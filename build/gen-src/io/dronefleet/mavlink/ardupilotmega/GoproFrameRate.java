package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum GoproFrameRate {
  /**
   * 12 FPS
   */
  @MavlinkEnumEntry(0)
  GOPRO_FRAME_RATE_12,

  /**
   * 15 FPS
   */
  @MavlinkEnumEntry(1)
  GOPRO_FRAME_RATE_15,

  /**
   * 24 FPS
   */
  @MavlinkEnumEntry(2)
  GOPRO_FRAME_RATE_24,

  /**
   * 25 FPS
   */
  @MavlinkEnumEntry(3)
  GOPRO_FRAME_RATE_25,

  /**
   * 30 FPS
   */
  @MavlinkEnumEntry(4)
  GOPRO_FRAME_RATE_30,

  /**
   * 48 FPS
   */
  @MavlinkEnumEntry(5)
  GOPRO_FRAME_RATE_48,

  /**
   * 50 FPS
   */
  @MavlinkEnumEntry(6)
  GOPRO_FRAME_RATE_50,

  /**
   * 60 FPS
   */
  @MavlinkEnumEntry(7)
  GOPRO_FRAME_RATE_60,

  /**
   * 80 FPS
   */
  @MavlinkEnumEntry(8)
  GOPRO_FRAME_RATE_80,

  /**
   * 90 FPS
   */
  @MavlinkEnumEntry(9)
  GOPRO_FRAME_RATE_90,

  /**
   * 100 FPS
   */
  @MavlinkEnumEntry(10)
  GOPRO_FRAME_RATE_100,

  /**
   * 120 FPS
   */
  @MavlinkEnumEntry(11)
  GOPRO_FRAME_RATE_120,

  /**
   * 240 FPS
   */
  @MavlinkEnumEntry(12)
  GOPRO_FRAME_RATE_240,

  /**
   * 12.5 FPS
   */
  @MavlinkEnumEntry(13)
  GOPRO_FRAME_RATE_12_5
}
