package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum MavArmAuthDeniedReason {
  /**
   * Not a specific reason
   */
  @MavlinkEntryInfo(0)
  MAV_ARM_AUTH_DENIED_REASON_GENERIC,

  /**
   * Authorizer will send the error as string to GCS
   */
  @MavlinkEntryInfo(1)
  MAV_ARM_AUTH_DENIED_REASON_NONE,

  /**
   * At least one waypoint have a invalid value
   */
  @MavlinkEntryInfo(2)
  MAV_ARM_AUTH_DENIED_REASON_INVALID_WAYPOINT,

  /**
   * Timeout in the authorizer process(in case it depends on network)
   */
  @MavlinkEntryInfo(3)
  MAV_ARM_AUTH_DENIED_REASON_TIMEOUT,

  /**
   * Airspace of the mission in use by another vehicle, second result parameter can have the waypoint id that caused it to be denied.
   */
  @MavlinkEntryInfo(4)
  MAV_ARM_AUTH_DENIED_REASON_AIRSPACE_IN_USE,

  /**
   * Weather is not good to fly
   */
  @MavlinkEntryInfo(5)
  MAV_ARM_AUTH_DENIED_REASON_BAD_WEATHER
}
