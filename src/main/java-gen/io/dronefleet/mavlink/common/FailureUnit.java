package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * List of possible units where failures can be injected. 
 */
@MavlinkEnum
public enum FailureUnit {
    /**
     *  
     */
    @MavlinkEntryInfo(0)
    FAILURE_UNIT_SENSOR_GYRO,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    FAILURE_UNIT_SENSOR_ACCEL,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    FAILURE_UNIT_SENSOR_MAG,

    /**
     *  
     */
    @MavlinkEntryInfo(3)
    FAILURE_UNIT_SENSOR_BARO,

    /**
     *  
     */
    @MavlinkEntryInfo(4)
    FAILURE_UNIT_SENSOR_GPS,

    /**
     *  
     */
    @MavlinkEntryInfo(5)
    FAILURE_UNIT_SENSOR_OPTICAL_FLOW,

    /**
     *  
     */
    @MavlinkEntryInfo(6)
    FAILURE_UNIT_SENSOR_VIO,

    /**
     *  
     */
    @MavlinkEntryInfo(7)
    FAILURE_UNIT_SENSOR_DISTANCE_SENSOR,

    /**
     *  
     */
    @MavlinkEntryInfo(8)
    FAILURE_UNIT_SENSOR_AIRSPEED,

    /**
     *  
     */
    @MavlinkEntryInfo(100)
    FAILURE_UNIT_SYSTEM_BATTERY,

    /**
     *  
     */
    @MavlinkEntryInfo(101)
    FAILURE_UNIT_SYSTEM_MOTOR,

    /**
     *  
     */
    @MavlinkEntryInfo(102)
    FAILURE_UNIT_SYSTEM_SERVO,

    /**
     *  
     */
    @MavlinkEntryInfo(103)
    FAILURE_UNIT_SYSTEM_AVOIDANCE,

    /**
     *  
     */
    @MavlinkEntryInfo(104)
    FAILURE_UNIT_SYSTEM_RC_SIGNAL,

    /**
     *  
     */
    @MavlinkEntryInfo(105)
    FAILURE_UNIT_SYSTEM_MAVLINK_SIGNAL
}
