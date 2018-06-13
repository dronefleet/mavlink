package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Ack message during waypoint handling. The type field states if this message is a positive ack 
 * (type=0) or if an error happened (type=non-zero). 
 */
@MavlinkMessage(
    id = 47,
    crc = 153
)
public final class MissionAck {
  private final int targetSystem;

  private final int targetComponent;

  private final MavMissionResult type;

  private final MavMissionType missionType;

  private MissionAck(int targetSystem, int targetComponent, MavMissionResult type,
      MavMissionType missionType) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.type = type;
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
   * See MAV_MISSION_RESULT enum 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final MavMissionResult type() {
    return type;
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

    private MavMissionResult type;

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
     * See MAV_MISSION_RESULT enum 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder type(MavMissionResult type) {
      this.type = type;
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

    public final MissionAck build() {
      return new MissionAck(targetSystem, targetComponent, type, missionType);
    }
  }
}
