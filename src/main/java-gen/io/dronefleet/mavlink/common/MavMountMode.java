package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Enumeration of possible mount operation modes 
 */
@MavlinkEnum
public enum MavMountMode {
    /**
     * Load and keep safe position (Roll,Pitch,Yaw) from permant memory and stop stabilization 
     */
    @MavlinkEntryInfo(0)
    MAV_MOUNT_MODE_RETRACT,

    /**
     * Load and keep neutral position (Roll,Pitch,Yaw) from permanent memory. 
     */
    @MavlinkEntryInfo(1)
    MAV_MOUNT_MODE_NEUTRAL,

    /**
     * Load neutral position and start MAVLink Roll,Pitch,Yaw control with stabilization 
     */
    @MavlinkEntryInfo(2)
    MAV_MOUNT_MODE_MAVLINK_TARGETING,

    /**
     * Load neutral position and start RC Roll,Pitch,Yaw control with stabilization 
     */
    @MavlinkEntryInfo(3)
    MAV_MOUNT_MODE_RC_TARGETING,

    /**
     * Load neutral position and start to point to Lat,Lon,Alt 
     */
    @MavlinkEntryInfo(4)
    MAV_MOUNT_MODE_GPS_POINT,

    /**
     * Gimbal tracks system with specified system ID 
     */
    @MavlinkEntryInfo(5)
    MAV_MOUNT_MODE_SYSID_TARGET
}
