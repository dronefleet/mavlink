package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Enumeration of VTOL states 
 */
@MavlinkEnum
public enum MavVtolState {
    /**
     * MAV is not configured as VTOL 
     */
    @MavlinkEntryInfo(0)
    MAV_VTOL_STATE_UNDEFINED,

    /**
     * VTOL is in transition from multicopter to fixed-wing 
     */
    @MavlinkEntryInfo(1)
    MAV_VTOL_STATE_TRANSITION_TO_FW,

    /**
     * VTOL is in transition from fixed-wing to multicopter 
     */
    @MavlinkEntryInfo(2)
    MAV_VTOL_STATE_TRANSITION_TO_MC,

    /**
     * VTOL is in multicopter state 
     */
    @MavlinkEntryInfo(3)
    MAV_VTOL_STATE_MC,

    /**
     * VTOL is in fixed-wing state 
     */
    @MavlinkEntryInfo(4)
    MAV_VTOL_STATE_FW
}
