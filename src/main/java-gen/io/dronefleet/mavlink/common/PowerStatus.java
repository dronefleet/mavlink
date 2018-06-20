package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.Override;
import java.lang.String;

/**
 * Power supply status 
 */
@MavlinkMessageInfo(
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

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "PowerStatus{vcc=" + vcc
         + ", vservo=" + vservo
         + ", flags=" + flags + "}";
  }

  /**
   * 5V rail voltage in millivolts 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 2
  )
  public final int vcc() {
    return vcc;
  }

  /**
   * servo rail voltage in millivolts 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 2
  )
  public final int vservo() {
    return vservo;
  }

  /**
   * power supply status flags (see {@link io.dronefleet.mavlink.common.MavPowerStatus MavPowerStatus} enum) 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 2
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
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 2
    )
    public final Builder vcc(int vcc) {
      this.vcc = vcc;
      return this;
    }

    /**
     * servo rail voltage in millivolts 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 2
    )
    public final Builder vservo(int vservo) {
      this.vservo = vservo;
      return this;
    }

    /**
     * power supply status flags (see {@link io.dronefleet.mavlink.common.MavPowerStatus MavPowerStatus} enum) 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 2
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
