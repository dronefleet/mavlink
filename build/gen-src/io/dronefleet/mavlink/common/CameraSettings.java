package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Settings of a camera, can be requested using MAV_CMD_REQUEST_CAMERA_SETTINGS. 
 */
@MavlinkMessage(
    id = 260,
    crc = 146
)
public final class CameraSettings {
  private final long timeBootMs;

  private final CameraMode modeId;

  private CameraSettings(long timeBootMs, CameraMode modeId) {
    this.timeBootMs = timeBootMs;
    this.modeId = modeId;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (milliseconds since system boot) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  /**
   * Camera mode (CAMERA_MODE) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final CameraMode modeId() {
    return modeId;
  }

  public class Builder {
    private long timeBootMs;

    private CameraMode modeId;

    private Builder() {
    }

    /**
     * Timestamp (milliseconds since system boot) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder timeBootMs(long timeBootMs) {
      this.timeBootMs = timeBootMs;
      return this;
    }

    /**
     * Camera mode (CAMERA_MODE) 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder modeId(CameraMode modeId) {
      this.modeId = modeId;
      return this;
    }

    public final CameraSettings build() {
      return new CameraSettings(timeBootMs, modeId);
    }
  }
}
