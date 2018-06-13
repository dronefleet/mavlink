package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Setpoint in roll, pitch, yaw and thrust from the operator 
 */
@MavlinkMessage(
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

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp in milliseconds since system boot 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  /**
   * Desired roll rate in radians per second 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float roll() {
    return roll;
  }

  /**
   * Desired pitch rate in radians per second 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float pitch() {
    return pitch;
  }

  /**
   * Desired yaw rate in radians per second 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float yaw() {
    return yaw;
  }

  /**
   * Collective thrust, normalized to 0 .. 1 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float thrust() {
    return thrust;
  }

  /**
   * Flight mode switch position, 0.. 255 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1
  )
  public final int modeSwitch() {
    return modeSwitch;
  }

  /**
   * Override mode switch position, 0.. 255 
   */
  @MavlinkMessageField(
      position = 7,
      length = 1
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
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder timeBootMs(long timeBootMs) {
      this.timeBootMs = timeBootMs;
      return this;
    }

    /**
     * Desired roll rate in radians per second 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder roll(float roll) {
      this.roll = roll;
      return this;
    }

    /**
     * Desired pitch rate in radians per second 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder pitch(float pitch) {
      this.pitch = pitch;
      return this;
    }

    /**
     * Desired yaw rate in radians per second 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder yaw(float yaw) {
      this.yaw = yaw;
      return this;
    }

    /**
     * Collective thrust, normalized to 0 .. 1 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder thrust(float thrust) {
      this.thrust = thrust;
      return this;
    }

    /**
     * Flight mode switch position, 0.. 255 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1
    )
    public final Builder modeSwitch(int modeSwitch) {
      this.modeSwitch = modeSwitch;
      return this;
    }

    /**
     * Override mode switch position, 0.. 255 
     */
    @MavlinkMessageField(
        position = 7,
        length = 1
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
