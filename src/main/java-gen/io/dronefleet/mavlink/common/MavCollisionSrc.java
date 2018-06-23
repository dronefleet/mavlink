package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Source of information about this collision. 
 */
@MavlinkEnum
public enum MavCollisionSrc {
    /**
     * ID field references ADSB_VEHICLE packets<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    MAV_COLLISION_SRC_ADSB,

    /**
     * ID field references MAVLink SRC ID<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    MAV_COLLISION_SRC_MAVLINK_GPS_GLOBAL_INT
}
