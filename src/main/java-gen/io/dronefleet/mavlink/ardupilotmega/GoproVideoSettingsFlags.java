package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum GoproVideoSettingsFlags {
  /**
   * 0=NTSC, 1=PAL
   */
  @MavlinkEntryInfo(1)
  GOPRO_VIDEO_SETTINGS_TV_MODE
}
