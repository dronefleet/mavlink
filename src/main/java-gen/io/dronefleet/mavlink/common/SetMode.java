package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * THIS INTERFACE IS DEPRECATED. USE COMMAND_LONG with MAV_CMD_DO_SET_MODE INSTEAD. Set the 
 * system mode, as defined by enum {@link io.dronefleet.mavlink.common.MavMode MavMode}. There is no target component id as the mode is by 
 * definition for the overall aircraft, not only for one component. 
 */
@MavlinkMessage(
    id = 11,
    crc = 89
)
public final class SetMode {
  /**
   * The system setting the mode 
   */
  private final int targetSystem;

  /**
   * The new base mode 
   */
  private final MavMode baseMode;

  /**
   * The new autopilot-specific mode. This field can be ignored by an autopilot. 
   */
  private final long customMode;

  private SetMode(int targetSystem, MavMode baseMode, long customMode) {
    this.targetSystem = targetSystem;
    this.baseMode = baseMode;
    this.customMode = customMode;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * The system setting the mode 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * The new base mode 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final MavMode baseMode() {
    return baseMode;
  }

  /**
   * The new autopilot-specific mode. This field can be ignored by an autopilot. 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final long customMode() {
    return customMode;
  }

  public static class Builder {
    private int targetSystem;

    private MavMode baseMode;

    private long customMode;

    private Builder() {
    }

    /**
     * The system setting the mode 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder targetSystem(int targetSystem) {
      this.targetSystem = targetSystem;
      return this;
    }

    /**
     * The new base mode 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder baseMode(MavMode baseMode) {
      this.baseMode = baseMode;
      return this;
    }

    /**
     * The new autopilot-specific mode. This field can be ignored by an autopilot. 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder customMode(long customMode) {
      this.customMode = customMode;
      return this;
    }

    public final SetMode build() {
      return new SetMode(targetSystem, baseMode, customMode);
    }
  }
}
