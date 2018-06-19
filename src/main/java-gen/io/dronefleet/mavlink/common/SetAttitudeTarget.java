package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Float;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Sets a desired vehicle attitude. Used by an external controller to command the vehicle (manual 
 * controller or other system). 
 */
@MavlinkMessage(
    id = 82,
    crc = 49
)
public final class SetAttitudeTarget {
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
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * Mappings: If any of these bits are set, the corresponding input should be ignored: bit 1: body 
   * roll rate, bit 2: body pitch rate, bit 3: body yaw rate. bit 4-bit 6: reserved, bit 7: throttle, 
   * bit 8: attitude 
   */
  private final int typeMask;

  private SetAttitudeTarget(long timeBootMs, List<Float> q, float bodyRollRate, float bodyPitchRate,
      float bodyYawRate, float thrust, int targetSystem, int targetComponent, int typeMask) {
    this.timeBootMs = timeBootMs;
    this.q = q;
    this.bodyRollRate = bodyRollRate;
    this.bodyPitchRate = bodyPitchRate;
    this.bodyYawRate = bodyYawRate;
    this.thrust = thrust;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.typeMask = typeMask;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "SetAttitudeTarget{timeBootMs=" + timeBootMs
         + ", targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
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
      position = 5,
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
      position = 6,
      unitSize = 4
  )
  public final float bodyRollRate() {
    return bodyRollRate;
  }

  /**
   * Body pitch rate in radians per second 
   */
  @MavlinkMessageField(
      position = 7,
      unitSize = 4
  )
  public final float bodyPitchRate() {
    return bodyPitchRate;
  }

  /**
   * Body yaw rate in radians per second 
   */
  @MavlinkMessageField(
      position = 8,
      unitSize = 4
  )
  public final float bodyYawRate() {
    return bodyYawRate;
  }

  /**
   * Collective thrust, normalized to 0 .. 1 (-1 .. 1 for vehicles capable of reverse trust) 
   */
  @MavlinkMessageField(
      position = 9,
      unitSize = 4
  )
  public final float thrust() {
    return thrust;
  }

  /**
   * System ID 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Component ID 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * Mappings: If any of these bits are set, the corresponding input should be ignored: bit 1: body 
   * roll rate, bit 2: body pitch rate, bit 3: body yaw rate. bit 4-bit 6: reserved, bit 7: throttle, 
   * bit 8: attitude 
   */
  @MavlinkMessageField(
      position = 4,
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

    private int targetSystem;

    private int targetComponent;

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
        position = 5,
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
        position = 6,
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
        position = 7,
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
        position = 8,
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
        position = 9,
        unitSize = 4
    )
    public final Builder thrust(float thrust) {
      this.thrust = thrust;
      return this;
    }

    /**
     * System ID 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 1
    )
    public final Builder targetSystem(int targetSystem) {
      this.targetSystem = targetSystem;
      return this;
    }

    /**
     * Component ID 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 1
    )
    public final Builder targetComponent(int targetComponent) {
      this.targetComponent = targetComponent;
      return this;
    }

    /**
     * Mappings: If any of these bits are set, the corresponding input should be ignored: bit 1: body 
     * roll rate, bit 2: body pitch rate, bit 3: body yaw rate. bit 4-bit 6: reserved, bit 7: throttle, 
     * bit 8: attitude 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 1
    )
    public final Builder typeMask(int typeMask) {
      this.typeMask = typeMask;
      return this;
    }

    public final SetAttitudeTarget build() {
      return new SetAttitudeTarget(timeBootMs, q, bodyRollRate, bodyPitchRate, bodyYawRate, thrust, targetSystem, targetComponent, typeMask);
    }
  }
}
