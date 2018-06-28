package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * ADSB classification for the type of vehicle emitting the transponder signal 
 */
@MavlinkEnum
public enum AdsbEmitterType {
    /**
     *  
     */
    @MavlinkEntryInfo(0)
    ADSB_EMITTER_TYPE_NO_INFO,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    ADSB_EMITTER_TYPE_LIGHT,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    ADSB_EMITTER_TYPE_SMALL,

    /**
     *  
     */
    @MavlinkEntryInfo(3)
    ADSB_EMITTER_TYPE_LARGE,

    /**
     *  
     */
    @MavlinkEntryInfo(4)
    ADSB_EMITTER_TYPE_HIGH_VORTEX_LARGE,

    /**
     *  
     */
    @MavlinkEntryInfo(5)
    ADSB_EMITTER_TYPE_HEAVY,

    /**
     *  
     */
    @MavlinkEntryInfo(6)
    ADSB_EMITTER_TYPE_HIGHLY_MANUV,

    /**
     *  
     */
    @MavlinkEntryInfo(7)
    ADSB_EMITTER_TYPE_ROTOCRAFT,

    /**
     *  
     */
    @MavlinkEntryInfo(8)
    ADSB_EMITTER_TYPE_UNASSIGNED,

    /**
     *  
     */
    @MavlinkEntryInfo(9)
    ADSB_EMITTER_TYPE_GLIDER,

    /**
     *  
     */
    @MavlinkEntryInfo(10)
    ADSB_EMITTER_TYPE_LIGHTER_AIR,

    /**
     *  
     */
    @MavlinkEntryInfo(11)
    ADSB_EMITTER_TYPE_PARACHUTE,

    /**
     *  
     */
    @MavlinkEntryInfo(12)
    ADSB_EMITTER_TYPE_ULTRA_LIGHT,

    /**
     *  
     */
    @MavlinkEntryInfo(13)
    ADSB_EMITTER_TYPE_UNASSIGNED2,

    /**
     *  
     */
    @MavlinkEntryInfo(14)
    ADSB_EMITTER_TYPE_UAV,

    /**
     *  
     */
    @MavlinkEntryInfo(15)
    ADSB_EMITTER_TYPE_SPACE,

    /**
     *  
     */
    @MavlinkEntryInfo(16)
    ADSB_EMITTER_TYPE_UNASSGINED3,

    /**
     *  
     */
    @MavlinkEntryInfo(17)
    ADSB_EMITTER_TYPE_EMERGENCY_SURFACE,

    /**
     *  
     */
    @MavlinkEntryInfo(18)
    ADSB_EMITTER_TYPE_SERVICE_SURFACE,

    /**
     *  
     */
    @MavlinkEntryInfo(19)
    ADSB_EMITTER_TYPE_POINT_OBSTACLE
}
