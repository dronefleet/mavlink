package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum ParachuteAction {
  /**
   * Disable parachute release
   */
  @MavlinkEntryInfo(0)
  PARACHUTE_DISABLE,

  /**
   * Enable parachute release
   */
  @MavlinkEntryInfo(1)
  PARACHUTE_ENABLE,

  /**
   * Release parachute
   */
  @MavlinkEntryInfo(2)
  PARACHUTE_RELEASE
}
