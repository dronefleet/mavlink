package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum GoproProtuneSharpness {
  /**
   * Low Sharpness
   */
  @MavlinkEnumEntry(0)
  GOPRO_PROTUNE_SHARPNESS_LOW,

  /**
   * Medium Sharpness
   */
  @MavlinkEnumEntry(1)
  GOPRO_PROTUNE_SHARPNESS_MEDIUM,

  /**
   * High Sharpness
   */
  @MavlinkEnumEntry(2)
  GOPRO_PROTUNE_SHARPNESS_HIGH
}
