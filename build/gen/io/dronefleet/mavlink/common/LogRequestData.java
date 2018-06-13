package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Request a chunk of a log 
 */
@MavlinkMessage(
    id = 119,
    crc = 116
)
public final class LogRequestData {
  private final int targetSystem;

  private final int targetComponent;

  private final int id;

  private final long ofs;

  private final long count;

  private LogRequestData(int targetSystem, int targetComponent, int id, long ofs, long count) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.id = id;
    this.ofs = ofs;
    this.count = count;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * System ID 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Component ID 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * Log id (from LOG_ENTRY reply) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int id() {
    return id;
  }

  /**
   * Offset into the log 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final long ofs() {
    return ofs;
  }

  /**
   * Number of bytes 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final long count() {
    return count;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private int id;

    private long ofs;

    private long count;

    private Builder() {
    }

    /**
     * System ID 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder targetSystem(int targetSystem) {
      this.targetSystem = targetSystem;
      return this;
    }

    /**
     * Component ID 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder targetComponent(int targetComponent) {
      this.targetComponent = targetComponent;
      return this;
    }

    /**
     * Log id (from LOG_ENTRY reply) 
     */
    @MavlinkMessageField(
        position = 3,
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
        position = 4,
        length = 4
    )
    public final Builder ofs(long ofs) {
      this.ofs = ofs;
      return this;
    }

    /**
     * Number of bytes 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder count(long count) {
      this.count = count;
      return this;
    }

    public final LogRequestData build() {
      return new LogRequestData(targetSystem, targetComponent, id, ofs, count);
    }
  }
}
