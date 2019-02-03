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
     * Zoom value as proportion of full camera range (a value between 0.0 and 100.0) 
     */
    @MavlinkEntryInfo(2)
    ZOOM_TYPE_RANGE
}
