package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Deprecated. Use BATTERY_STATUS instead. 2nd Battery status 
 */
@MavlinkMessage(
    id = 181,
    crc = 174
)
public final class Battery2 {
  private final int voltage;

  private final int currentBattery;

  private Battery2(int voltage, int currentBattery) {
    this.voltage = voltage;
    this.currentBattery = currentBattery;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * voltage in millivolts 
   */
  @MavlinkMessageField(
      position = 1,
      length = 2
  )
  public final int voltage() {
    return voltage;
  }

  /**
   * Battery current, in centiamperes (1 = 10 milliampere), -1: autopilot does not measure the 
   * current 
   */
  @MavlinkMessageField(
      position = 2,
      length = 2
  )
  public final int currentBattery() {
    return currentBattery;
  }

  public class Builder {
    private int voltage;

    private int currentBattery;

    private Builder() {
    }

    /**
     * voltage in millivolts 
     */
    @MavlinkMessageField(
        position = 1,
        length = 2
    )
    public final Builder voltage(int voltage) {
      this.voltage = voltage;
      return this;
    }

    /**
     * Battery current, in centiamperes (1 = 10 milliampere), -1: autopilot does not measure the 
     * current 
     */
    @MavlinkMessageField(
        position = 2,
        length = 2
    )
    public final Builder currentBattery(int currentBattery) {
      this.currentBattery = currentBattery;
      return this;
    }

    public final Battery2 build() {
      return new Battery2(voltage, currentBattery);
    }
  }
}
