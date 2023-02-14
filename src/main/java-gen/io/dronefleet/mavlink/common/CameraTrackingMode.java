package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Camera tracking modes 
 */
@MavlinkEnum
public enum CameraTrackingMode {
    /**
     * Not tracking 
     */
    @MavlinkEntryInfo(0)
    CAMERA_TRACKING_MODE_NONE,

    /**
     * Target is a point 
     */
    @MavlinkEntryInfo(1)
    CAMERA_TRACKING_MODE_POINT,

    /**
     * Target is a rectangle 
     */
    @MavlinkEntryInfo(2)
    CAMERA_TRACKING_MODE_RECTANGLE
}
