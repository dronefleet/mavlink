package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Reply to {@link io.dronefleet.mavlink.common.LogRequestData LogRequestData} 
 */
@MavlinkMessageInfo(
    id = 120,
    crc = 134
)
public final class LogData {
  /**
   * Offset into the log 
   */
  private final long ofs;

  /**
   * Log id (from {@link io.dronefleet.mavlink.common.LogEntry LogEntry} reply) 
   */
  private final int id;

  /**
   * Number of bytes (zero for end of log) 
   */
  private final int count;

  /**
   * log data 
   */
  private final List<Integer> data;

  private LogData(long ofs, int id, int count, List<Integer> data) {
    this.ofs = ofs;
    this.id = id;
    this.count = count;
    this.data = data;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "LogData{id=" + id
         + ", ofs=" + ofs
         + ", count=" + count
         + ", data=" + data + "}";
  }

  /**
   * Offset into the log 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 4
  )
  public final long ofs() {
    return ofs;
  }

  /**
   * Log id (from {@link io.dronefleet.mavlink.common.LogEntry LogEntry} reply) 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 2
  )
  public final int id() {
    return id;
  }

  /**
   * Number of bytes (zero for end of log) 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1
  )
  public final int count() {
    return count;
  }

  /**
   * log data 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 1,
      arraySize = 90
  )
  public final List<Integer> data() {
    return data;
  }

  public static class Builder {
    private long ofs;

    private int id;

    private int count;

    private List<Integer> data;

    private Builder() {
    }

    /**
     * Offset into the log 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 4
    )
    public final Builder ofs(long ofs) {
      this.ofs = ofs;
      return this;
    }

    /**
     * Log id (from {@link io.dronefleet.mavlink.common.LogEntry LogEntry} reply) 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 2
    )
    public final Builder id(int id) {
      this.id = id;
      return this;
    }

    /**
     * Number of bytes (zero for end of log) 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 1
    )
    public final Builder count(int count) {
      this.count = count;
      return this;
    }

    /**
     * log data 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 1,
        arraySize = 90
    )
    public final Builder data(List<Integer> data) {
      this.data = data;
      return this;
    }

    public final LogData build() {
      return new LogData(ofs, id, count, data);
    }
  }
}
