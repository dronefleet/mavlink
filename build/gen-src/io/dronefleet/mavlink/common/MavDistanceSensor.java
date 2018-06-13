package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Enumeration of distance sensor types 
 */
@MavlinkEnum
public enum MavDistanceSensor {
  /**
   * Laser rangefinder, e.g. LightWare SF02/F or PulsedLight units
   */
  @MavlinkEnumEntry(0)
  MAV_DISTANCE_SENSOR_LASER,

  /**
   * Ultrasound rangefinder, e.g. MaxBotix units
   */
  @MavlinkEnumEntry(1)
  MAV_DISTANCE_SENSOR_ULTRASOUND,

  /**
   * Infrared rangefinder, e.g. Sharp units
   */
  @MavlinkEnumEntry(2)
  MAV_DISTANCE_SENSOR_INFRARED,

  /**
   * Radar type, e.g. uLanding units
   */
  @MavlinkEnumEntry(3)
  MAV_DISTANCE_SENSOR_RADAR,

  /**
   * Broken or unknown type, e.g. analog units
   */
  @MavlinkEnumEntry(4)
  MAV_DISTANCE_SENSOR_UNKNOWN
}
