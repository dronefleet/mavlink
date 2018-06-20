package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;

/**
 * The filtered global position (e.g. fused GPS and accelerometers). The position is in 
 * GPS-frame (right-handed, Z-up). It is designed as scaled integer message since the 
 * resolution of float is not sufficient. NOTE: This message is intended for onboard networks / 
 * companion computers and higher-bandwidth links and optimized for accuracy and 
 * completeness. Please use the {@link io.dronefleet.mavlink.common.GlobalPositionInt GlobalPositionInt} message for a minimal subset. 
 */
@MavlinkMessageInfo(
    id = 63,
    crc = 119
)
public final class GlobalPositionIntCov {
  /**
   * Timestamp (microseconds since system boot or since UNIX epoch) 
   */
  private final BigInteger timeUsec;

  /**
   * Latitude, expressed as degrees * 1E7 
   */
  private final int lat;

  /**
   * Longitude, expressed as degrees * 1E7 
   */
  private final int lon;

  /**
   * Altitude in meters, expressed as * 1000 (millimeters), above MSL 
   */
  private final int alt;

  /**
   * Altitude above ground in meters, expressed as * 1000 (millimeters) 
   */
  private final int relativeAlt;

  /**
   * Ground X Speed (Latitude), expressed as m/s 
   */
  private final float vx;

  /**
   * Ground Y Speed (Longitude), expressed as m/s 
   */
  private final float vy;

  /**
   * Ground Z Speed (Altitude), expressed as m/s 
   */
  private final float vz;

  /**
   * Covariance matrix (first six entries are the first ROW, next six entries are the second row, 
   * etc.) 
   */
  private final List<Float> covariance;

  /**
   * Class id of the estimator this estimate originated from. 
   */
  private final MavEstimatorType estimatorType;

  private GlobalPositionIntCov(BigInteger timeUsec, int lat, int lon, int alt, int relativeAlt,
      float vx, float vy, float vz, List<Float> covariance, MavEstimatorType estimatorType) {
    this.timeUsec = timeUsec;
    this.lat = lat;
    this.lon = lon;
    this.alt = alt;
    this.relativeAlt = relativeAlt;
    this.vx = vx;
    this.vy = vy;
    this.vz = vz;
    this.covariance = covariance;
    this.estimatorType = estimatorType;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "GlobalPositionIntCov{timeUsec=" + timeUsec
         + ", estimatorType=" + estimatorType
         + ", lat=" + lat
         + ", lon=" + lon
         + ", alt=" + alt
         + ", relativeAlt=" + relativeAlt
         + ", vx=" + vx
         + ", vy=" + vy
         + ", vz=" + vz
         + ", covariance=" + covariance + "}";
  }

  /**
   * Timestamp (microseconds since system boot or since UNIX epoch) 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * Latitude, expressed as degrees * 1E7 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 4
  )
  public final int lat() {
    return lat;
  }

  /**
   * Longitude, expressed as degrees * 1E7 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 4
  )
  public final int lon() {
    return lon;
  }

  /**
   * Altitude in meters, expressed as * 1000 (millimeters), above MSL 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final int alt() {
    return alt;
  }

  /**
   * Altitude above ground in meters, expressed as * 1000 (millimeters) 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 4
  )
  public final int relativeAlt() {
    return relativeAlt;
  }

  /**
   * Ground X Speed (Latitude), expressed as m/s 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 4
  )
  public final float vx() {
    return vx;
  }

  /**
   * Ground Y Speed (Longitude), expressed as m/s 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 4
  )
  public final float vy() {
    return vy;
  }

  /**
   * Ground Z Speed (Altitude), expressed as m/s 
   */
  @MavlinkFieldInfo(
      position = 9,
      unitSize = 4
  )
  public final float vz() {
    return vz;
  }

  /**
   * Covariance matrix (first six entries are the first ROW, next six entries are the second row, 
   * etc.) 
   */
  @MavlinkFieldInfo(
      position = 10,
      unitSize = 4,
      arraySize = 36
  )
  public final List<Float> covariance() {
    return covariance;
  }

  /**
   * Class id of the estimator this estimate originated from. 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final MavEstimatorType estimatorType() {
    return estimatorType;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private int lat;

    private int lon;

    private int alt;

    private int relativeAlt;

    private float vx;

    private float vy;

    private float vz;

    private List<Float> covariance;

    private MavEstimatorType estimatorType;

    private Builder() {
    }

    /**
     * Timestamp (microseconds since system boot or since UNIX epoch) 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 8
    )
    public final Builder timeUsec(BigInteger timeUsec) {
      this.timeUsec = timeUsec;
      return this;
    }

    /**
     * Latitude, expressed as degrees * 1E7 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 4
    )
    public final Builder lat(int lat) {
      this.lat = lat;
      return this;
    }

    /**
     * Longitude, expressed as degrees * 1E7 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 4
    )
    public final Builder lon(int lon) {
      this.lon = lon;
      return this;
    }

    /**
     * Altitude in meters, expressed as * 1000 (millimeters), above MSL 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder alt(int alt) {
      this.alt = alt;
      return this;
    }

    /**
     * Altitude above ground in meters, expressed as * 1000 (millimeters) 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 4
    )
    public final Builder relativeAlt(int relativeAlt) {
      this.relativeAlt = relativeAlt;
      return this;
    }

    /**
     * Ground X Speed (Latitude), expressed as m/s 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 4
    )
    public final Builder vx(float vx) {
      this.vx = vx;
      return this;
    }

    /**
     * Ground Y Speed (Longitude), expressed as m/s 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 4
    )
    public final Builder vy(float vy) {
      this.vy = vy;
      return this;
    }

    /**
     * Ground Z Speed (Altitude), expressed as m/s 
     */
    @MavlinkFieldInfo(
        position = 9,
        unitSize = 4
    )
    public final Builder vz(float vz) {
      this.vz = vz;
      return this;
    }

    /**
     * Covariance matrix (first six entries are the first ROW, next six entries are the second row, 
     * etc.) 
     */
    @MavlinkFieldInfo(
        position = 10,
        unitSize = 4,
        arraySize = 36
    )
    public final Builder covariance(List<Float> covariance) {
      this.covariance = covariance;
      return this;
    }

    /**
     * Class id of the estimator this estimate originated from. 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder estimatorType(MavEstimatorType estimatorType) {
      this.estimatorType = estimatorType;
      return this;
    }

    public final GlobalPositionIntCov build() {
      return new GlobalPositionIntCov(timeUsec, lat, lon, alt, relativeAlt, vx, vy, vz, covariance, estimatorType);
    }
  }
}
