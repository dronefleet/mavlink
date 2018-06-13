package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Report status of a command. Includes feedback whether the command was executed. 
 */
@MavlinkMessage(
    id = 77,
    crc = 143
)
public final class CommandAck {
  private final MavCmd command;

  private final MavResult result;

  private final int progress;

  private final int resultParam2;

  private final int targetSystem;

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

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Command ID, as defined by MAV_CMD enum. 
   */
  @MavlinkMessageField(
      position = 1,
      length = 2
  )
  public final MavCmd command() {
    return command;
  }

  /**
   * See MAV_RESULT enum 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final MavResult result() {
    return result;
  }

  /**
   * WIP: Also used as result_param1, it can be set with a enum containing the errors reasons of why 
   * the command was denied or the progress percentage or 255 if unknown the progress when result is 
   * MAV_RESULT_IN_PROGRESS. 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1,
      extension = true
  )
  public final int progress() {
    return progress;
  }

  /**
   * WIP: Additional parameter of the result, example: which parameter of MAV_CMD_NAV_WAYPOINT 
   * caused it to be denied. 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4,
      extension = true
  )
  public final int resultParam2() {
    return resultParam2;
  }

  /**
   * WIP: System which requested the command to be executed 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1,
      extension = true
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * WIP: Component which requested the command to be executed 
   */
  @MavlinkMessageField(
      position = 7,
      length = 1,
      extension = true
  )
  public final int targetComponent() {
    return targetComponent;
  }

  public class Builder {
    private MavCmd command;

    private MavResult result;

    private int progress;

    private int resultParam2;

    private int targetSystem;

    private int targetComponent;

    private Builder() {
    }

    /**
     * Command ID, as defined by MAV_CMD enum. 
     */
    @MavlinkMessageField(
        position = 1,
        length = 2
    )
    public final Builder command(MavCmd command) {
      this.command = command;
      return this;
    }

    /**
     * See MAV_RESULT enum 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
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
    @MavlinkMessageField(
        position = 4,
        length = 1,
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
    @MavlinkMessageField(
        position = 5,
        length = 4,
        extension = true
    )
    public final Builder resultParam2(int resultParam2) {
      this.resultParam2 = resultParam2;
      return this;
    }

    /**
     * WIP: System which requested the command to be executed 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1,
        extension = true
    )
    public final Builder targetSystem(int targetSystem) {
      this.targetSystem = targetSystem;
      return this;
    }

    /**
     * WIP: Component which requested the command to be executed 
     */
    @MavlinkMessageField(
        position = 7,
        length = 1,
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
