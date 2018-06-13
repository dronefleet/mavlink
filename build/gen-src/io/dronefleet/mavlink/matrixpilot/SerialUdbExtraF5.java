package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F5: format 
 */
@MavlinkMessage(
    id = 173,
    crc = 54
)
public final class SerialUdbExtraF5 {
  private final float sueYawkpAileron;

  private final float sueYawkdAileron;

  private final float sueRollkp;

  private final float sueRollkd;

  private SerialUdbExtraF5(float sueYawkpAileron, float sueYawkdAileron, float sueRollkp,
      float sueRollkd) {
    this.sueYawkpAileron = sueYawkpAileron;
    this.sueYawkdAileron = sueYawkdAileron;
    this.sueRollkp = sueRollkp;
    this.sueRollkd = sueRollkd;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Serial UDB YAWKP_AILERON Gain for Proporional control of navigation 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final float sueYawkpAileron() {
    return sueYawkpAileron;
  }

  /**
   * Serial UDB YAWKD_AILERON Gain for Rate control of navigation 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float sueYawkdAileron() {
    return sueYawkdAileron;
  }

  /**
   * Serial UDB Extra ROLLKP Gain for Proportional control of roll stabilization 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float sueRollkp() {
    return sueRollkp;
  }

  /**
   * Serial UDB Extra ROLLKD Gain for Rate control of roll stabilization 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float sueRollkd() {
    return sueRollkd;
  }

  public class Builder {
    private float sueYawkpAileron;

    private float sueYawkdAileron;

    private float sueRollkp;

    private float sueRollkd;

    private Builder() {
    }

    /**
     * Serial UDB YAWKP_AILERON Gain for Proporional control of navigation 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder sueYawkpAileron(float sueYawkpAileron) {
      this.sueYawkpAileron = sueYawkpAileron;
      return this;
    }

    /**
     * Serial UDB YAWKD_AILERON Gain for Rate control of navigation 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder sueYawkdAileron(float sueYawkdAileron) {
      this.sueYawkdAileron = sueYawkdAileron;
      return this;
    }

    /**
     * Serial UDB Extra ROLLKP Gain for Proportional control of roll stabilization 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder sueRollkp(float sueRollkp) {
      this.sueRollkp = sueRollkp;
      return this;
    }

    /**
     * Serial UDB Extra ROLLKD Gain for Rate control of roll stabilization 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder sueRollkd(float sueRollkd) {
      this.sueRollkd = sueRollkd;
      return this;
    }

    public final SerialUdbExtraF5 build() {
      return new SerialUdbExtraF5(sueYawkpAileron, sueYawkdAileron, sueRollkp, sueRollkd);
    }
  }
}
