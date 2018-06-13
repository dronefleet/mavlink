package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.math.BigInteger;

/**
 * Off-board controls/commands for ASLUAVs 
 */
@MavlinkMessage(
    id = 207,
    crc = 234
)
public final class AslObctrl {
  private final BigInteger timestamp;

  private final float uelev;

  private final float uthrot;

  private final float uthrot2;

  private final float uaill;

  private final float uailr;

  private final float urud;

  private final int obctrlStatus;

  private AslObctrl(BigInteger timestamp, float uelev, float uthrot, float uthrot2, float uaill,
      float uailr, float urud, int obctrlStatus) {
    this.timestamp = timestamp;
    this.uelev = uelev;
    this.uthrot = uthrot;
    this.uthrot2 = uthrot2;
    this.uaill = uaill;
    this.uailr = uailr;
    this.urud = urud;
    this.obctrlStatus = obctrlStatus;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Time since system start 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger timestamp() {
    return timestamp;
  }

  /**
   * Elevator command [~] 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float uelev() {
    return uelev;
  }

  /**
   * Throttle command [~] 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float uthrot() {
    return uthrot;
  }

  /**
   * Throttle 2 command [~] 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float uthrot2() {
    return uthrot2;
  }

  /**
   * Left aileron command [~] 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float uaill() {
    return uaill;
  }

  /**
   * Right aileron command [~] 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float uailr() {
    return uailr;
  }

  /**
   * Rudder command [~] 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float urud() {
    return urud;
  }

  /**
   * Off-board computer status 
   */
  @MavlinkMessageField(
      position = 8,
      length = 1
  )
  public final int obctrlStatus() {
    return obctrlStatus;
  }

  public class Builder {
    private BigInteger timestamp;

    private float uelev;

    private float uthrot;

    private float uthrot2;

    private float uaill;

    private float uailr;

    private float urud;

    private int obctrlStatus;

    private Builder() {
    }

    /**
     * Time since system start 
     */
    @MavlinkMessageField(
        position = 1,
        length = 8
    )
    public final Builder timestamp(BigInteger timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    /**
     * Elevator command [~] 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder uelev(float uelev) {
      this.uelev = uelev;
      return this;
    }

    /**
     * Throttle command [~] 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder uthrot(float uthrot) {
      this.uthrot = uthrot;
      return this;
    }

    /**
     * Throttle 2 command [~] 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder uthrot2(float uthrot2) {
      this.uthrot2 = uthrot2;
      return this;
    }

    /**
     * Left aileron command [~] 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder uaill(float uaill) {
      this.uaill = uaill;
      return this;
    }

    /**
     * Right aileron command [~] 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder uailr(float uailr) {
      this.uailr = uailr;
      return this;
    }

    /**
     * Rudder command [~] 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder urud(float urud) {
      this.urud = urud;
      return this;
    }

    /**
     * Off-board computer status 
     */
    @MavlinkMessageField(
        position = 8,
        length = 1
    )
    public final Builder obctrlStatus(int obctrlStatus) {
      this.obctrlStatus = obctrlStatus;
      return this;
    }

    public final AslObctrl build() {
      return new AslObctrl(timestamp, uelev, uthrot, uthrot2, uaill, uailr, urud, obctrlStatus);
    }
  }
}
