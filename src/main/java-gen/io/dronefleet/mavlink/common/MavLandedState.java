package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Enumeration of landed detector states 
 */
@MavlinkEnum
public enum MavLandedState {
    /**
     * MAV landed state is unknown<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    MAV_LANDED_STATE_UNDEFINED,

    /**
     * MAV is landed (on ground)<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    MAV_LANDED_STATE_ON_GROUND,

    /**
     * MAV is in air<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    MAV_LANDED_STATE_IN_AIR,

    /**
     * MAV currently taking off<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    MAV_LANDED_STATE_TAKEOFF,

    /**
     * MAV currently landing<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    MAV_LANDED_STATE_LANDING
}
