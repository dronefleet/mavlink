package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Reply to LOG_REQUEST_DATA 
 */
@MavlinkMessage(
    id = 120,
    crc = 134
)
public final class LogData {
  private final int id;

  private final long ofs;

  private final int count;

  private final List<Integer> data;

  private LogData(int id, long ofs, int count, List<Integer> data) {
    this.id = id;
    this.ofs = ofs;
    this.count = count;
    this.data = data;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Log id (from LOG_ENTRY reply) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 2
  )
  public final int id() {
    return id;
  }

  /**
   * Offset into the log 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final long ofs() {
    return ofs;
  }

  /**
   * Number of bytes (zero for end of log) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int count() {
    return count;
  }

  /**
   * log data 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1,
      arraySize = 90
  )
  public final List<Integer> data() {
    return data;
  }

  public class Builder {
    private int id;

    private long ofs;

    private int count;

    private List<Integer> data;

    private Builder() {
    }

    /**
     * Log id (from LOG_ENTRY reply) 
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
     * Offset into the log 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder ofs(long ofs) {
      this.ofs = ofs;
      return this;
    }

    /**
     * Number of bytes (zero for end of log) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder count(int count) {
      this.count = count;
      return this;
    }

    /**
     * log data 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1,
        arraySize = 90
    )
    public final Builder data(List<Integer> data) {
      this.data = data;
      return this;
    }

    public final LogData build() {
      return new LogData(id, ofs, count, data);
    }
  }
}
