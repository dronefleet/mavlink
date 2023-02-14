package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Enable axes that will be tuned via autotuning. Used in MAV_CMD_DO_AUTOTUNE_ENABLE. 
 */
@MavlinkEnum
public enum AutotuneAxis {
    /**
     * Flight stack tunes axis according to its default settings. 
     */
    @MavlinkEntryInfo(0)
    AUTOTUNE_AXIS_DEFAULT,

    /**
     * Autotune roll axis. 
     */
    @MavlinkEntryInfo(1)
    AUTOTUNE_AXIS_ROLL,

    /**
     * Autotune pitch axis. 
     */
    @MavlinkEntryInfo(2)
    AUTOTUNE_AXIS_PITCH,

    /**
     * Autotune yaw axis. 
     */
    @MavlinkEntryInfo(4)
    AUTOTUNE_AXIS_YAW
}
