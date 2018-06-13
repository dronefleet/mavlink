package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum GoproVideoSettingsFlags {
  /**
   * 0=NTSC, 1=PAL
   */
  @MavlinkEnumEntry(1)
  GOPRO_VIDEO_SETTINGS_TV_MODE
}
