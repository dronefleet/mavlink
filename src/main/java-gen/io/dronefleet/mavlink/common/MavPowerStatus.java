package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Power supply status flags (bitmask) 
 */
@MavlinkEnum
public enum MavPowerStatus {
    /**
     * main brick power supply valid<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    MAV_POWER_STATUS_BRICK_VALID,

    /**
     * main servo power supply valid for FMU<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    MAV_POWER_STATUS_SERVO_VALID,

    /**
     * USB power is connected<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    MAV_POWER_STATUS_USB_CONNECTED,

    /**
     * peripheral supply is in over-current state<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8)
    MAV_POWER_STATUS_PERIPH_OVERCURRENT,

    /**
     * hi-power peripheral supply is in over-current state<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16)
    MAV_POWER_STATUS_PERIPH_HIPOWER_OVERCURRENT,

    /**
     * Power status has changed since boot<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(32)
    MAV_POWER_STATUS_CHANGED
}
