package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * THIS INTERFACE IS DEPRECATED AS OF JANUARY 2018. Please use MAV_CMD_DO_SET_ROI_* messages 
 * instead. The ROI (region of interest) for the vehicle. This can be be used by the vehicle for 
 * camera/vehicle attitude alignment (see MAV_CMD_NAV_ROI). 
 */
@MavlinkEnum
public enum MavRoi {
  /**
   * No region of interest.
   */
  @MavlinkEnumEntry(0)
  MAV_ROI_NONE,

  /**
   * Point toward next waypoint, with optional pitch/roll/yaw offset.
   */
  @MavlinkEnumEntry(1)
  MAV_ROI_WPNEXT,

  /**
   * Point toward given waypoint.
   */
  @MavlinkEnumEntry(2)
  MAV_ROI_WPINDEX,

  /**
   * Point toward fixed location.
   */
  @MavlinkEnumEntry(3)
  MAV_ROI_LOCATION,

  /**
   * Point toward of given id.
   */
  @MavlinkEnumEntry(4)
  MAV_ROI_TARGET
}
