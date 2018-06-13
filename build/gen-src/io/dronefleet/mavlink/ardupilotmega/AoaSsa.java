package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.math.BigInteger;

/**
 * Angle of Attack and Side Slip Angle 
 */
@MavlinkMessage(
    id = 11020,
    crc = 205
)
public final class AoaSsa {
  private final BigInteger timeUsec;

  private final float aoa;

  private final float ssa;

  private AoaSsa(BigInteger timeUsec, float aoa, float ssa) {
    this.timeUsec = timeUsec;
    this.aoa = aoa;
    this.ssa = ssa;
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
   * Angle of Attack (degrees) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float aoa() {
    return aoa;
  }

  /**
   * Side Slip Angle (degrees) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float ssa() {
    return ssa;
  }

  public class Builder {
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
        length = 8
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
        length = 4
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
        length = 4
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
