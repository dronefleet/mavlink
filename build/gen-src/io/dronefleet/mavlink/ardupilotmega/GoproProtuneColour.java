package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum GoproProtuneColour {
  /**
   * Auto
   */
  @MavlinkEnumEntry(0)
  GOPRO_PROTUNE_COLOUR_STANDARD,

  /**
   * Neutral
   */
  @MavlinkEnumEntry(1)
  GOPRO_PROTUNE_COLOUR_NEUTRAL
}
