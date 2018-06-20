package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Definitions for aircraft size 
 */
@MavlinkEnum
public enum UavionixAdsbOutCfgAircraftSize {
  /**
   * null
   */
  @MavlinkEntryInfo(0)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_NO_DATA,

  /**
   * null
   */
  @MavlinkEntryInfo(1)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L15M_W23M,

  /**
   * null
   */
  @MavlinkEntryInfo(2)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L25M_W28P5M,

  /**
   * null
   */
  @MavlinkEntryInfo(3)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L25_34M,

  /**
   * null
   */
  @MavlinkEntryInfo(4)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L35_33M,

  /**
   * null
   */
  @MavlinkEntryInfo(5)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L35_38M,

  /**
   * null
   */
  @MavlinkEntryInfo(6)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L45_39P5M,

  /**
   * null
   */
  @MavlinkEntryInfo(7)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L45_45M,

  /**
   * null
   */
  @MavlinkEntryInfo(8)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L55_45M,

  /**
   * null
   */
  @MavlinkEntryInfo(9)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L55_52M,

  /**
   * null
   */
  @MavlinkEntryInfo(10)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L65_59P5M,

  /**
   * null
   */
  @MavlinkEntryInfo(11)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L65_67M,

  /**
   * null
   */
  @MavlinkEntryInfo(12)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L75_W72P5M,

  /**
   * null
   */
  @MavlinkEntryInfo(13)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L75_W80M,

  /**
   * null
   */
  @MavlinkEntryInfo(14)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L85_W80M,

  /**
   * null
   */
  @MavlinkEntryInfo(15)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L85_W90M
}
