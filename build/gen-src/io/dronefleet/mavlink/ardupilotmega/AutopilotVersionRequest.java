package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Request the autopilot version from the system/component. 
 */
@MavlinkMessage(
    id = 183,
    crc = 85
)
public final class AutopilotVersionRequest {
  private final int targetSystem;

  private final int targetComponent;

  private AutopilotVersionRequest(int targetSystem, int targetComponent) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
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

  public class Builder {
    private int targetSystem;

    private int targetComponent;

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

    public final AutopilotVersionRequest build() {
      return new AutopilotVersionRequest(targetSystem, targetComponent);
    }
  }
}
