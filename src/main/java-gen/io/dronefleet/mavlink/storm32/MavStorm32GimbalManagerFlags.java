package io.dronefleet.mavlink.storm32;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Flags for gimbal manager operation. Used for setting and reporting, unless specified 
 * otherwise. If a setting has been accepted by the gimbal manager is reported in the 
 * STORM32_GIMBAL_MANAGER_STATUS message. 
 */
@MavlinkEnum
public enum MavStorm32GimbalManagerFlags {
    /**
     * 0 = ignore. 
     */
    @MavlinkEntryInfo(0)
    MAV_STORM32_GIMBAL_MANAGER_FLAGS_NONE,

    /**
     * Request to set RC input to active, or report RC input is active. Implies RC mixed. RC exclusive is 
     * achieved by setting all clients to inactive. 
     */
    @MavlinkEntryInfo(1)
    MAV_STORM32_GIMBAL_MANAGER_FLAGS_RC_ACTIVE,

    /**
     * Request to set onboard/companion computer client to active, or report this client is active. 
     */
    @MavlinkEntryInfo(2)
    MAV_STORM32_GIMBAL_MANAGER_FLAGS_CLIENT_ONBOARD_ACTIVE,

    /**
     * Request to set autopliot client to active, or report this client is active. 
     */
    @MavlinkEntryInfo(4)
    MAV_STORM32_GIMBAL_MANAGER_FLAGS_CLIENT_AUTOPILOT_ACTIVE,

    /**
     * Request to set GCS client to active, or report this client is active. 
     */
    @MavlinkEntryInfo(8)
    MAV_STORM32_GIMBAL_MANAGER_FLAGS_CLIENT_GCS_ACTIVE,

    /**
     * Request to set camera client to active, or report this client is active. 
     */
    @MavlinkEntryInfo(16)
    MAV_STORM32_GIMBAL_MANAGER_FLAGS_CLIENT_CAMERA_ACTIVE,

    /**
     * Request to set GCS2 client to active, or report this client is active. 
     */
    @MavlinkEntryInfo(32)
    MAV_STORM32_GIMBAL_MANAGER_FLAGS_CLIENT_GCS2_ACTIVE,

    /**
     * Request to set camera2 client to active, or report this client is active. 
     */
    @MavlinkEntryInfo(64)
    MAV_STORM32_GIMBAL_MANAGER_FLAGS_CLIENT_CAMERA2_ACTIVE,

    /**
     * Request to set custom client to active, or report this client is active. 
     */
    @MavlinkEntryInfo(128)
    MAV_STORM32_GIMBAL_MANAGER_FLAGS_CLIENT_CUSTOM_ACTIVE,

    /**
     * Request to set custom2 client to active, or report this client is active. 
     */
    @MavlinkEntryInfo(256)
    MAV_STORM32_GIMBAL_MANAGER_FLAGS_CLIENT_CUSTOM2_ACTIVE,

    /**
     * Request supervision. This flag is only for setting, it is not reported. 
     */
    @MavlinkEntryInfo(512)
    MAV_STORM32_GIMBAL_MANAGER_FLAGS_SET_SUPERVISON,

    /**
     * Release supervision. This flag is only for setting, it is not reported. 
     */
    @MavlinkEntryInfo(1024)
    MAV_STORM32_GIMBAL_MANAGER_FLAGS_SET_RELEASE
}
