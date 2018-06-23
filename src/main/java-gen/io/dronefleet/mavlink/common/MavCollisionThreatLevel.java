package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Aircraft-rated danger from this threat. 
 */
@MavlinkEnum
public enum MavCollisionThreatLevel {
    /**
     * Not a threat<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    MAV_COLLISION_THREAT_LEVEL_NONE,

    /**
     * Craft is mildly concerned about this threat<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    MAV_COLLISION_THREAT_LEVEL_LOW,

    /**
     * Craft is panicing, and may take actions to avoid threat<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    MAV_COLLISION_THREAT_LEVEL_HIGH
}
