package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Indicates the ESC connection type. 
 */
@MavlinkEnum
public enum EscConnectionType {
    /**
     * Traditional PPM ESC. 
     */
    @MavlinkEntryInfo(0)
    ESC_CONNECTION_TYPE_PPM,

    /**
     * Serial Bus connected ESC. 
     */
    @MavlinkEntryInfo(1)
    ESC_CONNECTION_TYPE_SERIAL,

    /**
     * One Shot PPM ESC. 
     */
    @MavlinkEntryInfo(2)
    ESC_CONNECTION_TYPE_ONESHOT,

    /**
     * I2C ESC. 
     */
    @MavlinkEntryInfo(3)
    ESC_CONNECTION_TYPE_I2C,

    /**
     * CAN-Bus ESC. 
     */
    @MavlinkEntryInfo(4)
    ESC_CONNECTION_TYPE_CAN,

    /**
     * DShot ESC. 
     */
    @MavlinkEntryInfo(5)
    ESC_CONNECTION_TYPE_DSHOT
}
