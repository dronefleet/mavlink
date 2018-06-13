package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Action required when performing CMD_PREFLIGHT_STORAGE 
 */
@MavlinkEnum
public enum MavPreflightStorageAction {
  /**
   * Read all parameters from storage
   */
  @MavlinkEnumEntry(0)
  MAV_PFS_CMD_READ_ALL,

  /**
   * Write all parameters to storage
   */
  @MavlinkEnumEntry(1)
  MAV_PFS_CMD_WRITE_ALL,

  /**
   * Clear all  parameters in storage
   */
  @MavlinkEnumEntry(2)
  MAV_PFS_CMD_CLEAR_ALL,

  /**
   * Read specific parameters from storage
   */
  @MavlinkEnumEntry(3)
  MAV_PFS_CMD_READ_SPECIFIC,

  /**
   * Write specific parameters to storage
   */
  @MavlinkEnumEntry(4)
  MAV_PFS_CMD_WRITE_SPECIFIC,

  /**
   * Clear specific parameters in storage
   */
  @MavlinkEnumEntry(5)
  MAV_PFS_CMD_CLEAR_SPECIFIC,

  /**
   * do nothing
   */
  @MavlinkEnumEntry(6)
  MAV_PFS_CMD_DO_NOTHING
}
