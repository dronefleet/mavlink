package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Specifies the datatype of a MAVLink extended parameter. 
 */
@MavlinkEnum
public enum MavParamExtType {
    /**
     * 8-bit unsigned integer 
     */
    @MavlinkEntryInfo(1)
    MAV_PARAM_EXT_TYPE_UINT8,

    /**
     * 8-bit signed integer 
     */
    @MavlinkEntryInfo(2)
    MAV_PARAM_EXT_TYPE_INT8,

    /**
     * 16-bit unsigned integer 
     */
    @MavlinkEntryInfo(3)
    MAV_PARAM_EXT_TYPE_UINT16,

    /**
     * 16-bit signed integer 
     */
    @MavlinkEntryInfo(4)
    MAV_PARAM_EXT_TYPE_INT16,

    /**
     * 32-bit unsigned integer 
     */
    @MavlinkEntryInfo(5)
    MAV_PARAM_EXT_TYPE_UINT32,

    /**
     * 32-bit signed integer 
     */
    @MavlinkEntryInfo(6)
    MAV_PARAM_EXT_TYPE_INT32,

    /**
     * 64-bit unsigned integer 
     */
    @MavlinkEntryInfo(7)
    MAV_PARAM_EXT_TYPE_UINT64,

    /**
     * 64-bit signed integer 
     */
    @MavlinkEntryInfo(8)
    MAV_PARAM_EXT_TYPE_INT64,

    /**
     * 32-bit floating-point 
     */
    @MavlinkEntryInfo(9)
    MAV_PARAM_EXT_TYPE_REAL32,

    /**
     * 64-bit floating-point 
     */
    @MavlinkEntryInfo(10)
    MAV_PARAM_EXT_TYPE_REAL64,

    /**
     * Custom Type 
     */
    @MavlinkEntryInfo(11)
    MAV_PARAM_EXT_TYPE_CUSTOM
}
