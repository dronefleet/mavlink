package io.dronefleet.mavlink.paparazzi;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * This message is emitted as response to {@link io.dronefleet.mavlink.paparazzi.ScriptRequestList ScriptRequestList} by the MAV to get the number of 
 * mission scripts. 
 */
@MavlinkMessage(
    id = 183,
    crc = 186
)
public final class ScriptCount {
  /**
   * Number of script items in the sequence 
   */
  private final int count;

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  private ScriptCount(int count, int targetSystem, int targetComponent) {
    this.count = count;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "ScriptCount{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", count=" + count + "}";
  }

  /**
   * Number of script items in the sequence 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 2
  )
  public final int count() {
    return count;
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
    private int count;

    private int targetSystem;

    private int targetComponent;

    private Builder() {
    }

    /**
     * Number of script items in the sequence 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 2
    )
    public final Builder count(int count) {
      this.count = count;
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

    public final ScriptCount build() {
      return new ScriptCount(count, targetSystem, targetComponent);
    }
  }
}
