package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Request a list of available logs. On some systems calling this may stop on-board logging until 
 * LOG_REQUEST_END is called. 
 */
@MavlinkMessageInfo(
    id = 117,
    crc = 128
)
public final class LogRequestList {
  /**
   * First log id (0 for first available) 
   */
  private final int start;

  /**
   * Last log id (0xffff for last available) 
   */
  private final int end;

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  private LogRequestList(int start, int end, int targetSystem, int targetComponent) {
    this.start = start;
    this.end = end;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "LogRequestList{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", start=" + start
         + ", end=" + end + "}";
  }

  /**
   * First log id (0 for first available) 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 2
  )
  public final int start() {
    return start;
  }

  /**
   * Last log id (0xffff for last available) 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 2
  )
  public final int end() {
    return end;
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
    private int start;

    private int end;

    private int targetSystem;

    private int targetComponent;

    private Builder() {
    }

    /**
     * First log id (0 for first available) 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 2
    )
    public final Builder start(int start) {
      this.start = start;
      return this;
    }

    /**
     * Last log id (0xffff for last available) 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 2
    )
    public final Builder end(int end) {
      this.end = end;
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

    public final LogRequestList build() {
      return new LogRequestList(start, end, targetSystem, targetComponent);
    }
  }
}
