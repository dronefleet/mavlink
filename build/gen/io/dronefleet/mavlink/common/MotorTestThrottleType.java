package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum MotorTestThrottleType {
  /**
   * throttle as a percentage from 0 ~ 100
   */
  @MavlinkEnumEntry(0)
  MOTOR_TEST_THROTTLE_PERCENT,

  /**
   * throttle as an absolute PWM value (normally in range of 1000~2000)
   */
  @MavlinkEnumEntry(1)
  MOTOR_TEST_THROTTLE_PWM,

  /**
   * throttle pass-through from pilot's transmitter
   */
  @MavlinkEnumEntry(2)
  MOTOR_TEST_THROTTLE_PILOT,

  /**
   * per-motor compass calibration test
   */
  @MavlinkEnumEntry(3)
  MOTOR_TEST_COMPASS_CAL
}
