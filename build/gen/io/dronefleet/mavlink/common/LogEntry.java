package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Reply to LOG_REQUEST_LIST 
 */
@MavlinkMessage(
    id = 118,
    crc = 56
)
public final class LogEntry {
  private final int id;

  private final int numLogs;

  private final int lastLogNum;

  private final long timeUtc;

  private final long size;

  private LogEntry(int id, int numLogs, int lastLogNum, long timeUtc, long size) {
    this.id = id;
    this.numLogs = numLogs;
    this.lastLogNum = lastLogNum;
    this.timeUtc = timeUtc;
    this.size = size;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Log id 
   */
  @MavlinkMessageField(
      position = 1,
      length = 2
  )
  public final int id() {
    return id;
  }

  /**
   * Total number of logs 
   */
  @MavlinkMessageField(
      position = 2,
      length = 2
  )
  public final int numLogs() {
    return numLogs;
  }

  /**
   * High log number 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int lastLogNum() {
    return lastLogNum;
  }

  /**
   * UTC timestamp of log in seconds since 1970, or 0 if not available 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final long timeUtc() {
    return timeUtc;
  }

  /**
   * Size of the log (may be approximate) in bytes 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final long size() {
    return size;
  }

  public class Builder {
    private int id;

    private int numLogs;

    private int lastLogNum;

    private long timeUtc;

    private long size;

    private Builder() {
    }

    /**
     * Log id 
     */
    @MavlinkMessageField(
        position = 1,
        length = 2
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
        length = 2
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
        length = 2
    )
    public final Builder lastLogNum(int lastLogNum) {
      this.lastLogNum = lastLogNum;
      return this;
    }

    /**
     * UTC timestamp of log in seconds since 1970, or 0 if not available 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
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
        length = 4
    )
    public final Builder size(long size) {
      this.size = size;
      return this;
    }

    public final LogEntry build() {
      return new LogEntry(id, numLogs, lastLogNum, timeUtc, size);
    }
  }
}
