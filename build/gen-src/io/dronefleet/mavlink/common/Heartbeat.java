package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.util.EnumFlagSet;

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

  private final EnumFlagSet<MavModeFlag> baseMode;

  private final long customMode;

  private final MavState systemStatus;

  private final int mavlinkVersion;

  private Heartbeat(MavType type, MavAutopilot autopilot, EnumFlagSet<MavModeFlag> baseMode,
      long customMode, MavState systemStatus, int mavlinkVersion) {
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
   * System mode bitfield, as defined by MAV_MODE_FLAG enum 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final EnumFlagSet<MavModeFlag> baseMode() {
    return baseMode;
  }

  /**
   * A bitfield for use for autopilot-specific flags 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final long customMode() {
    return customMode;
  }

  /**
   * System status flag, as defined by MAV_STATE enum 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final MavState systemStatus() {
    return systemStatus;
  }

  /**
   * MAVLink version, not writable by user, gets added by protocol because of magic data type: 
   * uint8_t_mavlink_version 
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

    private EnumFlagSet<MavModeFlag> baseMode;

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
     * System mode bitfield, as defined by MAV_MODE_FLAG enum 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder baseMode(EnumFlagSet<MavModeFlag> baseMode) {
      this.baseMode = baseMode;
      return this;
    }

    /**
     * A bitfield for use for autopilot-specific flags 
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
     * System status flag, as defined by MAV_STATE enum 
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
     * MAVLink version, not writable by user, gets added by protocol because of magic data type: 
     * uint8_t_mavlink_version 
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
