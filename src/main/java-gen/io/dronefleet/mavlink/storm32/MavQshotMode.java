package io.dronefleet.mavlink.storm32;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Enumeration of possible shot modes. 
 */
@MavlinkEnum
public enum MavQshotMode {
    /**
     * Undefined shot mode. Can be used to determine if qshots should be used or not. 
     */
    @MavlinkEntryInfo(0)
    MAV_QSHOT_MODE_UNDEFINED,

    /**
     * Start normal gimbal operation. Is usually used to return back from a shot. 
     */
    @MavlinkEntryInfo(1)
    MAV_QSHOT_MODE_DEFAULT,

    /**
     * Load and keep safe gimbal position and stop stabilization. 
     */
    @MavlinkEntryInfo(2)
    MAV_QSHOT_MODE_GIMBAL_RETRACT,

    /**
     * Load neutral gimbal position and keep it while stabilizing. 
     */
    @MavlinkEntryInfo(3)
    MAV_QSHOT_MODE_GIMBAL_NEUTRAL,

    /**
     * Start mission with gimbal control. 
     */
    @MavlinkEntryInfo(4)
    MAV_QSHOT_MODE_GIMBAL_MISSION,

    /**
     * Start RC gimbal control. 
     */
    @MavlinkEntryInfo(5)
    MAV_QSHOT_MODE_GIMBAL_RC_CONTROL,

    /**
     * Start gimbal tracking the point specified by Lat, Lon, Alt. 
     */
    @MavlinkEntryInfo(6)
    MAV_QSHOT_MODE_POI_TARGETING,

    /**
     * Start gimbal tracking the system with specified system ID. 
     */
    @MavlinkEntryInfo(7)
    MAV_QSHOT_MODE_SYSID_TARGETING,

    /**
     * Start 2-point cable cam quick shot. 
     */
    @MavlinkEntryInfo(8)
    MAV_QSHOT_MODE_CABLECAM_2POINT,

    /**
     * Start gimbal tracking the home location. 
     */
    @MavlinkEntryInfo(9)
    MAV_QSHOT_MODE_HOME_TARGETING
}
