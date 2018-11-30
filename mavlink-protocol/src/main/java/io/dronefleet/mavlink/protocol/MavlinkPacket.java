package io.dronefleet.mavlink.protocol;

import io.dronefleet.mavlink.protocol.util.CrcX25;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MavlinkPacket {

    public static final int MAGIC_V1 = 0xFE;
    public static final int MAGIC_V2 = 0xFD;
    public static final int INCOMPAT_FLAG_SIGNED = 0x01;

    public static MavlinkPacket createSignedMavlink2Packet(
            int sequence, int systemId, int componentId, int messageId,
            int crcExtra, byte[] payload, int linkId, long timestamp, byte[] secretKey) {
        byte[] rawBytes = new byte[25 + payload.length];
        ByteArray bytes = new ByteArray(rawBytes);
        bytes.putInt8(MAGIC_V2, 0);
        bytes.putInt8(payload.length, 1);
        bytes.putInt8(INCOMPAT_FLAG_SIGNED, 2);
        bytes.putInt8(0, 3);
        bytes.putInt8(sequence, 4);
        bytes.putInt8(systemId, 5);
        bytes.putInt8(componentId, 6);
        bytes.putInt24(messageId, 7);
        System.arraycopy(payload, 0, rawBytes, 10, payload.length);
        int crc = generateCrc(rawBytes, crcExtra);
        bytes.putInt16(crc, 10 + payload.length);
        byte[] signature = generateSignature(rawBytes, linkId, timestamp, secretKey);
        System.arraycopy(signature, 0, rawBytes, rawBytes.length - signature.length, signature.length);
        return new MavlinkPacket(MAGIC_V2, INCOMPAT_FLAG_SIGNED, 0, sequence, systemId,
                componentId, messageId, payload, crc, signature, rawBytes);
    }

    public static MavlinkPacket createUnsignedMavlink2Packet(
            int sequence, int systemId, int componentId, int messageId,
            int crcExtra, byte[] payload) {
        byte[] rawBytes = new byte[12 + payload.length];
        ByteArray bytes = new ByteArray(rawBytes);
        bytes.putInt8(MAGIC_V2, 0);
        bytes.putInt8(payload.length, 1);
        bytes.putInt8(0, 2);
        bytes.putInt8(0, 3);
        bytes.putInt8(sequence, 4);
        bytes.putInt8(systemId, 5);
        bytes.putInt8(componentId, 6);
        bytes.putInt24(messageId, 7);
        System.arraycopy(payload, 0, rawBytes, 10, payload.length);
        int crc = generateCrc(rawBytes, crcExtra);
        bytes.putInt16(crc, 10 + payload.length);
        return new MavlinkPacket(MAGIC_V2, 0, 0, sequence, systemId, componentId, messageId,
                payload, crc, new byte[0], rawBytes);
    }

    public static MavlinkPacket createMavlink1Packet(
            int sequence, int systemId, int componentId, int messageId,
            int crcExtra, byte[] payload) {
        byte[] rawBytes = new byte[8 + payload.length];
        ByteArray bytes = new ByteArray(rawBytes);
        bytes.putInt8(MAGIC_V1, 0);
        bytes.putInt8(payload.length, 1);
        bytes.putInt8(sequence, 2);
        bytes.putInt8(systemId, 3);
        bytes.putInt8(componentId, 4);
        bytes.putInt8(messageId, 5);
        System.arraycopy(payload, 0, rawBytes, 6, payload.length);
        int crc = generateCrc(rawBytes, crcExtra);
        bytes.putInt16(crc, 6 + payload.length);
        return new MavlinkPacket(MAGIC_V1, -1, -1, sequence, systemId, componentId, messageId,
                payload, crc, new byte[0], rawBytes);
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
        return new MavlinkPacket(versionMarker, -1, -1, sequence, systemId, componentId,
                messageId, payload, checksum, new byte[0], rawBytes);
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
        byte[] payload = bytes.slice(10, payloadLength);
        int checksum = bytes.getInt16(10 + payloadLength);
        byte[] signature;
        if ((incompatibleFlags & INCOMPAT_FLAG_SIGNED) != 0) {
            signature = bytes.slice(12 + payloadLength, 13);
        } else {
            signature = new byte[0];
        }
        return new MavlinkPacket(versionMarker, incompatibleFlags, compatibleFlags, sequence,
                systemId, componentId, messageId, payload, checksum, signature, rawBytes);
    }

    public static int generateCrc(byte[] packetBytes, int crcExtra) {
        if (packetBytes.length < 3) {
            return -1;
        }
        int payloadLength = packetBytes[1] & 0xFF;
        int packetLengthWithoutCrc;
        switch (packetBytes[0] & 0xFF) {
            case MAGIC_V1:
                packetLengthWithoutCrc = 6;
                break;
            case MAGIC_V2:
                packetLengthWithoutCrc = 10;
                break;
            default: throw new IllegalStateException("not a mavlink packet");
        }
        packetLengthWithoutCrc += payloadLength;
        CrcX25 crc = new CrcX25();
        crc.accumulate(packetBytes, 1, packetLengthWithoutCrc);
        crc.accumulate(crcExtra);
        return crc.get();
    }

    public static byte[] generateSignature(
            byte[] packetBytes, int linkId, long timestamp, byte[] secretKey) {
        if (packetBytes.length < 3
                || (packetBytes[0] & MavlinkPacket.MAGIC_V2) != MavlinkPacket.MAGIC_V2
                || (packetBytes[2] & MavlinkPacket.INCOMPAT_FLAG_SIGNED) == 0) {
            return new byte[0];
        }
        int payloadLength = packetBytes[1] & 0xFF;
        int packetLengthWithCrc = 12 + payloadLength;
        if (packetBytes.length < packetLengthWithCrc) {
            throw new IllegalArgumentException("specified packet seems to be incomplete");
        }
        byte[] signature = new byte[13];
        ByteArray bytes = new ByteArray(signature);
        bytes.putInt8(linkId, 0);
        bytes.putInt48(timestamp, 1);
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(secretKey);
            digest.update(packetBytes, 0, packetLengthWithCrc);
            digest.update(signature, 0, 7);
            byte[] hash = digest.digest();
            System.arraycopy(hash, 0, signature, 7, 6);
            return signature;
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("JVM does not have an implementation of SHA-256 available.");
        }
    }

    private final int versionMarker;
    private final int incompatibleFlags;
    private final int compatibleFlags;
    private final int sequence;
    private final int systemId;
    private final int componentId;
    private final int messageId;
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
            byte[] payload,
            int checksum,
            byte[] signature,
            byte[] rawBytes) {
        this.versionMarker = versionMarker;
        this.incompatibleFlags = incompatibleFlags;
        this.compatibleFlags = compatibleFlags;
        this.sequence = sequence;
        this.systemId = systemId;
        this.componentId = componentId;
        this.messageId = messageId;
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

    public boolean validateCrc(int crcExtra) {
        return generateCrc(rawBytes, crcExtra) == checksum;
    }

    public boolean isSigned() {
        return ((incompatibleFlags & INCOMPAT_FLAG_SIGNED) != 0);
    }

    public boolean validateSignature(int linkId, long timestamp, byte[] secretKey) {
        return isSigned() && Arrays.equals(
                signature,
                generateSignature(this.rawBytes, linkId, timestamp, secretKey));
    }

    public int getSignedLinkId() {
        return isSigned() ? (signature[0] & 0xFF) : -1;
    }

    public long getSignedTimestamp() {
        ByteArray bytes = new ByteArray(signature);
        return isSigned() ? bytes.getInt48(1) : -1;
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
                ", payload=" + Arrays.toString(payload) +
                ", checksum=" + checksum +
                ", signature=" + Arrays.toString(signature) +
                '}';
    }
}
