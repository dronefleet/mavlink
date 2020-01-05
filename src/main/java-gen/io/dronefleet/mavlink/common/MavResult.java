package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Result from a MAVLink command ({@link io.dronefleet.mavlink.common.MavCmd MAV_CMD}) 
 */
@MavlinkEnum
public enum MavResult {
    /**
     * Command is valid (is supported and has valid parameters), and was executed. 
     */
    @MavlinkEntryInfo(0)
    MAV_RESULT_ACCEPTED,

    /**
     * Command is valid, but cannot be executed at this time. This is used to indicate a problem that 
     * should be fixed just by waiting (e.g. a state machine is busy, can't arm because have not got GPS 
     * lock, etc.). Retrying later should work. 
     */
    @MavlinkEntryInfo(1)
    MAV_RESULT_TEMPORARILY_REJECTED,

    /**
     * Command is invalid (is supported but has invalid parameters). Retrying same command and 
     * parameters will not work. 
     */
    @MavlinkEntryInfo(2)
    MAV_RESULT_DENIED,

    /**
     * Command is not supported (unknown). 
     */
    @MavlinkEntryInfo(3)
    MAV_RESULT_UNSUPPORTED,

    /**
     * Command is valid, but execution has failed. This is used to indicate any non-temporary or 
     * unexpected problem, i.e. any problem that must be fixed before the command can succeed/be 
     * retried. For example, attempting to write a file when out of memory, attempting to arm when 
     * sensors are not calibrated, etc. 
     */
    @MavlinkEntryInfo(4)
    MAV_RESULT_FAILED,

    /**
     * Command is valid and is being executed. This will be followed by further progress updates, i.e. 
     * the component may send further {@link io.dronefleet.mavlink.common.CommandAck COMMAND_ACK} messages with result MAV_RESULT_IN_PROGRESS (at 
     * a rate decided by the implementation), and must terminate by sending a {@link io.dronefleet.mavlink.common.CommandAck COMMAND_ACK} message 
     * with final result of the operation. The {@link io.dronefleet.mavlink.common.CommandAck COMMAND_ACK}.progress field can be used to indicate the 
     * progress of the operation. There is no need for the sender to retry the command, but if done 
     * during execution, the component will return MAV_RESULT_IN_PROGRESS with an updated 
     * progress. 
     */
    @MavlinkEntryInfo(5)
    MAV_RESULT_IN_PROGRESS
}
