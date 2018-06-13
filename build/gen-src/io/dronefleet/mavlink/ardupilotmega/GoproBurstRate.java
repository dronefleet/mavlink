package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum GoproBurstRate {
  /**
   * 3 Shots / 1 Second
   */
  @MavlinkEnumEntry(0)
  GOPRO_BURST_RATE_3_IN_1_SECOND,

  /**
   * 5 Shots / 1 Second
   */
  @MavlinkEnumEntry(1)
  GOPRO_BURST_RATE_5_IN_1_SECOND,

  /**
   * 10 Shots / 1 Second
   */
  @MavlinkEnumEntry(2)
  GOPRO_BURST_RATE_10_IN_1_SECOND,

  /**
   * 10 Shots / 2 Second
   */
  @MavlinkEnumEntry(3)
  GOPRO_BURST_RATE_10_IN_2_SECOND,

  /**
   * 10 Shots / 3 Second (Hero 4 Only)
   */
  @MavlinkEnumEntry(4)
  GOPRO_BURST_RATE_10_IN_3_SECOND,

  /**
   * 30 Shots / 1 Second
   */
  @MavlinkEnumEntry(5)
  GOPRO_BURST_RATE_30_IN_1_SECOND,

  /**
   * 30 Shots / 2 Second
   */
  @MavlinkEnumEntry(6)
  GOPRO_BURST_RATE_30_IN_2_SECOND,

  /**
   * 30 Shots / 3 Second
   */
  @MavlinkEnumEntry(7)
  GOPRO_BURST_RATE_30_IN_3_SECOND,

  /**
   * 30 Shots / 6 Second
   */
  @MavlinkEnumEntry(8)
  GOPRO_BURST_RATE_30_IN_6_SECOND
}
