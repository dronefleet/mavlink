package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavOdidDescType {
    /**
     * Optional free-form text description of the purpose of the flight. 
     */
    @MavlinkEntryInfo(0)
    MAV_ODID_DESC_TYPE_TEXT,

    /**
     * Optional additional clarification when status == MAV_ODID_STATUS_EMERGENCY. 
     */
    @MavlinkEntryInfo(1)
    MAV_ODID_DESC_TYPE_EMERGENCY,

    /**
     * Optional additional clarification when status != MAV_ODID_STATUS_EMERGENCY. 
     */
    @MavlinkEntryInfo(2)
    MAV_ODID_DESC_TYPE_EXTENDED_STATUS
}
