package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum LimitsState {
    /**
     * Pre-initialization. 
     */
    @MavlinkEntryInfo(0)
    LIMITS_INIT,

    /**
     * Disabled. 
     */
    @MavlinkEntryInfo(1)
    LIMITS_DISABLED,

    /**
     * Checking limits. 
     */
    @MavlinkEntryInfo(2)
    LIMITS_ENABLED,

    /**
     * A limit has been breached. 
     */
    @MavlinkEntryInfo(3)
    LIMITS_TRIGGERED,

    /**
     * Taking action e.g. Return/RTL. 
     */
    @MavlinkEntryInfo(4)
    LIMITS_RECOVERING,

    /**
     * We're no longer in breach of a limit. 
     */
    @MavlinkEntryInfo(5)
    LIMITS_RECOVERED
}
