package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Acknowldge sucess or failure of a flexifunction command 
 */
@MavlinkMessage(
    id = 157,
    crc = 133
)
public final class FlexifunctionCommand {
  private final int targetSystem;

  private final int targetComponent;

  private final int commandType;

  private FlexifunctionCommand(int targetSystem, int targetComponent, int commandType) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.commandType = commandType;
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
   * Flexifunction command type 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int commandType() {
    return commandType;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private int commandType;

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
     * Flexifunction command type 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder commandType(int commandType) {
      this.commandType = commandType;
      return this;
    }

    public final FlexifunctionCommand build() {
      return new FlexifunctionCommand(targetSystem, targetComponent, commandType);
    }
  }
}
