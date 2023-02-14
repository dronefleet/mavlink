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
    MAV_ODID_STATUS_AIRBORNE,

    /**
     * The UA is having an emergency. 
     */
    @MavlinkEntryInfo(3)
    MAV_ODID_STATUS_EMERGENCY,

    /**
     * The remote ID system is failing or unreliable in some way. 
     */
    @MavlinkEntryInfo(4)
    MAV_ODID_STATUS_REMOTE_ID_SYSTEM_FAILURE
}
