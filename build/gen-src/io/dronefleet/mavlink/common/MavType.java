package io.dronefleet.mavlink.common;

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
   * Tricopter
   */
  @MavlinkEnumEntry(15)
  MAV_TYPE_TRICOPTER,

  /**
   * Flapping wing
   */
  @MavlinkEnumEntry(16)
  MAV_TYPE_FLAPPING_WING,

  /**
   * Kite
   */
  @MavlinkEnumEntry(17)
  MAV_TYPE_KITE,

  /**
   * Onboard companion controller
   */
  @MavlinkEnumEntry(18)
  MAV_TYPE_ONBOARD_CONTROLLER,

  /**
   * Two-rotor VTOL using control surfaces in vertical operation in addition. Tailsitter.
   */
  @MavlinkEnumEntry(19)
  MAV_TYPE_VTOL_DUOROTOR,

  /**
   * Quad-rotor VTOL using a V-shaped quad config in vertical operation. Tailsitter.
   */
  @MavlinkEnumEntry(20)
  MAV_TYPE_VTOL_QUADROTOR,

  /**
   * Tiltrotor VTOL
   */
  @MavlinkEnumEntry(21)
  MAV_TYPE_VTOL_TILTROTOR,

  /**
   * VTOL reserved 2
   */
  @MavlinkEnumEntry(22)
  MAV_TYPE_VTOL_RESERVED2,

  /**
   * VTOL reserved 3
   */
  @MavlinkEnumEntry(23)
  MAV_TYPE_VTOL_RESERVED3,

  /**
   * VTOL reserved 4
   */
  @MavlinkEnumEntry(24)
  MAV_TYPE_VTOL_RESERVED4,

  /**
   * VTOL reserved 5
   */
  @MavlinkEnumEntry(25)
  MAV_TYPE_VTOL_RESERVED5,

  /**
   * Onboard gimbal
   */
  @MavlinkEnumEntry(26)
  MAV_TYPE_GIMBAL,

  /**
   * Onboard ADSB peripheral
   */
  @MavlinkEnumEntry(27)
  MAV_TYPE_ADSB,

  /**
   * Steerable, nonrigid airfoil
   */
  @MavlinkEnumEntry(28)
  MAV_TYPE_PARAFOIL,

  /**
   * Dodecarotor
   */
  @MavlinkEnumEntry(29)
  MAV_TYPE_DODECAROTOR,

  /**
   * Camera
   */
  @MavlinkEnumEntry(30)
  MAV_TYPE_CAMERA,

  /**
   * Charging station
   */
  @MavlinkEnumEntry(31)
  MAV_TYPE_CHARGING_STATION,

  /**
   * Onboard FLARM collision avoidance system
   */
  @MavlinkEnumEntry(32)
  MAV_TYPE_FLARM
}
