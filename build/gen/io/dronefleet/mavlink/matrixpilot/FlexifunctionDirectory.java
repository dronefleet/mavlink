package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Acknowldge sucess or failure of a flexifunction command 
 */
@MavlinkMessage(
    id = 155,
    crc = 12
)
public final class FlexifunctionDirectory {
  private final int targetSystem;

  private final int targetComponent;

  private final int directoryType;

  private final int startIndex;

  private final int count;

  private final List<Integer> directoryData;

  private FlexifunctionDirectory(int targetSystem, int targetComponent, int directoryType,
      int startIndex, int count, List<Integer> directoryData) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.directoryType = directoryType;
    this.startIndex = startIndex;
    this.count = count;
    this.directoryData = directoryData;
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
   * Settings data 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1,
      arraySize = 48
  )
  public final List<Integer> directoryData() {
    return directoryData;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private int directoryType;

    private int startIndex;

    private int count;

    private List<Integer> directoryData;

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
     * Settings data 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1,
        arraySize = 48
    )
    public final Builder directoryData(List<Integer> directoryData) {
      this.directoryData = directoryData;
      return this;
    }

    public final FlexifunctionDirectory build() {
      return new FlexifunctionDirectory(targetSystem, targetComponent, directoryType, startIndex, count, directoryData);
    }
  }
}
