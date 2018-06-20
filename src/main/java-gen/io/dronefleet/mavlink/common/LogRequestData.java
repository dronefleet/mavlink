package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Request a chunk of a log 
 */
@MavlinkMessageInfo(
    id = 119,
    crc = 116
)
public final class LogRequestData {
  /**
   * Offset into the log 
   */
  private final long ofs;

  /**
   * Number of bytes 
   */
  private final long count;

  /**
   * Log id (from {@link io.dronefleet.mavlink.common.LogEntry LogEntry} reply) 
   */
  private final int id;

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  private LogRequestData(long ofs, long count, int id, int targetSystem, int targetComponent) {
    this.ofs = ofs;
    this.count = count;
    this.id = id;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "LogRequestData{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", id=" + id
         + ", ofs=" + ofs
         + ", count=" + count + "}";
  }

  /**
   * Offset into the log 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 4
  )
  public final long ofs() {
    return ofs;
  }

  /**
   * Number of bytes 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final long count() {
    return count;
  }

  /**
   * Log id (from {@link io.dronefleet.mavlink.common.LogEntry LogEntry} reply) 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 2
  )
  public final int id() {
    return id;
  }

  /**
   * System ID 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Component ID 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  public static class Builder {
    private long ofs;

    private long count;

    private int id;

    private int targetSystem;

    private int targetComponent;

    private Builder() {
    }

    /**
     * Offset into the log 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 4
    )
    public final Builder ofs(long ofs) {
      this.ofs = ofs;
      return this;
    }

    /**
     * Number of bytes 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder count(long count) {
      this.count = count;
      return this;
    }

    /**
     * Log id (from {@link io.dronefleet.mavlink.common.LogEntry LogEntry} reply) 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 2
    )
    public final Builder id(int id) {
      this.id = id;
      return this;
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 1
    )
    public final Builder targetSystem(int targetSystem) {
      this.targetSystem = targetSystem;
      return this;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder targetComponent(int targetComponent) {
      this.targetComponent = targetComponent;
      return this;
    }

    public final LogRequestData build() {
      return new LogRequestData(ofs, count, id, targetSystem, targetComponent);
    }
  }
}
