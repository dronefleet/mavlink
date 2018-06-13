package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum CameraFeedbackFlags {
  /**
   * Shooting photos, not video
   */
  @MavlinkEnumEntry(0)
  CAMERA_FEEDBACK_PHOTO,

  /**
   * Shooting video, not stills
   */
  @MavlinkEnumEntry(1)
  CAMERA_FEEDBACK_VIDEO,

  /**
   * Unable to achieve requested exposure (e.g. shutter speed too low)
   */
  @MavlinkEnumEntry(2)
  CAMERA_FEEDBACK_BADEXPOSURE,

  /**
   * Closed loop feedback from camera, we know for sure it has successfully taken a picture
   */
  @MavlinkEnumEntry(3)
  CAMERA_FEEDBACK_CLOSEDLOOP,

  /**
   * Open loop camera, an image trigger has been requested but we can't know for sure it has successfully taken a picture
   */
  @MavlinkEnumEntry(4)
  CAMERA_FEEDBACK_OPENLOOP
}
