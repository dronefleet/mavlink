package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum LedControlPattern {
    /**
     * LED patterns off (return control to regular vehicle control)<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    LED_CONTROL_PATTERN_OFF,

    /**
     * LEDs show pattern during firmware update<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    LED_CONTROL_PATTERN_FIRMWAREUPDATE,

    /**
     * Custom Pattern using custom bytes fields<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(255)
    LED_CONTROL_PATTERN_CUSTOM
}
