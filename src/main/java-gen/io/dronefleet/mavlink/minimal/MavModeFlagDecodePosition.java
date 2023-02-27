package io.dronefleet.mavlink.minimal;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * These values encode the bit positions of the decode position. These values can be used to read 
 * the value of a flag bit by combining the base_mode variable with AND with the flag position 
 * value. The result will be either 0 or 1, depending on if the flag is set or not. 
 */
@MavlinkEnum
public enum MavModeFlagDecodePosition {
    /**
     * First bit: 10000000 
     */
    @MavlinkEntryInfo(128)
    MAV_MODE_FLAG_DECODE_POSITION_SAFETY,

    /**
     * Second bit: 01000000 
     */
    @MavlinkEntryInfo(64)
    MAV_MODE_FLAG_DECODE_POSITION_MANUAL,

    /**
     * Third bit: 00100000 
     */
    @MavlinkEntryInfo(32)
    MAV_MODE_FLAG_DECODE_POSITION_HIL,

    /**
     * Fourth bit: 00010000 
     */
    @MavlinkEntryInfo(16)
    MAV_MODE_FLAG_DECODE_POSITION_STABILIZE,

    /**
     * Fifth bit: 00001000 
     */
    @MavlinkEntryInfo(8)
    MAV_MODE_FLAG_DECODE_POSITION_GUIDED,

    /**
     * Sixth bit: 00000100 
     */
    @MavlinkEntryInfo(4)
    MAV_MODE_FLAG_DECODE_POSITION_AUTO,

    /**
     * Seventh bit: 00000010 
     */
    @MavlinkEntryInfo(2)
    MAV_MODE_FLAG_DECODE_POSITION_TEST,

    /**
     * Eighth bit: 00000001 
     */
    @MavlinkEntryInfo(1)
    MAV_MODE_FLAG_DECODE_POSITION_CUSTOM_MODE
}
