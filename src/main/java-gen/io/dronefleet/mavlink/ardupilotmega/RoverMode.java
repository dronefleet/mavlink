package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * A mapping of rover flight modes for custom_mode field of heartbeat. 
 */
@MavlinkEnum
public enum RoverMode {
    /**
     *  
     */
    @MavlinkEntryInfo(0)
    ROVER_MODE_MANUAL,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    ROVER_MODE_ACRO,

    /**
     *  
     */
    @MavlinkEntryInfo(3)
    ROVER_MODE_STEERING,

    /**
     *  
     */
    @MavlinkEntryInfo(4)
    ROVER_MODE_HOLD,

    /**
     *  
     */
    @MavlinkEntryInfo(5)
    ROVER_MODE_LOITER,

    /**
     *  
     */
    @MavlinkEntryInfo(6)
    ROVER_MODE_FOLLOW,

    /**
     *  
     */
    @MavlinkEntryInfo(7)
    ROVER_MODE_SIMPLE,

    /**
     *  
     */
    @MavlinkEntryInfo(10)
    ROVER_MODE_AUTO,

    /**
     *  
     */
    @MavlinkEntryInfo(11)
    ROVER_MODE_RTL,

    /**
     *  
     */
    @MavlinkEntryInfo(12)
    ROVER_MODE_SMART_RTL,

    /**
     *  
     */
    @MavlinkEntryInfo(15)
    ROVER_MODE_GUIDED,

    /**
     *  
     */
    @MavlinkEntryInfo(16)
    ROVER_MODE_INITIALIZING
}
