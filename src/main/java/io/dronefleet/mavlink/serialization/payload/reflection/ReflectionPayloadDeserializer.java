package io.dronefleet.mavlink.serialization.payload.reflection;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.serialization.payload.MavlinkPayloadDeserializer;
import io.dronefleet.mavlink.serialization.MavlinkSerializationException;
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

public class ReflectionPayloadDeserializer implements MavlinkPayloadDeserializer {

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
                        return MavlinkFieldInfo.WIRE_COMPARATOR.compare(fa, fb);
                    })
                    .filter(f -> nextOffset.get() < payload.length)
                    .forEach(method -> {
                        MavlinkFieldInfo field = method.getAnnotation(MavlinkFieldInfo.class);

                        int length = field.unitSize() * Math.max(field.arraySize(), 1);
                        int offset = nextOffset.getAndAccumulate(length, (a, b) -> a + b);

                        byte[] data = new byte[length];
                        System.arraycopy(payload, offset, data, 0, length);

                        Class fieldType = Optional.of(method.getParameterTypes())
                                .filter(types -> types.length == 1)
                                .map(types -> types[0])
                                .orElseThrow(() -> new MavlinkSerializationException(
                                        "Method " + method.getName() + " of " + builder.getClass().getName()
                                                + " is annotated with @MavlinkFieldInfo, however does not " +
                                                "accept a single parameter."));

                        try {
                            if (Enum.class.isAssignableFrom(fieldType)) {
                                method.invoke(builder, enumValue(fieldType, data, field.signed()));
                            } else if (EnumFlagSet.class.isAssignableFrom(fieldType)) {
                                method.invoke(builder, enumFlagSetValue((Class) ((ParameterizedType) (method.getParameters()[0].getParameterizedType())).getActualTypeArguments()[0], data));
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
            value = value | ((data[i] & 0xff) << (i * 8));
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

    private Object enumValue(Class enumType, byte[] data, boolean signed) {
        long value = integerValue(data, signed);
        return Arrays.stream(enumType.getFields())
                .filter(Field::isEnumConstant)
                .filter(f -> f.isAnnotationPresent(MavlinkEntryInfo.class))
                .filter(f -> f.getAnnotation(MavlinkEntryInfo.class).value() == value)
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

    private EnumFlagSet enumFlagSetValue(Class enumType, byte[] data) {
        EnumFlagSet enumFlagSet = new EnumFlagSet();
        long bitmask = integerValue(data, false);

        Arrays.stream(enumType.getFields())
                .filter(Field::isEnumConstant)
                .filter(f -> f.isAnnotationPresent(MavlinkEntryInfo.class))
                .filter(f -> (f.getAnnotation(MavlinkEntryInfo.class).value() & bitmask) > 0)
                .map(f -> {
                    try {
                        return (Enum) f.get(null);
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
