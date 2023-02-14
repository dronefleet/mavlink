package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavOdidTimeAcc {
    /**
     * The timestamp accuracy is unknown. 
     */
    @MavlinkEntryInfo(0)
    MAV_ODID_TIME_ACC_UNKNOWN,

    /**
     * The timestamp accuracy is smaller than or equal to 0.1 second. 
     */
    @MavlinkEntryInfo(1)
    MAV_ODID_TIME_ACC_0_1_SECOND,

    /**
     * The timestamp accuracy is smaller than or equal to 0.2 second. 
     */
    @MavlinkEntryInfo(2)
    MAV_ODID_TIME_ACC_0_2_SECOND,

    /**
     * The timestamp accuracy is smaller than or equal to 0.3 second. 
     */
    @MavlinkEntryInfo(3)
    MAV_ODID_TIME_ACC_0_3_SECOND,

    /**
     * The timestamp accuracy is smaller than or equal to 0.4 second. 
     */
    @MavlinkEntryInfo(4)
    MAV_ODID_TIME_ACC_0_4_SECOND,

    /**
     * The timestamp accuracy is smaller than or equal to 0.5 second. 
     */
    @MavlinkEntryInfo(5)
    MAV_ODID_TIME_ACC_0_5_SECOND,

    /**
     * The timestamp accuracy is smaller than or equal to 0.6 second. 
     */
    @MavlinkEntryInfo(6)
    MAV_ODID_TIME_ACC_0_6_SECOND,

    /**
     * The timestamp accuracy is smaller than or equal to 0.7 second. 
     */
    @MavlinkEntryInfo(7)
    MAV_ODID_TIME_ACC_0_7_SECOND,

    /**
     * The timestamp accuracy is smaller than or equal to 0.8 second. 
     */
    @MavlinkEntryInfo(8)
    MAV_ODID_TIME_ACC_0_8_SECOND,

    /**
     * The timestamp accuracy is smaller than or equal to 0.9 second. 
     */
    @MavlinkEntryInfo(9)
    MAV_ODID_TIME_ACC_0_9_SECOND,

    /**
     * The timestamp accuracy is smaller than or equal to 1.0 second. 
     */
    @MavlinkEntryInfo(10)
    MAV_ODID_TIME_ACC_1_0_SECOND,

    /**
     * The timestamp accuracy is smaller than or equal to 1.1 second. 
     */
    @MavlinkEntryInfo(11)
    MAV_ODID_TIME_ACC_1_1_SECOND,

    /**
     * The timestamp accuracy is smaller than or equal to 1.2 second. 
     */
    @MavlinkEntryInfo(12)
    MAV_ODID_TIME_ACC_1_2_SECOND,

    /**
     * The timestamp accuracy is smaller than or equal to 1.3 second. 
     */
    @MavlinkEntryInfo(13)
    MAV_ODID_TIME_ACC_1_3_SECOND,

    /**
     * The timestamp accuracy is smaller than or equal to 1.4 second. 
     */
    @MavlinkEntryInfo(14)
    MAV_ODID_TIME_ACC_1_4_SECOND,

    /**
     * The timestamp accuracy is smaller than or equal to 1.5 second. 
     */
    @MavlinkEntryInfo(15)
    MAV_ODID_TIME_ACC_1_5_SECOND
}
