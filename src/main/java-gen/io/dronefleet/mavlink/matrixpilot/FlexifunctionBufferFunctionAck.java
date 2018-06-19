package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Flexifunction type and parameters for component at function index from buffer 
 */
@MavlinkMessage(
    id = 153,
    crc = 109
)
public final class FlexifunctionBufferFunctionAck {
  /**
   * Function index 
   */
  private final int funcIndex;

  /**
   * result of acknowledge, 0=fail, 1=good 
   */
  private final int result;

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  private FlexifunctionBufferFunctionAck(int funcIndex, int result, int targetSystem,
      int targetComponent) {
    this.funcIndex = funcIndex;
    this.result = result;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "FlexifunctionBufferFunctionAck{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", funcIndex=" + funcIndex
         + ", result=" + result + "}";
  }

  /**
   * Function index 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 2
  )
  public final int funcIndex() {
    return funcIndex;
  }

  /**
   * result of acknowledge, 0=fail, 1=good 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 2
  )
  public final int result() {
    return result;
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

  public static class Builder {
    private int funcIndex;

    private int result;

    private int targetSystem;

    private int targetComponent;

    private Builder() {
    }

    /**
     * Function index 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 2
    )
    public final Builder funcIndex(int funcIndex) {
      this.funcIndex = funcIndex;
      return this;
    }

    /**
     * result of acknowledge, 0=fail, 1=good 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 2
    )
    public final Builder result(int result) {
      this.result = result;
      return this;
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

    public final FlexifunctionBufferFunctionAck build() {
      return new FlexifunctionBufferFunctionAck(funcIndex, result, targetSystem, targetComponent);
    }
  }
}
