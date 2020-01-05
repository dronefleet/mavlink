package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * These flags indicate status such as data validity of each data source. Set = data valid 
 */
@MavlinkEnum
public enum AdsbFlags {
    /**
     *  
     */
    @MavlinkEntryInfo(1)
    ADSB_FLAGS_VALID_COORDS,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    ADSB_FLAGS_VALID_ALTITUDE,

    /**
     *  
     */
    @MavlinkEntryInfo(4)
    ADSB_FLAGS_VALID_HEADING,

    /**
     *  
     */
    @MavlinkEntryInfo(8)
    ADSB_FLAGS_VALID_VELOCITY,

    /**
     *  
     */
    @MavlinkEntryInfo(16)
    ADSB_FLAGS_VALID_CALLSIGN,

    /**
     *  
     */
    @MavlinkEntryInfo(32)
    ADSB_FLAGS_VALID_SQUAWK,

    /**
     *  
     */
    @MavlinkEntryInfo(64)
    ADSB_FLAGS_SIMULATED,

    /**
     *  
     */
    @MavlinkEntryInfo(128)
    ADSB_FLAGS_VERTICAL_VELOCITY_VALID,

    /**
     *  
     */
    @MavlinkEntryInfo(256)
    ADSB_FLAGS_BARO_VALID,

    /**
     *  
     */
    @MavlinkEntryInfo(32768)
    ADSB_FLAGS_SOURCE_UAT
}
