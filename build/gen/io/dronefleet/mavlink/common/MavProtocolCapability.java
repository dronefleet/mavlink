package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Bitmask of (optional) autopilot capabilities (64 bit). If a bit is set, the autopilot supports 
 * this capability. 
 */
@MavlinkEnum
public enum MavProtocolCapability {
  /**
   * Autopilot supports MISSION float message type.
   */
  @MavlinkEnumEntry(1)
  MAV_PROTOCOL_CAPABILITY_MISSION_FLOAT,

  /**
   * Autopilot supports the new param float message type.
   */
  @MavlinkEnumEntry(2)
  MAV_PROTOCOL_CAPABILITY_PARAM_FLOAT,

  /**
   * Autopilot supports MISSION_INT scaled integer message type.
   */
  @MavlinkEnumEntry(4)
  MAV_PROTOCOL_CAPABILITY_MISSION_INT,

  /**
   * Autopilot supports COMMAND_INT scaled integer message type.
   */
  @MavlinkEnumEntry(8)
  MAV_PROTOCOL_CAPABILITY_COMMAND_INT,

  /**
   * Autopilot supports the new param union message type.
   */
  @MavlinkEnumEntry(16)
  MAV_PROTOCOL_CAPABILITY_PARAM_UNION,

  /**
   * Autopilot supports the new FILE_TRANSFER_PROTOCOL message type.
   */
  @MavlinkEnumEntry(32)
  MAV_PROTOCOL_CAPABILITY_FTP,

  /**
   * Autopilot supports commanding attitude offboard.
   */
  @MavlinkEnumEntry(64)
  MAV_PROTOCOL_CAPABILITY_SET_ATTITUDE_TARGET,

  /**
   * Autopilot supports commanding position and velocity targets in local NED frame.
   */
  @MavlinkEnumEntry(128)
  MAV_PROTOCOL_CAPABILITY_SET_POSITION_TARGET_LOCAL_NED,

  /**
   * Autopilot supports commanding position and velocity targets in global scaled integers.
   */
  @MavlinkEnumEntry(256)
  MAV_PROTOCOL_CAPABILITY_SET_POSITION_TARGET_GLOBAL_INT,

  /**
   * Autopilot supports terrain protocol / data handling.
   */
  @MavlinkEnumEntry(512)
  MAV_PROTOCOL_CAPABILITY_TERRAIN,

  /**
   * Autopilot supports direct actuator control.
   */
  @MavlinkEnumEntry(1024)
  MAV_PROTOCOL_CAPABILITY_SET_ACTUATOR_TARGET,

  /**
   * Autopilot supports the flight termination command.
   */
  @MavlinkEnumEntry(2048)
  MAV_PROTOCOL_CAPABILITY_FLIGHT_TERMINATION,

  /**
   * Autopilot supports onboard compass calibration.
   */
  @MavlinkEnumEntry(4096)
  MAV_PROTOCOL_CAPABILITY_COMPASS_CALIBRATION,

  /**
   * Autopilot supports mavlink version 2.
   */
  @MavlinkEnumEntry(8192)
  MAV_PROTOCOL_CAPABILITY_MAVLINK2,

  /**
   * Autopilot supports mission fence protocol.
   */
  @MavlinkEnumEntry(16384)
  MAV_PROTOCOL_CAPABILITY_MISSION_FENCE,

  /**
   * Autopilot supports mission rally point protocol.
   */
  @MavlinkEnumEntry(32768)
  MAV_PROTOCOL_CAPABILITY_MISSION_RALLY,

  /**
   * Autopilot supports the flight information protocol.
   */
  @MavlinkEnumEntry(65536)
  MAV_PROTOCOL_CAPABILITY_FLIGHT_INFORMATION
}
