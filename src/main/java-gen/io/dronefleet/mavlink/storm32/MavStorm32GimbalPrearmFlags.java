package io.dronefleet.mavlink.storm32;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * STorM32 gimbal prearm check flags. 
 */
@MavlinkEnum
public enum MavStorm32GimbalPrearmFlags {
    /**
     * STorM32 gimbal is in normal state. 
     */
    @MavlinkEntryInfo(1)
    MAV_STORM32_GIMBAL_PREARM_FLAGS_IS_NORMAL,

    /**
     * The IMUs are healthy and working normally. 
     */
    @MavlinkEntryInfo(2)
    MAV_STORM32_GIMBAL_PREARM_FLAGS_IMUS_WORKING,

    /**
     * The motors are active and working normally. 
     */
    @MavlinkEntryInfo(4)
    MAV_STORM32_GIMBAL_PREARM_FLAGS_MOTORS_WORKING,

    /**
     * The encoders are healthy and working normally. 
     */
    @MavlinkEntryInfo(8)
    MAV_STORM32_GIMBAL_PREARM_FLAGS_ENCODERS_WORKING,

    /**
     * A battery voltage is applied and is in range. 
     */
    @MavlinkEntryInfo(16)
    MAV_STORM32_GIMBAL_PREARM_FLAGS_VOLTAGE_OK,

    /**
     * Virtual input channels are receiving data. 
     */
    @MavlinkEntryInfo(32)
    MAV_STORM32_GIMBAL_PREARM_FLAGS_VIRTUALCHANNELS_RECEIVING,

    /**
     * Mavlink messages are being received. 
     */
    @MavlinkEntryInfo(64)
    MAV_STORM32_GIMBAL_PREARM_FLAGS_MAVLINK_RECEIVING,

    /**
     * The STorM32Link data indicates QFix. 
     */
    @MavlinkEntryInfo(128)
    MAV_STORM32_GIMBAL_PREARM_FLAGS_STORM32LINK_QFIX,

    /**
     * The STorM32Link is working. 
     */
    @MavlinkEntryInfo(256)
    MAV_STORM32_GIMBAL_PREARM_FLAGS_STORM32LINK_WORKING,

    /**
     * The camera has been found and is connected. 
     */
    @MavlinkEntryInfo(512)
    MAV_STORM32_GIMBAL_PREARM_FLAGS_CAMERA_CONNECTED,

    /**
     * The signal on the AUX0 input pin is low. 
     */
    @MavlinkEntryInfo(1024)
    MAV_STORM32_GIMBAL_PREARM_FLAGS_AUX0_LOW,

    /**
     * The signal on the AUX1 input pin is low. 
     */
    @MavlinkEntryInfo(2048)
    MAV_STORM32_GIMBAL_PREARM_FLAGS_AUX1_LOW,

    /**
     * The NTLogger is working normally. 
     */
    @MavlinkEntryInfo(4096)
    MAV_STORM32_GIMBAL_PREARM_FLAGS_NTLOGGER_WORKING
}
