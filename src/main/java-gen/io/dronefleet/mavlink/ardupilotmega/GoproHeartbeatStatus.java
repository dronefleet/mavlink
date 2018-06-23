package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum GoproHeartbeatStatus {
    /**
     * No GoPro connected<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    GOPRO_HEARTBEAT_STATUS_DISCONNECTED,

    /**
     * The detected GoPro is not HeroBus compatible<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    GOPRO_HEARTBEAT_STATUS_INCOMPATIBLE,

    /**
     * A HeroBus compatible GoPro is connected<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    GOPRO_HEARTBEAT_STATUS_CONNECTED,

    /**
     * An unrecoverable error was encountered with the connected GoPro, it may require a power cycle<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    GOPRO_HEARTBEAT_STATUS_ERROR
}
