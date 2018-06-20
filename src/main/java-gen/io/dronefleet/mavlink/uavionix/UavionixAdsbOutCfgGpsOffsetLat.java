package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * GPS lataral offset encoding 
 */
@MavlinkEnum
public enum UavionixAdsbOutCfgGpsOffsetLat {
  /**
   * null
   */
  @MavlinkEntryInfo(0)
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_NO_DATA,

  /**
   * null
   */
  @MavlinkEntryInfo(1)
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_LEFT_2M,

  /**
   * null
   */
  @MavlinkEntryInfo(2)
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_LEFT_4M,

  /**
   * null
   */
  @MavlinkEntryInfo(3)
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_LEFT_6M,

  /**
   * null
   */
  @MavlinkEntryInfo(4)
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_RIGHT_0M,

  /**
   * null
   */
  @MavlinkEntryInfo(5)
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_RIGHT_2M,

  /**
   * null
   */
  @MavlinkEntryInfo(6)
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_RIGHT_4M,

  /**
   * null
   */
  @MavlinkEntryInfo(7)
  UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LAT_RIGHT_6M
}
