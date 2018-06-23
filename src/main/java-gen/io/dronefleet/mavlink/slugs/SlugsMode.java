package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Slugs-specific navigation modes. 
 */
@MavlinkEnum
public enum SlugsMode {
    /**
     * No change to SLUGS mode.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    SLUGS_MODE_NONE,

    /**
     * Vehicle is in liftoff mode.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    SLUGS_MODE_LIFTOFF,

    /**
     * Vehicle is in passthrough mode, being controlled by a pilot.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    SLUGS_MODE_PASSTHROUGH,

    /**
     * Vehicle is in waypoint mode, navigating to waypoints.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    SLUGS_MODE_WAYPOINT,

    /**
     * Vehicle is executing mid-level commands.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    SLUGS_MODE_MID_LEVEL,

    /**
     * Vehicle is returning to the home location.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(5)
    SLUGS_MODE_RETURNING,

    /**
     * Vehicle is landing.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(6)
    SLUGS_MODE_LANDING,

    /**
     * Lost connection with vehicle.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(7)
    SLUGS_MODE_LOST,

    /**
     * Vehicle is in selective passthrough mode, where selected surfaces are being manually controlled.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8)
    SLUGS_MODE_SELECTIVE_PASSTHROUGH,

    /**
     * Vehicle is in ISR mode, performing reconaissance at a point specified by ISR_LOCATION message.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(9)
    SLUGS_MODE_ISR,

    /**
     * Vehicle is patrolling along lines between waypoints.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(10)
    SLUGS_MODE_LINE_PATROL,

    /**
     * Vehicle is grounded or an error has occurred.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(11)
    SLUGS_MODE_GROUNDED
}
