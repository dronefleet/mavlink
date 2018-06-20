package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * null
 */
@MavlinkMessageInfo(
    id = 132,
    crc = 85
)
public final class DistanceSensor {
  /**
   * Time since system boot 
   */
  private final long timeBootMs;

  /**
   * Minimum distance the sensor can measure in centimeters 
   */
  private final int minDistance;

  /**
   * Maximum distance the sensor can measure in centimeters 
   */
  private final int maxDistance;

  /**
   * Current distance reading 
   */
  private final int currentDistance;

  /**
   * Type from {@link io.dronefleet.mavlink.common.MavDistanceSensor MavDistanceSensor} enum. 
   */
  private final MavDistanceSensor type;

  /**
   * Onboard ID of the sensor 
   */
  private final int id;

  /**
   * Direction the sensor faces from {@link io.dronefleet.mavlink.common.MavSensorOrientation MavSensorOrientation} enum. downward-facing: 
   * ROTATION_PITCH_270, upward-facing: ROTATION_PITCH_90, backward-facing: 
   * ROTATION_PITCH_180, forward-facing: ROTATION_NONE, left-facing: ROTATION_YAW_90, 
   * right-facing: ROTATION_YAW_270 
   */
  private final MavSensorOrientation orientation;

  /**
   * Measurement covariance in centimeters, 0 for unknown / invalid readings 
   */
  private final int covariance;

  private DistanceSensor(long timeBootMs, int minDistance, int maxDistance, int currentDistance,
      MavDistanceSensor type, int id, MavSensorOrientation orientation, int covariance) {
    this.timeBootMs = timeBootMs;
    this.minDistance = minDistance;
    this.maxDistance = maxDistance;
    this.currentDistance = currentDistance;
    this.type = type;
    this.id = id;
    this.orientation = orientation;
    this.covariance = covariance;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "DistanceSensor{timeBootMs=" + timeBootMs
         + ", minDistance=" + minDistance
         + ", maxDistance=" + maxDistance
         + ", currentDistance=" + currentDistance
         + ", type=" + type
         + ", id=" + id
         + ", orientation=" + orientation
         + ", covariance=" + covariance + "}";
  }

  /**
   * Time since system boot 
   */
  @MavlinkFieldInfo(
      position = 0,
      unitSize = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  /**
   * Minimum distance the sensor can measure in centimeters 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 2
  )
  public final int minDistance() {
    return minDistance;
  }

  /**
   * Maximum distance the sensor can measure in centimeters 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 2
  )
  public final int maxDistance() {
    return maxDistance;
  }

  /**
   * Current distance reading 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 2
  )
  public final int currentDistance() {
    return currentDistance;
  }

  /**
   * Type from {@link io.dronefleet.mavlink.common.MavDistanceSensor MavDistanceSensor} enum. 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 1
  )
  public final MavDistanceSensor type() {
    return type;
  }

  /**
   * Onboard ID of the sensor 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 1
  )
  public final int id() {
    return id;
  }

  /**
   * Direction the sensor faces from {@link io.dronefleet.mavlink.common.MavSensorOrientation MavSensorOrientation} enum. downward-facing: 
   * ROTATION_PITCH_270, upward-facing: ROTATION_PITCH_90, backward-facing: 
   * ROTATION_PITCH_180, forward-facing: ROTATION_NONE, left-facing: ROTATION_YAW_90, 
   * right-facing: ROTATION_YAW_270 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 1
  )
  public final MavSensorOrientation orientation() {
    return orientation;
  }

  /**
   * Measurement covariance in centimeters, 0 for unknown / invalid readings 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 1
  )
  public final int covariance() {
    return covariance;
  }

  public static class Builder {
    private long timeBootMs;

    private int minDistance;

    private int maxDistance;

    private int currentDistance;

    private MavDistanceSensor type;

    private int id;

    private MavSensorOrientation orientation;

    private int covariance;

    private Builder() {
    }

    /**
     * Time since system boot 
     */
    @MavlinkFieldInfo(
        position = 0,
        unitSize = 4
    )
    public final Builder timeBootMs(long timeBootMs) {
      this.timeBootMs = timeBootMs;
      return this;
    }

    /**
     * Minimum distance the sensor can measure in centimeters 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 2
    )
    public final Builder minDistance(int minDistance) {
      this.minDistance = minDistance;
      return this;
    }

    /**
     * Maximum distance the sensor can measure in centimeters 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 2
    )
    public final Builder maxDistance(int maxDistance) {
      this.maxDistance = maxDistance;
      return this;
    }

    /**
     * Current distance reading 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 2
    )
    public final Builder currentDistance(int currentDistance) {
      this.currentDistance = currentDistance;
      return this;
    }

    /**
     * Type from {@link io.dronefleet.mavlink.common.MavDistanceSensor MavDistanceSensor} enum. 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 1
    )
    public final Builder type(MavDistanceSensor type) {
      this.type = type;
      return this;
    }

    /**
     * Onboard ID of the sensor 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 1
    )
    public final Builder id(int id) {
      this.id = id;
      return this;
    }

    /**
     * Direction the sensor faces from {@link io.dronefleet.mavlink.common.MavSensorOrientation MavSensorOrientation} enum. downward-facing: 
     * ROTATION_PITCH_270, upward-facing: ROTATION_PITCH_90, backward-facing: 
     * ROTATION_PITCH_180, forward-facing: ROTATION_NONE, left-facing: ROTATION_YAW_90, 
     * right-facing: ROTATION_YAW_270 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 1
    )
    public final Builder orientation(MavSensorOrientation orientation) {
      this.orientation = orientation;
      return this;
    }

    /**
     * Measurement covariance in centimeters, 0 for unknown / invalid readings 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 1
    )
    public final Builder covariance(int covariance) {
      this.covariance = covariance;
      return this;
    }

    public final DistanceSensor build() {
      return new DistanceSensor(timeBootMs, minDistance, maxDistance, currentDistance, type, id, orientation, covariance);
    }
  }
}
