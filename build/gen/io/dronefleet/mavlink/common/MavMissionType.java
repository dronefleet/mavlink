package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Type of mission items being requested/sent in mission protocol. 
 */
@MavlinkEnum
public enum MavMissionType {
  /**
   * Items are mission commands for main mission.
   */
  @MavlinkEnumEntry(0)
  MAV_MISSION_TYPE_MISSION,

  /**
   * Specifies GeoFence area(s). Items are MAV_CMD_FENCE_ GeoFence items.
   */
  @MavlinkEnumEntry(1)
  MAV_MISSION_TYPE_FENCE,

  /**
   * Specifies the rally points for the vehicle. Rally points are alternative RTL points. Items are MAV_CMD_RALLY_POINT rally point items.
   */
  @MavlinkEnumEntry(2)
  MAV_MISSION_TYPE_RALLY,

  /**
   * Only used in MISSION_CLEAR_ALL to clear all mission types.
   */
  @MavlinkEnumEntry(255)
  MAV_MISSION_TYPE_ALL
}
