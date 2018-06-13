package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum CameraStatusTypes {
  /**
   * Camera heartbeat, announce camera component ID at 1hz
   */
  @MavlinkEnumEntry(0)
  CAMERA_STATUS_TYPE_HEARTBEAT,

  /**
   * Camera image triggered
   */
  @MavlinkEnumEntry(1)
  CAMERA_STATUS_TYPE_TRIGGER,

  /**
   * Camera connection lost
   */
  @MavlinkEnumEntry(2)
  CAMERA_STATUS_TYPE_DISCONNECT,

  /**
   * Camera unknown error
   */
  @MavlinkEnumEntry(3)
  CAMERA_STATUS_TYPE_ERROR,

  /**
   * Camera battery low. Parameter p1 shows reported voltage
   */
  @MavlinkEnumEntry(4)
  CAMERA_STATUS_TYPE_LOWBATT,

  /**
   * Camera storage low. Parameter p1 shows reported shots remaining
   */
  @MavlinkEnumEntry(5)
  CAMERA_STATUS_TYPE_LOWSTORE,

  /**
   * Camera storage low. Parameter p1 shows reported video minutes remaining
   */
  @MavlinkEnumEntry(6)
  CAMERA_STATUS_TYPE_LOWSTOREV
}
