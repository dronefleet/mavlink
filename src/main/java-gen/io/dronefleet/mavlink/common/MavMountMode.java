package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;
import java.lang.Deprecated;

/**
 * Enumeration of possible mount operation modes. This message is used by obsolete/deprecated 
 * gimbal messages. 
 * @deprecated Since 2020-01, replaced by {@link io.dronefleet.mavlink.common.GimbalManagerFlags GIMBAL_MANAGER_FLAGS}. 
 */
@MavlinkEnum
@Deprecated
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
    MAV_MOUNT_MODE_SYSID_TARGET,

    /**
     * Gimbal tracks home position 
     */
    @MavlinkEntryInfo(6)
    MAV_MOUNT_MODE_HOME_LOCATION
}
