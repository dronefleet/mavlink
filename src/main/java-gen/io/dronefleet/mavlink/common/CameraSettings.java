package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Settings of a camera, can be requested using MAV_CMD_REQUEST_CAMERA_SETTINGS. 
 */
@MavlinkMessageInfo(
    id = 260,
    crc = 146
)
public final class CameraSettings {
  /**
   * Timestamp (milliseconds since system boot) 
   */
  private final long timeBootMs;

  /**
   * Camera mode ({@link io.dronefleet.mavlink.common.CameraMode CameraMode}) 
   */
  private final CameraMode modeId;

  private CameraSettings(long timeBootMs, CameraMode modeId) {
    this.timeBootMs = timeBootMs;
    this.modeId = modeId;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "CameraSettings{timeBootMs=" + timeBootMs
         + ", modeId=" + modeId + "}";
  }

  /**
   * Timestamp (milliseconds since system boot) 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  /**
   * Camera mode ({@link io.dronefleet.mavlink.common.CameraMode CameraMode}) 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final CameraMode modeId() {
    return modeId;
  }

  public static class Builder {
    private long timeBootMs;

    private CameraMode modeId;

    private Builder() {
    }

    /**
     * Timestamp (milliseconds since system boot) 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 4
    )
    public final Builder timeBootMs(long timeBootMs) {
      this.timeBootMs = timeBootMs;
      return this;
    }

    /**
     * Camera mode ({@link io.dronefleet.mavlink.common.CameraMode CameraMode}) 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
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
