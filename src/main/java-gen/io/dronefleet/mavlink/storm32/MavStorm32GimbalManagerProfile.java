package io.dronefleet.mavlink.storm32;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Gimbal manager profiles. Only standard profiles are defined. Any implementation can define 
 * its own profile(s) in addition, and should use enum values &gt; 16. 
 */
@MavlinkEnum
public enum MavStorm32GimbalManagerProfile {
    /**
     * Default profile. Implementation specific. 
     */
    @MavlinkEntryInfo(0)
    MAV_STORM32_GIMBAL_MANAGER_PROFILE_DEFAULT,

    /**
     * Not supported/deprecated. 
     */
    @MavlinkEntryInfo(1)
    MAV_STORM32_GIMBAL_MANAGER_PROFILE_CUSTOM,

    /**
     * Profile with cooperative behavior. 
     */
    @MavlinkEntryInfo(2)
    MAV_STORM32_GIMBAL_MANAGER_PROFILE_COOPERATIVE,

    /**
     * Profile with exclusive behavior. 
     */
    @MavlinkEntryInfo(3)
    MAV_STORM32_GIMBAL_MANAGER_PROFILE_EXCLUSIVE,

    /**
     * Profile with priority and cooperative behavior for equal priority. 
     */
    @MavlinkEntryInfo(4)
    MAV_STORM32_GIMBAL_MANAGER_PROFILE_PRIORITY_COOPERATIVE,

    /**
     * Profile with priority and exclusive behavior for equal priority. 
     */
    @MavlinkEntryInfo(5)
    MAV_STORM32_GIMBAL_MANAGER_PROFILE_PRIORITY_EXCLUSIVE
}
