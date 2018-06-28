package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Bus types for device operations 
 */
@MavlinkEnum
public enum DeviceOpBustype {
    /**
     * I2C Device operation 
     */
    @MavlinkEntryInfo(0)
    DEVICE_OP_BUSTYPE_I2C,

    /**
     * SPI Device operation 
     */
    @MavlinkEntryInfo(1)
    DEVICE_OP_BUSTYPE_SPI
}
