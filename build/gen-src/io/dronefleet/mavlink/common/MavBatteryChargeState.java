package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Enumeration for low battery states. 
 */
@MavlinkEnum
public enum MavBatteryChargeState {
  /**
   * Low battery state is not provided
   */
  @MavlinkEnumEntry(0)
  MAV_BATTERY_CHARGE_STATE_UNDEFINED,

  /**
   * Battery is not in low state. Normal operation.
   */
  @MavlinkEnumEntry(1)
  MAV_BATTERY_CHARGE_STATE_OK,

  /**
   * Battery state is low, warn and monitor close.
   */
  @MavlinkEnumEntry(2)
  MAV_BATTERY_CHARGE_STATE_LOW,

  /**
   * Battery state is critical, return or abort immediately.
   */
  @MavlinkEnumEntry(3)
  MAV_BATTERY_CHARGE_STATE_CRITICAL,

  /**
   * Battery state is too low for ordinary abort sequence. Perform fastest possible emergency stop to prevent damage.
   */
  @MavlinkEnumEntry(4)
  MAV_BATTERY_CHARGE_STATE_EMERGENCY,

  /**
   * Battery failed, damage unavoidable.
   */
  @MavlinkEnumEntry(5)
  MAV_BATTERY_CHARGE_STATE_FAILED,

  /**
   * Battery is diagnosed to be defective or an error occurred, usage is discouraged / prohibited.
   */
  @MavlinkEnumEntry(6)
  MAV_BATTERY_CHARGE_STATE_UNHEALTHY
}
