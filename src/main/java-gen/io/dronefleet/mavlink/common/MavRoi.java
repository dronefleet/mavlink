package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;
import java.lang.Deprecated;

/**
 * The ROI (region of interest) for the vehicle. This can be be used by the vehicle for 
 * camera/vehicle attitude alignment (see MAV_CMD_NAV_ROI). 
 * @deprecated Since 2018-01, replaced by MAV_CMD_DO_SET_ROI_*. 
 */
@MavlinkEnum
@Deprecated
public enum MavRoi {
    /**
     * No region of interest. 
     */
    @MavlinkEntryInfo(0)
    MAV_ROI_NONE,

    /**
     * Point toward next waypoint, with optional pitch/roll/yaw offset. 
     */
    @MavlinkEntryInfo(1)
    MAV_ROI_WPNEXT,

    /**
     * Point toward given waypoint. 
     */
    @MavlinkEntryInfo(2)
    MAV_ROI_WPINDEX,

    /**
     * Point toward fixed location. 
     */
    @MavlinkEntryInfo(3)
    MAV_ROI_LOCATION,

    /**
     * Point toward of given id. 
     */
    @MavlinkEntryInfo(4)
    MAV_ROI_TARGET
}
