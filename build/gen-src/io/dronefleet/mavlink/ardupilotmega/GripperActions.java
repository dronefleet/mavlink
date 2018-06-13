package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Gripper actions. 
 */
@MavlinkEnum
public enum GripperActions {
  /**
   * gripper release of cargo
   */
  @MavlinkEnumEntry(0)
  GRIPPER_ACTION_RELEASE,

  /**
   * gripper grabs onto cargo
   */
  @MavlinkEnumEntry(1)
  GRIPPER_ACTION_GRAB
}
