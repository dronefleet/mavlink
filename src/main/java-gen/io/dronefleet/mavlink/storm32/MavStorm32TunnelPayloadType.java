package io.dronefleet.mavlink.storm32;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavStorm32TunnelPayloadType {
    /**
     * Registered for STorM32 gimbal controller. For communication with gimbal or camera. 
     */
    @MavlinkEntryInfo(200)
    MAV_STORM32_TUNNEL_PAYLOAD_TYPE_STORM32_CH1_IN,

    /**
     * Registered for STorM32 gimbal controller. For communication with gimbal or camera. 
     */
    @MavlinkEntryInfo(201)
    MAV_STORM32_TUNNEL_PAYLOAD_TYPE_STORM32_CH1_OUT,

    /**
     * Registered for STorM32 gimbal controller. For communication with gimbal. 
     */
    @MavlinkEntryInfo(202)
    MAV_STORM32_TUNNEL_PAYLOAD_TYPE_STORM32_CH2_IN,

    /**
     * Registered for STorM32 gimbal controller. For communication with gimbal. 
     */
    @MavlinkEntryInfo(203)
    MAV_STORM32_TUNNEL_PAYLOAD_TYPE_STORM32_CH2_OUT,

    /**
     * Registered for STorM32 gimbal controller. For communication with camera. 
     */
    @MavlinkEntryInfo(204)
    MAV_STORM32_TUNNEL_PAYLOAD_TYPE_STORM32_CH3_IN,

    /**
     * Registered for STorM32 gimbal controller. For communication with camera. 
     */
    @MavlinkEntryInfo(205)
    MAV_STORM32_TUNNEL_PAYLOAD_TYPE_STORM32_CH3_OUT
}
