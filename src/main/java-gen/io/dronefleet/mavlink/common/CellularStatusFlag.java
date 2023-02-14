package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * These flags encode the cellular network status 
 */
@MavlinkEnum
public enum CellularStatusFlag {
    /**
     * State unknown or not reportable. 
     */
    @MavlinkEntryInfo(0)
    CELLULAR_STATUS_FLAG_UNKNOWN,

    /**
     * Modem is unusable 
     */
    @MavlinkEntryInfo(1)
    CELLULAR_STATUS_FLAG_FAILED,

    /**
     * Modem is being initialized 
     */
    @MavlinkEntryInfo(2)
    CELLULAR_STATUS_FLAG_INITIALIZING,

    /**
     * Modem is locked 
     */
    @MavlinkEntryInfo(3)
    CELLULAR_STATUS_FLAG_LOCKED,

    /**
     * Modem is not enabled and is powered down 
     */
    @MavlinkEntryInfo(4)
    CELLULAR_STATUS_FLAG_DISABLED,

    /**
     * Modem is currently transitioning to the CELLULAR_STATUS_FLAG_DISABLED state 
     */
    @MavlinkEntryInfo(5)
    CELLULAR_STATUS_FLAG_DISABLING,

    /**
     * Modem is currently transitioning to the CELLULAR_STATUS_FLAG_ENABLED state 
     */
    @MavlinkEntryInfo(6)
    CELLULAR_STATUS_FLAG_ENABLING,

    /**
     * Modem is enabled and powered on but not registered with a network provider and not available for 
     * data connections 
     */
    @MavlinkEntryInfo(7)
    CELLULAR_STATUS_FLAG_ENABLED,

    /**
     * Modem is searching for a network provider to register 
     */
    @MavlinkEntryInfo(8)
    CELLULAR_STATUS_FLAG_SEARCHING,

    /**
     * Modem is registered with a network provider, and data connections and messaging may be 
     * available for use 
     */
    @MavlinkEntryInfo(9)
    CELLULAR_STATUS_FLAG_REGISTERED,

    /**
     * Modem is disconnecting and deactivating the last active packet data bearer. This state will 
     * not be entered if more than one packet data bearer is active and one of the active bearers is 
     * deactivated 
     */
    @MavlinkEntryInfo(10)
    CELLULAR_STATUS_FLAG_DISCONNECTING,

    /**
     * Modem is activating and connecting the first packet data bearer. Subsequent bearer 
     * activations when another bearer is already active do not cause this state to be entered 
     */
    @MavlinkEntryInfo(11)
    CELLULAR_STATUS_FLAG_CONNECTING,

    /**
     * One or more packet data bearers is active and connected 
     */
    @MavlinkEntryInfo(12)
    CELLULAR_STATUS_FLAG_CONNECTED
}
