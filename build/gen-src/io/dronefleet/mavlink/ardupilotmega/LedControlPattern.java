package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum LedControlPattern {
  /**
   * LED patterns off (return control to regular vehicle control)
   */
  @MavlinkEnumEntry(0)
  LED_CONTROL_PATTERN_OFF,

  /**
   * LEDs show pattern during firmware update
   */
  @MavlinkEnumEntry(1)
  LED_CONTROL_PATTERN_FIRMWAREUPDATE,

  /**
   * Custom Pattern using custom bytes fields
   */
  @MavlinkEnumEntry(255)
  LED_CONTROL_PATTERN_CUSTOM
}
