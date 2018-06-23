package io.dronefleet.mavlink;

public class MavlinkMessage<T> {

    public static <T> Class<MavlinkMessage<T>> ofGenericType(Class<T> type) {
        return (Class<MavlinkMessage<T>>)(Class<?>)MavlinkMessage.class;
    }

    private final int originSystemId;
    private final int originComponentId;
    private final T payload;

    public MavlinkMessage(int originSystemId, int originComponentId, T payload) {
        this.originSystemId = originSystemId;
        this.originComponentId = originComponentId;
        this.payload = payload;
    }

    private MavlinkMessage(Class<T> type) {
        this.originSystemId = -1;
        this.originComponentId = -1;
        this.payload = null;
    }

    public int getOriginSystemId() {
        return originSystemId;
    }

    public int getOriginComponentId() {
        return originComponentId;
    }

    public T getPayload() {
        return payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MavlinkMessage<?> that = (MavlinkMessage<?>) o;

        if (originSystemId != that.originSystemId) return false;
        if (originComponentId != that.originComponentId) return false;
        return payload != null ? payload.equals(that.payload) : that.payload == null;
    }

    @Override
    public int hashCode() {
        int result = originSystemId;
        result = 31 * result + originComponentId;
        result = 31 * result + (payload != null ? payload.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MavlinkMessage{" +
                "originSystemId=" + originSystemId +
                ", originComponentId=" + originComponentId +
                ", payload=" + payload +
                '}';
    }
}
