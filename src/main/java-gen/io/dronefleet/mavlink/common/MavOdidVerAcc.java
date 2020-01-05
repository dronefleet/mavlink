package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavOdidVerAcc {
    /**
     * The vertical accuracy is unknown. 
     */
    @MavlinkEntryInfo(0)
    MAV_ODID_VER_ACC_UNKNOWN,

    /**
     * The vertical accuracy is smaller than 150 meter. 
     */
    @MavlinkEntryInfo(1)
    MAV_ODID_VER_ACC_150_METER,

    /**
     * The vertical accuracy is smaller than 45 meter. 
     */
    @MavlinkEntryInfo(2)
    MAV_ODID_VER_ACC_45_METER,

    /**
     * The vertical accuracy is smaller than 25 meter. 
     */
    @MavlinkEntryInfo(3)
    MAV_ODID_VER_ACC_25_METER,

    /**
     * The vertical accuracy is smaller than 10 meter. 
     */
    @MavlinkEntryInfo(4)
    MAV_ODID_VER_ACC_10_METER,

    /**
     * The vertical accuracy is smaller than 3 meter. 
     */
    @MavlinkEntryInfo(5)
    MAV_ODID_VER_ACC_3_METER,

    /**
     * The vertical accuracy is smaller than 1 meter. 
     */
    @MavlinkEntryInfo(6)
    MAV_ODID_VER_ACC_1_METER
}
