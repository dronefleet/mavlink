package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.util.EnumFlagSet;

/**
 * Heartbeat from a HeroBus attached GoPro 
 */
@MavlinkMessage(
    id = 215,
    crc = 101
)
public final class GoproHeartbeat {
  /**
   * Status 
   */
  private final GoproHeartbeatStatus status;

  /**
   * Current capture mode 
   */
  private final GoproCaptureMode captureMode;

  /**
   * additional status bits 
   */
  private final EnumFlagSet<GoproHeartbeatFlags> flags;

  private GoproHeartbeat(GoproHeartbeatStatus status, GoproCaptureMode captureMode,
      EnumFlagSet<GoproHeartbeatFlags> flags) {
    this.status = status;
    this.captureMode = captureMode;
    this.flags = flags;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Status 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final GoproHeartbeatStatus status() {
    return status;
  }

  /**
   * Current capture mode 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final GoproCaptureMode captureMode() {
    return captureMode;
  }

  /**
   * additional status bits 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final EnumFlagSet<GoproHeartbeatFlags> flags() {
    return flags;
  }

  public static class Builder {
    private GoproHeartbeatStatus status;

    private GoproCaptureMode captureMode;

    private EnumFlagSet<GoproHeartbeatFlags> flags;

    private Builder() {
    }

    /**
     * Status 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder status(GoproHeartbeatStatus status) {
      this.status = status;
      return this;
    }

    /**
     * Current capture mode 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder captureMode(GoproCaptureMode captureMode) {
      this.captureMode = captureMode;
      return this;
    }

    /**
     * additional status bits 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder flags(EnumFlagSet<GoproHeartbeatFlags> flags) {
      this.flags = flags;
      return this;
    }

    public final GoproHeartbeat build() {
      return new GoproHeartbeat(status, captureMode, flags);
    }
  }
}
