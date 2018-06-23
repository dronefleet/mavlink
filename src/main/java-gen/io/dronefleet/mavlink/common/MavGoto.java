package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Override command, pauses current mission execution and moves immediately to a position 
 */
@MavlinkEnum
public enum MavGoto {
    /**
     * Hold at the current position.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    MAV_GOTO_DO_HOLD,

    /**
     * Continue with the next item in mission execution.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    MAV_GOTO_DO_CONTINUE,

    /**
     * Hold at the current position of the system<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    MAV_GOTO_HOLD_AT_CURRENT_POSITION,

    /**
     * Hold at the position specified in the parameters of the DO_HOLD action<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    MAV_GOTO_HOLD_AT_SPECIFIED_POSITION
}
