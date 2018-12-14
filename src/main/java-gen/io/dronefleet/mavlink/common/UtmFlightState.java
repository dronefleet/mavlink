package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Airborne status of UAS. 
 */
@MavlinkEnum
public enum UtmFlightState {
    /**
     * The flight state can't be determined. 
     */
    @MavlinkEntryInfo(1)
    UTM_FLIGHT_STATE_UNKNOWN,

    /**
     * UAS on ground. 
     */
    @MavlinkEntryInfo(2)
    UTM_FLIGHT_STATE_GROUND,

    /**
     * UAS airborne. 
     */
    @MavlinkEntryInfo(3)
    UTM_FLIGHT_STATE_AIRBORNE,

    /**
     * UAS is in an emergency flight state. 
     */
    @MavlinkEntryInfo(16)
    UTM_FLIGHT_STATE_EMERGENCY,

    /**
     * UAS has no active controls. 
     */
    @MavlinkEntryInfo(32)
    UTM_FLIGHT_STATE_NOCTRL
}
