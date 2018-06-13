package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Message encoding a mission item. This message is emitted to announce the presence of a mission 
 * item and to set a mission item on the system. The mission item can be either in x, y, z meters (type: 
 * LOCAL) or x:lat, y:lon, z:altitude. Local frame is Z-down, right handed (NED), global frame is 
 * Z-up, right handed (ENU). See also https://mavlink.io/en/protocol/mission.html. 
 */
@MavlinkMessage(
    id = 73,
    crc = 38
)
public final class MissionItemInt {
  private final int targetSystem;

  private final int targetComponent;

  private final int seq;

  private final MavFrame frame;

  private final MavCmd command;

  private final int current;

  private final int autocontinue;

  private final float param1;

  private final float param2;

  private final float param3;

  private final float param4;

  private final int x;

  private final int y;

  private final float z;

  private final MavMissionType missionType;

  private MissionItemInt(int targetSystem, int targetComponent, int seq, MavFrame frame,
      MavCmd command, int current, int autocontinue, float param1, float param2, float param3,
      float param4, int x, int y, float z, MavMissionType missionType) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.seq = seq;
    this.frame = frame;
    this.command = command;
    this.current = current;
    this.autocontinue = autocontinue;
    this.param1 = param1;
    this.param2 = param2;
    this.param3 = param3;
    this.param4 = param4;
    this.x = x;
    this.y = y;
    this.z = z;
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
   * Waypoint ID (sequence number). Starts at zero. Increases monotonically for each waypoint, no 
   * gaps in the sequence (0,1,2,3,4). 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int seq() {
    return seq;
  }

  /**
   * The coordinate system of the waypoint, as defined by MAV_FRAME enum 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final MavFrame frame() {
    return frame;
  }

  /**
   * The scheduled action for the waypoint, as defined by MAV_CMD enum 
   */
  @MavlinkMessageField(
      position = 5,
      length = 2
  )
  public final MavCmd command() {
    return command;
  }

  /**
   * false:0, true:1 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1
  )
  public final int current() {
    return current;
  }

  /**
   * autocontinue to next wp 
   */
  @MavlinkMessageField(
      position = 7,
      length = 1
  )
  public final int autocontinue() {
    return autocontinue;
  }

  /**
   * PARAM1, see MAV_CMD enum 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float param1() {
    return param1;
  }

  /**
   * PARAM2, see MAV_CMD enum 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final float param2() {
    return param2;
  }

  /**
   * PARAM3, see MAV_CMD enum 
   */
  @MavlinkMessageField(
      position = 10,
      length = 4
  )
  public final float param3() {
    return param3;
  }

  /**
   * PARAM4, see MAV_CMD enum 
   */
  @MavlinkMessageField(
      position = 11,
      length = 4
  )
  public final float param4() {
    return param4;
  }

  /**
   * PARAM5 / local: x position in meters * 1e4, global: latitude in degrees * 10^7 
   */
  @MavlinkMessageField(
      position = 12,
      length = 4
  )
  public final int x() {
    return x;
  }

  /**
   * PARAM6 / y position: local: x position in meters * 1e4, global: longitude in degrees *10^7 
   */
  @MavlinkMessageField(
      position = 13,
      length = 4
  )
  public final int y() {
    return y;
  }

  /**
   * PARAM7 / z position: global: altitude in meters (relative or absolute, depending on frame. 
   */
  @MavlinkMessageField(
      position = 14,
      length = 4
  )
  public final float z() {
    return z;
  }

  /**
   * Mission type, see MAV_MISSION_TYPE 
   */
  @MavlinkMessageField(
      position = 16,
      length = 1,
      extension = true
  )
  public final MavMissionType missionType() {
    return missionType;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private int seq;

    private MavFrame frame;

    private MavCmd command;

    private int current;

    private int autocontinue;

    private float param1;

    private float param2;

    private float param3;

    private float param4;

    private int x;

    private int y;

    private float z;

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
     * Waypoint ID (sequence number). Starts at zero. Increases monotonically for each waypoint, no 
     * gaps in the sequence (0,1,2,3,4). 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder seq(int seq) {
      this.seq = seq;
      return this;
    }

    /**
     * The coordinate system of the waypoint, as defined by MAV_FRAME enum 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder frame(MavFrame frame) {
      this.frame = frame;
      return this;
    }

    /**
     * The scheduled action for the waypoint, as defined by MAV_CMD enum 
     */
    @MavlinkMessageField(
        position = 5,
        length = 2
    )
    public final Builder command(MavCmd command) {
      this.command = command;
      return this;
    }

    /**
     * false:0, true:1 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1
    )
    public final Builder current(int current) {
      this.current = current;
      return this;
    }

    /**
     * autocontinue to next wp 
     */
    @MavlinkMessageField(
        position = 7,
        length = 1
    )
    public final Builder autocontinue(int autocontinue) {
      this.autocontinue = autocontinue;
      return this;
    }

    /**
     * PARAM1, see MAV_CMD enum 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4
    )
    public final Builder param1(float param1) {
      this.param1 = param1;
      return this;
    }

    /**
     * PARAM2, see MAV_CMD enum 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4
    )
    public final Builder param2(float param2) {
      this.param2 = param2;
      return this;
    }

    /**
     * PARAM3, see MAV_CMD enum 
     */
    @MavlinkMessageField(
        position = 10,
        length = 4
    )
    public final Builder param3(float param3) {
      this.param3 = param3;
      return this;
    }

    /**
     * PARAM4, see MAV_CMD enum 
     */
    @MavlinkMessageField(
        position = 11,
        length = 4
    )
    public final Builder param4(float param4) {
      this.param4 = param4;
      return this;
    }

    /**
     * PARAM5 / local: x position in meters * 1e4, global: latitude in degrees * 10^7 
     */
    @MavlinkMessageField(
        position = 12,
        length = 4
    )
    public final Builder x(int x) {
      this.x = x;
      return this;
    }

    /**
     * PARAM6 / y position: local: x position in meters * 1e4, global: longitude in degrees *10^7 
     */
    @MavlinkMessageField(
        position = 13,
        length = 4
    )
    public final Builder y(int y) {
      this.y = y;
      return this;
    }

    /**
     * PARAM7 / z position: global: altitude in meters (relative or absolute, depending on frame. 
     */
    @MavlinkMessageField(
        position = 14,
        length = 4
    )
    public final Builder z(float z) {
      this.z = z;
      return this;
    }

    /**
     * Mission type, see MAV_MISSION_TYPE 
     */
    @MavlinkMessageField(
        position = 16,
        length = 1,
        extension = true
    )
    public final Builder missionType(MavMissionType missionType) {
      this.missionType = missionType;
      return this;
    }

    public final MissionItemInt build() {
      return new MissionItemInt(targetSystem, targetComponent, seq, frame, command, current, autocontinue, param1, param2, param3, param4, x, y, z, missionType);
    }
  }
}
