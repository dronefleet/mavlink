package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Request all parameters of this component. After this request, all parameters are emitted. 
 */
@MavlinkMessage(
    id = 321,
    crc = 88
)
public final class ParamExtRequestList {
  private final int targetSystem;

  private final int targetComponent;

  private ParamExtRequestList(int targetSystem, int targetComponent) {
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

    public final ParamExtRequestList build() {
      return new ParamExtRequestList(targetSystem, targetComponent);
    }
  }
}
