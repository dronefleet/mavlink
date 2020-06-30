package io.dronefleet.mavlink.serialization.payload.reflection;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.serialization.MavlinkSerializationException;
import io.dronefleet.mavlink.serialization.payload.MavlinkPayloadSerializer;
import io.dronefleet.mavlink.util.EnumValue;
import io.dronefleet.mavlink.util.WireFieldInfoComparator;
import io.dronefleet.mavlink.util.reflection.MavlinkReflection;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ReflectionPayloadSerializer implements MavlinkPayloadSerializer {

    private static final WireFieldInfoComparator wireComparator = new WireFieldInfoComparator();

    @Override
    public byte[] serialize(Object message) {
        Class<?> messageClass = message.getClass();
        if (!messageClass.isAnnotationPresent(MavlinkMessageInfo.class)) {
            throw new IllegalArgumentException(messageClass.getName() + " is not annotated with @MavlinkMessageInfo");
        }

        int payloadLength = Arrays.stream(messageClass.getMethods())
                .filter(m -> m.isAnnotationPresent(MavlinkFieldInfo.class))
                .map(m -> m.getAnnotation(MavlinkFieldInfo.class))
                .mapToInt(f -> f.unitSize() * Math.max(1, f.arraySize()))
                .sum();
        if (payloadLength > 255) {
            throw new IllegalStateException("payload length > 255 for message" + messageClass.getName());
        }
        byte[] payload = new byte[payloadLength];

        AtomicInteger nextOffset = new AtomicInteger(0);

        Arrays.stream(messageClass.getMethods())
                .filter(m -> m.isAnnotationPresent(MavlinkFieldInfo.class))
                .sorted((a, b) -> {
                    MavlinkFieldInfo fa = a.getAnnotation(MavlinkFieldInfo.class);
                    MavlinkFieldInfo fb = b.getAnnotation(MavlinkFieldInfo.class);
                    return wireComparator.compare(fa, fb);
                })
                .forEach(m -> {
                    MavlinkFieldInfo field = m.getAnnotation(MavlinkFieldInfo.class);
                    int length = field.unitSize() * Math.max(field.arraySize(), 1);
                    int offset = nextOffset.getAndAccumulate(length, (a, b) -> a + b);
                    length += offset;
                    try {
                        Object fieldValue = m.invoke(message);
                        if (fieldValue != null) {
                            write(fieldValue, payload, offset, length, field.unitSize());
                        }
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new IllegalStateException(e);
                    }
                });

        return payload;
    }

    private void write(Object value, byte[] buffer, int offset, int length, int unitSize) {
        Class<?> type = value.getClass();
        if (Integer.class.isAssignableFrom(type)) {
            write((Integer) value, buffer, offset, length);
        } else if (Long.class.isAssignableFrom(type)) {
            write((Long) value, buffer, offset, length);
        } else if (BigInteger.class.isAssignableFrom(type)) {
            write((BigInteger) value, buffer, offset, length);
        } else if (Float.class.isAssignableFrom(type)) {
            write((Float) value, buffer, offset, length);
        } else if (Double.class.isAssignableFrom(type)) {
            write((Double) value, buffer, offset, length);
        } else if (Enum.class.isAssignableFrom(type)) {
            write((Enum) value, buffer, offset, length);
        } else if (EnumValue.class.isAssignableFrom(type)) {
            write((EnumValue<? extends Enum>) value, buffer, offset, length);
        } else if (String.class.isAssignableFrom(type)) {
            write((String) value, buffer, offset, length);
        } else if (byte[].class.isAssignableFrom(type)) {
            write((byte[]) value, buffer, offset, length);
        } else if (List.class.isAssignableFrom(type)) {
            write((List<?>) value, buffer, offset, length, unitSize);
        } else {
            throw new MavlinkSerializationException("unrecognized field type " + type.getName());
        }
    }

    private void write(long value, byte[] buffer, int offset, int length) {
        for (int i = offset, shift = 0; i < length; i++, shift++) {
            buffer[i] = (byte) ((value >> (shift * 8)) & 0xff);
        }
    }

    private void write(BigInteger bigInt, byte[] buffer, int offset, int length) {
        write(bigInt.longValue(), buffer, offset, length);
    }

    private void write(float value, byte[] buffer, int offset, int length) {
        if ((length - offset) != 4) throw new IllegalArgumentException("length != 4");
        ByteBuffer.wrap(buffer)
                .order(ByteOrder.LITTLE_ENDIAN)
                .putFloat(offset, value);
    }

    private void write(double value, byte[] buffer, int offset, int length) {
        if ((length - offset) != 8) throw new IllegalArgumentException("length != 8");
        ByteBuffer.wrap(buffer)
                .order(ByteOrder.LITTLE_ENDIAN)
                .putDouble(offset, value);
    }

    private void write(Enum value, byte[] buffer, int offset, int length) {
        MavlinkReflection.getEnumEntry(value)
                .map(MavlinkEntryInfo::value)
                .ifPresent(e -> write(e, buffer, offset, length));
    }

    private void write(EnumValue<? extends Enum> value, byte[] buffer, int offset, int length) {
        write(value.value(), buffer, offset, length);
    }

    private void write(String str, byte[] buffer, int offset, int length) {
        write(str.getBytes(StandardCharsets.UTF_8), buffer, offset, length);
    }

    private void write(byte[] bytes, byte[] buffer, int offset, int length) {
        System.arraycopy(bytes, 0, buffer, offset, Math.min(length - offset, bytes.length));
    }

    private void write(List<?> list, byte[] buffer, int offset, int length, int unitSize) {
        if (list.size() > (length / unitSize)) {
            throw new IllegalStateException("too many items in list");
        }
        for (Object value : list) {
            write(value, buffer, offset, offset + unitSize, 1);
            offset += unitSize;
        }
    }
}
