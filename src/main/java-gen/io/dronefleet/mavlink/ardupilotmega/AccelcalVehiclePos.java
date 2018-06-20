package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum AccelcalVehiclePos {
  /**
   * null
   */
  @MavlinkEntryInfo(1)
  ACCELCAL_VEHICLE_POS_LEVEL,

  /**
   * null
   */
  @MavlinkEntryInfo(2)
  ACCELCAL_VEHICLE_POS_LEFT,

  /**
   * null
   */
  @MavlinkEntryInfo(3)
  ACCELCAL_VEHICLE_POS_RIGHT,

  /**
   * null
   */
  @MavlinkEntryInfo(4)
  ACCELCAL_VEHICLE_POS_NOSEDOWN,

  /**
   * null
   */
  @MavlinkEntryInfo(5)
  ACCELCAL_VEHICLE_POS_NOSEUP,

  /**
   * null
   */
  @MavlinkEntryInfo(6)
  ACCELCAL_VEHICLE_POS_BACK,

  /**
   * null
   */
  @MavlinkEntryInfo(16777215)
  ACCELCAL_VEHICLE_POS_SUCCESS,

  /**
   * null
   */
  @MavlinkEntryInfo(16777216)
  ACCELCAL_VEHICLE_POS_FAILED
}
