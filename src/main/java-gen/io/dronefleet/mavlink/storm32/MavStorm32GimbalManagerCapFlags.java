package io.dronefleet.mavlink.storm32;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Gimbal manager capability flags. 
 */
@MavlinkEnum
public enum MavStorm32GimbalManagerCapFlags {
    /**
     * The gimbal manager supports several profiles. 
     */
    @MavlinkEntryInfo(1)
    MAV_STORM32_GIMBAL_MANAGER_CAP_FLAGS_HAS_PROFILES
}
