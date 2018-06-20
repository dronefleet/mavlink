package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * The offset in X, Y, Z and yaw between the {@link io.dronefleet.mavlink.common.LocalPositionNed LocalPositionNed} messages of MAV X and the global 
 * coordinate frame in NED coordinates. Coordinate frame is right-handed, Z-axis down 
 * (aeronautical frame, NED / north-east-down convention) 
 */
@MavlinkMessageInfo(
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

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "LocalPositionNedSystemGlobalOffset{timeBootMs=" + timeBootMs
         + ", x=" + x
         + ", y=" + y
         + ", z=" + z
         + ", roll=" + roll
         + ", pitch=" + pitch
         + ", yaw=" + yaw + "}";
  }

  /**
   * Timestamp (milliseconds since system boot) 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  /**
   * X Position 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 4
  )
  public final float x() {
    return x;
  }

  /**
   * Y Position 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 4
  )
  public final float y() {
    return y;
  }

  /**
   * Z Position 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 4
  )
  public final float z() {
    return z;
  }

  /**
   * Roll 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final float roll() {
    return roll;
  }

  /**
   * Pitch 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 4
  )
  public final float pitch() {
    return pitch;
  }

  /**
   * Yaw 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 4
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
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 4
    )
    public final Builder timeBootMs(long timeBootMs) {
      this.timeBootMs = timeBootMs;
      return this;
    }

    /**
     * X Position 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 4
    )
    public final Builder x(float x) {
      this.x = x;
      return this;
    }

    /**
     * Y Position 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 4
    )
    public final Builder y(float y) {
      this.y = y;
      return this;
    }

    /**
     * Z Position 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 4
    )
    public final Builder z(float z) {
      this.z = z;
      return this;
    }

    /**
     * Roll 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder roll(float roll) {
      this.roll = roll;
      return this;
    }

    /**
     * Pitch 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 4
    )
    public final Builder pitch(float pitch) {
      this.pitch = pitch;
      return this;
    }

    /**
     * Yaw 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 4
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
