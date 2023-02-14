package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Actuator configuration, used to change a setting on an actuator. Component information 
 * metadata can be used to know which outputs support which commands. 
 */
@MavlinkEnum
public enum ActuatorConfiguration {
    /**
     * Do nothing. 
     */
    @MavlinkEntryInfo(0)
    ACTUATOR_CONFIGURATION_NONE,

    /**
     * Command the actuator to beep now. 
     */
    @MavlinkEntryInfo(1)
    ACTUATOR_CONFIGURATION_BEEP,

    /**
     * Permanently set the actuator (ESC) to 3D mode (reversible thrust). 
     */
    @MavlinkEntryInfo(2)
    ACTUATOR_CONFIGURATION_3D_MODE_ON,

    /**
     * Permanently set the actuator (ESC) to non 3D mode (non-reversible thrust). 
     */
    @MavlinkEntryInfo(3)
    ACTUATOR_CONFIGURATION_3D_MODE_OFF,

    /**
     * Permanently set the actuator (ESC) to spin direction 1 (which can be clockwise or 
     * counter-clockwise). 
     */
    @MavlinkEntryInfo(4)
    ACTUATOR_CONFIGURATION_SPIN_DIRECTION1,

    /**
     * Permanently set the actuator (ESC) to spin direction 2 (opposite of direction 1). 
     */
    @MavlinkEntryInfo(5)
    ACTUATOR_CONFIGURATION_SPIN_DIRECTION2
}
