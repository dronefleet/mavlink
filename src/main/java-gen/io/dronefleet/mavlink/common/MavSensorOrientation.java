package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Enumeration of sensor orientation, according to its rotations 
 */
@MavlinkEnum
public enum MavSensorOrientation {
    /**
     * Roll: 0, Pitch: 0, Yaw: 0<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    MAV_SENSOR_ROTATION_NONE,

    /**
     * Roll: 0, Pitch: 0, Yaw: 45<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    MAV_SENSOR_ROTATION_YAW_45,

    /**
     * Roll: 0, Pitch: 0, Yaw: 90<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    MAV_SENSOR_ROTATION_YAW_90,

    /**
     * Roll: 0, Pitch: 0, Yaw: 135<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    MAV_SENSOR_ROTATION_YAW_135,

    /**
     * Roll: 0, Pitch: 0, Yaw: 180<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    MAV_SENSOR_ROTATION_YAW_180,

    /**
     * Roll: 0, Pitch: 0, Yaw: 225<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(5)
    MAV_SENSOR_ROTATION_YAW_225,

    /**
     * Roll: 0, Pitch: 0, Yaw: 270<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(6)
    MAV_SENSOR_ROTATION_YAW_270,

    /**
     * Roll: 0, Pitch: 0, Yaw: 315<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(7)
    MAV_SENSOR_ROTATION_YAW_315,

    /**
     * Roll: 180, Pitch: 0, Yaw: 0<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8)
    MAV_SENSOR_ROTATION_ROLL_180,

    /**
     * Roll: 180, Pitch: 0, Yaw: 45<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(9)
    MAV_SENSOR_ROTATION_ROLL_180_YAW_45,

    /**
     * Roll: 180, Pitch: 0, Yaw: 90<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(10)
    MAV_SENSOR_ROTATION_ROLL_180_YAW_90,

    /**
     * Roll: 180, Pitch: 0, Yaw: 135<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(11)
    MAV_SENSOR_ROTATION_ROLL_180_YAW_135,

    /**
     * Roll: 0, Pitch: 180, Yaw: 0<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(12)
    MAV_SENSOR_ROTATION_PITCH_180,

    /**
     * Roll: 180, Pitch: 0, Yaw: 225<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(13)
    MAV_SENSOR_ROTATION_ROLL_180_YAW_225,

    /**
     * Roll: 180, Pitch: 0, Yaw: 270<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(14)
    MAV_SENSOR_ROTATION_ROLL_180_YAW_270,

    /**
     * Roll: 180, Pitch: 0, Yaw: 315<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(15)
    MAV_SENSOR_ROTATION_ROLL_180_YAW_315,

    /**
     * Roll: 90, Pitch: 0, Yaw: 0<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16)
    MAV_SENSOR_ROTATION_ROLL_90,

    /**
     * Roll: 90, Pitch: 0, Yaw: 45<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(17)
    MAV_SENSOR_ROTATION_ROLL_90_YAW_45,

    /**
     * Roll: 90, Pitch: 0, Yaw: 90<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(18)
    MAV_SENSOR_ROTATION_ROLL_90_YAW_90,

    /**
     * Roll: 90, Pitch: 0, Yaw: 135<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(19)
    MAV_SENSOR_ROTATION_ROLL_90_YAW_135,

    /**
     * Roll: 270, Pitch: 0, Yaw: 0<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(20)
    MAV_SENSOR_ROTATION_ROLL_270,

    /**
     * Roll: 270, Pitch: 0, Yaw: 45<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(21)
    MAV_SENSOR_ROTATION_ROLL_270_YAW_45,

    /**
     * Roll: 270, Pitch: 0, Yaw: 90<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(22)
    MAV_SENSOR_ROTATION_ROLL_270_YAW_90,

    /**
     * Roll: 270, Pitch: 0, Yaw: 135<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(23)
    MAV_SENSOR_ROTATION_ROLL_270_YAW_135,

    /**
     * Roll: 0, Pitch: 90, Yaw: 0<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(24)
    MAV_SENSOR_ROTATION_PITCH_90,

    /**
     * Roll: 0, Pitch: 270, Yaw: 0<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(25)
    MAV_SENSOR_ROTATION_PITCH_270,

    /**
     * Roll: 0, Pitch: 180, Yaw: 90<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(26)
    MAV_SENSOR_ROTATION_PITCH_180_YAW_90,

    /**
     * Roll: 0, Pitch: 180, Yaw: 270<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(27)
    MAV_SENSOR_ROTATION_PITCH_180_YAW_270,

    /**
     * Roll: 90, Pitch: 90, Yaw: 0<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(28)
    MAV_SENSOR_ROTATION_ROLL_90_PITCH_90,

    /**
     * Roll: 180, Pitch: 90, Yaw: 0<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(29)
    MAV_SENSOR_ROTATION_ROLL_180_PITCH_90,

    /**
     * Roll: 270, Pitch: 90, Yaw: 0<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(30)
    MAV_SENSOR_ROTATION_ROLL_270_PITCH_90,

    /**
     * Roll: 90, Pitch: 180, Yaw: 0<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(31)
    MAV_SENSOR_ROTATION_ROLL_90_PITCH_180,

    /**
     * Roll: 270, Pitch: 180, Yaw: 0<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(32)
    MAV_SENSOR_ROTATION_ROLL_270_PITCH_180,

    /**
     * Roll: 90, Pitch: 270, Yaw: 0<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(33)
    MAV_SENSOR_ROTATION_ROLL_90_PITCH_270,

    /**
     * Roll: 180, Pitch: 270, Yaw: 0<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(34)
    MAV_SENSOR_ROTATION_ROLL_180_PITCH_270,

    /**
     * Roll: 270, Pitch: 270, Yaw: 0<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(35)
    MAV_SENSOR_ROTATION_ROLL_270_PITCH_270,

    /**
     * Roll: 90, Pitch: 180, Yaw: 90<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(36)
    MAV_SENSOR_ROTATION_ROLL_90_PITCH_180_YAW_90,

    /**
     * Roll: 90, Pitch: 0, Yaw: 270<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(37)
    MAV_SENSOR_ROTATION_ROLL_90_YAW_270,

    /**
     * Roll: 315, Pitch: 315, Yaw: 315<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(38)
    MAV_SENSOR_ROTATION_ROLL_315_PITCH_315_YAW_315
}
