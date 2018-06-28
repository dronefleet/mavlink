package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * {@link io.dronefleet.mavlink.common.SerialControl SERIAL_CONTROL} device types 
 */
@MavlinkEnum
public enum SerialControlDev {
    /**
     * First telemetry port 
     */
    @MavlinkEntryInfo(0)
    SERIAL_CONTROL_DEV_TELEM1,

    /**
     * Second telemetry port 
     */
    @MavlinkEntryInfo(1)
    SERIAL_CONTROL_DEV_TELEM2,

    /**
     * First GPS port 
     */
    @MavlinkEntryInfo(2)
    SERIAL_CONTROL_DEV_GPS1,

    /**
     * Second GPS port 
     */
    @MavlinkEntryInfo(3)
    SERIAL_CONTROL_DEV_GPS2,

    /**
     * system shell 
     */
    @MavlinkEntryInfo(10)
    SERIAL_CONTROL_DEV_SHELL
}
