package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Enumeration of battery types 
 */
@MavlinkEnum
public enum MavBatteryType {
  /**
   * Not specified.
   */
  @MavlinkEnumEntry(0)
  MAV_BATTERY_TYPE_UNKNOWN,

  /**
   * Lithium polymer battery
   */
  @MavlinkEnumEntry(1)
  MAV_BATTERY_TYPE_LIPO,

  /**
   * Lithium-iron-phosphate battery
   */
  @MavlinkEnumEntry(2)
  MAV_BATTERY_TYPE_LIFE,

  /**
   * Lithium-ION battery
   */
  @MavlinkEnumEntry(3)
  MAV_BATTERY_TYPE_LION,

  /**
   * Nickel metal hydride battery
   */
  @MavlinkEnumEntry(4)
  MAV_BATTERY_TYPE_NIMH
}
