package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum GpsInputIgnoreFlags {
  /**
   * ignore altitude field
   */
  @MavlinkEnumEntry(1)
  GPS_INPUT_IGNORE_FLAG_ALT,

  /**
   * ignore hdop field
   */
  @MavlinkEnumEntry(2)
  GPS_INPUT_IGNORE_FLAG_HDOP,

  /**
   * ignore vdop field
   */
  @MavlinkEnumEntry(4)
  GPS_INPUT_IGNORE_FLAG_VDOP,

  /**
   * ignore horizontal velocity field (vn and ve)
   */
  @MavlinkEnumEntry(8)
  GPS_INPUT_IGNORE_FLAG_VEL_HORIZ,

  /**
   * ignore vertical velocity field (vd)
   */
  @MavlinkEnumEntry(16)
  GPS_INPUT_IGNORE_FLAG_VEL_VERT,

  /**
   * ignore speed accuracy field
   */
  @MavlinkEnumEntry(32)
  GPS_INPUT_IGNORE_FLAG_SPEED_ACCURACY,

  /**
   * ignore horizontal accuracy field
   */
  @MavlinkEnumEntry(64)
  GPS_INPUT_IGNORE_FLAG_HORIZONTAL_ACCURACY,

  /**
   * ignore vertical accuracy field
   */
  @MavlinkEnumEntry(128)
  GPS_INPUT_IGNORE_FLAG_VERTICAL_ACCURACY
}
