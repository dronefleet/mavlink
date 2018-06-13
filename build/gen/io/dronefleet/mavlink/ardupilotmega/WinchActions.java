package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Winch actions 
 */
@MavlinkEnum
public enum WinchActions {
  /**
   * relax winch
   */
  @MavlinkEnumEntry(0)
  WINCH_RELAXED,

  /**
   * winch unwinds or winds specified length of cable optionally using specified rate
   */
  @MavlinkEnumEntry(1)
  WINCH_RELATIVE_LENGTH_CONTROL,

  /**
   * winch unwinds or winds cable at specified rate in meters/seconds
   */
  @MavlinkEnumEntry(2)
  WINCH_RATE_CONTROL
}
