package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum LedControlPattern {
    /**
     * LED patterns off (return control to regular vehicle control) 
     */
    @MavlinkEntryInfo(0)
    LED_CONTROL_PATTERN_OFF,

    /**
     * LEDs show pattern during firmware update 
     */
    @MavlinkEntryInfo(1)
    LED_CONTROL_PATTERN_FIRMWAREUPDATE,

    /**
     * Custom Pattern using custom bytes fields 
     */
    @MavlinkEntryInfo(255)
    LED_CONTROL_PATTERN_CUSTOM
}
