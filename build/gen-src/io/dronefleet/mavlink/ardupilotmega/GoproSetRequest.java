package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Request to set a GOPRO_COMMAND with a desired 
 */
@MavlinkMessage(
    id = 218,
    crc = 17
)
public final class GoproSetRequest {
  private final int targetSystem;

  private final int targetComponent;

  private final GoproCommand cmdId;

  private final List<Integer> value;

  private GoproSetRequest(int targetSystem, int targetComponent, GoproCommand cmdId,
      List<Integer> value) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.cmdId = cmdId;
    this.value = value;
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

  /**
   * Value 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1,
      arraySize = 4
  )
  public final List<Integer> value() {
    return value;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private GoproCommand cmdId;

    private List<Integer> value;

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

    /**
     * Value 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1,
        arraySize = 4
    )
    public final Builder value(List<Integer> value) {
      this.value = value;
      return this;
    }

    public final GoproSetRequest build() {
      return new GoproSetRequest(targetSystem, targetComponent, cmdId, value);
    }
  }
}
