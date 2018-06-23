package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum ParachuteAction {
    /**
     * Disable parachute release<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    PARACHUTE_DISABLE,

    /**
     * Enable parachute release<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    PARACHUTE_ENABLE,

    /**
     * Release parachute<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    PARACHUTE_RELEASE
}
