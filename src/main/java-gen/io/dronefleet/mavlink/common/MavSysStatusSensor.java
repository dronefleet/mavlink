package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * These encode the sensors whose status is sent as part of the SYS_STATUS message. 
 */
@MavlinkEnum
public enum MavSysStatusSensor {
    /**
     * 0x01 3D gyro<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    MAV_SYS_STATUS_SENSOR_3D_GYRO,

    /**
     * 0x02 3D accelerometer<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    MAV_SYS_STATUS_SENSOR_3D_ACCEL,

    /**
     * 0x04 3D magnetometer<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    MAV_SYS_STATUS_SENSOR_3D_MAG,

    /**
     * 0x08 absolute pressure<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8)
    MAV_SYS_STATUS_SENSOR_ABSOLUTE_PRESSURE,

    /**
     * 0x10 differential pressure<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16)
    MAV_SYS_STATUS_SENSOR_DIFFERENTIAL_PRESSURE,

    /**
     * 0x20 GPS<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(32)
    MAV_SYS_STATUS_SENSOR_GPS,

    /**
     * 0x40 optical flow<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(64)
    MAV_SYS_STATUS_SENSOR_OPTICAL_FLOW,

    /**
     * 0x80 computer vision position<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(128)
    MAV_SYS_STATUS_SENSOR_VISION_POSITION,

    /**
     * 0x100 laser based position<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(256)
    MAV_SYS_STATUS_SENSOR_LASER_POSITION,

    /**
     * 0x200 external ground truth (Vicon or Leica)<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(512)
    MAV_SYS_STATUS_SENSOR_EXTERNAL_GROUND_TRUTH,

    /**
     * 0x400 3D angular rate control<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1024)
    MAV_SYS_STATUS_SENSOR_ANGULAR_RATE_CONTROL,

    /**
     * 0x800 attitude stabilization<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2048)
    MAV_SYS_STATUS_SENSOR_ATTITUDE_STABILIZATION,

    /**
     * 0x1000 yaw position<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4096)
    MAV_SYS_STATUS_SENSOR_YAW_POSITION,

    /**
     * 0x2000 z/altitude control<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8192)
    MAV_SYS_STATUS_SENSOR_Z_ALTITUDE_CONTROL,

    /**
     * 0x4000 x/y position control<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16384)
    MAV_SYS_STATUS_SENSOR_XY_POSITION_CONTROL,

    /**
     * 0x8000 motor outputs / control<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(32768)
    MAV_SYS_STATUS_SENSOR_MOTOR_OUTPUTS,

    /**
     * 0x10000 rc receiver<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(65536)
    MAV_SYS_STATUS_SENSOR_RC_RECEIVER,

    /**
     * 0x20000 2nd 3D gyro<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(131072)
    MAV_SYS_STATUS_SENSOR_3D_GYRO2,

    /**
     * 0x40000 2nd 3D accelerometer<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(262144)
    MAV_SYS_STATUS_SENSOR_3D_ACCEL2,

    /**
     * 0x80000 2nd 3D magnetometer<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(524288)
    MAV_SYS_STATUS_SENSOR_3D_MAG2,

    /**
     * 0x100000 geofence<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1048576)
    MAV_SYS_STATUS_GEOFENCE,

    /**
     * 0x200000 AHRS subsystem health<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2097152)
    MAV_SYS_STATUS_AHRS,

    /**
     * 0x400000 Terrain subsystem health<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4194304)
    MAV_SYS_STATUS_TERRAIN,

    /**
     * 0x800000 Motors are reversed<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8388608)
    MAV_SYS_STATUS_REVERSE_MOTOR,

    /**
     * 0x1000000 Logging<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16777216)
    MAV_SYS_STATUS_LOGGING,

    /**
     * 0x2000000 Battery<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(33554432)
    MAV_SYS_STATUS_SENSOR_BATTERY,

    /**
     * 0x4000000 Proximity<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(67108864)
    MAV_SYS_STATUS_SENSOR_PROXIMITY
}
