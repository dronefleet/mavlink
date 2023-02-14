package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * A mapping of plane flight modes for custom_mode field of heartbeat. 
 */
@MavlinkEnum
public enum PlaneMode {
    /**
     *  
     */
    @MavlinkEntryInfo(0)
    PLANE_MODE_MANUAL,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    PLANE_MODE_CIRCLE,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    PLANE_MODE_STABILIZE,

    /**
     *  
     */
    @MavlinkEntryInfo(3)
    PLANE_MODE_TRAINING,

    /**
     *  
     */
    @MavlinkEntryInfo(4)
    PLANE_MODE_ACRO,

    /**
     *  
     */
    @MavlinkEntryInfo(5)
    PLANE_MODE_FLY_BY_WIRE_A,

    /**
     *  
     */
    @MavlinkEntryInfo(6)
    PLANE_MODE_FLY_BY_WIRE_B,

    /**
     *  
     */
    @MavlinkEntryInfo(7)
    PLANE_MODE_CRUISE,

    /**
     *  
     */
    @MavlinkEntryInfo(8)
    PLANE_MODE_AUTOTUNE,

    /**
     *  
     */
    @MavlinkEntryInfo(10)
    PLANE_MODE_AUTO,

    /**
     *  
     */
    @MavlinkEntryInfo(11)
    PLANE_MODE_RTL,

    /**
     *  
     */
    @MavlinkEntryInfo(12)
    PLANE_MODE_LOITER,

    /**
     *  
     */
    @MavlinkEntryInfo(13)
    PLANE_MODE_TAKEOFF,

    /**
     *  
     */
    @MavlinkEntryInfo(14)
    PLANE_MODE_AVOID_ADSB,

    /**
     *  
     */
    @MavlinkEntryInfo(15)
    PLANE_MODE_GUIDED,

    /**
     *  
     */
    @MavlinkEntryInfo(16)
    PLANE_MODE_INITIALIZING,

    /**
     *  
     */
    @MavlinkEntryInfo(17)
    PLANE_MODE_QSTABILIZE,

    /**
     *  
     */
    @MavlinkEntryInfo(18)
    PLANE_MODE_QHOVER,

    /**
     *  
     */
    @MavlinkEntryInfo(19)
    PLANE_MODE_QLOITER,

    /**
     *  
     */
    @MavlinkEntryInfo(20)
    PLANE_MODE_QLAND,

    /**
     *  
     */
    @MavlinkEntryInfo(21)
    PLANE_MODE_QRTL,

    /**
     *  
     */
    @MavlinkEntryInfo(22)
    PLANE_MODE_QAUTOTUNE,

    /**
     *  
     */
    @MavlinkEntryInfo(23)
    PLANE_MODE_QACRO,

    /**
     *  
     */
    @MavlinkEntryInfo(24)
    PLANE_MODE_THERMAL
}
