package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * A mapping of sub flight modes for custom_mode field of heartbeat. 
 */
@MavlinkEnum
public enum SubMode {
    /**
     *  
     */
    @MavlinkEntryInfo(0)
    SUB_MODE_STABILIZE,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    SUB_MODE_ACRO,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    SUB_MODE_ALT_HOLD,

    /**
     *  
     */
    @MavlinkEntryInfo(3)
    SUB_MODE_AUTO,

    /**
     *  
     */
    @MavlinkEntryInfo(4)
    SUB_MODE_GUIDED,

    /**
     *  
     */
    @MavlinkEntryInfo(7)
    SUB_MODE_CIRCLE,

    /**
     *  
     */
    @MavlinkEntryInfo(9)
    SUB_MODE_SURFACE,

    /**
     *  
     */
    @MavlinkEntryInfo(16)
    SUB_MODE_POSHOLD,

    /**
     *  
     */
    @MavlinkEntryInfo(19)
    SUB_MODE_MANUAL
}
