package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * These encode the sensors whose status is sent as part of the {@link io.dronefleet.mavlink.common.SysStatus SYS_STATUS} message in the extended 
 * fields. 
 */
@MavlinkEnum
public enum MavSysStatusSensorExtended {
    /**
     * 0x01 Recovery system (parachute, balloon, retracts etc) 
     */
    @MavlinkEntryInfo(1)
    MAV_SYS_STATUS_RECOVERY_SYSTEM
}
