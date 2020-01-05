package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavOdidLocationSrc {
    /**
     * The location of the operator is the same as the take-off location. 
     */
    @MavlinkEntryInfo(0)
    MAV_ODID_LOCATION_SRC_TAKEOFF,

    /**
     * The location of the operator is based on live GNSS data. 
     */
    @MavlinkEntryInfo(1)
    MAV_ODID_LOCATION_SRC_LIVE_GNSS,

    /**
     * The location of the operator is a fixed location. 
     */
    @MavlinkEntryInfo(2)
    MAV_ODID_LOCATION_SRC_FIXED
}
