package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * A message containing logged data (see also MAV_CMD_LOGGING_START) 
 */
@MavlinkMessageInfo(
        id = 266,
        crc = 193
)
public final class LoggingData {
    private final int targetSystem;

    private final int targetComponent;

    private final int sequence;

    private final int length;

    private final int firstMessageOffset;

    private final byte[] data;

    private LoggingData(int targetSystem, int targetComponent, int sequence, int length,
            int firstMessageOffset, byte[] data) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.sequence = sequence;
        this.length = length;
        this.firstMessageOffset = firstMessageOffset;
        this.data = data;
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
     * sequence number (can wrap) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int sequence() {
        return this.sequence;
    }

    /**
     * data length 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int length() {
        return this.length;
    }

    /**
     * offset into data where first message starts. This can be used for recovery, when a previous 
     * message got lost (set to 255 if no start exists). 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int firstMessageOffset() {
        return this.firstMessageOffset;
    }

    /**
     * logged data 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            arraySize = 249
    )
    public final byte[] data() {
        return this.data;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int sequence;

        private int length;

        private int firstMessageOffset;

        private byte[] data;

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
         * sequence number (can wrap) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2
        )
        public final Builder sequence(int sequence) {
            this.sequence = sequence;
            return this;
        }

        /**
         * data length 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder length(int length) {
            this.length = length;
            return this;
        }

        /**
         * offset into data where first message starts. This can be used for recovery, when a previous 
         * message got lost (set to 255 if no start exists). 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder firstMessageOffset(int firstMessageOffset) {
            this.firstMessageOffset = firstMessageOffset;
            return this;
        }

        /**
         * logged data 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                arraySize = 249
        )
        public final Builder data(byte[] data) {
            this.data = data;
            return this;
        }

        public final LoggingData build() {
            return new LoggingData(targetSystem, targetComponent, sequence, length, firstMessageOffset, data);
        }
    }
}
