package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Source of information about this collision. 
 */
@MavlinkEnum
public enum MavCollisionSrc {
  /**
   * ID field references ADSB_VEHICLE packets
   */
  @MavlinkEnumEntry(0)
  MAV_COLLISION_SRC_ADSB,

  /**
   * ID field references MAVLink SRC ID
   */
  @MavlinkEnumEntry(1)
  MAV_COLLISION_SRC_MAVLINK_GPS_GLOBAL_INT
}
