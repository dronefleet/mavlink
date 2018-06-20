package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Generalized UAVCAN node health 
 */
@MavlinkEnum
public enum UavcanNodeHealth {
  /**
   * The node is functioning properly.
   */
  @MavlinkEntryInfo(0)
  UAVCAN_NODE_HEALTH_OK,

  /**
   * A critical parameter went out of range or the node has encountered a minor failure.
   */
  @MavlinkEntryInfo(1)
  UAVCAN_NODE_HEALTH_WARNING,

  /**
   * The node has encountered a major failure.
   */
  @MavlinkEntryInfo(2)
  UAVCAN_NODE_HEALTH_ERROR,

  /**
   * The node has suffered a fatal malfunction.
   */
  @MavlinkEntryInfo(3)
  UAVCAN_NODE_HEALTH_CRITICAL
}
