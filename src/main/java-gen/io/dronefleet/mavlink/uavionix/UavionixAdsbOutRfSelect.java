package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Transceiver RF control flags for ADS-B transponder dynamic reports 
 */
@MavlinkEnum
public enum UavionixAdsbOutRfSelect {
  /**
   * null
   */
  @MavlinkEntryInfo(0)
  UAVIONIX_ADSB_OUT_RF_SELECT_STANDBY,

  /**
   * null
   */
  @MavlinkEntryInfo(1)
  UAVIONIX_ADSB_OUT_RF_SELECT_RX_ENABLED,

  /**
   * null
   */
  @MavlinkEntryInfo(2)
  UAVIONIX_ADSB_OUT_RF_SELECT_TX_ENABLED
}
