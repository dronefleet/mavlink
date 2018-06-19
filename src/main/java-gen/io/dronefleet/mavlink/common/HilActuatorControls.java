package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Float;
import java.lang.Override;
import java.lang.String;
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
   * Flags as bitfield, reserved for future use. 
   */
  private final BigInteger flags;

  /**
   * Control outputs -1 .. 1. Channel assignment depends on the simulated hardware. 
   */
  private final List<Float> controls;

  /**
   * System mode ({@link io.dronefleet.mavlink.common.MavMode MavMode}), includes arming state. 
   */
  private final MavMode mode;

  private HilActuatorControls(BigInteger timeUsec, BigInteger flags, List<Float> controls,
      MavMode mode) {
    this.timeUsec = timeUsec;
    this.flags = flags;
    this.controls = controls;
    this.mode = mode;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "HilActuatorControls{timeUsec=" + timeUsec
         + ", controls=" + controls
         + ", mode=" + mode
         + ", flags=" + flags + "}";
  }

  /**
   * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * Flags as bitfield, reserved for future use. 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 8
  )
  public final BigInteger flags() {
    return flags;
  }

  /**
   * Control outputs -1 .. 1. Channel assignment depends on the simulated hardware. 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4,
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
      unitSize = 1
  )
  public final MavMode mode() {
    return mode;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private BigInteger flags;

    private List<Float> controls;

    private MavMode mode;

    private Builder() {
    }

    /**
     * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 8
    )
    public final Builder timeUsec(BigInteger timeUsec) {
      this.timeUsec = timeUsec;
      return this;
    }

    /**
     * Flags as bitfield, reserved for future use. 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 8
    )
    public final Builder flags(BigInteger flags) {
      this.flags = flags;
      return this;
    }

    /**
     * Control outputs -1 .. 1. Channel assignment depends on the simulated hardware. 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4,
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
        unitSize = 1
    )
    public final Builder mode(MavMode mode) {
      this.mode = mode;
      return this;
    }

    public final HilActuatorControls build() {
      return new HilActuatorControls(timeUsec, flags, controls, mode);
    }
  }
}
