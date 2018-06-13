package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Transceiver RF control flags for ADS-B transponder dynamic reports 
 */
@MavlinkEnum
public enum UavionixAdsbOutRfSelect {
  /**
   * null
   */
  @MavlinkEnumEntry(0)
  UAVIONIX_ADSB_OUT_RF_SELECT_STANDBY,

  /**
   * null
   */
  @MavlinkEnumEntry(1)
  UAVIONIX_ADSB_OUT_RF_SELECT_RX_ENABLED,

  /**
   * null
   */
  @MavlinkEnumEntry(2)
  UAVIONIX_ADSB_OUT_RF_SELECT_TX_ENABLED
}
