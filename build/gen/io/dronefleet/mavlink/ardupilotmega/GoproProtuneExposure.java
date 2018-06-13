package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum GoproProtuneExposure {
  /**
   * -5.0 EV (Hero 3+ Only)
   */
  @MavlinkEnumEntry(0)
  GOPRO_PROTUNE_EXPOSURE_NEG_5_0,

  /**
   * -4.5 EV (Hero 3+ Only)
   */
  @MavlinkEnumEntry(1)
  GOPRO_PROTUNE_EXPOSURE_NEG_4_5,

  /**
   * -4.0 EV (Hero 3+ Only)
   */
  @MavlinkEnumEntry(2)
  GOPRO_PROTUNE_EXPOSURE_NEG_4_0,

  /**
   * -3.5 EV (Hero 3+ Only)
   */
  @MavlinkEnumEntry(3)
  GOPRO_PROTUNE_EXPOSURE_NEG_3_5,

  /**
   * -3.0 EV (Hero 3+ Only)
   */
  @MavlinkEnumEntry(4)
  GOPRO_PROTUNE_EXPOSURE_NEG_3_0,

  /**
   * -2.5 EV (Hero 3+ Only)
   */
  @MavlinkEnumEntry(5)
  GOPRO_PROTUNE_EXPOSURE_NEG_2_5,

  /**
   * -2.0 EV
   */
  @MavlinkEnumEntry(6)
  GOPRO_PROTUNE_EXPOSURE_NEG_2_0,

  /**
   * -1.5 EV
   */
  @MavlinkEnumEntry(7)
  GOPRO_PROTUNE_EXPOSURE_NEG_1_5,

  /**
   * -1.0 EV
   */
  @MavlinkEnumEntry(8)
  GOPRO_PROTUNE_EXPOSURE_NEG_1_0,

  /**
   * -0.5 EV
   */
  @MavlinkEnumEntry(9)
  GOPRO_PROTUNE_EXPOSURE_NEG_0_5,

  /**
   * 0.0 EV
   */
  @MavlinkEnumEntry(10)
  GOPRO_PROTUNE_EXPOSURE_ZERO,

  /**
   * +0.5 EV
   */
  @MavlinkEnumEntry(11)
  GOPRO_PROTUNE_EXPOSURE_POS_0_5,

  /**
   * +1.0 EV
   */
  @MavlinkEnumEntry(12)
  GOPRO_PROTUNE_EXPOSURE_POS_1_0,

  /**
   * +1.5 EV
   */
  @MavlinkEnumEntry(13)
  GOPRO_PROTUNE_EXPOSURE_POS_1_5,

  /**
   * +2.0 EV
   */
  @MavlinkEnumEntry(14)
  GOPRO_PROTUNE_EXPOSURE_POS_2_0,

  /**
   * +2.5 EV (Hero 3+ Only)
   */
  @MavlinkEnumEntry(15)
  GOPRO_PROTUNE_EXPOSURE_POS_2_5,

  /**
   * +3.0 EV (Hero 3+ Only)
   */
  @MavlinkEnumEntry(16)
  GOPRO_PROTUNE_EXPOSURE_POS_3_0,

  /**
   * +3.5 EV (Hero 3+ Only)
   */
  @MavlinkEnumEntry(17)
  GOPRO_PROTUNE_EXPOSURE_POS_3_5,

  /**
   * +4.0 EV (Hero 3+ Only)
   */
  @MavlinkEnumEntry(18)
  GOPRO_PROTUNE_EXPOSURE_POS_4_0,

  /**
   * +4.5 EV (Hero 3+ Only)
   */
  @MavlinkEnumEntry(19)
  GOPRO_PROTUNE_EXPOSURE_POS_4_5,

  /**
   * +5.0 EV (Hero 3+ Only)
   */
  @MavlinkEnumEntry(20)
  GOPRO_PROTUNE_EXPOSURE_POS_5_0
}
