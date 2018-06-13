package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum GoproProtuneGain {
  /**
   * ISO 400
   */
  @MavlinkEnumEntry(0)
  GOPRO_PROTUNE_GAIN_400,

  /**
   * ISO 800 (Only Hero 4)
   */
  @MavlinkEnumEntry(1)
  GOPRO_PROTUNE_GAIN_800,

  /**
   * ISO 1600
   */
  @MavlinkEnumEntry(2)
  GOPRO_PROTUNE_GAIN_1600,

  /**
   * ISO 3200 (Only Hero 4)
   */
  @MavlinkEnumEntry(3)
  GOPRO_PROTUNE_GAIN_3200,

  /**
   * ISO 6400
   */
  @MavlinkEnumEntry(4)
  GOPRO_PROTUNE_GAIN_6400
}
