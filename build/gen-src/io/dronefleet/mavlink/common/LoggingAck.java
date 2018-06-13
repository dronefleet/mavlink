package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * An ack for a LOGGING_DATA_ACKED message 
 */
@MavlinkMessage(
    id = 268,
    crc = 14
)
public final class LoggingAck {
  private final int targetSystem;

  private final int targetComponent;

  private final int sequence;

  private LoggingAck(int targetSystem, int targetComponent, int sequence) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.sequence = sequence;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * system ID of the target 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * component ID of the target 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * sequence number (must match the one in LOGGING_DATA_ACKED) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int sequence() {
    return sequence;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private int sequence;

    private Builder() {
    }

    /**
     * system ID of the target 
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
     * component ID of the target 
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
     * sequence number (must match the one in LOGGING_DATA_ACKED) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder sequence(int sequence) {
      this.sequence = sequence;
      return this;
    }

    public final LoggingAck build() {
      return new LoggingAck(targetSystem, targetComponent, sequence);
    }
  }
}
