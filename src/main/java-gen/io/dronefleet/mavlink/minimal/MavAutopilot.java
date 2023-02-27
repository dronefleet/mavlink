package io.dronefleet.mavlink.minimal;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Micro air vehicle / autopilot classes. This identifies the individual model. 
 */
@MavlinkEnum
public enum MavAutopilot {
    /**
     * Generic autopilot, full support for everything 
     */
    @MavlinkEntryInfo(0)
    MAV_AUTOPILOT_GENERIC,

    /**
     * Reserved for future use. 
     */
    @MavlinkEntryInfo(1)
    MAV_AUTOPILOT_RESERVED,

    /**
     * SLUGS autopilot, http://slugsuav.soe.ucsc.edu 
     */
    @MavlinkEntryInfo(2)
    MAV_AUTOPILOT_SLUGS,

    /**
     * ArduPilot - Plane/Copter/Rover/Sub/Tracker, https://ardupilot.org 
     */
    @MavlinkEntryInfo(3)
    MAV_AUTOPILOT_ARDUPILOTMEGA,

    /**
     * OpenPilot, http://openpilot.org 
     */
    @MavlinkEntryInfo(4)
    MAV_AUTOPILOT_OPENPILOT,

    /**
     * Generic autopilot only supporting simple waypoints 
     */
    @MavlinkEntryInfo(5)
    MAV_AUTOPILOT_GENERIC_WAYPOINTS_ONLY,

    /**
     * Generic autopilot supporting waypoints and other simple navigation commands 
     */
    @MavlinkEntryInfo(6)
    MAV_AUTOPILOT_GENERIC_WAYPOINTS_AND_SIMPLE_NAVIGATION_ONLY,

    /**
     * Generic autopilot supporting the full mission command set 
     */
    @MavlinkEntryInfo(7)
    MAV_AUTOPILOT_GENERIC_MISSION_FULL,

    /**
     * No valid autopilot, e.g. a GCS or other MAVLink component 
     */
    @MavlinkEntryInfo(8)
    MAV_AUTOPILOT_INVALID,

    /**
     * PPZ UAV - http://nongnu.org/paparazzi 
     */
    @MavlinkEntryInfo(9)
    MAV_AUTOPILOT_PPZ,

    /**
     * UAV Dev Board 
     */
    @MavlinkEntryInfo(10)
    MAV_AUTOPILOT_UDB,

    /**
     * FlexiPilot 
     */
    @MavlinkEntryInfo(11)
    MAV_AUTOPILOT_FP,

    /**
     * PX4 Autopilot - http://px4.io/ 
     */
    @MavlinkEntryInfo(12)
    MAV_AUTOPILOT_PX4,

    /**
     * SMACCMPilot - http://smaccmpilot.org 
     */
    @MavlinkEntryInfo(13)
    MAV_AUTOPILOT_SMACCMPILOT,

    /**
     * AutoQuad -- http://autoquad.org 
     */
    @MavlinkEntryInfo(14)
    MAV_AUTOPILOT_AUTOQUAD,

    /**
     * Armazila -- http://armazila.com 
     */
    @MavlinkEntryInfo(15)
    MAV_AUTOPILOT_ARMAZILA,

    /**
     * Aerob -- http://aerob.ru 
     */
    @MavlinkEntryInfo(16)
    MAV_AUTOPILOT_AEROB,

    /**
     * ASLUAV autopilot -- http://www.asl.ethz.ch 
     */
    @MavlinkEntryInfo(17)
    MAV_AUTOPILOT_ASLUAV,

    /**
     * SmartAP Autopilot - http://sky-drones.com 
     */
    @MavlinkEntryInfo(18)
    MAV_AUTOPILOT_SMARTAP,

    /**
     * AirRails - http://uaventure.com 
     */
    @MavlinkEntryInfo(19)
    MAV_AUTOPILOT_AIRRAILS,

    /**
     * Fusion Reflex - https://fusion.engineering 
     */
    @MavlinkEntryInfo(20)
    MAV_AUTOPILOT_REFLEX
}
