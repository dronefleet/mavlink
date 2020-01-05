package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavOdidSpeedAcc {
    /**
     * The speed accuracy is unknown. 
     */
    @MavlinkEntryInfo(0)
    MAV_ODID_SPEED_ACC_UNKNOWN,

    /**
     * The speed accuracy is smaller than 10 meters per second. 
     */
    @MavlinkEntryInfo(1)
    MAV_ODID_SPEED_ACC_10_METERS_PER_SECOND,

    /**
     * The speed accuracy is smaller than 3 meters per second. 
     */
    @MavlinkEntryInfo(2)
    MAV_ODID_SPEED_ACC_3_METERS_PER_SECOND,

    /**
     * The speed accuracy is smaller than 1 meters per second. 
     */
    @MavlinkEntryInfo(3)
    MAV_ODID_SPEED_ACC_1_METERS_PER_SECOND,

    /**
     * The speed accuracy is smaller than 0.3 meters per second. 
     */
    @MavlinkEntryInfo(4)
    MAV_ODID_SPEED_ACC_0_3_METERS_PER_SECOND
}
