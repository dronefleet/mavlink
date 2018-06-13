package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F6: format 
 */
@MavlinkMessage(
    id = 174,
    crc = 54
)
public final class SerialUdbExtraF6 {
  private final float suePitchgain;

  private final float suePitchkd;

  private final float sueRudderElevMix;

  private final float sueRollElevMix;

  private final float sueElevatorBoost;

  private SerialUdbExtraF6(float suePitchgain, float suePitchkd, float sueRudderElevMix,
      float sueRollElevMix, float sueElevatorBoost) {
    this.suePitchgain = suePitchgain;
    this.suePitchkd = suePitchkd;
    this.sueRudderElevMix = sueRudderElevMix;
    this.sueRollElevMix = sueRollElevMix;
    this.sueElevatorBoost = sueElevatorBoost;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Serial UDB Extra PITCHGAIN Proportional Control 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final float suePitchgain() {
    return suePitchgain;
  }

  /**
   * Serial UDB Extra Pitch Rate Control 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float suePitchkd() {
    return suePitchkd;
  }

  /**
   * Serial UDB Extra Rudder to Elevator Mix 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float sueRudderElevMix() {
    return sueRudderElevMix;
  }

  /**
   * Serial UDB Extra Roll to Elevator Mix 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float sueRollElevMix() {
    return sueRollElevMix;
  }

  /**
   * Gain For Boosting Manual Elevator control When Plane Stabilized 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float sueElevatorBoost() {
    return sueElevatorBoost;
  }

  public class Builder {
    private float suePitchgain;

    private float suePitchkd;

    private float sueRudderElevMix;

    private float sueRollElevMix;

    private float sueElevatorBoost;

    private Builder() {
    }

    /**
     * Serial UDB Extra PITCHGAIN Proportional Control 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder suePitchgain(float suePitchgain) {
      this.suePitchgain = suePitchgain;
      return this;
    }

    /**
     * Serial UDB Extra Pitch Rate Control 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder suePitchkd(float suePitchkd) {
      this.suePitchkd = suePitchkd;
      return this;
    }

    /**
     * Serial UDB Extra Rudder to Elevator Mix 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder sueRudderElevMix(float sueRudderElevMix) {
      this.sueRudderElevMix = sueRudderElevMix;
      return this;
    }

    /**
     * Serial UDB Extra Roll to Elevator Mix 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder sueRollElevMix(float sueRollElevMix) {
      this.sueRollElevMix = sueRollElevMix;
      return this;
    }

    /**
     * Gain For Boosting Manual Elevator control When Plane Stabilized 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder sueElevatorBoost(float sueElevatorBoost) {
      this.sueElevatorBoost = sueElevatorBoost;
      return this;
    }

    public final SerialUdbExtraF6 build() {
      return new SerialUdbExtraF6(suePitchgain, suePitchkd, sueRudderElevMix, sueRollElevMix, sueElevatorBoost);
    }
  }
}
