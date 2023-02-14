package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum CanFilterOp {
    /**
     *  
     */
    @MavlinkEntryInfo(0)
    CAN_FILTER_REPLACE,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    CAN_FILTER_ADD,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    CAN_FILTER_REMOVE
}
