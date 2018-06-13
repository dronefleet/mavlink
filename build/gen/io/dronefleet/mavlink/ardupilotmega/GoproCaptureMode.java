package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum GoproCaptureMode {
  /**
   * Video mode
   */
  @MavlinkEnumEntry(0)
  GOPRO_CAPTURE_MODE_VIDEO,

  /**
   * Photo mode
   */
  @MavlinkEnumEntry(1)
  GOPRO_CAPTURE_MODE_PHOTO,

  /**
   * Burst mode, hero 3+ only
   */
  @MavlinkEnumEntry(2)
  GOPRO_CAPTURE_MODE_BURST,

  /**
   * Time lapse mode, hero 3+ only
   */
  @MavlinkEnumEntry(3)
  GOPRO_CAPTURE_MODE_TIME_LAPSE,

  /**
   * Multi shot mode, hero 4 only
   */
  @MavlinkEnumEntry(4)
  GOPRO_CAPTURE_MODE_MULTI_SHOT,

  /**
   * Playback mode, hero 4 only, silver only except when LCD or HDMI is connected to black
   */
  @MavlinkEnumEntry(5)
  GOPRO_CAPTURE_MODE_PLAYBACK,

  /**
   * Playback mode, hero 4 only
   */
  @MavlinkEnumEntry(6)
  GOPRO_CAPTURE_MODE_SETUP,

  /**
   * Mode not yet known
   */
  @MavlinkEnumEntry(255)
  GOPRO_CAPTURE_MODE_UNKNOWN
}
