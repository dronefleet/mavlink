package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Flags to report failure cases over the high latency telemtry. 
 */
@MavlinkEnum
public enum HlFailureFlag {
    /**
     * GPS failure.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    HL_FAILURE_FLAG_GPS,

    /**
     * Differential pressure sensor failure.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    HL_FAILURE_FLAG_DIFFERENTIAL_PRESSURE,

    /**
     * Absolute pressure sensor failure.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    HL_FAILURE_FLAG_ABSOLUTE_PRESSURE,

    /**
     * Accelerometer sensor failure.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8)
    HL_FAILURE_FLAG_3D_ACCEL,

    /**
     * Gyroscope sensor failure.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16)
    HL_FAILURE_FLAG_3D_GYRO,

    /**
     * Magnetometer sensor failure.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(32)
    HL_FAILURE_FLAG_3D_MAG,

    /**
     * Terrain subsystem failure.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(64)
    HL_FAILURE_FLAG_TERRAIN,

    /**
     * Battery failure/critical low battery.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(128)
    HL_FAILURE_FLAG_BATTERY,

    /**
     * RC receiver failure/no rc connection.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(256)
    HL_FAILURE_FLAG_RC_RECEIVER,

    /**
     * Offboard link failure.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(512)
    HL_FAILURE_FLAG_OFFBOARD_LINK,

    /**
     * Engine failure.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1024)
    HL_FAILURE_FLAG_ENGINE,

    /**
     * Geofence violation.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2048)
    HL_FAILURE_FLAG_GEOFENCE,

    /**
     * Estimator failure, for example measurement rejection or large variances.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4096)
    HL_FAILURE_FLAG_ESTIMATOR,

    /**
     * Mission failure.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8192)
    HL_FAILURE_FLAG_MISSION
}
