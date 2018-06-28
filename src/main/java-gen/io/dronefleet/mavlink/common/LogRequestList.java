package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Request a list of available logs. On some systems calling this may stop on-board logging until 
 * {@link io.dronefleet.mavlink.common.LogRequestEnd LOG_REQUEST_END} is called. 
 */
@MavlinkMessageInfo(
        id = 117,
        crc = 128
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
            unitSize = 1
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * First log id (0 for first available) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int start() {
        return this.start;
    }

    /**
     * Last log id (0xffff for last available) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2
    )
    public final int end() {
        return this.end;
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
                unitSize = 1
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
                unitSize = 1
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
                unitSize = 2
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
                unitSize = 2
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
