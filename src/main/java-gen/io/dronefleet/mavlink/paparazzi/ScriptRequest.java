package io.dronefleet.mavlink.paparazzi;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Request script item with the sequence number seq. The response of the system to this message 
 * should be a {@link io.dronefleet.mavlink.paparazzi.ScriptItem ScriptItem} message. 
 */
@MavlinkMessage(
    id = 181,
    crc = 129
)
public final class ScriptRequest {
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

  private ScriptRequest(int targetSystem, int targetComponent, int seq) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.seq = seq;
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

  public static class Builder {
    private int targetSystem;

    private int targetComponent;

    private int seq;

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

    public final ScriptRequest build() {
      return new ScriptRequest(targetSystem, targetComponent, seq);
    }
  }
}
