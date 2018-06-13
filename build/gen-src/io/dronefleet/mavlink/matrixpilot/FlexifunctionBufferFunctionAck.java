package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Flexifunction type and parameters for component at function index from buffer 
 */
@MavlinkMessage(
    id = 153,
    crc = 109
)
public final class FlexifunctionBufferFunctionAck {
  private final int targetSystem;

  private final int targetComponent;

  private final int funcIndex;

  private final int result;

  private FlexifunctionBufferFunctionAck(int targetSystem, int targetComponent, int funcIndex,
      int result) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.funcIndex = funcIndex;
    this.result = result;
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
   * Function index 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int funcIndex() {
    return funcIndex;
  }

  /**
   * result of acknowledge, 0=fail, 1=good 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int result() {
    return result;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private int funcIndex;

    private int result;

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
     * Function index 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
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
        length = 2
    )
    public final Builder result(int result) {
      this.result = result;
      return this;
    }

    public final FlexifunctionBufferFunctionAck build() {
      return new FlexifunctionBufferFunctionAck(targetSystem, targetComponent, funcIndex, result);
    }
  }
}
