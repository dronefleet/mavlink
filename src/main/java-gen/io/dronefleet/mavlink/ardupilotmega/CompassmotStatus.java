package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Status of compassmot calibration 
 */
@MavlinkMessage(
    id = 177,
    crc = 240
)
public final class CompassmotStatus {
  /**
   * current (Ampere) 
   */
  private final float current;

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

  /**
   * throttle (percent*10) 
   */
  private final int throttle;

  /**
   * interference (percent) 
   */
  private final int interference;

  private CompassmotStatus(float current, float compensationx, float compensationy,
      float compensationz, int throttle, int interference) {
    this.current = current;
    this.compensationx = compensationx;
    this.compensationy = compensationy;
    this.compensationz = compensationz;
    this.throttle = throttle;
    this.interference = interference;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "CompassmotStatus{throttle=" + throttle
         + ", current=" + current
         + ", interference=" + interference
         + ", compensationx=" + compensationx
         + ", compensationy=" + compensationy
         + ", compensationz=" + compensationz + "}";
  }

  /**
   * current (Ampere) 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final float current() {
    return current;
  }

  /**
   * Motor Compensation X 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final float compensationx() {
    return compensationx;
  }

  /**
   * Motor Compensation Y 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 4
  )
  public final float compensationy() {
    return compensationy;
  }

  /**
   * Motor Compensation Z 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 4
  )
  public final float compensationz() {
    return compensationz;
  }

  /**
   * throttle (percent*10) 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 2
  )
  public final int throttle() {
    return throttle;
  }

  /**
   * interference (percent) 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 2
  )
  public final int interference() {
    return interference;
  }

  public static class Builder {
    private float current;

    private float compensationx;

    private float compensationy;

    private float compensationz;

    private int throttle;

    private int interference;

    private Builder() {
    }

    /**
     * current (Ampere) 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder current(float current) {
      this.current = current;
      return this;
    }

    /**
     * Motor Compensation X 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 4
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
        unitSize = 4
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
        unitSize = 4
    )
    public final Builder compensationz(float compensationz) {
      this.compensationz = compensationz;
      return this;
    }

    /**
     * throttle (percent*10) 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 2
    )
    public final Builder throttle(int throttle) {
      this.throttle = throttle;
      return this;
    }

    /**
     * interference (percent) 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 2
    )
    public final Builder interference(int interference) {
      this.interference = interference;
      return this;
    }

    public final CompassmotStatus build() {
      return new CompassmotStatus(current, compensationx, compensationy, compensationz, throttle, interference);
    }
  }
}
