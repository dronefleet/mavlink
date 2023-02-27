package io.dronefleet.mavlink.storm32;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Gimbal manager client ID. In a prioritizing profile, the priorities are determined by the 
 * implementation; they could e.g. be custom1 &gt; onboard &gt; GCS &gt; autopilot/camera &gt; GCS2 &gt; custom2. 
 */
@MavlinkEnum
public enum MavStorm32GimbalManagerClient {
    /**
     * For convenience. 
     */
    @MavlinkEntryInfo(0)
    MAV_STORM32_GIMBAL_MANAGER_CLIENT_NONE,

    /**
     * This is the onboard/companion computer client. 
     */
    @MavlinkEntryInfo(1)
    MAV_STORM32_GIMBAL_MANAGER_CLIENT_ONBOARD,

    /**
     * This is the autopilot client. 
     */
    @MavlinkEntryInfo(2)
    MAV_STORM32_GIMBAL_MANAGER_CLIENT_AUTOPILOT,

    /**
     * This is the GCS client. 
     */
    @MavlinkEntryInfo(3)
    MAV_STORM32_GIMBAL_MANAGER_CLIENT_GCS,

    /**
     * This is the camera client. 
     */
    @MavlinkEntryInfo(4)
    MAV_STORM32_GIMBAL_MANAGER_CLIENT_CAMERA,

    /**
     * This is the GCS2 client. 
     */
    @MavlinkEntryInfo(5)
    MAV_STORM32_GIMBAL_MANAGER_CLIENT_GCS2,

    /**
     * This is the camera2 client. 
     */
    @MavlinkEntryInfo(6)
    MAV_STORM32_GIMBAL_MANAGER_CLIENT_CAMERA2,

    /**
     * This is the custom client. 
     */
    @MavlinkEntryInfo(7)
    MAV_STORM32_GIMBAL_MANAGER_CLIENT_CUSTOM,

    /**
     * This is the custom2 client. 
     */
    @MavlinkEntryInfo(8)
    MAV_STORM32_GIMBAL_MANAGER_CLIENT_CUSTOM2
}
