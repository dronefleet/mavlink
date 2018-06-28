package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Enumeration of battery functions 
 */
@MavlinkEnum
public enum MavBatteryFunction {
    /**
     * Battery function is unknown 
     */
    @MavlinkEntryInfo(0)
    MAV_BATTERY_FUNCTION_UNKNOWN,

    /**
     * Battery supports all flight systems 
     */
    @MavlinkEntryInfo(1)
    MAV_BATTERY_FUNCTION_ALL,

    /**
     * Battery for the propulsion system 
     */
    @MavlinkEntryInfo(2)
    MAV_BATTERY_FUNCTION_PROPULSION,

    /**
     * Avionics battery 
     */
    @MavlinkEntryInfo(3)
    MAV_BATTERY_FUNCTION_AVIONICS,

    /**
     * Payload battery 
     */
    @MavlinkEntryInfo(4)
    MAV_BATTERY_TYPE_PAYLOAD
}
