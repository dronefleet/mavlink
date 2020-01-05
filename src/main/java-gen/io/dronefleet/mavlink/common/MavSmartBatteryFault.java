package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Smart battery supply status/fault flags (bitmask) for health indication. 
 */
@MavlinkEnum
public enum MavSmartBatteryFault {
    /**
     * Battery has deep discharged. 
     */
    @MavlinkEntryInfo(1)
    MAV_SMART_BATTERY_FAULT_DEEP_DISCHARGE,

    /**
     * Voltage spikes. 
     */
    @MavlinkEntryInfo(2)
    MAV_SMART_BATTERY_FAULT_SPIKES,

    /**
     * Single cell has failed. 
     */
    @MavlinkEntryInfo(4)
    MAV_SMART_BATTERY_FAULT_SINGLE_CELL_FAIL,

    /**
     * Over-current fault. 
     */
    @MavlinkEntryInfo(8)
    MAV_SMART_BATTERY_FAULT_OVER_CURRENT,

    /**
     * Over-temperature fault. 
     */
    @MavlinkEntryInfo(16)
    MAV_SMART_BATTERY_FAULT_OVER_TEMPERATURE,

    /**
     * Under-temperature fault. 
     */
    @MavlinkEntryInfo(32)
    MAV_SMART_BATTERY_FAULT_UNDER_TEMPERATURE
}
