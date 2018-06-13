package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Adaptive Controller tuning information 
 */
@MavlinkMessage(
    id = 11010,
    crc = 46
)
public final class AdapTuning {
  private final PidTuningAxis axis;

  private final float desired;

  private final float achieved;

  private final float error;

  private final float theta;

  private final float omega;

  private final float sigma;

  private final float thetaDot;

  private final float omegaDot;

  private final float sigmaDot;

  private final float f;

  private final float fDot;

  private final float u;

  private AdapTuning(PidTuningAxis axis, float desired, float achieved, float error, float theta,
      float omega, float sigma, float thetaDot, float omegaDot, float sigmaDot, float f, float fDot,
      float u) {
    this.axis = axis;
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
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * axis 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final PidTuningAxis axis() {
    return axis;
  }

  /**
   * desired rate (degrees/s) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float desired() {
    return desired;
  }

  /**
   * achieved rate (degrees/s) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float achieved() {
    return achieved;
  }

  /**
   * error between model and vehicle 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float error() {
    return error;
  }

  /**
   * theta estimated state predictor 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float theta() {
    return theta;
  }

  /**
   * omega estimated state predictor 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float omega() {
    return omega;
  }

  /**
   * sigma estimated state predictor 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float sigma() {
    return sigma;
  }

  /**
   * theta derivative 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float thetaDot() {
    return thetaDot;
  }

  /**
   * omega derivative 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final float omegaDot() {
    return omegaDot;
  }

  /**
   * sigma derivative 
   */
  @MavlinkMessageField(
      position = 10,
      length = 4
  )
  public final float sigmaDot() {
    return sigmaDot;
  }

  /**
   * projection operator value 
   */
  @MavlinkMessageField(
      position = 11,
      length = 4
  )
  public final float f() {
    return f;
  }

  /**
   * projection operator derivative 
   */
  @MavlinkMessageField(
      position = 12,
      length = 4
  )
  public final float fDot() {
    return fDot;
  }

  /**
   * u adaptive controlled output command 
   */
  @MavlinkMessageField(
      position = 13,
      length = 4
  )
  public final float u() {
    return u;
  }

  public class Builder {
    private PidTuningAxis axis;

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

    private Builder() {
    }

    /**
     * axis 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder axis(PidTuningAxis axis) {
      this.axis = axis;
      return this;
    }

    /**
     * desired rate (degrees/s) 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder desired(float desired) {
      this.desired = desired;
      return this;
    }

    /**
     * achieved rate (degrees/s) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder achieved(float achieved) {
      this.achieved = achieved;
      return this;
    }

    /**
     * error between model and vehicle 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder error(float error) {
      this.error = error;
      return this;
    }

    /**
     * theta estimated state predictor 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder theta(float theta) {
      this.theta = theta;
      return this;
    }

    /**
     * omega estimated state predictor 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder omega(float omega) {
      this.omega = omega;
      return this;
    }

    /**
     * sigma estimated state predictor 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder sigma(float sigma) {
      this.sigma = sigma;
      return this;
    }

    /**
     * theta derivative 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4
    )
    public final Builder thetaDot(float thetaDot) {
      this.thetaDot = thetaDot;
      return this;
    }

    /**
     * omega derivative 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4
    )
    public final Builder omegaDot(float omegaDot) {
      this.omegaDot = omegaDot;
      return this;
    }

    /**
     * sigma derivative 
     */
    @MavlinkMessageField(
        position = 10,
        length = 4
    )
    public final Builder sigmaDot(float sigmaDot) {
      this.sigmaDot = sigmaDot;
      return this;
    }

    /**
     * projection operator value 
     */
    @MavlinkMessageField(
        position = 11,
        length = 4
    )
    public final Builder f(float f) {
      this.f = f;
      return this;
    }

    /**
     * projection operator derivative 
     */
    @MavlinkMessageField(
        position = 12,
        length = 4
    )
    public final Builder fDot(float fDot) {
      this.fDot = fDot;
      return this;
    }

    /**
     * u adaptive controlled output command 
     */
    @MavlinkMessageField(
        position = 13,
        length = 4
    )
    public final Builder u(float u) {
      this.u = u;
      return this;
    }

    public final AdapTuning build() {
      return new AdapTuning(axis, desired, achieved, error, theta, omega, sigma, thetaDot, omegaDot, sigmaDot, f, fDot, u);
    }
  }
}
