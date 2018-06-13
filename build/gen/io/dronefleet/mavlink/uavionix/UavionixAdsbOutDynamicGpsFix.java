package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Status for ADS-B transponder dynamic input 
 */
@MavlinkEnum
public enum UavionixAdsbOutDynamicGpsFix {
  /**
   * null
   */
  @MavlinkEnumEntry(0)
  UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_NONE_0,

  /**
   * null
   */
  @MavlinkEnumEntry(1)
  UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_NONE_1,

  /**
   * null
   */
  @MavlinkEnumEntry(2)
  UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_2D,

  /**
   * null
   */
  @MavlinkEnumEntry(3)
  UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_3D,

  /**
   * null
   */
  @MavlinkEnumEntry(4)
  UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_DGPS,

  /**
   * null
   */
  @MavlinkEnumEntry(5)
  UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_RTK
}
