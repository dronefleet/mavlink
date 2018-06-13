package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Control vehicle tone generation (buzzer) 
 */
@MavlinkMessage(
    id = 258,
    crc = 187
)
public final class PlayTune {
  private final int targetSystem;

  private final int targetComponent;

  private final List<Integer> tune;

  private PlayTune(int targetSystem, int targetComponent, List<Integer> tune) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.tune = tune;
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
   * tune in board specific format 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1,
      arraySize = 30
  )
  public final List<Integer> tune() {
    return tune;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private List<Integer> tune;

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
     * tune in board specific format 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1,
        arraySize = 30
    )
    public final Builder tune(List<Integer> tune) {
      this.tune = tune;
      return this;
    }

    public final PlayTune build() {
      return new PlayTune(targetSystem, targetComponent, tune);
    }
  }
}
