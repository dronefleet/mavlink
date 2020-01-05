package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Navigational status of AIS vessel, enum duplicated from AIS standard, 
 * https://gpsd.gitlab.io/gpsd/AIVDM.html 
 */
@MavlinkEnum
public enum AisNavStatus {
    /**
     * Under way using engine. 
     */
    @MavlinkEntryInfo(0)
    UNDER_WAY,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    AIS_NAV_ANCHORED,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    AIS_NAV_UN_COMMANDED,

    /**
     *  
     */
    @MavlinkEntryInfo(3)
    AIS_NAV_RESTRICTED_MANOEUVERABILITY,

    /**
     *  
     */
    @MavlinkEntryInfo(4)
    AIS_NAV_DRAUGHT_CONSTRAINED,

    /**
     *  
     */
    @MavlinkEntryInfo(5)
    AIS_NAV_MOORED,

    /**
     *  
     */
    @MavlinkEntryInfo(6)
    AIS_NAV_AGROUND,

    /**
     *  
     */
    @MavlinkEntryInfo(7)
    AIS_NAV_FISHING,

    /**
     *  
     */
    @MavlinkEntryInfo(8)
    AIS_NAV_SAILING,

    /**
     *  
     */
    @MavlinkEntryInfo(9)
    AIS_NAV_RESERVED_HSC,

    /**
     *  
     */
    @MavlinkEntryInfo(10)
    AIS_NAV_RESERVED_WIG,

    /**
     *  
     */
    @MavlinkEntryInfo(11)
    AIS_NAV_RESERVED_1,

    /**
     *  
     */
    @MavlinkEntryInfo(12)
    AIS_NAV_RESERVED_2,

    /**
     *  
     */
    @MavlinkEntryInfo(13)
    AIS_NAV_RESERVED_3,

    /**
     * Search And Rescue Transponder. 
     */
    @MavlinkEntryInfo(14)
    AIS_NAV_AIS_SART,

    /**
     * Not available (default). 
     */
    @MavlinkEntryInfo(15)
    AIS_NAV_UNKNOWN
}
