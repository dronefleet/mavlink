package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * The interval between messages for a particular MAVLink message ID. This interface replaces 
 * {@link io.dronefleet.mavlink.common.DataStream DATA_STREAM} 
 */
@MavlinkMessageInfo(
        id = 244,
        crc = 95
)
public final class MessageInterval {
    private final int messageId;

    private final int intervalUs;

    private MessageInterval(int messageId, int intervalUs) {
        this.messageId = messageId;
        this.intervalUs = intervalUs;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The ID of the requested MAVLink message. v1.0 is limited to 254 messages. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2
    )
    public final int messageId() {
        return this.messageId;
    }

    /**
     * The interval between two messages, in microseconds. A value of -1 indicates this stream is 
     * disabled, 0 indicates it is not available, > 0 indicates the interval at which it is sent. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            signed = true
    )
    public final int intervalUs() {
        return this.intervalUs;
    }

    public static final class Builder {
        private int messageId;

        private int intervalUs;

        /**
         * The ID of the requested MAVLink message. v1.0 is limited to 254 messages. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2
        )
        public final Builder messageId(int messageId) {
            this.messageId = messageId;
            return this;
        }

        /**
         * The interval between two messages, in microseconds. A value of -1 indicates this stream is 
         * disabled, 0 indicates it is not available, > 0 indicates the interval at which it is sent. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                signed = true
        )
        public final Builder intervalUs(int intervalUs) {
            this.intervalUs = intervalUs;
            return this;
        }

        public final MessageInterval build() {
            return new MessageInterval(messageId, intervalUs);
        }
    }
}
