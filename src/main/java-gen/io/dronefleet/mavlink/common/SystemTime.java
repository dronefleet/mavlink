package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * The system time is the time of the master clock, typically the computer clock of the main onboard 
 * computer. 
 */
@MavlinkMessage(
    id = 2,
    crc = 137
)
public final class SystemTime {
  /**
   * Timestamp of the master clock in microseconds since UNIX epoch. 
   */
  private final BigInteger timeUnixUsec;

  /**
   * Timestamp of the component clock since boot time in milliseconds. 
   */
  private final long timeBootMs;

  private SystemTime(BigInteger timeUnixUsec, long timeBootMs) {
    this.timeUnixUsec = timeUnixUsec;
    this.timeBootMs = timeBootMs;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "SystemTime{timeUnixUsec=" + timeUnixUsec
         + ", timeBootMs=" + timeBootMs + "}";
  }

  /**
   * Timestamp of the master clock in microseconds since UNIX epoch. 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 8
  )
  public final BigInteger timeUnixUsec() {
    return timeUnixUsec;
  }

  /**
   * Timestamp of the component clock since boot time in milliseconds. 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  public static class Builder {
    private BigInteger timeUnixUsec;

    private long timeBootMs;

    private Builder() {
    }

    /**
     * Timestamp of the master clock in microseconds since UNIX epoch. 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 8
    )
    public final Builder timeUnixUsec(BigInteger timeUnixUsec) {
      this.timeUnixUsec = timeUnixUsec;
      return this;
    }

    /**
     * Timestamp of the component clock since boot time in milliseconds. 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder timeBootMs(long timeBootMs) {
      this.timeBootMs = timeBootMs;
      return this;
    }

    public final SystemTime build() {
      return new SystemTime(timeUnixUsec, timeBootMs);
    }
  }
}
