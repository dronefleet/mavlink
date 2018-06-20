package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Message encoding a command with parameters as scaled integers. Scaling depends on the actual 
 * command value. 
 */
@MavlinkMessageInfo(
    id = 75,
    crc = 158
)
public final class CommandInt {
  /**
   * PARAM1, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
   */
  private final float param1;

  /**
   * PARAM2, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
   */
  private final float param2;

  /**
   * PARAM3, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
   */
  private final float param3;

  /**
   * PARAM4, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
   */
  private final float param4;

  /**
   * PARAM5 / local: x position in meters * 1e4, global: latitude in degrees * 10^7 
   */
  private final int x;

  /**
   * PARAM6 / local: y position in meters * 1e4, global: longitude in degrees * 10^7 
   */
  private final int y;

  /**
   * PARAM7 / z position: global: altitude in meters (relative or absolute, depending on frame. 
   */
  private final float z;

  /**
   * The scheduled action for the mission item, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
   */
  private final MavCmd command;

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * The coordinate system of the COMMAND, as defined by {@link io.dronefleet.mavlink.common.MavFrame MavFrame} enum 
   */
  private final MavFrame frame;

  /**
   * false:0, true:1 
   */
  private final int current;

  /**
   * autocontinue to next wp 
   */
  private final int autocontinue;

  private CommandInt(float param1, float param2, float param3, float param4, int x, int y, float z,
      MavCmd command, int targetSystem, int targetComponent, MavFrame frame, int current,
      int autocontinue) {
    this.param1 = param1;
    this.param2 = param2;
    this.param3 = param3;
    this.param4 = param4;
    this.x = x;
    this.y = y;
    this.z = z;
    this.command = command;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.frame = frame;
    this.current = current;
    this.autocontinue = autocontinue;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "CommandInt{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", frame=" + frame
         + ", command=" + command
         + ", current=" + current
         + ", autocontinue=" + autocontinue
         + ", param1=" + param1
         + ", param2=" + param2
         + ", param3=" + param3
         + ", param4=" + param4
         + ", x=" + x
         + ", y=" + y
         + ", z=" + z + "}";
  }

  /**
   * PARAM1, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 4
  )
  public final float param1() {
    return param1;
  }

  /**
   * PARAM2, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 4
  )
  public final float param2() {
    return param2;
  }

  /**
   * PARAM3, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
   */
  @MavlinkFieldInfo(
      position = 9,
      unitSize = 4
  )
  public final float param3() {
    return param3;
  }

  /**
   * PARAM4, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
   */
  @MavlinkFieldInfo(
      position = 10,
      unitSize = 4
  )
  public final float param4() {
    return param4;
  }

  /**
   * PARAM5 / local: x position in meters * 1e4, global: latitude in degrees * 10^7 
   */
  @MavlinkFieldInfo(
      position = 11,
      unitSize = 4
  )
  public final int x() {
    return x;
  }

  /**
   * PARAM6 / local: y position in meters * 1e4, global: longitude in degrees * 10^7 
   */
  @MavlinkFieldInfo(
      position = 12,
      unitSize = 4
  )
  public final int y() {
    return y;
  }

  /**
   * PARAM7 / z position: global: altitude in meters (relative or absolute, depending on frame. 
   */
  @MavlinkFieldInfo(
      position = 13,
      unitSize = 4
  )
  public final float z() {
    return z;
  }

  /**
   * The scheduled action for the mission item, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 2
  )
  public final MavCmd command() {
    return command;
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
   * The coordinate system of the COMMAND, as defined by {@link io.dronefleet.mavlink.common.MavFrame MavFrame} enum 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1
  )
  public final MavFrame frame() {
    return frame;
  }

  /**
   * false:0, true:1 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 1
  )
  public final int current() {
    return current;
  }

  /**
   * autocontinue to next wp 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 1
  )
  public final int autocontinue() {
    return autocontinue;
  }

  public static class Builder {
    private float param1;

    private float param2;

    private float param3;

    private float param4;

    private int x;

    private int y;

    private float z;

    private MavCmd command;

    private int targetSystem;

    private int targetComponent;

    private MavFrame frame;

    private int current;

    private int autocontinue;

    private Builder() {
    }

    /**
     * PARAM1, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 4
    )
    public final Builder param1(float param1) {
      this.param1 = param1;
      return this;
    }

    /**
     * PARAM2, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 4
    )
    public final Builder param2(float param2) {
      this.param2 = param2;
      return this;
    }

    /**
     * PARAM3, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
     */
    @MavlinkFieldInfo(
        position = 9,
        unitSize = 4
    )
    public final Builder param3(float param3) {
      this.param3 = param3;
      return this;
    }

    /**
     * PARAM4, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
     */
    @MavlinkFieldInfo(
        position = 10,
        unitSize = 4
    )
    public final Builder param4(float param4) {
      this.param4 = param4;
      return this;
    }

    /**
     * PARAM5 / local: x position in meters * 1e4, global: latitude in degrees * 10^7 
     */
    @MavlinkFieldInfo(
        position = 11,
        unitSize = 4
    )
    public final Builder x(int x) {
      this.x = x;
      return this;
    }

    /**
     * PARAM6 / local: y position in meters * 1e4, global: longitude in degrees * 10^7 
     */
    @MavlinkFieldInfo(
        position = 12,
        unitSize = 4
    )
    public final Builder y(int y) {
      this.y = y;
      return this;
    }

    /**
     * PARAM7 / z position: global: altitude in meters (relative or absolute, depending on frame. 
     */
    @MavlinkFieldInfo(
        position = 13,
        unitSize = 4
    )
    public final Builder z(float z) {
      this.z = z;
      return this;
    }

    /**
     * The scheduled action for the mission item, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 2
    )
    public final Builder command(MavCmd command) {
      this.command = command;
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
     * The coordinate system of the COMMAND, as defined by {@link io.dronefleet.mavlink.common.MavFrame MavFrame} enum 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 1
    )
    public final Builder frame(MavFrame frame) {
      this.frame = frame;
      return this;
    }

    /**
     * false:0, true:1 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 1
    )
    public final Builder current(int current) {
      this.current = current;
      return this;
    }

    /**
     * autocontinue to next wp 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 1
    )
    public final Builder autocontinue(int autocontinue) {
      this.autocontinue = autocontinue;
      return this;
    }

    public final CommandInt build() {
      return new CommandInt(param1, param2, param3, param4, x, y, z, command, targetSystem, targetComponent, frame, current, autocontinue);
    }
  }
}
