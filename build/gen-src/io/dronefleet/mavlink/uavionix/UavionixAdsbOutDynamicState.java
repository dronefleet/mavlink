package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * State flags for ADS-B transponder dynamic report 
 */
@MavlinkEnum
public enum UavionixAdsbOutDynamicState {
  /**
   * null
   */
  @MavlinkEnumEntry(1)
  UAVIONIX_ADSB_OUT_DYNAMIC_STATE_INTENT_CHANGE,

  /**
   * null
   */
  @MavlinkEnumEntry(2)
  UAVIONIX_ADSB_OUT_DYNAMIC_STATE_AUTOPILOT_ENABLED,

  /**
   * null
   */
  @MavlinkEnumEntry(4)
  UAVIONIX_ADSB_OUT_DYNAMIC_STATE_NICBARO_CROSSCHECKED,

  /**
   * null
   */
  @MavlinkEnumEntry(8)
  UAVIONIX_ADSB_OUT_DYNAMIC_STATE_ON_GROUND,

  /**
   * null
   */
  @MavlinkEnumEntry(16)
  UAVIONIX_ADSB_OUT_DYNAMIC_STATE_IDENT
}
