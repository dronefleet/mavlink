package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum NavVtolLandOptions {
    /**
     * Default autopilot landing behaviour. 
     */
    @MavlinkEntryInfo(0)
    NAV_VTOL_LAND_OPTIONS_DEFAULT,

    /**
     * Descend in fixed wing mode, transitioning to multicopter mode for vertical landing when close 
     * to the ground. The fixed wing descent pattern is at the discretion of the vehicle (e.g. 
     * transition altitude, loiter direction, radius, and speed, etc.). 
     */
    @MavlinkEntryInfo(1)
    NAV_VTOL_LAND_OPTIONS_FW_DESCENT,

    /**
     * Land in multicopter mode on reaching the landing coordinates (the whole landing is by "hover 
     * descent"). 
     */
    @MavlinkEntryInfo(2)
    NAV_VTOL_LAND_OPTIONS_HOVER_DESCENT
}
