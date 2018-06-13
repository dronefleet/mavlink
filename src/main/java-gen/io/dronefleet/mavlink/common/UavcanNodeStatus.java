package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
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

  /**
   * Vendor-specific status information. 
   */
  private final int vendorSpecificStatusCode;

  private UavcanNodeStatus(BigInteger timeUsec, long uptimeSec, UavcanNodeHealth health,
      UavcanNodeMode mode, int subMode, int vendorSpecificStatusCode) {
    this.timeUsec = timeUsec;
    this.uptimeSec = uptimeSec;
    this.health = health;
    this.mode = mode;
    this.subMode = subMode;
    this.vendorSpecificStatusCode = vendorSpecificStatusCode;
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
   * The number of seconds since the start-up of the node. 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final long uptimeSec() {
    return uptimeSec;
  }

  /**
   * Generalized node health status. 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final UavcanNodeHealth health() {
    return health;
  }

  /**
   * Generalized operating mode. 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final UavcanNodeMode mode() {
    return mode;
  }

  /**
   * Not used currently. 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int subMode() {
    return subMode;
  }

  /**
   * Vendor-specific status information. 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int vendorSpecificStatusCode() {
    return vendorSpecificStatusCode;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private long uptimeSec;

    private UavcanNodeHealth health;

    private UavcanNodeMode mode;

    private int subMode;

    private int vendorSpecificStatusCode;

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
     * The number of seconds since the start-up of the node. 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder uptimeSec(long uptimeSec) {
      this.uptimeSec = uptimeSec;
      return this;
    }

    /**
     * Generalized node health status. 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
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
        length = 1
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
        length = 1
    )
    public final Builder subMode(int subMode) {
      this.subMode = subMode;
      return this;
    }

    /**
     * Vendor-specific status information. 
     */
    @MavlinkMessageField(
        position = 6,
        length = 2
    )
    public final Builder vendorSpecificStatusCode(int vendorSpecificStatusCode) {
      this.vendorSpecificStatusCode = vendorSpecificStatusCode;
      return this;
    }

    public final UavcanNodeStatus build() {
      return new UavcanNodeStatus(timeUsec, uptimeSec, health, mode, subMode, vendorSpecificStatusCode);
    }
  }
}
