package io.dronefleet.mavlink.storm32;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * STorM32 camera prearm check flags. 
 */
@MavlinkEnum
public enum MavStorm32CameraPrearmFlags {
    /**
     * The camera has been found and is connected. 
     */
    @MavlinkEntryInfo(1)
    MAV_STORM32_CAMERA_PREARM_FLAGS_CONNECTED
}
