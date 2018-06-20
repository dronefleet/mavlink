package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;

/**
 * Set the vehicle attitude and body angular rates. 
 */
@MavlinkMessageInfo(
    id = 140,
    crc = 181
)
public final class ActuatorControlTarget {
  /**
   * Timestamp (micros since boot or Unix epoch) 
   */
  private final BigInteger timeUsec;

  /**
   * Actuator controls. Normed to -1..+1 where 0 is neutral position. Throttle for single rotation 
   * direction motors is 0..1, negative range for reverse direction. Standard mapping for 
   * attitude controls (group 0): (index 0-7): roll, pitch, yaw, throttle, flaps, spoilers, 
   * airbrakes, landing gear. Load a pass-through mixer to repurpose them as generic outputs. 
   */
  private final List<Float> controls;

  /**
   * Actuator group. The "_mlx" indicates this is a multi-instance message and a MAVLink parser 
   * should use this field to difference between instances. 
   */
  private final int groupMlx;

  private ActuatorControlTarget(BigInteger timeUsec, List<Float> controls, int groupMlx) {
    this.timeUsec = timeUsec;
    this.controls = controls;
    this.groupMlx = groupMlx;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "ActuatorControlTarget{timeUsec=" + timeUsec
         + ", groupMlx=" + groupMlx
         + ", controls=" + controls + "}";
  }

  /**
   * Timestamp (micros since boot or Unix epoch) 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * Actuator controls. Normed to -1..+1 where 0 is neutral position. Throttle for single rotation 
   * direction motors is 0..1, negative range for reverse direction. Standard mapping for 
   * attitude controls (group 0): (index 0-7): roll, pitch, yaw, throttle, flaps, spoilers, 
   * airbrakes, landing gear. Load a pass-through mixer to repurpose them as generic outputs. 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 4,
      arraySize = 8
  )
  public final List<Float> controls() {
    return controls;
  }

  /**
   * Actuator group. The "_mlx" indicates this is a multi-instance message and a MAVLink parser 
   * should use this field to difference between instances. 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final int groupMlx() {
    return groupMlx;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private List<Float> controls;

    private int groupMlx;

    private Builder() {
    }

    /**
     * Timestamp (micros since boot or Unix epoch) 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 8
    )
    public final Builder timeUsec(BigInteger timeUsec) {
      this.timeUsec = timeUsec;
      return this;
    }

    /**
     * Actuator controls. Normed to -1..+1 where 0 is neutral position. Throttle for single rotation 
     * direction motors is 0..1, negative range for reverse direction. Standard mapping for 
     * attitude controls (group 0): (index 0-7): roll, pitch, yaw, throttle, flaps, spoilers, 
     * airbrakes, landing gear. Load a pass-through mixer to repurpose them as generic outputs. 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 4,
        arraySize = 8
    )
    public final Builder controls(List<Float> controls) {
      this.controls = controls;
      return this;
    }

    /**
     * Actuator group. The "_mlx" indicates this is a multi-instance message and a MAVLink parser 
     * should use this field to difference between instances. 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder groupMlx(int groupMlx) {
      this.groupMlx = groupMlx;
      return this;
    }

    public final ActuatorControlTarget build() {
      return new ActuatorControlTarget(timeUsec, controls, groupMlx);
    }
  }
}
