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
 * current motion information from a designated system 
 */
@MavlinkMessage(
    id = 144,
    crc = 127
)
public final class FollowTarget {
  /**
   * Timestamp in milliseconds since system boot 
   */
  private final BigInteger timestamp;

  /**
   * button states or switches of a tracker device 
   */
  private final BigInteger customState;

  /**
   * Latitude (WGS84), in degrees * 1E7 
   */
  private final int lat;

  /**
   * Longitude (WGS84), in degrees * 1E7 
   */
  private final int lon;

  /**
   * AMSL, in meters 
   */
  private final float alt;

  /**
   * target velocity (0,0,0) for unknown 
   */
  private final List<Float> vel;

  /**
   * linear target acceleration (0,0,0) for unknown 
   */
  private final List<Float> acc;

  /**
   * (1 0 0 0 for unknown) 
   */
  private final List<Float> attitudeQ;

  /**
   * (0 0 0 for unknown) 
   */
  private final List<Float> rates;

  /**
   * eph epv 
   */
  private final List<Float> positionCov;

  /**
   * bit positions for tracker reporting capabilities (POS = 0, VEL = 1, ACCEL = 2, ATT + RATES = 3) 
   */
  private final int estCapabilities;

  private FollowTarget(BigInteger timestamp, BigInteger customState, int lat, int lon, float alt,
      List<Float> vel, List<Float> acc, List<Float> attitudeQ, List<Float> rates,
      List<Float> positionCov, int estCapabilities) {
    this.timestamp = timestamp;
    this.customState = customState;
    this.lat = lat;
    this.lon = lon;
    this.alt = alt;
    this.vel = vel;
    this.acc = acc;
    this.attitudeQ = attitudeQ;
    this.rates = rates;
    this.positionCov = positionCov;
    this.estCapabilities = estCapabilities;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "FollowTarget{timestamp=" + timestamp
         + ", estCapabilities=" + estCapabilities
         + ", lat=" + lat
         + ", lon=" + lon
         + ", alt=" + alt
         + ", vel=" + vel
         + ", acc=" + acc
         + ", attitudeQ=" + attitudeQ
         + ", rates=" + rates
         + ", positionCov=" + positionCov
         + ", customState=" + customState + "}";
  }

  /**
   * Timestamp in milliseconds since system boot 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 8
  )
  public final BigInteger timestamp() {
    return timestamp;
  }

  /**
   * button states or switches of a tracker device 
   */
  @MavlinkMessageField(
      position = 11,
      unitSize = 8
  )
  public final BigInteger customState() {
    return customState;
  }

  /**
   * Latitude (WGS84), in degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final int lat() {
    return lat;
  }

  /**
   * Longitude (WGS84), in degrees * 1E7 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final int lon() {
    return lon;
  }

  /**
   * AMSL, in meters 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 4
  )
  public final float alt() {
    return alt;
  }

  /**
   * target velocity (0,0,0) for unknown 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 4,
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
      unitSize = 4,
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
      unitSize = 4,
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
      unitSize = 4,
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
      unitSize = 4,
      arraySize = 3
  )
  public final List<Float> positionCov() {
    return positionCov;
  }

  /**
   * bit positions for tracker reporting capabilities (POS = 0, VEL = 1, ACCEL = 2, ATT + RATES = 3) 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final int estCapabilities() {
    return estCapabilities;
  }

  public static class Builder {
    private BigInteger timestamp;

    private BigInteger customState;

    private int lat;

    private int lon;

    private float alt;

    private List<Float> vel;

    private List<Float> acc;

    private List<Float> attitudeQ;

    private List<Float> rates;

    private List<Float> positionCov;

    private int estCapabilities;

    private Builder() {
    }

    /**
     * Timestamp in milliseconds since system boot 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 8
    )
    public final Builder timestamp(BigInteger timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    /**
     * button states or switches of a tracker device 
     */
    @MavlinkMessageField(
        position = 11,
        unitSize = 8
    )
    public final Builder customState(BigInteger customState) {
      this.customState = customState;
      return this;
    }

    /**
     * Latitude (WGS84), in degrees * 1E7 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 4
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
        unitSize = 4
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
        unitSize = 4
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
        unitSize = 4,
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
        unitSize = 4,
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
        unitSize = 4,
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
        unitSize = 4,
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
        unitSize = 4,
        arraySize = 3
    )
    public final Builder positionCov(List<Float> positionCov) {
      this.positionCov = positionCov;
      return this;
    }

    /**
     * bit positions for tracker reporting capabilities (POS = 0, VEL = 1, ACCEL = 2, ATT + RATES = 3) 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 1
    )
    public final Builder estCapabilities(int estCapabilities) {
      this.estCapabilities = estCapabilities;
      return this;
    }

    public final FollowTarget build() {
      return new FollowTarget(timestamp, customState, lat, lon, alt, vel, acc, attitudeQ, rates, positionCov, estCapabilities);
    }
  }
}
