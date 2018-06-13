package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Definitions for aircraft size 
 */
@MavlinkEnum
public enum UavionixAdsbOutCfgAircraftSize {
  /**
   * null
   */
  @MavlinkEnumEntry(0)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_NO_DATA,

  /**
   * null
   */
  @MavlinkEnumEntry(1)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L15M_W23M,

  /**
   * null
   */
  @MavlinkEnumEntry(2)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L25M_W28P5M,

  /**
   * null
   */
  @MavlinkEnumEntry(3)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L25_34M,

  /**
   * null
   */
  @MavlinkEnumEntry(4)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L35_33M,

  /**
   * null
   */
  @MavlinkEnumEntry(5)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L35_38M,

  /**
   * null
   */
  @MavlinkEnumEntry(6)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L45_39P5M,

  /**
   * null
   */
  @MavlinkEnumEntry(7)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L45_45M,

  /**
   * null
   */
  @MavlinkEnumEntry(8)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L55_45M,

  /**
   * null
   */
  @MavlinkEnumEntry(9)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L55_52M,

  /**
   * null
   */
  @MavlinkEnumEntry(10)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L65_59P5M,

  /**
   * null
   */
  @MavlinkEnumEntry(11)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L65_67M,

  /**
   * null
   */
  @MavlinkEnumEntry(12)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L75_W72P5M,

  /**
   * null
   */
  @MavlinkEnumEntry(13)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L75_W80M,

  /**
   * null
   */
  @MavlinkEnumEntry(14)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L85_W80M,

  /**
   * null
   */
  @MavlinkEnumEntry(15)
  UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L85_W90M
}
