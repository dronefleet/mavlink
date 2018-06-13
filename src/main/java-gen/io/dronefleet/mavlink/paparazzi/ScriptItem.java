package io.dronefleet.mavlink.paparazzi;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.String;

/**
 * Message encoding a mission script item. This message is emitted upon a request for the next 
 * script item. 
 */
@MavlinkMessage(
    id = 180,
    crc = 231
)
public final class ScriptItem {
  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * Sequence 
   */
  private final int seq;

  /**
   * The name of the mission script, NULL terminated. 
   */
  private final String name;

  private ScriptItem(int targetSystem, int targetComponent, int seq, String name) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.seq = seq;
    this.name = name;
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
   * Sequence 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int seq() {
    return seq;
  }

  /**
   * The name of the mission script, NULL terminated. 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1,
      arraySize = 50
  )
  public final String name() {
    return name;
  }

  public static class Builder {
    private int targetSystem;

    private int targetComponent;

    private int seq;

    private String name;

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
     * Sequence 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder seq(int seq) {
      this.seq = seq;
      return this;
    }

    /**
     * The name of the mission script, NULL terminated. 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1,
        arraySize = 50
    )
    public final Builder name(String name) {
      this.name = name;
      return this;
    }

    public final ScriptItem build() {
      return new ScriptItem(targetSystem, targetComponent, seq, name);
    }
  }
}
