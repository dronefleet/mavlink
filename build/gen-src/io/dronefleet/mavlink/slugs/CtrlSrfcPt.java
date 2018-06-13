package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.util.EnumFlagSet;

/**
 * This message sets the control surfaces for selective passthrough mode. 
 */
@MavlinkMessage(
    id = 181,
    crc = 104
)
public final class CtrlSrfcPt {
  private final int target;

  private final EnumFlagSet<ControlSurfaceFlag> bitfieldpt;

  private CtrlSrfcPt(int target, EnumFlagSet<ControlSurfaceFlag> bitfieldpt) {
    this.target = target;
    this.bitfieldpt = bitfieldpt;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * The system setting the commands 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int target() {
    return target;
  }

  /**
   * Bitfield containing the passthrough configuration, see CONTROL_SURFACE_FLAG ENUM. 
   */
  @MavlinkMessageField(
      position = 2,
      length = 2
  )
  public final EnumFlagSet<ControlSurfaceFlag> bitfieldpt() {
    return bitfieldpt;
  }

  public class Builder {
    private int target;

    private EnumFlagSet<ControlSurfaceFlag> bitfieldpt;

    private Builder() {
    }

    /**
     * The system setting the commands 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder target(int target) {
      this.target = target;
      return this;
    }

    /**
     * Bitfield containing the passthrough configuration, see CONTROL_SURFACE_FLAG ENUM. 
     */
    @MavlinkMessageField(
        position = 2,
        length = 2
    )
    public final Builder bitfieldpt(EnumFlagSet<ControlSurfaceFlag> bitfieldpt) {
      this.bitfieldpt = bitfieldpt;
      return this;
    }

    public final CtrlSrfcPt build() {
      return new CtrlSrfcPt(target, bitfieldpt);
    }
  }
}
