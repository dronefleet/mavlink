package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Parachute actions. Trigger release and enable/disable auto-release. 
 */
@MavlinkEnum
public enum ParachuteAction {
    /**
     * Disable auto-release of parachute (i.e. release triggered by crash detectors). 
     */
    @MavlinkEntryInfo(0)
    PARACHUTE_DISABLE,

    /**
     * Enable auto-release of parachute. 
     */
    @MavlinkEntryInfo(1)
    PARACHUTE_ENABLE,

    /**
     * Release parachute and kill motors. 
     */
    @MavlinkEntryInfo(2)
    PARACHUTE_RELEASE
}
