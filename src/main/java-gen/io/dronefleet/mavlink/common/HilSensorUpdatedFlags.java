package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Flags in the {@link io.dronefleet.mavlink.common.HilSensor HIL_SENSOR} message indicate which fields have updated since the last message 
 */
@MavlinkEnum
public enum HilSensorUpdatedFlags {
    /**
     * None of the fields in {@link io.dronefleet.mavlink.common.HilSensor HIL_SENSOR} have been updated 
     */
    @MavlinkEntryInfo(0)
    HIL_SENSOR_UPDATED_NONE,

    /**
     * The value in the xacc field has been updated 
     */
    @MavlinkEntryInfo(1)
    HIL_SENSOR_UPDATED_XACC,

    /**
     * The value in the yacc field has been updated 
     */
    @MavlinkEntryInfo(2)
    HIL_SENSOR_UPDATED_YACC,

    /**
     * The value in the zacc field has been updated 
     */
    @MavlinkEntryInfo(4)
    HIL_SENSOR_UPDATED_ZACC,

    /**
     * The value in the xgyro field has been updated 
     */
    @MavlinkEntryInfo(8)
    HIL_SENSOR_UPDATED_XGYRO,

    /**
     * The value in the ygyro field has been updated 
     */
    @MavlinkEntryInfo(16)
    HIL_SENSOR_UPDATED_YGYRO,

    /**
     * The value in the zgyro field has been updated 
     */
    @MavlinkEntryInfo(32)
    HIL_SENSOR_UPDATED_ZGYRO,

    /**
     * The value in the xmag field has been updated 
     */
    @MavlinkEntryInfo(64)
    HIL_SENSOR_UPDATED_XMAG,

    /**
     * The value in the ymag field has been updated 
     */
    @MavlinkEntryInfo(128)
    HIL_SENSOR_UPDATED_YMAG,

    /**
     * The value in the zmag field has been updated 
     */
    @MavlinkEntryInfo(256)
    HIL_SENSOR_UPDATED_ZMAG,

    /**
     * The value in the abs_pressure field has been updated 
     */
    @MavlinkEntryInfo(512)
    HIL_SENSOR_UPDATED_ABS_PRESSURE,

    /**
     * The value in the diff_pressure field has been updated 
     */
    @MavlinkEntryInfo(1024)
    HIL_SENSOR_UPDATED_DIFF_PRESSURE,

    /**
     * The value in the pressure_alt field has been updated 
     */
    @MavlinkEntryInfo(2048)
    HIL_SENSOR_UPDATED_PRESSURE_ALT,

    /**
     * The value in the temperature field has been updated 
     */
    @MavlinkEntryInfo(4096)
    HIL_SENSOR_UPDATED_TEMPERATURE,

    /**
     * Full reset of attitude/position/velocities/etc was performed in sim (Bit 31). 
     */
    @MavlinkEntryInfo(-2147483648)
    HIL_SENSOR_UPDATED_RESET
}
