package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum MavComponent {
  /**
   * null
   */
  @MavlinkEnumEntry(0)
  MAV_COMP_ID_ALL,

  /**
   * null
   */
  @MavlinkEnumEntry(1)
  MAV_COMP_ID_AUTOPILOT1,

  /**
   * null
   */
  @MavlinkEnumEntry(100)
  MAV_COMP_ID_CAMERA,

  /**
   * null
   */
  @MavlinkEnumEntry(101)
  MAV_COMP_ID_CAMERA2,

  /**
   * null
   */
  @MavlinkEnumEntry(102)
  MAV_COMP_ID_CAMERA3,

  /**
   * null
   */
  @MavlinkEnumEntry(103)
  MAV_COMP_ID_CAMERA4,

  /**
   * null
   */
  @MavlinkEnumEntry(104)
  MAV_COMP_ID_CAMERA5,

  /**
   * null
   */
  @MavlinkEnumEntry(105)
  MAV_COMP_ID_CAMERA6,

  /**
   * null
   */
  @MavlinkEnumEntry(140)
  MAV_COMP_ID_SERVO1,

  /**
   * null
   */
  @MavlinkEnumEntry(141)
  MAV_COMP_ID_SERVO2,

  /**
   * null
   */
  @MavlinkEnumEntry(142)
  MAV_COMP_ID_SERVO3,

  /**
   * null
   */
  @MavlinkEnumEntry(143)
  MAV_COMP_ID_SERVO4,

  /**
   * null
   */
  @MavlinkEnumEntry(144)
  MAV_COMP_ID_SERVO5,

  /**
   * null
   */
  @MavlinkEnumEntry(145)
  MAV_COMP_ID_SERVO6,

  /**
   * null
   */
  @MavlinkEnumEntry(146)
  MAV_COMP_ID_SERVO7,

  /**
   * null
   */
  @MavlinkEnumEntry(147)
  MAV_COMP_ID_SERVO8,

  /**
   * null
   */
  @MavlinkEnumEntry(148)
  MAV_COMP_ID_SERVO9,

  /**
   * null
   */
  @MavlinkEnumEntry(149)
  MAV_COMP_ID_SERVO10,

  /**
   * null
   */
  @MavlinkEnumEntry(150)
  MAV_COMP_ID_SERVO11,

  /**
   * null
   */
  @MavlinkEnumEntry(151)
  MAV_COMP_ID_SERVO12,

  /**
   * null
   */
  @MavlinkEnumEntry(152)
  MAV_COMP_ID_SERVO13,

  /**
   * null
   */
  @MavlinkEnumEntry(153)
  MAV_COMP_ID_SERVO14,

  /**
   * null
   */
  @MavlinkEnumEntry(154)
  MAV_COMP_ID_GIMBAL,

  /**
   * null
   */
  @MavlinkEnumEntry(155)
  MAV_COMP_ID_LOG,

  /**
   * null
   */
  @MavlinkEnumEntry(156)
  MAV_COMP_ID_ADSB,

  /**
   * On Screen Display (OSD) devices for video links
   */
  @MavlinkEnumEntry(157)
  MAV_COMP_ID_OSD,

  /**
   * Generic autopilot peripheral component ID. Meant for devices that do not implement the parameter sub-protocol
   */
  @MavlinkEnumEntry(158)
  MAV_COMP_ID_PERIPHERAL,

  /**
   * null
   */
  @MavlinkEnumEntry(159)
  MAV_COMP_ID_QX1_GIMBAL,

  /**
   * null
   */
  @MavlinkEnumEntry(160)
  MAV_COMP_ID_FLARM,

  /**
   * null
   */
  @MavlinkEnumEntry(180)
  MAV_COMP_ID_MAPPER,

  /**
   * null
   */
  @MavlinkEnumEntry(190)
  MAV_COMP_ID_MISSIONPLANNER,

  /**
   * null
   */
  @MavlinkEnumEntry(195)
  MAV_COMP_ID_PATHPLANNER,

  /**
   * null
   */
  @MavlinkEnumEntry(200)
  MAV_COMP_ID_IMU,

  /**
   * null
   */
  @MavlinkEnumEntry(201)
  MAV_COMP_ID_IMU_2,

  /**
   * null
   */
  @MavlinkEnumEntry(202)
  MAV_COMP_ID_IMU_3,

  /**
   * null
   */
  @MavlinkEnumEntry(220)
  MAV_COMP_ID_GPS,

  /**
   * null
   */
  @MavlinkEnumEntry(221)
  MAV_COMP_ID_GPS2,

  /**
   * null
   */
  @MavlinkEnumEntry(240)
  MAV_COMP_ID_UDP_BRIDGE,

  /**
   * null
   */
  @MavlinkEnumEntry(241)
  MAV_COMP_ID_UART_BRIDGE,

  /**
   * null
   */
  @MavlinkEnumEntry(250)
  MAV_COMP_ID_SYSTEM_CONTROL
}
