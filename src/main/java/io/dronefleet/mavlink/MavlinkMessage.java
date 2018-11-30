package io.dronefleet.mavlink;

import io.dronefleet.mavlink.protocol.MavlinkPacket;

/**
 * Represents a Mavlink message. The contents of this class are sufficient for a Mavlink1 message.
 * See {@link Mavlink2Message} for the Mavlink2 message DTO, which inherits from this class.
 *
 * @param <T> The type of this message's payload.
 */
public class MavlinkMessage<T> {

    private final MavlinkPacket packet;
    private final T payload;

    MavlinkMessage(MavlinkPacket packet, T payload) {
        this.packet = packet;
        this.payload = payload;
    }

    /**
     * Returns the sequence of this message.
     */
    public int getSequence() {
        return packet.getSequence();
    }

    /**
     * Returns the ID of the system that originated this message.
     */
    public int getOriginSystemId() {
        return packet.getSystemId();
    }

    /**
     * Returns the ID of the component that originated this message.
     */
    public int getOriginComponentId() {
        return packet.getComponentId();
    }

    /**
     * Returns the payload of this message.
     */
    public T getPayload() {
        return payload;
    }

    /**
     * Returns a copy of the original raw bytes of this message.
     */
    public byte[] getRawBytes() {
        return packet.getRawBytes()
                .clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MavlinkMessage<?> that = (MavlinkMessage<?>) o;

        if (packet != null ? !packet.equals(that.packet) : that.packet != null) return false;
        return payload != null ? payload.equals(that.payload) : that.payload == null;
    }

    @Override
    public int hashCode() {
        int result = packet != null ? packet.hashCode() : 0;
        result = 31 * result + (payload != null ? payload.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MavlinkMessage{" +
                "packet=" + packet +
                ", payload=" + payload +
                '}';
    }
}
