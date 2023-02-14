package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * States of the mission state machine. Note that these states are independent of whether the 
 * mission is in a mode that can execute mission items or not (is suspended). They may not all be 
 * relevant on all vehicles. 
 */
@MavlinkEnum
public enum MissionState {
    /**
     * The mission status reporting is not supported. 
     */
    @MavlinkEntryInfo(0)
    MISSION_STATE_UNKNOWN,

    /**
     * No mission on the vehicle. 
     */
    @MavlinkEntryInfo(1)
    MISSION_STATE_NO_MISSION,

    /**
     * Mission has not started. This is the case after a mission has uploaded but not yet started 
     * executing. 
     */
    @MavlinkEntryInfo(2)
    MISSION_STATE_NOT_STARTED,

    /**
     * Mission is active, and will execute mission items when in auto mode. 
     */
    @MavlinkEntryInfo(3)
    MISSION_STATE_ACTIVE,

    /**
     * Mission is paused when in auto mode. 
     */
    @MavlinkEntryInfo(4)
    MISSION_STATE_PAUSED,

    /**
     * Mission has executed all mission items. 
     */
    @MavlinkEntryInfo(5)
    MISSION_STATE_COMPLETE
}
