package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Float;
import java.math.BigInteger;
import java.util.List;

/**
 * null
 */
@MavlinkMessage(
    id = 102,
    crc = 158
)
public final class VisionPositionEstimate {
  private final BigInteger usec;

  private final float x;

  private final float y;

  private final float z;

  private final float roll;

  private final float pitch;

  private final float yaw;

  private final List<Float> covariance;

  private VisionPositionEstimate(BigInteger usec, float x, float y, float z, float roll,
      float pitch, float yaw, List<Float> covariance) {
    this.usec = usec;
    this.x = x;
    this.y = y;
    this.z = z;
    this.roll = roll;
    this.pitch = pitch;
    this.yaw = yaw;
    this.covariance = covariance;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (microseconds, synced to UNIX time or since system boot) 
   */
  @MavlinkMessageField(
      position = 0,
      length = 8
  )
  public final BigInteger usec() {
    return usec;
  }

  /**
   * Global X position 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final float x() {
    return x;
  }

  /**
   * Global Y position 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float y() {
    return y;
  }

  /**
   * Global Z position 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float z() {
    return z;
  }

  /**
   * Roll angle in rad 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float roll() {
    return roll;
  }

  /**
   * Pitch angle in rad 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float pitch() {
    return pitch;
  }

  /**
   * Yaw angle in rad 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
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
      length = 4,
      arraySize = 21,
      extension = true
  )
  public final List<Float> covariance() {
    return covariance;
  }

  public class Builder {
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
        length = 8
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
        length = 4
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
        length = 4
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
        length = 4
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
        length = 4
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
        length = 4
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
        length = 4
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
        length = 4,
        arraySize = 21,
        extension = true
    )
    public final Builder covariance(List<Float> covariance) {
      this.covariance = covariance;
      return this;
    }

    public final VisionPositionEstimate build() {
      return new VisionPositionEstimate(usec, x, y, z, roll, pitch, yaw, covariance);
    }
  }
}
