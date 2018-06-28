package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Slugs-specific navigation modes. 
 */
@MavlinkEnum
public enum SlugsMode {
    /**
     * No change to SLUGS mode. 
     */
    @MavlinkEntryInfo(0)
    SLUGS_MODE_NONE,

    /**
     * Vehicle is in liftoff mode. 
     */
    @MavlinkEntryInfo(1)
    SLUGS_MODE_LIFTOFF,

    /**
     * Vehicle is in passthrough mode, being controlled by a pilot. 
     */
    @MavlinkEntryInfo(2)
    SLUGS_MODE_PASSTHROUGH,

    /**
     * Vehicle is in waypoint mode, navigating to waypoints. 
     */
    @MavlinkEntryInfo(3)
    SLUGS_MODE_WAYPOINT,

    /**
     * Vehicle is executing mid-level commands. 
     */
    @MavlinkEntryInfo(4)
    SLUGS_MODE_MID_LEVEL,

    /**
     * Vehicle is returning to the home location. 
     */
    @MavlinkEntryInfo(5)
    SLUGS_MODE_RETURNING,

    /**
     * Vehicle is landing. 
     */
    @MavlinkEntryInfo(6)
    SLUGS_MODE_LANDING,

    /**
     * Lost connection with vehicle. 
     */
    @MavlinkEntryInfo(7)
    SLUGS_MODE_LOST,

    /**
     * Vehicle is in selective passthrough mode, where selected surfaces are being manually 
     * controlled. 
     */
    @MavlinkEntryInfo(8)
    SLUGS_MODE_SELECTIVE_PASSTHROUGH,

    /**
     * Vehicle is in ISR mode, performing reconaissance at a point specified by {@link io.dronefleet.mavlink.slugs.IsrLocation ISR_LOCATION} 
     * message. 
     */
    @MavlinkEntryInfo(9)
    SLUGS_MODE_ISR,

    /**
     * Vehicle is patrolling along lines between waypoints. 
     */
    @MavlinkEntryInfo(10)
    SLUGS_MODE_LINE_PATROL,

    /**
     * Vehicle is grounded or an error has occurred. 
     */
    @MavlinkEntryInfo(11)
    SLUGS_MODE_GROUNDED
}
