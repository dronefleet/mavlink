package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum MavComponent {
  /**
   * null
   */
  @MavlinkEntryInfo(0)
  MAV_COMP_ID_ALL,

  /**
   * null
   */
  @MavlinkEntryInfo(1)
  MAV_COMP_ID_AUTOPILOT1,

  /**
   * null
   */
  @MavlinkEntryInfo(100)
  MAV_COMP_ID_CAMERA,

  /**
   * null
   */
  @MavlinkEntryInfo(101)
  MAV_COMP_ID_CAMERA2,

  /**
   * null
   */
  @MavlinkEntryInfo(102)
  MAV_COMP_ID_CAMERA3,

  /**
   * null
   */
  @MavlinkEntryInfo(103)
  MAV_COMP_ID_CAMERA4,

  /**
   * null
   */
  @MavlinkEntryInfo(104)
  MAV_COMP_ID_CAMERA5,

  /**
   * null
   */
  @MavlinkEntryInfo(105)
  MAV_COMP_ID_CAMERA6,

  /**
   * null
   */
  @MavlinkEntryInfo(140)
  MAV_COMP_ID_SERVO1,

  /**
   * null
   */
  @MavlinkEntryInfo(141)
  MAV_COMP_ID_SERVO2,

  /**
   * null
   */
  @MavlinkEntryInfo(142)
  MAV_COMP_ID_SERVO3,

  /**
   * null
   */
  @MavlinkEntryInfo(143)
  MAV_COMP_ID_SERVO4,

  /**
   * null
   */
  @MavlinkEntryInfo(144)
  MAV_COMP_ID_SERVO5,

  /**
   * null
   */
  @MavlinkEntryInfo(145)
  MAV_COMP_ID_SERVO6,

  /**
   * null
   */
  @MavlinkEntryInfo(146)
  MAV_COMP_ID_SERVO7,

  /**
   * null
   */
  @MavlinkEntryInfo(147)
  MAV_COMP_ID_SERVO8,

  /**
   * null
   */
  @MavlinkEntryInfo(148)
  MAV_COMP_ID_SERVO9,

  /**
   * null
   */
  @MavlinkEntryInfo(149)
  MAV_COMP_ID_SERVO10,

  /**
   * null
   */
  @MavlinkEntryInfo(150)
  MAV_COMP_ID_SERVO11,

  /**
   * null
   */
  @MavlinkEntryInfo(151)
  MAV_COMP_ID_SERVO12,

  /**
   * null
   */
  @MavlinkEntryInfo(152)
  MAV_COMP_ID_SERVO13,

  /**
   * null
   */
  @MavlinkEntryInfo(153)
  MAV_COMP_ID_SERVO14,

  /**
   * null
   */
  @MavlinkEntryInfo(154)
  MAV_COMP_ID_GIMBAL,

  /**
   * null
   */
  @MavlinkEntryInfo(155)
  MAV_COMP_ID_LOG,

  /**
   * null
   */
  @MavlinkEntryInfo(156)
  MAV_COMP_ID_ADSB,

  /**
   * On Screen Display (OSD) devices for video links
   */
  @MavlinkEntryInfo(157)
  MAV_COMP_ID_OSD,

  /**
   * Generic autopilot peripheral component ID. Meant for devices that do not implement the parameter sub-protocol
   */
  @MavlinkEntryInfo(158)
  MAV_COMP_ID_PERIPHERAL,

  /**
   * null
   */
  @MavlinkEntryInfo(159)
  MAV_COMP_ID_QX1_GIMBAL,

  /**
   * null
   */
  @MavlinkEntryInfo(160)
  MAV_COMP_ID_FLARM,

  /**
   * null
   */
  @MavlinkEntryInfo(180)
  MAV_COMP_ID_MAPPER,

  /**
   * null
   */
  @MavlinkEntryInfo(190)
  MAV_COMP_ID_MISSIONPLANNER,

  /**
   * null
   */
  @MavlinkEntryInfo(195)
  MAV_COMP_ID_PATHPLANNER,

  /**
   * null
   */
  @MavlinkEntryInfo(200)
  MAV_COMP_ID_IMU,

  /**
   * null
   */
  @MavlinkEntryInfo(201)
  MAV_COMP_ID_IMU_2,

  /**
   * null
   */
  @MavlinkEntryInfo(202)
  MAV_COMP_ID_IMU_3,

  /**
   * null
   */
  @MavlinkEntryInfo(220)
  MAV_COMP_ID_GPS,

  /**
   * null
   */
  @MavlinkEntryInfo(221)
  MAV_COMP_ID_GPS2,

  /**
   * null
   */
  @MavlinkEntryInfo(240)
  MAV_COMP_ID_UDP_BRIDGE,

  /**
   * null
   */
  @MavlinkEntryInfo(241)
  MAV_COMP_ID_UART_BRIDGE,

  /**
   * null
   */
  @MavlinkEntryInfo(250)
  MAV_COMP_ID_SYSTEM_CONTROL
}
