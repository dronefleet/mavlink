package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum GoproProtuneWhiteBalance {
  /**
   * Auto
   */
  @MavlinkEnumEntry(0)
  GOPRO_PROTUNE_WHITE_BALANCE_AUTO,

  /**
   * 3000K
   */
  @MavlinkEnumEntry(1)
  GOPRO_PROTUNE_WHITE_BALANCE_3000K,

  /**
   * 5500K
   */
  @MavlinkEnumEntry(2)
  GOPRO_PROTUNE_WHITE_BALANCE_5500K,

  /**
   * 6500K
   */
  @MavlinkEnumEntry(3)
  GOPRO_PROTUNE_WHITE_BALANCE_6500K,

  /**
   * Camera Raw
   */
  @MavlinkEnumEntry(4)
  GOPRO_PROTUNE_WHITE_BALANCE_RAW
}
