package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Float;
import java.util.List;

/**
 * Reports the current commanded attitude of the vehicle as specified by the autopilot. This 
 * should match the commands sent in a SET_ATTITUDE_TARGET message if the vehicle is being 
 * controlled this way. 
 */
@MavlinkMessage(
    id = 83,
    crc = 22
)
public final class AttitudeTarget {
  private final long timeBootMs;

  private final int typeMask;

  private final List<Float> q;

  private final float bodyRollRate;

  private final float bodyPitchRate;

  private final float bodyYawRate;

  private final float thrust;

  private AttitudeTarget(long timeBootMs, int typeMask, List<Float> q, float bodyRollRate,
      float bodyPitchRate, float bodyYawRate, float thrust) {
    this.timeBootMs = timeBootMs;
    this.typeMask = typeMask;
    this.q = q;
    this.bodyRollRate = bodyRollRate;
    this.bodyPitchRate = bodyPitchRate;
    this.bodyYawRate = bodyYawRate;
    this.thrust = thrust;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp in milliseconds since system boot 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  /**
   * Mappings: If any of these bits are set, the corresponding input should be ignored: bit 1: body 
   * roll rate, bit 2: body pitch rate, bit 3: body yaw rate. bit 4-bit 7: reserved, bit 8: attitude 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int typeMask() {
    return typeMask;
  }

  /**
   * Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4,
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
      length = 4
  )
  public final float bodyRollRate() {
    return bodyRollRate;
  }

  /**
   * Body pitch rate in radians per second 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float bodyPitchRate() {
    return bodyPitchRate;
  }

  /**
   * Body yaw rate in radians per second 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float bodyYawRate() {
    return bodyYawRate;
  }

  /**
   * Collective thrust, normalized to 0 .. 1 (-1 .. 1 for vehicles capable of reverse trust) 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float thrust() {
    return thrust;
  }

  public class Builder {
    private long timeBootMs;

    private int typeMask;

    private List<Float> q;

    private float bodyRollRate;

    private float bodyPitchRate;

    private float bodyYawRate;

    private float thrust;

    private Builder() {
    }

    /**
     * Timestamp in milliseconds since system boot 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder timeBootMs(long timeBootMs) {
      this.timeBootMs = timeBootMs;
      return this;
    }

    /**
     * Mappings: If any of these bits are set, the corresponding input should be ignored: bit 1: body 
     * roll rate, bit 2: body pitch rate, bit 3: body yaw rate. bit 4-bit 7: reserved, bit 8: attitude 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder typeMask(int typeMask) {
      this.typeMask = typeMask;
      return this;
    }

    /**
     * Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4,
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
        length = 4
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
        length = 4
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
        length = 4
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
        length = 4
    )
    public final Builder thrust(float thrust) {
      this.thrust = thrust;
      return this;
    }

    public final AttitudeTarget build() {
      return new AttitudeTarget(timeBootMs, typeMask, q, bodyRollRate, bodyPitchRate, bodyYawRate, thrust);
    }
  }
}
