package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Possible actions an aircraft can take to avoid a collision. 
 */
@MavlinkEnum
public enum MavCollisionAction {
  /**
   * Ignore any potential collisions
   */
  @MavlinkEntryInfo(0)
  MAV_COLLISION_ACTION_NONE,

  /**
   * Report potential collision
   */
  @MavlinkEntryInfo(1)
  MAV_COLLISION_ACTION_REPORT,

  /**
   * Ascend or Descend to avoid threat
   */
  @MavlinkEntryInfo(2)
  MAV_COLLISION_ACTION_ASCEND_OR_DESCEND,

  /**
   * Move horizontally to avoid threat
   */
  @MavlinkEntryInfo(3)
  MAV_COLLISION_ACTION_MOVE_HORIZONTALLY,

  /**
   * Aircraft to move perpendicular to the collision's velocity vector
   */
  @MavlinkEntryInfo(4)
  MAV_COLLISION_ACTION_MOVE_PERPENDICULAR,

  /**
   * Aircraft to fly directly back to its launch point
   */
  @MavlinkEntryInfo(5)
  MAV_COLLISION_ACTION_RTL,

  /**
   * Aircraft to stop in place
   */
  @MavlinkEntryInfo(6)
  MAV_COLLISION_ACTION_HOVER
}
