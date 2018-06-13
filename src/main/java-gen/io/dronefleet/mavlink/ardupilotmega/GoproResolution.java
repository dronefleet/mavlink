package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum GoproResolution {
  /**
   * 848 x 480 (480p)
   */
  @MavlinkEnumEntry(0)
  GOPRO_RESOLUTION_480p,

  /**
   * 1280 x 720 (720p)
   */
  @MavlinkEnumEntry(1)
  GOPRO_RESOLUTION_720p,

  /**
   * 1280 x 960 (960p)
   */
  @MavlinkEnumEntry(2)
  GOPRO_RESOLUTION_960p,

  /**
   * 1920 x 1080 (1080p)
   */
  @MavlinkEnumEntry(3)
  GOPRO_RESOLUTION_1080p,

  /**
   * 1920 x 1440 (1440p)
   */
  @MavlinkEnumEntry(4)
  GOPRO_RESOLUTION_1440p,

  /**
   * 2704 x 1440 (2.7k-17:9)
   */
  @MavlinkEnumEntry(5)
  GOPRO_RESOLUTION_2_7k_17_9,

  /**
   * 2704 x 1524 (2.7k-16:9)
   */
  @MavlinkEnumEntry(6)
  GOPRO_RESOLUTION_2_7k_16_9,

  /**
   * 2704 x 2028 (2.7k-4:3)
   */
  @MavlinkEnumEntry(7)
  GOPRO_RESOLUTION_2_7k_4_3,

  /**
   * 3840 x 2160 (4k-16:9)
   */
  @MavlinkEnumEntry(8)
  GOPRO_RESOLUTION_4k_16_9,

  /**
   * 4096 x 2160 (4k-17:9)
   */
  @MavlinkEnumEntry(9)
  GOPRO_RESOLUTION_4k_17_9,

  /**
   * 1280 x 720 (720p-SuperView)
   */
  @MavlinkEnumEntry(10)
  GOPRO_RESOLUTION_720p_SUPERVIEW,

  /**
   * 1920 x 1080 (1080p-SuperView)
   */
  @MavlinkEnumEntry(11)
  GOPRO_RESOLUTION_1080p_SUPERVIEW,

  /**
   * 2704 x 1520 (2.7k-SuperView)
   */
  @MavlinkEnumEntry(12)
  GOPRO_RESOLUTION_2_7k_SUPERVIEW,

  /**
   * 3840 x 2160 (4k-SuperView)
   */
  @MavlinkEnumEntry(13)
  GOPRO_RESOLUTION_4k_SUPERVIEW
}
