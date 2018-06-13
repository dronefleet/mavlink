package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * GPS lataral offset encoding 
 */
@MavlinkEnum
public enum UavionixAdsbOutCfgGpsOffsetLat {
  /**
   * null
   */
  @MavlinkEnumEntry(0)
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_NO_DATA,

  /**
   * null
   */
  @MavlinkEnumEntry(1)
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_LEFT_2M,

  /**
   * null
   */
  @MavlinkEnumEntry(2)
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_LEFT_4M,

  /**
   * null
   */
  @MavlinkEnumEntry(3)
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_LEFT_6M,

  /**
   * null
   */
  @MavlinkEnumEntry(4)
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_RIGHT_0M,

  /**
   * null
   */
  @MavlinkEnumEntry(5)
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_RIGHT_2M,

  /**
   * null
   */
  @MavlinkEnumEntry(6)
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_RIGHT_4M,

  /**
   * null
   */
  @MavlinkEnumEntry(7)
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_RIGHT_6M
}
