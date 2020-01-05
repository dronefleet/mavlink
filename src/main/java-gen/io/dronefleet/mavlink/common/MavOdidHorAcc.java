package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavOdidHorAcc {
    /**
     * The horizontal accuracy is unknown. 
     */
    @MavlinkEntryInfo(0)
    MAV_ODID_HOR_ACC_UNKNOWN,

    /**
     * The horizontal accuracy is smaller than 10 Nautical Miles. 18.52 km. 
     */
    @MavlinkEntryInfo(1)
    MAV_ODID_HOR_ACC_10NM,

    /**
     * The horizontal accuracy is smaller than 4 Nautical Miles. 7.408 km. 
     */
    @MavlinkEntryInfo(2)
    MAV_ODID_HOR_ACC_4NM,

    /**
     * The horizontal accuracy is smaller than 2 Nautical Miles. 3.704 km. 
     */
    @MavlinkEntryInfo(3)
    MAV_ODID_HOR_ACC_2NM,

    /**
     * The horizontal accuracy is smaller than 1 Nautical Miles. 1.852 km. 
     */
    @MavlinkEntryInfo(4)
    MAV_ODID_HOR_ACC_1NM,

    /**
     * The horizontal accuracy is smaller than 0.5 Nautical Miles. 926 m. 
     */
    @MavlinkEntryInfo(5)
    MAV_ODID_HOR_ACC_0_5NM,

    /**
     * The horizontal accuracy is smaller than 0.3 Nautical Miles. 555.6 m. 
     */
    @MavlinkEntryInfo(6)
    MAV_ODID_HOR_ACC_0_3NM,

    /**
     * The horizontal accuracy is smaller than 0.1 Nautical Miles. 185.2 m. 
     */
    @MavlinkEntryInfo(7)
    MAV_ODID_HOR_ACC_0_1NM,

    /**
     * The horizontal accuracy is smaller than 0.05 Nautical Miles. 92.6 m. 
     */
    @MavlinkEntryInfo(8)
    MAV_ODID_HOR_ACC_0_05NM,

    /**
     * The horizontal accuracy is smaller than 30 meter. 
     */
    @MavlinkEntryInfo(9)
    MAV_ODID_HOR_ACC_30_METER,

    /**
     * The horizontal accuracy is smaller than 10 meter. 
     */
    @MavlinkEntryInfo(10)
    MAV_ODID_HOR_ACC_10_METER,

    /**
     * The horizontal accuracy is smaller than 3 meter. 
     */
    @MavlinkEntryInfo(11)
    MAV_ODID_HOR_ACC_3_METER,

    /**
     * The horizontal accuracy is smaller than 1 meter. 
     */
    @MavlinkEntryInfo(12)
    MAV_ODID_HOR_ACC_1_METER
}
