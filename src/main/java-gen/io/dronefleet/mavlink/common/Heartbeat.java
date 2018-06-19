package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.Override;
import java.lang.String;

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
  /**
   * A bitfield for use for autopilot-specific flags 
   */
  private final long customMode;

  /**
   * Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in {@link io.dronefleet.mavlink.common.MavType MavType} ENUM) 
   */
  private final MavType type;

  /**
   * Autopilot type / class. defined in {@link io.dronefleet.mavlink.common.MavAutopilot MavAutopilot} ENUM 
   */
  private final MavAutopilot autopilot;

  /**
   * System mode bitfield, as defined by {@link io.dronefleet.mavlink.common.MavModeFlag MavModeFlag} enum 
   */
  private final EnumFlagSet<MavModeFlag> baseMode;

  /**
   * System status flag, as defined by {@link io.dronefleet.mavlink.common.MavState MavState} enum 
   */
  private final MavState systemStatus;

  /**
   * MAVLink version, not writable by user, gets added by protocol because of magic data type: 
   * uint8_t_mavlink_version 
   */
  private final int mavlinkVersion;

  private Heartbeat(long customMode, MavType type, MavAutopilot autopilot,
      EnumFlagSet<MavModeFlag> baseMode, MavState systemStatus, int mavlinkVersion) {
    this.customMode = customMode;
    this.type = type;
    this.autopilot = autopilot;
    this.baseMode = baseMode;
    this.systemStatus = systemStatus;
    this.mavlinkVersion = mavlinkVersion;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "Heartbeat{type=" + type
         + ", autopilot=" + autopilot
         + ", baseMode=" + baseMode
         + ", customMode=" + customMode
         + ", systemStatus=" + systemStatus
         + ", mavlinkVersion=" + mavlinkVersion + "}";
  }

  /**
   * A bitfield for use for autopilot-specific flags 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final long customMode() {
    return customMode;
  }

  /**
   * Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in {@link io.dronefleet.mavlink.common.MavType MavType} ENUM) 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1
  )
  public final MavType type() {
    return type;
  }

  /**
   * Autopilot type / class. defined in {@link io.dronefleet.mavlink.common.MavAutopilot MavAutopilot} ENUM 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final MavAutopilot autopilot() {
    return autopilot;
  }

  /**
   * System mode bitfield, as defined by {@link io.dronefleet.mavlink.common.MavModeFlag MavModeFlag} enum 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 1
  )
  public final EnumFlagSet<MavModeFlag> baseMode() {
    return baseMode;
  }

  /**
   * System status flag, as defined by {@link io.dronefleet.mavlink.common.MavState MavState} enum 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 1
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
      unitSize = 1
  )
  public final int mavlinkVersion() {
    return mavlinkVersion;
  }

  public static class Builder {
    private long customMode;

    private MavType type;

    private MavAutopilot autopilot;

    private EnumFlagSet<MavModeFlag> baseMode;

    private MavState systemStatus;

    private int mavlinkVersion;

    private Builder() {
    }

    /**
     * A bitfield for use for autopilot-specific flags 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 4
    )
    public final Builder customMode(long customMode) {
      this.customMode = customMode;
      return this;
    }

    /**
     * Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in {@link io.dronefleet.mavlink.common.MavType MavType} ENUM) 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 1
    )
    public final Builder type(MavType type) {
      this.type = type;
      return this;
    }

    /**
     * Autopilot type / class. defined in {@link io.dronefleet.mavlink.common.MavAutopilot MavAutopilot} ENUM 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 1
    )
    public final Builder autopilot(MavAutopilot autopilot) {
      this.autopilot = autopilot;
      return this;
    }

    /**
     * System mode bitfield, as defined by {@link io.dronefleet.mavlink.common.MavModeFlag MavModeFlag} enum 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 1
    )
    public final Builder baseMode(EnumFlagSet<MavModeFlag> baseMode) {
      this.baseMode = baseMode;
      return this;
    }

    /**
     * System status flag, as defined by {@link io.dronefleet.mavlink.common.MavState MavState} enum 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 1
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
        unitSize = 1
    )
    public final Builder mavlinkVersion(int mavlinkVersion) {
      this.mavlinkVersion = mavlinkVersion;
      return this;
    }

    public final Heartbeat build() {
      return new Heartbeat(customMode, type, autopilot, baseMode, systemStatus, mavlinkVersion);
    }
  }
}
