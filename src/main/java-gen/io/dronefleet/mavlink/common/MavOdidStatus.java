package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavOdidStatus {
    /**
     * The status of the (UA) Unmanned Aircraft is undefined. 
     */
    @MavlinkEntryInfo(0)
    MAV_ODID_STATUS_UNDECLARED,

    /**
     * The UA is on the ground. 
     */
    @MavlinkEntryInfo(1)
    MAV_ODID_STATUS_GROUND,

    /**
     * The UA is in the air. 
     */
    @MavlinkEntryInfo(2)
    MAV_ODID_STATUS_AIRBORNE
}
