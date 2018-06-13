package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Request a partial list of mission items from the system/component. 
 * https://mavlink.io/en/protocol/mission.html. If start and end index are the same, just 
 * send one waypoint. 
 */
@MavlinkMessage(
    id = 37,
    crc = 212
)
public final class MissionRequestPartialList {
  private final int targetSystem;

  private final int targetComponent;

  private final int startIndex;

  private final int endIndex;

  private final MavMissionType missionType;

  private MissionRequestPartialList(int targetSystem, int targetComponent, int startIndex,
      int endIndex, MavMissionType missionType) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.startIndex = startIndex;
    this.endIndex = endIndex;
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
   * Start index, 0 by default 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int startIndex() {
    return startIndex;
  }

  /**
   * End index, -1 by default (-1: send list to end). Else a valid index of the list 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int endIndex() {
    return endIndex;
  }

  /**
   * Mission type, see MAV_MISSION_TYPE 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1,
      extension = true
  )
  public final MavMissionType missionType() {
    return missionType;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private int startIndex;

    private int endIndex;

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
     * Start index, 0 by default 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder startIndex(int startIndex) {
      this.startIndex = startIndex;
      return this;
    }

    /**
     * End index, -1 by default (-1: send list to end). Else a valid index of the list 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder endIndex(int endIndex) {
      this.endIndex = endIndex;
      return this;
    }

    /**
     * Mission type, see MAV_MISSION_TYPE 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1,
        extension = true
    )
    public final Builder missionType(MavMissionType missionType) {
      this.missionType = missionType;
      return this;
    }

    public final MissionRequestPartialList build() {
      return new MissionRequestPartialList(targetSystem, targetComponent, startIndex, endIndex, missionType);
    }
  }
}
