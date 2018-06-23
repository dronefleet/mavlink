package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Bitmask of (optional) autopilot capabilities (64 bit). If a bit is set, the autopilot supports 
 * this capability. 
 */
@MavlinkEnum
public enum MavProtocolCapability {
    /**
     * Autopilot supports MISSION float message type.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    MAV_PROTOCOL_CAPABILITY_MISSION_FLOAT,

    /**
     * Autopilot supports the new param float message type.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    MAV_PROTOCOL_CAPABILITY_PARAM_FLOAT,

    /**
     * Autopilot supports MISSION_INT scaled integer message type.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    MAV_PROTOCOL_CAPABILITY_MISSION_INT,

    /**
     * Autopilot supports COMMAND_INT scaled integer message type.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8)
    MAV_PROTOCOL_CAPABILITY_COMMAND_INT,

    /**
     * Autopilot supports the new param union message type.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16)
    MAV_PROTOCOL_CAPABILITY_PARAM_UNION,

    /**
     * Autopilot supports the new FILE_TRANSFER_PROTOCOL message type.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(32)
    MAV_PROTOCOL_CAPABILITY_FTP,

    /**
     * Autopilot supports commanding attitude offboard.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(64)
    MAV_PROTOCOL_CAPABILITY_SET_ATTITUDE_TARGET,

    /**
     * Autopilot supports commanding position and velocity targets in local NED frame.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(128)
    MAV_PROTOCOL_CAPABILITY_SET_POSITION_TARGET_LOCAL_NED,

    /**
     * Autopilot supports commanding position and velocity targets in global scaled integers.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(256)
    MAV_PROTOCOL_CAPABILITY_SET_POSITION_TARGET_GLOBAL_INT,

    /**
     * Autopilot supports terrain protocol / data handling.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(512)
    MAV_PROTOCOL_CAPABILITY_TERRAIN,

    /**
     * Autopilot supports direct actuator control.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1024)
    MAV_PROTOCOL_CAPABILITY_SET_ACTUATOR_TARGET,

    /**
     * Autopilot supports the flight termination command.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2048)
    MAV_PROTOCOL_CAPABILITY_FLIGHT_TERMINATION,

    /**
     * Autopilot supports onboard compass calibration.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4096)
    MAV_PROTOCOL_CAPABILITY_COMPASS_CALIBRATION,

    /**
     * Autopilot supports mavlink version 2.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8192)
    MAV_PROTOCOL_CAPABILITY_MAVLINK2,

    /**
     * Autopilot supports mission fence protocol.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16384)
    MAV_PROTOCOL_CAPABILITY_MISSION_FENCE,

    /**
     * Autopilot supports mission rally point protocol.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(32768)
    MAV_PROTOCOL_CAPABILITY_MISSION_RALLY,

    /**
     * Autopilot supports the flight information protocol.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(65536)
    MAV_PROTOCOL_CAPABILITY_FLIGHT_INFORMATION
}
