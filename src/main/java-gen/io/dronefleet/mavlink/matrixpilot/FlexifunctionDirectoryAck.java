package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Acknowldge sucess or failure of a flexifunction command 
 */
@MavlinkMessage(
    id = 156,
    crc = 218
)
public final class FlexifunctionDirectoryAck {
  /**
   * result of acknowledge, 0=fail, 1=good 
   */
  private final int result;

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * 0=inputs, 1=outputs 
   */
  private final int directoryType;

  /**
   * index of first directory entry to write 
   */
  private final int startIndex;

  /**
   * count of directory entries to write 
   */
  private final int count;

  private FlexifunctionDirectoryAck(int result, int targetSystem, int targetComponent,
      int directoryType, int startIndex, int count) {
    this.result = result;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.directoryType = directoryType;
    this.startIndex = startIndex;
    this.count = count;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "FlexifunctionDirectoryAck{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", directoryType=" + directoryType
         + ", startIndex=" + startIndex
         + ", count=" + count
         + ", result=" + result + "}";
  }

  /**
   * result of acknowledge, 0=fail, 1=good 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 2
  )
  public final int result() {
    return result;
  }

  /**
   * System ID 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Component ID 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * 0=inputs, 1=outputs 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 1
  )
  public final int directoryType() {
    return directoryType;
  }

  /**
   * index of first directory entry to write 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 1
  )
  public final int startIndex() {
    return startIndex;
  }

  /**
   * count of directory entries to write 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 1
  )
  public final int count() {
    return count;
  }

  public static class Builder {
    private int result;

    private int targetSystem;

    private int targetComponent;

    private int directoryType;

    private int startIndex;

    private int count;

    private Builder() {
    }

    /**
     * result of acknowledge, 0=fail, 1=good 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 2
    )
    public final Builder result(int result) {
      this.result = result;
      return this;
    }

    /**
     * System ID 
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
     * Component ID 
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
     * 0=inputs, 1=outputs 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 1
    )
    public final Builder directoryType(int directoryType) {
      this.directoryType = directoryType;
      return this;
    }

    /**
     * index of first directory entry to write 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 1
    )
    public final Builder startIndex(int startIndex) {
      this.startIndex = startIndex;
      return this;
    }

    /**
     * count of directory entries to write 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 1
    )
    public final Builder count(int count) {
      this.count = count;
      return this;
    }

    public final FlexifunctionDirectoryAck build() {
      return new FlexifunctionDirectoryAck(result, targetSystem, targetComponent, directoryType, startIndex, count);
    }
  }
}
