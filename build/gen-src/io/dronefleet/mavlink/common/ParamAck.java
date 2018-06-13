package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Result from a PARAM_EXT_SET message. 
 */
@MavlinkEnum
public enum ParamAck {
  /**
   * Parameter value ACCEPTED and SET
   */
  @MavlinkEnumEntry(0)
  PARAM_ACK_ACCEPTED,

  /**
   * Parameter value UNKNOWN/UNSUPPORTED
   */
  @MavlinkEnumEntry(1)
  PARAM_ACK_VALUE_UNSUPPORTED,

  /**
   * Parameter failed to set
   */
  @MavlinkEnumEntry(2)
  PARAM_ACK_FAILED,

  /**
   * Parameter value received but not yet validated or set. A subsequent PARAM_EXT_ACK will follow once operation is completed with the actual result. These are for parameters that may take longer to set. Instead of waiting for an ACK and potentially timing out, you will immediately receive this response to let you know it was received.
   */
  @MavlinkEnumEntry(3)
  PARAM_ACK_IN_PROGRESS
}
