package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * The offset in X, Y, Z and yaw between the {@link io.dronefleet.mavlink.common.LocalPositionNed LocalPositionNed} messages of MAV X and the global 
 * coordinate frame in NED coordinates. Coordinate frame is right-handed, Z-axis down 
 * (aeronautical frame, NED / north-east-down convention) 
 */
@MavlinkMessage(
    id = 89,
    crc = 231
)
public final class LocalPositionNedSystemGlobalOffset {
  /**
   * Timestamp (milliseconds since system boot) 
   */
  private final long timeBootMs;

  /**
   * X Position 
   */
  private final float x;

  /**
   * Y Position 
   */
  private final float y;

  /**
   * Z Position 
   */
  private final float z;

  /**
   * Roll 
   */
  private final float roll;

  /**
   * Pitch 
   */
  private final float pitch;

  /**
   * Yaw 
   */
  private final float yaw;

  private LocalPositionNedSystemGlobalOffset(long timeBootMs, float x, float y, float z, float roll,
      float pitch, float yaw) {
    this.timeBootMs = timeBootMs;
    this.x = x;
    this.y = y;
    this.z = z;
    this.roll = roll;
    this.pitch = pitch;
    this.yaw = yaw;
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
   * X Position 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float x() {
    return x;
  }

  /**
   * Y Position 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float y() {
    return y;
  }

  /**
   * Z Position 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float z() {
    return z;
  }

  /**
   * Roll 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float roll() {
    return roll;
  }

  /**
   * Pitch 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float pitch() {
    return pitch;
  }

  /**
   * Yaw 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float yaw() {
    return yaw;
  }

  public static class Builder {
    private long timeBootMs;

    private float x;

    private float y;

    private float z;

    private float roll;

    private float pitch;

    private float yaw;

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
     * X Position 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder x(float x) {
      this.x = x;
      return this;
    }

    /**
     * Y Position 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder y(float y) {
      this.y = y;
      return this;
    }

    /**
     * Z Position 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder z(float z) {
      this.z = z;
      return this;
    }

    /**
     * Roll 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder roll(float roll) {
      this.roll = roll;
      return this;
    }

    /**
     * Pitch 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder pitch(float pitch) {
      this.pitch = pitch;
      return this;
    }

    /**
     * Yaw 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder yaw(float yaw) {
      this.yaw = yaw;
      return this;
    }

    public final LocalPositionNedSystemGlobalOffset build() {
      return new LocalPositionNedSystemGlobalOffset(timeBootMs, x, y, z, roll, pitch, yaw);
    }
  }
}
