package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.math.BigInteger;

/**
 * Simulated optical flow from a flow sensor (e.g. PX4FLOW or optical mouse sensor) 
 */
@MavlinkMessage(
    id = 114,
    crc = 237
)
public final class HilOpticalFlow {
  /**
   * Timestamp (microseconds, synced to UNIX time or since system boot) 
   */
  private final BigInteger timeUsec;

  /**
   * Sensor ID 
   */
  private final int sensorId;

  /**
   * Integration time in microseconds. Divide integrated_x and integrated_y by the integration 
   * time to obtain average flow. The integration time also indicates the. 
   */
  private final long integrationTimeUs;

  /**
   * Flow in radians around X axis (Sensor RH rotation about the X axis induces a positive flow. 
   * Sensor linear motion along the positive Y axis induces a negative flow.) 
   */
  private final float integratedX;

  /**
   * Flow in radians around Y axis (Sensor RH rotation about the Y axis induces a positive flow. 
   * Sensor linear motion along the positive X axis induces a positive flow.) 
   */
  private final float integratedY;

  /**
   * RH rotation around X axis (rad) 
   */
  private final float integratedXgyro;

  /**
   * RH rotation around Y axis (rad) 
   */
  private final float integratedYgyro;

  /**
   * RH rotation around Z axis (rad) 
   */
  private final float integratedZgyro;

  /**
   * Temperature * 100 in centi-degrees Celsius 
   */
  private final int temperature;

  /**
   * Optical flow quality / confidence. 0: no valid flow, 255: maximum quality 
   */
  private final int quality;

  /**
   * Time in microseconds since the distance was sampled. 
   */
  private final long timeDeltaDistanceUs;

  /**
   * Distance to the center of the flow field in meters. Positive value (including zero): distance 
   * known. Negative value: Unknown distance. 
   */
  private final float distance;

  private HilOpticalFlow(BigInteger timeUsec, int sensorId, long integrationTimeUs,
      float integratedX, float integratedY, float integratedXgyro, float integratedYgyro,
      float integratedZgyro, int temperature, int quality, long timeDeltaDistanceUs,
      float distance) {
    this.timeUsec = timeUsec;
    this.sensorId = sensorId;
    this.integrationTimeUs = integrationTimeUs;
    this.integratedX = integratedX;
    this.integratedY = integratedY;
    this.integratedXgyro = integratedXgyro;
    this.integratedYgyro = integratedYgyro;
    this.integratedZgyro = integratedZgyro;
    this.temperature = temperature;
    this.quality = quality;
    this.timeDeltaDistanceUs = timeDeltaDistanceUs;
    this.distance = distance;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (microseconds, synced to UNIX time or since system boot) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * Sensor ID 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int sensorId() {
    return sensorId;
  }

  /**
   * Integration time in microseconds. Divide integrated_x and integrated_y by the integration 
   * time to obtain average flow. The integration time also indicates the. 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final long integrationTimeUs() {
    return integrationTimeUs;
  }

  /**
   * Flow in radians around X axis (Sensor RH rotation about the X axis induces a positive flow. 
   * Sensor linear motion along the positive Y axis induces a negative flow.) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float integratedX() {
    return integratedX;
  }

  /**
   * Flow in radians around Y axis (Sensor RH rotation about the Y axis induces a positive flow. 
   * Sensor linear motion along the positive X axis induces a positive flow.) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float integratedY() {
    return integratedY;
  }

  /**
   * RH rotation around X axis (rad) 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float integratedXgyro() {
    return integratedXgyro;
  }

  /**
   * RH rotation around Y axis (rad) 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float integratedYgyro() {
    return integratedYgyro;
  }

  /**
   * RH rotation around Z axis (rad) 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float integratedZgyro() {
    return integratedZgyro;
  }

  /**
   * Temperature * 100 in centi-degrees Celsius 
   */
  @MavlinkMessageField(
      position = 9,
      length = 2
  )
  public final int temperature() {
    return temperature;
  }

  /**
   * Optical flow quality / confidence. 0: no valid flow, 255: maximum quality 
   */
  @MavlinkMessageField(
      position = 10,
      length = 1
  )
  public final int quality() {
    return quality;
  }

  /**
   * Time in microseconds since the distance was sampled. 
   */
  @MavlinkMessageField(
      position = 11,
      length = 4
  )
  public final long timeDeltaDistanceUs() {
    return timeDeltaDistanceUs;
  }

  /**
   * Distance to the center of the flow field in meters. Positive value (including zero): distance 
   * known. Negative value: Unknown distance. 
   */
  @MavlinkMessageField(
      position = 12,
      length = 4
  )
  public final float distance() {
    return distance;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private int sensorId;

    private long integrationTimeUs;

    private float integratedX;

    private float integratedY;

    private float integratedXgyro;

    private float integratedYgyro;

    private float integratedZgyro;

    private int temperature;

    private int quality;

    private long timeDeltaDistanceUs;

    private float distance;

    private Builder() {
    }

    /**
     * Timestamp (microseconds, synced to UNIX time or since system boot) 
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
     * Sensor ID 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder sensorId(int sensorId) {
      this.sensorId = sensorId;
      return this;
    }

    /**
     * Integration time in microseconds. Divide integrated_x and integrated_y by the integration 
     * time to obtain average flow. The integration time also indicates the. 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder integrationTimeUs(long integrationTimeUs) {
      this.integrationTimeUs = integrationTimeUs;
      return this;
    }

    /**
     * Flow in radians around X axis (Sensor RH rotation about the X axis induces a positive flow. 
     * Sensor linear motion along the positive Y axis induces a negative flow.) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder integratedX(float integratedX) {
      this.integratedX = integratedX;
      return this;
    }

    /**
     * Flow in radians around Y axis (Sensor RH rotation about the Y axis induces a positive flow. 
     * Sensor linear motion along the positive X axis induces a positive flow.) 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder integratedY(float integratedY) {
      this.integratedY = integratedY;
      return this;
    }

    /**
     * RH rotation around X axis (rad) 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder integratedXgyro(float integratedXgyro) {
      this.integratedXgyro = integratedXgyro;
      return this;
    }

    /**
     * RH rotation around Y axis (rad) 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder integratedYgyro(float integratedYgyro) {
      this.integratedYgyro = integratedYgyro;
      return this;
    }

    /**
     * RH rotation around Z axis (rad) 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4
    )
    public final Builder integratedZgyro(float integratedZgyro) {
      this.integratedZgyro = integratedZgyro;
      return this;
    }

    /**
     * Temperature * 100 in centi-degrees Celsius 
     */
    @MavlinkMessageField(
        position = 9,
        length = 2
    )
    public final Builder temperature(int temperature) {
      this.temperature = temperature;
      return this;
    }

    /**
     * Optical flow quality / confidence. 0: no valid flow, 255: maximum quality 
     */
    @MavlinkMessageField(
        position = 10,
        length = 1
    )
    public final Builder quality(int quality) {
      this.quality = quality;
      return this;
    }

    /**
     * Time in microseconds since the distance was sampled. 
     */
    @MavlinkMessageField(
        position = 11,
        length = 4
    )
    public final Builder timeDeltaDistanceUs(long timeDeltaDistanceUs) {
      this.timeDeltaDistanceUs = timeDeltaDistanceUs;
      return this;
    }

    /**
     * Distance to the center of the flow field in meters. Positive value (including zero): distance 
     * known. Negative value: Unknown distance. 
     */
    @MavlinkMessageField(
        position = 12,
        length = 4
    )
    public final Builder distance(float distance) {
      this.distance = distance;
      return this;
    }

    public final HilOpticalFlow build() {
      return new HilOpticalFlow(timeUsec, sensorId, integrationTimeUs, integratedX, integratedY, integratedXgyro, integratedYgyro, integratedZgyro, temperature, quality, timeDeltaDistanceUs, distance);
    }
  }
}
