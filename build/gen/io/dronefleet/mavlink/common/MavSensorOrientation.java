package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Enumeration of sensor orientation, according to its rotations 
 */
@MavlinkEnum
public enum MavSensorOrientation {
  /**
   * Roll: 0, Pitch: 0, Yaw: 0
   */
  @MavlinkEnumEntry(0)
  MAV_SENSOR_ROTATION_NONE,

  /**
   * Roll: 0, Pitch: 0, Yaw: 45
   */
  @MavlinkEnumEntry(1)
  MAV_SENSOR_ROTATION_YAW_45,

  /**
   * Roll: 0, Pitch: 0, Yaw: 90
   */
  @MavlinkEnumEntry(2)
  MAV_SENSOR_ROTATION_YAW_90,

  /**
   * Roll: 0, Pitch: 0, Yaw: 135
   */
  @MavlinkEnumEntry(3)
  MAV_SENSOR_ROTATION_YAW_135,

  /**
   * Roll: 0, Pitch: 0, Yaw: 180
   */
  @MavlinkEnumEntry(4)
  MAV_SENSOR_ROTATION_YAW_180,

  /**
   * Roll: 0, Pitch: 0, Yaw: 225
   */
  @MavlinkEnumEntry(5)
  MAV_SENSOR_ROTATION_YAW_225,

  /**
   * Roll: 0, Pitch: 0, Yaw: 270
   */
  @MavlinkEnumEntry(6)
  MAV_SENSOR_ROTATION_YAW_270,

  /**
   * Roll: 0, Pitch: 0, Yaw: 315
   */
  @MavlinkEnumEntry(7)
  MAV_SENSOR_ROTATION_YAW_315,

  /**
   * Roll: 180, Pitch: 0, Yaw: 0
   */
  @MavlinkEnumEntry(8)
  MAV_SENSOR_ROTATION_ROLL_180,

  /**
   * Roll: 180, Pitch: 0, Yaw: 45
   */
  @MavlinkEnumEntry(9)
  MAV_SENSOR_ROTATION_ROLL_180_YAW_45,

  /**
   * Roll: 180, Pitch: 0, Yaw: 90
   */
  @MavlinkEnumEntry(10)
  MAV_SENSOR_ROTATION_ROLL_180_YAW_90,

  /**
   * Roll: 180, Pitch: 0, Yaw: 135
   */
  @MavlinkEnumEntry(11)
  MAV_SENSOR_ROTATION_ROLL_180_YAW_135,

  /**
   * Roll: 0, Pitch: 180, Yaw: 0
   */
  @MavlinkEnumEntry(12)
  MAV_SENSOR_ROTATION_PITCH_180,

  /**
   * Roll: 180, Pitch: 0, Yaw: 225
   */
  @MavlinkEnumEntry(13)
  MAV_SENSOR_ROTATION_ROLL_180_YAW_225,

  /**
   * Roll: 180, Pitch: 0, Yaw: 270
   */
  @MavlinkEnumEntry(14)
  MAV_SENSOR_ROTATION_ROLL_180_YAW_270,

  /**
   * Roll: 180, Pitch: 0, Yaw: 315
   */
  @MavlinkEnumEntry(15)
  MAV_SENSOR_ROTATION_ROLL_180_YAW_315,

  /**
   * Roll: 90, Pitch: 0, Yaw: 0
   */
  @MavlinkEnumEntry(16)
  MAV_SENSOR_ROTATION_ROLL_90,

  /**
   * Roll: 90, Pitch: 0, Yaw: 45
   */
  @MavlinkEnumEntry(17)
  MAV_SENSOR_ROTATION_ROLL_90_YAW_45,

  /**
   * Roll: 90, Pitch: 0, Yaw: 90
   */
  @MavlinkEnumEntry(18)
  MAV_SENSOR_ROTATION_ROLL_90_YAW_90,

  /**
   * Roll: 90, Pitch: 0, Yaw: 135
   */
  @MavlinkEnumEntry(19)
  MAV_SENSOR_ROTATION_ROLL_90_YAW_135,

  /**
   * Roll: 270, Pitch: 0, Yaw: 0
   */
  @MavlinkEnumEntry(20)
  MAV_SENSOR_ROTATION_ROLL_270,

  /**
   * Roll: 270, Pitch: 0, Yaw: 45
   */
  @MavlinkEnumEntry(21)
  MAV_SENSOR_ROTATION_ROLL_270_YAW_45,

  /**
   * Roll: 270, Pitch: 0, Yaw: 90
   */
  @MavlinkEnumEntry(22)
  MAV_SENSOR_ROTATION_ROLL_270_YAW_90,

  /**
   * Roll: 270, Pitch: 0, Yaw: 135
   */
  @MavlinkEnumEntry(23)
  MAV_SENSOR_ROTATION_ROLL_270_YAW_135,

  /**
   * Roll: 0, Pitch: 90, Yaw: 0
   */
  @MavlinkEnumEntry(24)
  MAV_SENSOR_ROTATION_PITCH_90,

  /**
   * Roll: 0, Pitch: 270, Yaw: 0
   */
  @MavlinkEnumEntry(25)
  MAV_SENSOR_ROTATION_PITCH_270,

  /**
   * Roll: 0, Pitch: 180, Yaw: 90
   */
  @MavlinkEnumEntry(26)
  MAV_SENSOR_ROTATION_PITCH_180_YAW_90,

  /**
   * Roll: 0, Pitch: 180, Yaw: 270
   */
  @MavlinkEnumEntry(27)
  MAV_SENSOR_ROTATION_PITCH_180_YAW_270,

  /**
   * Roll: 90, Pitch: 90, Yaw: 0
   */
  @MavlinkEnumEntry(28)
  MAV_SENSOR_ROTATION_ROLL_90_PITCH_90,

  /**
   * Roll: 180, Pitch: 90, Yaw: 0
   */
  @MavlinkEnumEntry(29)
  MAV_SENSOR_ROTATION_ROLL_180_PITCH_90,

  /**
   * Roll: 270, Pitch: 90, Yaw: 0
   */
  @MavlinkEnumEntry(30)
  MAV_SENSOR_ROTATION_ROLL_270_PITCH_90,

  /**
   * Roll: 90, Pitch: 180, Yaw: 0
   */
  @MavlinkEnumEntry(31)
  MAV_SENSOR_ROTATION_ROLL_90_PITCH_180,

  /**
   * Roll: 270, Pitch: 180, Yaw: 0
   */
  @MavlinkEnumEntry(32)
  MAV_SENSOR_ROTATION_ROLL_270_PITCH_180,

  /**
   * Roll: 90, Pitch: 270, Yaw: 0
   */
  @MavlinkEnumEntry(33)
  MAV_SENSOR_ROTATION_ROLL_90_PITCH_270,

  /**
   * Roll: 180, Pitch: 270, Yaw: 0
   */
  @MavlinkEnumEntry(34)
  MAV_SENSOR_ROTATION_ROLL_180_PITCH_270,

  /**
   * Roll: 270, Pitch: 270, Yaw: 0
   */
  @MavlinkEnumEntry(35)
  MAV_SENSOR_ROTATION_ROLL_270_PITCH_270,

  /**
   * Roll: 90, Pitch: 180, Yaw: 90
   */
  @MavlinkEnumEntry(36)
  MAV_SENSOR_ROTATION_ROLL_90_PITCH_180_YAW_90,

  /**
   * Roll: 90, Pitch: 0, Yaw: 270
   */
  @MavlinkEnumEntry(37)
  MAV_SENSOR_ROTATION_ROLL_90_YAW_270,

  /**
   * Roll: 315, Pitch: 315, Yaw: 315
   */
  @MavlinkEnumEntry(38)
  MAV_SENSOR_ROTATION_ROLL_315_PITCH_315_YAW_315
}
