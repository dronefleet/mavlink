package io.dronefleet.mavlink.serialization;

import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;
import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.protocol.MavlinkPacket;
import io.dronefleet.mavlink.util.EnumFlagSet;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class ReflectionPacketDeserializer implements MavlinkPacketDeserializer {

    public static void main(String args[]) {
        double d = 123456;
        long l = Double.doubleToLongBits(d);
        double d2 = Double.longBitsToDouble(l);
        System.out.println(d2);
    }


    @Override
    public <T> T deserialize(MavlinkPacket packet, Class<T> messageType) {
        MavlinkMessage message = messageType.getAnnotation(MavlinkMessage.class);
        if (message == null) {
            throw new IllegalArgumentException(String.format(
                    "class %s is not annotated with @MavlinkMessage", messageType.getName()));
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
                    .filter(m -> m.isAnnotationPresent(MavlinkMessageField.class))
                    .sorted((a, b) -> {
                        MavlinkMessageField fa = a.getAnnotation(MavlinkMessageField.class);
                        MavlinkMessageField fb = b.getAnnotation(MavlinkMessageField.class);
                        return MavlinkMessageField.WIRE_COMPARATOR.compare(fa, fb);
                    })
                    .filter(f -> nextOffset.get() < packet.getPayload().length)
                    .forEach(method -> {
                        MavlinkMessageField field = method.getAnnotation(MavlinkMessageField.class);

                        int length = field.unitSize() * Math.max(field.arraySize(), 1);
                        int offset = nextOffset.getAndAccumulate(length, (a,b) -> a+b);

                        byte[] data = new byte[length];
                        System.arraycopy(packet.getPayload(), offset, data, 0, length);

                        Class fieldType = Optional.of(method.getParameterTypes())
                                .filter(types -> types.length == 1)
                                .map(types -> types[0])
                                .orElseThrow(() -> new MavlinkSerializationException(
                                        "Method " + method.getName() + " of " + builder.getClass().getName()
                                                + " is annotated with @MavlinkMessageField, however does not " +
                                                "accept a single parameter."));

                        try {
                            if (Enum.class.isAssignableFrom(fieldType)) {
                                method.invoke(builder, enumValue(fieldType, data));
                            } else if (EnumFlagSet.class.isAssignableFrom(fieldType)) {
                                method.invoke(builder, enumFlagSetValue((Class)((ParameterizedType)(method.getParameters()[0].getParameterizedType())).getActualTypeArguments()[0], data));
                            } else if (int.class.isAssignableFrom(fieldType)) {
                                method.invoke(builder, (int) integerValue(data));
                            } else if (long.class.isAssignableFrom(fieldType)) {
                                method.invoke(builder, integerValue(data));
                            } else if (float.class.isAssignableFrom(fieldType)) {
                                method.invoke(builder, floatValue(data));
                            } else if (double.class.isAssignableFrom(fieldType)) {
                                method.invoke(builder, doubleValue(data));
                            } else if (String.class.isAssignableFrom(fieldType)) {
                                method.invoke(builder, stringValue(data));
                            }
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    });

            //noinspection unchecked
            return (T)builder.getClass().getMethod("build").invoke(builder);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public long integerValue(byte[] data) {
        long value = 0;
        for (int i = 0; i < data.length; i++) {
            value = (value << 8) | (data[i] & 0xff);
        }
        return value;
    }

    public double doubleValue(byte[] data) {
        return ByteBuffer.wrap(data)
                .order(ByteOrder.LITTLE_ENDIAN)
                .getDouble();
    }

    public float floatValue(byte[] data) {
        return ByteBuffer.wrap(data)
                .order(ByteOrder.LITTLE_ENDIAN)
                .getFloat();
    }

    public String stringValue(byte[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 0) {
                return new String(data, 0, i, StandardCharsets.UTF_8);
            }
        }
        return new String(data, StandardCharsets.UTF_8);
    }

    public Object enumValue(Class enumType, byte[] data) {
        long value = integerValue(data);
        return Arrays.stream(enumType.getFields())
                .filter(Field::isEnumConstant)
                .filter(f -> f.isAnnotationPresent(MavlinkEnumEntry.class))
                .filter(f -> f.getAnnotation(MavlinkEnumEntry.class).value() == value)
                .map(f -> {
                    try {
                        return f.get(null);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "enum " + enumType.getSimpleName() + " does not have an entry with value " + value));
    }

    public EnumFlagSet enumFlagSetValue(Class enumType, byte[] data) {
        EnumFlagSet enumFlagSet = new EnumFlagSet();
        long bitmask = integerValue(data);

        Arrays.stream(enumType.getFields())
                .filter(Field::isEnumConstant)
                .filter(f -> f.isAnnotationPresent(MavlinkEnumEntry.class))
                .filter(f -> (f.getAnnotation(MavlinkEnumEntry.class).value() & bitmask) > 0)
                .map(f -> {
                    try {
                        return (Enum)f.get(null);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .forEach(enumFlagSet::enable);
        return enumFlagSet;
    }
}
