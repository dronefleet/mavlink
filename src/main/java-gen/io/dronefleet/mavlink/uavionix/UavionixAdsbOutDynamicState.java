package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * State flags for ADS-B transponder dynamic report 
 */
@MavlinkEnum
public enum UavionixAdsbOutDynamicState {
    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    UAVIONIX_ADSB_OUT_DYNAMIC_STATE_INTENT_CHANGE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    UAVIONIX_ADSB_OUT_DYNAMIC_STATE_AUTOPILOT_ENABLED,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    UAVIONIX_ADSB_OUT_DYNAMIC_STATE_NICBARO_CROSSCHECKED,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8)
    UAVIONIX_ADSB_OUT_DYNAMIC_STATE_ON_GROUND,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16)
    UAVIONIX_ADSB_OUT_DYNAMIC_STATE_IDENT
}
