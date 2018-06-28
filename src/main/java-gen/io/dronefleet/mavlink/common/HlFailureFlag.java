package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Flags to report failure cases over the high latency telemtry. 
 */
@MavlinkEnum
public enum HlFailureFlag {
    /**
     * GPS failure. 
     */
    @MavlinkEntryInfo(1)
    HL_FAILURE_FLAG_GPS,

    /**
     * Differential pressure sensor failure. 
     */
    @MavlinkEntryInfo(2)
    HL_FAILURE_FLAG_DIFFERENTIAL_PRESSURE,

    /**
     * Absolute pressure sensor failure. 
     */
    @MavlinkEntryInfo(4)
    HL_FAILURE_FLAG_ABSOLUTE_PRESSURE,

    /**
     * Accelerometer sensor failure. 
     */
    @MavlinkEntryInfo(8)
    HL_FAILURE_FLAG_3D_ACCEL,

    /**
     * Gyroscope sensor failure. 
     */
    @MavlinkEntryInfo(16)
    HL_FAILURE_FLAG_3D_GYRO,

    /**
     * Magnetometer sensor failure. 
     */
    @MavlinkEntryInfo(32)
    HL_FAILURE_FLAG_3D_MAG,

    /**
     * Terrain subsystem failure. 
     */
    @MavlinkEntryInfo(64)
    HL_FAILURE_FLAG_TERRAIN,

    /**
     * Battery failure/critical low battery. 
     */
    @MavlinkEntryInfo(128)
    HL_FAILURE_FLAG_BATTERY,

    /**
     * RC receiver failure/no rc connection. 
     */
    @MavlinkEntryInfo(256)
    HL_FAILURE_FLAG_RC_RECEIVER,

    /**
     * Offboard link failure. 
     */
    @MavlinkEntryInfo(512)
    HL_FAILURE_FLAG_OFFBOARD_LINK,

    /**
     * Engine failure. 
     */
    @MavlinkEntryInfo(1024)
    HL_FAILURE_FLAG_ENGINE,

    /**
     * Geofence violation. 
     */
    @MavlinkEntryInfo(2048)
    HL_FAILURE_FLAG_GEOFENCE,

    /**
     * Estimator failure, for example measurement rejection or large variances. 
     */
    @MavlinkEntryInfo(4096)
    HL_FAILURE_FLAG_ESTIMATOR,

    /**
     * Mission failure. 
     */
    @MavlinkEntryInfo(8192)
    HL_FAILURE_FLAG_MISSION
}
