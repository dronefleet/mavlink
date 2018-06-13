package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * PID tuning information 
 */
@MavlinkMessage(
    id = 194,
    crc = 98
)
public final class PidTuning {
  private final PidTuningAxis axis;

  private final float desired;

  private final float achieved;

  private final float ff;

  private final float p;

  private final float i;

  private final float d;

  private PidTuning(PidTuningAxis axis, float desired, float achieved, float ff, float p, float i,
      float d) {
    this.axis = axis;
    this.desired = desired;
    this.achieved = achieved;
    this.ff = ff;
    this.p = p;
    this.i = i;
    this.d = d;
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
   * FF component 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float ff() {
    return ff;
  }

  /**
   * P component 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float p() {
    return p;
  }

  /**
   * I component 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float i() {
    return i;
  }

  /**
   * D component 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float d() {
    return d;
  }

  public class Builder {
    private PidTuningAxis axis;

    private float desired;

    private float achieved;

    private float ff;

    private float p;

    private float i;

    private float d;

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
     * FF component 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder ff(float ff) {
      this.ff = ff;
      return this;
    }

    /**
     * P component 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder p(float p) {
      this.p = p;
      return this;
    }

    /**
     * I component 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder i(float i) {
      this.i = i;
      return this;
    }

    /**
     * D component 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder d(float d) {
      this.d = d;
      return this;
    }

    public final PidTuning build() {
      return new PidTuning(axis, desired, achieved, ff, p, i, d);
    }
  }
}
