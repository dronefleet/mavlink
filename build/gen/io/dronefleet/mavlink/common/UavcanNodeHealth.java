package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Generalized UAVCAN node health 
 */
@MavlinkEnum
public enum UavcanNodeHealth {
  /**
   * The node is functioning properly.
   */
  @MavlinkEnumEntry(0)
  UAVCAN_NODE_HEALTH_OK,

  /**
   * A critical parameter went out of range or the node has encountered a minor failure.
   */
  @MavlinkEnumEntry(1)
  UAVCAN_NODE_HEALTH_WARNING,

  /**
   * The node has encountered a major failure.
   */
  @MavlinkEnumEntry(2)
  UAVCAN_NODE_HEALTH_ERROR,

  /**
   * The node has suffered a fatal malfunction.
   */
  @MavlinkEnumEntry(3)
  UAVCAN_NODE_HEALTH_CRITICAL
}
