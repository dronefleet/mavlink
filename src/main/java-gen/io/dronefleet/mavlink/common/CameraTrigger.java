package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * Camera-IMU triggering and synchronisation message. 
 */
@MavlinkMessage(
    id = 112,
    crc = 174
)
public final class CameraTrigger {
  /**
   * Timestamp for the image frame in microseconds 
   */
  private final BigInteger timeUsec;

  /**
   * Image frame sequence 
   */
  private final long seq;

  private CameraTrigger(BigInteger timeUsec, long seq) {
    this.timeUsec = timeUsec;
    this.seq = seq;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "CameraTrigger{timeUsec=" + timeUsec
         + ", seq=" + seq + "}";
  }

  /**
   * Timestamp for the image frame in microseconds 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * Image frame sequence 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final long seq() {
    return seq;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private long seq;

    private Builder() {
    }

    /**
     * Timestamp for the image frame in microseconds 
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
     * Image frame sequence 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder seq(long seq) {
      this.seq = seq;
      return this;
    }

    public final CameraTrigger build() {
      return new CameraTrigger(timeUsec, seq);
    }
  }
}
