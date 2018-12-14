package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum GimbalAxis {
    /**
     * Gimbal yaw axis. 
     */
    @MavlinkEntryInfo(0)
    GIMBAL_AXIS_YAW,

    /**
     * Gimbal pitch axis. 
     */
    @MavlinkEntryInfo(1)
    GIMBAL_AXIS_PITCH,

    /**
     * Gimbal roll axis. 
     */
    @MavlinkEntryInfo(2)
    GIMBAL_AXIS_ROLL
}
