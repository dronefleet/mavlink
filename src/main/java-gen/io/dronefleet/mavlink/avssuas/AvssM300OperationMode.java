package io.dronefleet.mavlink.avssuas;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum AvssM300OperationMode {
    /**
     * In manual control mode 
     */
    @MavlinkEntryInfo(0)
    MODE_M300_MANUAL_CTRL,

    /**
     * In attitude mode 
     */
    @MavlinkEntryInfo(1)
    MODE_M300_ATTITUDE,

    /**
     * In GPS mode 
     */
    @MavlinkEntryInfo(6)
    MODE_M300_P_GPS,

    /**
     * In hotpoint mode 
     */
    @MavlinkEntryInfo(9)
    MODE_M300_HOTPOINT_MODE,

    /**
     * In assisted takeoff mode 
     */
    @MavlinkEntryInfo(10)
    MODE_M300_ASSISTED_TAKEOFF,

    /**
     * In auto takeoff mode 
     */
    @MavlinkEntryInfo(11)
    MODE_M300_AUTO_TAKEOFF,

    /**
     * In auto landing mode 
     */
    @MavlinkEntryInfo(12)
    MODE_M300_AUTO_LANDING,

    /**
     * In go home mode 
     */
    @MavlinkEntryInfo(15)
    MODE_M300_NAVI_GO_HOME,

    /**
     * In sdk control mode 
     */
    @MavlinkEntryInfo(17)
    MODE_M300_NAVI_SDK_CTRL,

    /**
     * In sport mode 
     */
    @MavlinkEntryInfo(31)
    MODE_M300_S_SPORT,

    /**
     * In force auto landing mode 
     */
    @MavlinkEntryInfo(33)
    MODE_M300_FORCE_AUTO_LANDING,

    /**
     * In tripod mode 
     */
    @MavlinkEntryInfo(38)
    MODE_M300_T_TRIPOD,

    /**
     * In search mode 
     */
    @MavlinkEntryInfo(40)
    MODE_M300_SEARCH_MODE,

    /**
     * In engine mode 
     */
    @MavlinkEntryInfo(41)
    MODE_M300_ENGINE_START
}
