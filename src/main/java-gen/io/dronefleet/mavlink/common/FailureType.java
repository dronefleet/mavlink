package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * List of possible failure type to inject. 
 */
@MavlinkEnum
public enum FailureType {
    /**
     * No failure injected, used to reset a previous failure. 
     */
    @MavlinkEntryInfo(0)
    FAILURE_TYPE_OK,

    /**
     * Sets unit off, so completely non-responsive. 
     */
    @MavlinkEntryInfo(1)
    FAILURE_TYPE_OFF,

    /**
     * Unit is stuck e.g. keeps reporting the same value. 
     */
    @MavlinkEntryInfo(2)
    FAILURE_TYPE_STUCK,

    /**
     * Unit is reporting complete garbage. 
     */
    @MavlinkEntryInfo(3)
    FAILURE_TYPE_GARBAGE,

    /**
     * Unit is consistently wrong. 
     */
    @MavlinkEntryInfo(4)
    FAILURE_TYPE_WRONG,

    /**
     * Unit is slow, so e.g. reporting at slower than expected rate. 
     */
    @MavlinkEntryInfo(5)
    FAILURE_TYPE_SLOW,

    /**
     * Data of unit is delayed in time. 
     */
    @MavlinkEntryInfo(6)
    FAILURE_TYPE_DELAYED,

    /**
     * Unit is sometimes working, sometimes not. 
     */
    @MavlinkEntryInfo(7)
    FAILURE_TYPE_INTERMITTENT
}
