package io.dronefleet.mavlink.icarous;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * ICAROUS heartbeat 
 */
@MavlinkMessage(
    id = 42000,
    crc = 227
)
public final class IcarousHeartbeat {
  /**
   * See the FMS_STATE enum. 
   */
  private final IcarousFmsState status;

  private IcarousHeartbeat(IcarousFmsState status) {
    this.status = status;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * See the FMS_STATE enum. 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final IcarousFmsState status() {
    return status;
  }

  public static class Builder {
    private IcarousFmsState status;

    private Builder() {
    }

    /**
     * See the FMS_STATE enum. 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder status(IcarousFmsState status) {
      this.status = status;
      return this;
    }

    public final IcarousHeartbeat build() {
      return new IcarousHeartbeat(status);
    }
  }
}
