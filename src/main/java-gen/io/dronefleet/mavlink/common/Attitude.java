package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right). 
 */
@MavlinkMessage(
    id = 30,
    crc = 39
)
public final class Attitude {
  /**
   * Timestamp (milliseconds since system boot) 
   */
  private final long timeBootMs;

  /**
   * Roll angle (rad, -pi..+pi) 
   */
  private final float roll;

  /**
   * Pitch angle (rad, -pi..+pi) 
   */
  private final float pitch;

  /**
   * Yaw angle (rad, -pi..+pi) 
   */
  private final float yaw;

  /**
   * Roll angular speed (rad/s) 
   */
  private final float rollspeed;

  /**
   * Pitch angular speed (rad/s) 
   */
  private final float pitchspeed;

  /**
   * Yaw angular speed (rad/s) 
   */
  private final float yawspeed;

  private Attitude(long timeBootMs, float roll, float pitch, float yaw, float rollspeed,
      float pitchspeed, float yawspeed) {
    this.timeBootMs = timeBootMs;
    this.roll = roll;
    this.pitch = pitch;
    this.yaw = yaw;
    this.rollspeed = rollspeed;
    this.pitchspeed = pitchspeed;
    this.yawspeed = yawspeed;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (milliseconds since system boot) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  /**
   * Roll angle (rad, -pi..+pi) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float roll() {
    return roll;
  }

  /**
   * Pitch angle (rad, -pi..+pi) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float pitch() {
    return pitch;
  }

  /**
   * Yaw angle (rad, -pi..+pi) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float yaw() {
    return yaw;
  }

  /**
   * Roll angular speed (rad/s) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float rollspeed() {
    return rollspeed;
  }

  /**
   * Pitch angular speed (rad/s) 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float pitchspeed() {
    return pitchspeed;
  }

  /**
   * Yaw angular speed (rad/s) 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float yawspeed() {
    return yawspeed;
  }

  public static class Builder {
    private long timeBootMs;

    private float roll;

    private float pitch;

    private float yaw;

    private float rollspeed;

    private float pitchspeed;

    private float yawspeed;

    private Builder() {
    }

    /**
     * Timestamp (milliseconds since system boot) 
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
     * Roll angle (rad, -pi..+pi) 
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
     * Pitch angle (rad, -pi..+pi) 
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
     * Yaw angle (rad, -pi..+pi) 
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
     * Roll angular speed (rad/s) 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder rollspeed(float rollspeed) {
      this.rollspeed = rollspeed;
      return this;
    }

    /**
     * Pitch angular speed (rad/s) 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder pitchspeed(float pitchspeed) {
      this.pitchspeed = pitchspeed;
      return this;
    }

    /**
     * Yaw angular speed (rad/s) 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder yawspeed(float yawspeed) {
      this.yawspeed = yawspeed;
      return this;
    }

    public final Attitude build() {
      return new Attitude(timeBootMs, roll, pitch, yaw, rollspeed, pitchspeed, yawspeed);
    }
  }
}
