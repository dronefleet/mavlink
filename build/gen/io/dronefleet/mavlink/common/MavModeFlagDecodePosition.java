package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * These values encode the bit positions of the decode position. These values can be used to read 
 * the value of a flag bit by combining the base_mode variable with AND with the flag position 
 * value. The result will be either 0 or 1, depending on if the flag is set or not. 
 */
@MavlinkEnum
public enum MavModeFlagDecodePosition {
  /**
   * First bit:  10000000
   */
  @MavlinkEnumEntry(128)
  MAV_MODE_FLAG_DECODE_POSITION_SAFETY,

  /**
   * Second bit: 01000000
   */
  @MavlinkEnumEntry(64)
  MAV_MODE_FLAG_DECODE_POSITION_MANUAL,

  /**
   * Third bit:  00100000
   */
  @MavlinkEnumEntry(32)
  MAV_MODE_FLAG_DECODE_POSITION_HIL,

  /**
   * Fourth bit: 00010000
   */
  @MavlinkEnumEntry(16)
  MAV_MODE_FLAG_DECODE_POSITION_STABILIZE,

  /**
   * Fifth bit:  00001000
   */
  @MavlinkEnumEntry(8)
  MAV_MODE_FLAG_DECODE_POSITION_GUIDED,

  /**
   * Sixt bit:   00000100
   */
  @MavlinkEnumEntry(4)
  MAV_MODE_FLAG_DECODE_POSITION_AUTO,

  /**
   * Seventh bit: 00000010
   */
  @MavlinkEnumEntry(2)
  MAV_MODE_FLAG_DECODE_POSITION_TEST,

  /**
   * Eighth bit: 00000001
   */
  @MavlinkEnumEntry(1)
  MAV_MODE_FLAG_DECODE_POSITION_CUSTOM_MODE
}
