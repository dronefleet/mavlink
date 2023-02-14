package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Camera tracking status flags 
 */
@MavlinkEnum
public enum CameraTrackingStatusFlags {
    /**
     * Camera is not tracking 
     */
    @MavlinkEntryInfo(0)
    CAMERA_TRACKING_STATUS_FLAGS_IDLE,

    /**
     * Camera is tracking 
     */
    @MavlinkEntryInfo(1)
    CAMERA_TRACKING_STATUS_FLAGS_ACTIVE,

    /**
     * Camera tracking in error state 
     */
    @MavlinkEntryInfo(2)
    CAMERA_TRACKING_STATUS_FLAGS_ERROR
}
