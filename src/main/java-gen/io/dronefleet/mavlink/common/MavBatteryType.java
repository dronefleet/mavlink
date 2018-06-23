package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Enumeration of battery types 
 */
@MavlinkEnum
public enum MavBatteryType {
    /**
     * Not specified.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    MAV_BATTERY_TYPE_UNKNOWN,

    /**
     * Lithium polymer battery<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    MAV_BATTERY_TYPE_LIPO,

    /**
     * Lithium-iron-phosphate battery<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    MAV_BATTERY_TYPE_LIFE,

    /**
     * Lithium-ION battery<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    MAV_BATTERY_TYPE_LION,

    /**
     * Nickel metal hydride battery<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    MAV_BATTERY_TYPE_NIMH
}
