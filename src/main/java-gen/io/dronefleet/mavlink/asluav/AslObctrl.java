package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * Off-board controls/commands for ASLUAVs 
 */
@MavlinkMessageInfo(
    id = 207,
    crc = 234
)
public final class AslObctrl {
  /**
   * Time since system start 
   */
  private final BigInteger timestamp;

  /**
   * Elevator command [~] 
   */
  private final float uelev;

  /**
   * Throttle command [~] 
   */
  private final float uthrot;

  /**
   * Throttle 2 command [~] 
   */
  private final float uthrot2;

  /**
   * Left aileron command [~] 
   */
  private final float uaill;

  /**
   * Right aileron command [~] 
   */
  private final float uailr;

  /**
   * Rudder command [~] 
   */
  private final float urud;

  /**
   * Off-board computer status 
   */
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

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "AslObctrl{timestamp=" + timestamp
         + ", uelev=" + uelev
         + ", uthrot=" + uthrot
         + ", uthrot2=" + uthrot2
         + ", uaill=" + uaill
         + ", uailr=" + uailr
         + ", urud=" + urud
         + ", obctrlStatus=" + obctrlStatus + "}";
  }

  /**
   * Time since system start 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 8
  )
  public final BigInteger timestamp() {
    return timestamp;
  }

  /**
   * Elevator command [~] 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 4
  )
  public final float uelev() {
    return uelev;
  }

  /**
   * Throttle command [~] 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 4
  )
  public final float uthrot() {
    return uthrot;
  }

  /**
   * Throttle 2 command [~] 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 4
  )
  public final float uthrot2() {
    return uthrot2;
  }

  /**
   * Left aileron command [~] 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final float uaill() {
    return uaill;
  }

  /**
   * Right aileron command [~] 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 4
  )
  public final float uailr() {
    return uailr;
  }

  /**
   * Rudder command [~] 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 4
  )
  public final float urud() {
    return urud;
  }

  /**
   * Off-board computer status 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 1
  )
  public final int obctrlStatus() {
    return obctrlStatus;
  }

  public static class Builder {
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
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 8
    )
    public final Builder timestamp(BigInteger timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    /**
     * Elevator command [~] 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 4
    )
    public final Builder uelev(float uelev) {
      this.uelev = uelev;
      return this;
    }

    /**
     * Throttle command [~] 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 4
    )
    public final Builder uthrot(float uthrot) {
      this.uthrot = uthrot;
      return this;
    }

    /**
     * Throttle 2 command [~] 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 4
    )
    public final Builder uthrot2(float uthrot2) {
      this.uthrot2 = uthrot2;
      return this;
    }

    /**
     * Left aileron command [~] 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder uaill(float uaill) {
      this.uaill = uaill;
      return this;
    }

    /**
     * Right aileron command [~] 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 4
    )
    public final Builder uailr(float uailr) {
      this.uailr = uailr;
      return this;
    }

    /**
     * Rudder command [~] 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 4
    )
    public final Builder urud(float urud) {
      this.urud = urud;
      return this;
    }

    /**
     * Off-board computer status 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 1
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
