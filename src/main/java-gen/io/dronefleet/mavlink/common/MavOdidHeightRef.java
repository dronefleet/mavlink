package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavOdidHeightRef {
    /**
     * The height field is relative to the take-off location. 
     */
    @MavlinkEntryInfo(0)
    MAV_ODID_HEIGHT_REF_OVER_TAKEOFF,

    /**
     * The height field is relative to ground. 
     */
    @MavlinkEntryInfo(1)
    MAV_ODID_HEIGHT_REF_OVER_GROUND
}
