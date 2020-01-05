package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavOdidDescType {
    /**
     * Free-form text description of the purpose of the flight. 
     */
    @MavlinkEntryInfo(0)
    MAV_ODID_DESC_TYPE_TEXT
}
