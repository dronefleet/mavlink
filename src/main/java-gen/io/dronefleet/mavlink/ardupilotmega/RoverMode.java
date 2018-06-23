package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * A mapping of rover flight modes for custom_mode field of heartbeat 
 */
@MavlinkEnum
public enum RoverMode {
    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    ROVER_MODE_MANUAL,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    ROVER_MODE_ACRO,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    ROVER_MODE_STEERING,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    ROVER_MODE_HOLD,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(5)
    ROVER_MODE_LOITER,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(10)
    ROVER_MODE_AUTO,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(11)
    ROVER_MODE_RTL,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(12)
    ROVER_MODE_SMART_RTL,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(15)
    ROVER_MODE_GUIDED,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16)
    ROVER_MODE_INITIALIZING
}
