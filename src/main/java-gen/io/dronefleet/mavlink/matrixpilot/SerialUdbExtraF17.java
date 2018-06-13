package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F17 format 
 */
@MavlinkMessage(
    id = 183,
    crc = 175
)
public final class SerialUdbExtraF17 {
  /**
   * SUE Feed Forward Gain 
   */
  private final float sueFeedForward;

  /**
   * SUE Max Turn Rate when Navigating 
   */
  private final float sueTurnRateNav;

  /**
   * SUE Max Turn Rate in Fly By Wire Mode 
   */
  private final float sueTurnRateFbw;

  private SerialUdbExtraF17(float sueFeedForward, float sueTurnRateNav, float sueTurnRateFbw) {
    this.sueFeedForward = sueFeedForward;
    this.sueTurnRateNav = sueTurnRateNav;
    this.sueTurnRateFbw = sueTurnRateFbw;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * SUE Feed Forward Gain 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final float sueFeedForward() {
    return sueFeedForward;
  }

  /**
   * SUE Max Turn Rate when Navigating 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float sueTurnRateNav() {
    return sueTurnRateNav;
  }

  /**
   * SUE Max Turn Rate in Fly By Wire Mode 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float sueTurnRateFbw() {
    return sueTurnRateFbw;
  }

  public static class Builder {
    private float sueFeedForward;

    private float sueTurnRateNav;

    private float sueTurnRateFbw;

    private Builder() {
    }

    /**
     * SUE Feed Forward Gain 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder sueFeedForward(float sueFeedForward) {
      this.sueFeedForward = sueFeedForward;
      return this;
    }

    /**
     * SUE Max Turn Rate when Navigating 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder sueTurnRateNav(float sueTurnRateNav) {
      this.sueTurnRateNav = sueTurnRateNav;
      return this;
    }

    /**
     * SUE Max Turn Rate in Fly By Wire Mode 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder sueTurnRateFbw(float sueTurnRateFbw) {
      this.sueTurnRateFbw = sueTurnRateFbw;
      return this;
    }

    public final SerialUdbExtraF17 build() {
      return new SerialUdbExtraF17(sueFeedForward, sueTurnRateNav, sueTurnRateFbw);
    }
  }
}
