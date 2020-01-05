package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Yaw behaviour during orbit flight. 
 */
@MavlinkEnum
public enum OrbitYawBehaviour {
    /**
     * Vehicle front points to the center (default). 
     */
    @MavlinkEntryInfo(0)
    ORBIT_YAW_BEHAVIOUR_HOLD_FRONT_TO_CIRCLE_CENTER,

    /**
     * Vehicle front holds heading when message received. 
     */
    @MavlinkEntryInfo(1)
    ORBIT_YAW_BEHAVIOUR_HOLD_INITIAL_HEADING,

    /**
     * Yaw uncontrolled. 
     */
    @MavlinkEntryInfo(2)
    ORBIT_YAW_BEHAVIOUR_UNCONTROLLED,

    /**
     * Vehicle front follows flight path (tangential to circle). 
     */
    @MavlinkEntryInfo(3)
    ORBIT_YAW_BEHAVIOUR_HOLD_FRONT_TANGENT_TO_CIRCLE,

    /**
     * Yaw controlled by RC input. 
     */
    @MavlinkEntryInfo(4)
    ORBIT_YAW_BEHAVIOUR_RC_CONTROLLED
}
