package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * A mapping of antenna tracker flight modes for custom_mode field of heartbeat 
 */
@MavlinkEnum
public enum TrackerMode {
    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    TRACKER_MODE_MANUAL,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    TRACKER_MODE_STOP,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    TRACKER_MODE_SCAN,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    TRACKER_MODE_SERVO_TEST,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(10)
    TRACKER_MODE_AUTO,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16)
    TRACKER_MODE_INITIALIZING
}
