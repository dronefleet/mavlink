package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * General status information of an UAVCAN node. Please refer to the definition of the UAVCAN 
 * message "uavcan.protocol.NodeStatus" for the background information. The UAVCAN 
 * specification is available at http://uavcan.org. 
 */
@MavlinkMessage(
    id = 310,
    crc = 28
)
public final class UavcanNodeStatus {
  /**
   * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
   */
  private final BigInteger timeUsec;

  /**
   * The number of seconds since the start-up of the node. 
   */
  private final long uptimeSec;

  /**
   * Vendor-specific status information. 
   */
  private final int vendorSpecificStatusCode;

  /**
   * Generalized node health status. 
   */
  private final UavcanNodeHealth health;

  /**
   * Generalized operating mode. 
   */
  private final UavcanNodeMode mode;

  /**
   * Not used currently. 
   */
  private final int subMode;

  private UavcanNodeStatus(BigInteger timeUsec, long uptimeSec, int vendorSpecificStatusCode,
      UavcanNodeHealth health, UavcanNodeMode mode, int subMode) {
    this.timeUsec = timeUsec;
    this.uptimeSec = uptimeSec;
    this.vendorSpecificStatusCode = vendorSpecificStatusCode;
    this.health = health;
    this.mode = mode;
    this.subMode = subMode;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "UavcanNodeStatus{timeUsec=" + timeUsec
         + ", uptimeSec=" + uptimeSec
         + ", health=" + health
         + ", mode=" + mode
         + ", subMode=" + subMode
         + ", vendorSpecificStatusCode=" + vendorSpecificStatusCode + "}";
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
   * The number of seconds since the start-up of the node. 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final long uptimeSec() {
    return uptimeSec;
  }

  /**
   * Vendor-specific status information. 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 2
  )
  public final int vendorSpecificStatusCode() {
    return vendorSpecificStatusCode;
  }

  /**
   * Generalized node health status. 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 1
  )
  public final UavcanNodeHealth health() {
    return health;
  }

  /**
   * Generalized operating mode. 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 1
  )
  public final UavcanNodeMode mode() {
    return mode;
  }

  /**
   * Not used currently. 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 1
  )
  public final int subMode() {
    return subMode;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private long uptimeSec;

    private int vendorSpecificStatusCode;

    private UavcanNodeHealth health;

    private UavcanNodeMode mode;

    private int subMode;

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
     * The number of seconds since the start-up of the node. 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder uptimeSec(long uptimeSec) {
      this.uptimeSec = uptimeSec;
      return this;
    }

    /**
     * Vendor-specific status information. 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 2
    )
    public final Builder vendorSpecificStatusCode(int vendorSpecificStatusCode) {
      this.vendorSpecificStatusCode = vendorSpecificStatusCode;
      return this;
    }

    /**
     * Generalized node health status. 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 1
    )
    public final Builder health(UavcanNodeHealth health) {
      this.health = health;
      return this;
    }

    /**
     * Generalized operating mode. 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 1
    )
    public final Builder mode(UavcanNodeMode mode) {
      this.mode = mode;
      return this;
    }

    /**
     * Not used currently. 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 1
    )
    public final Builder subMode(int subMode) {
      this.subMode = subMode;
      return this;
    }

    public final UavcanNodeStatus build() {
      return new UavcanNodeStatus(timeUsec, uptimeSec, vendorSpecificStatusCode, health, mode, subMode);
    }
  }
}
