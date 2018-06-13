package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * A message containing logged data which requires a LOGGING_ACK to be sent back 
 */
@MavlinkMessage(
    id = 267,
    crc = 35
)
public final class LoggingDataAcked {
  /**
   * system ID of the target 
   */
  private final int targetSystem;

  /**
   * component ID of the target 
   */
  private final int targetComponent;

  /**
   * sequence number (can wrap) 
   */
  private final int sequence;

  /**
   * data length 
   */
  private final int length;

  /**
   * offset into data where first message starts. This can be used for recovery, when a previous 
   * message got lost (set to 255 if no start exists). 
   */
  private final int firstMessageOffset;

  /**
   * logged data 
   */
  private final List<Integer> data;

  private LoggingDataAcked(int targetSystem, int targetComponent, int sequence, int length,
      int firstMessageOffset, List<Integer> data) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.sequence = sequence;
    this.length = length;
    this.firstMessageOffset = firstMessageOffset;
    this.data = data;
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
   * sequence number (can wrap) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int sequence() {
    return sequence;
  }

  /**
   * data length 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final int length() {
    return length;
  }

  /**
   * offset into data where first message starts. This can be used for recovery, when a previous 
   * message got lost (set to 255 if no start exists). 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int firstMessageOffset() {
    return firstMessageOffset;
  }

  /**
   * logged data 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1,
      arraySize = 249
  )
  public final List<Integer> data() {
    return data;
  }

  public static class Builder {
    private int targetSystem;

    private int targetComponent;

    private int sequence;

    private int length;

    private int firstMessageOffset;

    private List<Integer> data;

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
     * sequence number (can wrap) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder sequence(int sequence) {
      this.sequence = sequence;
      return this;
    }

    /**
     * data length 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder length(int length) {
      this.length = length;
      return this;
    }

    /**
     * offset into data where first message starts. This can be used for recovery, when a previous 
     * message got lost (set to 255 if no start exists). 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder firstMessageOffset(int firstMessageOffset) {
      this.firstMessageOffset = firstMessageOffset;
      return this;
    }

    /**
     * logged data 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1,
        arraySize = 249
    )
    public final Builder data(List<Integer> data) {
      this.data = data;
      return this;
    }

    public final LoggingDataAcked build() {
      return new LoggingDataAcked(targetSystem, targetComponent, sequence, length, firstMessageOffset, data);
    }
  }
}
