package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F5: format 
 */
@MavlinkMessage(
    id = 173,
    crc = 54
)
public final class SerialUdbExtraF5 {
  /**
   * Serial UDB YAWKP_AILERON Gain for Proporional control of navigation 
   */
  private final float sueYawkpAileron;

  /**
   * Serial UDB YAWKD_AILERON Gain for Rate control of navigation 
   */
  private final float sueYawkdAileron;

  /**
   * Serial UDB Extra ROLLKP Gain for Proportional control of roll stabilization 
   */
  private final float sueRollkp;

  /**
   * Serial UDB Extra ROLLKD Gain for Rate control of roll stabilization 
   */
  private final float sueRollkd;

  private SerialUdbExtraF5(float sueYawkpAileron, float sueYawkdAileron, float sueRollkp,
      float sueRollkd) {
    this.sueYawkpAileron = sueYawkpAileron;
    this.sueYawkdAileron = sueYawkdAileron;
    this.sueRollkp = sueRollkp;
    this.sueRollkd = sueRollkd;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "SerialUdbExtraF5{sueYawkpAileron=" + sueYawkpAileron
         + ", sueYawkdAileron=" + sueYawkdAileron
         + ", sueRollkp=" + sueRollkp
         + ", sueRollkd=" + sueRollkd + "}";
  }

  /**
   * Serial UDB YAWKP_AILERON Gain for Proporional control of navigation 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 4
  )
  public final float sueYawkpAileron() {
    return sueYawkpAileron;
  }

  /**
   * Serial UDB YAWKD_AILERON Gain for Rate control of navigation 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final float sueYawkdAileron() {
    return sueYawkdAileron;
  }

  /**
   * Serial UDB Extra ROLLKP Gain for Proportional control of roll stabilization 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final float sueRollkp() {
    return sueRollkp;
  }

  /**
   * Serial UDB Extra ROLLKD Gain for Rate control of roll stabilization 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final float sueRollkd() {
    return sueRollkd;
  }

  public static class Builder {
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
        unitSize = 4
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
        unitSize = 4
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
        unitSize = 4
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
        unitSize = 4
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
