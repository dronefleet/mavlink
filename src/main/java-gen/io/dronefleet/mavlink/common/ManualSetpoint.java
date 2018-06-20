package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Setpoint in roll, pitch, yaw and thrust from the operator 
 */
@MavlinkMessageInfo(
    id = 81,
    crc = 106
)
public final class ManualSetpoint {
  /**
   * Timestamp in milliseconds since system boot 
   */
  private final long timeBootMs;

  /**
   * Desired roll rate in radians per second 
   */
  private final float roll;

  /**
   * Desired pitch rate in radians per second 
   */
  private final float pitch;

  /**
   * Desired yaw rate in radians per second 
   */
  private final float yaw;

  /**
   * Collective thrust, normalized to 0 .. 1 
   */
  private final float thrust;

  /**
   * Flight mode switch position, 0.. 255 
   */
  private final int modeSwitch;

  /**
   * Override mode switch position, 0.. 255 
   */
  private final int manualOverrideSwitch;

  private ManualSetpoint(long timeBootMs, float roll, float pitch, float yaw, float thrust,
      int modeSwitch, int manualOverrideSwitch) {
    this.timeBootMs = timeBootMs;
    this.roll = roll;
    this.pitch = pitch;
    this.yaw = yaw;
    this.thrust = thrust;
    this.modeSwitch = modeSwitch;
    this.manualOverrideSwitch = manualOverrideSwitch;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "ManualSetpoint{timeBootMs=" + timeBootMs
         + ", roll=" + roll
         + ", pitch=" + pitch
         + ", yaw=" + yaw
         + ", thrust=" + thrust
         + ", modeSwitch=" + modeSwitch
         + ", manualOverrideSwitch=" + manualOverrideSwitch + "}";
  }

  /**
   * Timestamp in milliseconds since system boot 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  /**
   * Desired roll rate in radians per second 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 4
  )
  public final float roll() {
    return roll;
  }

  /**
   * Desired pitch rate in radians per second 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 4
  )
  public final float pitch() {
    return pitch;
  }

  /**
   * Desired yaw rate in radians per second 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 4
  )
  public final float yaw() {
    return yaw;
  }

  /**
   * Collective thrust, normalized to 0 .. 1 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final float thrust() {
    return thrust;
  }

  /**
   * Flight mode switch position, 0.. 255 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 1
  )
  public final int modeSwitch() {
    return modeSwitch;
  }

  /**
   * Override mode switch position, 0.. 255 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 1
  )
  public final int manualOverrideSwitch() {
    return manualOverrideSwitch;
  }

  public static class Builder {
    private long timeBootMs;

    private float roll;

    private float pitch;

    private float yaw;

    private float thrust;

    private int modeSwitch;

    private int manualOverrideSwitch;

    private Builder() {
    }

    /**
     * Timestamp in milliseconds since system boot 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 4
    )
    public final Builder timeBootMs(long timeBootMs) {
      this.timeBootMs = timeBootMs;
      return this;
    }

    /**
     * Desired roll rate in radians per second 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 4
    )
    public final Builder roll(float roll) {
      this.roll = roll;
      return this;
    }

    /**
     * Desired pitch rate in radians per second 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 4
    )
    public final Builder pitch(float pitch) {
      this.pitch = pitch;
      return this;
    }

    /**
     * Desired yaw rate in radians per second 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 4
    )
    public final Builder yaw(float yaw) {
      this.yaw = yaw;
      return this;
    }

    /**
     * Collective thrust, normalized to 0 .. 1 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder thrust(float thrust) {
      this.thrust = thrust;
      return this;
    }

    /**
     * Flight mode switch position, 0.. 255 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 1
    )
    public final Builder modeSwitch(int modeSwitch) {
      this.modeSwitch = modeSwitch;
      return this;
    }

    /**
     * Override mode switch position, 0.. 255 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 1
    )
    public final Builder manualOverrideSwitch(int manualOverrideSwitch) {
      this.manualOverrideSwitch = manualOverrideSwitch;
      return this;
    }

    public final ManualSetpoint build() {
      return new ManualSetpoint(timeBootMs, roll, pitch, yaw, thrust, modeSwitch, manualOverrideSwitch);
    }
  }
}
