package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * Optical flow from a flow sensor (e.g. optical mouse sensor) 
 */
@MavlinkMessageInfo(
    id = 100,
    crc = 175
)
public final class OpticalFlow {
  /**
   * Timestamp (UNIX) 
   */
  private final BigInteger timeUsec;

  /**
   * Flow in meters in x-sensor direction, angular-speed compensated 
   */
  private final float flowCompMX;

  /**
   * Flow in meters in y-sensor direction, angular-speed compensated 
   */
  private final float flowCompMY;

  /**
   * Ground distance in meters. Positive value: distance known. Negative value: Unknown distance 
   */
  private final float groundDistance;

  /**
   * Flow in pixels * 10 in x-sensor direction (dezi-pixels) 
   */
  private final int flowX;

  /**
   * Flow in pixels * 10 in y-sensor direction (dezi-pixels) 
   */
  private final int flowY;

  /**
   * Sensor ID 
   */
  private final int sensorId;

  /**
   * Optical flow quality / confidence. 0: bad, 255: maximum quality 
   */
  private final int quality;

  /**
   * Flow rate in radians/second about X axis 
   */
  private final float flowRateX;

  /**
   * Flow rate in radians/second about Y axis 
   */
  private final float flowRateY;

  private OpticalFlow(BigInteger timeUsec, float flowCompMX, float flowCompMY, float groundDistance,
      int flowX, int flowY, int sensorId, int quality, float flowRateX, float flowRateY) {
    this.timeUsec = timeUsec;
    this.flowCompMX = flowCompMX;
    this.flowCompMY = flowCompMY;
    this.groundDistance = groundDistance;
    this.flowX = flowX;
    this.flowY = flowY;
    this.sensorId = sensorId;
    this.quality = quality;
    this.flowRateX = flowRateX;
    this.flowRateY = flowRateY;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "OpticalFlow{timeUsec=" + timeUsec
         + ", sensorId=" + sensorId
         + ", flowX=" + flowX
         + ", flowY=" + flowY
         + ", flowCompMX=" + flowCompMX
         + ", flowCompMY=" + flowCompMY
         + ", quality=" + quality
         + ", groundDistance=" + groundDistance
         + ", flowRateX=" + flowRateX
         + ", flowRateY=" + flowRateY + "}";
  }

  /**
   * Timestamp (UNIX) 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * Flow in meters in x-sensor direction, angular-speed compensated 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final float flowCompMX() {
    return flowCompMX;
  }

  /**
   * Flow in meters in y-sensor direction, angular-speed compensated 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 4
  )
  public final float flowCompMY() {
    return flowCompMY;
  }

  /**
   * Ground distance in meters. Positive value: distance known. Negative value: Unknown distance 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 4
  )
  public final float groundDistance() {
    return groundDistance;
  }

  /**
   * Flow in pixels * 10 in x-sensor direction (dezi-pixels) 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 2
  )
  public final int flowX() {
    return flowX;
  }

  /**
   * Flow in pixels * 10 in y-sensor direction (dezi-pixels) 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 2
  )
  public final int flowY() {
    return flowY;
  }

  /**
   * Sensor ID 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final int sensorId() {
    return sensorId;
  }

  /**
   * Optical flow quality / confidence. 0: bad, 255: maximum quality 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 1
  )
  public final int quality() {
    return quality;
  }

  /**
   * Flow rate in radians/second about X axis 
   */
  @MavlinkFieldInfo(
      position = 10,
      unitSize = 4,
      extension = true
  )
  public final float flowRateX() {
    return flowRateX;
  }

  /**
   * Flow rate in radians/second about Y axis 
   */
  @MavlinkFieldInfo(
      position = 11,
      unitSize = 4,
      extension = true
  )
  public final float flowRateY() {
    return flowRateY;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private float flowCompMX;

    private float flowCompMY;

    private float groundDistance;

    private int flowX;

    private int flowY;

    private int sensorId;

    private int quality;

    private float flowRateX;

    private float flowRateY;

    private Builder() {
    }

    /**
     * Timestamp (UNIX) 
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
     * Flow in meters in x-sensor direction, angular-speed compensated 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder flowCompMX(float flowCompMX) {
      this.flowCompMX = flowCompMX;
      return this;
    }

    /**
     * Flow in meters in y-sensor direction, angular-speed compensated 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 4
    )
    public final Builder flowCompMY(float flowCompMY) {
      this.flowCompMY = flowCompMY;
      return this;
    }

    /**
     * Ground distance in meters. Positive value: distance known. Negative value: Unknown distance 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 4
    )
    public final Builder groundDistance(float groundDistance) {
      this.groundDistance = groundDistance;
      return this;
    }

    /**
     * Flow in pixels * 10 in x-sensor direction (dezi-pixels) 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 2
    )
    public final Builder flowX(int flowX) {
      this.flowX = flowX;
      return this;
    }

    /**
     * Flow in pixels * 10 in y-sensor direction (dezi-pixels) 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 2
    )
    public final Builder flowY(int flowY) {
      this.flowY = flowY;
      return this;
    }

    /**
     * Sensor ID 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder sensorId(int sensorId) {
      this.sensorId = sensorId;
      return this;
    }

    /**
     * Optical flow quality / confidence. 0: bad, 255: maximum quality 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 1
    )
    public final Builder quality(int quality) {
      this.quality = quality;
      return this;
    }

    /**
     * Flow rate in radians/second about X axis 
     */
    @MavlinkFieldInfo(
        position = 10,
        unitSize = 4,
        extension = true
    )
    public final Builder flowRateX(float flowRateX) {
      this.flowRateX = flowRateX;
      return this;
    }

    /**
     * Flow rate in radians/second about Y axis 
     */
    @MavlinkFieldInfo(
        position = 11,
        unitSize = 4,
        extension = true
    )
    public final Builder flowRateY(float flowRateY) {
      this.flowRateY = flowRateY;
      return this;
    }

    public final OpticalFlow build() {
      return new OpticalFlow(timeUsec, flowCompMX, flowCompMY, groundDistance, flowX, flowY, sensorId, quality, flowRateX, flowRateY);
    }
  }
}
