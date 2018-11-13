package io.dronefleet.mavlink.protocol;

import io.dronefleet.mavlink.protocol.validation.CrcX25;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MavlinkPacket {

    public static final int MAGIC_V1 = 0xFE;
    public static final int MAGIC_V2 = 0xFD;

    public static final int INCOMPAT_FLAG_SIGNED = 0x01;

    public static MavlinkPacket create(
            int incompatibleFlags,
            int compatibleFlags,
            int sequence,
            int systemId,
            int componentId,
            int messageId,
            int crcExtra,
            byte[] payload) {
        return create(
                incompatibleFlags,
                compatibleFlags,
                sequence,
                systemId,
                componentId,
                messageId,
                crcExtra,
                payload,
                null);
    }

    public static MavlinkPacket create(
            int incompatibleFlags,
            int compatibleFlags,
            int sequence,
            int systemId,
            int componentId,
            int messageId,
            int crcExtra,
            byte[] payload,
            byte[] signature) {
        if (signature == null) {
            signature = new byte[0];
        } else if (signature.length != 13) {
            throw new IllegalArgumentException("signature must be 13 bytes in length");
        }

        byte[] rawBytes = new byte[12 + payload.length  + signature.length];
        ByteArray bytes = new ByteArray(rawBytes);
        bytes.putInt8(MAGIC_V2, 0);
        bytes.putInt8(payload.length, 1);
        bytes.putInt8(incompatibleFlags, 2);
        bytes.putInt8(compatibleFlags, 3);
        bytes.putInt8(sequence, 4);
        bytes.putInt8(systemId, 5);
        bytes.putInt8(componentId, 6);
        bytes.putInt24(messageId, 7);
        System.arraycopy(payload, 0, rawBytes, 10, payload.length);
        System.arraycopy(signature, 0, rawBytes, 12 + payload.length, signature.length);

        CrcX25 crc = new CrcX25();
        crc.accumulate(rawBytes, 1, 10);
        crc.accumulate(payload);
        crc.accumulate(crcExtra);
        bytes.putInt16(crc.get(), 10 + payload.length);

        return new MavlinkPacket(
                MAGIC_V2,
                incompatibleFlags,
                compatibleFlags,
                sequence,
                systemId,
                componentId,
                messageId,
                payload,
                crc.get(),
                signature,
                rawBytes);
    }

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
        bytes.putInt16(crc.get(), 6 + payload.length);

        return new MavlinkPacket(
                MAGIC_V1,
                -1,
                -1,
                sequence,
                systemId,
                componentId,
                messageId,
                payload,
                crc.get(),
                new byte[0],
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
                payload,
                checksum,
                new byte[0],
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
        byte[] payload = bytes.slice(10, payloadLength);
        int checksum = bytes.getInt16(10 + payloadLength);
        byte[] signature;
        if ((incompatibleFlags & INCOMPAT_FLAG_SIGNED) != 0) {
            signature = bytes.slice(12 + payloadLength, 13);
        } else {
            signature = new byte[0];
        }
        return new MavlinkPacket(
                versionMarker,
                incompatibleFlags,
                compatibleFlags,
                sequence,
                systemId,
                componentId,
                messageId,
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
        CrcX25 crcX25 = new CrcX25();
        switch (versionMarker) {
            case MAGIC_V1:
                crcX25.accumulate(getRawBytes(), 1, 6 + payload.length);
                break;
            case MAGIC_V2:
                crcX25.accumulate(getRawBytes(), 1, 10 + payload.length);
                break;
            default:
                throw new IllegalStateException(
                        "Unknown version marker: 0x" + Integer.toHexString(versionMarker));
        }
        crcX25.accumulate(crcExtra);
        return crcX25.get() == checksum;
    }

    public MavlinkPacket sign(int linkId, long timestamp, byte[] secretKey) {
        byte[] signature = generateSignature(linkId, timestamp, secretKey);
        byte[] rawBytes;
        if (this.signature.length == 0) {
            rawBytes = new byte[this.rawBytes.length + signature.length];
            System.arraycopy(this.rawBytes, 0, rawBytes, 0, this.rawBytes.length);
            System.arraycopy(signature, 0, rawBytes, this.rawBytes.length, signature.length);
        } else {
            rawBytes = new byte[this.rawBytes.length];
            System.arraycopy(this.rawBytes, 0, rawBytes, 0, this.rawBytes.length - signature.length);
            System.arraycopy(signature, 0, rawBytes, this.rawBytes.length - signature.length, signature.length);
        }

        return new MavlinkPacket(
                versionMarker,
                incompatibleFlags | INCOMPAT_FLAG_SIGNED,
                compatibleFlags,
                sequence,
                systemId,
                componentId,
                messageId,
                payload,
                checksum,
                signature,
                rawBytes);
    }

    public boolean isSigned() {
        return ((incompatibleFlags & INCOMPAT_FLAG_SIGNED) != 0);
    }

    public boolean validateSignature(int linkId, long timestamp, byte[] secretKey) {
        if (versionMarker == MAGIC_V1) {
            throw new IllegalStateException("mavlink1 packets do not support signatures");
        }
        return isSigned() && Arrays.equals(
                signature,
                generateSignature(linkId, timestamp, secretKey));
    }

    public int getSignedLinkId() {
        return isSigned() ? (signature[0] & 0xFF) : -1;
    }

    public long getSignedTimestamp() {
        ByteArray bytes = new ByteArray(signature);
        return isSigned() ? bytes.getInt48(1) : -1;
    }

    private byte[] generateSignature(int linkId, long timestamp, byte[] secretKey) {
        byte[] signature = new byte[13];
        ByteArray bytes = new ByteArray(signature);
        bytes.putInt8(linkId, 0);
        bytes.putInt48(timestamp, 1);
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(secretKey);
            digest.update(rawBytes, 1, 9);
            digest.update(payload);
            digest.update(rawBytes, 10 + payload.length, 2);
            digest.update(signature, 0, 7);
            System.arraycopy(digest.digest(), 0, signature, 7, 6);
            return signature;
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("JVM does not have an implementation of SHA-256 available.");
        }
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
