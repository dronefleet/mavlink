package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavOdidOperatorLocationType {
    /**
     * The location/altitude of the operator is the same as the take-off location. 
     */
    @MavlinkEntryInfo(0)
    MAV_ODID_OPERATOR_LOCATION_TYPE_TAKEOFF,

    /**
     * The location/altitude of the operator is dynamic. E.g. based on live GNSS data. 
     */
    @MavlinkEntryInfo(1)
    MAV_ODID_OPERATOR_LOCATION_TYPE_LIVE_GNSS,

    /**
     * The location/altitude of the operator are fixed values. 
     */
    @MavlinkEntryInfo(2)
    MAV_ODID_OPERATOR_LOCATION_TYPE_FIXED
}
