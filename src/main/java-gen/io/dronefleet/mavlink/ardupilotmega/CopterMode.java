package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * A mapping of copter flight modes for custom_mode field of heartbeat 
 */
@MavlinkEnum
public enum CopterMode {
    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    COPTER_MODE_STABILIZE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    COPTER_MODE_ACRO,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    COPTER_MODE_ALT_HOLD,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    COPTER_MODE_AUTO,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    COPTER_MODE_GUIDED,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(5)
    COPTER_MODE_LOITER,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(6)
    COPTER_MODE_RTL,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(7)
    COPTER_MODE_CIRCLE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(9)
    COPTER_MODE_LAND,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(11)
    COPTER_MODE_DRIFT,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(13)
    COPTER_MODE_SPORT,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(14)
    COPTER_MODE_FLIP,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(15)
    COPTER_MODE_AUTOTUNE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16)
    COPTER_MODE_POSHOLD,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(17)
    COPTER_MODE_BRAKE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(18)
    COPTER_MODE_THROW,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(19)
    COPTER_MODE_AVOID_ADSB,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(20)
    COPTER_MODE_GUIDED_NOGPS,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(21)
    COPTER_MODE_SMART_RTL
}
