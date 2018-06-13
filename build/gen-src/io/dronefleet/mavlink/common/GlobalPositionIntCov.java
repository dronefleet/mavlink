package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Float;
import java.math.BigInteger;
import java.util.List;

/**
 * The filtered global position (e.g. fused GPS and accelerometers). The position is in 
 * GPS-frame (right-handed, Z-up). It is designed as scaled integer message since the 
 * resolution of float is not sufficient. NOTE: This message is intended for onboard networks / 
 * companion computers and higher-bandwidth links and optimized for accuracy and 
 * completeness. Please use the GLOBAL_POSITION_INT message for a minimal subset. 
 */
@MavlinkMessage(
    id = 63,
    crc = 119
)
public final class GlobalPositionIntCov {
  private final BigInteger timeUsec;

  private final MavEstimatorType estimatorType;

  private final int lat;

  private final int lon;

  private final int alt;

  private final int relativeAlt;

  private final float vx;

  private final float vy;

  private final float vz;

  private final List<Float> covariance;

  private GlobalPositionIntCov(BigInteger timeUsec, MavEstimatorType estimatorType, int lat,
      int lon, int alt, int relativeAlt, float vx, float vy, float vz, List<Float> covariance) {
    this.timeUsec = timeUsec;
    this.estimatorType = estimatorType;
    this.lat = lat;
    this.lon = lon;
    this.alt = alt;
    this.relativeAlt = relativeAlt;
    this.vx = vx;
    this.vy = vy;
    this.vz = vz;
    this.covariance = covariance;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (microseconds since system boot or since UNIX epoch) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * Class id of the estimator this estimate originated from. 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final MavEstimatorType estimatorType() {
    return estimatorType;
  }

  /**
   * Latitude, expressed as degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final int lat() {
    return lat;
  }

  /**
   * Longitude, expressed as degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final int lon() {
    return lon;
  }

  /**
   * Altitude in meters, expressed as * 1000 (millimeters), above MSL 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final int alt() {
    return alt;
  }

  /**
   * Altitude above ground in meters, expressed as * 1000 (millimeters) 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final int relativeAlt() {
    return relativeAlt;
  }

  /**
   * Ground X Speed (Latitude), expressed as m/s 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float vx() {
    return vx;
  }

  /**
   * Ground Y Speed (Longitude), expressed as m/s 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float vy() {
    return vy;
  }

  /**
   * Ground Z Speed (Altitude), expressed as m/s 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final float vz() {
    return vz;
  }

  /**
   * Covariance matrix (first six entries are the first ROW, next six entries are the second row, 
   * etc.) 
   */
  @MavlinkMessageField(
      position = 10,
      length = 4,
      arraySize = 36
  )
  public final List<Float> covariance() {
    return covariance;
  }

  public class Builder {
    private BigInteger timeUsec;

    private MavEstimatorType estimatorType;

    private int lat;

    private int lon;

    private int alt;

    private int relativeAlt;

    private float vx;

    private float vy;

    private float vz;

    private List<Float> covariance;

    private Builder() {
    }

    /**
     * Timestamp (microseconds since system boot or since UNIX epoch) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 8
    )
    public final Builder timeUsec(BigInteger timeUsec) {
      this.timeUsec = timeUsec;
      return this;
    }

    /**
     * Class id of the estimator this estimate originated from. 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder estimatorType(MavEstimatorType estimatorType) {
      this.estimatorType = estimatorType;
      return this;
    }

    /**
     * Latitude, expressed as degrees * 1E7 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder lat(int lat) {
      this.lat = lat;
      return this;
    }

    /**
     * Longitude, expressed as degrees * 1E7 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder lon(int lon) {
      this.lon = lon;
      return this;
    }

    /**
     * Altitude in meters, expressed as * 1000 (millimeters), above MSL 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder alt(int alt) {
      this.alt = alt;
      return this;
    }

    /**
     * Altitude above ground in meters, expressed as * 1000 (millimeters) 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder relativeAlt(int relativeAlt) {
      this.relativeAlt = relativeAlt;
      return this;
    }

    /**
     * Ground X Speed (Latitude), expressed as m/s 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder vx(float vx) {
      this.vx = vx;
      return this;
    }

    /**
     * Ground Y Speed (Longitude), expressed as m/s 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4
    )
    public final Builder vy(float vy) {
      this.vy = vy;
      return this;
    }

    /**
     * Ground Z Speed (Altitude), expressed as m/s 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4
    )
    public final Builder vz(float vz) {
      this.vz = vz;
      return this;
    }

    /**
     * Covariance matrix (first six entries are the first ROW, next six entries are the second row, 
     * etc.) 
     */
    @MavlinkMessageField(
        position = 10,
        length = 4,
        arraySize = 36
    )
    public final Builder covariance(List<Float> covariance) {
      this.covariance = covariance;
      return this;
    }

    public final GlobalPositionIntCov build() {
      return new GlobalPositionIntCov(timeUsec, estimatorType, lat, lon, alt, relativeAlt, vx, vy, vz, covariance);
    }
  }
}
