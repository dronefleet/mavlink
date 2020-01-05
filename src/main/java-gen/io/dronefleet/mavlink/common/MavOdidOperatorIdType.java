package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavOdidOperatorIdType {
    /**
     * CAA (Civil Aviation Authority) registered operator ID. 
     */
    @MavlinkEntryInfo(0)
    MAV_ODID_OPERATOR_ID_TYPE_CAA
}
