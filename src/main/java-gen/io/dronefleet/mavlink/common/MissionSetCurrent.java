package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Set the mission item with sequence number seq as current item. This means that the MAV will 
 * continue to this mission item on the shortest path (not following the mission items 
 * in-between). 
 */
@MavlinkMessage(
    id = 41,
    crc = 28
)
public final class MissionSetCurrent {
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

  private MissionSetCurrent(int targetSystem, int targetComponent, int seq) {
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

    public final MissionSetCurrent build() {
      return new MissionSetCurrent(targetSystem, targetComponent, seq);
    }
  }
}
