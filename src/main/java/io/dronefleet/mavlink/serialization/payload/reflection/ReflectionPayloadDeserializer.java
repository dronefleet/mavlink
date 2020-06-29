package io.dronefleet.mavlink.serialization.payload.reflection;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.serialization.MavlinkSerializationException;
import io.dronefleet.mavlink.serialization.payload.MavlinkPayloadDeserializer;
import io.dronefleet.mavlink.util.EnumValue;
import io.dronefleet.mavlink.util.WireFieldInfoComparator;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class ReflectionPayloadDeserializer implements MavlinkPayloadDeserializer {

    private static final WireFieldInfoComparator wireComparator = new WireFieldInfoComparator();

    @Override
    public <T> T deserialize(byte[] payload, Class<T> messageType) {
        MavlinkMessageInfo message = messageType.getAnnotation(MavlinkMessageInfo.class);
        if (message == null) {
            throw new IllegalArgumentException(String.format(
                    "class %s is not annotated with @MavlinkMessageInfo", messageType.getName()));
        }

        try {
            Object builder = Arrays.stream(messageType.getMethods())
                    .filter(m -> m.isAnnotationPresent(MavlinkMessageBuilder.class))
                    .findFirst()
                    .orElseThrow(() -> new MavlinkSerializationException(
                            "Message " + messageType.getName() + " does not have a builder"))
                    .invoke(null);

            AtomicInteger nextOffset = new AtomicInteger();
            Arrays.stream(builder.getClass().getMethods())
                    .filter(m -> m.isAnnotationPresent(MavlinkFieldInfo.class))
                    .sorted((a, b) -> {
                        MavlinkFieldInfo fa = a.getAnnotation(MavlinkFieldInfo.class);
                        MavlinkFieldInfo fb = b.getAnnotation(MavlinkFieldInfo.class);
                        return wireComparator.compare(fa, fb);
                    })
                    .forEach(method -> {
                        MavlinkFieldInfo field = method.getAnnotation(MavlinkFieldInfo.class);

                        int length = field.unitSize() * Math.max(field.arraySize(), 1);
                        int offset = nextOffset.getAndAccumulate(length, (a, b) -> a + b);

                        byte[] data = new byte[length];
                        if (offset < payload.length) {
                            int copyLength = Math.max(
                                    Math.min(length, payload.length - offset),
                                    0
                            );
                            System.arraycopy(payload, offset, data, 0, copyLength);
                        }

                        Class fieldType = Optional.of(method.getParameterTypes())
                                .filter(types -> types.length == 1)
                                .map(types -> types[0])
                                .orElseThrow(() -> new MavlinkSerializationException(
                                        "Method " + method.getName() + " of " + builder.getClass().getName()
                                                + " is annotated with @MavlinkFieldInfo, however does not " +
                                                "accept a single parameter."));

                        try {
                            if (EnumValue.class.isAssignableFrom(fieldType)) {
                                method.invoke(builder, enumValue(field.enumType(), data, field.signed()));
                            } else if (int.class.isAssignableFrom(fieldType)) {
                                method.invoke(builder, (int) integerValue(data, field.signed()));
                            } else if (long.class.isAssignableFrom(fieldType)) {
                                method.invoke(builder, integerValue(data, field.signed()));
                            } else if (float.class.isAssignableFrom(fieldType)) {
                                method.invoke(builder, floatValue(data));
                            } else if (double.class.isAssignableFrom(fieldType)) {
                                method.invoke(builder, doubleValue(data));
                            } else if (String.class.isAssignableFrom(fieldType)) {
                                method.invoke(builder, stringValue(data));
                            } else if (byte[].class.isAssignableFrom(fieldType)) {
                                method.invoke(builder, (Object) data);
                            } else if (short[].class.isAssignableFrom(fieldType)) {
                                method.invoke(builder, (Object) shortArrayValue(data));
                            } else if (int[].class.isAssignableFrom(fieldType)) {
                                method.invoke(builder, (Object) intArrayValue(data));
                            } else if (long[].class.isAssignableFrom(fieldType)) {
                                method.invoke(builder, (Object) longArrayValue(data));
                            } else if (BigInteger.class.isAssignableFrom(fieldType)) {
                                method.invoke(builder, bigIntValue(data));
                            }
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    });

            //noinspection unchecked
            return (T) builder.getClass().getMethod("build").invoke(builder);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    private long unsignedIntegerValue(byte[] data) {
        long value = 0;
        for (int i = 0; i < data.length; i++) {
            value = value | ((long) ((data[i] & 0xff)) << (i * 8));
        }
        return value;
    }

    private long signedIntegerValue(byte[] data) {
        long value = unsignedIntegerValue(data);
        int signBitIndex = data.length * Byte.SIZE - 1;
        if ((value >> signBitIndex) == 1) {
            value |= (-1L << signBitIndex);
        }
        return value;
    }

    private long integerValue(byte[] data, boolean signed) {
        if (signed) {
            return signedIntegerValue(data);
        } else {
            return unsignedIntegerValue(data);
        }
    }

    private double doubleValue(byte[] data) {
        return ByteBuffer.wrap(data)
                .order(ByteOrder.LITTLE_ENDIAN)
                .getDouble();
    }

    private float floatValue(byte[] data) {
        return ByteBuffer.wrap(data)
                .order(ByteOrder.LITTLE_ENDIAN)
                .getFloat();
    }

    private String stringValue(byte[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 0) {
                return new String(data, 0, i, StandardCharsets.UTF_8);
            }
        }
        return new String(data, StandardCharsets.UTF_8);
    }


    private BigInteger bigIntValue(byte[] data){
        // Invert to big-endian, for BigInteger constructor
        for (int i = 0; i < data.length/2; ++i){
            byte tmp = data[i];
            data[i] = data[data.length-1-i];
            data[data.length-1-i] = tmp;
        }

        return new BigInteger(data);
    }

    private Object enumValue(Class<?> enumType, byte[] data, boolean signed) {
        return EnumValue.create(
                (Class<? extends Enum>) enumType,
                (int) integerValue(data, signed));
    }

    private short[] shortArrayValue(byte[] data){
        short[] result = new short[data.length/2];
        ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(result);

        return result;
    }

    private int[] intArrayValue(byte[] data){
        int[] result = new int[data.length/4];
        ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().get(result);

        return result;
    }


    private long[] longArrayValue(byte[] data){
        long[] result = new long[data.length/8];
        ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).asLongBuffer().get(result);

        return result;
    }


}
