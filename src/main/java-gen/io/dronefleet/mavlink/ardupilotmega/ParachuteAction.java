package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum ParachuteAction {
  /**
   * Disable parachute release
   */
  @MavlinkEnumEntry(0)
  PARACHUTE_DISABLE,

  /**
   * Enable parachute release
   */
  @MavlinkEnumEntry(1)
  PARACHUTE_ENABLE,

  /**
   * Release parachute
   */
  @MavlinkEnumEntry(2)
  PARACHUTE_RELEASE
}
