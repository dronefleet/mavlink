package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * A mapping of copter flight modes for custom_mode field of heartbeat. 
 */
@MavlinkEnum
public enum CopterMode {
    /**
     *  
     */
    @MavlinkEntryInfo(0)
    COPTER_MODE_STABILIZE,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    COPTER_MODE_ACRO,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    COPTER_MODE_ALT_HOLD,

    /**
     *  
     */
    @MavlinkEntryInfo(3)
    COPTER_MODE_AUTO,

    /**
     *  
     */
    @MavlinkEntryInfo(4)
    COPTER_MODE_GUIDED,

    /**
     *  
     */
    @MavlinkEntryInfo(5)
    COPTER_MODE_LOITER,

    /**
     *  
     */
    @MavlinkEntryInfo(6)
    COPTER_MODE_RTL,

    /**
     *  
     */
    @MavlinkEntryInfo(7)
    COPTER_MODE_CIRCLE,

    /**
     *  
     */
    @MavlinkEntryInfo(9)
    COPTER_MODE_LAND,

    /**
     *  
     */
    @MavlinkEntryInfo(11)
    COPTER_MODE_DRIFT,

    /**
     *  
     */
    @MavlinkEntryInfo(13)
    COPTER_MODE_SPORT,

    /**
     *  
     */
    @MavlinkEntryInfo(14)
    COPTER_MODE_FLIP,

    /**
     *  
     */
    @MavlinkEntryInfo(15)
    COPTER_MODE_AUTOTUNE,

    /**
     *  
     */
    @MavlinkEntryInfo(16)
    COPTER_MODE_POSHOLD,

    /**
     *  
     */
    @MavlinkEntryInfo(17)
    COPTER_MODE_BRAKE,

    /**
     *  
     */
    @MavlinkEntryInfo(18)
    COPTER_MODE_THROW,

    /**
     *  
     */
    @MavlinkEntryInfo(19)
    COPTER_MODE_AVOID_ADSB,

    /**
     *  
     */
    @MavlinkEntryInfo(20)
    COPTER_MODE_GUIDED_NOGPS,

    /**
     *  
     */
    @MavlinkEntryInfo(21)
    COPTER_MODE_SMART_RTL,

    /**
     *  
     */
    @MavlinkEntryInfo(22)
    COPTER_MODE_FLOWHOLD,

    /**
     *  
     */
    @MavlinkEntryInfo(23)
    COPTER_MODE_FOLLOW,

    /**
     *  
     */
    @MavlinkEntryInfo(24)
    COPTER_MODE_ZIGZAG,

    /**
     *  
     */
    @MavlinkEntryInfo(25)
    COPTER_MODE_SYSTEMID,

    /**
     *  
     */
    @MavlinkEntryInfo(26)
    COPTER_MODE_AUTOROTATE,

    /**
     *  
     */
    @MavlinkEntryInfo(27)
    COPTER_MODE_AUTO_RTL
}
