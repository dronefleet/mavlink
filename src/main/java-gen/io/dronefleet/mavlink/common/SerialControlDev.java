package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * SERIAL_CONTROL device types 
 */
@MavlinkEnum
public enum SerialControlDev {
    /**
     * First telemetry port<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    SERIAL_CONTROL_DEV_TELEM1,

    /**
     * Second telemetry port<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    SERIAL_CONTROL_DEV_TELEM2,

    /**
     * First GPS port<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    SERIAL_CONTROL_DEV_GPS1,

    /**
     * Second GPS port<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    SERIAL_CONTROL_DEV_GPS2,

    /**
     * system shell<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(10)
    SERIAL_CONTROL_DEV_SHELL
}
