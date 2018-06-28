package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavComponent {
    /**
     *  
     */
    @MavlinkEntryInfo(0)
    MAV_COMP_ID_ALL,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    MAV_COMP_ID_AUTOPILOT1,

    /**
     *  
     */
    @MavlinkEntryInfo(100)
    MAV_COMP_ID_CAMERA,

    /**
     *  
     */
    @MavlinkEntryInfo(101)
    MAV_COMP_ID_CAMERA2,

    /**
     *  
     */
    @MavlinkEntryInfo(102)
    MAV_COMP_ID_CAMERA3,

    /**
     *  
     */
    @MavlinkEntryInfo(103)
    MAV_COMP_ID_CAMERA4,

    /**
     *  
     */
    @MavlinkEntryInfo(104)
    MAV_COMP_ID_CAMERA5,

    /**
     *  
     */
    @MavlinkEntryInfo(105)
    MAV_COMP_ID_CAMERA6,

    /**
     *  
     */
    @MavlinkEntryInfo(140)
    MAV_COMP_ID_SERVO1,

    /**
     *  
     */
    @MavlinkEntryInfo(141)
    MAV_COMP_ID_SERVO2,

    /**
     *  
     */
    @MavlinkEntryInfo(142)
    MAV_COMP_ID_SERVO3,

    /**
     *  
     */
    @MavlinkEntryInfo(143)
    MAV_COMP_ID_SERVO4,

    /**
     *  
     */
    @MavlinkEntryInfo(144)
    MAV_COMP_ID_SERVO5,

    /**
     *  
     */
    @MavlinkEntryInfo(145)
    MAV_COMP_ID_SERVO6,

    /**
     *  
     */
    @MavlinkEntryInfo(146)
    MAV_COMP_ID_SERVO7,

    /**
     *  
     */
    @MavlinkEntryInfo(147)
    MAV_COMP_ID_SERVO8,

    /**
     *  
     */
    @MavlinkEntryInfo(148)
    MAV_COMP_ID_SERVO9,

    /**
     *  
     */
    @MavlinkEntryInfo(149)
    MAV_COMP_ID_SERVO10,

    /**
     *  
     */
    @MavlinkEntryInfo(150)
    MAV_COMP_ID_SERVO11,

    /**
     *  
     */
    @MavlinkEntryInfo(151)
    MAV_COMP_ID_SERVO12,

    /**
     *  
     */
    @MavlinkEntryInfo(152)
    MAV_COMP_ID_SERVO13,

    /**
     *  
     */
    @MavlinkEntryInfo(153)
    MAV_COMP_ID_SERVO14,

    /**
     *  
     */
    @MavlinkEntryInfo(154)
    MAV_COMP_ID_GIMBAL,

    /**
     *  
     */
    @MavlinkEntryInfo(155)
    MAV_COMP_ID_LOG,

    /**
     *  
     */
    @MavlinkEntryInfo(156)
    MAV_COMP_ID_ADSB,

    /**
     * On Screen Display (OSD) devices for video links 
     */
    @MavlinkEntryInfo(157)
    MAV_COMP_ID_OSD,

    /**
     * Generic autopilot peripheral component ID. Meant for devices that do not implement the 
     * parameter sub-protocol 
     */
    @MavlinkEntryInfo(158)
    MAV_COMP_ID_PERIPHERAL,

    /**
     *  
     */
    @MavlinkEntryInfo(159)
    MAV_COMP_ID_QX1_GIMBAL,

    /**
     *  
     */
    @MavlinkEntryInfo(160)
    MAV_COMP_ID_FLARM,

    /**
     *  
     */
    @MavlinkEntryInfo(180)
    MAV_COMP_ID_MAPPER,

    /**
     *  
     */
    @MavlinkEntryInfo(190)
    MAV_COMP_ID_MISSIONPLANNER,

    /**
     *  
     */
    @MavlinkEntryInfo(195)
    MAV_COMP_ID_PATHPLANNER,

    /**
     *  
     */
    @MavlinkEntryInfo(200)
    MAV_COMP_ID_IMU,

    /**
     *  
     */
    @MavlinkEntryInfo(201)
    MAV_COMP_ID_IMU_2,

    /**
     *  
     */
    @MavlinkEntryInfo(202)
    MAV_COMP_ID_IMU_3,

    /**
     *  
     */
    @MavlinkEntryInfo(220)
    MAV_COMP_ID_GPS,

    /**
     *  
     */
    @MavlinkEntryInfo(221)
    MAV_COMP_ID_GPS2,

    /**
     *  
     */
    @MavlinkEntryInfo(240)
    MAV_COMP_ID_UDP_BRIDGE,

    /**
     *  
     */
    @MavlinkEntryInfo(241)
    MAV_COMP_ID_UART_BRIDGE,

    /**
     *  
     */
    @MavlinkEntryInfo(250)
    MAV_COMP_ID_SYSTEM_CONTROL
}
