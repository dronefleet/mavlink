package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Micro air vehicle / autopilot classes. This identifies the individual model. 
 */
@MavlinkEnum
public enum MavAutopilot {
    /**
     * Generic autopilot, full support for everything<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    MAV_AUTOPILOT_GENERIC,

    /**
     * Reserved for future use.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    MAV_AUTOPILOT_RESERVED,

    /**
     * SLUGS autopilot, http://slugsuav.soe.ucsc.edu<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    MAV_AUTOPILOT_SLUGS,

    /**
     * ArduPilotMega / ArduCopter, http://diydrones.com<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    MAV_AUTOPILOT_ARDUPILOTMEGA,

    /**
     * OpenPilot, http://openpilot.org<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    MAV_AUTOPILOT_OPENPILOT,

    /**
     * Generic autopilot only supporting simple waypoints<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(5)
    MAV_AUTOPILOT_GENERIC_WAYPOINTS_ONLY,

    /**
     * Generic autopilot supporting waypoints and other simple navigation commands<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(6)
    MAV_AUTOPILOT_GENERIC_WAYPOINTS_AND_SIMPLE_NAVIGATION_ONLY,

    /**
     * Generic autopilot supporting the full mission command set<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(7)
    MAV_AUTOPILOT_GENERIC_MISSION_FULL,

    /**
     * No valid autopilot, e.g. a GCS or other MAVLink component<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8)
    MAV_AUTOPILOT_INVALID,

    /**
     * PPZ UAV - http://nongnu.org/paparazzi<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(9)
    MAV_AUTOPILOT_PPZ,

    /**
     * UAV Dev Board<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(10)
    MAV_AUTOPILOT_UDB,

    /**
     * FlexiPilot<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(11)
    MAV_AUTOPILOT_FP,

    /**
     * PX4 Autopilot - http://pixhawk.ethz.ch/px4/<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(12)
    MAV_AUTOPILOT_PX4,

    /**
     * SMACCMPilot - http://smaccmpilot.org<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(13)
    MAV_AUTOPILOT_SMACCMPILOT,

    /**
     * AutoQuad -- http://autoquad.org<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(14)
    MAV_AUTOPILOT_AUTOQUAD,

    /**
     * Armazila -- http://armazila.com<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(15)
    MAV_AUTOPILOT_ARMAZILA,

    /**
     * Aerob -- http://aerob.ru<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16)
    MAV_AUTOPILOT_AEROB,

    /**
     * ASLUAV autopilot -- http://www.asl.ethz.ch<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(17)
    MAV_AUTOPILOT_ASLUAV,

    /**
     * SmartAP Autopilot - http://sky-drones.com<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(18)
    MAV_AUTOPILOT_SMARTAP,

    /**
     * AirRails - http://uaventure.com<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(19)
    MAV_AUTOPILOT_AIRRAILS
}
