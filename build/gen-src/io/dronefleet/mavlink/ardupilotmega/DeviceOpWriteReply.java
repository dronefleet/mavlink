package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Write registers reply 
 */
@MavlinkMessage(
    id = 11003,
    crc = 64
)
public final class DeviceOpWriteReply {
  private final long requestId;

  private final int result;

  private DeviceOpWriteReply(long requestId, int result) {
    this.requestId = requestId;
    this.result = result;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * request ID - copied from request 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final long requestId() {
    return requestId;
  }

  /**
   * 0 for success, anything else is failure code 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int result() {
    return result;
  }

  public class Builder {
    private long requestId;

    private int result;

    private Builder() {
    }

    /**
     * request ID - copied from request 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder requestId(long requestId) {
      this.requestId = requestId;
      return this;
    }

    /**
     * 0 for success, anything else is failure code 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder result(int result) {
      this.result = result;
      return this;
    }

    public final DeviceOpWriteReply build() {
      return new DeviceOpWriteReply(requestId, result);
    }
  }
}
