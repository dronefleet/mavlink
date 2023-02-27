package io.dronefleet.mavlink.minimal;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;
import java.lang.Deprecated;

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
     * Target id (target_component) used to broadcast messages to all components of the receiving 
     * system. Components should attempt to process messages with this component ID and forward to 
     * components on any other interfaces. Note: This is not a valid *source* component id for a 
     * message. 
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
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(25)
    MAV_COMP_ID_USER1,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(26)
    MAV_COMP_ID_USER2,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(27)
    MAV_COMP_ID_USER3,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(28)
    MAV_COMP_ID_USER4,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(29)
    MAV_COMP_ID_USER5,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(30)
    MAV_COMP_ID_USER6,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(31)
    MAV_COMP_ID_USER7,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(32)
    MAV_COMP_ID_USER8,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(33)
    MAV_COMP_ID_USER9,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(34)
    MAV_COMP_ID_USER10,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(35)
    MAV_COMP_ID_USER11,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(36)
    MAV_COMP_ID_USER12,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(37)
    MAV_COMP_ID_USER13,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(38)
    MAV_COMP_ID_USER14,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(39)
    MAV_COMP_ID_USER15,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(40)
    MAV_COMP_ID_USER16,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(41)
    MAV_COMP_ID_USER17,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(42)
    MAV_COMP_ID_USER18,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(43)
    MAV_COMP_ID_USER19,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(44)
    MAV_COMP_ID_USER20,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(45)
    MAV_COMP_ID_USER21,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(46)
    MAV_COMP_ID_USER22,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(47)
    MAV_COMP_ID_USER23,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(48)
    MAV_COMP_ID_USER24,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(49)
    MAV_COMP_ID_USER25,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(50)
    MAV_COMP_ID_USER26,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(51)
    MAV_COMP_ID_USER27,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(52)
    MAV_COMP_ID_USER28,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(53)
    MAV_COMP_ID_USER29,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(54)
    MAV_COMP_ID_USER30,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(55)
    MAV_COMP_ID_USER31,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(56)
    MAV_COMP_ID_USER32,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(57)
    MAV_COMP_ID_USER33,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(58)
    MAV_COMP_ID_USER34,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(59)
    MAV_COMP_ID_USER35,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(60)
    MAV_COMP_ID_USER36,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(61)
    MAV_COMP_ID_USER37,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(62)
    MAV_COMP_ID_USER38,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(63)
    MAV_COMP_ID_USER39,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(64)
    MAV_COMP_ID_USER40,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(65)
    MAV_COMP_ID_USER41,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(66)
    MAV_COMP_ID_USER42,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(67)
    MAV_COMP_ID_USER43,

    /**
     * Telemetry radio (e.g. SiK radio, or other component that emits RADIO_STATUS messages). 
     */
    @MavlinkEntryInfo(68)
    MAV_COMP_ID_TELEMETRY_RADIO,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(69)
    MAV_COMP_ID_USER45,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(70)
    MAV_COMP_ID_USER46,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(71)
    MAV_COMP_ID_USER47,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(72)
    MAV_COMP_ID_USER48,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(73)
    MAV_COMP_ID_USER49,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(74)
    MAV_COMP_ID_USER50,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(75)
    MAV_COMP_ID_USER51,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(76)
    MAV_COMP_ID_USER52,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(77)
    MAV_COMP_ID_USER53,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(78)
    MAV_COMP_ID_USER54,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(79)
    MAV_COMP_ID_USER55,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(80)
    MAV_COMP_ID_USER56,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(81)
    MAV_COMP_ID_USER57,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(82)
    MAV_COMP_ID_USER58,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(83)
    MAV_COMP_ID_USER59,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(84)
    MAV_COMP_ID_USER60,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(85)
    MAV_COMP_ID_USER61,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(86)
    MAV_COMP_ID_USER62,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(87)
    MAV_COMP_ID_USER63,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(88)
    MAV_COMP_ID_USER64,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(89)
    MAV_COMP_ID_USER65,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(90)
    MAV_COMP_ID_USER66,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(91)
    MAV_COMP_ID_USER67,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(92)
    MAV_COMP_ID_USER68,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(93)
    MAV_COMP_ID_USER69,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(94)
    MAV_COMP_ID_USER70,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(95)
    MAV_COMP_ID_USER71,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(96)
    MAV_COMP_ID_USER72,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(97)
    MAV_COMP_ID_USER73,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(98)
    MAV_COMP_ID_USER74,

    /**
     * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not 
     * be published by components outside of the private network. 
     */
    @MavlinkEntryInfo(99)
    MAV_COMP_ID_USER75,

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
     * Gimbal #1. 
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
     * @deprecated Since 2018-11, replaced by MAV_COMP_ID_GIMBAL. All gimbals should use 
     * MAV_COMP_ID_GIMBAL. 
     */
    @MavlinkEntryInfo(159)
    @Deprecated
    MAV_COMP_ID_QX1_GIMBAL,

    /**
     * FLARM collision alert component. 
     */
    @MavlinkEntryInfo(160)
    MAV_COMP_ID_FLARM,

    /**
     * Parachute component. 
     */
    @MavlinkEntryInfo(161)
    MAV_COMP_ID_PARACHUTE,

    /**
     * Winch component. 
     */
    @MavlinkEntryInfo(169)
    MAV_COMP_ID_WINCH,

    /**
     * Gimbal #2. 
     */
    @MavlinkEntryInfo(171)
    MAV_COMP_ID_GIMBAL2,

    /**
     * Gimbal #3. 
     */
    @MavlinkEntryInfo(172)
    MAV_COMP_ID_GIMBAL3,

    /**
     * Gimbal #4 
     */
    @MavlinkEntryInfo(173)
    MAV_COMP_ID_GIMBAL4,

    /**
     * Gimbal #5. 
     */
    @MavlinkEntryInfo(174)
    MAV_COMP_ID_GIMBAL5,

    /**
     * Gimbal #6. 
     */
    @MavlinkEntryInfo(175)
    MAV_COMP_ID_GIMBAL6,

    /**
     * Battery #1. 
     */
    @MavlinkEntryInfo(180)
    MAV_COMP_ID_BATTERY,

    /**
     * Battery #2. 
     */
    @MavlinkEntryInfo(181)
    MAV_COMP_ID_BATTERY2,

    /**
     * CAN over MAVLink client. 
     */
    @MavlinkEntryInfo(189)
    MAV_COMP_ID_MAVCAN,

    /**
     * Component that can generate/supply a mission flight plan (e.g. GCS or developer API). 
     */
    @MavlinkEntryInfo(190)
    MAV_COMP_ID_MISSIONPLANNER,

    /**
     * Component that lives on the onboard computer (companion computer) and has some generic 
     * functionalities, such as settings system parameters and monitoring the status of some 
     * processes that don't directly speak mavlink and so on. 
     */
    @MavlinkEntryInfo(191)
    MAV_COMP_ID_ONBOARD_COMPUTER,

    /**
     * Component that lives on the onboard computer (companion computer) and has some generic 
     * functionalities, such as settings system parameters and monitoring the status of some 
     * processes that don't directly speak mavlink and so on. 
     */
    @MavlinkEntryInfo(192)
    MAV_COMP_ID_ONBOARD_COMPUTER2,

    /**
     * Component that lives on the onboard computer (companion computer) and has some generic 
     * functionalities, such as settings system parameters and monitoring the status of some 
     * processes that don't directly speak mavlink and so on. 
     */
    @MavlinkEntryInfo(193)
    MAV_COMP_ID_ONBOARD_COMPUTER3,

    /**
     * Component that lives on the onboard computer (companion computer) and has some generic 
     * functionalities, such as settings system parameters and monitoring the status of some 
     * processes that don't directly speak mavlink and so on. 
     */
    @MavlinkEntryInfo(194)
    MAV_COMP_ID_ONBOARD_COMPUTER4,

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
     * Component that manages pairing of vehicle and GCS. 
     */
    @MavlinkEntryInfo(198)
    MAV_COMP_ID_PAIRING_MANAGER,

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
     * Open Drone ID transmitter/receiver (Bluetooth/WiFi/Internet). 
     */
    @MavlinkEntryInfo(236)
    MAV_COMP_ID_ODID_TXRX_1,

    /**
     * Open Drone ID transmitter/receiver (Bluetooth/WiFi/Internet). 
     */
    @MavlinkEntryInfo(237)
    MAV_COMP_ID_ODID_TXRX_2,

    /**
     * Open Drone ID transmitter/receiver (Bluetooth/WiFi/Internet). 
     */
    @MavlinkEntryInfo(238)
    MAV_COMP_ID_ODID_TXRX_3,

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
     * Component handling TUNNEL messages (e.g. vendor specific GUI of a component). 
     */
    @MavlinkEntryInfo(242)
    MAV_COMP_ID_TUNNEL_NODE,

    /**
     * Deprecated, don't use. Component for handling system messages (e.g. to ARM, takeoff, etc.). 
     * @deprecated Since 2018-11, replaced by MAV_COMP_ID_ALL. System control does not require a 
     * separate component ID. Instead, system commands should be sent with 
     * target_component=MAV_COMP_ID_ALL allowing the target component to use any appropriate 
     * component id. 
     */
    @MavlinkEntryInfo(250)
    @Deprecated
    MAV_COMP_ID_SYSTEM_CONTROL
}
