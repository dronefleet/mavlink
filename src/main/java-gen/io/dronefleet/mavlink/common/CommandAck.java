package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Report status of a command. Includes feedback whether the command was executed. 
 */
@MavlinkMessageInfo(
    id = 77,
    crc = 143
)
public final class CommandAck {
  /**
   * Command ID, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
   */
  private final MavCmd command;

  /**
   * See {@link io.dronefleet.mavlink.common.MavResult MavResult} enum 
   */
  private final MavResult result;

  /**
   * WIP: Also used as result_param1, it can be set with a enum containing the errors reasons of why 
   * the command was denied or the progress percentage or 255 if unknown the progress when result is 
   * MAV_RESULT_IN_PROGRESS. 
   */
  private final int progress;

  /**
   * WIP: Additional parameter of the result, example: which parameter of MAV_CMD_NAV_WAYPOINT 
   * caused it to be denied. 
   */
  private final int resultParam2;

  /**
   * WIP: System which requested the command to be executed 
   */
  private final int targetSystem;

  /**
   * WIP: Component which requested the command to be executed 
   */
  private final int targetComponent;

  private CommandAck(MavCmd command, MavResult result, int progress, int resultParam2,
      int targetSystem, int targetComponent) {
    this.command = command;
    this.result = result;
    this.progress = progress;
    this.resultParam2 = resultParam2;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "CommandAck{command=" + command
         + ", result=" + result
         + ", progress=" + progress
         + ", resultParam2=" + resultParam2
         + ", targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent + "}";
  }

  /**
   * Command ID, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 2
  )
  public final MavCmd command() {
    return command;
  }

  /**
   * See {@link io.dronefleet.mavlink.common.MavResult MavResult} enum 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final MavResult result() {
    return result;
  }

  /**
   * WIP: Also used as result_param1, it can be set with a enum containing the errors reasons of why 
   * the command was denied or the progress percentage or 255 if unknown the progress when result is 
   * MAV_RESULT_IN_PROGRESS. 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 1,
      extension = true
  )
  public final int progress() {
    return progress;
  }

  /**
   * WIP: Additional parameter of the result, example: which parameter of MAV_CMD_NAV_WAYPOINT 
   * caused it to be denied. 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4,
      extension = true
  )
  public final int resultParam2() {
    return resultParam2;
  }

  /**
   * WIP: System which requested the command to be executed 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 1,
      extension = true
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * WIP: Component which requested the command to be executed 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 1,
      extension = true
  )
  public final int targetComponent() {
    return targetComponent;
  }

  public static class Builder {
    private MavCmd command;

    private MavResult result;

    private int progress;

    private int resultParam2;

    private int targetSystem;

    private int targetComponent;

    private Builder() {
    }

    /**
     * Command ID, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 2
    )
    public final Builder command(MavCmd command) {
      this.command = command;
      return this;
    }

    /**
     * See {@link io.dronefleet.mavlink.common.MavResult MavResult} enum 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder result(MavResult result) {
      this.result = result;
      return this;
    }

    /**
     * WIP: Also used as result_param1, it can be set with a enum containing the errors reasons of why 
     * the command was denied or the progress percentage or 255 if unknown the progress when result is 
     * MAV_RESULT_IN_PROGRESS. 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 1,
        extension = true
    )
    public final Builder progress(int progress) {
      this.progress = progress;
      return this;
    }

    /**
     * WIP: Additional parameter of the result, example: which parameter of MAV_CMD_NAV_WAYPOINT 
     * caused it to be denied. 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4,
        extension = true
    )
    public final Builder resultParam2(int resultParam2) {
      this.resultParam2 = resultParam2;
      return this;
    }

    /**
     * WIP: System which requested the command to be executed 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 1,
        extension = true
    )
    public final Builder targetSystem(int targetSystem) {
      this.targetSystem = targetSystem;
      return this;
    }

    /**
     * WIP: Component which requested the command to be executed 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 1,
        extension = true
    )
    public final Builder targetComponent(int targetComponent) {
      this.targetComponent = targetComponent;
      return this;
    }

    public final CommandAck build() {
      return new CommandAck(command, result, progress, resultParam2, targetSystem, targetComponent);
    }
  }
}
