package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Enumeration of landed detector states 
 */
@MavlinkEnum
public enum MavLandedState {
  /**
   * MAV landed state is unknown
   */
  @MavlinkEnumEntry(0)
  MAV_LANDED_STATE_UNDEFINED,

  /**
   * MAV is landed (on ground)
   */
  @MavlinkEnumEntry(1)
  MAV_LANDED_STATE_ON_GROUND,

  /**
   * MAV is in air
   */
  @MavlinkEnumEntry(2)
  MAV_LANDED_STATE_IN_AIR,

  /**
   * MAV currently taking off
   */
  @MavlinkEnumEntry(3)
  MAV_LANDED_STATE_TAKEOFF,

  /**
   * MAV currently landing
   */
  @MavlinkEnumEntry(4)
  MAV_LANDED_STATE_LANDING
}
