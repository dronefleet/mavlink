package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Result from {@link io.dronefleet.mavlink.common.ParamExtSet PARAM_EXT_SET} message (or a {@link io.dronefleet.mavlink.common.ParamSet PARAM_SET} within a transaction). 
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
     * Parameter value received but not yet set/accepted. A subsequent PARAM_ACK_TRANSACTION or 
     * {@link io.dronefleet.mavlink.common.ParamExtAck PARAM_EXT_ACK} with the final result will follow once operation is completed. This is returned 
     * immediately for parameters that take longer to set, indicating that the the parameter was 
     * received and does not need to be resent. 
     */
    @MavlinkEntryInfo(3)
    PARAM_ACK_IN_PROGRESS
}
