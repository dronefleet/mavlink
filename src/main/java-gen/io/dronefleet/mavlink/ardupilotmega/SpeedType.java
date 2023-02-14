package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum SpeedType {
    /**
     *  
     */
    @MavlinkEntryInfo(0)
    SPEED_TYPE_AIRSPEED,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    SPEED_TYPE_GROUNDSPEED
}
