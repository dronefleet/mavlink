package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum FenceBreach {
    /**
     * No last fence breach<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    FENCE_BREACH_NONE,

    /**
     * Breached minimum altitude<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    FENCE_BREACH_MINALT,

    /**
     * Breached maximum altitude<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    FENCE_BREACH_MAXALT,

    /**
     * Breached fence boundary<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    FENCE_BREACH_BOUNDARY
}
