package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum MavComponent {
    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    MAV_COMP_ID_ALL,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    MAV_COMP_ID_AUTOPILOT1,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(100)
    MAV_COMP_ID_CAMERA,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(101)
    MAV_COMP_ID_CAMERA2,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(102)
    MAV_COMP_ID_CAMERA3,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(103)
    MAV_COMP_ID_CAMERA4,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(104)
    MAV_COMP_ID_CAMERA5,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(105)
    MAV_COMP_ID_CAMERA6,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(140)
    MAV_COMP_ID_SERVO1,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(141)
    MAV_COMP_ID_SERVO2,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(142)
    MAV_COMP_ID_SERVO3,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(143)
    MAV_COMP_ID_SERVO4,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(144)
    MAV_COMP_ID_SERVO5,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(145)
    MAV_COMP_ID_SERVO6,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(146)
    MAV_COMP_ID_SERVO7,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(147)
    MAV_COMP_ID_SERVO8,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(148)
    MAV_COMP_ID_SERVO9,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(149)
    MAV_COMP_ID_SERVO10,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(150)
    MAV_COMP_ID_SERVO11,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(151)
    MAV_COMP_ID_SERVO12,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(152)
    MAV_COMP_ID_SERVO13,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(153)
    MAV_COMP_ID_SERVO14,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(154)
    MAV_COMP_ID_GIMBAL,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(155)
    MAV_COMP_ID_LOG,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(156)
    MAV_COMP_ID_ADSB,

    /**
     * On Screen Display (OSD) devices for video links<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(157)
    MAV_COMP_ID_OSD,

    /**
     * Generic autopilot peripheral component ID. Meant for devices that do not implement the parameter sub-protocol<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(158)
    MAV_COMP_ID_PERIPHERAL,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(159)
    MAV_COMP_ID_QX1_GIMBAL,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(160)
    MAV_COMP_ID_FLARM,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(180)
    MAV_COMP_ID_MAPPER,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(190)
    MAV_COMP_ID_MISSIONPLANNER,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(195)
    MAV_COMP_ID_PATHPLANNER,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(200)
    MAV_COMP_ID_IMU,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(201)
    MAV_COMP_ID_IMU_2,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(202)
    MAV_COMP_ID_IMU_3,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(220)
    MAV_COMP_ID_GPS,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(221)
    MAV_COMP_ID_GPS2,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(240)
    MAV_COMP_ID_UDP_BRIDGE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(241)
    MAV_COMP_ID_UART_BRIDGE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(250)
    MAV_COMP_ID_SYSTEM_CONTROL
}
