package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * THIS INTERFACE IS DEPRECATED. USE MESSAGE_INTERVAL INSTEAD. 
 */
@MavlinkMessage(
    id = 67,
    crc = 21
)
public final class DataStream {
  /**
   * The message rate 
   */
  private final int messageRate;

  /**
   * The ID of the requested data stream 
   */
  private final int streamId;

  /**
   * 1 stream is enabled, 0 stream is stopped. 
   */
  private final int onOff;

  private DataStream(int messageRate, int streamId, int onOff) {
    this.messageRate = messageRate;
    this.streamId = streamId;
    this.onOff = onOff;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "DataStream{streamId=" + streamId
         + ", messageRate=" + messageRate
         + ", onOff=" + onOff + "}";
  }

  /**
   * The message rate 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 2
  )
  public final int messageRate() {
    return messageRate;
  }

  /**
   * The ID of the requested data stream 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1
  )
  public final int streamId() {
    return streamId;
  }

  /**
   * 1 stream is enabled, 0 stream is stopped. 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 1
  )
  public final int onOff() {
    return onOff;
  }

  public static class Builder {
    private int messageRate;

    private int streamId;

    private int onOff;

    private Builder() {
    }

    /**
     * The message rate 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 2
    )
    public final Builder messageRate(int messageRate) {
      this.messageRate = messageRate;
      return this;
    }

    /**
     * The ID of the requested data stream 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 1
    )
    public final Builder streamId(int streamId) {
      this.streamId = streamId;
      return this;
    }

    /**
     * 1 stream is enabled, 0 stream is stopped. 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 1
    )
    public final Builder onOff(int onOff) {
      this.onOff = onOff;
      return this;
    }

    public final DataStream build() {
      return new DataStream(messageRate, streamId, onOff);
    }
  }
}
