package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Float;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Reports the current commanded attitude of the vehicle as specified by the autopilot. This 
 * should match the commands sent in a {@link io.dronefleet.mavlink.common.SetAttitudeTarget SetAttitudeTarget} message if the vehicle is being 
 * controlled this way. 
 */
@MavlinkMessage(
    id = 83,
    crc = 22
)
public final class AttitudeTarget {
  /**
   * Timestamp in milliseconds since system boot 
   */
  private final long timeBootMs;

  /**
   * Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
   */
  private final List<Float> q;

  /**
   * Body roll rate in radians per second 
   */
  private final float bodyRollRate;

  /**
   * Body pitch rate in radians per second 
   */
  private final float bodyPitchRate;

  /**
   * Body yaw rate in radians per second 
   */
  private final float bodyYawRate;

  /**
   * Collective thrust, normalized to 0 .. 1 (-1 .. 1 for vehicles capable of reverse trust) 
   */
  private final float thrust;

  /**
   * Mappings: If any of these bits are set, the corresponding input should be ignored: bit 1: body 
   * roll rate, bit 2: body pitch rate, bit 3: body yaw rate. bit 4-bit 7: reserved, bit 8: attitude 
   */
  private final int typeMask;

  private AttitudeTarget(long timeBootMs, List<Float> q, float bodyRollRate, float bodyPitchRate,
      float bodyYawRate, float thrust, int typeMask) {
    this.timeBootMs = timeBootMs;
    this.q = q;
    this.bodyRollRate = bodyRollRate;
    this.bodyPitchRate = bodyPitchRate;
    this.bodyYawRate = bodyYawRate;
    this.thrust = thrust;
    this.typeMask = typeMask;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "AttitudeTarget{timeBootMs=" + timeBootMs
         + ", typeMask=" + typeMask
         + ", q=" + q
         + ", bodyRollRate=" + bodyRollRate
         + ", bodyPitchRate=" + bodyPitchRate
         + ", bodyYawRate=" + bodyYawRate
         + ", thrust=" + thrust + "}";
  }

  /**
   * Timestamp in milliseconds since system boot 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  /**
   * Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4,
      arraySize = 4
  )
  public final List<Float> q() {
    return q;
  }

  /**
   * Body roll rate in radians per second 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final float bodyRollRate() {
    return bodyRollRate;
  }

  /**
   * Body pitch rate in radians per second 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 4
  )
  public final float bodyPitchRate() {
    return bodyPitchRate;
  }

  /**
   * Body yaw rate in radians per second 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 4
  )
  public final float bodyYawRate() {
    return bodyYawRate;
  }

  /**
   * Collective thrust, normalized to 0 .. 1 (-1 .. 1 for vehicles capable of reverse trust) 
   */
  @MavlinkMessageField(
      position = 7,
      unitSize = 4
  )
  public final float thrust() {
    return thrust;
  }

  /**
   * Mappings: If any of these bits are set, the corresponding input should be ignored: bit 1: body 
   * roll rate, bit 2: body pitch rate, bit 3: body yaw rate. bit 4-bit 7: reserved, bit 8: attitude 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final int typeMask() {
    return typeMask;
  }

  public static class Builder {
    private long timeBootMs;

    private List<Float> q;

    private float bodyRollRate;

    private float bodyPitchRate;

    private float bodyYawRate;

    private float thrust;

    private int typeMask;

    private Builder() {
    }

    /**
     * Timestamp in milliseconds since system boot 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 4
    )
    public final Builder timeBootMs(long timeBootMs) {
      this.timeBootMs = timeBootMs;
      return this;
    }

    /**
     * Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 4,
        arraySize = 4
    )
    public final Builder q(List<Float> q) {
      this.q = q;
      return this;
    }

    /**
     * Body roll rate in radians per second 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 4
    )
    public final Builder bodyRollRate(float bodyRollRate) {
      this.bodyRollRate = bodyRollRate;
      return this;
    }

    /**
     * Body pitch rate in radians per second 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 4
    )
    public final Builder bodyPitchRate(float bodyPitchRate) {
      this.bodyPitchRate = bodyPitchRate;
      return this;
    }

    /**
     * Body yaw rate in radians per second 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 4
    )
    public final Builder bodyYawRate(float bodyYawRate) {
      this.bodyYawRate = bodyYawRate;
      return this;
    }

    /**
     * Collective thrust, normalized to 0 .. 1 (-1 .. 1 for vehicles capable of reverse trust) 
     */
    @MavlinkMessageField(
        position = 7,
        unitSize = 4
    )
    public final Builder thrust(float thrust) {
      this.thrust = thrust;
      return this;
    }

    /**
     * Mappings: If any of these bits are set, the corresponding input should be ignored: bit 1: body 
     * roll rate, bit 2: body pitch rate, bit 3: body yaw rate. bit 4-bit 7: reserved, bit 8: attitude 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 1
    )
    public final Builder typeMask(int typeMask) {
      this.typeMask = typeMask;
      return this;
    }

    public final AttitudeTarget build() {
      return new AttitudeTarget(timeBootMs, q, bodyRollRate, bodyPitchRate, bodyYawRate, thrust, typeMask);
    }
  }
}
