package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Float;
import java.lang.Integer;
import java.math.BigInteger;
import java.util.List;

/**
 * WORK IN PROGRESS! DO NOT DEPLOY! Message to describe a trajectory in the local frame. Supported 
 * trajectory types are enumerated in {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation} 
 */
@MavlinkMessage(
    id = 332,
    crc = 131
)
public final class Trajectory {
  /**
   * Timestamp (microseconds since system boot or since UNIX epoch). 
   */
  private final BigInteger timeUsec;

  /**
   * Waypoints, Bezier etc. see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation} 
   */
  private final MavTrajectoryRepresentation type;

  /**
   * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation}) 
   */
  private final List<Float> point1;

  /**
   * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation}) 
   */
  private final List<Float> point2;

  /**
   * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation}) 
   */
  private final List<Float> point3;

  /**
   * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation}) 
   */
  private final List<Float> point4;

  /**
   * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation}) 
   */
  private final List<Float> point5;

  /**
   * States if respective point is valid (boolean) 
   */
  private final List<Integer> pointValid;

  private Trajectory(BigInteger timeUsec, MavTrajectoryRepresentation type, List<Float> point1,
      List<Float> point2, List<Float> point3, List<Float> point4, List<Float> point5,
      List<Integer> pointValid) {
    this.timeUsec = timeUsec;
    this.type = type;
    this.point1 = point1;
    this.point2 = point2;
    this.point3 = point3;
    this.point4 = point4;
    this.point5 = point5;
    this.pointValid = pointValid;
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
   * Waypoints, Bezier etc. see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation} 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final MavTrajectoryRepresentation type() {
    return type;
  }

  /**
   * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation}) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4,
      arraySize = 11
  )
  public final List<Float> point1() {
    return point1;
  }

  /**
   * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation}) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4,
      arraySize = 11
  )
  public final List<Float> point2() {
    return point2;
  }

  /**
   * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation}) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4,
      arraySize = 11
  )
  public final List<Float> point3() {
    return point3;
  }

  /**
   * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation}) 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4,
      arraySize = 11
  )
  public final List<Float> point4() {
    return point4;
  }

  /**
   * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation}) 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4,
      arraySize = 11
  )
  public final List<Float> point5() {
    return point5;
  }

  /**
   * States if respective point is valid (boolean) 
   */
  @MavlinkMessageField(
      position = 8,
      length = 1,
      arraySize = 5
  )
  public final List<Integer> pointValid() {
    return pointValid;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private MavTrajectoryRepresentation type;

    private List<Float> point1;

    private List<Float> point2;

    private List<Float> point3;

    private List<Float> point4;

    private List<Float> point5;

    private List<Integer> pointValid;

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
     * Waypoints, Bezier etc. see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation} 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder type(MavTrajectoryRepresentation type) {
      this.type = type;
      return this;
    }

    /**
     * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation}) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4,
        arraySize = 11
    )
    public final Builder point1(List<Float> point1) {
      this.point1 = point1;
      return this;
    }

    /**
     * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation}) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4,
        arraySize = 11
    )
    public final Builder point2(List<Float> point2) {
      this.point2 = point2;
      return this;
    }

    /**
     * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation}) 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4,
        arraySize = 11
    )
    public final Builder point3(List<Float> point3) {
      this.point3 = point3;
      return this;
    }

    /**
     * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation}) 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4,
        arraySize = 11
    )
    public final Builder point4(List<Float> point4) {
      this.point4 = point4;
      return this;
    }

    /**
     * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation}) 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4,
        arraySize = 11
    )
    public final Builder point5(List<Float> point5) {
      this.point5 = point5;
      return this;
    }

    /**
     * States if respective point is valid (boolean) 
     */
    @MavlinkMessageField(
        position = 8,
        length = 1,
        arraySize = 5
    )
    public final Builder pointValid(List<Integer> pointValid) {
      this.pointValid = pointValid;
      return this;
    }

    public final Trajectory build() {
      return new Trajectory(timeUsec, type, point1, point2, point3, point4, point5, pointValid);
    }
  }
}
