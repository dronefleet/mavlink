package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Slugs-specific navigation modes. 
 */
@MavlinkEnum
public enum SlugsMode {
  /**
   * No change to SLUGS mode.
   */
  @MavlinkEnumEntry(0)
  SLUGS_MODE_NONE,

  /**
   * Vehicle is in liftoff mode.
   */
  @MavlinkEnumEntry(1)
  SLUGS_MODE_LIFTOFF,

  /**
   * Vehicle is in passthrough mode, being controlled by a pilot.
   */
  @MavlinkEnumEntry(2)
  SLUGS_MODE_PASSTHROUGH,

  /**
   * Vehicle is in waypoint mode, navigating to waypoints.
   */
  @MavlinkEnumEntry(3)
  SLUGS_MODE_WAYPOINT,

  /**
   * Vehicle is executing mid-level commands.
   */
  @MavlinkEnumEntry(4)
  SLUGS_MODE_MID_LEVEL,

  /**
   * Vehicle is returning to the home location.
   */
  @MavlinkEnumEntry(5)
  SLUGS_MODE_RETURNING,

  /**
   * Vehicle is landing.
   */
  @MavlinkEnumEntry(6)
  SLUGS_MODE_LANDING,

  /**
   * Lost connection with vehicle.
   */
  @MavlinkEnumEntry(7)
  SLUGS_MODE_LOST,

  /**
   * Vehicle is in selective passthrough mode, where selected surfaces are being manually controlled.
   */
  @MavlinkEnumEntry(8)
  SLUGS_MODE_SELECTIVE_PASSTHROUGH,

  /**
   * Vehicle is in ISR mode, performing reconaissance at a point specified by ISR_LOCATION message.
   */
  @MavlinkEnumEntry(9)
  SLUGS_MODE_ISR,

  /**
   * Vehicle is patrolling along lines between waypoints.
   */
  @MavlinkEnumEntry(10)
  SLUGS_MODE_LINE_PATROL,

  /**
   * Vehicle is grounded or an error has occurred.
   */
  @MavlinkEnumEntry(11)
  SLUGS_MODE_GROUNDED
}
