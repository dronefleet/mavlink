package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum GoproCharging {
  /**
   * Charging disabled
   */
  @MavlinkEnumEntry(0)
  GOPRO_CHARGING_DISABLED,

  /**
   * Charging enabled
   */
  @MavlinkEnumEntry(1)
  GOPRO_CHARGING_ENABLED
}
