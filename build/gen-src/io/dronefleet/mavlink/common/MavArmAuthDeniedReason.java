package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum MavArmAuthDeniedReason {
  /**
   * Not a specific reason
   */
  @MavlinkEnumEntry(0)
  MAV_ARM_AUTH_DENIED_REASON_GENERIC,

  /**
   * Authorizer will send the error as string to GCS
   */
  @MavlinkEnumEntry(1)
  MAV_ARM_AUTH_DENIED_REASON_NONE,

  /**
   * At least one waypoint have a invalid value
   */
  @MavlinkEnumEntry(2)
  MAV_ARM_AUTH_DENIED_REASON_INVALID_WAYPOINT,

  /**
   * Timeout in the authorizer process(in case it depends on network)
   */
  @MavlinkEnumEntry(3)
  MAV_ARM_AUTH_DENIED_REASON_TIMEOUT,

  /**
   * Airspace of the mission in use by another vehicle, second result parameter can have the waypoint id that caused it to be denied.
   */
  @MavlinkEnumEntry(4)
  MAV_ARM_AUTH_DENIED_REASON_AIRSPACE_IN_USE,

  /**
   * Weather is not good to fly
   */
  @MavlinkEnumEntry(5)
  MAV_ARM_AUTH_DENIED_REASON_BAD_WEATHER
}
