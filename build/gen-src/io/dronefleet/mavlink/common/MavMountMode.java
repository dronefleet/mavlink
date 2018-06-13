package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Enumeration of possible mount operation modes 
 */
@MavlinkEnum
public enum MavMountMode {
  /**
   * Load and keep safe position (Roll,Pitch,Yaw) from permant memory and stop stabilization
   */
  @MavlinkEnumEntry(0)
  MAV_MOUNT_MODE_RETRACT,

  /**
   * Load and keep neutral position (Roll,Pitch,Yaw) from permanent memory.
   */
  @MavlinkEnumEntry(1)
  MAV_MOUNT_MODE_NEUTRAL,

  /**
   * Load neutral position and start MAVLink Roll,Pitch,Yaw control with stabilization
   */
  @MavlinkEnumEntry(2)
  MAV_MOUNT_MODE_MAVLINK_TARGETING,

  /**
   * Load neutral position and start RC Roll,Pitch,Yaw control with stabilization
   */
  @MavlinkEnumEntry(3)
  MAV_MOUNT_MODE_RC_TARGETING,

  /**
   * Load neutral position and start to point to Lat,Lon,Alt
   */
  @MavlinkEnumEntry(4)
  MAV_MOUNT_MODE_GPS_POINT
}
