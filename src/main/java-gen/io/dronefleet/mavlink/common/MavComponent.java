package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Component ids (values) for the different types and instances of onboard hardware/software 
 * that might make up a MAVLink system (autopilot, cameras, servos, GPS systems, avoidance 
 * systems etc.). Components must use the appropriate ID in their source address when sending 
 * messages. Components can also use IDs to determine if they are the intended recipient of an 
 * incoming message. The MAV_COMP_ID_ALL value is used to indicate messages that must be 
 * processed by all components. When creating new entries, components that can have multiple 
 * instances (e.g. cameras, servos etc.) should be allocated sequential values. An appropriate 
 * number of values should be left free after these components to allow the number of instances to 
 * be expanded. 
 */
@MavlinkEnum
public enum MavComponent {
    /**
     * Used to broadcast messages to all components of the receiving system. Components should 
     * attempt to process messages with this component ID and forward to components on any other 
     * interfaces. 
     */
    @MavlinkEntryInfo(0)
    MAV_COMP_ID_ALL,

    /**
     * System flight controller component ("autopilot"). Only one autopilot is expected in a 
     * particular system. 
     */
    @MavlinkEntryInfo(1)
    MAV_COMP_ID_AUTOPILOT1,

    /**
     * Camera #1. 
     */
    @MavlinkEntryInfo(100)
    MAV_COMP_ID_CAMERA,

    /**
     * Camera #2. 
     */
    @MavlinkEntryInfo(101)
    MAV_COMP_ID_CAMERA2,

    /**
     * Camera #3. 
     */
    @MavlinkEntryInfo(102)
    MAV_COMP_ID_CAMERA3,

    /**
     * Camera #4. 
     */
    @MavlinkEntryInfo(103)
    MAV_COMP_ID_CAMERA4,

    /**
     * Camera #5. 
     */
    @MavlinkEntryInfo(104)
    MAV_COMP_ID_CAMERA5,

    /**
     * Camera #6. 
     */
    @MavlinkEntryInfo(105)
    MAV_COMP_ID_CAMERA6,

    /**
     * Servo #1. 
     */
    @MavlinkEntryInfo(140)
    MAV_COMP_ID_SERVO1,

    /**
     * Servo #2. 
     */
    @MavlinkEntryInfo(141)
    MAV_COMP_ID_SERVO2,

    /**
     * Servo #3. 
     */
    @MavlinkEntryInfo(142)
    MAV_COMP_ID_SERVO3,

    /**
     * Servo #4. 
     */
    @MavlinkEntryInfo(143)
    MAV_COMP_ID_SERVO4,

    /**
     * Servo #5. 
     */
    @MavlinkEntryInfo(144)
    MAV_COMP_ID_SERVO5,

    /**
     * Servo #6. 
     */
    @MavlinkEntryInfo(145)
    MAV_COMP_ID_SERVO6,

    /**
     * Servo #7. 
     */
    @MavlinkEntryInfo(146)
    MAV_COMP_ID_SERVO7,

    /**
     * Servo #8. 
     */
    @MavlinkEntryInfo(147)
    MAV_COMP_ID_SERVO8,

    /**
     * Servo #9. 
     */
    @MavlinkEntryInfo(148)
    MAV_COMP_ID_SERVO9,

    /**
     * Servo #10. 
     */
    @MavlinkEntryInfo(149)
    MAV_COMP_ID_SERVO10,

    /**
     * Servo #11. 
     */
    @MavlinkEntryInfo(150)
    MAV_COMP_ID_SERVO11,

    /**
     * Servo #12. 
     */
    @MavlinkEntryInfo(151)
    MAV_COMP_ID_SERVO12,

    /**
     * Servo #13. 
     */
    @MavlinkEntryInfo(152)
    MAV_COMP_ID_SERVO13,

    /**
     * Servo #14. 
     */
    @MavlinkEntryInfo(153)
    MAV_COMP_ID_SERVO14,

    /**
     * Gimbal component. 
     */
    @MavlinkEntryInfo(154)
    MAV_COMP_ID_GIMBAL,

    /**
     * Logging component. 
     */
    @MavlinkEntryInfo(155)
    MAV_COMP_ID_LOG,

    /**
     * Automatic Dependent Surveillance-Broadcast (ADS-B) component. 
     */
    @MavlinkEntryInfo(156)
    MAV_COMP_ID_ADSB,

    /**
     * On Screen Display (OSD) devices for video links. 
     */
    @MavlinkEntryInfo(157)
    MAV_COMP_ID_OSD,

    /**
     * Generic autopilot peripheral component ID. Meant for devices that do not implement the 
     * parameter microservice. 
     */
    @MavlinkEntryInfo(158)
    MAV_COMP_ID_PERIPHERAL,

    /**
     * Gimbal ID for QX1. 
     */
    @MavlinkEntryInfo(159)
    MAV_COMP_ID_QX1_GIMBAL,

    /**
     * FLARM collision alert component. 
     */
    @MavlinkEntryInfo(160)
    MAV_COMP_ID_FLARM,

    /**
     * Component that can generate/supply a mission flight plan (e.g. GCS or developer API). 
     */
    @MavlinkEntryInfo(190)
    MAV_COMP_ID_MISSIONPLANNER,

    /**
     * Component that finds an optimal path between points based on a certain constraint (e.g. 
     * minimum snap, shortest path, cost, etc.). 
     */
    @MavlinkEntryInfo(195)
    MAV_COMP_ID_PATHPLANNER,

    /**
     * Component that plans a collision free path between two points. 
     */
    @MavlinkEntryInfo(196)
    MAV_COMP_ID_OBSTACLE_AVOIDANCE,

    /**
     * Component that provides position estimates using VIO techniques. 
     */
    @MavlinkEntryInfo(197)
    MAV_COMP_ID_VISUAL_INERTIAL_ODOMETRY,

    /**
     * Inertial Measurement Unit (IMU) #1. 
     */
    @MavlinkEntryInfo(200)
    MAV_COMP_ID_IMU,

    /**
     * Inertial Measurement Unit (IMU) #2. 
     */
    @MavlinkEntryInfo(201)
    MAV_COMP_ID_IMU_2,

    /**
     * Inertial Measurement Unit (IMU) #3. 
     */
    @MavlinkEntryInfo(202)
    MAV_COMP_ID_IMU_3,

    /**
     * GPS #1. 
     */
    @MavlinkEntryInfo(220)
    MAV_COMP_ID_GPS,

    /**
     * GPS #2. 
     */
    @MavlinkEntryInfo(221)
    MAV_COMP_ID_GPS2,

    /**
     * Component to bridge MAVLink to UDP (i.e. from a UART). 
     */
    @MavlinkEntryInfo(240)
    MAV_COMP_ID_UDP_BRIDGE,

    /**
     * Component to bridge to UART (i.e. from UDP). 
     */
    @MavlinkEntryInfo(241)
    MAV_COMP_ID_UART_BRIDGE,

    /**
     * Component for handling system messages (e.g. to ARM, takeoff, etc.). 
     */
    @MavlinkEntryInfo(250)
    MAV_COMP_ID_SYSTEM_CONTROL
}
