package io.dronefleet.mavlink;

public class Mavlink2Message<T> extends MavlinkMessage<T> {

    private final int targetSystemId;
    private final int targetComponentId;

    public Mavlink2Message(
            int originSystemId,
            int originComponentId,
            int targetSystemId,
            int targetComponentId,
            T payload) {
        super(originSystemId, originComponentId, payload);
        this.targetSystemId = targetSystemId;
        this.targetComponentId = targetComponentId;
    }

    public int getTargetSystemId() {
        return targetSystemId;
    }

    public int getTargetComponentId() {
        return targetComponentId;
    }

    @Override
    public String toString() {
        return "Mavlink2Message{" +
                "targetSystemId=" + targetSystemId +
                ", targetComponentId=" + targetComponentId +
                "} " + super.toString();
    }
}
