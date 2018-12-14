package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * THIS INTERFACE IS DEPRECATED. USE {@link io.dronefleet.mavlink.common.MessageInterval MESSAGE_INTERVAL} INSTEAD. 
 */
@MavlinkMessageInfo(
        id = 67,
        crc = 21,
        description = "THIS INTERFACE IS DEPRECATED. USE MESSAGE_INTERVAL INSTEAD."
)
@Deprecated
public final class DataStream {
    private final int streamId;

    private final int messageRate;

    private final int onOff;

    private DataStream(int streamId, int messageRate, int onOff) {
        this.streamId = streamId;
        this.messageRate = messageRate;
        this.onOff = onOff;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The ID of the requested data stream 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "The ID of the requested data stream"
    )
    public final int streamId() {
        return this.streamId;
    }

    /**
     * The message rate 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            description = "The message rate"
    )
    public final int messageRate() {
        return this.messageRate;
    }

    /**
     * 1 stream is enabled, 0 stream is stopped. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "1 stream is enabled, 0 stream is stopped."
    )
    public final int onOff() {
        return this.onOff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        DataStream other = (DataStream)o;
        if (!Objects.deepEquals(streamId, other.streamId)) return false;
        if (!Objects.deepEquals(messageRate, other.messageRate)) return false;
        if (!Objects.deepEquals(onOff, other.onOff)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(streamId);
        result = 31 * result + Objects.hashCode(messageRate);
        result = 31 * result + Objects.hashCode(onOff);
        return result;
    }

    @Override
    public String toString() {
        return "DataStream{streamId=" + streamId
                 + ", messageRate=" + messageRate
                 + ", onOff=" + onOff + "}";
    }

    public static final class Builder {
        private int streamId;

        private int messageRate;

        private int onOff;

        /**
         * The ID of the requested data stream 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "The ID of the requested data stream"
        )
        public final Builder streamId(int streamId) {
            this.streamId = streamId;
            return this;
        }

        /**
         * The message rate 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                description = "The message rate"
        )
        public final Builder messageRate(int messageRate) {
            this.messageRate = messageRate;
            return this;
        }

        /**
         * 1 stream is enabled, 0 stream is stopped. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "1 stream is enabled, 0 stream is stopped."
        )
        public final Builder onOff(int onOff) {
            this.onOff = onOff;
            return this;
        }

        public final DataStream build() {
            return new DataStream(streamId, messageRate, onOff);
        }
    }
}
