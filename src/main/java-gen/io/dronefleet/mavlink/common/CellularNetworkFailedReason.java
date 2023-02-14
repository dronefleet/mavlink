package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * These flags are used to diagnose the failure state of {@link io.dronefleet.mavlink.common.CellularStatus CELLULAR_STATUS} 
 */
@MavlinkEnum
public enum CellularNetworkFailedReason {
    /**
     * No error 
     */
    @MavlinkEntryInfo(0)
    CELLULAR_NETWORK_FAILED_REASON_NONE,

    /**
     * Error state is unknown 
     */
    @MavlinkEntryInfo(1)
    CELLULAR_NETWORK_FAILED_REASON_UNKNOWN,

    /**
     * SIM is required for the modem but missing 
     */
    @MavlinkEntryInfo(2)
    CELLULAR_NETWORK_FAILED_REASON_SIM_MISSING,

    /**
     * SIM is available, but not usable for connection 
     */
    @MavlinkEntryInfo(3)
    CELLULAR_NETWORK_FAILED_REASON_SIM_ERROR
}
