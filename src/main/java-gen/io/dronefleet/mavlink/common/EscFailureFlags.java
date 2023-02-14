package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Flags to report ESC failures. 
 */
@MavlinkEnum
public enum EscFailureFlags {
    /**
     * No ESC failure. 
     */
    @MavlinkEntryInfo(0)
    ESC_FAILURE_NONE,

    /**
     * Over current failure. 
     */
    @MavlinkEntryInfo(1)
    ESC_FAILURE_OVER_CURRENT,

    /**
     * Over voltage failure. 
     */
    @MavlinkEntryInfo(2)
    ESC_FAILURE_OVER_VOLTAGE,

    /**
     * Over temperature failure. 
     */
    @MavlinkEntryInfo(4)
    ESC_FAILURE_OVER_TEMPERATURE,

    /**
     * Over RPM failure. 
     */
    @MavlinkEntryInfo(8)
    ESC_FAILURE_OVER_RPM,

    /**
     * Inconsistent command failure i.e. out of bounds. 
     */
    @MavlinkEntryInfo(16)
    ESC_FAILURE_INCONSISTENT_CMD,

    /**
     * Motor stuck failure. 
     */
    @MavlinkEntryInfo(32)
    ESC_FAILURE_MOTOR_STUCK,

    /**
     * Generic ESC failure. 
     */
    @MavlinkEntryInfo(64)
    ESC_FAILURE_GENERIC
}
