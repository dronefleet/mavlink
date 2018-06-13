package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Bus types for device operations 
 */
@MavlinkEnum
public enum DeviceOpBustype {
  /**
   * I2C Device operation
   */
  @MavlinkEnumEntry(0)
  DEVICE_OP_BUSTYPE_I2C,

  /**
   * SPI Device operation
   */
  @MavlinkEnumEntry(1)
  DEVICE_OP_BUSTYPE_SPI
}
