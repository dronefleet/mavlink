package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * null
 */
@MavlinkMessage(
    id = 132,
    crc = 85
)
public final class DistanceSensor {
  private final long timeBootMs;

  private final int minDistance;

  private final int maxDistance;

  private final int currentDistance;

  private final MavDistanceSensor type;

  private final int id;

  private final MavSensorOrientation orientation;

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

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Time since system boot 
   */
  @MavlinkMessageField(
      position = 0,
      length = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  /**
   * Minimum distance the sensor can measure in centimeters 
   */
  @MavlinkMessageField(
      position = 1,
      length = 2
  )
  public final int minDistance() {
    return minDistance;
  }

  /**
   * Maximum distance the sensor can measure in centimeters 
   */
  @MavlinkMessageField(
      position = 2,
      length = 2
  )
  public final int maxDistance() {
    return maxDistance;
  }

  /**
   * Current distance reading 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int currentDistance() {
    return currentDistance;
  }

  /**
   * Type from MAV_DISTANCE_SENSOR enum. 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final MavDistanceSensor type() {
    return type;
  }

  /**
   * Onboard ID of the sensor 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int id() {
    return id;
  }

  /**
   * Direction the sensor faces from MAV_SENSOR_ORIENTATION enum. downward-facing: 
   * ROTATION_PITCH_270, upward-facing: ROTATION_PITCH_90, backward-facing: 
   * ROTATION_PITCH_180, forward-facing: ROTATION_NONE, left-facing: ROTATION_YAW_90, 
   * right-facing: ROTATION_YAW_270 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1
  )
  public final MavSensorOrientation orientation() {
    return orientation;
  }

  /**
   * Measurement covariance in centimeters, 0 for unknown / invalid readings 
   */
  @MavlinkMessageField(
      position = 7,
      length = 1
  )
  public final int covariance() {
    return covariance;
  }

  public class Builder {
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
    @MavlinkMessageField(
        position = 0,
        length = 4
    )
    public final Builder timeBootMs(long timeBootMs) {
      this.timeBootMs = timeBootMs;
      return this;
    }

    /**
     * Minimum distance the sensor can measure in centimeters 
     */
    @MavlinkMessageField(
        position = 1,
        length = 2
    )
    public final Builder minDistance(int minDistance) {
      this.minDistance = minDistance;
      return this;
    }

    /**
     * Maximum distance the sensor can measure in centimeters 
     */
    @MavlinkMessageField(
        position = 2,
        length = 2
    )
    public final Builder maxDistance(int maxDistance) {
      this.maxDistance = maxDistance;
      return this;
    }

    /**
     * Current distance reading 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder currentDistance(int currentDistance) {
      this.currentDistance = currentDistance;
      return this;
    }

    /**
     * Type from MAV_DISTANCE_SENSOR enum. 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder type(MavDistanceSensor type) {
      this.type = type;
      return this;
    }

    /**
     * Onboard ID of the sensor 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder id(int id) {
      this.id = id;
      return this;
    }

    /**
     * Direction the sensor faces from MAV_SENSOR_ORIENTATION enum. downward-facing: 
     * ROTATION_PITCH_270, upward-facing: ROTATION_PITCH_90, backward-facing: 
     * ROTATION_PITCH_180, forward-facing: ROTATION_NONE, left-facing: ROTATION_YAW_90, 
     * right-facing: ROTATION_YAW_270 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1
    )
    public final Builder orientation(MavSensorOrientation orientation) {
      this.orientation = orientation;
      return this;
    }

    /**
     * Measurement covariance in centimeters, 0 for unknown / invalid readings 
     */
    @MavlinkMessageField(
        position = 7,
        length = 1
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
