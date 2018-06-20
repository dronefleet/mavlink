package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Request a {@link io.dronefleet.mavlink.ardupilotmega.GoproCommand GoproCommand} response from the GoPro 
 */
@MavlinkMessageInfo(
    id = 216,
    crc = 50
)
public final class GoproGetRequest {
  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * Command ID 
   */
  private final GoproCommand cmdId;

  private GoproGetRequest(int targetSystem, int targetComponent, GoproCommand cmdId) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.cmdId = cmdId;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "GoproGetRequest{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", cmdId=" + cmdId + "}";
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
   * Command ID 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1
  )
  public final GoproCommand cmdId() {
    return cmdId;
  }

  public static class Builder {
    private int targetSystem;

    private int targetComponent;

    private GoproCommand cmdId;

    private Builder() {
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
     * Command ID 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 1
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
