package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Generalized UAVCAN node mode 
 */
@MavlinkEnum
public enum UavcanNodeMode {
  /**
   * The node is performing its primary functions.
   */
  @MavlinkEnumEntry(0)
  UAVCAN_NODE_MODE_OPERATIONAL,

  /**
   * The node is initializing; this mode is entered immediately after startup.
   */
  @MavlinkEnumEntry(1)
  UAVCAN_NODE_MODE_INITIALIZATION,

  /**
   * The node is under maintenance.
   */
  @MavlinkEnumEntry(2)
  UAVCAN_NODE_MODE_MAINTENANCE,

  /**
   * The node is in the process of updating its software.
   */
  @MavlinkEnumEntry(3)
  UAVCAN_NODE_MODE_SOFTWARE_UPDATE,

  /**
   * The node is no longer available online.
   */
  @MavlinkEnumEntry(7)
  UAVCAN_NODE_MODE_OFFLINE
}
