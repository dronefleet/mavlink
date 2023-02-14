package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MagCalStatus {
    /**
     *  
     */
    @MavlinkEntryInfo(0)
    MAG_CAL_NOT_STARTED,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    MAG_CAL_WAITING_TO_START,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    MAG_CAL_RUNNING_STEP_ONE,

    /**
     *  
     */
    @MavlinkEntryInfo(3)
    MAG_CAL_RUNNING_STEP_TWO,

    /**
     *  
     */
    @MavlinkEntryInfo(4)
    MAG_CAL_SUCCESS,

    /**
     *  
     */
    @MavlinkEntryInfo(5)
    MAG_CAL_FAILED,

    /**
     *  
     */
    @MavlinkEntryInfo(6)
    MAG_CAL_BAD_ORIENTATION,

    /**
     *  
     */
    @MavlinkEntryInfo(7)
    MAG_CAL_BAD_RADIUS
}
