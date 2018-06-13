package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum MavlinkDataStreamType {
  /**
   * null
   */
  @MavlinkEnumEntry(1)
  MAVLINK_DATA_STREAM_IMG_JPEG,

  /**
   * null
   */
  @MavlinkEnumEntry(2)
  MAVLINK_DATA_STREAM_IMG_BMP,

  /**
   * null
   */
  @MavlinkEnumEntry(3)
  MAVLINK_DATA_STREAM_IMG_RAW8U,

  /**
   * null
   */
  @MavlinkEnumEntry(4)
  MAVLINK_DATA_STREAM_IMG_RAW32U,

  /**
   * null
   */
  @MavlinkEnumEntry(5)
  MAVLINK_DATA_STREAM_IMG_PGM,

  /**
   * null
   */
  @MavlinkEnumEntry(6)
  MAVLINK_DATA_STREAM_IMG_PNG
}
