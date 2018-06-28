package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Result from a {@link io.dronefleet.mavlink.common.ParamExtSet PARAM_EXT_SET} message. 
 */
@MavlinkEnum
public enum ParamAck {
    /**
     * Parameter value ACCEPTED and SET 
     */
    @MavlinkEntryInfo(0)
    PARAM_ACK_ACCEPTED,

    /**
     * Parameter value UNKNOWN/UNSUPPORTED 
     */
    @MavlinkEntryInfo(1)
    PARAM_ACK_VALUE_UNSUPPORTED,

    /**
     * Parameter failed to set 
     */
    @MavlinkEntryInfo(2)
    PARAM_ACK_FAILED,

    /**
     * Parameter value received but not yet validated or set. A subsequent {@link io.dronefleet.mavlink.common.ParamExtAck PARAM_EXT_ACK} will follow 
     * once operation is completed with the actual result. These are for parameters that may take 
     * longer to set. Instead of waiting for an ACK and potentially timing out, you will immediately 
     * receive this response to let you know it was received. 
     */
    @MavlinkEntryInfo(3)
    PARAM_ACK_IN_PROGRESS
}
