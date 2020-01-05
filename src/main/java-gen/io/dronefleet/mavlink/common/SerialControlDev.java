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
    SERIAL_CONTROL_DEV_SHELL,

    /**
     * SERIAL0 
     */
    @MavlinkEntryInfo(100)
    SERIAL_CONTROL_SERIAL0,

    /**
     * SERIAL1 
     */
    @MavlinkEntryInfo(101)
    SERIAL_CONTROL_SERIAL1,

    /**
     * SERIAL2 
     */
    @MavlinkEntryInfo(102)
    SERIAL_CONTROL_SERIAL2,

    /**
     * SERIAL3 
     */
    @MavlinkEntryInfo(103)
    SERIAL_CONTROL_SERIAL3,

    /**
     * SERIAL4 
     */
    @MavlinkEntryInfo(104)
    SERIAL_CONTROL_SERIAL4,

    /**
     * SERIAL5 
     */
    @MavlinkEntryInfo(105)
    SERIAL_CONTROL_SERIAL5,

    /**
     * SERIAL6 
     */
    @MavlinkEntryInfo(106)
    SERIAL_CONTROL_SERIAL6,

    /**
     * SERIAL7 
     */
    @MavlinkEntryInfo(107)
    SERIAL_CONTROL_SERIAL7,

    /**
     * SERIAL8 
     */
    @MavlinkEntryInfo(108)
    SERIAL_CONTROL_SERIAL8,

    /**
     * SERIAL9 
     */
    @MavlinkEntryInfo(109)
    SERIAL_CONTROL_SERIAL9
}
