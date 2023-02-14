package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Flags in the {@link io.dronefleet.mavlink.common.HighresImu HIGHRES_IMU} message indicate which fields have updated since the last message 
 */
@MavlinkEnum
public enum HighresImuUpdatedFlags {
    /**
     * None of the fields in {@link io.dronefleet.mavlink.common.HighresImu HIGHRES_IMU} have been updated 
     */
    @MavlinkEntryInfo(0)
    HIGHRES_IMU_UPDATED_NONE,

    /**
     * The value in the xacc field has been updated 
     */
    @MavlinkEntryInfo(1)
    HIGHRES_IMU_UPDATED_XACC,

    /**
     * The value in the yacc field has been updated 
     */
    @MavlinkEntryInfo(2)
    HIGHRES_IMU_UPDATED_YACC,

    /**
     * The value in the zacc field has been updated since 
     */
    @MavlinkEntryInfo(4)
    HIGHRES_IMU_UPDATED_ZACC,

    /**
     * The value in the xgyro field has been updated 
     */
    @MavlinkEntryInfo(8)
    HIGHRES_IMU_UPDATED_XGYRO,

    /**
     * The value in the ygyro field has been updated 
     */
    @MavlinkEntryInfo(16)
    HIGHRES_IMU_UPDATED_YGYRO,

    /**
     * The value in the zgyro field has been updated 
     */
    @MavlinkEntryInfo(32)
    HIGHRES_IMU_UPDATED_ZGYRO,

    /**
     * The value in the xmag field has been updated 
     */
    @MavlinkEntryInfo(64)
    HIGHRES_IMU_UPDATED_XMAG,

    /**
     * The value in the ymag field has been updated 
     */
    @MavlinkEntryInfo(128)
    HIGHRES_IMU_UPDATED_YMAG,

    /**
     * The value in the zmag field has been updated 
     */
    @MavlinkEntryInfo(256)
    HIGHRES_IMU_UPDATED_ZMAG,

    /**
     * The value in the abs_pressure field has been updated 
     */
    @MavlinkEntryInfo(512)
    HIGHRES_IMU_UPDATED_ABS_PRESSURE,

    /**
     * The value in the diff_pressure field has been updated 
     */
    @MavlinkEntryInfo(1024)
    HIGHRES_IMU_UPDATED_DIFF_PRESSURE,

    /**
     * The value in the pressure_alt field has been updated 
     */
    @MavlinkEntryInfo(2048)
    HIGHRES_IMU_UPDATED_PRESSURE_ALT,

    /**
     * The value in the temperature field has been updated 
     */
    @MavlinkEntryInfo(4096)
    HIGHRES_IMU_UPDATED_TEMPERATURE,

    /**
     * All fields in {@link io.dronefleet.mavlink.common.HighresImu HIGHRES_IMU} have been updated. 
     */
    @MavlinkEntryInfo(65535)
    HIGHRES_IMU_UPDATED_ALL
}
