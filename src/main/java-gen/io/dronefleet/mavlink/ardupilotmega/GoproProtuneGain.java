package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum GoproProtuneGain {
  /**
   * ISO 400
   */
  @MavlinkEntryInfo(0)
  GOPRO_PROTUNE_GAIN_400,

  /**
   * ISO 800 (Only Hero 4)
   */
  @MavlinkEntryInfo(1)
  GOPRO_PROTUNE_GAIN_800,

  /**
   * ISO 1600
   */
  @MavlinkEntryInfo(2)
  GOPRO_PROTUNE_GAIN_1600,

  /**
   * ISO 3200 (Only Hero 4)
   */
  @MavlinkEntryInfo(3)
  GOPRO_PROTUNE_GAIN_3200,

  /**
   * ISO 6400
   */
  @MavlinkEntryInfo(4)
  GOPRO_PROTUNE_GAIN_6400
}
