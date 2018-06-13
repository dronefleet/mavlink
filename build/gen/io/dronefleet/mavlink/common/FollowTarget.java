package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Float;
import java.math.BigInteger;
import java.util.List;

/**
 * current motion information from a designated system 
 */
@MavlinkMessage(
    id = 144,
    crc = 127
)
public final class FollowTarget {
  private final BigInteger timestamp;

  private final int estCapabilities;

  private final int lat;

  private final int lon;

  private final float alt;

  private final List<Float> vel;

  private final List<Float> acc;

  private final List<Float> attitudeQ;

  private final List<Float> rates;

  private final List<Float> positionCov;

  private final BigInteger customState;

  private FollowTarget(BigInteger timestamp, int estCapabilities, int lat, int lon, float alt,
      List<Float> vel, List<Float> acc, List<Float> attitudeQ, List<Float> rates,
      List<Float> positionCov, BigInteger customState) {
    this.timestamp = timestamp;
    this.estCapabilities = estCapabilities;
    this.lat = lat;
    this.lon = lon;
    this.alt = alt;
    this.vel = vel;
    this.acc = acc;
    this.attitudeQ = attitudeQ;
    this.rates = rates;
    this.positionCov = positionCov;
    this.customState = customState;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp in milliseconds since system boot 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger timestamp() {
    return timestamp;
  }

  /**
   * bit positions for tracker reporting capabilities (POS = 0, VEL = 1, ACCEL = 2, ATT + RATES = 3) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int estCapabilities() {
    return estCapabilities;
  }

  /**
   * Latitude (WGS84), in degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final int lat() {
    return lat;
  }

  /**
   * Longitude (WGS84), in degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final int lon() {
    return lon;
  }

  /**
   * AMSL, in meters 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float alt() {
    return alt;
  }

  /**
   * target velocity (0,0,0) for unknown 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4,
      arraySize = 3
  )
  public final List<Float> vel() {
    return vel;
  }

  /**
   * linear target acceleration (0,0,0) for unknown 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4,
      arraySize = 3
  )
  public final List<Float> acc() {
    return acc;
  }

  /**
   * (1 0 0 0 for unknown) 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4,
      arraySize = 4
  )
  public final List<Float> attitudeQ() {
    return attitudeQ;
  }

  /**
   * (0 0 0 for unknown) 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4,
      arraySize = 3
  )
  public final List<Float> rates() {
    return rates;
  }

  /**
   * eph epv 
   */
  @MavlinkMessageField(
      position = 10,
      length = 4,
      arraySize = 3
  )
  public final List<Float> positionCov() {
    return positionCov;
  }

  /**
   * button states or switches of a tracker device 
   */
  @MavlinkMessageField(
      position = 11,
      length = 8
  )
  public final BigInteger customState() {
    return customState;
  }

  public class Builder {
    private BigInteger timestamp;

    private int estCapabilities;

    private int lat;

    private int lon;

    private float alt;

    private List<Float> vel;

    private List<Float> acc;

    private List<Float> attitudeQ;

    private List<Float> rates;

    private List<Float> positionCov;

    private BigInteger customState;

    private Builder() {
    }

    /**
     * Timestamp in milliseconds since system boot 
     */
    @MavlinkMessageField(
        position = 1,
        length = 8
    )
    public final Builder timestamp(BigInteger timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    /**
     * bit positions for tracker reporting capabilities (POS = 0, VEL = 1, ACCEL = 2, ATT + RATES = 3) 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder estCapabilities(int estCapabilities) {
      this.estCapabilities = estCapabilities;
      return this;
    }

    /**
     * Latitude (WGS84), in degrees * 1E7 
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
     * Longitude (WGS84), in degrees * 1E7 
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
     * AMSL, in meters 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder alt(float alt) {
      this.alt = alt;
      return this;
    }

    /**
     * target velocity (0,0,0) for unknown 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4,
        arraySize = 3
    )
    public final Builder vel(List<Float> vel) {
      this.vel = vel;
      return this;
    }

    /**
     * linear target acceleration (0,0,0) for unknown 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4,
        arraySize = 3
    )
    public final Builder acc(List<Float> acc) {
      this.acc = acc;
      return this;
    }

    /**
     * (1 0 0 0 for unknown) 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4,
        arraySize = 4
    )
    public final Builder attitudeQ(List<Float> attitudeQ) {
      this.attitudeQ = attitudeQ;
      return this;
    }

    /**
     * (0 0 0 for unknown) 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4,
        arraySize = 3
    )
    public final Builder rates(List<Float> rates) {
      this.rates = rates;
      return this;
    }

    /**
     * eph epv 
     */
    @MavlinkMessageField(
        position = 10,
        length = 4,
        arraySize = 3
    )
    public final Builder positionCov(List<Float> positionCov) {
      this.positionCov = positionCov;
      return this;
    }

    /**
     * button states or switches of a tracker device 
     */
    @MavlinkMessageField(
        position = 11,
        length = 8
    )
    public final Builder customState(BigInteger customState) {
      this.customState = customState;
      return this;
    }

    public final FollowTarget build() {
      return new FollowTarget(timestamp, estCapabilities, lat, lon, alt, vel, acc, attitudeQ, rates, positionCov, customState);
    }
  }
}
