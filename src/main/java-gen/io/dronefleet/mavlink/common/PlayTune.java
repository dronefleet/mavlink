package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Control vehicle tone generation (buzzer) 
 */
@MavlinkMessage(
    id = 258,
    crc = 187
)
public final class PlayTune {
  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * tune in board specific format 
   */
  private final String tune;

  private PlayTune(int targetSystem, int targetComponent, String tune) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.tune = tune;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "PlayTune{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", tune=" + tune + "}";
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

  /**
   * tune in board specific format 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 1,
      arraySize = 30
  )
  public final String tune() {
    return tune;
  }

  public static class Builder {
    private int targetSystem;

    private int targetComponent;

    private String tune;

    private Builder() {
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

    /**
     * tune in board specific format 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 1,
        arraySize = 30
    )
    public final Builder tune(String tune) {
      this.tune = tune;
      return this;
    }

    public final PlayTune build() {
      return new PlayTune(targetSystem, targetComponent, tune);
    }
  }
}
