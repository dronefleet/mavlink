package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Emergency status encoding 
 */
@MavlinkEnum
public enum UavionixAdsbEmergencyStatus {
    /**
     *  
     */
    @MavlinkEntryInfo(0)
    UAVIONIX_ADSB_OUT_NO_EMERGENCY,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    UAVIONIX_ADSB_OUT_GENERAL_EMERGENCY,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    UAVIONIX_ADSB_OUT_LIFEGUARD_EMERGENCY,

    /**
     *  
     */
    @MavlinkEntryInfo(3)
    UAVIONIX_ADSB_OUT_MINIMUM_FUEL_EMERGENCY,

    /**
     *  
     */
    @MavlinkEntryInfo(4)
    UAVIONIX_ADSB_OUT_NO_COMM_EMERGENCY,

    /**
     *  
     */
    @MavlinkEntryInfo(5)
    UAVIONIX_ADSB_OUT_UNLAWFUL_INTERFERANCE_EMERGENCY,

    /**
     *  
     */
    @MavlinkEntryInfo(6)
    UAVIONIX_ADSB_OUT_DOWNED_AIRCRAFT_EMERGENCY,

    /**
     *  
     */
    @MavlinkEntryInfo(7)
    UAVIONIX_ADSB_OUT_RESERVED
}
