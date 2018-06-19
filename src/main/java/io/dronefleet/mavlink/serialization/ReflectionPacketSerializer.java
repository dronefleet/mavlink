package io.dronefleet.mavlink.serialization;

import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;
import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.common.*;
import io.dronefleet.mavlink.protocol.MavlinkPacket;
import io.dronefleet.mavlink.util.EnumFlagSet;
import io.dronefleet.mavlink.util.MavlinkReflection;
import io.dronefleet.mavlink.validation.CrcX25;

import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ReflectionPacketSerializer implements MavlinkPacketSerializer {

    public static void main(String args[]) {
        ReflectionPacketSerializer serializer = new ReflectionPacketSerializer();
        ReflectionPacketDeserializer deserializer = new ReflectionPacketDeserializer();

        CommandLong expected = CommandLong.builder()
                .command(MavCmd.MAV_CMD_COMPONENT_ARM_DISARM)
                .param1(1)
                .build();

        byte[] bytes = serializer.serialize(
                expected,
                100,
                0,
                0);

        System.out.println(bytes.length + " bytes: " + Arrays.toString(bytes));

        MavlinkPacket packet = MavlinkPacket.fromV1Bytes(bytes);

        CommandLong actual = deserializer.deserialize(packet, CommandLong.class);

        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    @Override
    public byte[] serialize(Object message, int sequence, int targetSystemId, int targetComponentId) {
        if (sequence > 255) {
            throw new IllegalArgumentException("sequence > 255");
        }
        if (sequence < 0) {
            throw new IllegalArgumentException("sequence < 0");
        }
        Class<?> messageClass = message.getClass();
        if (!messageClass.isAnnotationPresent(MavlinkMessage.class)) {
            throw new IllegalArgumentException(messageClass.getName() + " is not annotated with @MavlinkMessage");
        }

        MavlinkMessage messageMeta = messageClass.getAnnotation(MavlinkMessage.class);
        int messageId = messageMeta.id();

        int payloadLength = Arrays.stream(messageClass.getMethods())
                .filter(m -> m.isAnnotationPresent(MavlinkMessageField.class))
                .map(m -> m.getAnnotation(MavlinkMessageField.class))
                .mapToInt(f -> f.unitSize() * Math.max(1, f.arraySize()))
                .sum();
        if (payloadLength > 253) {
            throw new IllegalStateException("payload length > 253 for message" + messageClass.getName());
        }
        byte[] packet = new byte[27 + payloadLength];

        // write packet header
        write(MavlinkPacket.MAGIC_V1, packet, 0, 1);
        write(payloadLength, packet, 1, 2);
        write(sequence, packet, 2, 3);
        write(255, packet, 3, 4);
        write(1, packet, 4, 5);
        write(messageId, packet, 5, 6);

        AtomicInteger nextOffset = new AtomicInteger(6);

        Arrays.stream(messageClass.getMethods())
                .filter(m -> m.isAnnotationPresent(MavlinkMessageField.class))
                .sorted((a, b) -> {
                    MavlinkMessageField fa = a.getAnnotation(MavlinkMessageField.class);
                    MavlinkMessageField fb = b.getAnnotation(MavlinkMessageField.class);
                    return MavlinkMessageField.WIRE_COMPARATOR.compare(fa, fb);
                })
                .forEach(m -> {
                    MavlinkMessageField field = m.getAnnotation(MavlinkMessageField.class);
                    int length = field.unitSize() * Math.max(field.arraySize(), 1);
                    int offset = nextOffset.getAndAccumulate(length, (a,b) -> a+b);
                    length += offset;
                    try {
                        Object fieldValue = m.invoke(message);
                        if (fieldValue != null) {
                            Class<?> fieldType = fieldValue.getClass();
                            if (Integer.class.isAssignableFrom(fieldType)) {
                                write((Integer) fieldValue, packet, offset, length);
                            } else if (Long.class.isAssignableFrom(fieldType)) {
                                write((Long) fieldValue, packet, offset, length);
                            } else if (Float.class.isAssignableFrom(fieldType)) {
                                write((Float) fieldValue, packet, offset, length);
                            } else if (Double.class.isAssignableFrom(fieldType)) {
                                write((Double) fieldValue, packet, offset, length);
                            } else if (Enum.class.isAssignableFrom(fieldType)) {
                                write((Enum) fieldValue, packet, offset, length);
                            } else if (EnumFlagSet.class.isAssignableFrom(fieldType)) {
                                write((EnumFlagSet<? extends Enum>) fieldValue, packet, offset, length);
                            } else {
                                throw new MavlinkSerializationException("unrecognized field type " + fieldType.getName());
                            }
                        }
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new IllegalStateException(e);
                    }
                });

        CrcX25 crcX25 = new CrcX25();
        crcX25.accumulate(packet, 1, 6 + payloadLength);
        crcX25.accumulate(messageMeta.crc());

        write(crcX25.checksum(), packet, 6 + payloadLength, 6 + payloadLength + 2);

        return packet;
    }

    private void write(long value, byte[] buffer, int offset, int length) {
        for (int i = offset; i < length; i++) {
            buffer[i] = (byte) ((value >> ((length - 1 - i) * 8)) & 0xff);
        }
    }

    private void write(float value, byte[] buffer, int offset, int length) {
        if ((length-offset) != 4) throw new IllegalArgumentException("length != 4");
        ByteBuffer.wrap(buffer)
                .order(ByteOrder.LITTLE_ENDIAN)
                .putFloat(offset, value);
    }

    private void write(double value, byte[] buffer, int offset, int length) {
        if ((length-offset) != 8) throw new IllegalArgumentException("length != 8");
        ByteBuffer.wrap(buffer)
                .order(ByteOrder.LITTLE_ENDIAN)
                .putDouble(offset, value);
    }

    private void write(Enum value, byte[] buffer, int offset, int length) {
        MavlinkReflection.getEnumEntry(value)
                .map(MavlinkEnumEntry::value)
                .ifPresent(e -> write(e, buffer, offset, length));
    }

    private void write(EnumFlagSet<? extends Enum> value, byte[] buffer, int offset, int length) {
        AtomicInteger flags = new AtomicInteger(0);
        value.getEnabled().stream()
                .map(MavlinkReflection::getEnumEntry)
                .map(o -> o.orElseThrow(() -> new MavlinkSerializationException("unrecognized enum fields")))
                .filter(Objects::nonNull)
                .map(MavlinkEnumEntry::value)
                .forEach(flag -> {
                    flags.getAndAccumulate(flag, (a, b) -> a | b);
                });
        write(flags.get(), buffer, offset, length);
    }
}
