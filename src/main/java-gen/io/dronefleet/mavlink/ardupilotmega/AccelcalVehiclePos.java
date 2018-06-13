package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum AccelcalVehiclePos {
  /**
   * null
   */
  @MavlinkEnumEntry(1)
  ACCELCAL_VEHICLE_POS_LEVEL,

  /**
   * null
   */
  @MavlinkEnumEntry(2)
  ACCELCAL_VEHICLE_POS_LEFT,

  /**
   * null
   */
  @MavlinkEnumEntry(3)
  ACCELCAL_VEHICLE_POS_RIGHT,

  /**
   * null
   */
  @MavlinkEnumEntry(4)
  ACCELCAL_VEHICLE_POS_NOSEDOWN,

  /**
   * null
   */
  @MavlinkEnumEntry(5)
  ACCELCAL_VEHICLE_POS_NOSEUP,

  /**
   * null
   */
  @MavlinkEnumEntry(6)
  ACCELCAL_VEHICLE_POS_BACK,

  /**
   * null
   */
  @MavlinkEnumEntry(16777215)
  ACCELCAL_VEHICLE_POS_SUCCESS,

  /**
   * null
   */
  @MavlinkEnumEntry(16777216)
  ACCELCAL_VEHICLE_POS_FAILED
}
