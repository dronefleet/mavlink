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
 * Request one or more events to be (re-)sent. If first_sequence==last_sequence, only a single 
 * event is requested. Note that first_sequence can be larger than last_sequence (because the 
 * sequence number can wrap). Each sequence will trigger an {@link io.dronefleet.mavlink.common.Event EVENT} or EVENT_ERROR response. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 412,
        crc = 33,
        description = "Request one or more events to be (re-)sent. If first_sequence==last_sequence, only a single event is requested. Note that first_sequence can be larger than last_sequence (because the sequence number can wrap). Each sequence will trigger an EVENT or EVENT_ERROR response.",
        workInProgress = true
)
@Deprecated
public final class RequestEvent {
    private final int targetSystem;

    private final int targetComponent;

    private final int firstSequence;

    private final int lastSequence;

    private RequestEvent(int targetSystem, int targetComponent, int firstSequence,
            int lastSequence) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.firstSequence = firstSequence;
        this.lastSequence = lastSequence;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "System ID"
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Component ID"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * First sequence number of the requested event. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "First sequence number of the requested event."
    )
    public final int firstSequence() {
        return this.firstSequence;
    }

    /**
     * Last sequence number of the requested event. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "Last sequence number of the requested event."
    )
    public final int lastSequence() {
        return this.lastSequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        RequestEvent other = (RequestEvent)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(firstSequence, other.firstSequence)) return false;
        if (!Objects.deepEquals(lastSequence, other.lastSequence)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(firstSequence);
        result = 31 * result + Objects.hashCode(lastSequence);
        return result;
    }

    @Override
    public String toString() {
        return "RequestEvent{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", firstSequence=" + firstSequence
                 + ", lastSequence=" + lastSequence + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int firstSequence;

        private int lastSequence;

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "System ID"
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Component ID"
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * First sequence number of the requested event. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "First sequence number of the requested event."
        )
        public final Builder firstSequence(int firstSequence) {
            this.firstSequence = firstSequence;
            return this;
        }

        /**
         * Last sequence number of the requested event. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "Last sequence number of the requested event."
        )
        public final Builder lastSequence(int lastSequence) {
            this.lastSequence = lastSequence;
            return this;
        }

        public final RequestEvent build() {
            return new RequestEvent(targetSystem, targetComponent, firstSequence, lastSequence);
        }
    }
}
