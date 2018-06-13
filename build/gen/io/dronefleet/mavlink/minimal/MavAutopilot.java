package io.dronefleet.mavlink.minimal;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Micro air vehicle / autopilot classes. This identifies the individual model. 
 */
@MavlinkEnum
public enum MavAutopilot {
  /**
   * Generic autopilot, full support for everything
   */
  @MavlinkEnumEntry(0)
  MAV_AUTOPILOT_GENERIC,

  /**
   * PIXHAWK autopilot, http://pixhawk.ethz.ch
   */
  @MavlinkEnumEntry(1)
  MAV_AUTOPILOT_PIXHAWK,

  /**
   * SLUGS autopilot, http://slugsuav.soe.ucsc.edu
   */
  @MavlinkEnumEntry(2)
  MAV_AUTOPILOT_SLUGS,

  /**
   * ArduPilotMega / ArduCopter, http://diydrones.com
   */
  @MavlinkEnumEntry(3)
  MAV_AUTOPILOT_ARDUPILOTMEGA,

  /**
   * OpenPilot, http://openpilot.org
   */
  @MavlinkEnumEntry(4)
  MAV_AUTOPILOT_OPENPILOT,

  /**
   * Generic autopilot only supporting simple waypoints
   */
  @MavlinkEnumEntry(5)
  MAV_AUTOPILOT_GENERIC_WAYPOINTS_ONLY,

  /**
   * Generic autopilot supporting waypoints and other simple navigation commands
   */
  @MavlinkEnumEntry(6)
  MAV_AUTOPILOT_GENERIC_WAYPOINTS_AND_SIMPLE_NAVIGATION_ONLY,

  /**
   * Generic autopilot supporting the full mission command set
   */
  @MavlinkEnumEntry(7)
  MAV_AUTOPILOT_GENERIC_MISSION_FULL,

  /**
   * No valid autopilot, e.g. a GCS or other MAVLink component
   */
  @MavlinkEnumEntry(8)
  MAV_AUTOPILOT_INVALID,

  /**
   * PPZ UAV - http://nongnu.org/paparazzi
   */
  @MavlinkEnumEntry(9)
  MAV_AUTOPILOT_PPZ,

  /**
   * UAV Dev Board
   */
  @MavlinkEnumEntry(10)
  MAV_AUTOPILOT_UDB,

  /**
   * FlexiPilot
   */
  @MavlinkEnumEntry(11)
  MAV_AUTOPILOT_FP
}
