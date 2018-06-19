package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Status of DCM attitude estimator 
 */
@MavlinkMessage(
    id = 163,
    crc = 127
)
public final class Ahrs {
  /**
   * X gyro drift estimate rad/s 
   */
  private final float omegaix;

  /**
   * Y gyro drift estimate rad/s 
   */
  private final float omegaiy;

  /**
   * Z gyro drift estimate rad/s 
   */
  private final float omegaiz;

  /**
   * average accel_weight 
   */
  private final float accelWeight;

  /**
   * average renormalisation value 
   */
  private final float renormVal;

  /**
   * average error_roll_pitch value 
   */
  private final float errorRp;

  /**
   * average error_yaw value 
   */
  private final float errorYaw;

  private Ahrs(float omegaix, float omegaiy, float omegaiz, float accelWeight, float renormVal,
      float errorRp, float errorYaw) {
    this.omegaix = omegaix;
    this.omegaiy = omegaiy;
    this.omegaiz = omegaiz;
    this.accelWeight = accelWeight;
    this.renormVal = renormVal;
    this.errorRp = errorRp;
    this.errorYaw = errorYaw;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "Ahrs{omegaix=" + omegaix
         + ", omegaiy=" + omegaiy
         + ", omegaiz=" + omegaiz
         + ", accelWeight=" + accelWeight
         + ", renormVal=" + renormVal
         + ", errorRp=" + errorRp
         + ", errorYaw=" + errorYaw + "}";
  }

  /**
   * X gyro drift estimate rad/s 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 4
  )
  public final float omegaix() {
    return omegaix;
  }

  /**
   * Y gyro drift estimate rad/s 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final float omegaiy() {
    return omegaiy;
  }

  /**
   * Z gyro drift estimate rad/s 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final float omegaiz() {
    return omegaiz;
  }

  /**
   * average accel_weight 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final float accelWeight() {
    return accelWeight;
  }

  /**
   * average renormalisation value 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 4
  )
  public final float renormVal() {
    return renormVal;
  }

  /**
   * average error_roll_pitch value 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 4
  )
  public final float errorRp() {
    return errorRp;
  }

  /**
   * average error_yaw value 
   */
  @MavlinkMessageField(
      position = 7,
      unitSize = 4
  )
  public final float errorYaw() {
    return errorYaw;
  }

  public static class Builder {
    private float omegaix;

    private float omegaiy;

    private float omegaiz;

    private float accelWeight;

    private float renormVal;

    private float errorRp;

    private float errorYaw;

    private Builder() {
    }

    /**
     * X gyro drift estimate rad/s 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 4
    )
    public final Builder omegaix(float omegaix) {
      this.omegaix = omegaix;
      return this;
    }

    /**
     * Y gyro drift estimate rad/s 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder omegaiy(float omegaiy) {
      this.omegaiy = omegaiy;
      return this;
    }

    /**
     * Z gyro drift estimate rad/s 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 4
    )
    public final Builder omegaiz(float omegaiz) {
      this.omegaiz = omegaiz;
      return this;
    }

    /**
     * average accel_weight 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 4
    )
    public final Builder accelWeight(float accelWeight) {
      this.accelWeight = accelWeight;
      return this;
    }

    /**
     * average renormalisation value 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 4
    )
    public final Builder renormVal(float renormVal) {
      this.renormVal = renormVal;
      return this;
    }

    /**
     * average error_roll_pitch value 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 4
    )
    public final Builder errorRp(float errorRp) {
      this.errorRp = errorRp;
      return this;
    }

    /**
     * average error_yaw value 
     */
    @MavlinkMessageField(
        position = 7,
        unitSize = 4
    )
    public final Builder errorYaw(float errorYaw) {
      this.errorYaw = errorYaw;
      return this;
    }

    public final Ahrs build() {
      return new Ahrs(omegaix, omegaiy, omegaiz, accelWeight, renormVal, errorRp, errorYaw);
    }
  }
}
