package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * These encode the sensors whose status is sent as part of the {@link io.dronefleet.mavlink.common.SysStatus SYS_STATUS} message. 
 */
@MavlinkEnum
public enum MavSysStatusSensor {
    /**
     * 0x01 3D gyro 
     */
    @MavlinkEntryInfo(1)
    MAV_SYS_STATUS_SENSOR_3D_GYRO,

    /**
     * 0x02 3D accelerometer 
     */
    @MavlinkEntryInfo(2)
    MAV_SYS_STATUS_SENSOR_3D_ACCEL,

    /**
     * 0x04 3D magnetometer 
     */
    @MavlinkEntryInfo(4)
    MAV_SYS_STATUS_SENSOR_3D_MAG,

    /**
     * 0x08 absolute pressure 
     */
    @MavlinkEntryInfo(8)
    MAV_SYS_STATUS_SENSOR_ABSOLUTE_PRESSURE,

    /**
     * 0x10 differential pressure 
     */
    @MavlinkEntryInfo(16)
    MAV_SYS_STATUS_SENSOR_DIFFERENTIAL_PRESSURE,

    /**
     * 0x20 GPS 
     */
    @MavlinkEntryInfo(32)
    MAV_SYS_STATUS_SENSOR_GPS,

    /**
     * 0x40 optical flow 
     */
    @MavlinkEntryInfo(64)
    MAV_SYS_STATUS_SENSOR_OPTICAL_FLOW,

    /**
     * 0x80 computer vision position 
     */
    @MavlinkEntryInfo(128)
    MAV_SYS_STATUS_SENSOR_VISION_POSITION,

    /**
     * 0x100 laser based position 
     */
    @MavlinkEntryInfo(256)
    MAV_SYS_STATUS_SENSOR_LASER_POSITION,

    /**
     * 0x200 external ground truth (Vicon or Leica) 
     */
    @MavlinkEntryInfo(512)
    MAV_SYS_STATUS_SENSOR_EXTERNAL_GROUND_TRUTH,

    /**
     * 0x400 3D angular rate control 
     */
    @MavlinkEntryInfo(1024)
    MAV_SYS_STATUS_SENSOR_ANGULAR_RATE_CONTROL,

    /**
     * 0x800 attitude stabilization 
     */
    @MavlinkEntryInfo(2048)
    MAV_SYS_STATUS_SENSOR_ATTITUDE_STABILIZATION,

    /**
     * 0x1000 yaw position 
     */
    @MavlinkEntryInfo(4096)
    MAV_SYS_STATUS_SENSOR_YAW_POSITION,

    /**
     * 0x2000 z/altitude control 
     */
    @MavlinkEntryInfo(8192)
    MAV_SYS_STATUS_SENSOR_Z_ALTITUDE_CONTROL,

    /**
     * 0x4000 x/y position control 
     */
    @MavlinkEntryInfo(16384)
    MAV_SYS_STATUS_SENSOR_XY_POSITION_CONTROL,

    /**
     * 0x8000 motor outputs / control 
     */
    @MavlinkEntryInfo(32768)
    MAV_SYS_STATUS_SENSOR_MOTOR_OUTPUTS,

    /**
     * 0x10000 rc receiver 
     */
    @MavlinkEntryInfo(65536)
    MAV_SYS_STATUS_SENSOR_RC_RECEIVER,

    /**
     * 0x20000 2nd 3D gyro 
     */
    @MavlinkEntryInfo(131072)
    MAV_SYS_STATUS_SENSOR_3D_GYRO2,

    /**
     * 0x40000 2nd 3D accelerometer 
     */
    @MavlinkEntryInfo(262144)
    MAV_SYS_STATUS_SENSOR_3D_ACCEL2,

    /**
     * 0x80000 2nd 3D magnetometer 
     */
    @MavlinkEntryInfo(524288)
    MAV_SYS_STATUS_SENSOR_3D_MAG2,

    /**
     * 0x100000 geofence 
     */
    @MavlinkEntryInfo(1048576)
    MAV_SYS_STATUS_GEOFENCE,

    /**
     * 0x200000 AHRS subsystem health 
     */
    @MavlinkEntryInfo(2097152)
    MAV_SYS_STATUS_AHRS,

    /**
     * 0x400000 Terrain subsystem health 
     */
    @MavlinkEntryInfo(4194304)
    MAV_SYS_STATUS_TERRAIN,

    /**
     * 0x800000 Motors are reversed 
     */
    @MavlinkEntryInfo(8388608)
    MAV_SYS_STATUS_REVERSE_MOTOR,

    /**
     * 0x1000000 Logging 
     */
    @MavlinkEntryInfo(16777216)
    MAV_SYS_STATUS_LOGGING,

    /**
     * 0x2000000 Battery 
     */
    @MavlinkEntryInfo(33554432)
    MAV_SYS_STATUS_SENSOR_BATTERY,

    /**
     * 0x4000000 Proximity 
     */
    @MavlinkEntryInfo(67108864)
    MAV_SYS_STATUS_SENSOR_PROXIMITY
}
