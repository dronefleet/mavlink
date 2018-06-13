package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * THIS INTERFACE IS DEPRECATED. USE MESSAGE_INTERVAL INSTEAD. 
 */
@MavlinkMessage(
    id = 67,
    crc = 21
)
public final class DataStream {
  /**
   * The ID of the requested data stream 
   */
  private final int streamId;

  /**
   * The message rate 
   */
  private final int messageRate;

  /**
   * 1 stream is enabled, 0 stream is stopped. 
   */
  private final int onOff;

  private DataStream(int streamId, int messageRate, int onOff) {
    this.streamId = streamId;
    this.messageRate = messageRate;
    this.onOff = onOff;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * The ID of the requested data stream 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int streamId() {
    return streamId;
  }

  /**
   * The message rate 
   */
  @MavlinkMessageField(
      position = 2,
      length = 2
  )
  public final int messageRate() {
    return messageRate;
  }

  /**
   * 1 stream is enabled, 0 stream is stopped. 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int onOff() {
    return onOff;
  }

  public static class Builder {
    private int streamId;

    private int messageRate;

    private int onOff;

    private Builder() {
    }

    /**
     * The ID of the requested data stream 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder streamId(int streamId) {
      this.streamId = streamId;
      return this;
    }

    /**
     * The message rate 
     */
    @MavlinkMessageField(
        position = 2,
        length = 2
    )
    public final Builder messageRate(int messageRate) {
      this.messageRate = messageRate;
      return this;
    }

    /**
     * 1 stream is enabled, 0 stream is stopped. 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder onOff(int onOff) {
      this.onOff = onOff;
      return this;
    }

    public final DataStream build() {
      return new DataStream(streamId, messageRate, onOff);
    }
  }
}
