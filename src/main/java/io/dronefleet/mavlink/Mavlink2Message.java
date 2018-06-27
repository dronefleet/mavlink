package io.dronefleet.mavlink;

import java.util.Arrays;

public class Mavlink2Message<T> extends MavlinkMessage<T> {

    private final int incompatibleFlags;
    private final int compatibleFlags;
    private final int targetSystemId;
    private final int targetComponentId;
    private final byte[] signature;

    public Mavlink2Message(
            int incompatibleFlags,
            int compatibleFlags,
            int originSystemId,
            int originComponentId,
            int targetSystemId,
            int targetComponentId,
            T payload,
            byte[] signature) {
        super(originSystemId, originComponentId, payload);
        this.targetSystemId = targetSystemId;
        this.targetComponentId = targetComponentId;
        this.incompatibleFlags = incompatibleFlags;
        this.compatibleFlags = compatibleFlags;
        this.signature = signature;
    }

    public int getIncompatibleFlags() {
        return incompatibleFlags;
    }

    public int getCompatibleFlags() {
        return compatibleFlags;
    }

    public int getTargetSystemId() {
        return targetSystemId;
    }

    public int getTargetComponentId() {
        return targetComponentId;
    }

    public byte[] getSignature() {
        return signature;
    }

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
        return Arrays.equals(signature, that.signature);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + incompatibleFlags;
        result = 31 * result + compatibleFlags;
        result = 31 * result + targetSystemId;
        result = 31 * result + targetComponentId;
        result = 31 * result + Arrays.hashCode(signature);
        return result;
    }

    @Override
    public String toString() {
        return "Mavlink2Message{" +
                "incompatibleFlags=" + incompatibleFlags +
                ", compatibleFlags=" + compatibleFlags +
                ", targetSystemId=" + targetSystemId +
                ", targetComponentId=" + targetComponentId +
                ", signature=" + Arrays.toString(signature) +
                "} " + super.toString();
    }
}
