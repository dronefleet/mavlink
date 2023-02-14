package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Zoom types for MAV_CMD_SET_CAMERA_ZOOM 
 */
@MavlinkEnum
public enum CameraZoomType {
    /**
     * Zoom one step increment (-1 for wide, 1 for tele) 
     */
    @MavlinkEntryInfo(0)
    ZOOM_TYPE_STEP,

    /**
     * Continuous zoom up/down until stopped (-1 for wide, 1 for tele, 0 to stop zooming) 
     */
    @MavlinkEntryInfo(1)
    ZOOM_TYPE_CONTINUOUS,

    /**
     * Zoom value as proportion of full camera range (a percentage value between 0.0 and 100.0) 
     */
    @MavlinkEntryInfo(2)
    ZOOM_TYPE_RANGE,

    /**
     * Zoom value/variable focal length in millimetres. Note that there is no message to get the valid 
     * zoom range of the camera, so this can type can only be used for cameras where the zoom range is 
     * known (implying that this cannot reliably be used in a GCS for an arbitrary camera) 
     */
    @MavlinkEntryInfo(3)
    ZOOM_TYPE_FOCAL_LENGTH
}
