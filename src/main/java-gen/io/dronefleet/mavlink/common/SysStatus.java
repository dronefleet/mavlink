package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.Override;
import java.lang.String;

/**
 * The general system state. If the system is following the MAVLink standard, the system state is 
 * mainly defined by three orthogonal states/modes: The system mode, which is either LOCKED 
 * (motors shut down and locked), MANUAL (system under RC control), GUIDED (system with 
 * autonomous position control, position setpoint controlled manually) or AUTO (system guided 
 * by path/waypoint planner). The NAV_MODE defined the current flight state: LIFTOFF (often an 
 * open-loop maneuver), LANDING, WAYPOINTS or VECTOR. This represents the internal navigation 
 * state machine. The system status shows whether the system is currently active or not and if an 
 * emergency occured. During the CRITICAL and EMERGENCY states the MAV is still considered to be 
 * active, but should start emergency procedures autonomously. After a failure occured it 
 * should first move from active to critical to allow manual intervention and then move to 
 * emergency after a certain timeout. 
 */
@MavlinkMessage(
    id = 1,
    crc = 124
)
public final class SysStatus {
  /**
   * Bitmask showing which onboard controllers and sensors are present. Value of 0: not present. 
   * Value of 1: present. Indices defined by ENUM {@link io.dronefleet.mavlink.common.MavSysStatusSensor MavSysStatusSensor} 
   */
  private final EnumFlagSet<MavSysStatusSensor> onboardControlSensorsPresent;

  /**
   * Bitmask showing which onboard controllers and sensors are enabled: Value of 0: not enabled. 
   * Value of 1: enabled. Indices defined by ENUM {@link io.dronefleet.mavlink.common.MavSysStatusSensor MavSysStatusSensor} 
   */
  private final EnumFlagSet<MavSysStatusSensor> onboardControlSensorsEnabled;

  /**
   * Bitmask showing which onboard controllers and sensors are operational or have an error: Value 
   * of 0: not enabled. Value of 1: enabled. Indices defined by ENUM {@link io.dronefleet.mavlink.common.MavSysStatusSensor MavSysStatusSensor} 
   */
  private final EnumFlagSet<MavSysStatusSensor> onboardControlSensorsHealth;

  /**
   * Maximum usage in percent of the mainloop time, (0%: 0, 100%: 1000) should be always below 1000 
   */
  private final int load;

  /**
   * Battery voltage, in millivolts (1 = 1 millivolt) 
   */
  private final int voltageBattery;

  /**
   * Battery current, in 10*milliamperes (1 = 10 milliampere), -1: autopilot does not measure the 
   * current 
   */
  private final int currentBattery;

  /**
   * Communication drops in percent, (0%: 0, 100%: 10'000), (UART, I2C, SPI, CAN), dropped packets 
   * on all links (packets that were corrupted on reception on the MAV) 
   */
  private final int dropRateComm;

  /**
   * Communication errors (UART, I2C, SPI, CAN), dropped packets on all links (packets that were 
   * corrupted on reception on the MAV) 
   */
  private final int errorsComm;

  /**
   * Autopilot-specific errors 
   */
  private final int errorsCount1;

  /**
   * Autopilot-specific errors 
   */
  private final int errorsCount2;

  /**
   * Autopilot-specific errors 
   */
  private final int errorsCount3;

  /**
   * Autopilot-specific errors 
   */
  private final int errorsCount4;

  /**
   * Remaining battery energy: (0%: 0, 100%: 100), -1: autopilot estimate the remaining battery 
   */
  private final int batteryRemaining;

  private SysStatus(EnumFlagSet<MavSysStatusSensor> onboardControlSensorsPresent,
      EnumFlagSet<MavSysStatusSensor> onboardControlSensorsEnabled,
      EnumFlagSet<MavSysStatusSensor> onboardControlSensorsHealth, int load, int voltageBattery,
      int currentBattery, int dropRateComm, int errorsComm, int errorsCount1, int errorsCount2,
      int errorsCount3, int errorsCount4, int batteryRemaining) {
    this.onboardControlSensorsPresent = onboardControlSensorsPresent;
    this.onboardControlSensorsEnabled = onboardControlSensorsEnabled;
    this.onboardControlSensorsHealth = onboardControlSensorsHealth;
    this.load = load;
    this.voltageBattery = voltageBattery;
    this.currentBattery = currentBattery;
    this.dropRateComm = dropRateComm;
    this.errorsComm = errorsComm;
    this.errorsCount1 = errorsCount1;
    this.errorsCount2 = errorsCount2;
    this.errorsCount3 = errorsCount3;
    this.errorsCount4 = errorsCount4;
    this.batteryRemaining = batteryRemaining;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "SysStatus{onboardControlSensorsPresent=" + onboardControlSensorsPresent
         + ", onboardControlSensorsEnabled=" + onboardControlSensorsEnabled
         + ", onboardControlSensorsHealth=" + onboardControlSensorsHealth
         + ", load=" + load
         + ", voltageBattery=" + voltageBattery
         + ", currentBattery=" + currentBattery
         + ", batteryRemaining=" + batteryRemaining
         + ", dropRateComm=" + dropRateComm
         + ", errorsComm=" + errorsComm
         + ", errorsCount1=" + errorsCount1
         + ", errorsCount2=" + errorsCount2
         + ", errorsCount3=" + errorsCount3
         + ", errorsCount4=" + errorsCount4 + "}";
  }

  /**
   * Bitmask showing which onboard controllers and sensors are present. Value of 0: not present. 
   * Value of 1: present. Indices defined by ENUM {@link io.dronefleet.mavlink.common.MavSysStatusSensor MavSysStatusSensor} 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 4
  )
  public final EnumFlagSet<MavSysStatusSensor> onboardControlSensorsPresent() {
    return onboardControlSensorsPresent;
  }

  /**
   * Bitmask showing which onboard controllers and sensors are enabled: Value of 0: not enabled. 
   * Value of 1: enabled. Indices defined by ENUM {@link io.dronefleet.mavlink.common.MavSysStatusSensor MavSysStatusSensor} 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final EnumFlagSet<MavSysStatusSensor> onboardControlSensorsEnabled() {
    return onboardControlSensorsEnabled;
  }

  /**
   * Bitmask showing which onboard controllers and sensors are operational or have an error: Value 
   * of 0: not enabled. Value of 1: enabled. Indices defined by ENUM {@link io.dronefleet.mavlink.common.MavSysStatusSensor MavSysStatusSensor} 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final EnumFlagSet<MavSysStatusSensor> onboardControlSensorsHealth() {
    return onboardControlSensorsHealth;
  }

  /**
   * Maximum usage in percent of the mainloop time, (0%: 0, 100%: 1000) should be always below 1000 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 2
  )
  public final int load() {
    return load;
  }

  /**
   * Battery voltage, in millivolts (1 = 1 millivolt) 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 2
  )
  public final int voltageBattery() {
    return voltageBattery;
  }

  /**
   * Battery current, in 10*milliamperes (1 = 10 milliampere), -1: autopilot does not measure the 
   * current 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 2
  )
  public final int currentBattery() {
    return currentBattery;
  }

  /**
   * Communication drops in percent, (0%: 0, 100%: 10'000), (UART, I2C, SPI, CAN), dropped packets 
   * on all links (packets that were corrupted on reception on the MAV) 
   */
  @MavlinkMessageField(
      position = 8,
      unitSize = 2
  )
  public final int dropRateComm() {
    return dropRateComm;
  }

  /**
   * Communication errors (UART, I2C, SPI, CAN), dropped packets on all links (packets that were 
   * corrupted on reception on the MAV) 
   */
  @MavlinkMessageField(
      position = 9,
      unitSize = 2
  )
  public final int errorsComm() {
    return errorsComm;
  }

  /**
   * Autopilot-specific errors 
   */
  @MavlinkMessageField(
      position = 10,
      unitSize = 2
  )
  public final int errorsCount1() {
    return errorsCount1;
  }

  /**
   * Autopilot-specific errors 
   */
  @MavlinkMessageField(
      position = 11,
      unitSize = 2
  )
  public final int errorsCount2() {
    return errorsCount2;
  }

  /**
   * Autopilot-specific errors 
   */
  @MavlinkMessageField(
      position = 12,
      unitSize = 2
  )
  public final int errorsCount3() {
    return errorsCount3;
  }

  /**
   * Autopilot-specific errors 
   */
  @MavlinkMessageField(
      position = 13,
      unitSize = 2
  )
  public final int errorsCount4() {
    return errorsCount4;
  }

  /**
   * Remaining battery energy: (0%: 0, 100%: 100), -1: autopilot estimate the remaining battery 
   */
  @MavlinkMessageField(
      position = 7,
      unitSize = 1
  )
  public final int batteryRemaining() {
    return batteryRemaining;
  }

  public static class Builder {
    private EnumFlagSet<MavSysStatusSensor> onboardControlSensorsPresent;

    private EnumFlagSet<MavSysStatusSensor> onboardControlSensorsEnabled;

    private EnumFlagSet<MavSysStatusSensor> onboardControlSensorsHealth;

    private int load;

    private int voltageBattery;

    private int currentBattery;

    private int dropRateComm;

    private int errorsComm;

    private int errorsCount1;

    private int errorsCount2;

    private int errorsCount3;

    private int errorsCount4;

    private int batteryRemaining;

    private Builder() {
    }

    /**
     * Bitmask showing which onboard controllers and sensors are present. Value of 0: not present. 
     * Value of 1: present. Indices defined by ENUM {@link io.dronefleet.mavlink.common.MavSysStatusSensor MavSysStatusSensor} 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 4
    )
    public final Builder onboardControlSensorsPresent(
        EnumFlagSet<MavSysStatusSensor> onboardControlSensorsPresent) {
      this.onboardControlSensorsPresent = onboardControlSensorsPresent;
      return this;
    }

    /**
     * Bitmask showing which onboard controllers and sensors are enabled: Value of 0: not enabled. 
     * Value of 1: enabled. Indices defined by ENUM {@link io.dronefleet.mavlink.common.MavSysStatusSensor MavSysStatusSensor} 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder onboardControlSensorsEnabled(
        EnumFlagSet<MavSysStatusSensor> onboardControlSensorsEnabled) {
      this.onboardControlSensorsEnabled = onboardControlSensorsEnabled;
      return this;
    }

    /**
     * Bitmask showing which onboard controllers and sensors are operational or have an error: Value 
     * of 0: not enabled. Value of 1: enabled. Indices defined by ENUM {@link io.dronefleet.mavlink.common.MavSysStatusSensor MavSysStatusSensor} 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 4
    )
    public final Builder onboardControlSensorsHealth(
        EnumFlagSet<MavSysStatusSensor> onboardControlSensorsHealth) {
      this.onboardControlSensorsHealth = onboardControlSensorsHealth;
      return this;
    }

    /**
     * Maximum usage in percent of the mainloop time, (0%: 0, 100%: 1000) should be always below 1000 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 2
    )
    public final Builder load(int load) {
      this.load = load;
      return this;
    }

    /**
     * Battery voltage, in millivolts (1 = 1 millivolt) 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 2
    )
    public final Builder voltageBattery(int voltageBattery) {
      this.voltageBattery = voltageBattery;
      return this;
    }

    /**
     * Battery current, in 10*milliamperes (1 = 10 milliampere), -1: autopilot does not measure the 
     * current 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 2
    )
    public final Builder currentBattery(int currentBattery) {
      this.currentBattery = currentBattery;
      return this;
    }

    /**
     * Communication drops in percent, (0%: 0, 100%: 10'000), (UART, I2C, SPI, CAN), dropped packets 
     * on all links (packets that were corrupted on reception on the MAV) 
     */
    @MavlinkMessageField(
        position = 8,
        unitSize = 2
    )
    public final Builder dropRateComm(int dropRateComm) {
      this.dropRateComm = dropRateComm;
      return this;
    }

    /**
     * Communication errors (UART, I2C, SPI, CAN), dropped packets on all links (packets that were 
     * corrupted on reception on the MAV) 
     */
    @MavlinkMessageField(
        position = 9,
        unitSize = 2
    )
    public final Builder errorsComm(int errorsComm) {
      this.errorsComm = errorsComm;
      return this;
    }

    /**
     * Autopilot-specific errors 
     */
    @MavlinkMessageField(
        position = 10,
        unitSize = 2
    )
    public final Builder errorsCount1(int errorsCount1) {
      this.errorsCount1 = errorsCount1;
      return this;
    }

    /**
     * Autopilot-specific errors 
     */
    @MavlinkMessageField(
        position = 11,
        unitSize = 2
    )
    public final Builder errorsCount2(int errorsCount2) {
      this.errorsCount2 = errorsCount2;
      return this;
    }

    /**
     * Autopilot-specific errors 
     */
    @MavlinkMessageField(
        position = 12,
        unitSize = 2
    )
    public final Builder errorsCount3(int errorsCount3) {
      this.errorsCount3 = errorsCount3;
      return this;
    }

    /**
     * Autopilot-specific errors 
     */
    @MavlinkMessageField(
        position = 13,
        unitSize = 2
    )
    public final Builder errorsCount4(int errorsCount4) {
      this.errorsCount4 = errorsCount4;
      return this;
    }

    /**
     * Remaining battery energy: (0%: 0, 100%: 100), -1: autopilot estimate the remaining battery 
     */
    @MavlinkMessageField(
        position = 7,
        unitSize = 1
    )
    public final Builder batteryRemaining(int batteryRemaining) {
      this.batteryRemaining = batteryRemaining;
      return this;
    }

    public final SysStatus build() {
      return new SysStatus(onboardControlSensorsPresent, onboardControlSensorsEnabled, onboardControlSensorsHealth, load, voltageBattery, currentBattery, dropRateComm, errorsComm, errorsCount1, errorsCount2, errorsCount3, errorsCount4, batteryRemaining);
    }
  }
}
