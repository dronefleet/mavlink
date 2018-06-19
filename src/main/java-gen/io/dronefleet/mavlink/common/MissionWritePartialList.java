package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * This message is sent to the MAV to write a partial list. If start index == end index, only one item 
 * will be transmitted / updated. If the start index is NOT 0 and above the current list size, this 
 * request should be REJECTED! 
 */
@MavlinkMessage(
    id = 38,
    crc = 9
)
public final class MissionWritePartialList {
  /**
   * Start index, 0 by default and smaller / equal to the largest index of the current onboard list. 
   */
  private final int startIndex;

  /**
   * End index, equal or greater than start index. 
   */
  private final int endIndex;

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
   */
  private final MavMissionType missionType;

  private MissionWritePartialList(int startIndex, int endIndex, int targetSystem,
      int targetComponent, MavMissionType missionType) {
    this.startIndex = startIndex;
    this.endIndex = endIndex;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.missionType = missionType;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "MissionWritePartialList{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", startIndex=" + startIndex
         + ", endIndex=" + endIndex
         + ", missionType=" + missionType + "}";
  }

  /**
   * Start index, 0 by default and smaller / equal to the largest index of the current onboard list. 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 2
  )
  public final int startIndex() {
    return startIndex;
  }

  /**
   * End index, equal or greater than start index. 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 2
  )
  public final int endIndex() {
    return endIndex;
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
   * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 1,
      extension = true
  )
  public final MavMissionType missionType() {
    return missionType;
  }

  public static class Builder {
    private int startIndex;

    private int endIndex;

    private int targetSystem;

    private int targetComponent;

    private MavMissionType missionType;

    private Builder() {
    }

    /**
     * Start index, 0 by default and smaller / equal to the largest index of the current onboard list. 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 2
    )
    public final Builder startIndex(int startIndex) {
      this.startIndex = startIndex;
      return this;
    }

    /**
     * End index, equal or greater than start index. 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 2
    )
    public final Builder endIndex(int endIndex) {
      this.endIndex = endIndex;
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
     * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 1,
        extension = true
    )
    public final Builder missionType(MavMissionType missionType) {
      this.missionType = missionType;
      return this;
    }

    public final MissionWritePartialList build() {
      return new MissionWritePartialList(startIndex, endIndex, targetSystem, targetComponent, missionType);
    }
  }
}
