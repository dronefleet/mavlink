package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum GoproPhotoResolution {
  /**
   * 5MP Medium
   */
  @MavlinkEnumEntry(0)
  GOPRO_PHOTO_RESOLUTION_5MP_MEDIUM,

  /**
   * 7MP Medium
   */
  @MavlinkEnumEntry(1)
  GOPRO_PHOTO_RESOLUTION_7MP_MEDIUM,

  /**
   * 7MP Wide
   */
  @MavlinkEnumEntry(2)
  GOPRO_PHOTO_RESOLUTION_7MP_WIDE,

  /**
   * 10MP Wide
   */
  @MavlinkEnumEntry(3)
  GOPRO_PHOTO_RESOLUTION_10MP_WIDE,

  /**
   * 12MP Wide
   */
  @MavlinkEnumEntry(4)
  GOPRO_PHOTO_RESOLUTION_12MP_WIDE
}
