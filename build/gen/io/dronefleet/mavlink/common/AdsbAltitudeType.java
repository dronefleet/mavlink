package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Enumeration of the ADSB altimeter types 
 */
@MavlinkEnum
public enum AdsbAltitudeType {
  /**
   * Altitude reported from a Baro source using QNH reference
   */
  @MavlinkEnumEntry(0)
  ADSB_ALTITUDE_TYPE_PRESSURE_QNH,

  /**
   * Altitude reported from a GNSS source
   */
  @MavlinkEnumEntry(1)
  ADSB_ALTITUDE_TYPE_GEOMETRIC
}
