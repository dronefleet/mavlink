package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Type of landing target 
 */
@MavlinkEnum
public enum LandingTargetType {
  /**
   * Landing target signaled by light beacon (ex: IR-LOCK)
   */
  @MavlinkEntryInfo(0)
  LANDING_TARGET_TYPE_LIGHT_BEACON,

  /**
   * Landing target signaled by radio beacon (ex: ILS, NDB)
   */
  @MavlinkEntryInfo(1)
  LANDING_TARGET_TYPE_RADIO_BEACON,

  /**
   * Landing target represented by a fiducial marker (ex: ARTag)
   */
  @MavlinkEntryInfo(2)
  LANDING_TARGET_TYPE_VISION_FIDUCIAL,

  /**
   * Landing target represented by a pre-defined visual shape/feature (ex: X-marker, H-marker, square)
   */
  @MavlinkEntryInfo(3)
  LANDING_TARGET_TYPE_VISION_OTHER
}
