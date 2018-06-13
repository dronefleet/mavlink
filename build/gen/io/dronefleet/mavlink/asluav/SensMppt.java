package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.math.BigInteger;

/**
 * Maximum Power Point Tracker (MPPT) sensor data for solar module power performance tracking 
 */
@MavlinkMessage(
    id = 202,
    crc = 231
)
public final class SensMppt {
  private final BigInteger mpptTimestamp;

  private final float mppt1Volt;

  private final float mppt1Amp;

  private final int mppt1Pwm;

  private final int mppt1Status;

  private final float mppt2Volt;

  private final float mppt2Amp;

  private final int mppt2Pwm;

  private final int mppt2Status;

  private final float mppt3Volt;

  private final float mppt3Amp;

  private final int mppt3Pwm;

  private final int mppt3Status;

  private SensMppt(BigInteger mpptTimestamp, float mppt1Volt, float mppt1Amp, int mppt1Pwm,
      int mppt1Status, float mppt2Volt, float mppt2Amp, int mppt2Pwm, int mppt2Status,
      float mppt3Volt, float mppt3Amp, int mppt3Pwm, int mppt3Status) {
    this.mpptTimestamp = mpptTimestamp;
    this.mppt1Volt = mppt1Volt;
    this.mppt1Amp = mppt1Amp;
    this.mppt1Pwm = mppt1Pwm;
    this.mppt1Status = mppt1Status;
    this.mppt2Volt = mppt2Volt;
    this.mppt2Amp = mppt2Amp;
    this.mppt2Pwm = mppt2Pwm;
    this.mppt2Status = mppt2Status;
    this.mppt3Volt = mppt3Volt;
    this.mppt3Amp = mppt3Amp;
    this.mppt3Pwm = mppt3Pwm;
    this.mppt3Status = mppt3Status;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * MPPT last timestamp 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger mpptTimestamp() {
    return mpptTimestamp;
  }

  /**
   * MPPT1 voltage 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float mppt1Volt() {
    return mppt1Volt;
  }

  /**
   * MPPT1 current 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float mppt1Amp() {
    return mppt1Amp;
  }

  /**
   * MPPT1 pwm 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int mppt1Pwm() {
    return mppt1Pwm;
  }

  /**
   * MPPT1 status 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int mppt1Status() {
    return mppt1Status;
  }

  /**
   * MPPT2 voltage 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float mppt2Volt() {
    return mppt2Volt;
  }

  /**
   * MPPT2 current 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float mppt2Amp() {
    return mppt2Amp;
  }

  /**
   * MPPT2 pwm 
   */
  @MavlinkMessageField(
      position = 8,
      length = 2
  )
  public final int mppt2Pwm() {
    return mppt2Pwm;
  }

  /**
   * MPPT2 status 
   */
  @MavlinkMessageField(
      position = 9,
      length = 1
  )
  public final int mppt2Status() {
    return mppt2Status;
  }

  /**
   * MPPT3 voltage 
   */
  @MavlinkMessageField(
      position = 10,
      length = 4
  )
  public final float mppt3Volt() {
    return mppt3Volt;
  }

  /**
   * MPPT3 current 
   */
  @MavlinkMessageField(
      position = 11,
      length = 4
  )
  public final float mppt3Amp() {
    return mppt3Amp;
  }

  /**
   * MPPT3 pwm 
   */
  @MavlinkMessageField(
      position = 12,
      length = 2
  )
  public final int mppt3Pwm() {
    return mppt3Pwm;
  }

  /**
   * MPPT3 status 
   */
  @MavlinkMessageField(
      position = 13,
      length = 1
  )
  public final int mppt3Status() {
    return mppt3Status;
  }

  public class Builder {
    private BigInteger mpptTimestamp;

    private float mppt1Volt;

    private float mppt1Amp;

    private int mppt1Pwm;

    private int mppt1Status;

    private float mppt2Volt;

    private float mppt2Amp;

    private int mppt2Pwm;

    private int mppt2Status;

    private float mppt3Volt;

    private float mppt3Amp;

    private int mppt3Pwm;

    private int mppt3Status;

    private Builder() {
    }

    /**
     * MPPT last timestamp 
     */
    @MavlinkMessageField(
        position = 1,
        length = 8
    )
    public final Builder mpptTimestamp(BigInteger mpptTimestamp) {
      this.mpptTimestamp = mpptTimestamp;
      return this;
    }

    /**
     * MPPT1 voltage 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder mppt1Volt(float mppt1Volt) {
      this.mppt1Volt = mppt1Volt;
      return this;
    }

    /**
     * MPPT1 current 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder mppt1Amp(float mppt1Amp) {
      this.mppt1Amp = mppt1Amp;
      return this;
    }

    /**
     * MPPT1 pwm 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder mppt1Pwm(int mppt1Pwm) {
      this.mppt1Pwm = mppt1Pwm;
      return this;
    }

    /**
     * MPPT1 status 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder mppt1Status(int mppt1Status) {
      this.mppt1Status = mppt1Status;
      return this;
    }

    /**
     * MPPT2 voltage 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder mppt2Volt(float mppt2Volt) {
      this.mppt2Volt = mppt2Volt;
      return this;
    }

    /**
     * MPPT2 current 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder mppt2Amp(float mppt2Amp) {
      this.mppt2Amp = mppt2Amp;
      return this;
    }

    /**
     * MPPT2 pwm 
     */
    @MavlinkMessageField(
        position = 8,
        length = 2
    )
    public final Builder mppt2Pwm(int mppt2Pwm) {
      this.mppt2Pwm = mppt2Pwm;
      return this;
    }

    /**
     * MPPT2 status 
     */
    @MavlinkMessageField(
        position = 9,
        length = 1
    )
    public final Builder mppt2Status(int mppt2Status) {
      this.mppt2Status = mppt2Status;
      return this;
    }

    /**
     * MPPT3 voltage 
     */
    @MavlinkMessageField(
        position = 10,
        length = 4
    )
    public final Builder mppt3Volt(float mppt3Volt) {
      this.mppt3Volt = mppt3Volt;
      return this;
    }

    /**
     * MPPT3 current 
     */
    @MavlinkMessageField(
        position = 11,
        length = 4
    )
    public final Builder mppt3Amp(float mppt3Amp) {
      this.mppt3Amp = mppt3Amp;
      return this;
    }

    /**
     * MPPT3 pwm 
     */
    @MavlinkMessageField(
        position = 12,
        length = 2
    )
    public final Builder mppt3Pwm(int mppt3Pwm) {
      this.mppt3Pwm = mppt3Pwm;
      return this;
    }

    /**
     * MPPT3 status 
     */
    @MavlinkMessageField(
        position = 13,
        length = 1
    )
    public final Builder mppt3Status(int mppt3Status) {
      this.mppt3Status = mppt3Status;
      return this;
    }

    public final SensMppt build() {
      return new SensMppt(mpptTimestamp, mppt1Volt, mppt1Amp, mppt1Pwm, mppt1Status, mppt2Volt, mppt2Amp, mppt2Pwm, mppt2Status, mppt3Volt, mppt3Amp, mppt3Pwm, mppt3Status);
    }
  }
}
