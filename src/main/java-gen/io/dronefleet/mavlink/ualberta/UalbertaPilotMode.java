package io.dronefleet.mavlink.ualberta;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Mode currently commanded by pilot 
 */
@MavlinkEnum
public enum UalbertaPilotMode {
    /**
     *  
     */
    @MavlinkEntryInfo(1)
    PILOT_MANUAL,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    PILOT_AUTO,

    /**
     * Rotomotion mode 
     */
    @MavlinkEntryInfo(3)
    PILOT_ROTO
}
