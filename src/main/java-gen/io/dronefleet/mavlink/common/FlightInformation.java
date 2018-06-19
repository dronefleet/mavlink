package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;
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

  /**
   * Timestamp (milliseconds since system boot) 
   */
  private final long timeBootMs;

  private FlightInformation(BigInteger armingTimeUtc, BigInteger takeoffTimeUtc,
      BigInteger flightUuid, long timeBootMs) {
    this.armingTimeUtc = armingTimeUtc;
    this.takeoffTimeUtc = takeoffTimeUtc;
    this.flightUuid = flightUuid;
    this.timeBootMs = timeBootMs;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "FlightInformation{timeBootMs=" + timeBootMs
         + ", armingTimeUtc=" + armingTimeUtc
         + ", takeoffTimeUtc=" + takeoffTimeUtc
         + ", flightUuid=" + flightUuid + "}";
  }

  /**
   * Timestamp at arming (microseconds since UNIX epoch) in UTC, 0 for unknown 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 8
  )
  public final BigInteger armingTimeUtc() {
    return armingTimeUtc;
  }

  /**
   * Timestamp at takeoff (microseconds since UNIX epoch) in UTC, 0 for unknown 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 8
  )
  public final BigInteger takeoffTimeUtc() {
    return takeoffTimeUtc;
  }

  /**
   * Universally unique identifier (UUID) of flight, should correspond to name of logfiles 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 8
  )
  public final BigInteger flightUuid() {
    return flightUuid;
  }

  /**
   * Timestamp (milliseconds since system boot) 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  public static class Builder {
    private BigInteger armingTimeUtc;

    private BigInteger takeoffTimeUtc;

    private BigInteger flightUuid;

    private long timeBootMs;

    private Builder() {
    }

    /**
     * Timestamp at arming (microseconds since UNIX epoch) in UTC, 0 for unknown 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 8
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
        unitSize = 8
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
        unitSize = 8
    )
    public final Builder flightUuid(BigInteger flightUuid) {
      this.flightUuid = flightUuid;
      return this;
    }

    /**
     * Timestamp (milliseconds since system boot) 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 4
    )
    public final Builder timeBootMs(long timeBootMs) {
      this.timeBootMs = timeBootMs;
      return this;
    }

    public final FlightInformation build() {
      return new FlightInformation(armingTimeUtc, takeoffTimeUtc, flightUuid, timeBootMs);
    }
  }
}
