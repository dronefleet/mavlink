package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum MotorTestOrder {
  /**
   * default autopilot motor test method
   */
  @MavlinkEnumEntry(0)
  MOTOR_TEST_ORDER_DEFAULT,

  /**
   * motor numbers are specified as their index in a predefined vehicle-specific sequence
   */
  @MavlinkEnumEntry(1)
  MOTOR_TEST_ORDER_SEQUENCE,

  /**
   * motor numbers are specified as the output as labeled on the board
   */
  @MavlinkEnumEntry(2)
  MOTOR_TEST_ORDER_BOARD
}
