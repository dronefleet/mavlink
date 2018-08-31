package io.dronefleet.mavlink;

/**
 * Represents a Mavlink2 message. See {@link MavlinkMessage} for the Mavlink1 message DTO.
 * @param <T>   The type of the payload of this message.
 */
public class Mavlink2Message<T> extends MavlinkMessage<T> {

    /**
     * A bitmask which must be understood.
     */
    private final int incompatibleFlags;

    /**
     * A bitmask of flags which may optionally be understood.
     */
    private final int compatibleFlags;

    /**
     * Constructs a new {@code Mavlink2Message} instance using the specified settings
     * @param incompatibleFlags Flags which must be understood.
     * @param compatibleFlags   Flags which may optionally be understood.
     * @param originSystemId    The ID of the originating system.
     * @param originComponentId The ID of the originating component.
     * @param payload           The payload of this message.
     */
    public Mavlink2Message(
            int incompatibleFlags,
            int compatibleFlags,
            int originSystemId,
            int originComponentId,
            T payload) {
        super(originSystemId, originComponentId, payload);
        this.incompatibleFlags = incompatibleFlags;
        this.compatibleFlags = compatibleFlags;
    }

    /**
     * Returns flags which must be understood.
     */
    public int getIncompatibleFlags() {
        return incompatibleFlags;
    }

    /**
     * Returns flags which may optionally be understood.
     */
    public int getCompatibleFlags() {
        return compatibleFlags;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Mavlink2Message<?> that = (Mavlink2Message<?>) o;

        if (incompatibleFlags != that.incompatibleFlags) return false;
        if (compatibleFlags != that.compatibleFlags) return false;
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + incompatibleFlags;
        result = 31 * result + compatibleFlags;
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Mavlink2Message{" +
                "incompatibleFlags=" + incompatibleFlags +
                ", compatibleFlags=" + compatibleFlags +
                "} " + super.toString();
    }
}
