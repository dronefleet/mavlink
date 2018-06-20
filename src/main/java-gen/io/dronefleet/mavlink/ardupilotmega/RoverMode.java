package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * A mapping of rover flight modes for custom_mode field of heartbeat 
 */
@MavlinkEnum
public enum RoverMode {
  /**
   * null
   */
  @MavlinkEntryInfo(0)
  ROVER_MODE_MANUAL,

  /**
   * null
   */
  @MavlinkEntryInfo(1)
  ROVER_MODE_ACRO,

  /**
   * null
   */
  @MavlinkEntryInfo(3)
  ROVER_MODE_STEERING,

  /**
   * null
   */
  @MavlinkEntryInfo(4)
  ROVER_MODE_HOLD,

  /**
   * null
   */
  @MavlinkEntryInfo(5)
  ROVER_MODE_LOITER,

  /**
   * null
   */
  @MavlinkEntryInfo(10)
  ROVER_MODE_AUTO,

  /**
   * null
   */
  @MavlinkEntryInfo(11)
  ROVER_MODE_RTL,

  /**
   * null
   */
  @MavlinkEntryInfo(12)
  ROVER_MODE_SMART_RTL,

  /**
   * null
   */
  @MavlinkEntryInfo(15)
  ROVER_MODE_GUIDED,

  /**
   * null
   */
  @MavlinkEntryInfo(16)
  ROVER_MODE_INITIALIZING
}
