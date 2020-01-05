package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * The interval between messages for a particular MAVLink message ID. This message is the 
 * response to the MAV_CMD_GET_MESSAGE_INTERVAL command. This interface replaces 
 * {@link io.dronefleet.mavlink.common.DataStream DATA_STREAM}. 
 */
@MavlinkMessageInfo(
        id = 244,
        crc = 95,
        description = "The interval between messages for a particular MAVLink message ID. This message is the response to the MAV_CMD_GET_MESSAGE_INTERVAL command. This interface replaces DATA_STREAM."
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
            unitSize = 2,
            description = "The ID of the requested MAVLink message. v1.0 is limited to 254 messages."
    )
    public final int messageId() {
        return this.messageId;
    }

    /**
     * The interval between two messages. A value of -1 indicates this stream is disabled, 0 indicates 
     * it is not available, &gt; 0 indicates the interval at which it is sent. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            signed = true,
            description = "The interval between two messages. A value of -1 indicates this stream is disabled, 0 indicates it is not available, > 0 indicates the interval at which it is sent."
    )
    public final int intervalUs() {
        return this.intervalUs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        MessageInterval other = (MessageInterval)o;
        if (!Objects.deepEquals(messageId, other.messageId)) return false;
        if (!Objects.deepEquals(intervalUs, other.intervalUs)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(messageId);
        result = 31 * result + Objects.hashCode(intervalUs);
        return result;
    }

    @Override
    public String toString() {
        return "MessageInterval{messageId=" + messageId
                 + ", intervalUs=" + intervalUs + "}";
    }

    public static final class Builder {
        private int messageId;

        private int intervalUs;

        /**
         * The ID of the requested MAVLink message. v1.0 is limited to 254 messages. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2,
                description = "The ID of the requested MAVLink message. v1.0 is limited to 254 messages."
        )
        public final Builder messageId(int messageId) {
            this.messageId = messageId;
            return this;
        }

        /**
         * The interval between two messages. A value of -1 indicates this stream is disabled, 0 indicates 
         * it is not available, &gt; 0 indicates the interval at which it is sent. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                signed = true,
                description = "The interval between two messages. A value of -1 indicates this stream is disabled, 0 indicates it is not available, > 0 indicates the interval at which it is sent."
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
