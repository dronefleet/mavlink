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
     * The ID of the target system.
     */
    private final int targetSystemId;

    /**
     * The ID of the target component.
     */
    private final int targetComponentId;

    /**
     * Constructs a new {@code Mavlink2Message} instance using the specified settings
     * @param incompatibleFlags Flags which must be understood.
     * @param compatibleFlags   Flags which may optionally be understood.
     * @param originSystemId    The ID of the originating system.
     * @param originComponentId The ID of the originating component.
     * @param targetSystemId    The ID of the target system.
     * @param targetComponentId The ID of the target component.
     * @param payload           The payload of this message.
     */
    public Mavlink2Message(
            int incompatibleFlags,
            int compatibleFlags,
            int originSystemId,
            int originComponentId,
            int targetSystemId,
            int targetComponentId,
            T payload) {
        super(originSystemId, originComponentId, payload);
        this.targetSystemId = targetSystemId;
        this.targetComponentId = targetComponentId;
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
     * Returns the ID of the target system.
     */
    public int getTargetSystemId() {
        return targetSystemId;
    }

    /**
     * Returns the ID of the target component.
     */
    public int getTargetComponentId() {
        return targetComponentId;
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
        if (targetSystemId != that.targetSystemId) return false;
        if (targetComponentId != that.targetComponentId) return false;
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
        result = 31 * result + targetSystemId;
        result = 31 * result + targetComponentId;
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
                ", targetSystemId=" + targetSystemId +
                ", targetComponentId=" + targetComponentId +
                "} " + super.toString();
    }
}
