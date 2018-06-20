package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * ADSB classification for the type of vehicle emitting the transponder signal 
 */
@MavlinkEnum
public enum AdsbEmitterType {
  /**
   * null
   */
  @MavlinkEntryInfo(0)
  ADSB_EMITTER_TYPE_NO_INFO,

  /**
   * null
   */
  @MavlinkEntryInfo(1)
  ADSB_EMITTER_TYPE_LIGHT,

  /**
   * null
   */
  @MavlinkEntryInfo(2)
  ADSB_EMITTER_TYPE_SMALL,

  /**
   * null
   */
  @MavlinkEntryInfo(3)
  ADSB_EMITTER_TYPE_LARGE,

  /**
   * null
   */
  @MavlinkEntryInfo(4)
  ADSB_EMITTER_TYPE_HIGH_VORTEX_LARGE,

  /**
   * null
   */
  @MavlinkEntryInfo(5)
  ADSB_EMITTER_TYPE_HEAVY,

  /**
   * null
   */
  @MavlinkEntryInfo(6)
  ADSB_EMITTER_TYPE_HIGHLY_MANUV,

  /**
   * null
   */
  @MavlinkEntryInfo(7)
  ADSB_EMITTER_TYPE_ROTOCRAFT,

  /**
   * null
   */
  @MavlinkEntryInfo(8)
  ADSB_EMITTER_TYPE_UNASSIGNED,

  /**
   * null
   */
  @MavlinkEntryInfo(9)
  ADSB_EMITTER_TYPE_GLIDER,

  /**
   * null
   */
  @MavlinkEntryInfo(10)
  ADSB_EMITTER_TYPE_LIGHTER_AIR,

  /**
   * null
   */
  @MavlinkEntryInfo(11)
  ADSB_EMITTER_TYPE_PARACHUTE,

  /**
   * null
   */
  @MavlinkEntryInfo(12)
  ADSB_EMITTER_TYPE_ULTRA_LIGHT,

  /**
   * null
   */
  @MavlinkEntryInfo(13)
  ADSB_EMITTER_TYPE_UNASSIGNED2,

  /**
   * null
   */
  @MavlinkEntryInfo(14)
  ADSB_EMITTER_TYPE_UAV,

  /**
   * null
   */
  @MavlinkEntryInfo(15)
  ADSB_EMITTER_TYPE_SPACE,

  /**
   * null
   */
  @MavlinkEntryInfo(16)
  ADSB_EMITTER_TYPE_UNASSGINED3,

  /**
   * null
   */
  @MavlinkEntryInfo(17)
  ADSB_EMITTER_TYPE_EMERGENCY_SURFACE,

  /**
   * null
   */
  @MavlinkEntryInfo(18)
  ADSB_EMITTER_TYPE_SERVICE_SURFACE,

  /**
   * null
   */
  @MavlinkEntryInfo(19)
  ADSB_EMITTER_TYPE_POINT_OBSTACLE
}
