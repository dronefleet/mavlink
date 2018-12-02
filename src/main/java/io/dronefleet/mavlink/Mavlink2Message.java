package io.dronefleet.mavlink;

import io.dronefleet.mavlink.protocol.MavlinkPacket;

/**
 * Represents a Mavlink2 message. See {@link MavlinkMessage} for the Mavlink1 message DTO.
 *
 * @param <T> The type of the payload of this message.
 */
public class Mavlink2Message<T> extends MavlinkMessage<T> {

    private final MavlinkPacket packet;

    Mavlink2Message(MavlinkPacket packet, T payload) {
        super(packet, payload);
        this.packet = packet;
    }

    /**
     * Returns {@code true} if this packet is signed, or {@code false} otherwise.
     */
    public boolean isSigned() {
        return packet.isSigned();
    }

    /**
     * Validates this packet's signature, using its own link ID and timestamp.
     *
     * @param secretKey The secret key to use when validating the signature.
     * @return {@code true} if the signature validation passed, or {@code false} otherwise.
     */
    public boolean validateSignature(byte[] secretKey) {
        return packet.validateSignature(secretKey);
    }

    /**
     * Returns the timestamp of this packet's signature.
     *
     * @return The timestamp in this packet's signature, or {@code -1} if this packet
     * is not signed.
     */
    public long getSignatureTimestamp() {
        return packet.getSignatureTimestamp();
    }

    /**
     * Returns the link ID of this packet's signature.
     *
     * @return The link ID in this packet's signature, or {@code -1} if this packet
     * is not signed.
     */
    public int getSignatureLinkId() {
        return packet.getSignatureLinkId();
    }

    /**
     * Returns the complete signature of this message.
     */
    public byte[] getSignature() {
        return packet.getSignature();
    }
}
