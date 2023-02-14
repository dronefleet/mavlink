package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Winch status flags used in {@link io.dronefleet.mavlink.common.WinchStatus WINCH_STATUS} 
 */
@MavlinkEnum
public enum MavWinchStatusFlag {
    /**
     * Winch is healthy 
     */
    @MavlinkEntryInfo(1)
    MAV_WINCH_STATUS_HEALTHY,

    /**
     * Winch line is fully retracted 
     */
    @MavlinkEntryInfo(2)
    MAV_WINCH_STATUS_FULLY_RETRACTED,

    /**
     * Winch motor is moving 
     */
    @MavlinkEntryInfo(4)
    MAV_WINCH_STATUS_MOVING,

    /**
     * Winch clutch is engaged allowing motor to move freely. 
     */
    @MavlinkEntryInfo(8)
    MAV_WINCH_STATUS_CLUTCH_ENGAGED,

    /**
     * Winch is locked by locking mechanism. 
     */
    @MavlinkEntryInfo(16)
    MAV_WINCH_STATUS_LOCKED,

    /**
     * Winch is gravity dropping payload. 
     */
    @MavlinkEntryInfo(32)
    MAV_WINCH_STATUS_DROPPING,

    /**
     * Winch is arresting payload descent. 
     */
    @MavlinkEntryInfo(64)
    MAV_WINCH_STATUS_ARRESTING,

    /**
     * Winch is using torque measurements to sense the ground. 
     */
    @MavlinkEntryInfo(128)
    MAV_WINCH_STATUS_GROUND_SENSE,

    /**
     * Winch is returning to the fully retracted position. 
     */
    @MavlinkEntryInfo(256)
    MAV_WINCH_STATUS_RETRACTING,

    /**
     * Winch is redelivering the payload. This is a failover state if the line tension goes above a 
     * threshold during RETRACTING. 
     */
    @MavlinkEntryInfo(512)
    MAV_WINCH_STATUS_REDELIVER,

    /**
     * Winch is abandoning the line and possibly payload. Winch unspools the entire calculated line 
     * length. This is a failover state from REDELIVER if the number of attempts exceeds a threshold. 
     */
    @MavlinkEntryInfo(1024)
    MAV_WINCH_STATUS_ABANDON_LINE,

    /**
     * Winch is engaging the locking mechanism. 
     */
    @MavlinkEntryInfo(2048)
    MAV_WINCH_STATUS_LOCKING,

    /**
     * Winch is spooling on line. 
     */
    @MavlinkEntryInfo(4096)
    MAV_WINCH_STATUS_LOAD_LINE,

    /**
     * Winch is loading a payload. 
     */
    @MavlinkEntryInfo(8192)
    MAV_WINCH_STATUS_LOAD_PAYLOAD
}
