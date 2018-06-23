package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * result from a mavlink command 
 */
@MavlinkEnum
public enum MavResult {
    /**
     * Command ACCEPTED and EXECUTED<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    MAV_RESULT_ACCEPTED,

    /**
     * Command TEMPORARY REJECTED/DENIED<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    MAV_RESULT_TEMPORARILY_REJECTED,

    /**
     * Command PERMANENTLY DENIED<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    MAV_RESULT_DENIED,

    /**
     * Command UNKNOWN/UNSUPPORTED<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    MAV_RESULT_UNSUPPORTED,

    /**
     * Command executed, but failed<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    MAV_RESULT_FAILED,

    /**
     * WIP: Command being executed<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(5)
    MAV_RESULT_IN_PROGRESS
}
