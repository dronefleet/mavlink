package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Acknowldge sucess or failure of a flexifunction command 
 */
@MavlinkMessage(
    id = 157,
    crc = 133
)
public final class FlexifunctionCommand {
  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * Flexifunction command type 
   */
  private final int commandType;

  private FlexifunctionCommand(int targetSystem, int targetComponent, int commandType) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.commandType = commandType;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "FlexifunctionCommand{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", commandType=" + commandType + "}";
  }

  /**
   * System ID 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Component ID 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * Flexifunction command type 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 1
  )
  public final int commandType() {
    return commandType;
  }

  public static class Builder {
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
        unitSize = 1
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
        unitSize = 1
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
        unitSize = 1
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
