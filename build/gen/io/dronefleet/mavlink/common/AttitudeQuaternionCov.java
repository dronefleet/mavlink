package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Float;
import java.math.BigInteger;
import java.util.List;

/**
 * The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right), expressed 
 * as quaternion. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0 0). 
 */
@MavlinkMessage(
    id = 61,
    crc = 167
)
public final class AttitudeQuaternionCov {
  private final BigInteger timeUsec;

  private final List<Float> q;

  private final float rollspeed;

  private final float pitchspeed;

  private final float yawspeed;

  private final List<Float> covariance;

  private AttitudeQuaternionCov(BigInteger timeUsec, List<Float> q, float rollspeed,
      float pitchspeed, float yawspeed, List<Float> covariance) {
    this.timeUsec = timeUsec;
    this.q = q;
    this.rollspeed = rollspeed;
    this.pitchspeed = pitchspeed;
    this.yawspeed = yawspeed;
    this.covariance = covariance;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (microseconds since system boot or since UNIX epoch) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4,
      arraySize = 4
  )
  public final List<Float> q() {
    return q;
  }

  /**
   * Roll angular speed (rad/s) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float rollspeed() {
    return rollspeed;
  }

  /**
   * Pitch angular speed (rad/s) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float pitchspeed() {
    return pitchspeed;
  }

  /**
   * Yaw angular speed (rad/s) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float yawspeed() {
    return yawspeed;
  }

  /**
   * Attitude covariance 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4,
      arraySize = 9
  )
  public final List<Float> covariance() {
    return covariance;
  }

  public class Builder {
    private BigInteger timeUsec;

    private List<Float> q;

    private float rollspeed;

    private float pitchspeed;

    private float yawspeed;

    private List<Float> covariance;

    private Builder() {
    }

    /**
     * Timestamp (microseconds since system boot or since UNIX epoch) 
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
     * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation) 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4,
        arraySize = 4
    )
    public final Builder q(List<Float> q) {
      this.q = q;
      return this;
    }

    /**
     * Roll angular speed (rad/s) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder rollspeed(float rollspeed) {
      this.rollspeed = rollspeed;
      return this;
    }

    /**
     * Pitch angular speed (rad/s) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder pitchspeed(float pitchspeed) {
      this.pitchspeed = pitchspeed;
      return this;
    }

    /**
     * Yaw angular speed (rad/s) 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder yawspeed(float yawspeed) {
      this.yawspeed = yawspeed;
      return this;
    }

    /**
     * Attitude covariance 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4,
        arraySize = 9
    )
    public final Builder covariance(List<Float> covariance) {
      this.covariance = covariance;
      return this;
    }

    public final AttitudeQuaternionCov build() {
      return new AttitudeQuaternionCov(timeUsec, q, rollspeed, pitchspeed, yawspeed, covariance);
    }
  }
}
