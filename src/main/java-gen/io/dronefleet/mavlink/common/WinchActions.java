package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Winch actions. 
 */
@MavlinkEnum
public enum WinchActions {
    /**
     * Allow motor to freewheel. 
     */
    @MavlinkEntryInfo(0)
    WINCH_RELAXED,

    /**
     * Wind or unwind specified length of line, optionally using specified rate. 
     */
    @MavlinkEntryInfo(1)
    WINCH_RELATIVE_LENGTH_CONTROL,

    /**
     * Wind or unwind line at specified rate. 
     */
    @MavlinkEntryInfo(2)
    WINCH_RATE_CONTROL,

    /**
     * Perform the locking sequence to relieve motor while in the fully retracted position. Only 
     * action and instance command parameters are used, others are ignored. 
     */
    @MavlinkEntryInfo(3)
    WINCH_LOCK,

    /**
     * Sequence of drop, slow down, touch down, reel up, lock. Only action and instance command 
     * parameters are used, others are ignored. 
     */
    @MavlinkEntryInfo(4)
    WINCH_DELIVER,

    /**
     * Engage motor and hold current position. Only action and instance command parameters are used, 
     * others are ignored. 
     */
    @MavlinkEntryInfo(5)
    WINCH_HOLD,

    /**
     * Return the reel to the fully retracted position. Only action and instance command parameters 
     * are used, others are ignored. 
     */
    @MavlinkEntryInfo(6)
    WINCH_RETRACT,

    /**
     * Load the reel with line. The winch will calculate the total loaded length and stop when the 
     * tension exceeds a threshold. Only action and instance command parameters are used, others are 
     * ignored. 
     */
    @MavlinkEntryInfo(7)
    WINCH_LOAD_LINE,

    /**
     * Spool out the entire length of the line. Only action and instance command parameters are used, 
     * others are ignored. 
     */
    @MavlinkEntryInfo(8)
    WINCH_ABANDON_LINE,

    /**
     * Spools out just enough to present the hook to the user to load the payload. Only action and 
     * instance command parameters are used, others are ignored 
     */
    @MavlinkEntryInfo(9)
    WINCH_LOAD_PAYLOAD
}
