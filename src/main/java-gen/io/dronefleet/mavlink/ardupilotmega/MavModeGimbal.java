package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavModeGimbal {
    /**
     * Gimbal is powered on but has not started initializing yet. 
     */
    @MavlinkEntryInfo(0)
    MAV_MODE_GIMBAL_UNINITIALIZED,

    /**
     * Gimbal is currently running calibration on the pitch axis. 
     */
    @MavlinkEntryInfo(1)
    MAV_MODE_GIMBAL_CALIBRATING_PITCH,

    /**
     * Gimbal is currently running calibration on the roll axis. 
     */
    @MavlinkEntryInfo(2)
    MAV_MODE_GIMBAL_CALIBRATING_ROLL,

    /**
     * Gimbal is currently running calibration on the yaw axis. 
     */
    @MavlinkEntryInfo(3)
    MAV_MODE_GIMBAL_CALIBRATING_YAW,

    /**
     * Gimbal has finished calibrating and initializing, but is relaxed pending reception of first 
     * rate command from copter. 
     */
    @MavlinkEntryInfo(4)
    MAV_MODE_GIMBAL_INITIALIZED,

    /**
     * Gimbal is actively stabilizing. 
     */
    @MavlinkEntryInfo(5)
    MAV_MODE_GIMBAL_ACTIVE,

    /**
     * Gimbal is relaxed because it missed more than 10 expected rate command messages in a row. Gimbal 
     * will move back to active mode when it receives a new rate command. 
     */
    @MavlinkEntryInfo(6)
    MAV_MODE_GIMBAL_RATE_CMD_TIMEOUT
}
