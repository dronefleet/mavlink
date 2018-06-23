package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Gripper actions. 
 */
@MavlinkEnum
public enum GripperActions {
    /**
     * gripper release of cargo<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    GRIPPER_ACTION_RELEASE,

    /**
     * gripper grabs onto cargo<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    GRIPPER_ACTION_GRAB
}
