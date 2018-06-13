package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * SERIAL_CONTROL device types 
 */
@MavlinkEnum
public enum SerialControlDev {
  /**
   * First telemetry port
   */
  @MavlinkEnumEntry(0)
  SERIAL_CONTROL_DEV_TELEM1,

  /**
   * Second telemetry port
   */
  @MavlinkEnumEntry(1)
  SERIAL_CONTROL_DEV_TELEM2,

  /**
   * First GPS port
   */
  @MavlinkEnumEntry(2)
  SERIAL_CONTROL_DEV_GPS1,

  /**
   * Second GPS port
   */
  @MavlinkEnumEntry(3)
  SERIAL_CONTROL_DEV_GPS2,

  /**
   * system shell
   */
  @MavlinkEnumEntry(10)
  SERIAL_CONTROL_DEV_SHELL
}
