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
     * Focus value as proportion of full camera focus range (a value between 0.0 and 100.0) 
     */
    @MavlinkEntryInfo(2)
    FOCUS_TYPE_RANGE,

    /**
     * Focus value in metres. Note that there is no message to get the valid focus range of the camera, so 
     * this can type can only be used for cameras where the range is known (implying that this cannot 
     * reliably be used in a GCS for an arbitrary camera). 
     */
    @MavlinkEntryInfo(3)
    FOCUS_TYPE_METERS
}
