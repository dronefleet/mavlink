package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * An ack for a {@link io.dronefleet.mavlink.common.LoggingDataAcked LoggingDataAcked} message 
 */
@MavlinkMessageInfo(
    id = 268,
    crc = 14
)
public final class LoggingAck {
  /**
   * sequence number (must match the one in {@link io.dronefleet.mavlink.common.LoggingDataAcked LoggingDataAcked}) 
   */
  private final int sequence;

  /**
   * system ID of the target 
   */
  private final int targetSystem;

  /**
   * component ID of the target 
   */
  private final int targetComponent;

  private LoggingAck(int sequence, int targetSystem, int targetComponent) {
    this.sequence = sequence;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "LoggingAck{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", sequence=" + sequence + "}";
  }

  /**
   * sequence number (must match the one in {@link io.dronefleet.mavlink.common.LoggingDataAcked LoggingDataAcked}) 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 2
  )
  public final int sequence() {
    return sequence;
  }

  /**
   * system ID of the target 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * component ID of the target 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  public static class Builder {
    private int sequence;

    private int targetSystem;

    private int targetComponent;

    private Builder() {
    }

    /**
     * sequence number (must match the one in {@link io.dronefleet.mavlink.common.LoggingDataAcked LoggingDataAcked}) 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 2
    )
    public final Builder sequence(int sequence) {
      this.sequence = sequence;
      return this;
    }

    /**
     * system ID of the target 
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
     * component ID of the target 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder targetComponent(int targetComponent) {
      this.targetComponent = targetComponent;
      return this;
    }

    public final LoggingAck build() {
      return new LoggingAck(sequence, targetSystem, targetComponent);
    }
  }
}
