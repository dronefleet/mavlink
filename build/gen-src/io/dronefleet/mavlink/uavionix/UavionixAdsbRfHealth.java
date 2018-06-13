package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Status flags for ADS-B transponder dynamic output 
 */
@MavlinkEnum
public enum UavionixAdsbRfHealth {
  /**
   * null
   */
  @MavlinkEnumEntry(0)
  UAVIONIX_ADSB_RF_HEALTH_INITIALIZING,

  /**
   * null
   */
  @MavlinkEnumEntry(1)
  UAVIONIX_ADSB_RF_HEALTH_OK,

  /**
   * null
   */
  @MavlinkEnumEntry(2)
  UAVIONIX_ADSB_RF_HEALTH_FAIL_TX,

  /**
   * null
   */
  @MavlinkEnumEntry(16)
  UAVIONIX_ADSB_RF_HEALTH_FAIL_RX
}
