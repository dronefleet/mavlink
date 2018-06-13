package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

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
   * The ID of the requested MAVLink message. v1.0 is limited to 254 messages. 
   */
  private final int messageId;

  /**
   * The interval between two messages, in microseconds. A value of -1 indicates this stream is 
   * disabled, 0 indicates it is not available, > 0 indicates the interval at which it is sent. 
   */
  private final int intervalUs;

  private MessageInterval(int messageId, int intervalUs) {
    this.messageId = messageId;
    this.intervalUs = intervalUs;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * The ID of the requested MAVLink message. v1.0 is limited to 254 messages. 
   */
  @MavlinkMessageField(
      position = 1,
      length = 2
  )
  public final int messageId() {
    return messageId;
  }

  /**
   * The interval between two messages, in microseconds. A value of -1 indicates this stream is 
   * disabled, 0 indicates it is not available, > 0 indicates the interval at which it is sent. 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final int intervalUs() {
    return intervalUs;
  }

  public static class Builder {
    private int messageId;

    private int intervalUs;

    private Builder() {
    }

    /**
     * The ID of the requested MAVLink message. v1.0 is limited to 254 messages. 
     */
    @MavlinkMessageField(
        position = 1,
        length = 2
    )
    public final Builder messageId(int messageId) {
      this.messageId = messageId;
      return this;
    }

    /**
     * The interval between two messages, in microseconds. A value of -1 indicates this stream is 
     * disabled, 0 indicates it is not available, > 0 indicates the interval at which it is sent. 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
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
