package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum LimitModule {
    /**
     * pre-initialization<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    LIMIT_GPSLOCK,

    /**
     * disabled<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    LIMIT_GEOFENCE,

    /**
     * checking limits<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    LIMIT_ALTITUDE
}
