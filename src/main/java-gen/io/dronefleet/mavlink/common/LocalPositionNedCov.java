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
 * The filtered local position (e.g. fused computer vision and accelerometers). Coordinate 
 * frame is right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention) 
 */
@MavlinkMessage(
    id = 64,
    crc = 191
)
public final class LocalPositionNedCov {
  /**
   * Timestamp (microseconds since system boot or since UNIX epoch) 
   */
  private final BigInteger timeUsec;

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
   * X Speed (m/s) 
   */
  private final float vx;

  /**
   * Y Speed (m/s) 
   */
  private final float vy;

  /**
   * Z Speed (m/s) 
   */
  private final float vz;

  /**
   * X Acceleration (m/s^2) 
   */
  private final float ax;

  /**
   * Y Acceleration (m/s^2) 
   */
  private final float ay;

  /**
   * Z Acceleration (m/s^2) 
   */
  private final float az;

  /**
   * Covariance matrix upper right triangular (first nine entries are the first ROW, next eight 
   * entries are the second row, etc.) 
   */
  private final List<Float> covariance;

  /**
   * Class id of the estimator this estimate originated from. 
   */
  private final MavEstimatorType estimatorType;

  private LocalPositionNedCov(BigInteger timeUsec, float x, float y, float z, float vx, float vy,
      float vz, float ax, float ay, float az, List<Float> covariance,
      MavEstimatorType estimatorType) {
    this.timeUsec = timeUsec;
    this.x = x;
    this.y = y;
    this.z = z;
    this.vx = vx;
    this.vy = vy;
    this.vz = vz;
    this.ax = ax;
    this.ay = ay;
    this.az = az;
    this.covariance = covariance;
    this.estimatorType = estimatorType;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "LocalPositionNedCov{timeUsec=" + timeUsec
         + ", estimatorType=" + estimatorType
         + ", x=" + x
         + ", y=" + y
         + ", z=" + z
         + ", vx=" + vx
         + ", vy=" + vy
         + ", vz=" + vz
         + ", ax=" + ax
         + ", ay=" + ay
         + ", az=" + az
         + ", covariance=" + covariance + "}";
  }

  /**
   * Timestamp (microseconds since system boot or since UNIX epoch) 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * X Position 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final float x() {
    return x;
  }

  /**
   * Y Position 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final float y() {
    return y;
  }

  /**
   * Z Position 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 4
  )
  public final float z() {
    return z;
  }

  /**
   * X Speed (m/s) 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 4
  )
  public final float vx() {
    return vx;
  }

  /**
   * Y Speed (m/s) 
   */
  @MavlinkMessageField(
      position = 7,
      unitSize = 4
  )
  public final float vy() {
    return vy;
  }

  /**
   * Z Speed (m/s) 
   */
  @MavlinkMessageField(
      position = 8,
      unitSize = 4
  )
  public final float vz() {
    return vz;
  }

  /**
   * X Acceleration (m/s^2) 
   */
  @MavlinkMessageField(
      position = 9,
      unitSize = 4
  )
  public final float ax() {
    return ax;
  }

  /**
   * Y Acceleration (m/s^2) 
   */
  @MavlinkMessageField(
      position = 10,
      unitSize = 4
  )
  public final float ay() {
    return ay;
  }

  /**
   * Z Acceleration (m/s^2) 
   */
  @MavlinkMessageField(
      position = 11,
      unitSize = 4
  )
  public final float az() {
    return az;
  }

  /**
   * Covariance matrix upper right triangular (first nine entries are the first ROW, next eight 
   * entries are the second row, etc.) 
   */
  @MavlinkMessageField(
      position = 12,
      unitSize = 4,
      arraySize = 45
  )
  public final List<Float> covariance() {
    return covariance;
  }

  /**
   * Class id of the estimator this estimate originated from. 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final MavEstimatorType estimatorType() {
    return estimatorType;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private float x;

    private float y;

    private float z;

    private float vx;

    private float vy;

    private float vz;

    private float ax;

    private float ay;

    private float az;

    private List<Float> covariance;

    private MavEstimatorType estimatorType;

    private Builder() {
    }

    /**
     * Timestamp (microseconds since system boot or since UNIX epoch) 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 8
    )
    public final Builder timeUsec(BigInteger timeUsec) {
      this.timeUsec = timeUsec;
      return this;
    }

    /**
     * X Position 
     */
    @MavlinkMessageField(
        position = 3,
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
        position = 4,
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
        position = 5,
        unitSize = 4
    )
    public final Builder z(float z) {
      this.z = z;
      return this;
    }

    /**
     * X Speed (m/s) 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 4
    )
    public final Builder vx(float vx) {
      this.vx = vx;
      return this;
    }

    /**
     * Y Speed (m/s) 
     */
    @MavlinkMessageField(
        position = 7,
        unitSize = 4
    )
    public final Builder vy(float vy) {
      this.vy = vy;
      return this;
    }

    /**
     * Z Speed (m/s) 
     */
    @MavlinkMessageField(
        position = 8,
        unitSize = 4
    )
    public final Builder vz(float vz) {
      this.vz = vz;
      return this;
    }

    /**
     * X Acceleration (m/s^2) 
     */
    @MavlinkMessageField(
        position = 9,
        unitSize = 4
    )
    public final Builder ax(float ax) {
      this.ax = ax;
      return this;
    }

    /**
     * Y Acceleration (m/s^2) 
     */
    @MavlinkMessageField(
        position = 10,
        unitSize = 4
    )
    public final Builder ay(float ay) {
      this.ay = ay;
      return this;
    }

    /**
     * Z Acceleration (m/s^2) 
     */
    @MavlinkMessageField(
        position = 11,
        unitSize = 4
    )
    public final Builder az(float az) {
      this.az = az;
      return this;
    }

    /**
     * Covariance matrix upper right triangular (first nine entries are the first ROW, next eight 
     * entries are the second row, etc.) 
     */
    @MavlinkMessageField(
        position = 12,
        unitSize = 4,
        arraySize = 45
    )
    public final Builder covariance(List<Float> covariance) {
      this.covariance = covariance;
      return this;
    }

    /**
     * Class id of the estimator this estimate originated from. 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 1
    )
    public final Builder estimatorType(MavEstimatorType estimatorType) {
      this.estimatorType = estimatorType;
      return this;
    }

    public final LocalPositionNedCov build() {
      return new LocalPositionNedCov(timeUsec, x, y, z, vx, vy, vz, ax, ay, az, covariance, estimatorType);
    }
  }
}
