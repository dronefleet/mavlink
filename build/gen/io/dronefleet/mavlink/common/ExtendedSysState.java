package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Provides state for additional features 
 */
@MavlinkMessage(
    id = 245,
    crc = 130
)
public final class ExtendedSysState {
  private final MavVtolState vtolState;

  private final MavLandedState landedState;

  private ExtendedSysState(MavVtolState vtolState, MavLandedState landedState) {
    this.vtolState = vtolState;
    this.landedState = landedState;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * The VTOL state if applicable. Is set to MAV_VTOL_STATE_UNDEFINED if UAV is not in VTOL 
   * configuration. 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final MavVtolState vtolState() {
    return vtolState;
  }

  /**
   * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown. 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final MavLandedState landedState() {
    return landedState;
  }

  public class Builder {
    private MavVtolState vtolState;

    private MavLandedState landedState;

    private Builder() {
    }

    /**
     * The VTOL state if applicable. Is set to MAV_VTOL_STATE_UNDEFINED if UAV is not in VTOL 
     * configuration. 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder vtolState(MavVtolState vtolState) {
      this.vtolState = vtolState;
      return this;
    }

    /**
     * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown. 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
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
