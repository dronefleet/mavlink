package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Precision land modes (used in MAV_CMD_NAV_LAND). 
 */
@MavlinkEnum
public enum PrecisionLandMode {
    /**
     * Normal (non-precision) landing. 
     */
    @MavlinkEntryInfo(0)
    PRECISION_LAND_MODE_DISABLED,

    /**
     * Use precision landing if beacon detected when land command accepted, otherwise land 
     * normally. 
     */
    @MavlinkEntryInfo(1)
    PRECISION_LAND_MODE_OPPORTUNISTIC,

    /**
     * Use precision landing, searching for beacon if not found when land command accepted (land 
     * normally if beacon cannot be found). 
     */
    @MavlinkEntryInfo(2)
    PRECISION_LAND_MODE_REQUIRED
}
