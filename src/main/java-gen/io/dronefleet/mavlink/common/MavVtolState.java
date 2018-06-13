package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Enumeration of VTOL states 
 */
@MavlinkEnum
public enum MavVtolState {
  /**
   * MAV is not configured as VTOL
   */
  @MavlinkEnumEntry(0)
  MAV_VTOL_STATE_UNDEFINED,

  /**
   * VTOL is in transition from multicopter to fixed-wing
   */
  @MavlinkEnumEntry(1)
  MAV_VTOL_STATE_TRANSITION_TO_FW,

  /**
   * VTOL is in transition from fixed-wing to multicopter
   */
  @MavlinkEnumEntry(2)
  MAV_VTOL_STATE_TRANSITION_TO_MC,

  /**
   * VTOL is in multicopter state
   */
  @MavlinkEnumEntry(3)
  MAV_VTOL_STATE_MC,

  /**
   * VTOL is in fixed-wing state
   */
  @MavlinkEnumEntry(4)
  MAV_VTOL_STATE_FW
}
