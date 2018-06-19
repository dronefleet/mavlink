package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Float;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;

/**
 * null
 */
@MavlinkMessage(
    id = 104,
    crc = 56
)
public final class ViconPositionEstimate {
  /**
   * Timestamp (microseconds, synced to UNIX time or since system boot) 
   */
  private final BigInteger usec;

  /**
   * Global X position 
   */
  private final float x;

  /**
   * Global Y position 
   */
  private final float y;

  /**
   * Global Z position 
   */
  private final float z;

  /**
   * Roll angle in rad 
   */
  private final float roll;

  /**
   * Pitch angle in rad 
   */
  private final float pitch;

  /**
   * Yaw angle in rad 
   */
  private final float yaw;

  /**
   * Pose covariance matrix upper right triangular (first six entries are the first ROW, next five 
   * entries are the second ROW, etc.) 
   */
  private final List<Float> covariance;

  private ViconPositionEstimate(BigInteger usec, float x, float y, float z, float roll, float pitch,
      float yaw, List<Float> covariance) {
    this.usec = usec;
    this.x = x;
    this.y = y;
    this.z = z;
    this.roll = roll;
    this.pitch = pitch;
    this.yaw = yaw;
    this.covariance = covariance;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "ViconPositionEstimate{usec=" + usec
         + ", x=" + x
         + ", y=" + y
         + ", z=" + z
         + ", roll=" + roll
         + ", pitch=" + pitch
         + ", yaw=" + yaw
         + ", covariance=" + covariance + "}";
  }

  /**
   * Timestamp (microseconds, synced to UNIX time or since system boot) 
   */
  @MavlinkMessageField(
      position = 0,
      unitSize = 8
  )
  public final BigInteger usec() {
    return usec;
  }

  /**
   * Global X position 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 4
  )
  public final float x() {
    return x;
  }

  /**
   * Global Y position 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final float y() {
    return y;
  }

  /**
   * Global Z position 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final float z() {
    return z;
  }

  /**
   * Roll angle in rad 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final float roll() {
    return roll;
  }

  /**
   * Pitch angle in rad 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 4
  )
  public final float pitch() {
    return pitch;
  }

  /**
   * Yaw angle in rad 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 4
  )
  public final float yaw() {
    return yaw;
  }

  /**
   * Pose covariance matrix upper right triangular (first six entries are the first ROW, next five 
   * entries are the second ROW, etc.) 
   */
  @MavlinkMessageField(
      position = 8,
      unitSize = 4,
      arraySize = 21,
      extension = true
  )
  public final List<Float> covariance() {
    return covariance;
  }

  public static class Builder {
    private BigInteger usec;

    private float x;

    private float y;

    private float z;

    private float roll;

    private float pitch;

    private float yaw;

    private List<Float> covariance;

    private Builder() {
    }

    /**
     * Timestamp (microseconds, synced to UNIX time or since system boot) 
     */
    @MavlinkMessageField(
        position = 0,
        unitSize = 8
    )
    public final Builder usec(BigInteger usec) {
      this.usec = usec;
      return this;
    }

    /**
     * Global X position 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 4
    )
    public final Builder x(float x) {
      this.x = x;
      return this;
    }

    /**
     * Global Y position 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder y(float y) {
      this.y = y;
      return this;
    }

    /**
     * Global Z position 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 4
    )
    public final Builder z(float z) {
      this.z = z;
      return this;
    }

    /**
     * Roll angle in rad 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 4
    )
    public final Builder roll(float roll) {
      this.roll = roll;
      return this;
    }

    /**
     * Pitch angle in rad 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 4
    )
    public final Builder pitch(float pitch) {
      this.pitch = pitch;
      return this;
    }

    /**
     * Yaw angle in rad 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 4
    )
    public final Builder yaw(float yaw) {
      this.yaw = yaw;
      return this;
    }

    /**
     * Pose covariance matrix upper right triangular (first six entries are the first ROW, next five 
     * entries are the second ROW, etc.) 
     */
    @MavlinkMessageField(
        position = 8,
        unitSize = 4,
        arraySize = 21,
        extension = true
    )
    public final Builder covariance(List<Float> covariance) {
      this.covariance = covariance;
      return this;
    }

    public final ViconPositionEstimate build() {
      return new ViconPositionEstimate(usec, x, y, z, roll, pitch, yaw, covariance);
    }
  }
}
