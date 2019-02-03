package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * These flags encode the cellular network status 
 */
@MavlinkEnum
public enum CellularNetworkStatusFlag {
    /**
     * Roaming is active 
     */
    @MavlinkEntryInfo(1)
    CELLULAR_NETWORK_STATUS_FLAG_ROAMING
}
