package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * These defines are predefined OR-combined mode flags. There is no need to use values from this 
 * enum, but it simplifies the use of the mode flags. Note that manual input is enabled in all modes 
 * as a safety override. 
 */
@MavlinkEnum
public enum MavMode {
  /**
   * System is not ready to fly, booting, calibrating, etc. No flag is set.
   */
  @MavlinkEnumEntry(0)
  MAV_MODE_PREFLIGHT,

  /**
   * System is allowed to be active, under assisted RC control.
   */
  @MavlinkEnumEntry(80)
  MAV_MODE_STABILIZE_DISARMED,

  /**
   * System is allowed to be active, under assisted RC control.
   */
  @MavlinkEnumEntry(208)
  MAV_MODE_STABILIZE_ARMED,

  /**
   * System is allowed to be active, under manual (RC) control, no stabilization
   */
  @MavlinkEnumEntry(64)
  MAV_MODE_MANUAL_DISARMED,

  /**
   * System is allowed to be active, under manual (RC) control, no stabilization
   */
  @MavlinkEnumEntry(192)
  MAV_MODE_MANUAL_ARMED,

  /**
   * System is allowed to be active, under autonomous control, manual setpoint
   */
  @MavlinkEnumEntry(88)
  MAV_MODE_GUIDED_DISARMED,

  /**
   * System is allowed to be active, under autonomous control, manual setpoint
   */
  @MavlinkEnumEntry(216)
  MAV_MODE_GUIDED_ARMED,

  /**
   * System is allowed to be active, under autonomous control and navigation (the trajectory is decided onboard and not pre-programmed by waypoints)
   */
  @MavlinkEnumEntry(92)
  MAV_MODE_AUTO_DISARMED,

  /**
   * System is allowed to be active, under autonomous control and navigation (the trajectory is decided onboard and not pre-programmed by waypoints)
   */
  @MavlinkEnumEntry(220)
  MAV_MODE_AUTO_ARMED,

  /**
   * UNDEFINED mode. This solely depends on the autopilot - use with caution, intended for developers only.
   */
  @MavlinkEnumEntry(66)
  MAV_MODE_TEST_DISARMED,

  /**
   * UNDEFINED mode. This solely depends on the autopilot - use with caution, intended for developers only.
   */
  @MavlinkEnumEntry(194)
  MAV_MODE_TEST_ARMED
}
