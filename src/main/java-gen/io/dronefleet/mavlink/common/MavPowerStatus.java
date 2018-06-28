package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Power supply status flags (bitmask) 
 */
@MavlinkEnum
public enum MavPowerStatus {
    /**
     * main brick power supply valid 
     */
    @MavlinkEntryInfo(1)
    MAV_POWER_STATUS_BRICK_VALID,

    /**
     * main servo power supply valid for FMU 
     */
    @MavlinkEntryInfo(2)
    MAV_POWER_STATUS_SERVO_VALID,

    /**
     * USB power is connected 
     */
    @MavlinkEntryInfo(4)
    MAV_POWER_STATUS_USB_CONNECTED,

    /**
     * peripheral supply is in over-current state 
     */
    @MavlinkEntryInfo(8)
    MAV_POWER_STATUS_PERIPH_OVERCURRENT,

    /**
     * hi-power peripheral supply is in over-current state 
     */
    @MavlinkEntryInfo(16)
    MAV_POWER_STATUS_PERIPH_HIPOWER_OVERCURRENT,

    /**
     * Power status has changed since boot 
     */
    @MavlinkEntryInfo(32)
    MAV_POWER_STATUS_CHANGED
}
