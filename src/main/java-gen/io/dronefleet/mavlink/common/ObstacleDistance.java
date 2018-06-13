package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.math.BigInteger;
import java.util.List;

/**
 * Obstacle distances in front of the sensor, starting from the left in increment degrees to the 
 * right 
 */
@MavlinkMessage(
    id = 330,
    crc = 23
)
public final class ObstacleDistance {
  /**
   * Timestamp (microseconds since system boot or since UNIX epoch). 
   */
  private final BigInteger timeUsec;

  /**
   * Class id of the distance sensor type. 
   */
  private final MavDistanceSensor sensorType;

  /**
   * Distance of obstacles around the UAV with index 0 corresponding to local North. A value of 0 
   * means that the obstacle is right in front of the sensor. A value of max_distance +1 means no 
   * obstacle is present. A value of UINT16_MAX for unknown/not used. In a array element, one unit 
   * corresponds to 1cm. 
   */
  private final List<Integer> distances;

  /**
   * Angular width in degrees of each array element. 
   */
  private final int increment;

  /**
   * Minimum distance the sensor can measure in centimeters. 
   */
  private final int minDistance;

  /**
   * Maximum distance the sensor can measure in centimeters. 
   */
  private final int maxDistance;

  private ObstacleDistance(BigInteger timeUsec, MavDistanceSensor sensorType,
      List<Integer> distances, int increment, int minDistance, int maxDistance) {
    this.timeUsec = timeUsec;
    this.sensorType = sensorType;
    this.distances = distances;
    this.increment = increment;
    this.minDistance = minDistance;
    this.maxDistance = maxDistance;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (microseconds since system boot or since UNIX epoch). 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * Class id of the distance sensor type. 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final MavDistanceSensor sensorType() {
    return sensorType;
  }

  /**
   * Distance of obstacles around the UAV with index 0 corresponding to local North. A value of 0 
   * means that the obstacle is right in front of the sensor. A value of max_distance +1 means no 
   * obstacle is present. A value of UINT16_MAX for unknown/not used. In a array element, one unit 
   * corresponds to 1cm. 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2,
      arraySize = 72
  )
  public final List<Integer> distances() {
    return distances;
  }

  /**
   * Angular width in degrees of each array element. 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final int increment() {
    return increment;
  }

  /**
   * Minimum distance the sensor can measure in centimeters. 
   */
  @MavlinkMessageField(
      position = 5,
      length = 2
  )
  public final int minDistance() {
    return minDistance;
  }

  /**
   * Maximum distance the sensor can measure in centimeters. 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int maxDistance() {
    return maxDistance;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private MavDistanceSensor sensorType;

    private List<Integer> distances;

    private int increment;

    private int minDistance;

    private int maxDistance;

    private Builder() {
    }

    /**
     * Timestamp (microseconds since system boot or since UNIX epoch). 
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
     * Class id of the distance sensor type. 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder sensorType(MavDistanceSensor sensorType) {
      this.sensorType = sensorType;
      return this;
    }

    /**
     * Distance of obstacles around the UAV with index 0 corresponding to local North. A value of 0 
     * means that the obstacle is right in front of the sensor. A value of max_distance +1 means no 
     * obstacle is present. A value of UINT16_MAX for unknown/not used. In a array element, one unit 
     * corresponds to 1cm. 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2,
        arraySize = 72
    )
    public final Builder distances(List<Integer> distances) {
      this.distances = distances;
      return this;
    }

    /**
     * Angular width in degrees of each array element. 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder increment(int increment) {
      this.increment = increment;
      return this;
    }

    /**
     * Minimum distance the sensor can measure in centimeters. 
     */
    @MavlinkMessageField(
        position = 5,
        length = 2
    )
    public final Builder minDistance(int minDistance) {
      this.minDistance = minDistance;
      return this;
    }

    /**
     * Maximum distance the sensor can measure in centimeters. 
     */
    @MavlinkMessageField(
        position = 6,
        length = 2
    )
    public final Builder maxDistance(int maxDistance) {
      this.maxDistance = maxDistance;
      return this;
    }

    public final ObstacleDistance build() {
      return new ObstacleDistance(timeUsec, sensorType, distances, increment, minDistance, maxDistance);
    }
  }
}
