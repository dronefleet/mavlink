package io.dronefleet.mavlink.minimal;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum MavType {
  /**
   * Generic micro air vehicle.
   */
  @MavlinkEnumEntry(0)
  MAV_TYPE_GENERIC,

  /**
   * Fixed wing aircraft.
   */
  @MavlinkEnumEntry(1)
  MAV_TYPE_FIXED_WING,

  /**
   * Quadrotor
   */
  @MavlinkEnumEntry(2)
  MAV_TYPE_QUADROTOR,

  /**
   * Coaxial helicopter
   */
  @MavlinkEnumEntry(3)
  MAV_TYPE_COAXIAL,

  /**
   * Normal helicopter with tail rotor.
   */
  @MavlinkEnumEntry(4)
  MAV_TYPE_HELICOPTER,

  /**
   * Ground installation
   */
  @MavlinkEnumEntry(5)
  MAV_TYPE_ANTENNA_TRACKER,

  /**
   * Operator control unit / ground control station
   */
  @MavlinkEnumEntry(6)
  MAV_TYPE_GCS,

  /**
   * Airship, controlled
   */
  @MavlinkEnumEntry(7)
  MAV_TYPE_AIRSHIP,

  /**
   * Free balloon, uncontrolled
   */
  @MavlinkEnumEntry(8)
  MAV_TYPE_FREE_BALLOON,

  /**
   * Rocket
   */
  @MavlinkEnumEntry(9)
  MAV_TYPE_ROCKET,

  /**
   * Ground rover
   */
  @MavlinkEnumEntry(10)
  MAV_TYPE_GROUND_ROVER,

  /**
   * Surface vessel, boat, ship
   */
  @MavlinkEnumEntry(11)
  MAV_TYPE_SURFACE_BOAT,

  /**
   * Submarine
   */
  @MavlinkEnumEntry(12)
  MAV_TYPE_SUBMARINE,

  /**
   * Hexarotor
   */
  @MavlinkEnumEntry(13)
  MAV_TYPE_HEXAROTOR,

  /**
   * Octorotor
   */
  @MavlinkEnumEntry(14)
  MAV_TYPE_OCTOROTOR,

  /**
   * Octorotor
   */
  @MavlinkEnumEntry(15)
  MAV_TYPE_TRICOPTER,

  /**
   * Flapping wing
   */
  @MavlinkEnumEntry(16)
  MAV_TYPE_FLAPPING_WING
}
