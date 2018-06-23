package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum LimitsState {
    /**
     * pre-initialization<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    LIMITS_INIT,

    /**
     * disabled<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    LIMITS_DISABLED,

    /**
     * checking limits<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    LIMITS_ENABLED,

    /**
     * a limit has been breached<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    LIMITS_TRIGGERED,

    /**
     * taking action eg. RTL<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    LIMITS_RECOVERING,

    /**
     * we're no longer in breach of a limit<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(5)
    LIMITS_RECOVERED
}
