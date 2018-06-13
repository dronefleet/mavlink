package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Request a list of available logs. On some systems calling this may stop on-board logging until 
 * LOG_REQUEST_END is called. 
 */
@MavlinkMessage(
    id = 117,
    crc = 128
)
public final class LogRequestList {
  private final int targetSystem;

  private final int targetComponent;

  private final int start;

  private final int end;

  private LogRequestList(int targetSystem, int targetComponent, int start, int end) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.start = start;
    this.end = end;
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
   * First log id (0 for first available) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int start() {
    return start;
  }

  /**
   * Last log id (0xffff for last available) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int end() {
    return end;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private int start;

    private int end;

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
     * First log id (0 for first available) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder start(int start) {
      this.start = start;
      return this;
    }

    /**
     * Last log id (0xffff for last available) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder end(int end) {
      this.end = end;
      return this;
    }

    public final LogRequestList build() {
      return new LogRequestList(targetSystem, targetComponent, start, end);
    }
  }
}
