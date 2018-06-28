package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * An ack for a {@link io.dronefleet.mavlink.common.LoggingDataAcked LOGGING_DATA_ACKED} message 
 */
@MavlinkMessageInfo(
        id = 268,
        crc = 14
)
public final class LoggingAck {
    private final int targetSystem;

    private final int targetComponent;

    private final int sequence;

    private LoggingAck(int targetSystem, int targetComponent, int sequence) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.sequence = sequence;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * system ID of the target 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * component ID of the target 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * sequence number (must match the one in {@link io.dronefleet.mavlink.common.LoggingDataAcked LOGGING_DATA_ACKED}) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int sequence() {
        return this.sequence;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int sequence;

        /**
         * system ID of the target 
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
         * component ID of the target 
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
         * sequence number (must match the one in {@link io.dronefleet.mavlink.common.LoggingDataAcked LOGGING_DATA_ACKED}) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2
        )
        public final Builder sequence(int sequence) {
            this.sequence = sequence;
            return this;
        }

        public final LoggingAck build() {
            return new LoggingAck(targetSystem, targetComponent, sequence);
        }
    }
}
