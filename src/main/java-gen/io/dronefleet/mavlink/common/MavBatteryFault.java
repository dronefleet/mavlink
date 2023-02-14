package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Smart battery supply status/fault flags (bitmask) for health indication. The battery must 
 * also report either MAV_BATTERY_CHARGE_STATE_FAILED or 
 * MAV_BATTERY_CHARGE_STATE_UNHEALTHY if any of these are set. 
 */
@MavlinkEnum
public enum MavBatteryFault {
    /**
     * Battery has deep discharged. 
     */
    @MavlinkEntryInfo(1)
    MAV_BATTERY_FAULT_DEEP_DISCHARGE,

    /**
     * Voltage spikes. 
     */
    @MavlinkEntryInfo(2)
    MAV_BATTERY_FAULT_SPIKES,

    /**
     * One or more cells have failed. Battery should also report MAV_BATTERY_CHARGE_STATE_FAILE 
     * (and should not be used). 
     */
    @MavlinkEntryInfo(4)
    MAV_BATTERY_FAULT_CELL_FAIL,

    /**
     * Over-current fault. 
     */
    @MavlinkEntryInfo(8)
    MAV_BATTERY_FAULT_OVER_CURRENT,

    /**
     * Over-temperature fault. 
     */
    @MavlinkEntryInfo(16)
    MAV_BATTERY_FAULT_OVER_TEMPERATURE,

    /**
     * Under-temperature fault. 
     */
    @MavlinkEntryInfo(32)
    MAV_BATTERY_FAULT_UNDER_TEMPERATURE,

    /**
     * Vehicle voltage is not compatible with this battery (batteries on same power rail should have 
     * similar voltage). 
     */
    @MavlinkEntryInfo(64)
    MAV_BATTERY_FAULT_INCOMPATIBLE_VOLTAGE,

    /**
     * Battery firmware is not compatible with current autopilot firmware. 
     */
    @MavlinkEntryInfo(128)
    MAV_BATTERY_FAULT_INCOMPATIBLE_FIRMWARE,

    /**
     * Battery is not compatible due to cell configuration (e.g. 5s1p when vehicle requires 6s). 
     */
    @MavlinkEntryInfo(256)
    BATTERY_FAULT_INCOMPATIBLE_CELLS_CONFIGURATION
}
