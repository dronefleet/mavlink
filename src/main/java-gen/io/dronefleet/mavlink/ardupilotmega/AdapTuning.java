package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Adaptive Controller tuning information 
 */
@MavlinkMessageInfo(
    id = 11010,
    crc = 46
)
public final class AdapTuning {
  /**
   * desired rate (degrees/s) 
   */
  private final float desired;

  /**
   * achieved rate (degrees/s) 
   */
  private final float achieved;

  /**
   * error between model and vehicle 
   */
  private final float error;

  /**
   * theta estimated state predictor 
   */
  private final float theta;

  /**
   * omega estimated state predictor 
   */
  private final float omega;

  /**
   * sigma estimated state predictor 
   */
  private final float sigma;

  /**
   * theta derivative 
   */
  private final float thetaDot;

  /**
   * omega derivative 
   */
  private final float omegaDot;

  /**
   * sigma derivative 
   */
  private final float sigmaDot;

  /**
   * projection operator value 
   */
  private final float f;

  /**
   * projection operator derivative 
   */
  private final float fDot;

  /**
   * u adaptive controlled output command 
   */
  private final float u;

  /**
   * axis 
   */
  private final PidTuningAxis axis;

  private AdapTuning(float desired, float achieved, float error, float theta, float omega,
      float sigma, float thetaDot, float omegaDot, float sigmaDot, float f, float fDot, float u,
      PidTuningAxis axis) {
    this.desired = desired;
    this.achieved = achieved;
    this.error = error;
    this.theta = theta;
    this.omega = omega;
    this.sigma = sigma;
    this.thetaDot = thetaDot;
    this.omegaDot = omegaDot;
    this.sigmaDot = sigmaDot;
    this.f = f;
    this.fDot = fDot;
    this.u = u;
    this.axis = axis;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "AdapTuning{axis=" + axis
         + ", desired=" + desired
         + ", achieved=" + achieved
         + ", error=" + error
         + ", theta=" + theta
         + ", omega=" + omega
         + ", sigma=" + sigma
         + ", thetaDot=" + thetaDot
         + ", omegaDot=" + omegaDot
         + ", sigmaDot=" + sigmaDot
         + ", f=" + f
         + ", fDot=" + fDot
         + ", u=" + u + "}";
  }

  /**
   * desired rate (degrees/s) 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 4
  )
  public final float desired() {
    return desired;
  }

  /**
   * achieved rate (degrees/s) 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 4
  )
  public final float achieved() {
    return achieved;
  }

  /**
   * error between model and vehicle 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 4
  )
  public final float error() {
    return error;
  }

  /**
   * theta estimated state predictor 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final float theta() {
    return theta;
  }

  /**
   * omega estimated state predictor 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 4
  )
  public final float omega() {
    return omega;
  }

  /**
   * sigma estimated state predictor 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 4
  )
  public final float sigma() {
    return sigma;
  }

  /**
   * theta derivative 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 4
  )
  public final float thetaDot() {
    return thetaDot;
  }

  /**
   * omega derivative 
   */
  @MavlinkFieldInfo(
      position = 9,
      unitSize = 4
  )
  public final float omegaDot() {
    return omegaDot;
  }

  /**
   * sigma derivative 
   */
  @MavlinkFieldInfo(
      position = 10,
      unitSize = 4
  )
  public final float sigmaDot() {
    return sigmaDot;
  }

  /**
   * projection operator value 
   */
  @MavlinkFieldInfo(
      position = 11,
      unitSize = 4
  )
  public final float f() {
    return f;
  }

  /**
   * projection operator derivative 
   */
  @MavlinkFieldInfo(
      position = 12,
      unitSize = 4
  )
  public final float fDot() {
    return fDot;
  }

  /**
   * u adaptive controlled output command 
   */
  @MavlinkFieldInfo(
      position = 13,
      unitSize = 4
  )
  public final float u() {
    return u;
  }

  /**
   * axis 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 1
  )
  public final PidTuningAxis axis() {
    return axis;
  }

  public static class Builder {
    private float desired;

    private float achieved;

    private float error;

    private float theta;

    private float omega;

    private float sigma;

    private float thetaDot;

    private float omegaDot;

    private float sigmaDot;

    private float f;

    private float fDot;

    private float u;

    private PidTuningAxis axis;

    private Builder() {
    }

    /**
     * desired rate (degrees/s) 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 4
    )
    public final Builder desired(float desired) {
      this.desired = desired;
      return this;
    }

    /**
     * achieved rate (degrees/s) 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 4
    )
    public final Builder achieved(float achieved) {
      this.achieved = achieved;
      return this;
    }

    /**
     * error between model and vehicle 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 4
    )
    public final Builder error(float error) {
      this.error = error;
      return this;
    }

    /**
     * theta estimated state predictor 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder theta(float theta) {
      this.theta = theta;
      return this;
    }

    /**
     * omega estimated state predictor 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 4
    )
    public final Builder omega(float omega) {
      this.omega = omega;
      return this;
    }

    /**
     * sigma estimated state predictor 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 4
    )
    public final Builder sigma(float sigma) {
      this.sigma = sigma;
      return this;
    }

    /**
     * theta derivative 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 4
    )
    public final Builder thetaDot(float thetaDot) {
      this.thetaDot = thetaDot;
      return this;
    }

    /**
     * omega derivative 
     */
    @MavlinkFieldInfo(
        position = 9,
        unitSize = 4
    )
    public final Builder omegaDot(float omegaDot) {
      this.omegaDot = omegaDot;
      return this;
    }

    /**
     * sigma derivative 
     */
    @MavlinkFieldInfo(
        position = 10,
        unitSize = 4
    )
    public final Builder sigmaDot(float sigmaDot) {
      this.sigmaDot = sigmaDot;
      return this;
    }

    /**
     * projection operator value 
     */
    @MavlinkFieldInfo(
        position = 11,
        unitSize = 4
    )
    public final Builder f(float f) {
      this.f = f;
      return this;
    }

    /**
     * projection operator derivative 
     */
    @MavlinkFieldInfo(
        position = 12,
        unitSize = 4
    )
    public final Builder fDot(float fDot) {
      this.fDot = fDot;
      return this;
    }

    /**
     * u adaptive controlled output command 
     */
    @MavlinkFieldInfo(
        position = 13,
        unitSize = 4
    )
    public final Builder u(float u) {
      this.u = u;
      return this;
    }

    /**
     * axis 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 1
    )
    public final Builder axis(PidTuningAxis axis) {
      this.axis = axis;
      return this;
    }

    public final AdapTuning build() {
      return new AdapTuning(desired, achieved, error, theta, omega, sigma, thetaDot, omegaDot, sigmaDot, f, fDot, u, axis);
    }
  }
}
