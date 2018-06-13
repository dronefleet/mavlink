package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Float;
import java.math.BigInteger;
import java.util.List;

/**
 * Sent from autopilot to simulation. Hardware in the loop control outputs (replacement for 
 * {@link io.dronefleet.mavlink.common.HilControls HilControls}) 
 */
@MavlinkMessage(
    id = 93,
    crc = 47
)
public final class HilActuatorControls {
  /**
   * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
   */
  private final BigInteger timeUsec;

  /**
   * Control outputs -1 .. 1. Channel assignment depends on the simulated hardware. 
   */
  private final List<Float> controls;

  /**
   * System mode ({@link io.dronefleet.mavlink.common.MavMode MavMode}), includes arming state. 
   */
  private final MavMode mode;

  /**
   * Flags as bitfield, reserved for future use. 
   */
  private final BigInteger flags;

  private HilActuatorControls(BigInteger timeUsec, List<Float> controls, MavMode mode,
      BigInteger flags) {
    this.timeUsec = timeUsec;
    this.controls = controls;
    this.mode = mode;
    this.flags = flags;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * Control outputs -1 .. 1. Channel assignment depends on the simulated hardware. 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4,
      arraySize = 16
  )
  public final List<Float> controls() {
    return controls;
  }

  /**
   * System mode ({@link io.dronefleet.mavlink.common.MavMode MavMode}), includes arming state. 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final MavMode mode() {
    return mode;
  }

  /**
   * Flags as bitfield, reserved for future use. 
   */
  @MavlinkMessageField(
      position = 4,
      length = 8
  )
  public final BigInteger flags() {
    return flags;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private List<Float> controls;

    private MavMode mode;

    private BigInteger flags;

    private Builder() {
    }

    /**
     * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
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
     * Control outputs -1 .. 1. Channel assignment depends on the simulated hardware. 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4,
        arraySize = 16
    )
    public final Builder controls(List<Float> controls) {
      this.controls = controls;
      return this;
    }

    /**
     * System mode ({@link io.dronefleet.mavlink.common.MavMode MavMode}), includes arming state. 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder mode(MavMode mode) {
      this.mode = mode;
      return this;
    }

    /**
     * Flags as bitfield, reserved for future use. 
     */
    @MavlinkMessageField(
        position = 4,
        length = 8
    )
    public final Builder flags(BigInteger flags) {
      this.flags = flags;
      return this;
    }

    public final HilActuatorControls build() {
      return new HilActuatorControls(timeUsec, controls, mode, flags);
    }
  }
}
