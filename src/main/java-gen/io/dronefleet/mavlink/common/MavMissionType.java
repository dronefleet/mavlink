package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Type of mission items being requested/sent in mission protocol. 
 */
@MavlinkEnum
public enum MavMissionType {
  /**
   * Items are mission commands for main mission.
   */
  @MavlinkEntryInfo(0)
  MAV_MISSION_TYPE_MISSION,

  /**
   * Specifies GeoFence area(s). Items are MAV_CMD_FENCE_ GeoFence items.
   */
  @MavlinkEntryInfo(1)
  MAV_MISSION_TYPE_FENCE,

  /**
   * Specifies the rally points for the vehicle. Rally points are alternative RTL points. Items are MAV_CMD_RALLY_POINT rally point items.
   */
  @MavlinkEntryInfo(2)
  MAV_MISSION_TYPE_RALLY,

  /**
   * Only used in MISSION_CLEAR_ALL to clear all mission types.
   */
  @MavlinkEntryInfo(255)
  MAV_MISSION_TYPE_ALL
}
