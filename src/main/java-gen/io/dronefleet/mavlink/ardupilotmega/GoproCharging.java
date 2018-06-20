package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum GoproCharging {
  /**
   * Charging disabled
   */
  @MavlinkEntryInfo(0)
  GOPRO_CHARGING_DISABLED,

  /**
   * Charging enabled
   */
  @MavlinkEntryInfo(1)
  GOPRO_CHARGING_ENABLED
}
