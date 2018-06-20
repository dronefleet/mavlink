package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Enumeration for low battery states. 
 */
@MavlinkEnum
public enum MavBatteryChargeState {
  /**
   * Low battery state is not provided
   */
  @MavlinkEntryInfo(0)
  MAV_BATTERY_CHARGE_STATE_UNDEFINED,

  /**
   * Battery is not in low state. Normal operation.
   */
  @MavlinkEntryInfo(1)
  MAV_BATTERY_CHARGE_STATE_OK,

  /**
   * Battery state is low, warn and monitor close.
   */
  @MavlinkEntryInfo(2)
  MAV_BATTERY_CHARGE_STATE_LOW,

  /**
   * Battery state is critical, return or abort immediately.
   */
  @MavlinkEntryInfo(3)
  MAV_BATTERY_CHARGE_STATE_CRITICAL,

  /**
   * Battery state is too low for ordinary abort sequence. Perform fastest possible emergency stop to prevent damage.
   */
  @MavlinkEntryInfo(4)
  MAV_BATTERY_CHARGE_STATE_EMERGENCY,

  /**
   * Battery failed, damage unavoidable.
   */
  @MavlinkEntryInfo(5)
  MAV_BATTERY_CHARGE_STATE_FAILED,

  /**
   * Battery is diagnosed to be defective or an error occurred, usage is discouraged / prohibited.
   */
  @MavlinkEntryInfo(6)
  MAV_BATTERY_CHARGE_STATE_UNHEALTHY
}
