package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Actions following geofence breach. 
 */
@MavlinkEnum
public enum FenceAction {
    /**
     * Disable fenced mode. If used in a plan this would mean the next fence is disabled. 
     */
    @MavlinkEntryInfo(0)
    FENCE_ACTION_NONE,

    /**
     * Fly to geofence MAV_CMD_NAV_FENCE_RETURN_POINT in GUIDED mode. Note: This action is only 
     * supported by ArduPlane, and may not be supported in all versions. 
     */
    @MavlinkEntryInfo(1)
    FENCE_ACTION_GUIDED,

    /**
     * Report fence breach, but don't take action 
     */
    @MavlinkEntryInfo(2)
    FENCE_ACTION_REPORT,

    /**
     * Fly to geofence MAV_CMD_NAV_FENCE_RETURN_POINT with manual throttle control in GUIDED 
     * mode. Note: This action is only supported by ArduPlane, and may not be supported in all 
     * versions. 
     */
    @MavlinkEntryInfo(3)
    FENCE_ACTION_GUIDED_THR_PASS,

    /**
     * Return/RTL mode. 
     */
    @MavlinkEntryInfo(4)
    FENCE_ACTION_RTL,

    /**
     * Hold at current location. 
     */
    @MavlinkEntryInfo(5)
    FENCE_ACTION_HOLD,

    /**
     * Termination failsafe. Motors are shut down (some flight stacks may trigger other failsafe 
     * actions). 
     */
    @MavlinkEntryInfo(6)
    FENCE_ACTION_TERMINATE,

    /**
     * Land at current location. 
     */
    @MavlinkEntryInfo(7)
    FENCE_ACTION_LAND
}
