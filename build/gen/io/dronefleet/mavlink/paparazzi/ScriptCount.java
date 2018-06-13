package io.dronefleet.mavlink.paparazzi;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * This message is emitted as response to SCRIPT_REQUEST_LIST by the MAV to get the number of 
 * mission scripts. 
 */
@MavlinkMessage(
    id = 183,
    crc = 186
)
public final class ScriptCount {
  private final int targetSystem;

  private final int targetComponent;

  private final int count;

  private ScriptCount(int targetSystem, int targetComponent, int count) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.count = count;
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
   * Number of script items in the sequence 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int count() {
    return count;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private int count;

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
     * Number of script items in the sequence 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder count(int count) {
      this.count = count;
      return this;
    }

    public final ScriptCount build() {
      return new ScriptCount(targetSystem, targetComponent, count);
    }
  }
}
