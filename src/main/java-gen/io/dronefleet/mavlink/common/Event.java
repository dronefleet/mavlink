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
 * Event message. Each new event from a particular component gets a new sequence number. The same 
 * message might be sent multiple times if (re-)requested. Most events are broadcast, some can be 
 * specific to a target component (as receivers keep track of the sequence for missed events, all 
 * events need to be broadcast. Thus we use destination_component instead of 
 * target_component). 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 410,
        crc = 160,
        description = "Event message. Each new event from a particular component gets a new sequence number. The same message might be sent multiple times if (re-)requested. Most events are broadcast, some can be specific to a target component (as receivers keep track of the sequence for missed events, all events need to be broadcast. Thus we use destination_component instead of target_component).",
        workInProgress = true
)
@Deprecated
public final class Event {
    private final int destinationComponent;

    private final int destinationSystem;

    private final long id;

    private final long eventTimeBootMs;

    private final int sequence;

    private final int logLevels;

    private final byte[] arguments;

    private Event(int destinationComponent, int destinationSystem, long id, long eventTimeBootMs,
            int sequence, int logLevels, byte[] arguments) {
        this.destinationComponent = destinationComponent;
        this.destinationSystem = destinationSystem;
        this.id = id;
        this.eventTimeBootMs = eventTimeBootMs;
        this.sequence = sequence;
        this.logLevels = logLevels;
        this.arguments = arguments;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID"
    )
    public final int destinationComponent() {
        return this.destinationComponent;
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "System ID"
    )
    public final int destinationSystem() {
        return this.destinationSystem;
    }

    /**
     * Event ID (as defined in the component metadata) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Event ID (as defined in the component metadata)"
    )
    public final long id() {
        return this.id;
    }

    /**
     * Timestamp (time since system boot when the event happened). 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Timestamp (time since system boot when the event happened)."
    )
    public final long eventTimeBootMs() {
        return this.eventTimeBootMs;
    }

    /**
     * Sequence number. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "Sequence number."
    )
    public final int sequence() {
        return this.sequence;
    }

    /**
     * Log levels: 4 bits MSB: internal (for logging purposes), 4 bits LSB: external. Levels: 
     * Emergency = 0, Alert = 1, Critical = 2, Error = 3, Warning = 4, Notice = 5, Info = 6, Debug = 7, 
     * Protocol = 8, Disabled = 9 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            description = "Log levels: 4 bits MSB: internal (for logging purposes), 4 bits LSB: external. Levels: Emergency = 0, Alert = 1, Critical = 2, Error = 3, Warning = 4, Notice = 5, Info = 6, Debug = 7, Protocol = 8, Disabled = 9"
    )
    public final int logLevels() {
        return this.logLevels;
    }

    /**
     * Arguments (depend on event ID). 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            arraySize = 40,
            description = "Arguments (depend on event ID)."
    )
    public final byte[] arguments() {
        return this.arguments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Event other = (Event)o;
        if (!Objects.deepEquals(destinationComponent, other.destinationComponent)) return false;
        if (!Objects.deepEquals(destinationSystem, other.destinationSystem)) return false;
        if (!Objects.deepEquals(id, other.id)) return false;
        if (!Objects.deepEquals(eventTimeBootMs, other.eventTimeBootMs)) return false;
        if (!Objects.deepEquals(sequence, other.sequence)) return false;
        if (!Objects.deepEquals(logLevels, other.logLevels)) return false;
        if (!Objects.deepEquals(arguments, other.arguments)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(destinationComponent);
        result = 31 * result + Objects.hashCode(destinationSystem);
        result = 31 * result + Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(eventTimeBootMs);
        result = 31 * result + Objects.hashCode(sequence);
        result = 31 * result + Objects.hashCode(logLevels);
        result = 31 * result + Objects.hashCode(arguments);
        return result;
    }

    @Override
    public String toString() {
        return "Event{destinationComponent=" + destinationComponent
                 + ", destinationSystem=" + destinationSystem
                 + ", id=" + id
                 + ", eventTimeBootMs=" + eventTimeBootMs
                 + ", sequence=" + sequence
                 + ", logLevels=" + logLevels
                 + ", arguments=" + arguments + "}";
    }

    public static final class Builder {
        private int destinationComponent;

        private int destinationSystem;

        private long id;

        private long eventTimeBootMs;

        private int sequence;

        private int logLevels;

        private byte[] arguments;

        /**
         * Component ID 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Component ID"
        )
        public final Builder destinationComponent(int destinationComponent) {
            this.destinationComponent = destinationComponent;
            return this;
        }

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "System ID"
        )
        public final Builder destinationSystem(int destinationSystem) {
            this.destinationSystem = destinationSystem;
            return this;
        }

        /**
         * Event ID (as defined in the component metadata) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Event ID (as defined in the component metadata)"
        )
        public final Builder id(long id) {
            this.id = id;
            return this;
        }

        /**
         * Timestamp (time since system boot when the event happened). 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Timestamp (time since system boot when the event happened)."
        )
        public final Builder eventTimeBootMs(long eventTimeBootMs) {
            this.eventTimeBootMs = eventTimeBootMs;
            return this;
        }

        /**
         * Sequence number. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "Sequence number."
        )
        public final Builder sequence(int sequence) {
            this.sequence = sequence;
            return this;
        }

        /**
         * Log levels: 4 bits MSB: internal (for logging purposes), 4 bits LSB: external. Levels: 
         * Emergency = 0, Alert = 1, Critical = 2, Error = 3, Warning = 4, Notice = 5, Info = 6, Debug = 7, 
         * Protocol = 8, Disabled = 9 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                description = "Log levels: 4 bits MSB: internal (for logging purposes), 4 bits LSB: external. Levels: Emergency = 0, Alert = 1, Critical = 2, Error = 3, Warning = 4, Notice = 5, Info = 6, Debug = 7, Protocol = 8, Disabled = 9"
        )
        public final Builder logLevels(int logLevels) {
            this.logLevels = logLevels;
            return this;
        }

        /**
         * Arguments (depend on event ID). 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                arraySize = 40,
                description = "Arguments (depend on event ID)."
        )
        public final Builder arguments(byte[] arguments) {
            this.arguments = arguments;
            return this;
        }

        public final Event build() {
            return new Event(destinationComponent, destinationSystem, id, eventTimeBootMs, sequence, logLevels, arguments);
        }
    }
}
