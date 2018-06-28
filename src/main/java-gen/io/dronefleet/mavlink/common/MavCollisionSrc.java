package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Source of information about this collision. 
 */
@MavlinkEnum
public enum MavCollisionSrc {
    /**
     * ID field references {@link io.dronefleet.mavlink.common.AdsbVehicle ADSB_VEHICLE} packets 
     */
    @MavlinkEntryInfo(0)
    MAV_COLLISION_SRC_ADSB,

    /**
     * ID field references MAVLink SRC ID 
     */
    @MavlinkEntryInfo(1)
    MAV_COLLISION_SRC_MAVLINK_GPS_GLOBAL_INT
}
