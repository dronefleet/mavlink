package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

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
  @MavlinkEnumEntry(128)
  CONTROL_SURFACE_FLAG_THROTTLE,

  /**
   * 0b01000000 Left aileron control passes through to pilot console.
   */
  @MavlinkEnumEntry(64)
  CONTROL_SURFACE_FLAG_LEFT_AILERON,

  /**
   * 0b00100000 Right aileron control passes through to pilot console.
   */
  @MavlinkEnumEntry(32)
  CONTROL_SURFACE_FLAG_RIGHT_AILERON,

  /**
   * 0b00010000 Rudder control passes through to pilot console.
   */
  @MavlinkEnumEntry(16)
  CONTROL_SURFACE_FLAG_RUDDER,

  /**
   * 0b00001000 Left elevator control passes through to pilot console.
   */
  @MavlinkEnumEntry(8)
  CONTROL_SURFACE_FLAG_LEFT_ELEVATOR,

  /**
   * 0b00000100 Right elevator control passes through to pilot console.
   */
  @MavlinkEnumEntry(4)
  CONTROL_SURFACE_FLAG_RIGHT_ELEVATOR,

  /**
   * 0b00000010 Left flap control passes through to pilot console.
   */
  @MavlinkEnumEntry(2)
  CONTROL_SURFACE_FLAG_LEFT_FLAP,

  /**
   * 0b00000001 Right flap control passes through to pilot console.
   */
  @MavlinkEnumEntry(1)
  CONTROL_SURFACE_FLAG_RIGHT_FLAP
}
