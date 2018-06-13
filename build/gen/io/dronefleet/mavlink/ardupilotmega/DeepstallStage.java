package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Deepstall flight stage 
 */
@MavlinkEnum
public enum DeepstallStage {
  /**
   * Flying to the landing point
   */
  @MavlinkEnumEntry(0)
  DEEPSTALL_STAGE_FLY_TO_LANDING,

  /**
   * Building an estimate of the wind
   */
  @MavlinkEnumEntry(1)
  DEEPSTALL_STAGE_ESTIMATE_WIND,

  /**
   * Waiting to breakout of the loiter to fly the approach
   */
  @MavlinkEnumEntry(2)
  DEEPSTALL_STAGE_WAIT_FOR_BREAKOUT,

  /**
   * Flying to the first arc point to turn around to the landing point
   */
  @MavlinkEnumEntry(3)
  DEEPSTALL_STAGE_FLY_TO_ARC,

  /**
   * Turning around back to the deepstall landing point
   */
  @MavlinkEnumEntry(4)
  DEEPSTALL_STAGE_ARC,

  /**
   * Approaching the landing point
   */
  @MavlinkEnumEntry(5)
  DEEPSTALL_STAGE_APPROACH,

  /**
   * Stalling and steering towards the land point
   */
  @MavlinkEnumEntry(6)
  DEEPSTALL_STAGE_LAND
}
