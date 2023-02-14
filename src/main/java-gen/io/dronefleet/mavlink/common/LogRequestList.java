package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Request a list of available logs. On some systems calling this may stop on-board logging until 
 * {@link io.dronefleet.mavlink.common.LogRequestEnd LOG_REQUEST_END} is called. If there are no log files available this request shall be answered 
 * with one {@link io.dronefleet.mavlink.common.LogEntry LOG_ENTRY} message with id = 0 and num_logs = 0. 
 */
@MavlinkMessageInfo(
        id = 117,
        crc = 128,
        description = "Request a list of available logs. On some systems calling this may stop on-board logging until LOG_REQUEST_END is called. If there are no log files available this request shall be answered with one LOG_ENTRY message with id = 0 and num_logs = 0."
)
public final class LogRequestList {
    private final int targetSystem;

    private final int targetComponent;

    private final int start;

    private final int end;

    private LogRequestList(int targetSystem, int targetComponent, int start, int end) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.start = start;
        this.end = end;
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
            position = 1,
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
            position = 2,
            unitSize = 1,
            description = "Component ID"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * First log id (0 for first available) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "First log id (0 for first available)"
    )
    public final int start() {
        return this.start;
    }

    /**
     * Last log id (0xffff for last available) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "Last log id (0xffff for last available)"
    )
    public final int end() {
        return this.end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        LogRequestList other = (LogRequestList)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(start, other.start)) return false;
        if (!Objects.deepEquals(end, other.end)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(start);
        result = 31 * result + Objects.hashCode(end);
        return result;
    }

    @Override
    public String toString() {
        return "LogRequestList{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", start=" + start
                 + ", end=" + end + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int start;

        private int end;

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 1,
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
                position = 2,
                unitSize = 1,
                description = "Component ID"
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * First log id (0 for first available) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "First log id (0 for first available)"
        )
        public final Builder start(int start) {
            this.start = start;
            return this;
        }

        /**
         * Last log id (0xffff for last available) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "Last log id (0xffff for last available)"
        )
        public final Builder end(int end) {
            this.end = end;
            return this;
        }

        public final LogRequestList build() {
            return new LogRequestList(targetSystem, targetComponent, start, end);
        }
    }
}
