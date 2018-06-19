package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * The filtered local position (e.g. fused computer vision and accelerometers). Coordinate 
 * frame is right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention) 
 */
@MavlinkMessage(
    id = 32,
    crc = 185
)
public final class LocalPositionNed {
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
   * X Speed 
   */
  private final float vx;

  /**
   * Y Speed 
   */
  private final float vy;

  /**
   * Z Speed 
   */
  private final float vz;

  private LocalPositionNed(long timeBootMs, float x, float y, float z, float vx, float vy,
      float vz) {
    this.timeBootMs = timeBootMs;
    this.x = x;
    this.y = y;
    this.z = z;
    this.vx = vx;
    this.vy = vy;
    this.vz = vz;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "LocalPositionNed{timeBootMs=" + timeBootMs
         + ", x=" + x
         + ", y=" + y
         + ", z=" + z
         + ", vx=" + vx
         + ", vy=" + vy
         + ", vz=" + vz + "}";
  }

  /**
   * Timestamp (milliseconds since system boot) 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  /**
   * X Position 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final float x() {
    return x;
  }

  /**
   * Y Position 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final float y() {
    return y;
  }

  /**
   * Z Position 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final float z() {
    return z;
  }

  /**
   * X Speed 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 4
  )
  public final float vx() {
    return vx;
  }

  /**
   * Y Speed 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 4
  )
  public final float vy() {
    return vy;
  }

  /**
   * Z Speed 
   */
  @MavlinkMessageField(
      position = 7,
      unitSize = 4
  )
  public final float vz() {
    return vz;
  }

  public static class Builder {
    private long timeBootMs;

    private float x;

    private float y;

    private float z;

    private float vx;

    private float vy;

    private float vz;

    private Builder() {
    }

    /**
     * Timestamp (milliseconds since system boot) 
     */
    @MavlinkMessageField(
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
    @MavlinkMessageField(
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
    @MavlinkMessageField(
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
    @MavlinkMessageField(
        position = 4,
        unitSize = 4
    )
    public final Builder z(float z) {
      this.z = z;
      return this;
    }

    /**
     * X Speed 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 4
    )
    public final Builder vx(float vx) {
      this.vx = vx;
      return this;
    }

    /**
     * Y Speed 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 4
    )
    public final Builder vy(float vy) {
      this.vy = vy;
      return this;
    }

    /**
     * Z Speed 
     */
    @MavlinkMessageField(
        position = 7,
        unitSize = 4
    )
    public final Builder vz(float vz) {
      this.vz = vz;
      return this;
    }

    public final LocalPositionNed build() {
      return new LocalPositionNed(timeBootMs, x, y, z, vx, vy, vz);
    }
  }
}
