package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Winch actions 
 */
@MavlinkEnum
public enum WinchActions {
  /**
   * relax winch
   */
  @MavlinkEntryInfo(0)
  WINCH_RELAXED,

  /**
   * winch unwinds or winds specified length of cable optionally using specified rate
   */
  @MavlinkEntryInfo(1)
  WINCH_RELATIVE_LENGTH_CONTROL,

  /**
   * winch unwinds or winds cable at specified rate in meters/seconds
   */
  @MavlinkEntryInfo(2)
  WINCH_RATE_CONTROL
}
