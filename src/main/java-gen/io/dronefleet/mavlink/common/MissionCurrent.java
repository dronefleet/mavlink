package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Message that announces the sequence number of the current active mission item. The MAV will fly 
 * towards this mission item. 
 */
@MavlinkMessage(
    id = 42,
    crc = 28
)
public final class MissionCurrent {
  /**
   * Sequence 
   */
  private final int seq;

  private MissionCurrent(int seq) {
    this.seq = seq;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Sequence 
   */
  @MavlinkMessageField(
      position = 1,
      length = 2
  )
  public final int seq() {
    return seq;
  }

  public static class Builder {
    private int seq;

    private Builder() {
    }

    /**
     * Sequence 
     */
    @MavlinkMessageField(
        position = 1,
        length = 2
    )
    public final Builder seq(int seq) {
      this.seq = seq;
      return this;
    }

    public final MissionCurrent build() {
      return new MissionCurrent(seq);
    }
  }
}
