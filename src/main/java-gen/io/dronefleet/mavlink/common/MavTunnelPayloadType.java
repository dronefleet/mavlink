package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavTunnelPayloadType {
    /**
     * Encoding of payload unknown. 
     */
    @MavlinkEntryInfo(0)
    MAV_TUNNEL_PAYLOAD_TYPE_UNKNOWN,

    /**
     * Registered for STorM32 gimbal controller. 
     */
    @MavlinkEntryInfo(200)
    MAV_TUNNEL_PAYLOAD_TYPE_STORM32_RESERVED0,

    /**
     * Registered for STorM32 gimbal controller. 
     */
    @MavlinkEntryInfo(201)
    MAV_TUNNEL_PAYLOAD_TYPE_STORM32_RESERVED1,

    /**
     * Registered for STorM32 gimbal controller. 
     */
    @MavlinkEntryInfo(202)
    MAV_TUNNEL_PAYLOAD_TYPE_STORM32_RESERVED2,

    /**
     * Registered for STorM32 gimbal controller. 
     */
    @MavlinkEntryInfo(203)
    MAV_TUNNEL_PAYLOAD_TYPE_STORM32_RESERVED3,

    /**
     * Registered for STorM32 gimbal controller. 
     */
    @MavlinkEntryInfo(204)
    MAV_TUNNEL_PAYLOAD_TYPE_STORM32_RESERVED4,

    /**
     * Registered for STorM32 gimbal controller. 
     */
    @MavlinkEntryInfo(205)
    MAV_TUNNEL_PAYLOAD_TYPE_STORM32_RESERVED5,

    /**
     * Registered for STorM32 gimbal controller. 
     */
    @MavlinkEntryInfo(206)
    MAV_TUNNEL_PAYLOAD_TYPE_STORM32_RESERVED6,

    /**
     * Registered for STorM32 gimbal controller. 
     */
    @MavlinkEntryInfo(207)
    MAV_TUNNEL_PAYLOAD_TYPE_STORM32_RESERVED7,

    /**
     * Registered for STorM32 gimbal controller. 
     */
    @MavlinkEntryInfo(208)
    MAV_TUNNEL_PAYLOAD_TYPE_STORM32_RESERVED8,

    /**
     * Registered for STorM32 gimbal controller. 
     */
    @MavlinkEntryInfo(209)
    MAV_TUNNEL_PAYLOAD_TYPE_STORM32_RESERVED9
}
