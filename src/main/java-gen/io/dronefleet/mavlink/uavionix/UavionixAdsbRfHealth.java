package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Status flags for ADS-B transponder dynamic output 
 */
@MavlinkEnum
public enum UavionixAdsbRfHealth {
    /**
     *  
     */
    @MavlinkEntryInfo(0)
    UAVIONIX_ADSB_RF_HEALTH_INITIALIZING,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    UAVIONIX_ADSB_RF_HEALTH_OK,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    UAVIONIX_ADSB_RF_HEALTH_FAIL_TX,

    /**
     *  
     */
    @MavlinkEntryInfo(16)
    UAVIONIX_ADSB_RF_HEALTH_FAIL_RX
}
