package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Message encoding a command with parameters as scaled integers. Scaling depends on the actual 
 * command value. 
 */
@MavlinkMessage(
    id = 75,
    crc = 158
)
public final class CommandInt {
  private final int targetSystem;

  private final int targetComponent;

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

  private CommandInt(int targetSystem, int targetComponent, MavFrame frame, MavCmd command,
      int current, int autocontinue, float param1, float param2, float param3, float param4, int x,
      int y, float z) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
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
   * The coordinate system of the COMMAND, as defined by MAV_FRAME enum 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final MavFrame frame() {
    return frame;
  }

  /**
   * The scheduled action for the mission item, as defined by MAV_CMD enum 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final MavCmd command() {
    return command;
  }

  /**
   * false:0, true:1 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int current() {
    return current;
  }

  /**
   * autocontinue to next wp 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1
  )
  public final int autocontinue() {
    return autocontinue;
  }

  /**
   * PARAM1, see MAV_CMD enum 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float param1() {
    return param1;
  }

  /**
   * PARAM2, see MAV_CMD enum 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float param2() {
    return param2;
  }

  /**
   * PARAM3, see MAV_CMD enum 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final float param3() {
    return param3;
  }

  /**
   * PARAM4, see MAV_CMD enum 
   */
  @MavlinkMessageField(
      position = 10,
      length = 4
  )
  public final float param4() {
    return param4;
  }

  /**
   * PARAM5 / local: x position in meters * 1e4, global: latitude in degrees * 10^7 
   */
  @MavlinkMessageField(
      position = 11,
      length = 4
  )
  public final int x() {
    return x;
  }

  /**
   * PARAM6 / local: y position in meters * 1e4, global: longitude in degrees * 10^7 
   */
  @MavlinkMessageField(
      position = 12,
      length = 4
  )
  public final int y() {
    return y;
  }

  /**
   * PARAM7 / z position: global: altitude in meters (relative or absolute, depending on frame. 
   */
  @MavlinkMessageField(
      position = 13,
      length = 4
  )
  public final float z() {
    return z;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

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
     * The coordinate system of the COMMAND, as defined by MAV_FRAME enum 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder frame(MavFrame frame) {
      this.frame = frame;
      return this;
    }

    /**
     * The scheduled action for the mission item, as defined by MAV_CMD enum 
     */
    @MavlinkMessageField(
        position = 4,
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
        position = 5,
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
        position = 6,
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
        position = 7,
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
        position = 8,
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
        position = 9,
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
        position = 10,
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
        position = 11,
        length = 4
    )
    public final Builder x(int x) {
      this.x = x;
      return this;
    }

    /**
     * PARAM6 / local: y position in meters * 1e4, global: longitude in degrees * 10^7 
     */
    @MavlinkMessageField(
        position = 12,
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
        position = 13,
        length = 4
    )
    public final Builder z(float z) {
      this.z = z;
      return this;
    }

    public final CommandInt build() {
      return new CommandInt(targetSystem, targetComponent, frame, command, current, autocontinue, param1, param2, param3, param4, x, y, z);
    }
  }
}
