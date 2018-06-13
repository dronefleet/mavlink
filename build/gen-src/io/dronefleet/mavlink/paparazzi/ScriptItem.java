package io.dronefleet.mavlink.paparazzi;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Message encoding a mission script item. This message is emitted upon a request for the next 
 * script item. 
 */
@MavlinkMessage(
    id = 180,
    crc = 231
)
public final class ScriptItem {
  private final int targetSystem;

  private final int targetComponent;

  private final int seq;

  private final List<Integer> name;

  private ScriptItem(int targetSystem, int targetComponent, int seq, List<Integer> name) {
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
  public final List<Integer> name() {
    return name;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private int seq;

    private List<Integer> name;

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
    public final Builder name(List<Integer> name) {
      this.name = name;
      return this;
    }

    public final ScriptItem build() {
      return new ScriptItem(targetSystem, targetComponent, seq, name);
    }
  }
}
