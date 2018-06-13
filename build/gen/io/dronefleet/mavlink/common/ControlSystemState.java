package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Float;
import java.math.BigInteger;
import java.util.List;

/**
 * The smoothed, monotonic system state used to feed the control loops of the system. 
 */
@MavlinkMessage(
    id = 146,
    crc = 103
)
public final class ControlSystemState {
  private final BigInteger timeUsec;

  private final float xAcc;

  private final float yAcc;

  private final float zAcc;

  private final float xVel;

  private final float yVel;

  private final float zVel;

  private final float xPos;

  private final float yPos;

  private final float zPos;

  private final float airspeed;

  private final List<Float> velVariance;

  private final List<Float> posVariance;

  private final List<Float> q;

  private final float rollRate;

  private final float pitchRate;

  private final float yawRate;

  private ControlSystemState(BigInteger timeUsec, float xAcc, float yAcc, float zAcc, float xVel,
      float yVel, float zVel, float xPos, float yPos, float zPos, float airspeed,
      List<Float> velVariance, List<Float> posVariance, List<Float> q, float rollRate,
      float pitchRate, float yawRate) {
    this.timeUsec = timeUsec;
    this.xAcc = xAcc;
    this.yAcc = yAcc;
    this.zAcc = zAcc;
    this.xVel = xVel;
    this.yVel = yVel;
    this.zVel = zVel;
    this.xPos = xPos;
    this.yPos = yPos;
    this.zPos = zPos;
    this.airspeed = airspeed;
    this.velVariance = velVariance;
    this.posVariance = posVariance;
    this.q = q;
    this.rollRate = rollRate;
    this.pitchRate = pitchRate;
    this.yawRate = yawRate;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (micros since boot or Unix epoch) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * X acceleration in body frame 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float xAcc() {
    return xAcc;
  }

  /**
   * Y acceleration in body frame 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float yAcc() {
    return yAcc;
  }

  /**
   * Z acceleration in body frame 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float zAcc() {
    return zAcc;
  }

  /**
   * X velocity in body frame 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float xVel() {
    return xVel;
  }

  /**
   * Y velocity in body frame 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float yVel() {
    return yVel;
  }

  /**
   * Z velocity in body frame 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float zVel() {
    return zVel;
  }

  /**
   * X position in local frame 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float xPos() {
    return xPos;
  }

  /**
   * Y position in local frame 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final float yPos() {
    return yPos;
  }

  /**
   * Z position in local frame 
   */
  @MavlinkMessageField(
      position = 10,
      length = 4
  )
  public final float zPos() {
    return zPos;
  }

  /**
   * Airspeed, set to -1 if unknown 
   */
  @MavlinkMessageField(
      position = 11,
      length = 4
  )
  public final float airspeed() {
    return airspeed;
  }

  /**
   * Variance of body velocity estimate 
   */
  @MavlinkMessageField(
      position = 12,
      length = 4,
      arraySize = 3
  )
  public final List<Float> velVariance() {
    return velVariance;
  }

  /**
   * Variance in local position 
   */
  @MavlinkMessageField(
      position = 13,
      length = 4,
      arraySize = 3
  )
  public final List<Float> posVariance() {
    return posVariance;
  }

  /**
   * The attitude, represented as Quaternion 
   */
  @MavlinkMessageField(
      position = 14,
      length = 4,
      arraySize = 4
  )
  public final List<Float> q() {
    return q;
  }

  /**
   * Angular rate in roll axis 
   */
  @MavlinkMessageField(
      position = 15,
      length = 4
  )
  public final float rollRate() {
    return rollRate;
  }

  /**
   * Angular rate in pitch axis 
   */
  @MavlinkMessageField(
      position = 16,
      length = 4
  )
  public final float pitchRate() {
    return pitchRate;
  }

  /**
   * Angular rate in yaw axis 
   */
  @MavlinkMessageField(
      position = 17,
      length = 4
  )
  public final float yawRate() {
    return yawRate;
  }

  public class Builder {
    private BigInteger timeUsec;

    private float xAcc;

    private float yAcc;

    private float zAcc;

    private float xVel;

    private float yVel;

    private float zVel;

    private float xPos;

    private float yPos;

    private float zPos;

    private float airspeed;

    private List<Float> velVariance;

    private List<Float> posVariance;

    private List<Float> q;

    private float rollRate;

    private float pitchRate;

    private float yawRate;

    private Builder() {
    }

    /**
     * Timestamp (micros since boot or Unix epoch) 
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
     * X acceleration in body frame 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder xAcc(float xAcc) {
      this.xAcc = xAcc;
      return this;
    }

    /**
     * Y acceleration in body frame 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder yAcc(float yAcc) {
      this.yAcc = yAcc;
      return this;
    }

    /**
     * Z acceleration in body frame 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder zAcc(float zAcc) {
      this.zAcc = zAcc;
      return this;
    }

    /**
     * X velocity in body frame 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder xVel(float xVel) {
      this.xVel = xVel;
      return this;
    }

    /**
     * Y velocity in body frame 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder yVel(float yVel) {
      this.yVel = yVel;
      return this;
    }

    /**
     * Z velocity in body frame 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder zVel(float zVel) {
      this.zVel = zVel;
      return this;
    }

    /**
     * X position in local frame 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4
    )
    public final Builder xPos(float xPos) {
      this.xPos = xPos;
      return this;
    }

    /**
     * Y position in local frame 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4
    )
    public final Builder yPos(float yPos) {
      this.yPos = yPos;
      return this;
    }

    /**
     * Z position in local frame 
     */
    @MavlinkMessageField(
        position = 10,
        length = 4
    )
    public final Builder zPos(float zPos) {
      this.zPos = zPos;
      return this;
    }

    /**
     * Airspeed, set to -1 if unknown 
     */
    @MavlinkMessageField(
        position = 11,
        length = 4
    )
    public final Builder airspeed(float airspeed) {
      this.airspeed = airspeed;
      return this;
    }

    /**
     * Variance of body velocity estimate 
     */
    @MavlinkMessageField(
        position = 12,
        length = 4,
        arraySize = 3
    )
    public final Builder velVariance(List<Float> velVariance) {
      this.velVariance = velVariance;
      return this;
    }

    /**
     * Variance in local position 
     */
    @MavlinkMessageField(
        position = 13,
        length = 4,
        arraySize = 3
    )
    public final Builder posVariance(List<Float> posVariance) {
      this.posVariance = posVariance;
      return this;
    }

    /**
     * The attitude, represented as Quaternion 
     */
    @MavlinkMessageField(
        position = 14,
        length = 4,
        arraySize = 4
    )
    public final Builder q(List<Float> q) {
      this.q = q;
      return this;
    }

    /**
     * Angular rate in roll axis 
     */
    @MavlinkMessageField(
        position = 15,
        length = 4
    )
    public final Builder rollRate(float rollRate) {
      this.rollRate = rollRate;
      return this;
    }

    /**
     * Angular rate in pitch axis 
     */
    @MavlinkMessageField(
        position = 16,
        length = 4
    )
    public final Builder pitchRate(float pitchRate) {
      this.pitchRate = pitchRate;
      return this;
    }

    /**
     * Angular rate in yaw axis 
     */
    @MavlinkMessageField(
        position = 17,
        length = 4
    )
    public final Builder yawRate(float yawRate) {
      this.yawRate = yawRate;
      return this;
    }

    public final ControlSystemState build() {
      return new ControlSystemState(timeUsec, xAcc, yAcc, zAcc, xVel, yVel, zVel, xPos, yPos, zPos, airspeed, velVariance, posVariance, q, rollRate, pitchRate, yawRate);
    }
  }
}
