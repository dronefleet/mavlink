package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * A mapping of rover flight modes for custom_mode field of heartbeat 
 */
@MavlinkEnum
public enum RoverMode {
  /**
   * null
   */
  @MavlinkEnumEntry(0)
  ROVER_MODE_MANUAL,

  /**
   * null
   */
  @MavlinkEnumEntry(1)
  ROVER_MODE_ACRO,

  /**
   * null
   */
  @MavlinkEnumEntry(3)
  ROVER_MODE_STEERING,

  /**
   * null
   */
  @MavlinkEnumEntry(4)
  ROVER_MODE_HOLD,

  /**
   * null
   */
  @MavlinkEnumEntry(5)
  ROVER_MODE_LOITER,

  /**
   * null
   */
  @MavlinkEnumEntry(10)
  ROVER_MODE_AUTO,

  /**
   * null
   */
  @MavlinkEnumEntry(11)
  ROVER_MODE_RTL,

  /**
   * null
   */
  @MavlinkEnumEntry(12)
  ROVER_MODE_SMART_RTL,

  /**
   * null
   */
  @MavlinkEnumEntry(15)
  ROVER_MODE_GUIDED,

  /**
   * null
   */
  @MavlinkEnumEntry(16)
  ROVER_MODE_INITIALIZING
}
