package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;

/**
 * Odometry message to communicate odometry information with an external interface. Fits ROS 
 * REP 147 standard for aerial vehicles (http://www.ros.org/reps/rep-0147.html). 
 */
@MavlinkMessageInfo(
    id = 331,
    crc = 58
)
public final class Odometry {
  /**
   * Timestamp (microseconds since system boot or since UNIX epoch). 
   */
  private final BigInteger timeUsec;

  /**
   * X Position 
   */
  private final float x;

  /**
   * Y Position 
   */
  private final float y;

  /**
   * Z Position 
   */
  private final float z;

  /**
   * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation) 
   */
  private final List<Float> q;

  /**
   * X linear speed 
   */
  private final float vx;

  /**
   * Y linear speed 
   */
  private final float vy;

  /**
   * Z linear speed 
   */
  private final float vz;

  /**
   * Roll angular speed 
   */
  private final float rollspeed;

  /**
   * Pitch angular speed 
   */
  private final float pitchspeed;

  /**
   * Yaw angular speed 
   */
  private final float yawspeed;

  /**
   * Pose (states: x, y, z, roll, pitch, yaw) covariance matrix upper right triangle (first six 
   * entries are the first ROW, next five entries are the second ROW, etc.) 
   */
  private final List<Float> poseCovariance;

  /**
   * Twist (states: vx, vy, vz, rollspeed, pitchspeed, yawspeed) covariance matrix upper right 
   * triangle (first six entries are the first ROW, next five entries are the second ROW, etc.) 
   */
  private final List<Float> twistCovariance;

  /**
   * Coordinate frame of reference for the pose data, as defined by {@link io.dronefleet.mavlink.common.MavFrame MavFrame} enum. 
   */
  private final MavFrame frameId;

  /**
   * Coordinate frame of reference for the velocity in free space (twist) data, as defined by 
   * {@link io.dronefleet.mavlink.common.MavFrame MavFrame} enum. 
   */
  private final MavFrame childFrameId;

  private Odometry(BigInteger timeUsec, float x, float y, float z, List<Float> q, float vx,
      float vy, float vz, float rollspeed, float pitchspeed, float yawspeed,
      List<Float> poseCovariance, List<Float> twistCovariance, MavFrame frameId,
      MavFrame childFrameId) {
    this.timeUsec = timeUsec;
    this.x = x;
    this.y = y;
    this.z = z;
    this.q = q;
    this.vx = vx;
    this.vy = vy;
    this.vz = vz;
    this.rollspeed = rollspeed;
    this.pitchspeed = pitchspeed;
    this.yawspeed = yawspeed;
    this.poseCovariance = poseCovariance;
    this.twistCovariance = twistCovariance;
    this.frameId = frameId;
    this.childFrameId = childFrameId;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "Odometry{timeUsec=" + timeUsec
         + ", frameId=" + frameId
         + ", childFrameId=" + childFrameId
         + ", x=" + x
         + ", y=" + y
         + ", z=" + z
         + ", q=" + q
         + ", vx=" + vx
         + ", vy=" + vy
         + ", vz=" + vz
         + ", rollspeed=" + rollspeed
         + ", pitchspeed=" + pitchspeed
         + ", yawspeed=" + yawspeed
         + ", poseCovariance=" + poseCovariance
         + ", twistCovariance=" + twistCovariance + "}";
  }

  /**
   * Timestamp (microseconds since system boot or since UNIX epoch). 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * X Position 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 4
  )
  public final float x() {
    return x;
  }

  /**
   * Y Position 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final float y() {
    return y;
  }

  /**
   * Z Position 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 4
  )
  public final float z() {
    return z;
  }

  /**
   * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation) 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 4,
      arraySize = 4
  )
  public final List<Float> q() {
    return q;
  }

  /**
   * X linear speed 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 4
  )
  public final float vx() {
    return vx;
  }

  /**
   * Y linear speed 
   */
  @MavlinkFieldInfo(
      position = 9,
      unitSize = 4
  )
  public final float vy() {
    return vy;
  }

  /**
   * Z linear speed 
   */
  @MavlinkFieldInfo(
      position = 10,
      unitSize = 4
  )
  public final float vz() {
    return vz;
  }

  /**
   * Roll angular speed 
   */
  @MavlinkFieldInfo(
      position = 11,
      unitSize = 4
  )
  public final float rollspeed() {
    return rollspeed;
  }

  /**
   * Pitch angular speed 
   */
  @MavlinkFieldInfo(
      position = 12,
      unitSize = 4
  )
  public final float pitchspeed() {
    return pitchspeed;
  }

  /**
   * Yaw angular speed 
   */
  @MavlinkFieldInfo(
      position = 13,
      unitSize = 4
  )
  public final float yawspeed() {
    return yawspeed;
  }

  /**
   * Pose (states: x, y, z, roll, pitch, yaw) covariance matrix upper right triangle (first six 
   * entries are the first ROW, next five entries are the second ROW, etc.) 
   */
  @MavlinkFieldInfo(
      position = 14,
      unitSize = 4,
      arraySize = 21
  )
  public final List<Float> poseCovariance() {
    return poseCovariance;
  }

  /**
   * Twist (states: vx, vy, vz, rollspeed, pitchspeed, yawspeed) covariance matrix upper right 
   * triangle (first six entries are the first ROW, next five entries are the second ROW, etc.) 
   */
  @MavlinkFieldInfo(
      position = 15,
      unitSize = 4,
      arraySize = 21
  )
  public final List<Float> twistCovariance() {
    return twistCovariance;
  }

  /**
   * Coordinate frame of reference for the pose data, as defined by {@link io.dronefleet.mavlink.common.MavFrame MavFrame} enum. 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final MavFrame frameId() {
    return frameId;
  }

  /**
   * Coordinate frame of reference for the velocity in free space (twist) data, as defined by 
   * {@link io.dronefleet.mavlink.common.MavFrame MavFrame} enum. 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1
  )
  public final MavFrame childFrameId() {
    return childFrameId;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private float x;

    private float y;

    private float z;

    private List<Float> q;

    private float vx;

    private float vy;

    private float vz;

    private float rollspeed;

    private float pitchspeed;

    private float yawspeed;

    private List<Float> poseCovariance;

    private List<Float> twistCovariance;

    private MavFrame frameId;

    private MavFrame childFrameId;

    private Builder() {
    }

    /**
     * Timestamp (microseconds since system boot or since UNIX epoch). 
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
     * X Position 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 4
    )
    public final Builder x(float x) {
      this.x = x;
      return this;
    }

    /**
     * Y Position 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder y(float y) {
      this.y = y;
      return this;
    }

    /**
     * Z Position 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 4
    )
    public final Builder z(float z) {
      this.z = z;
      return this;
    }

    /**
     * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation) 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 4,
        arraySize = 4
    )
    public final Builder q(List<Float> q) {
      this.q = q;
      return this;
    }

    /**
     * X linear speed 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 4
    )
    public final Builder vx(float vx) {
      this.vx = vx;
      return this;
    }

    /**
     * Y linear speed 
     */
    @MavlinkFieldInfo(
        position = 9,
        unitSize = 4
    )
    public final Builder vy(float vy) {
      this.vy = vy;
      return this;
    }

    /**
     * Z linear speed 
     */
    @MavlinkFieldInfo(
        position = 10,
        unitSize = 4
    )
    public final Builder vz(float vz) {
      this.vz = vz;
      return this;
    }

    /**
     * Roll angular speed 
     */
    @MavlinkFieldInfo(
        position = 11,
        unitSize = 4
    )
    public final Builder rollspeed(float rollspeed) {
      this.rollspeed = rollspeed;
      return this;
    }

    /**
     * Pitch angular speed 
     */
    @MavlinkFieldInfo(
        position = 12,
        unitSize = 4
    )
    public final Builder pitchspeed(float pitchspeed) {
      this.pitchspeed = pitchspeed;
      return this;
    }

    /**
     * Yaw angular speed 
     */
    @MavlinkFieldInfo(
        position = 13,
        unitSize = 4
    )
    public final Builder yawspeed(float yawspeed) {
      this.yawspeed = yawspeed;
      return this;
    }

    /**
     * Pose (states: x, y, z, roll, pitch, yaw) covariance matrix upper right triangle (first six 
     * entries are the first ROW, next five entries are the second ROW, etc.) 
     */
    @MavlinkFieldInfo(
        position = 14,
        unitSize = 4,
        arraySize = 21
    )
    public final Builder poseCovariance(List<Float> poseCovariance) {
      this.poseCovariance = poseCovariance;
      return this;
    }

    /**
     * Twist (states: vx, vy, vz, rollspeed, pitchspeed, yawspeed) covariance matrix upper right 
     * triangle (first six entries are the first ROW, next five entries are the second ROW, etc.) 
     */
    @MavlinkFieldInfo(
        position = 15,
        unitSize = 4,
        arraySize = 21
    )
    public final Builder twistCovariance(List<Float> twistCovariance) {
      this.twistCovariance = twistCovariance;
      return this;
    }

    /**
     * Coordinate frame of reference for the pose data, as defined by {@link io.dronefleet.mavlink.common.MavFrame MavFrame} enum. 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder frameId(MavFrame frameId) {
      this.frameId = frameId;
      return this;
    }

    /**
     * Coordinate frame of reference for the velocity in free space (twist) data, as defined by 
     * {@link io.dronefleet.mavlink.common.MavFrame MavFrame} enum. 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 1
    )
    public final Builder childFrameId(MavFrame childFrameId) {
      this.childFrameId = childFrameId;
      return this;
    }

    public final Odometry build() {
      return new Odometry(timeUsec, x, y, z, q, vx, vy, vz, rollspeed, pitchspeed, yawspeed, poseCovariance, twistCovariance, frameId, childFrameId);
    }
  }
}
