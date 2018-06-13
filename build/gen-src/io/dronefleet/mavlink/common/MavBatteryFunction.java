package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Enumeration of battery functions 
 */
@MavlinkEnum
public enum MavBatteryFunction {
  /**
   * Battery function is unknown
   */
  @MavlinkEnumEntry(0)
  MAV_BATTERY_FUNCTION_UNKNOWN,

  /**
   * Battery supports all flight systems
   */
  @MavlinkEnumEntry(1)
  MAV_BATTERY_FUNCTION_ALL,

  /**
   * Battery for the propulsion system
   */
  @MavlinkEnumEntry(2)
  MAV_BATTERY_FUNCTION_PROPULSION,

  /**
   * Avionics battery
   */
  @MavlinkEnumEntry(3)
  MAV_BATTERY_FUNCTION_AVIONICS,

  /**
   * Payload battery
   */
  @MavlinkEnumEntry(4)
  MAV_BATTERY_TYPE_PAYLOAD
}
