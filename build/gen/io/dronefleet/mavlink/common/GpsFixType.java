package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Type of GPS fix 
 */
@MavlinkEnum
public enum GpsFixType {
  /**
   * No GPS connected
   */
  @MavlinkEnumEntry(0)
  GPS_FIX_TYPE_NO_GPS,

  /**
   * No position information, GPS is connected
   */
  @MavlinkEnumEntry(1)
  GPS_FIX_TYPE_NO_FIX,

  /**
   * 2D position
   */
  @MavlinkEnumEntry(2)
  GPS_FIX_TYPE_2D_FIX,

  /**
   * 3D position
   */
  @MavlinkEnumEntry(3)
  GPS_FIX_TYPE_3D_FIX,

  /**
   * DGPS/SBAS aided 3D position
   */
  @MavlinkEnumEntry(4)
  GPS_FIX_TYPE_DGPS,

  /**
   * RTK float, 3D position
   */
  @MavlinkEnumEntry(5)
  GPS_FIX_TYPE_RTK_FLOAT,

  /**
   * RTK Fixed, 3D position
   */
  @MavlinkEnumEntry(6)
  GPS_FIX_TYPE_RTK_FIXED,

  /**
   * Static fixed, typically used for base stations
   */
  @MavlinkEnumEntry(7)
  GPS_FIX_TYPE_STATIC,

  /**
   * PPP, 3D position.
   */
  @MavlinkEnumEntry(8)
  GPS_FIX_TYPE_PPP
}
