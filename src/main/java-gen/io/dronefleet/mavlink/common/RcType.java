package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * RC type 
 */
@MavlinkEnum
public enum RcType {
  /**
   * Spektrum DSM2
   */
  @MavlinkEnumEntry(0)
  RC_TYPE_SPEKTRUM_DSM2,

  /**
   * Spektrum DSMX
   */
  @MavlinkEnumEntry(1)
  RC_TYPE_SPEKTRUM_DSMX
}
