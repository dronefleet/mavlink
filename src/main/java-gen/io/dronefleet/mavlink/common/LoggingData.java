package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * A message containing logged data (see also MAV_CMD_LOGGING_START) 
 */
@MavlinkMessage(
    id = 266,
    crc = 193
)
public final class LoggingData {
  /**
   * sequence number (can wrap) 
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

  private LoggingData(int sequence, int targetSystem, int targetComponent, int length,
      int firstMessageOffset, List<Integer> data) {
    this.sequence = sequence;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.length = length;
    this.firstMessageOffset = firstMessageOffset;
    this.data = data;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "LoggingData{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", sequence=" + sequence
         + ", length=" + length
         + ", firstMessageOffset=" + firstMessageOffset
         + ", data=" + data + "}";
  }

  /**
   * sequence number (can wrap) 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 2
  )
  public final int sequence() {
    return sequence;
  }

  /**
   * system ID of the target 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * component ID of the target 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * data length 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 1
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
      unitSize = 1
  )
  public final int firstMessageOffset() {
    return firstMessageOffset;
  }

  /**
   * logged data 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 1,
      arraySize = 249
  )
  public final List<Integer> data() {
    return data;
  }

  public static class Builder {
    private int sequence;

    private int targetSystem;

    private int targetComponent;

    private int length;

    private int firstMessageOffset;

    private List<Integer> data;

    private Builder() {
    }

    /**
     * sequence number (can wrap) 
     */
    @MavlinkMessageField(
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
    @MavlinkMessageField(
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
    @MavlinkMessageField(
        position = 2,
        unitSize = 1
    )
    public final Builder targetComponent(int targetComponent) {
      this.targetComponent = targetComponent;
      return this;
    }

    /**
     * data length 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 1
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
        unitSize = 1
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
        unitSize = 1,
        arraySize = 249
    )
    public final Builder data(List<Integer> data) {
      this.data = data;
      return this;
    }

    public final LoggingData build() {
      return new LoggingData(sequence, targetSystem, targetComponent, length, firstMessageOffset, data);
    }
  }
}
