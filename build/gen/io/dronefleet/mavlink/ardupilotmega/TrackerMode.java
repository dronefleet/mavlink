package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * A mapping of antenna tracker flight modes for custom_mode field of heartbeat 
 */
@MavlinkEnum
public enum TrackerMode {
  /**
   * null
   */
  @MavlinkEnumEntry(0)
  TRACKER_MODE_MANUAL,

  /**
   * null
   */
  @MavlinkEnumEntry(1)
  TRACKER_MODE_STOP,

  /**
   * null
   */
  @MavlinkEnumEntry(2)
  TRACKER_MODE_SCAN,

  /**
   * null
   */
  @MavlinkEnumEntry(3)
  TRACKER_MODE_SERVO_TEST,

  /**
   * null
   */
  @MavlinkEnumEntry(10)
  TRACKER_MODE_AUTO,

  /**
   * null
   */
  @MavlinkEnumEntry(16)
  TRACKER_MODE_INITIALIZING
}
