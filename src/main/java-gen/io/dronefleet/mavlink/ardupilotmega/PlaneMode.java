package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * A mapping of plane flight modes for custom_mode field of heartbeat 
 */
@MavlinkEnum
public enum PlaneMode {
    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    PLANE_MODE_MANUAL,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    PLANE_MODE_CIRCLE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    PLANE_MODE_STABILIZE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    PLANE_MODE_TRAINING,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    PLANE_MODE_ACRO,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(5)
    PLANE_MODE_FLY_BY_WIRE_A,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(6)
    PLANE_MODE_FLY_BY_WIRE_B,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(7)
    PLANE_MODE_CRUISE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8)
    PLANE_MODE_AUTOTUNE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(10)
    PLANE_MODE_AUTO,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(11)
    PLANE_MODE_RTL,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(12)
    PLANE_MODE_LOITER,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(14)
    PLANE_MODE_AVOID_ADSB,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(15)
    PLANE_MODE_GUIDED,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16)
    PLANE_MODE_INITIALIZING,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(17)
    PLANE_MODE_QSTABILIZE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(18)
    PLANE_MODE_QHOVER,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(19)
    PLANE_MODE_QLOITER,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(20)
    PLANE_MODE_QLAND,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(21)
    PLANE_MODE_QRTL
}
