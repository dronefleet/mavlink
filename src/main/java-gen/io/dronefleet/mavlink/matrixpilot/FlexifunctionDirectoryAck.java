package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Acknowldge sucess or failure of a flexifunction command 
 */
@MavlinkMessage(
    id = 156,
    crc = 218
)
public final class FlexifunctionDirectoryAck {
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

  /**
   * result of acknowledge, 0=fail, 1=good 
   */
  private final int result;

  private FlexifunctionDirectoryAck(int targetSystem, int targetComponent, int directoryType,
      int startIndex, int count, int result) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.directoryType = directoryType;
    this.startIndex = startIndex;
    this.count = count;
    this.result = result;
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
   * 0=inputs, 1=outputs 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int directoryType() {
    return directoryType;
  }

  /**
   * index of first directory entry to write 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final int startIndex() {
    return startIndex;
  }

  /**
   * count of directory entries to write 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int count() {
    return count;
  }

  /**
   * result of acknowledge, 0=fail, 1=good 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int result() {
    return result;
  }

  public static class Builder {
    private int targetSystem;

    private int targetComponent;

    private int directoryType;

    private int startIndex;

    private int count;

    private int result;

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
     * 0=inputs, 1=outputs 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
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
        length = 1
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
        length = 1
    )
    public final Builder count(int count) {
      this.count = count;
      return this;
    }

    /**
     * result of acknowledge, 0=fail, 1=good 
     */
    @MavlinkMessageField(
        position = 6,
        length = 2
    )
    public final Builder result(int result) {
      this.result = result;
      return this;
    }

    public final FlexifunctionDirectoryAck build() {
      return new FlexifunctionDirectoryAck(targetSystem, targetComponent, directoryType, startIndex, count, result);
    }
  }
}
