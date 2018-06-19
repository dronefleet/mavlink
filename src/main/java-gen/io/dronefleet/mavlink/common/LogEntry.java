package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Reply to {@link io.dronefleet.mavlink.common.LogRequestList LogRequestList} 
 */
@MavlinkMessage(
    id = 118,
    crc = 56
)
public final class LogEntry {
  /**
   * UTC timestamp of log in seconds since 1970, or 0 if not available 
   */
  private final long timeUtc;

  /**
   * Size of the log (may be approximate) in bytes 
   */
  private final long size;

  /**
   * Log id 
   */
  private final int id;

  /**
   * Total number of logs 
   */
  private final int numLogs;

  /**
   * High log number 
   */
  private final int lastLogNum;

  private LogEntry(long timeUtc, long size, int id, int numLogs, int lastLogNum) {
    this.timeUtc = timeUtc;
    this.size = size;
    this.id = id;
    this.numLogs = numLogs;
    this.lastLogNum = lastLogNum;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "LogEntry{id=" + id
         + ", numLogs=" + numLogs
         + ", lastLogNum=" + lastLogNum
         + ", timeUtc=" + timeUtc
         + ", size=" + size + "}";
  }

  /**
   * UTC timestamp of log in seconds since 1970, or 0 if not available 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final long timeUtc() {
    return timeUtc;
  }

  /**
   * Size of the log (may be approximate) in bytes 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 4
  )
  public final long size() {
    return size;
  }

  /**
   * Log id 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 2
  )
  public final int id() {
    return id;
  }

  /**
   * Total number of logs 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 2
  )
  public final int numLogs() {
    return numLogs;
  }

  /**
   * High log number 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 2
  )
  public final int lastLogNum() {
    return lastLogNum;
  }

  public static class Builder {
    private long timeUtc;

    private long size;

    private int id;

    private int numLogs;

    private int lastLogNum;

    private Builder() {
    }

    /**
     * UTC timestamp of log in seconds since 1970, or 0 if not available 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 4
    )
    public final Builder timeUtc(long timeUtc) {
      this.timeUtc = timeUtc;
      return this;
    }

    /**
     * Size of the log (may be approximate) in bytes 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 4
    )
    public final Builder size(long size) {
      this.size = size;
      return this;
    }

    /**
     * Log id 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 2
    )
    public final Builder id(int id) {
      this.id = id;
      return this;
    }

    /**
     * Total number of logs 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 2
    )
    public final Builder numLogs(int numLogs) {
      this.numLogs = numLogs;
      return this;
    }

    /**
     * High log number 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 2
    )
    public final Builder lastLogNum(int lastLogNum) {
      this.lastLogNum = lastLogNum;
      return this;
    }

    public final LogEntry build() {
      return new LogEntry(timeUtc, size, id, numLogs, lastLogNum);
    }
  }
}
