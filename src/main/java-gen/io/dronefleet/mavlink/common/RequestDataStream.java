package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Request a data stream. 
 */
@MavlinkMessageInfo(
        id = 66,
        crc = 148,
        description = "Request a data stream."
)
public final class RequestDataStream {
    private final int targetSystem;

    private final int targetComponent;

    private final int reqStreamId;

    private final int reqMessageRate;

    private final int startStop;

    private RequestDataStream(int targetSystem, int targetComponent, int reqStreamId,
            int reqMessageRate, int startStop) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.reqStreamId = reqStreamId;
        this.reqMessageRate = reqMessageRate;
        this.startStop = startStop;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The target requested to send the message stream. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "The target requested to send the message stream."
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * The target requested to send the message stream. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "The target requested to send the message stream."
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * The ID of the requested data stream 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "The ID of the requested data stream"
    )
    public final int reqStreamId() {
        return this.reqStreamId;
    }

    /**
     * The requested message rate 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "The requested message rate"
    )
    public final int reqMessageRate() {
        return this.reqMessageRate;
    }

    /**
     * 1 to start sending, 0 to stop sending. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            description = "1 to start sending, 0 to stop sending."
    )
    public final int startStop() {
        return this.startStop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        RequestDataStream other = (RequestDataStream)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(reqStreamId, other.reqStreamId)) return false;
        if (!Objects.deepEquals(reqMessageRate, other.reqMessageRate)) return false;
        if (!Objects.deepEquals(startStop, other.startStop)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(reqStreamId);
        result = 31 * result + Objects.hashCode(reqMessageRate);
        result = 31 * result + Objects.hashCode(startStop);
        return result;
    }

    @Override
    public String toString() {
        return "RequestDataStream{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", reqStreamId=" + reqStreamId
                 + ", reqMessageRate=" + reqMessageRate
                 + ", startStop=" + startStop + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int reqStreamId;

        private int reqMessageRate;

        private int startStop;

        /**
         * The target requested to send the message stream. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "The target requested to send the message stream."
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * The target requested to send the message stream. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "The target requested to send the message stream."
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * The ID of the requested data stream 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "The ID of the requested data stream"
        )
        public final Builder reqStreamId(int reqStreamId) {
            this.reqStreamId = reqStreamId;
            return this;
        }

        /**
         * The requested message rate 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "The requested message rate"
        )
        public final Builder reqMessageRate(int reqMessageRate) {
            this.reqMessageRate = reqMessageRate;
            return this;
        }

        /**
         * 1 to start sending, 0 to stop sending. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                description = "1 to start sending, 0 to stop sending."
        )
        public final Builder startStop(int startStop) {
            this.startStop = startStop;
            return this;
        }

        public final RequestDataStream build() {
            return new RequestDataStream(targetSystem, targetComponent, reqStreamId, reqMessageRate, startStop);
        }
    }
}
