package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * Angle of Attack and Side Slip Angle 
 */
@MavlinkMessage(
    id = 11020,
    crc = 205
)
public final class AoaSsa {
  /**
   * Timestamp (micros since boot or Unix epoch) 
   */
  private final BigInteger timeUsec;

  /**
   * Angle of Attack (degrees) 
   */
  private final float aoa;

  /**
   * Side Slip Angle (degrees) 
   */
  private final float ssa;

  private AoaSsa(BigInteger timeUsec, float aoa, float ssa) {
    this.timeUsec = timeUsec;
    this.aoa = aoa;
    this.ssa = ssa;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "AoaSsa{timeUsec=" + timeUsec
         + ", aoa=" + aoa
         + ", ssa=" + ssa + "}";
  }

  /**
   * Timestamp (micros since boot or Unix epoch) 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * Angle of Attack (degrees) 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final float aoa() {
    return aoa;
  }

  /**
   * Side Slip Angle (degrees) 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final float ssa() {
    return ssa;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private float aoa;

    private float ssa;

    private Builder() {
    }

    /**
     * Timestamp (micros since boot or Unix epoch) 
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
     * Angle of Attack (degrees) 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder aoa(float aoa) {
      this.aoa = aoa;
      return this;
    }

    /**
     * Side Slip Angle (degrees) 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 4
    )
    public final Builder ssa(float ssa) {
      this.ssa = ssa;
      return this;
    }

    public final AoaSsa build() {
      return new AoaSsa(timeUsec, aoa, ssa);
    }
  }
}
