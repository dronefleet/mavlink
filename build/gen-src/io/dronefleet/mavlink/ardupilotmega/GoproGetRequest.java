package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Request a GOPRO_COMMAND response from the GoPro 
 */
@MavlinkMessage(
    id = 216,
    crc = 50
)
public final class GoproGetRequest {
  private final int targetSystem;

  private final int targetComponent;

  private final GoproCommand cmdId;

  private GoproGetRequest(int targetSystem, int targetComponent, GoproCommand cmdId) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.cmdId = cmdId;
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
   * Command ID 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final GoproCommand cmdId() {
    return cmdId;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private GoproCommand cmdId;

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
     * Command ID 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder cmdId(GoproCommand cmdId) {
      this.cmdId = cmdId;
      return this;
    }

    public final GoproGetRequest build() {
      return new GoproGetRequest(targetSystem, targetComponent, cmdId);
    }
  }
}
