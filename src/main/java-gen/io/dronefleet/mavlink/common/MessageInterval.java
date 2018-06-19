package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * The interval between messages for a particular MAVLink message ID. This interface replaces 
 * {@link io.dronefleet.mavlink.common.DataStream DataStream} 
 */
@MavlinkMessage(
    id = 244,
    crc = 95
)
public final class MessageInterval {
  /**
   * The interval between two messages, in microseconds. A value of -1 indicates this stream is 
   * disabled, 0 indicates it is not available, > 0 indicates the interval at which it is sent. 
   */
  private final int intervalUs;

  /**
   * The ID of the requested MAVLink message. v1.0 is limited to 254 messages. 
   */
  private final int messageId;

  private MessageInterval(int intervalUs, int messageId) {
    this.intervalUs = intervalUs;
    this.messageId = messageId;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "MessageInterval{messageId=" + messageId
         + ", intervalUs=" + intervalUs + "}";
  }

  /**
   * The interval between two messages, in microseconds. A value of -1 indicates this stream is 
   * disabled, 0 indicates it is not available, > 0 indicates the interval at which it is sent. 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final int intervalUs() {
    return intervalUs;
  }

  /**
   * The ID of the requested MAVLink message. v1.0 is limited to 254 messages. 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 2
  )
  public final int messageId() {
    return messageId;
  }

  public static class Builder {
    private int intervalUs;

    private int messageId;

    private Builder() {
    }

    /**
     * The interval between two messages, in microseconds. A value of -1 indicates this stream is 
     * disabled, 0 indicates it is not available, > 0 indicates the interval at which it is sent. 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder intervalUs(int intervalUs) {
      this.intervalUs = intervalUs;
      return this;
    }

    /**
     * The ID of the requested MAVLink message. v1.0 is limited to 254 messages. 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 2
    )
    public final Builder messageId(int messageId) {
      this.messageId = messageId;
      return this;
    }

    public final MessageInterval build() {
      return new MessageInterval(intervalUs, messageId);
    }
  }
}
