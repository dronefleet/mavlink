package io.dronefleet.mavlink.protocol;

import io.dronefleet.mavlink.protocol.util.CrcX25;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * <p>
 * Facilitates a Mavlink protocol packet. This class includes functionality for
 * serializing, deserializing, signing and CRC validation of Mavlink protocol packets.
 */
public class MavlinkPacket {

    static final int MAGIC_V1 = 0xFE;
    static final int MAGIC_V2 = 0xFD;
    private static final int INCOMPAT_FLAG_SIGNED = 0x01;

    /**
     * Creates a signed Mavlink 2 packet.
     *
     * @param sequence    The sequence of the packet to create.
     * @param systemId    The system ID of the originator of this packet.
     * @param componentId The component ID of the originator of this packet.
     * @param messageId   The message ID of this packet
     * @param crcExtra    The CRC extra corresponding to the message ID of this packet.
     * @param payload     The payload of this packet.
     * @param linkId      The link ID to use in the packet's signature.
     * @param timestamp   The timestamp to use in the packet's signature.
     * @param secretKey   The secret key to use in order to generate this packet's signature.
     * @return A signed Mavlink 2 packet of the specified settings.
     */
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

    /**
     * Creates an unsigned Mavlink 2 packet.
     *
     * @param sequence    The sequence of the packet to create.
     * @param systemId    The system ID of the originator of this packet.
     * @param componentId The component ID of the originator of this packet.
     * @param messageId   The message ID of this packet
     * @param crcExtra    The CRC extra corresponding to the message ID of this packet.
     * @param payload     The payload of this packet.
     * @return An unsigned Mavlink 2 packet of the specified settings.
     */
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

    /**
     * Creates a Mavlink 1 packet.
     *
     * @param sequence    The sequence of the packet to create.
     * @param systemId    The system ID of the originator of this packet.
     * @param componentId The component ID of the originator of this packet.
     * @param messageId   The message ID of this packet
     * @param crcExtra    The CRC extra corresponding to the message ID of this packet.
     * @param payload     The payload of this packet.
     * @return A Mavlink 1 packet of the specified settings.
     */
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

    /**
     * Parses a Mavlink 1 packet.
     *
     * @param rawBytes A Mavlink 1 packet frame to parse the packet from.
     * @return The parsed Mavlink 1 packet.
     */
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

    /**
     * Parses a Mavlink 2 packet.
     *
     * @param rawBytes A Mavlink 2 frame to parse the packet from.
     * @return The parsed Mavlink 2 packet.
     */
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

    /**
     * Generates a CRC.
     *
     * @param packetBytes The packet bytes to generate a CRC for. This method
     *                    will only consume bytes up to the expected position
     *                    of the CRC, so it is safe to pass frames that are longer
     *                    than the CRC position in a frame. The packet bytes are
     *                    expected to include the version marker (or STX).
     * @param crcExtra    The CRC extra of the message of this packet.
     * @return The generated CRC checksum.
     */
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
            default:
                throw new IllegalStateException("not a mavlink packet");
        }
        packetLengthWithoutCrc += payloadLength;
        CrcX25 crc = new CrcX25();
        crc.accumulate(packetBytes, 1, packetLengthWithoutCrc);
        crc.accumulate(crcExtra);
        return crc.get();
    }

    /**
     * Generates a Mavlink 2 signature.
     *
     * @param packetBytes The bytes of the packet to generate the signature for.
     * @param linkId      The signature's link ID.
     * @param timestamp   The signature's timestamp.
     * @param secretKey   The secret key to use in order to generate the signature's hash.
     * @return The generated signature.
     */
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

    /**
     * Returns this packet's version marker (STX). The result is 0xFE for a version 1 packet,
     * or 0xFD for a version 2 packet.
     */
    public int getVersionMarker() {
        return versionMarker;
    }

    /**
     * Returns this packet's incompatibility flags. Incompatibility flags are used to indicate
     * features that a MAVLink library must support in order to be able to handle the packet.
     * This includes any feature that affects the packet format/ordering. If any flag in
     * this bitmask is not understood, the packet must be dropped.
     */
    public int getIncompatibleFlags() {
        return incompatibleFlags;
    }

    /**
     * Returns this packet's compatibility flags. Compatibility flags are used to indicate features
     * won't prevent a library from handling the packet (even if the feature is not understood).
     * This might include, for example, a flag to indicate that a packet should be treated as
     * "high priority" (such a messages could be handled by any MAVLink implementation because
     * packet format and structure is not affected).
     */
    public int getCompatibleFlags() {
        return compatibleFlags;
    }

    /**
     * Returns this packet's sequence number. The sequence number is a value between 0 to 255,
     * which increments between consecutive packets. The sequence number resets to 0 once
     * it has overflown the 8 bits available.
     */
    public int getSequence() {
        return sequence;
    }

    /**
     * Returns the system ID of the originator of this packet.
     */
    public int getSystemId() {
        return systemId;
    }

    /**
     * Returns the component ID of the originator of this packet.
     */
    public int getComponentId() {
        return componentId;
    }

    /**
     * Returns the message ID of this packet.
     */
    public int getMessageId() {
        return messageId;
    }

    /**
     * Returns the payload of this packet. The payload content can be resolved by observing
     * this packet's {@link #getMessageId() message id}.
     */
    public byte[] getPayload() {
        return payload;
    }

    /**
     * Returns this packet's CRC checksum.
     */
    public int getChecksum() {
        return checksum;
    }

    /**
     * Returns the signature of this packet.
     *
     * @return The signature of this packet, or an empty byte array if no signature
     * was included in this packet.
     */
    public byte[] getSignature() {
        return signature;
    }

    /**
     * Returns a byte array containing the complete packet bytes, as they would be
     * sent or received.
     */
    public byte[] getRawBytes() {
        return rawBytes;
    }

    /**
     * Checks whether or not this is a version 2 packet.
     *
     * @return {@code true} if this is a version 2 packet, or {@code false} otherwise.
     */
    public boolean isMavlink2() {
        return versionMarker == MAGIC_V2;
    }

    /**
     * Validate's this packet's CRC checksum.
     *
     * @param crcExtra The CRC extra corresponding to this packet's message ID
     * @return {@code true} if this packet's CRC checksum passes validation, or
     * {@code false} otherwise.
     */
    public boolean validateCrc(int crcExtra) {
        return generateCrc(rawBytes, crcExtra) == checksum;
    }

    /**
     * Checks whether this packet is signed.
     *
     * @return {@code true} if this packet's incompatibility flags denote that it is signed,
     * or {@code false} otherwise.
     */
    public boolean isSigned() {
        return ((incompatibleFlags & INCOMPAT_FLAG_SIGNED) != 0);
    }

    /**
     * Validates this packet's signature.
     *
     * @param secretKey The secret key to use when validating the signature.
     * @return {@code true} if the signature is valid according to specified parameters,
     * or {@code false} otherwise.
     */
    public boolean validateSignature(byte[] secretKey) {
        return isSigned() &&
                Arrays.equals(
                        signature,
                        generateSignature(
                                this.rawBytes,
                                getSignatureLinkId(),
                                getSignatureTimestamp(),
                                secretKey));
    }

    /**
     * Returns the link ID of this packet's signature.
     */
    public int getSignatureLinkId() {
        return isSigned() ? (signature[0] & 0xFF) : -1;
    }

    /**
     * Returns the timestamp of this packet's signature.
     */
    public long getSignatureTimestamp() {
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
