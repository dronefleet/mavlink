package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.util.EnumFlagSet;

/**
 * Power supply status 
 */
@MavlinkMessage(
    id = 125,
    crc = 203
)
public final class PowerStatus {
  /**
   * 5V rail voltage in millivolts 
   */
  private final int vcc;

  /**
   * servo rail voltage in millivolts 
   */
  private final int vservo;

  /**
   * power supply status flags (see {@link io.dronefleet.mavlink.common.MavPowerStatus MavPowerStatus} enum) 
   */
  private final EnumFlagSet<MavPowerStatus> flags;

  private PowerStatus(int vcc, int vservo, EnumFlagSet<MavPowerStatus> flags) {
    this.vcc = vcc;
    this.vservo = vservo;
    this.flags = flags;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * 5V rail voltage in millivolts 
   */
  @MavlinkMessageField(
      position = 1,
      length = 2
  )
  public final int vcc() {
    return vcc;
  }

  /**
   * servo rail voltage in millivolts 
   */
  @MavlinkMessageField(
      position = 2,
      length = 2
  )
  public final int vservo() {
    return vservo;
  }

  /**
   * power supply status flags (see {@link io.dronefleet.mavlink.common.MavPowerStatus MavPowerStatus} enum) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final EnumFlagSet<MavPowerStatus> flags() {
    return flags;
  }

  public static class Builder {
    private int vcc;

    private int vservo;

    private EnumFlagSet<MavPowerStatus> flags;

    private Builder() {
    }

    /**
     * 5V rail voltage in millivolts 
     */
    @MavlinkMessageField(
        position = 1,
        length = 2
    )
    public final Builder vcc(int vcc) {
      this.vcc = vcc;
      return this;
    }

    /**
     * servo rail voltage in millivolts 
     */
    @MavlinkMessageField(
        position = 2,
        length = 2
    )
    public final Builder vservo(int vservo) {
      this.vservo = vservo;
      return this;
    }

    /**
     * power supply status flags (see {@link io.dronefleet.mavlink.common.MavPowerStatus MavPowerStatus} enum) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder flags(EnumFlagSet<MavPowerStatus> flags) {
      this.flags = flags;
      return this;
    }

    public final PowerStatus build() {
      return new PowerStatus(vcc, vservo, flags);
    }
  }
}
