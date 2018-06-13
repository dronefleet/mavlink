package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.math.BigInteger;

/**
 * Optical flow from a flow sensor (e.g. optical mouse sensor) 
 */
@MavlinkMessage(
    id = 100,
    crc = 175
)
public final class OpticalFlow {
  private final BigInteger timeUsec;

  private final int sensorId;

  private final int flowX;

  private final int flowY;

  private final float flowCompMX;

  private final float flowCompMY;

  private final int quality;

  private final float groundDistance;

  private final float flowRateX;

  private final float flowRateY;

  private OpticalFlow(BigInteger timeUsec, int sensorId, int flowX, int flowY, float flowCompMX,
      float flowCompMY, int quality, float groundDistance, float flowRateX, float flowRateY) {
    this.timeUsec = timeUsec;
    this.sensorId = sensorId;
    this.flowX = flowX;
    this.flowY = flowY;
    this.flowCompMX = flowCompMX;
    this.flowCompMY = flowCompMY;
    this.quality = quality;
    this.groundDistance = groundDistance;
    this.flowRateX = flowRateX;
    this.flowRateY = flowRateY;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (UNIX) 
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
   * Flow in pixels * 10 in x-sensor direction (dezi-pixels) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int flowX() {
    return flowX;
  }

  /**
   * Flow in pixels * 10 in y-sensor direction (dezi-pixels) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int flowY() {
    return flowY;
  }

  /**
   * Flow in meters in x-sensor direction, angular-speed compensated 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float flowCompMX() {
    return flowCompMX;
  }

  /**
   * Flow in meters in y-sensor direction, angular-speed compensated 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float flowCompMY() {
    return flowCompMY;
  }

  /**
   * Optical flow quality / confidence. 0: bad, 255: maximum quality 
   */
  @MavlinkMessageField(
      position = 7,
      length = 1
  )
  public final int quality() {
    return quality;
  }

  /**
   * Ground distance in meters. Positive value: distance known. Negative value: Unknown distance 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float groundDistance() {
    return groundDistance;
  }

  /**
   * Flow rate in radians/second about X axis 
   */
  @MavlinkMessageField(
      position = 10,
      length = 4,
      extension = true
  )
  public final float flowRateX() {
    return flowRateX;
  }

  /**
   * Flow rate in radians/second about Y axis 
   */
  @MavlinkMessageField(
      position = 11,
      length = 4,
      extension = true
  )
  public final float flowRateY() {
    return flowRateY;
  }

  public class Builder {
    private BigInteger timeUsec;

    private int sensorId;

    private int flowX;

    private int flowY;

    private float flowCompMX;

    private float flowCompMY;

    private int quality;

    private float groundDistance;

    private float flowRateX;

    private float flowRateY;

    private Builder() {
    }

    /**
     * Timestamp (UNIX) 
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
     * Flow in pixels * 10 in x-sensor direction (dezi-pixels) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder flowX(int flowX) {
      this.flowX = flowX;
      return this;
    }

    /**
     * Flow in pixels * 10 in y-sensor direction (dezi-pixels) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder flowY(int flowY) {
      this.flowY = flowY;
      return this;
    }

    /**
     * Flow in meters in x-sensor direction, angular-speed compensated 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder flowCompMX(float flowCompMX) {
      this.flowCompMX = flowCompMX;
      return this;
    }

    /**
     * Flow in meters in y-sensor direction, angular-speed compensated 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder flowCompMY(float flowCompMY) {
      this.flowCompMY = flowCompMY;
      return this;
    }

    /**
     * Optical flow quality / confidence. 0: bad, 255: maximum quality 
     */
    @MavlinkMessageField(
        position = 7,
        length = 1
    )
    public final Builder quality(int quality) {
      this.quality = quality;
      return this;
    }

    /**
     * Ground distance in meters. Positive value: distance known. Negative value: Unknown distance 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4
    )
    public final Builder groundDistance(float groundDistance) {
      this.groundDistance = groundDistance;
      return this;
    }

    /**
     * Flow rate in radians/second about X axis 
     */
    @MavlinkMessageField(
        position = 10,
        length = 4,
        extension = true
    )
    public final Builder flowRateX(float flowRateX) {
      this.flowRateX = flowRateX;
      return this;
    }

    /**
     * Flow rate in radians/second about Y axis 
     */
    @MavlinkMessageField(
        position = 11,
        length = 4,
        extension = true
    )
    public final Builder flowRateY(float flowRateY) {
      this.flowRateY = flowRateY;
      return this;
    }

    public final OpticalFlow build() {
      return new OpticalFlow(timeUsec, sensorId, flowX, flowY, flowCompMX, flowCompMY, quality, groundDistance, flowRateX, flowRateY);
    }
  }
}
