package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Focus types for MAV_CMD_SET_CAMERA_FOCUS 
 */
@MavlinkEnum
public enum SetFocusType {
    /**
     * Focus one step increment (-1 for focusing in, 1 for focusing out towards infinity). 
     */
    @MavlinkEntryInfo(0)
    FOCUS_TYPE_STEP,

    /**
     * Continuous focus up/down until stopped (-1 for focusing in, 1 for focusing out towards 
     * infinity, 0 to stop focusing) 
     */
    @MavlinkEntryInfo(1)
    FOCUS_TYPE_CONTINUOUS,

    /**
     * Zoom value as proportion of full camera range (a value between 0.0 and 100.0) 
     */
    @MavlinkEntryInfo(2)
    FOCUS_TYPE_RANGE
}
