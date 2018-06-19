package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
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
   * Distance of obstacles around the UAV with index 0 corresponding to local North. A value of 0 
   * means that the obstacle is right in front of the sensor. A value of max_distance +1 means no 
   * obstacle is present. A value of UINT16_MAX for unknown/not used. In a array element, one unit 
   * corresponds to 1cm. 
   */
  private final List<Integer> distances;

  /**
   * Minimum distance the sensor can measure in centimeters. 
   */
  private final int minDistance;

  /**
   * Maximum distance the sensor can measure in centimeters. 
   */
  private final int maxDistance;

  /**
   * Class id of the distance sensor type. 
   */
  private final MavDistanceSensor sensorType;

  /**
   * Angular width in degrees of each array element. 
   */
  private final int increment;

  private ObstacleDistance(BigInteger timeUsec, List<Integer> distances, int minDistance,
      int maxDistance, MavDistanceSensor sensorType, int increment) {
    this.timeUsec = timeUsec;
    this.distances = distances;
    this.minDistance = minDistance;
    this.maxDistance = maxDistance;
    this.sensorType = sensorType;
    this.increment = increment;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "ObstacleDistance{timeUsec=" + timeUsec
         + ", sensorType=" + sensorType
         + ", distances=" + distances
         + ", increment=" + increment
         + ", minDistance=" + minDistance
         + ", maxDistance=" + maxDistance + "}";
  }

  /**
   * Timestamp (microseconds since system boot or since UNIX epoch). 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * Distance of obstacles around the UAV with index 0 corresponding to local North. A value of 0 
   * means that the obstacle is right in front of the sensor. A value of max_distance +1 means no 
   * obstacle is present. A value of UINT16_MAX for unknown/not used. In a array element, one unit 
   * corresponds to 1cm. 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 2,
      arraySize = 72
  )
  public final List<Integer> distances() {
    return distances;
  }

  /**
   * Minimum distance the sensor can measure in centimeters. 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 2
  )
  public final int minDistance() {
    return minDistance;
  }

  /**
   * Maximum distance the sensor can measure in centimeters. 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 2
  )
  public final int maxDistance() {
    return maxDistance;
  }

  /**
   * Class id of the distance sensor type. 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final MavDistanceSensor sensorType() {
    return sensorType;
  }

  /**
   * Angular width in degrees of each array element. 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 1
  )
  public final int increment() {
    return increment;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private List<Integer> distances;

    private int minDistance;

    private int maxDistance;

    private MavDistanceSensor sensorType;

    private int increment;

    private Builder() {
    }

    /**
     * Timestamp (microseconds since system boot or since UNIX epoch). 
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
     * Distance of obstacles around the UAV with index 0 corresponding to local North. A value of 0 
     * means that the obstacle is right in front of the sensor. A value of max_distance +1 means no 
     * obstacle is present. A value of UINT16_MAX for unknown/not used. In a array element, one unit 
     * corresponds to 1cm. 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 2,
        arraySize = 72
    )
    public final Builder distances(List<Integer> distances) {
      this.distances = distances;
      return this;
    }

    /**
     * Minimum distance the sensor can measure in centimeters. 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 2
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
        unitSize = 2
    )
    public final Builder maxDistance(int maxDistance) {
      this.maxDistance = maxDistance;
      return this;
    }

    /**
     * Class id of the distance sensor type. 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 1
    )
    public final Builder sensorType(MavDistanceSensor sensorType) {
      this.sensorType = sensorType;
      return this;
    }

    /**
     * Angular width in degrees of each array element. 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 1
    )
    public final Builder increment(int increment) {
      this.increment = increment;
      return this;
    }

    public final ObstacleDistance build() {
      return new ObstacleDistance(timeUsec, distances, minDistance, maxDistance, sensorType, increment);
    }
  }
}
