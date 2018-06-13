package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * This message is emitted as response to MISSION_REQUEST_LIST by the MAV and to initiate a write 
 * transaction. The GCS can then request the individual mission item based on the knowledge of the 
 * total number of waypoints. 
 */
@MavlinkMessage(
    id = 44,
    crc = 221
)
public final class MissionCount {
  private final int targetSystem;

  private final int targetComponent;

  private final int count;

  private final MavMissionType missionType;

  private MissionCount(int targetSystem, int targetComponent, int count,
      MavMissionType missionType) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.count = count;
    this.missionType = missionType;
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
   * Number of mission items in the sequence 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int count() {
    return count;
  }

  /**
   * Mission type, see MAV_MISSION_TYPE 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1,
      extension = true
  )
  public final MavMissionType missionType() {
    return missionType;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private int count;

    private MavMissionType missionType;

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
     * Number of mission items in the sequence 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder count(int count) {
      this.count = count;
      return this;
    }

    /**
     * Mission type, see MAV_MISSION_TYPE 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1,
        extension = true
    )
    public final Builder missionType(MavMissionType missionType) {
      this.missionType = missionType;
      return this;
    }

    public final MissionCount build() {
      return new MissionCount(targetSystem, targetComponent, count, missionType);
    }
  }
}
