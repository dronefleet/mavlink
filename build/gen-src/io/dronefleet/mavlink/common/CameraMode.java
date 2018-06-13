package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Camera Modes. 
 */
@MavlinkEnum
public enum CameraMode {
  /**
   * Camera is in image/photo capture mode.
   */
  @MavlinkEnumEntry(0)
  CAMERA_MODE_IMAGE,

  /**
   * Camera is in video capture mode.
   */
  @MavlinkEnumEntry(1)
  CAMERA_MODE_VIDEO,

  /**
   * Camera is in image survey capture mode. It allows for camera controller to do specific settings for surveys.
   */
  @MavlinkEnumEntry(2)
  CAMERA_MODE_IMAGE_SURVEY
}
