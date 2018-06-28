package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum PidTuningAxis {
    /**
     *  
     */
    @MavlinkEntryInfo(1)
    PID_TUNING_ROLL,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    PID_TUNING_PITCH,

    /**
     *  
     */
    @MavlinkEntryInfo(3)
    PID_TUNING_YAW,

    /**
     *  
     */
    @MavlinkEntryInfo(4)
    PID_TUNING_ACCZ,

    /**
     *  
     */
    @MavlinkEntryInfo(5)
    PID_TUNING_STEER,

    /**
     *  
     */
    @MavlinkEntryInfo(6)
    PID_TUNING_LANDING
}
