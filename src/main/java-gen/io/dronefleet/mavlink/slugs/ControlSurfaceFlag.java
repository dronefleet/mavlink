package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * These flags encode the control surfaces for selective passthrough mode. If a bit is set then the 
 * pilot console has control of the surface, and if not then the autopilot has control of the 
 * surface. 
 */
@MavlinkEnum
public enum ControlSurfaceFlag {
    /**
     * 0b10000000 Throttle control passes through to pilot console. 
     */
    @MavlinkEntryInfo(128)
    CONTROL_SURFACE_FLAG_THROTTLE,

    /**
     * 0b01000000 Left aileron control passes through to pilot console. 
     */
    @MavlinkEntryInfo(64)
    CONTROL_SURFACE_FLAG_LEFT_AILERON,

    /**
     * 0b00100000 Right aileron control passes through to pilot console. 
     */
    @MavlinkEntryInfo(32)
    CONTROL_SURFACE_FLAG_RIGHT_AILERON,

    /**
     * 0b00010000 Rudder control passes through to pilot console. 
     */
    @MavlinkEntryInfo(16)
    CONTROL_SURFACE_FLAG_RUDDER,

    /**
     * 0b00001000 Left elevator control passes through to pilot console. 
     */
    @MavlinkEntryInfo(8)
    CONTROL_SURFACE_FLAG_LEFT_ELEVATOR,

    /**
     * 0b00000100 Right elevator control passes through to pilot console. 
     */
    @MavlinkEntryInfo(4)
    CONTROL_SURFACE_FLAG_RIGHT_ELEVATOR,

    /**
     * 0b00000010 Left flap control passes through to pilot console. 
     */
    @MavlinkEntryInfo(2)
    CONTROL_SURFACE_FLAG_LEFT_FLAP,

    /**
     * 0b00000001 Right flap control passes through to pilot console. 
     */
    @MavlinkEntryInfo(1)
    CONTROL_SURFACE_FLAG_RIGHT_FLAP
}
