package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * This message is emitted as response to {@link io.dronefleet.mavlink.common.MissionRequestList MissionRequestList} by the MAV and to initiate a write 
 * transaction. The GCS can then request the individual mission item based on the knowledge of the 
 * total number of waypoints. 
 */
@MavlinkMessageInfo(
    id = 44,
    crc = 221
)
public final class MissionCount {
  /**
   * Number of mission items in the sequence 
   */
  private final int count;

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

  private MissionCount(int count, int targetSystem, int targetComponent,
      MavMissionType missionType) {
    this.count = count;
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
    return "MissionCount{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", count=" + count
         + ", missionType=" + missionType + "}";
  }

  /**
   * Number of mission items in the sequence 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 2
  )
  public final int count() {
    return count;
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

  /**
   * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 1,
      extension = true
  )
  public final MavMissionType missionType() {
    return missionType;
  }

  public static class Builder {
    private int count;

    private int targetSystem;

    private int targetComponent;

    private MavMissionType missionType;

    private Builder() {
    }

    /**
     * Number of mission items in the sequence 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 2
    )
    public final Builder count(int count) {
      this.count = count;
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

    /**
     * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 1,
        extension = true
    )
    public final Builder missionType(MavMissionType missionType) {
      this.missionType = missionType;
      return this;
    }

    public final MissionCount build() {
      return new MissionCount(count, targetSystem, targetComponent, missionType);
    }
  }
}
