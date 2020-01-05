package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Actions being taken to mitigate/prevent fence breach 
 */
@MavlinkEnum
public enum FenceMitigate {
    /**
     * Unknown 
     */
    @MavlinkEntryInfo(0)
    FENCE_MITIGATE_UNKNOWN,

    /**
     * No actions being taken 
     */
    @MavlinkEntryInfo(1)
    FENCE_MITIGATE_NONE,

    /**
     * Velocity limiting active to prevent breach 
     */
    @MavlinkEntryInfo(2)
    FENCE_MITIGATE_VEL_LIMIT
}
