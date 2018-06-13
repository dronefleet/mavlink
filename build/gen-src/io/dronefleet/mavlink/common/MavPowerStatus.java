package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Power supply status flags (bitmask) 
 */
@MavlinkEnum
public enum MavPowerStatus {
  /**
   * main brick power supply valid
   */
  @MavlinkEnumEntry(1)
  MAV_POWER_STATUS_BRICK_VALID,

  /**
   * main servo power supply valid for FMU
   */
  @MavlinkEnumEntry(2)
  MAV_POWER_STATUS_SERVO_VALID,

  /**
   * USB power is connected
   */
  @MavlinkEnumEntry(4)
  MAV_POWER_STATUS_USB_CONNECTED,

  /**
   * peripheral supply is in over-current state
   */
  @MavlinkEnumEntry(8)
  MAV_POWER_STATUS_PERIPH_OVERCURRENT,

  /**
   * hi-power peripheral supply is in over-current state
   */
  @MavlinkEnumEntry(16)
  MAV_POWER_STATUS_PERIPH_HIPOWER_OVERCURRENT,

  /**
   * Power status has changed since boot
   */
  @MavlinkEnumEntry(32)
  MAV_POWER_STATUS_CHANGED
}
