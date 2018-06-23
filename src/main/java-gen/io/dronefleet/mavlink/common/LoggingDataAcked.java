package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * A message containing logged data which requires a LOGGING_ACK to be sent back 
 */
@MavlinkMessageInfo(
        id = 267,
        crc = 35
)
public final class LoggingDataAcked {
    /**
     * sequence number (can wrap) 
     */
    private final int sequence;

    /**
     * system ID of the target 
     */
    private final int targetSystem;

    /**
     * component ID of the target 
     */
    private final int targetComponent;

    /**
     * data length 
     */
    private final int length;

    /**
     * offset into data where first message starts. This can be used for recovery, when a previous 
     * message got lost (set to 255 if no start exists). 
     */
    private final int firstMessageOffset;

    /**
     * logged data 
     */
    private final byte[] data;

    private LoggingDataAcked(int sequence, int targetSystem, int targetComponent, int length,
            int firstMessageOffset, byte[] data) {
        this.sequence = sequence;
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.length = length;
        this.firstMessageOffset = firstMessageOffset;
        this.data = data;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "LoggingDataAcked{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", sequence=" + sequence
                 + ", length=" + length
                 + ", firstMessageOffset=" + firstMessageOffset
                 + ", data=" + data + "}";
    }

    /**
     * sequence number (can wrap) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int sequence() {
        return sequence;
    }

    /**
     * system ID of the target 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int targetSystem() {
        return targetSystem;
    }

    /**
     * component ID of the target 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetComponent() {
        return targetComponent;
    }

    /**
     * data length 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int length() {
        return length;
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
        return firstMessageOffset;
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
        return data;
    }

    public static class Builder {
        private int sequence;

        private int targetSystem;

        private int targetComponent;

        private int length;

        private int firstMessageOffset;

        private byte[] data;

        private Builder() {
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

        public final LoggingDataAcked build() {
            return new LoggingDataAcked(sequence, targetSystem, targetComponent, length, firstMessageOffset, data);
        }
    }
}
