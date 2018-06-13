package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F7: format 
 */
@MavlinkMessage(
    id = 175,
    crc = 171
)
public final class SerialUdbExtraF7 {
  private final float sueYawkpRudder;

  private final float sueYawkdRudder;

  private final float sueRollkpRudder;

  private final float sueRollkdRudder;

  private final float sueRudderBoost;

  private final float sueRtlPitchDown;

  private SerialUdbExtraF7(float sueYawkpRudder, float sueYawkdRudder, float sueRollkpRudder,
      float sueRollkdRudder, float sueRudderBoost, float sueRtlPitchDown) {
    this.sueYawkpRudder = sueYawkpRudder;
    this.sueYawkdRudder = sueYawkdRudder;
    this.sueRollkpRudder = sueRollkpRudder;
    this.sueRollkdRudder = sueRollkdRudder;
    this.sueRudderBoost = sueRudderBoost;
    this.sueRtlPitchDown = sueRtlPitchDown;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Serial UDB YAWKP_RUDDER Gain for Proporional control of navigation 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final float sueYawkpRudder() {
    return sueYawkpRudder;
  }

  /**
   * Serial UDB YAWKD_RUDDER Gain for Rate control of navigation 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float sueYawkdRudder() {
    return sueYawkdRudder;
  }

  /**
   * Serial UDB Extra ROLLKP_RUDDER Gain for Proportional control of roll stabilization 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float sueRollkpRudder() {
    return sueRollkpRudder;
  }

  /**
   * Serial UDB Extra ROLLKD_RUDDER Gain for Rate control of roll stabilization 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float sueRollkdRudder() {
    return sueRollkdRudder;
  }

  /**
   * SERIAL UDB EXTRA Rudder Boost Gain to Manual Control when stabilized 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float sueRudderBoost() {
    return sueRudderBoost;
  }

  /**
   * Serial UDB Extra Return To Landing - Angle to Pitch Plane Down 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float sueRtlPitchDown() {
    return sueRtlPitchDown;
  }

  public class Builder {
    private float sueYawkpRudder;

    private float sueYawkdRudder;

    private float sueRollkpRudder;

    private float sueRollkdRudder;

    private float sueRudderBoost;

    private float sueRtlPitchDown;

    private Builder() {
    }

    /**
     * Serial UDB YAWKP_RUDDER Gain for Proporional control of navigation 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder sueYawkpRudder(float sueYawkpRudder) {
      this.sueYawkpRudder = sueYawkpRudder;
      return this;
    }

    /**
     * Serial UDB YAWKD_RUDDER Gain for Rate control of navigation 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder sueYawkdRudder(float sueYawkdRudder) {
      this.sueYawkdRudder = sueYawkdRudder;
      return this;
    }

    /**
     * Serial UDB Extra ROLLKP_RUDDER Gain for Proportional control of roll stabilization 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder sueRollkpRudder(float sueRollkpRudder) {
      this.sueRollkpRudder = sueRollkpRudder;
      return this;
    }

    /**
     * Serial UDB Extra ROLLKD_RUDDER Gain for Rate control of roll stabilization 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder sueRollkdRudder(float sueRollkdRudder) {
      this.sueRollkdRudder = sueRollkdRudder;
      return this;
    }

    /**
     * SERIAL UDB EXTRA Rudder Boost Gain to Manual Control when stabilized 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder sueRudderBoost(float sueRudderBoost) {
      this.sueRudderBoost = sueRudderBoost;
      return this;
    }

    /**
     * Serial UDB Extra Return To Landing - Angle to Pitch Plane Down 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder sueRtlPitchDown(float sueRtlPitchDown) {
      this.sueRtlPitchDown = sueRtlPitchDown;
      return this;
    }

    public final SerialUdbExtraF7 build() {
      return new SerialUdbExtraF7(sueYawkpRudder, sueYawkdRudder, sueRollkpRudder, sueRollkdRudder, sueRudderBoost, sueRtlPitchDown);
    }
  }
}
