package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum GoproModel {
  /**
   * Unknown gopro model
   */
  @MavlinkEnumEntry(0)
  GOPRO_MODEL_UNKNOWN,

  /**
   * Hero 3+ Silver (HeroBus not supported by GoPro)
   */
  @MavlinkEnumEntry(1)
  GOPRO_MODEL_HERO_3_PLUS_SILVER,

  /**
   * Hero 3+ Black
   */
  @MavlinkEnumEntry(2)
  GOPRO_MODEL_HERO_3_PLUS_BLACK,

  /**
   * Hero 4 Silver
   */
  @MavlinkEnumEntry(3)
  GOPRO_MODEL_HERO_4_SILVER,

  /**
   * Hero 4 Black
   */
  @MavlinkEnumEntry(4)
  GOPRO_MODEL_HERO_4_BLACK
}
