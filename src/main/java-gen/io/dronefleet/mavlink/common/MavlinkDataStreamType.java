package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum MavlinkDataStreamType {
  /**
   * null
   */
  @MavlinkEntryInfo(1)
  MAVLINK_DATA_STREAM_IMG_JPEG,

  /**
   * null
   */
  @MavlinkEntryInfo(2)
  MAVLINK_DATA_STREAM_IMG_BMP,

  /**
   * null
   */
  @MavlinkEntryInfo(3)
  MAVLINK_DATA_STREAM_IMG_RAW8U,

  /**
   * null
   */
  @MavlinkEntryInfo(4)
  MAVLINK_DATA_STREAM_IMG_RAW32U,

  /**
   * null
   */
  @MavlinkEntryInfo(5)
  MAVLINK_DATA_STREAM_IMG_PGM,

  /**
   * null
   */
  @MavlinkEntryInfo(6)
  MAVLINK_DATA_STREAM_IMG_PNG
}
