package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * result in a mavlink mission ack 
 */
@MavlinkEnum
public enum MavMissionResult {
  /**
   * mission accepted OK
   */
  @MavlinkEnumEntry(0)
  MAV_MISSION_ACCEPTED,

  /**
   * generic error / not accepting mission commands at all right now
   */
  @MavlinkEnumEntry(1)
  MAV_MISSION_ERROR,

  /**
   * coordinate frame is not supported
   */
  @MavlinkEnumEntry(2)
  MAV_MISSION_UNSUPPORTED_FRAME,

  /**
   * command is not supported
   */
  @MavlinkEnumEntry(3)
  MAV_MISSION_UNSUPPORTED,

  /**
   * mission item exceeds storage space
   */
  @MavlinkEnumEntry(4)
  MAV_MISSION_NO_SPACE,

  /**
   * one of the parameters has an invalid value
   */
  @MavlinkEnumEntry(5)
  MAV_MISSION_INVALID,

  /**
   * param1 has an invalid value
   */
  @MavlinkEnumEntry(6)
  MAV_MISSION_INVALID_PARAM1,

  /**
   * param2 has an invalid value
   */
  @MavlinkEnumEntry(7)
  MAV_MISSION_INVALID_PARAM2,

  /**
   * param3 has an invalid value
   */
  @MavlinkEnumEntry(8)
  MAV_MISSION_INVALID_PARAM3,

  /**
   * param4 has an invalid value
   */
  @MavlinkEnumEntry(9)
  MAV_MISSION_INVALID_PARAM4,

  /**
   * x/param5 has an invalid value
   */
  @MavlinkEnumEntry(10)
  MAV_MISSION_INVALID_PARAM5_X,

  /**
   * y/param6 has an invalid value
   */
  @MavlinkEnumEntry(11)
  MAV_MISSION_INVALID_PARAM6_Y,

  /**
   * param7 has an invalid value
   */
  @MavlinkEnumEntry(12)
  MAV_MISSION_INVALID_PARAM7,

  /**
   * received waypoint out of sequence
   */
  @MavlinkEnumEntry(13)
  MAV_MISSION_INVALID_SEQUENCE,

  /**
   * not accepting any mission commands from this communication partner
   */
  @MavlinkEnumEntry(14)
  MAV_MISSION_DENIED
}
