package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Flags to report failure cases over the high latency telemtry. 
 */
@MavlinkEnum
public enum HlFailureFlag {
  /**
   * GPS failure.
   */
  @MavlinkEnumEntry(1)
  HL_FAILURE_FLAG_GPS,

  /**
   * Differential pressure sensor failure.
   */
  @MavlinkEnumEntry(2)
  HL_FAILURE_FLAG_DIFFERENTIAL_PRESSURE,

  /**
   * Absolute pressure sensor failure.
   */
  @MavlinkEnumEntry(4)
  HL_FAILURE_FLAG_ABSOLUTE_PRESSURE,

  /**
   * Accelerometer sensor failure.
   */
  @MavlinkEnumEntry(8)
  HL_FAILURE_FLAG_3D_ACCEL,

  /**
   * Gyroscope sensor failure.
   */
  @MavlinkEnumEntry(16)
  HL_FAILURE_FLAG_3D_GYRO,

  /**
   * Magnetometer sensor failure.
   */
  @MavlinkEnumEntry(32)
  HL_FAILURE_FLAG_3D_MAG,

  /**
   * Terrain subsystem failure.
   */
  @MavlinkEnumEntry(64)
  HL_FAILURE_FLAG_TERRAIN,

  /**
   * Battery failure/critical low battery.
   */
  @MavlinkEnumEntry(128)
  HL_FAILURE_FLAG_BATTERY,

  /**
   * RC receiver failure/no rc connection.
   */
  @MavlinkEnumEntry(256)
  HL_FAILURE_FLAG_RC_RECEIVER,

  /**
   * Offboard link failure.
   */
  @MavlinkEnumEntry(512)
  HL_FAILURE_FLAG_OFFBOARD_LINK,

  /**
   * Engine failure.
   */
  @MavlinkEnumEntry(1024)
  HL_FAILURE_FLAG_ENGINE,

  /**
   * Geofence violation.
   */
  @MavlinkEnumEntry(2048)
  HL_FAILURE_FLAG_GEOFENCE,

  /**
   * Estimator failure, for example measurement rejection or large variances.
   */
  @MavlinkEnumEntry(4096)
  HL_FAILURE_FLAG_ESTIMATOR,

  /**
   * Mission failure.
   */
  @MavlinkEnumEntry(8192)
  HL_FAILURE_FLAG_MISSION
}
