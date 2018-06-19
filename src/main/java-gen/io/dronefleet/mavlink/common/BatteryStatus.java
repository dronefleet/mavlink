package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Battery information 
 */
@MavlinkMessage(
    id = 147,
    crc = 154
)
public final class BatteryStatus {
  /**
   * Consumed charge, in milliampere hours (1 = 1 mAh), -1: autopilot does not provide mAh 
   * consumption estimate 
   */
  private final int currentConsumed;

  /**
   * Consumed energy, in HectoJoules (intergrated U*I*dt) (1 = 100 Joule), -1: autopilot does not 
   * provide energy consumption estimate 
   */
  private final int energyConsumed;

  /**
   * Temperature of the battery in centi-degrees celsius. INT16_MAX for unknown temperature. 
   */
  private final int temperature;

  /**
   * Battery voltage of cells, in millivolts (1 = 1 millivolt). Cells above the valid cell count for 
   * this battery should have the UINT16_MAX value. 
   */
  private final List<Integer> voltages;

  /**
   * Battery current, in 10*milliamperes (1 = 10 milliampere), -1: autopilot does not measure the 
   * current 
   */
  private final int currentBattery;

  /**
   * Battery ID 
   */
  private final int id;

  /**
   * Function of the battery 
   */
  private final MavBatteryFunction batteryFunction;

  /**
   * Type (chemistry) of the battery 
   */
  private final MavBatteryType type;

  /**
   * Remaining battery energy: (0%: 0, 100%: 100), -1: autopilot does not estimate the remaining 
   * battery 
   */
  private final int batteryRemaining;

  /**
   * Remaining battery time, in seconds (1 = 1s = 0% energy left), 0: autopilot does not provide 
   * remaining battery time estimate 
   */
  private final int timeRemaining;

  /**
   * State for extent of discharge, provided by autopilot for warning or external reactions 
   */
  private final MavBatteryChargeState chargeState;

  private BatteryStatus(int currentConsumed, int energyConsumed, int temperature,
      List<Integer> voltages, int currentBattery, int id, MavBatteryFunction batteryFunction,
      MavBatteryType type, int batteryRemaining, int timeRemaining,
      MavBatteryChargeState chargeState) {
    this.currentConsumed = currentConsumed;
    this.energyConsumed = energyConsumed;
    this.temperature = temperature;
    this.voltages = voltages;
    this.currentBattery = currentBattery;
    this.id = id;
    this.batteryFunction = batteryFunction;
    this.type = type;
    this.batteryRemaining = batteryRemaining;
    this.timeRemaining = timeRemaining;
    this.chargeState = chargeState;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "BatteryStatus{id=" + id
         + ", batteryFunction=" + batteryFunction
         + ", type=" + type
         + ", temperature=" + temperature
         + ", voltages=" + voltages
         + ", currentBattery=" + currentBattery
         + ", currentConsumed=" + currentConsumed
         + ", energyConsumed=" + energyConsumed
         + ", batteryRemaining=" + batteryRemaining
         + ", timeRemaining=" + timeRemaining
         + ", chargeState=" + chargeState + "}";
  }

  /**
   * Consumed charge, in milliampere hours (1 = 1 mAh), -1: autopilot does not provide mAh 
   * consumption estimate 
   */
  @MavlinkMessageField(
      position = 7,
      unitSize = 4
  )
  public final int currentConsumed() {
    return currentConsumed;
  }

  /**
   * Consumed energy, in HectoJoules (intergrated U*I*dt) (1 = 100 Joule), -1: autopilot does not 
   * provide energy consumption estimate 
   */
  @MavlinkMessageField(
      position = 8,
      unitSize = 4
  )
  public final int energyConsumed() {
    return energyConsumed;
  }

  /**
   * Temperature of the battery in centi-degrees celsius. INT16_MAX for unknown temperature. 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 2
  )
  public final int temperature() {
    return temperature;
  }

  /**
   * Battery voltage of cells, in millivolts (1 = 1 millivolt). Cells above the valid cell count for 
   * this battery should have the UINT16_MAX value. 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 2,
      arraySize = 10
  )
  public final List<Integer> voltages() {
    return voltages;
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
   * Battery ID 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1
  )
  public final int id() {
    return id;
  }

  /**
   * Function of the battery 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final MavBatteryFunction batteryFunction() {
    return batteryFunction;
  }

  /**
   * Type (chemistry) of the battery 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 1
  )
  public final MavBatteryType type() {
    return type;
  }

  /**
   * Remaining battery energy: (0%: 0, 100%: 100), -1: autopilot does not estimate the remaining 
   * battery 
   */
  @MavlinkMessageField(
      position = 9,
      unitSize = 1
  )
  public final int batteryRemaining() {
    return batteryRemaining;
  }

  /**
   * Remaining battery time, in seconds (1 = 1s = 0% energy left), 0: autopilot does not provide 
   * remaining battery time estimate 
   */
  @MavlinkMessageField(
      position = 11,
      unitSize = 4,
      extension = true
  )
  public final int timeRemaining() {
    return timeRemaining;
  }

  /**
   * State for extent of discharge, provided by autopilot for warning or external reactions 
   */
  @MavlinkMessageField(
      position = 12,
      unitSize = 1,
      extension = true
  )
  public final MavBatteryChargeState chargeState() {
    return chargeState;
  }

  public static class Builder {
    private int currentConsumed;

    private int energyConsumed;

    private int temperature;

    private List<Integer> voltages;

    private int currentBattery;

    private int id;

    private MavBatteryFunction batteryFunction;

    private MavBatteryType type;

    private int batteryRemaining;

    private int timeRemaining;

    private MavBatteryChargeState chargeState;

    private Builder() {
    }

    /**
     * Consumed charge, in milliampere hours (1 = 1 mAh), -1: autopilot does not provide mAh 
     * consumption estimate 
     */
    @MavlinkMessageField(
        position = 7,
        unitSize = 4
    )
    public final Builder currentConsumed(int currentConsumed) {
      this.currentConsumed = currentConsumed;
      return this;
    }

    /**
     * Consumed energy, in HectoJoules (intergrated U*I*dt) (1 = 100 Joule), -1: autopilot does not 
     * provide energy consumption estimate 
     */
    @MavlinkMessageField(
        position = 8,
        unitSize = 4
    )
    public final Builder energyConsumed(int energyConsumed) {
      this.energyConsumed = energyConsumed;
      return this;
    }

    /**
     * Temperature of the battery in centi-degrees celsius. INT16_MAX for unknown temperature. 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 2
    )
    public final Builder temperature(int temperature) {
      this.temperature = temperature;
      return this;
    }

    /**
     * Battery voltage of cells, in millivolts (1 = 1 millivolt). Cells above the valid cell count for 
     * this battery should have the UINT16_MAX value. 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 2,
        arraySize = 10
    )
    public final Builder voltages(List<Integer> voltages) {
      this.voltages = voltages;
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
     * Battery ID 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 1
    )
    public final Builder id(int id) {
      this.id = id;
      return this;
    }

    /**
     * Function of the battery 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 1
    )
    public final Builder batteryFunction(MavBatteryFunction batteryFunction) {
      this.batteryFunction = batteryFunction;
      return this;
    }

    /**
     * Type (chemistry) of the battery 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 1
    )
    public final Builder type(MavBatteryType type) {
      this.type = type;
      return this;
    }

    /**
     * Remaining battery energy: (0%: 0, 100%: 100), -1: autopilot does not estimate the remaining 
     * battery 
     */
    @MavlinkMessageField(
        position = 9,
        unitSize = 1
    )
    public final Builder batteryRemaining(int batteryRemaining) {
      this.batteryRemaining = batteryRemaining;
      return this;
    }

    /**
     * Remaining battery time, in seconds (1 = 1s = 0% energy left), 0: autopilot does not provide 
     * remaining battery time estimate 
     */
    @MavlinkMessageField(
        position = 11,
        unitSize = 4,
        extension = true
    )
    public final Builder timeRemaining(int timeRemaining) {
      this.timeRemaining = timeRemaining;
      return this;
    }

    /**
     * State for extent of discharge, provided by autopilot for warning or external reactions 
     */
    @MavlinkMessageField(
        position = 12,
        unitSize = 1,
        extension = true
    )
    public final Builder chargeState(MavBatteryChargeState chargeState) {
      this.chargeState = chargeState;
      return this;
    }

    public final BatteryStatus build() {
      return new BatteryStatus(currentConsumed, energyConsumed, temperature, voltages, currentBattery, id, batteryFunction, type, batteryRemaining, timeRemaining, chargeState);
    }
  }
}
