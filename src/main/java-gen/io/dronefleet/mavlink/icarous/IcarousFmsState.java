package io.dronefleet.mavlink.icarous;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum IcarousFmsState {
    /**
     *  
     */
    @MavlinkEntryInfo(0)
    ICAROUS_FMS_STATE_IDLE,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    ICAROUS_FMS_STATE_TAKEOFF,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    ICAROUS_FMS_STATE_CLIMB,

    /**
     *  
     */
    @MavlinkEntryInfo(3)
    ICAROUS_FMS_STATE_CRUISE,

    /**
     *  
     */
    @MavlinkEntryInfo(4)
    ICAROUS_FMS_STATE_APPROACH,

    /**
     *  
     */
    @MavlinkEntryInfo(5)
    ICAROUS_FMS_STATE_LAND
}
