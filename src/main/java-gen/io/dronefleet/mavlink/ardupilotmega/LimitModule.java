package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum LimitModule {
    /**
     * Pre-initialization. 
     */
    @MavlinkEntryInfo(1)
    LIMIT_GPSLOCK,

    /**
     * Disabled. 
     */
    @MavlinkEntryInfo(2)
    LIMIT_GEOFENCE,

    /**
     * Checking limits. 
     */
    @MavlinkEntryInfo(4)
    LIMIT_ALTITUDE
}
