package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Float;
import java.math.BigInteger;
import java.util.List;

/**
 * Set the vehicle attitude and body angular rates. 
 */
@MavlinkMessage(
    id = 139,
    crc = 168
)
public final class SetActuatorControlTarget {
  /**
   * Timestamp (micros since boot or Unix epoch) 
   */
  private final BigInteger timeUsec;

  /**
   * Actuator group. The "_mlx" indicates this is a multi-instance message and a MAVLink parser 
   * should use this field to difference between instances. 
   */
  private final int groupMlx;

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * Actuator controls. Normed to -1..+1 where 0 is neutral position. Throttle for single rotation 
   * direction motors is 0..1, negative range for reverse direction. Standard mapping for 
   * attitude controls (group 0): (index 0-7): roll, pitch, yaw, throttle, flaps, spoilers, 
   * airbrakes, landing gear. Load a pass-through mixer to repurpose them as generic outputs. 
   */
  private final List<Float> controls;

  private SetActuatorControlTarget(BigInteger timeUsec, int groupMlx, int targetSystem,
      int targetComponent, List<Float> controls) {
    this.timeUsec = timeUsec;
    this.groupMlx = groupMlx;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.controls = controls;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (micros since boot or Unix epoch) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * Actuator group. The "_mlx" indicates this is a multi-instance message and a MAVLink parser 
   * should use this field to difference between instances. 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int groupMlx() {
    return groupMlx;
  }

  /**
   * System ID 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Component ID 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * Actuator controls. Normed to -1..+1 where 0 is neutral position. Throttle for single rotation 
   * direction motors is 0..1, negative range for reverse direction. Standard mapping for 
   * attitude controls (group 0): (index 0-7): roll, pitch, yaw, throttle, flaps, spoilers, 
   * airbrakes, landing gear. Load a pass-through mixer to repurpose them as generic outputs. 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4,
      arraySize = 8
  )
  public final List<Float> controls() {
    return controls;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private int groupMlx;

    private int targetSystem;

    private int targetComponent;

    private List<Float> controls;

    private Builder() {
    }

    /**
     * Timestamp (micros since boot or Unix epoch) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 8
    )
    public final Builder timeUsec(BigInteger timeUsec) {
      this.timeUsec = timeUsec;
      return this;
    }

    /**
     * Actuator group. The "_mlx" indicates this is a multi-instance message and a MAVLink parser 
     * should use this field to difference between instances. 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder groupMlx(int groupMlx) {
      this.groupMlx = groupMlx;
      return this;
    }

    /**
     * System ID 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder targetSystem(int targetSystem) {
      this.targetSystem = targetSystem;
      return this;
    }

    /**
     * Component ID 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder targetComponent(int targetComponent) {
      this.targetComponent = targetComponent;
      return this;
    }

    /**
     * Actuator controls. Normed to -1..+1 where 0 is neutral position. Throttle for single rotation 
     * direction motors is 0..1, negative range for reverse direction. Standard mapping for 
     * attitude controls (group 0): (index 0-7): roll, pitch, yaw, throttle, flaps, spoilers, 
     * airbrakes, landing gear. Load a pass-through mixer to repurpose them as generic outputs. 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4,
        arraySize = 8
    )
    public final Builder controls(List<Float> controls) {
      this.controls = controls;
      return this;
    }

    public final SetActuatorControlTarget build() {
      return new SetActuatorControlTarget(timeUsec, groupMlx, targetSystem, targetComponent, controls);
    }
  }
}
