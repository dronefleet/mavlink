package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum GoproHeartbeatFlags {
    /**
     * GoPro is currently recording<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    GOPRO_FLAG_RECORDING
}
