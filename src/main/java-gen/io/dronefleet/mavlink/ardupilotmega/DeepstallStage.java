package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Deepstall flight stage 
 */
@MavlinkEnum
public enum DeepstallStage {
  /**
   * Flying to the landing point
   */
  @MavlinkEntryInfo(0)
  DEEPSTALL_STAGE_FLY_TO_LANDING,

  /**
   * Building an estimate of the wind
   */
  @MavlinkEntryInfo(1)
  DEEPSTALL_STAGE_ESTIMATE_WIND,

  /**
   * Waiting to breakout of the loiter to fly the approach
   */
  @MavlinkEntryInfo(2)
  DEEPSTALL_STAGE_WAIT_FOR_BREAKOUT,

  /**
   * Flying to the first arc point to turn around to the landing point
   */
  @MavlinkEntryInfo(3)
  DEEPSTALL_STAGE_FLY_TO_ARC,

  /**
   * Turning around back to the deepstall landing point
   */
  @MavlinkEntryInfo(4)
  DEEPSTALL_STAGE_ARC,

  /**
   * Approaching the landing point
   */
  @MavlinkEntryInfo(5)
  DEEPSTALL_STAGE_APPROACH,

  /**
   * Stalling and steering towards the land point
   */
  @MavlinkEntryInfo(6)
  DEEPSTALL_STAGE_LAND
}
