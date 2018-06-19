package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;
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
   * Time in microseconds since the distance was sampled. 
   */
  private final long timeDeltaDistanceUs;

  /**
   * Distance to the center of the flow field in meters. Positive value (including zero): distance 
   * known. Negative value: Unknown distance. 
   */
  private final float distance;

  /**
   * Temperature * 100 in centi-degrees Celsius 
   */
  private final int temperature;

  /**
   * Sensor ID 
   */
  private final int sensorId;

  /**
   * Optical flow quality / confidence. 0: no valid flow, 255: maximum quality 
   */
  private final int quality;

  private HilOpticalFlow(BigInteger timeUsec, long integrationTimeUs, float integratedX,
      float integratedY, float integratedXgyro, float integratedYgyro, float integratedZgyro,
      long timeDeltaDistanceUs, float distance, int temperature, int sensorId, int quality) {
    this.timeUsec = timeUsec;
    this.integrationTimeUs = integrationTimeUs;
    this.integratedX = integratedX;
    this.integratedY = integratedY;
    this.integratedXgyro = integratedXgyro;
    this.integratedYgyro = integratedYgyro;
    this.integratedZgyro = integratedZgyro;
    this.timeDeltaDistanceUs = timeDeltaDistanceUs;
    this.distance = distance;
    this.temperature = temperature;
    this.sensorId = sensorId;
    this.quality = quality;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "HilOpticalFlow{timeUsec=" + timeUsec
         + ", sensorId=" + sensorId
         + ", integrationTimeUs=" + integrationTimeUs
         + ", integratedX=" + integratedX
         + ", integratedY=" + integratedY
         + ", integratedXgyro=" + integratedXgyro
         + ", integratedYgyro=" + integratedYgyro
         + ", integratedZgyro=" + integratedZgyro
         + ", temperature=" + temperature
         + ", quality=" + quality
         + ", timeDeltaDistanceUs=" + timeDeltaDistanceUs
         + ", distance=" + distance + "}";
  }

  /**
   * Timestamp (microseconds, synced to UNIX time or since system boot) 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * Integration time in microseconds. Divide integrated_x and integrated_y by the integration 
   * time to obtain average flow. The integration time also indicates the. 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
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
      unitSize = 4
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
      unitSize = 4
  )
  public final float integratedY() {
    return integratedY;
  }

  /**
   * RH rotation around X axis (rad) 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 4
  )
  public final float integratedXgyro() {
    return integratedXgyro;
  }

  /**
   * RH rotation around Y axis (rad) 
   */
  @MavlinkMessageField(
      position = 7,
      unitSize = 4
  )
  public final float integratedYgyro() {
    return integratedYgyro;
  }

  /**
   * RH rotation around Z axis (rad) 
   */
  @MavlinkMessageField(
      position = 8,
      unitSize = 4
  )
  public final float integratedZgyro() {
    return integratedZgyro;
  }

  /**
   * Time in microseconds since the distance was sampled. 
   */
  @MavlinkMessageField(
      position = 11,
      unitSize = 4
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
      unitSize = 4
  )
  public final float distance() {
    return distance;
  }

  /**
   * Temperature * 100 in centi-degrees Celsius 
   */
  @MavlinkMessageField(
      position = 9,
      unitSize = 2
  )
  public final int temperature() {
    return temperature;
  }

  /**
   * Sensor ID 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final int sensorId() {
    return sensorId;
  }

  /**
   * Optical flow quality / confidence. 0: no valid flow, 255: maximum quality 
   */
  @MavlinkMessageField(
      position = 10,
      unitSize = 1
  )
  public final int quality() {
    return quality;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private long integrationTimeUs;

    private float integratedX;

    private float integratedY;

    private float integratedXgyro;

    private float integratedYgyro;

    private float integratedZgyro;

    private long timeDeltaDistanceUs;

    private float distance;

    private int temperature;

    private int sensorId;

    private int quality;

    private Builder() {
    }

    /**
     * Timestamp (microseconds, synced to UNIX time or since system boot) 
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
     * Integration time in microseconds. Divide integrated_x and integrated_y by the integration 
     * time to obtain average flow. The integration time also indicates the. 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 4
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
        unitSize = 4
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
        unitSize = 4
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
        unitSize = 4
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
        unitSize = 4
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
        unitSize = 4
    )
    public final Builder integratedZgyro(float integratedZgyro) {
      this.integratedZgyro = integratedZgyro;
      return this;
    }

    /**
     * Time in microseconds since the distance was sampled. 
     */
    @MavlinkMessageField(
        position = 11,
        unitSize = 4
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
        unitSize = 4
    )
    public final Builder distance(float distance) {
      this.distance = distance;
      return this;
    }

    /**
     * Temperature * 100 in centi-degrees Celsius 
     */
    @MavlinkMessageField(
        position = 9,
        unitSize = 2
    )
    public final Builder temperature(int temperature) {
      this.temperature = temperature;
      return this;
    }

    /**
     * Sensor ID 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 1
    )
    public final Builder sensorId(int sensorId) {
      this.sensorId = sensorId;
      return this;
    }

    /**
     * Optical flow quality / confidence. 0: no valid flow, 255: maximum quality 
     */
    @MavlinkMessageField(
        position = 10,
        unitSize = 1
    )
    public final Builder quality(int quality) {
      this.quality = quality;
      return this;
    }

    public final HilOpticalFlow build() {
      return new HilOpticalFlow(timeUsec, integrationTimeUs, integratedX, integratedY, integratedXgyro, integratedYgyro, integratedZgyro, timeDeltaDistanceUs, distance, temperature, sensorId, quality);
    }
  }
}
