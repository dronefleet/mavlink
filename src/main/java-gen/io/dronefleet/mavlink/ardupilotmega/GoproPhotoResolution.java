package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum GoproPhotoResolution {
  /**
   * 5MP Medium
   */
  @MavlinkEntryInfo(0)
  GOPRO_PHOTO_RESOLUTION_5MP_MEDIUM,

  /**
   * 7MP Medium
   */
  @MavlinkEntryInfo(1)
  GOPRO_PHOTO_RESOLUTION_7MP_MEDIUM,

  /**
   * 7MP Wide
   */
  @MavlinkEntryInfo(2)
  GOPRO_PHOTO_RESOLUTION_7MP_WIDE,

  /**
   * 10MP Wide
   */
  @MavlinkEntryInfo(3)
  GOPRO_PHOTO_RESOLUTION_10MP_WIDE,

  /**
   * 12MP Wide
   */
  @MavlinkEntryInfo(4)
  GOPRO_PHOTO_RESOLUTION_12MP_WIDE
}
