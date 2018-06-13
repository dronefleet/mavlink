package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Status of compassmot calibration 
 */
@MavlinkMessage(
    id = 177,
    crc = 240
)
public final class CompassmotStatus {
  /**
   * throttle (percent*10) 
   */
  private final int throttle;

  /**
   * current (Ampere) 
   */
  private final float current;

  /**
   * interference (percent) 
   */
  private final int interference;

  /**
   * Motor Compensation X 
   */
  private final float compensationx;

  /**
   * Motor Compensation Y 
   */
  private final float compensationy;

  /**
   * Motor Compensation Z 
   */
  private final float compensationz;

  private CompassmotStatus(int throttle, float current, int interference, float compensationx,
      float compensationy, float compensationz) {
    this.throttle = throttle;
    this.current = current;
    this.interference = interference;
    this.compensationx = compensationx;
    this.compensationy = compensationy;
    this.compensationz = compensationz;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * throttle (percent*10) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 2
  )
  public final int throttle() {
    return throttle;
  }

  /**
   * current (Ampere) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float current() {
    return current;
  }

  /**
   * interference (percent) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int interference() {
    return interference;
  }

  /**
   * Motor Compensation X 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float compensationx() {
    return compensationx;
  }

  /**
   * Motor Compensation Y 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float compensationy() {
    return compensationy;
  }

  /**
   * Motor Compensation Z 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float compensationz() {
    return compensationz;
  }

  public static class Builder {
    private int throttle;

    private float current;

    private int interference;

    private float compensationx;

    private float compensationy;

    private float compensationz;

    private Builder() {
    }

    /**
     * throttle (percent*10) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 2
    )
    public final Builder throttle(int throttle) {
      this.throttle = throttle;
      return this;
    }

    /**
     * current (Ampere) 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder current(float current) {
      this.current = current;
      return this;
    }

    /**
     * interference (percent) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder interference(int interference) {
      this.interference = interference;
      return this;
    }

    /**
     * Motor Compensation X 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder compensationx(float compensationx) {
      this.compensationx = compensationx;
      return this;
    }

    /**
     * Motor Compensation Y 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder compensationy(float compensationy) {
      this.compensationy = compensationy;
      return this;
    }

    /**
     * Motor Compensation Z 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder compensationz(float compensationz) {
      this.compensationz = compensationz;
      return this;
    }

    public final CompassmotStatus build() {
      return new CompassmotStatus(throttle, current, interference, compensationx, compensationy, compensationz);
    }
  }
}
