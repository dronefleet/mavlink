package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Aircraft-rated danger from this threat. 
 */
@MavlinkEnum
public enum MavCollisionThreatLevel {
  /**
   * Not a threat
   */
  @MavlinkEnumEntry(0)
  MAV_COLLISION_THREAT_LEVEL_NONE,

  /**
   * Craft is mildly concerned about this threat
   */
  @MavlinkEnumEntry(1)
  MAV_COLLISION_THREAT_LEVEL_LOW,

  /**
   * Craft is panicing, and may take actions to avoid threat
   */
  @MavlinkEnumEntry(2)
  MAV_COLLISION_THREAT_LEVEL_HIGH
}
