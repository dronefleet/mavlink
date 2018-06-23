package io.dronefleet.mavlink.protocol;

import io.dronefleet.mavlink.protocol.validation.CrcX25;

import java.util.Arrays;

public class MavlinkPacket {

    public static final int MAGIC_V1 = 0xFE;
    public static final int MAGIC_V2 = 0xFD;

    public static MavlinkPacket create(
            int sequence,
            int systemId,
            int componentId,
            int messageId,
            int crcExtra,
            byte[] payload) {
        byte[] rawBytes = new byte[8 + payload.length];
        ByteArray bytes = new ByteArray(rawBytes);
        bytes.putInt8(MAGIC_V1, 0);
        bytes.putInt8(payload.length, 1);
        bytes.putInt8(sequence, 2);
        bytes.putInt8(systemId, 3);
        bytes.putInt8(componentId, 4);
        bytes.putInt8(messageId, 5);
        System.arraycopy(payload, 0, rawBytes, 6, payload.length);

        CrcX25 crc = new CrcX25();
        crc.accumulate(rawBytes, 1, 6 + payload.length);
        crc.accumulate(crcExtra);
        bytes.putInt16(crc.checksum(), 6 + payload.length);

        return new MavlinkPacket(
                MAGIC_V1,
                -1,
                -1,
                sequence,
                systemId,
                componentId,
                messageId,
                -1,
                -1,
                payload,
                crc.checksum(),
                null,
                rawBytes);
    }

    public static MavlinkPacket fromV1Bytes(byte[] rawBytes) {
        ByteArray bytes = new ByteArray(rawBytes);
        int versionMarker = bytes.getInt8(0);
        int payloadLength = bytes.getInt8(1);
        int sequence = bytes.getInt8(2);
        int systemId = bytes.getInt8(3);
        int componentId = bytes.getInt8(4);
        int messageId = bytes.getInt8(5);
        byte[] payload = bytes.slice(6, payloadLength);
        int checksum = bytes.getInt16(6 + payloadLength);

        return new MavlinkPacket(
                versionMarker,
                -1,
                -1,
                sequence,
                systemId,
                componentId,
                messageId,
                -1,
                -1,
                payload,
                checksum,
                null,
                rawBytes);
    }

    public static MavlinkPacket fromV2Bytes(byte[] rawBytes) {
        ByteArray bytes = new ByteArray(rawBytes);
        int versionMarker = bytes.getInt8(0);
        int payloadLength = bytes.getInt8(1);
        int incompatibleFlags = bytes.getInt8(2);
        int compatibleFlags = bytes.getInt8(3);
        int sequence = bytes.getInt8(4);
        int systemId = bytes.getInt8(5);
        int componentId = bytes.getInt8(6);
        int messageId = bytes.getInt24(7);
        int targetSystemId = bytes.getInt8(10);
        int targetComponentId = bytes.getInt8(11);
        byte[] payload = bytes.slice(12, payloadLength);
        int checksum = bytes.getInt16(12 + payloadLength);
        byte[] signature = bytes.slice(14 + payloadLength, 13);

        return new MavlinkPacket(
                versionMarker,
                incompatibleFlags,
                compatibleFlags,
                sequence,
                systemId,
                componentId,
                messageId,
                targetSystemId,
                targetComponentId,
                payload,
                checksum,
                signature,
                rawBytes);
    }

    private final int versionMarker;
    private final int incompatibleFlags;
    private final int compatibleFlags;
    private final int sequence;
    private final int systemId;
    private final int componentId;
    private final int messageId;
    private final int targetSystemId;
    private final int targetComponentId;
    private final byte[] payload;
    private final int checksum;
    private final byte[] signature;
    private final byte[] rawBytes;

    private MavlinkPacket(
            int versionMarker,
            int incompatibleFlags,
            int compatibleFlags,
            int sequence,
            int systemId,
            int componentId,
            int messageId,
            int targetSystemId,
            int targetComponentId,
            byte[] payload,
            int checksum,
            byte[] signature, byte[] rawBytes) {
        this.versionMarker = versionMarker;
        this.incompatibleFlags = incompatibleFlags;
        this.compatibleFlags = compatibleFlags;
        this.sequence = sequence;
        this.systemId = systemId;
        this.componentId = componentId;
        this.messageId = messageId;
        this.targetSystemId = targetSystemId;
        this.targetComponentId = targetComponentId;
        this.payload = payload;
        this.checksum = checksum;
        this.signature = signature;
        this.rawBytes = rawBytes;
    }

    public int getVersionMarker() {
        return versionMarker;
    }

    public int getIncompatibleFlags() {
        return incompatibleFlags;
    }

    public int getCompatibleFlags() {
        return compatibleFlags;
    }

    public int getSequence() {
        return sequence;
    }

    public int getSystemId() {
        return systemId;
    }

    public int getComponentId() {
        return componentId;
    }

    public int getMessageId() {
        return messageId;
    }

    public int getTargetSystemId() {
        return targetSystemId;
    }

    public int getTargetComponentId() {
        return targetComponentId;
    }

    public byte[] getPayload() {
        return payload;
    }

    public int getChecksum() {
        return checksum;
    }

    public byte[] getSignature() {
        return signature;
    }

    public byte[] getRawBytes() {
        return rawBytes;
    }

    public boolean validate(int crcExtra) {
        CrcX25 crcX25 = new CrcX25();
        switch (versionMarker) {
            case MAGIC_V1:
                crcX25.accumulate(getRawBytes(), 1, 6 + payload.length);
                break;

            case MAGIC_V2:
                crcX25.accumulate(getRawBytes(), 1, 12 + payload.length);
                break;

            default:
                throw new IllegalStateException(
                        "Unknown version marker: 0x" + Integer.toHexString(versionMarker));
        }
        crcX25.accumulate(crcExtra);
        return crcX25.checksum() == checksum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MavlinkPacket that = (MavlinkPacket) o;

        if (versionMarker != that.versionMarker) return false;
        if (incompatibleFlags != that.incompatibleFlags) return false;
        if (compatibleFlags != that.compatibleFlags) return false;
        if (sequence != that.sequence) return false;
        if (systemId != that.systemId) return false;
        if (componentId != that.componentId) return false;
        if (messageId != that.messageId) return false;
        if (targetSystemId != that.targetSystemId) return false;
        if (targetComponentId != that.targetComponentId) return false;
        if (checksum != that.checksum) return false;
        if (!Arrays.equals(payload, that.payload)) return false;
        if (!Arrays.equals(signature, that.signature)) return false;
        return Arrays.equals(rawBytes, that.rawBytes);
    }

    @Override
    public int hashCode() {
        int result = versionMarker;
        result = 31 * result + incompatibleFlags;
        result = 31 * result + compatibleFlags;
        result = 31 * result + sequence;
        result = 31 * result + systemId;
        result = 31 * result + componentId;
        result = 31 * result + messageId;
        result = 31 * result + targetSystemId;
        result = 31 * result + targetComponentId;
        result = 31 * result + Arrays.hashCode(payload);
        result = 31 * result + checksum;
        result = 31 * result + Arrays.hashCode(signature);
        result = 31 * result + Arrays.hashCode(rawBytes);
        return result;
    }

    @Override
    public String toString() {
        return "MavlinkPacket{" +
                "versionMarker=" + versionMarker +
                ", incompatibleFlags=" + incompatibleFlags +
                ", compatibleFlags=" + compatibleFlags +
                ", sequence=" + sequence +
                ", systemId=" + systemId +
                ", componentId=" + componentId +
                ", messageId=" + messageId +
                ", targetSystemId=" + targetSystemId +
                ", targetComponentId=" + targetComponentId +
                ", payload=" + Arrays.toString(payload) +
                ", checksum=" + checksum +
                ", signature=" + Arrays.toString(signature) +
                '}';
    }
}
