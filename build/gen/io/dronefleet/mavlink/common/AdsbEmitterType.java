package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * ADSB classification for the type of vehicle emitting the transponder signal 
 */
@MavlinkEnum
public enum AdsbEmitterType {
  /**
   * null
   */
  @MavlinkEnumEntry(0)
  ADSB_EMITTER_TYPE_NO_INFO,

  /**
   * null
   */
  @MavlinkEnumEntry(1)
  ADSB_EMITTER_TYPE_LIGHT,

  /**
   * null
   */
  @MavlinkEnumEntry(2)
  ADSB_EMITTER_TYPE_SMALL,

  /**
   * null
   */
  @MavlinkEnumEntry(3)
  ADSB_EMITTER_TYPE_LARGE,

  /**
   * null
   */
  @MavlinkEnumEntry(4)
  ADSB_EMITTER_TYPE_HIGH_VORTEX_LARGE,

  /**
   * null
   */
  @MavlinkEnumEntry(5)
  ADSB_EMITTER_TYPE_HEAVY,

  /**
   * null
   */
  @MavlinkEnumEntry(6)
  ADSB_EMITTER_TYPE_HIGHLY_MANUV,

  /**
   * null
   */
  @MavlinkEnumEntry(7)
  ADSB_EMITTER_TYPE_ROTOCRAFT,

  /**
   * null
   */
  @MavlinkEnumEntry(8)
  ADSB_EMITTER_TYPE_UNASSIGNED,

  /**
   * null
   */
  @MavlinkEnumEntry(9)
  ADSB_EMITTER_TYPE_GLIDER,

  /**
   * null
   */
  @MavlinkEnumEntry(10)
  ADSB_EMITTER_TYPE_LIGHTER_AIR,

  /**
   * null
   */
  @MavlinkEnumEntry(11)
  ADSB_EMITTER_TYPE_PARACHUTE,

  /**
   * null
   */
  @MavlinkEnumEntry(12)
  ADSB_EMITTER_TYPE_ULTRA_LIGHT,

  /**
   * null
   */
  @MavlinkEnumEntry(13)
  ADSB_EMITTER_TYPE_UNASSIGNED2,

  /**
   * null
   */
  @MavlinkEnumEntry(14)
  ADSB_EMITTER_TYPE_UAV,

  /**
   * null
   */
  @MavlinkEnumEntry(15)
  ADSB_EMITTER_TYPE_SPACE,

  /**
   * null
   */
  @MavlinkEnumEntry(16)
  ADSB_EMITTER_TYPE_UNASSGINED3,

  /**
   * null
   */
  @MavlinkEnumEntry(17)
  ADSB_EMITTER_TYPE_EMERGENCY_SURFACE,

  /**
   * null
   */
  @MavlinkEnumEntry(18)
  ADSB_EMITTER_TYPE_SERVICE_SURFACE,

  /**
   * null
   */
  @MavlinkEnumEntry(19)
  ADSB_EMITTER_TYPE_POINT_OBSTACLE
}
