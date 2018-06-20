package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum GoproProtuneWhiteBalance {
  /**
   * Auto
   */
  @MavlinkEntryInfo(0)
  GOPRO_PROTUNE_WHITE_BALANCE_AUTO,

  /**
   * 3000K
   */
  @MavlinkEntryInfo(1)
  GOPRO_PROTUNE_WHITE_BALANCE_3000K,

  /**
   * 5500K
   */
  @MavlinkEntryInfo(2)
  GOPRO_PROTUNE_WHITE_BALANCE_5500K,

  /**
   * 6500K
   */
  @MavlinkEntryInfo(3)
  GOPRO_PROTUNE_WHITE_BALANCE_6500K,

  /**
   * Camera Raw
   */
  @MavlinkEntryInfo(4)
  GOPRO_PROTUNE_WHITE_BALANCE_RAW
}
