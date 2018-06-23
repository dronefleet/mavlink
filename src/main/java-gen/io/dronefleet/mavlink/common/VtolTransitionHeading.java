package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Direction of VTOL transition 
 */
@MavlinkEnum
public enum VtolTransitionHeading {
    /**
     * Respect the heading configuration of the vehicle.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    VTOL_TRANSITION_HEADING_VEHICLE_DEFAULT,

    /**
     * Use the heading pointing towards the next waypoint.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    VTOL_TRANSITION_HEADING_NEXT_WAYPOINT,

    /**
     * Use the heading on takeoff (while sitting on the ground).<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    VTOL_TRANSITION_HEADING_TAKEOFF,

    /**
     * Use the specified heading in parameter 4.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    VTOL_TRANSITION_HEADING_SPECIFIED,

    /**
     * Use the current heading when reaching takeoff altitude (potentially facing the wind when weather-vaning is active).<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    VTOL_TRANSITION_HEADING_ANY
}
