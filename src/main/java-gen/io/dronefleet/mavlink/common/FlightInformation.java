package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.math.BigInteger;

/**
 * WIP: Information about flight since last arming 
 */
@MavlinkMessage(
    id = 264,
    crc = 49
)
public final class FlightInformation {
  /**
   * Timestamp (milliseconds since system boot) 
   */
  private final long timeBootMs;

  /**
   * Timestamp at arming (microseconds since UNIX epoch) in UTC, 0 for unknown 
   */
  private final BigInteger armingTimeUtc;

  /**
   * Timestamp at takeoff (microseconds since UNIX epoch) in UTC, 0 for unknown 
   */
  private final BigInteger takeoffTimeUtc;

  /**
   * Universally unique identifier (UUID) of flight, should correspond to name of logfiles 
   */
  private final BigInteger flightUuid;

  private FlightInformation(long timeBootMs, BigInteger armingTimeUtc, BigInteger takeoffTimeUtc,
      BigInteger flightUuid) {
    this.timeBootMs = timeBootMs;
    this.armingTimeUtc = armingTimeUtc;
    this.takeoffTimeUtc = takeoffTimeUtc;
    this.flightUuid = flightUuid;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (milliseconds since system boot) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  /**
   * Timestamp at arming (microseconds since UNIX epoch) in UTC, 0 for unknown 
   */
  @MavlinkMessageField(
      position = 2,
      length = 8
  )
  public final BigInteger armingTimeUtc() {
    return armingTimeUtc;
  }

  /**
   * Timestamp at takeoff (microseconds since UNIX epoch) in UTC, 0 for unknown 
   */
  @MavlinkMessageField(
      position = 3,
      length = 8
  )
  public final BigInteger takeoffTimeUtc() {
    return takeoffTimeUtc;
  }

  /**
   * Universally unique identifier (UUID) of flight, should correspond to name of logfiles 
   */
  @MavlinkMessageField(
      position = 4,
      length = 8
  )
  public final BigInteger flightUuid() {
    return flightUuid;
  }

  public static class Builder {
    private long timeBootMs;

    private BigInteger armingTimeUtc;

    private BigInteger takeoffTimeUtc;

    private BigInteger flightUuid;

    private Builder() {
    }

    /**
     * Timestamp (milliseconds since system boot) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder timeBootMs(long timeBootMs) {
      this.timeBootMs = timeBootMs;
      return this;
    }

    /**
     * Timestamp at arming (microseconds since UNIX epoch) in UTC, 0 for unknown 
     */
    @MavlinkMessageField(
        position = 2,
        length = 8
    )
    public final Builder armingTimeUtc(BigInteger armingTimeUtc) {
      this.armingTimeUtc = armingTimeUtc;
      return this;
    }

    /**
     * Timestamp at takeoff (microseconds since UNIX epoch) in UTC, 0 for unknown 
     */
    @MavlinkMessageField(
        position = 3,
        length = 8
    )
    public final Builder takeoffTimeUtc(BigInteger takeoffTimeUtc) {
      this.takeoffTimeUtc = takeoffTimeUtc;
      return this;
    }

    /**
     * Universally unique identifier (UUID) of flight, should correspond to name of logfiles 
     */
    @MavlinkMessageField(
        position = 4,
        length = 8
    )
    public final Builder flightUuid(BigInteger flightUuid) {
      this.flightUuid = flightUuid;
      return this;
    }

    public final FlightInformation build() {
      return new FlightInformation(timeBootMs, armingTimeUtc, takeoffTimeUtc, flightUuid);
    }
  }
}
