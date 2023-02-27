package io.dronefleet.mavlink.minimal;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavState {
    /**
     * Uninitialized system, state is unknown. 
     */
    @MavlinkEntryInfo(0)
    MAV_STATE_UNINIT,

    /**
     * System is booting up. 
     */
    @MavlinkEntryInfo(1)
    MAV_STATE_BOOT,

    /**
     * System is calibrating and not flight-ready. 
     */
    @MavlinkEntryInfo(2)
    MAV_STATE_CALIBRATING,

    /**
     * System is grounded and on standby. It can be launched any time. 
     */
    @MavlinkEntryInfo(3)
    MAV_STATE_STANDBY,

    /**
     * System is active and might be already airborne. Motors are engaged. 
     */
    @MavlinkEntryInfo(4)
    MAV_STATE_ACTIVE,

    /**
     * System is in a non-normal flight mode. It can however still navigate. 
     */
    @MavlinkEntryInfo(5)
    MAV_STATE_CRITICAL,

    /**
     * System is in a non-normal flight mode. It lost control over parts or over the whole airframe. It 
     * is in mayday and going down. 
     */
    @MavlinkEntryInfo(6)
    MAV_STATE_EMERGENCY,

    /**
     * System just initialized its power-down sequence, will shut down now. 
     */
    @MavlinkEntryInfo(7)
    MAV_STATE_POWEROFF,

    /**
     * System is terminating itself. 
     */
    @MavlinkEntryInfo(8)
    MAV_STATE_FLIGHT_TERMINATION
}
