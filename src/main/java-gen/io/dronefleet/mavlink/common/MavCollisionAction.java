package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Possible actions an aircraft can take to avoid a collision. 
 */
@MavlinkEnum
public enum MavCollisionAction {
  /**
   * Ignore any potential collisions
   */
  @MavlinkEnumEntry(0)
  MAV_COLLISION_ACTION_NONE,

  /**
   * Report potential collision
   */
  @MavlinkEnumEntry(1)
  MAV_COLLISION_ACTION_REPORT,

  /**
   * Ascend or Descend to avoid threat
   */
  @MavlinkEnumEntry(2)
  MAV_COLLISION_ACTION_ASCEND_OR_DESCEND,

  /**
   * Move horizontally to avoid threat
   */
  @MavlinkEnumEntry(3)
  MAV_COLLISION_ACTION_MOVE_HORIZONTALLY,

  /**
   * Aircraft to move perpendicular to the collision's velocity vector
   */
  @MavlinkEnumEntry(4)
  MAV_COLLISION_ACTION_MOVE_PERPENDICULAR,

  /**
   * Aircraft to fly directly back to its launch point
   */
  @MavlinkEnumEntry(5)
  MAV_COLLISION_ACTION_RTL,

  /**
   * Aircraft to stop in place
   */
  @MavlinkEnumEntry(6)
  MAV_COLLISION_ACTION_HOVER
}
