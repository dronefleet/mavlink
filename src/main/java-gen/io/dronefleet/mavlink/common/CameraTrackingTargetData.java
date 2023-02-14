package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Camera tracking target data (shows where tracked target is within image) 
 */
@MavlinkEnum
public enum CameraTrackingTargetData {
    /**
     * No target data 
     */
    @MavlinkEntryInfo(0)
    CAMERA_TRACKING_TARGET_DATA_NONE,

    /**
     * Target data embedded in image data (proprietary) 
     */
    @MavlinkEntryInfo(1)
    CAMERA_TRACKING_TARGET_DATA_EMBEDDED,

    /**
     * Target data rendered in image 
     */
    @MavlinkEntryInfo(2)
    CAMERA_TRACKING_TARGET_DATA_RENDERED,

    /**
     * Target data within status message (Point or Rectangle) 
     */
    @MavlinkEntryInfo(4)
    CAMERA_TRACKING_TARGET_DATA_IN_STATUS
}
