package io.dronefleet.mavlink;

/**
 * Represents a Mavlink message. The contents of this class are sufficient for a Mavlink1 message.
 * See {@link Mavlink2Message} for the Mavlink2 message DTO, which inherits from this class.
 * @param <T>   The type of this message's payload.
 */
public class MavlinkMessage<T> {

    /**
     * The ID of the system that originated this message.
     */
    private final int originSystemId;

    /**
     * The ID of the component which originated this message.
     */
    private final int originComponentId;

    /**
     * The payload of this message.
     */
    private final T payload;

    /**
     * Constructs a new {@code MavlinkMessage} using the specified settings.
     * @param originSystemId        The ID of the system that originated this message.
     * @param originComponentId     The ID of the component that originated this message.
     * @param payload               The payload of this message.
     */
    public MavlinkMessage(int originSystemId, int originComponentId, T payload) {
        this.originSystemId = originSystemId;
        this.originComponentId = originComponentId;
        this.payload = payload;
    }

    /**
     * Returns the ID of the system that originated this message.
     */
    public int getOriginSystemId() {
        return originSystemId;
    }

    /**
     * Returns the ID of the component that originated this message.
     */
    public int getOriginComponentId() {
        return originComponentId;
    }

    /**
     * Returns the payload of this message.
     */
    public T getPayload() {
        return payload;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MavlinkMessage<?> that = (MavlinkMessage<?>) o;

        if (originSystemId != that.originSystemId) return false;
        if (originComponentId != that.originComponentId) return false;
        return payload != null ? payload.equals(that.payload) : that.payload == null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = originSystemId;
        result = 31 * result + originComponentId;
        result = 31 * result + (payload != null ? payload.hashCode() : 0);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "MavlinkMessage{" +
                "originSystemId=" + originSystemId +
                ", originComponentId=" + originComponentId +
                ", payload=" + payload +
                '}';
    }
}
