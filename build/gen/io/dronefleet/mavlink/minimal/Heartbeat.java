package io.dronefleet.mavlink.minimal;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * The heartbeat message shows that a system is present and responding. The type of the MAV and 
 * Autopilot hardware allow the receiving system to treat further messages from this system 
 * appropriate (e.g. by laying out the user interface based on the autopilot). 
 */
@MavlinkMessage(
    id = 0,
    crc = 50
)
public final class Heartbeat {
  private final MavType type;

  private final MavAutopilot autopilot;

  private final int baseMode;

  private final long customMode;

  private final MavState systemStatus;

  private final int mavlinkVersion;

  private Heartbeat(MavType type, MavAutopilot autopilot, int baseMode, long customMode,
      MavState systemStatus, int mavlinkVersion) {
    this.type = type;
    this.autopilot = autopilot;
    this.baseMode = baseMode;
    this.customMode = customMode;
    this.systemStatus = systemStatus;
    this.mavlinkVersion = mavlinkVersion;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in MAV_TYPE ENUM) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final MavType type() {
    return type;
  }

  /**
   * Autopilot type / class. defined in MAV_AUTOPILOT ENUM 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final MavAutopilot autopilot() {
    return autopilot;
  }

  /**
   * System mode bitfield, see MAV_MODE_FLAGS ENUM in mavlink/include/mavlink_types.h 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int baseMode() {
    return baseMode;
  }

  /**
   * A bitfield for use for autopilot-specific flags. 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final long customMode() {
    return customMode;
  }

  /**
   * System status flag, see MAV_STATE ENUM 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final MavState systemStatus() {
    return systemStatus;
  }

  /**
   * MAVLink version 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1
  )
  public final int mavlinkVersion() {
    return mavlinkVersion;
  }

  public class Builder {
    private MavType type;

    private MavAutopilot autopilot;

    private int baseMode;

    private long customMode;

    private MavState systemStatus;

    private int mavlinkVersion;

    private Builder() {
    }

    /**
     * Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in MAV_TYPE ENUM) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder type(MavType type) {
      this.type = type;
      return this;
    }

    /**
     * Autopilot type / class. defined in MAV_AUTOPILOT ENUM 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder autopilot(MavAutopilot autopilot) {
      this.autopilot = autopilot;
      return this;
    }

    /**
     * System mode bitfield, see MAV_MODE_FLAGS ENUM in mavlink/include/mavlink_types.h 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder baseMode(int baseMode) {
      this.baseMode = baseMode;
      return this;
    }

    /**
     * A bitfield for use for autopilot-specific flags. 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder customMode(long customMode) {
      this.customMode = customMode;
      return this;
    }

    /**
     * System status flag, see MAV_STATE ENUM 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder systemStatus(MavState systemStatus) {
      this.systemStatus = systemStatus;
      return this;
    }

    /**
     * MAVLink version 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1
    )
    public final Builder mavlinkVersion(int mavlinkVersion) {
      this.mavlinkVersion = mavlinkVersion;
      return this;
    }

    public final Heartbeat build() {
      return new Heartbeat(type, autopilot, baseMode, customMode, systemStatus, mavlinkVersion);
    }
  }
}
