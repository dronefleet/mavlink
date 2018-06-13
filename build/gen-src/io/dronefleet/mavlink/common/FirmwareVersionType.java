package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * These values define the type of firmware release. These values indicate the first version or 
 * release of this type. For example the first alpha release would be 64, the second would be 65. 
 */
@MavlinkEnum
public enum FirmwareVersionType {
  /**
   * development release
   */
  @MavlinkEnumEntry(0)
  FIRMWARE_VERSION_TYPE_DEV,

  /**
   * alpha release
   */
  @MavlinkEnumEntry(64)
  FIRMWARE_VERSION_TYPE_ALPHA,

  /**
   * beta release
   */
  @MavlinkEnumEntry(128)
  FIRMWARE_VERSION_TYPE_BETA,

  /**
   * release candidate
   */
  @MavlinkEnumEntry(192)
  FIRMWARE_VERSION_TYPE_RC,

  /**
   * official stable release
   */
  @MavlinkEnumEntry(255)
  FIRMWARE_VERSION_TYPE_OFFICIAL
}
