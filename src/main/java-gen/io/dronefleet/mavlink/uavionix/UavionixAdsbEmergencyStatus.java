package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Emergency status encoding 
 */
@MavlinkEnum
public enum UavionixAdsbEmergencyStatus {
  /**
   * null
   */
  @MavlinkEnumEntry(0)
  UAVIONIX_ADSB_OUT_NO_EMERGENCY,

  /**
   * null
   */
  @MavlinkEnumEntry(1)
  UAVIONIX_ADSB_OUT_GENERAL_EMERGENCY,

  /**
   * null
   */
  @MavlinkEnumEntry(2)
  UAVIONIX_ADSB_OUT_LIFEGUARD_EMERGENCY,

  /**
   * null
   */
  @MavlinkEnumEntry(3)
  UAVIONIX_ADSB_OUT_MINIMUM_FUEL_EMERGENCY,

  /**
   * null
   */
  @MavlinkEnumEntry(4)
  UAVIONIX_ADSB_OUT_NO_COMM_EMERGENCY,

  /**
   * null
   */
  @MavlinkEnumEntry(5)
  UAVIONIX_ADSB_OUT_UNLAWFUL_INTERFERANCE_EMERGENCY,

  /**
   * null
   */
  @MavlinkEnumEntry(6)
  UAVIONIX_ADSB_OUT_DOWNED_AIRCRAFT_EMERGENCY,

  /**
   * null
   */
  @MavlinkEnumEntry(7)
  UAVIONIX_ADSB_OUT_RESERVED
}
