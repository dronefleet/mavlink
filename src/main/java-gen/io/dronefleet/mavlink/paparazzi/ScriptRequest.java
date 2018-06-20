package io.dronefleet.mavlink.paparazzi;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Request script item with the sequence number seq. The response of the system to this message 
 * should be a {@link io.dronefleet.mavlink.paparazzi.ScriptItem ScriptItem} message. 
 */
@MavlinkMessageInfo(
    id = 181,
    crc = 129
)
public final class ScriptRequest {
  /**
   * Sequence 
   */
  private final int seq;

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  private ScriptRequest(int seq, int targetSystem, int targetComponent) {
    this.seq = seq;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "ScriptRequest{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", seq=" + seq + "}";
  }

  /**
   * Sequence 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 2
  )
  public final int seq() {
    return seq;
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

  public static class Builder {
    private int seq;

    private int targetSystem;

    private int targetComponent;

    private Builder() {
    }

    /**
     * Sequence 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 2
    )
    public final Builder seq(int seq) {
      this.seq = seq;
      return this;
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

    public final ScriptRequest build() {
      return new ScriptRequest(seq, targetSystem, targetComponent);
    }
  }
}
