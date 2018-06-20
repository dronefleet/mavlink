package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Provides state for additional features 
 */
@MavlinkMessageInfo(
    id = 245,
    crc = 130
)
public final class ExtendedSysState {
  /**
   * The VTOL state if applicable. Is set to MAV_VTOL_STATE_UNDEFINED if UAV is not in VTOL 
   * configuration. 
   */
  private final MavVtolState vtolState;

  /**
   * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown. 
   */
  private final MavLandedState landedState;

  private ExtendedSysState(MavVtolState vtolState, MavLandedState landedState) {
    this.vtolState = vtolState;
    this.landedState = landedState;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "ExtendedSysState{vtolState=" + vtolState
         + ", landedState=" + landedState + "}";
  }

  /**
   * The VTOL state if applicable. Is set to MAV_VTOL_STATE_UNDEFINED if UAV is not in VTOL 
   * configuration. 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 1
  )
  public final MavVtolState vtolState() {
    return vtolState;
  }

  /**
   * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown. 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final MavLandedState landedState() {
    return landedState;
  }

  public static class Builder {
    private MavVtolState vtolState;

    private MavLandedState landedState;

    private Builder() {
    }

    /**
     * The VTOL state if applicable. Is set to MAV_VTOL_STATE_UNDEFINED if UAV is not in VTOL 
     * configuration. 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 1
    )
    public final Builder vtolState(MavVtolState vtolState) {
      this.vtolState = vtolState;
      return this;
    }

    /**
     * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown. 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder landedState(MavLandedState landedState) {
      this.landedState = landedState;
      return this;
    }

    public final ExtendedSysState build() {
      return new ExtendedSysState(vtolState, landedState);
    }
  }
}
