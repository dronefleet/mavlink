package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * A mapping of sub flight modes for custom_mode field of heartbeat 
 */
@MavlinkEnum
public enum SubMode {
    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    SUB_MODE_STABILIZE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    SUB_MODE_ACRO,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    SUB_MODE_ALT_HOLD,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    SUB_MODE_AUTO,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    SUB_MODE_GUIDED,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(7)
    SUB_MODE_CIRCLE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(9)
    SUB_MODE_SURFACE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16)
    SUB_MODE_POSHOLD,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(19)
    SUB_MODE_MANUAL
}
