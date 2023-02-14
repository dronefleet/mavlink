package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Possible responses from a {@link io.dronefleet.mavlink.common.CellularConfig CELLULAR_CONFIG} message. 
 */
@MavlinkEnum
public enum CellularConfigResponse {
    /**
     * Changes accepted. 
     */
    @MavlinkEntryInfo(0)
    CELLULAR_CONFIG_RESPONSE_ACCEPTED,

    /**
     * Invalid APN. 
     */
    @MavlinkEntryInfo(1)
    CELLULAR_CONFIG_RESPONSE_APN_ERROR,

    /**
     * Invalid PIN. 
     */
    @MavlinkEntryInfo(2)
    CELLULAR_CONFIG_RESPONSE_PIN_ERROR,

    /**
     * Changes rejected. 
     */
    @MavlinkEntryInfo(3)
    CELLULAR_CONFIG_RESPONSE_REJECTED,

    /**
     * PUK is required to unblock SIM card. 
     */
    @MavlinkEntryInfo(4)
    CELLULAR_CONFIG_BLOCKED_PUK_REQUIRED
}
