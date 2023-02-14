package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Gripper actions. 
 */
@MavlinkEnum
public enum GripperActions {
    /**
     * Gripper release cargo. 
     */
    @MavlinkEntryInfo(0)
    GRIPPER_ACTION_RELEASE,

    /**
     * Gripper grab onto cargo. 
     */
    @MavlinkEntryInfo(1)
    GRIPPER_ACTION_GRAB
}
