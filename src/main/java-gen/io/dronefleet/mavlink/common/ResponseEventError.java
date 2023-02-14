package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Deprecated;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Response to a {@link io.dronefleet.mavlink.common.RequestEvent REQUEST_EVENT} in case of an error (e.g. the event is not available anymore). 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 413,
        crc = 77,
        description = "Response to a REQUEST_EVENT in case of an error (e.g. the event is not available anymore).",
        workInProgress = true
)
@Deprecated
public final class ResponseEventError {
    private final int targetSystem;

    private final int targetComponent;

    private final int sequence;

    private final int sequenceOldestAvailable;

    private final EnumValue<MavEventErrorReason> reason;

    private ResponseEventError(int targetSystem, int targetComponent, int sequence,
            int sequenceOldestAvailable, EnumValue<MavEventErrorReason> reason) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.sequence = sequence;
        this.sequenceOldestAvailable = sequenceOldestAvailable;
        this.reason = reason;
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
     * Sequence number. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "Sequence number."
    )
    public final int sequence() {
        return this.sequence;
    }

    /**
     * Oldest Sequence number that is still available after the sequence set in {@link io.dronefleet.mavlink.common.RequestEvent REQUEST_EVENT}. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "Oldest Sequence number that is still available after the sequence set in REQUEST_EVENT."
    )
    public final int sequenceOldestAvailable() {
        return this.sequenceOldestAvailable;
    }

    /**
     * Error reason. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            enumType = MavEventErrorReason.class,
            description = "Error reason."
    )
    public final EnumValue<MavEventErrorReason> reason() {
        return this.reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ResponseEventError other = (ResponseEventError)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(sequence, other.sequence)) return false;
        if (!Objects.deepEquals(sequenceOldestAvailable, other.sequenceOldestAvailable)) return false;
        if (!Objects.deepEquals(reason, other.reason)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(sequence);
        result = 31 * result + Objects.hashCode(sequenceOldestAvailable);
        result = 31 * result + Objects.hashCode(reason);
        return result;
    }

    @Override
    public String toString() {
        return "ResponseEventError{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", sequence=" + sequence
                 + ", sequenceOldestAvailable=" + sequenceOldestAvailable
                 + ", reason=" + reason + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int sequence;

        private int sequenceOldestAvailable;

        private EnumValue<MavEventErrorReason> reason;

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
         * Sequence number. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "Sequence number."
        )
        public final Builder sequence(int sequence) {
            this.sequence = sequence;
            return this;
        }

        /**
         * Oldest Sequence number that is still available after the sequence set in {@link io.dronefleet.mavlink.common.RequestEvent REQUEST_EVENT}. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "Oldest Sequence number that is still available after the sequence set in REQUEST_EVENT."
        )
        public final Builder sequenceOldestAvailable(int sequenceOldestAvailable) {
            this.sequenceOldestAvailable = sequenceOldestAvailable;
            return this;
        }

        /**
         * Error reason. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                enumType = MavEventErrorReason.class,
                description = "Error reason."
        )
        public final Builder reason(EnumValue<MavEventErrorReason> reason) {
            this.reason = reason;
            return this;
        }

        /**
         * Error reason. 
         */
        public final Builder reason(MavEventErrorReason entry) {
            return reason(EnumValue.of(entry));
        }

        /**
         * Error reason. 
         */
        public final Builder reason(Enum... flags) {
            return reason(EnumValue.create(flags));
        }

        /**
         * Error reason. 
         */
        public final Builder reason(Collection<Enum> flags) {
            return reason(EnumValue.create(flags));
        }

        public final ResponseEventError build() {
            return new ResponseEventError(targetSystem, targetComponent, sequence, sequenceOldestAvailable, reason);
        }
    }
}
