package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F8: format 
 */
@MavlinkMessageInfo(
    id = 176,
    crc = 142
)
public final class SerialUdbExtraF8 {
  /**
   * Serial UDB Extra HEIGHT_TARGET_MAX 
   */
  private final float sueHeightTargetMax;

  /**
   * Serial UDB Extra HEIGHT_TARGET_MIN 
   */
  private final float sueHeightTargetMin;

  /**
   * Serial UDB Extra ALT_HOLD_THROTTLE_MIN 
   */
  private final float sueAltHoldThrottleMin;

  /**
   * Serial UDB Extra ALT_HOLD_THROTTLE_MAX 
   */
  private final float sueAltHoldThrottleMax;

  /**
   * Serial UDB Extra ALT_HOLD_PITCH_MIN 
   */
  private final float sueAltHoldPitchMin;

  /**
   * Serial UDB Extra ALT_HOLD_PITCH_MAX 
   */
  private final float sueAltHoldPitchMax;

  /**
   * Serial UDB Extra ALT_HOLD_PITCH_HIGH 
   */
  private final float sueAltHoldPitchHigh;

  private SerialUdbExtraF8(float sueHeightTargetMax, float sueHeightTargetMin,
      float sueAltHoldThrottleMin, float sueAltHoldThrottleMax, float sueAltHoldPitchMin,
      float sueAltHoldPitchMax, float sueAltHoldPitchHigh) {
    this.sueHeightTargetMax = sueHeightTargetMax;
    this.sueHeightTargetMin = sueHeightTargetMin;
    this.sueAltHoldThrottleMin = sueAltHoldThrottleMin;
    this.sueAltHoldThrottleMax = sueAltHoldThrottleMax;
    this.sueAltHoldPitchMin = sueAltHoldPitchMin;
    this.sueAltHoldPitchMax = sueAltHoldPitchMax;
    this.sueAltHoldPitchHigh = sueAltHoldPitchHigh;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "SerialUdbExtraF8{sueHeightTargetMax=" + sueHeightTargetMax
         + ", sueHeightTargetMin=" + sueHeightTargetMin
         + ", sueAltHoldThrottleMin=" + sueAltHoldThrottleMin
         + ", sueAltHoldThrottleMax=" + sueAltHoldThrottleMax
         + ", sueAltHoldPitchMin=" + sueAltHoldPitchMin
         + ", sueAltHoldPitchMax=" + sueAltHoldPitchMax
         + ", sueAltHoldPitchHigh=" + sueAltHoldPitchHigh + "}";
  }

  /**
   * Serial UDB Extra HEIGHT_TARGET_MAX 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 4
  )
  public final float sueHeightTargetMax() {
    return sueHeightTargetMax;
  }

  /**
   * Serial UDB Extra HEIGHT_TARGET_MIN 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 4
  )
  public final float sueHeightTargetMin() {
    return sueHeightTargetMin;
  }

  /**
   * Serial UDB Extra ALT_HOLD_THROTTLE_MIN 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 4
  )
  public final float sueAltHoldThrottleMin() {
    return sueAltHoldThrottleMin;
  }

  /**
   * Serial UDB Extra ALT_HOLD_THROTTLE_MAX 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 4
  )
  public final float sueAltHoldThrottleMax() {
    return sueAltHoldThrottleMax;
  }

  /**
   * Serial UDB Extra ALT_HOLD_PITCH_MIN 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final float sueAltHoldPitchMin() {
    return sueAltHoldPitchMin;
  }

  /**
   * Serial UDB Extra ALT_HOLD_PITCH_MAX 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 4
  )
  public final float sueAltHoldPitchMax() {
    return sueAltHoldPitchMax;
  }

  /**
   * Serial UDB Extra ALT_HOLD_PITCH_HIGH 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 4
  )
  public final float sueAltHoldPitchHigh() {
    return sueAltHoldPitchHigh;
  }

  public static class Builder {
    private float sueHeightTargetMax;

    private float sueHeightTargetMin;

    private float sueAltHoldThrottleMin;

    private float sueAltHoldThrottleMax;

    private float sueAltHoldPitchMin;

    private float sueAltHoldPitchMax;

    private float sueAltHoldPitchHigh;

    private Builder() {
    }

    /**
     * Serial UDB Extra HEIGHT_TARGET_MAX 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 4
    )
    public final Builder sueHeightTargetMax(float sueHeightTargetMax) {
      this.sueHeightTargetMax = sueHeightTargetMax;
      return this;
    }

    /**
     * Serial UDB Extra HEIGHT_TARGET_MIN 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 4
    )
    public final Builder sueHeightTargetMin(float sueHeightTargetMin) {
      this.sueHeightTargetMin = sueHeightTargetMin;
      return this;
    }

    /**
     * Serial UDB Extra ALT_HOLD_THROTTLE_MIN 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 4
    )
    public final Builder sueAltHoldThrottleMin(float sueAltHoldThrottleMin) {
      this.sueAltHoldThrottleMin = sueAltHoldThrottleMin;
      return this;
    }

    /**
     * Serial UDB Extra ALT_HOLD_THROTTLE_MAX 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 4
    )
    public final Builder sueAltHoldThrottleMax(float sueAltHoldThrottleMax) {
      this.sueAltHoldThrottleMax = sueAltHoldThrottleMax;
      return this;
    }

    /**
     * Serial UDB Extra ALT_HOLD_PITCH_MIN 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder sueAltHoldPitchMin(float sueAltHoldPitchMin) {
      this.sueAltHoldPitchMin = sueAltHoldPitchMin;
      return this;
    }

    /**
     * Serial UDB Extra ALT_HOLD_PITCH_MAX 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 4
    )
    public final Builder sueAltHoldPitchMax(float sueAltHoldPitchMax) {
      this.sueAltHoldPitchMax = sueAltHoldPitchMax;
      return this;
    }

    /**
     * Serial UDB Extra ALT_HOLD_PITCH_HIGH 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 4
    )
    public final Builder sueAltHoldPitchHigh(float sueAltHoldPitchHigh) {
      this.sueAltHoldPitchHigh = sueAltHoldPitchHigh;
      return this;
    }

    public final SerialUdbExtraF8 build() {
      return new SerialUdbExtraF8(sueHeightTargetMax, sueHeightTargetMin, sueAltHoldThrottleMin, sueAltHoldThrottleMax, sueAltHoldPitchMin, sueAltHoldPitchMax, sueAltHoldPitchHigh);
    }
  }
}
