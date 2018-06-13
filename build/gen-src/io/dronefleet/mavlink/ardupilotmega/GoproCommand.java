package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum GoproCommand {
  /**
   * (Get/Set)
   */
  @MavlinkEnumEntry(0)
  GOPRO_COMMAND_POWER,

  /**
   * (Get/Set)
   */
  @MavlinkEnumEntry(1)
  GOPRO_COMMAND_CAPTURE_MODE,

  /**
   * (___/Set)
   */
  @MavlinkEnumEntry(2)
  GOPRO_COMMAND_SHUTTER,

  /**
   * (Get/___)
   */
  @MavlinkEnumEntry(3)
  GOPRO_COMMAND_BATTERY,

  /**
   * (Get/___)
   */
  @MavlinkEnumEntry(4)
  GOPRO_COMMAND_MODEL,

  /**
   * (Get/Set)
   */
  @MavlinkEnumEntry(5)
  GOPRO_COMMAND_VIDEO_SETTINGS,

  /**
   * (Get/Set)
   */
  @MavlinkEnumEntry(6)
  GOPRO_COMMAND_LOW_LIGHT,

  /**
   * (Get/Set)
   */
  @MavlinkEnumEntry(7)
  GOPRO_COMMAND_PHOTO_RESOLUTION,

  /**
   * (Get/Set)
   */
  @MavlinkEnumEntry(8)
  GOPRO_COMMAND_PHOTO_BURST_RATE,

  /**
   * (Get/Set)
   */
  @MavlinkEnumEntry(9)
  GOPRO_COMMAND_PROTUNE,

  /**
   * (Get/Set) Hero 3+ Only
   */
  @MavlinkEnumEntry(10)
  GOPRO_COMMAND_PROTUNE_WHITE_BALANCE,

  /**
   * (Get/Set) Hero 3+ Only
   */
  @MavlinkEnumEntry(11)
  GOPRO_COMMAND_PROTUNE_COLOUR,

  /**
   * (Get/Set) Hero 3+ Only
   */
  @MavlinkEnumEntry(12)
  GOPRO_COMMAND_PROTUNE_GAIN,

  /**
   * (Get/Set) Hero 3+ Only
   */
  @MavlinkEnumEntry(13)
  GOPRO_COMMAND_PROTUNE_SHARPNESS,

  /**
   * (Get/Set) Hero 3+ Only
   */
  @MavlinkEnumEntry(14)
  GOPRO_COMMAND_PROTUNE_EXPOSURE,

  /**
   * (Get/Set)
   */
  @MavlinkEnumEntry(15)
  GOPRO_COMMAND_TIME,

  /**
   * (Get/Set)
   */
  @MavlinkEnumEntry(16)
  GOPRO_COMMAND_CHARGING
}
