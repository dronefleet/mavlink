package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Message that announces the sequence number of the current active mission item. The MAV will fly 
 * towards this mission item. 
 */
@MavlinkMessageInfo(
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

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "MissionCurrent{seq=" + seq + "}";
  }

  /**
   * Sequence 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 2
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
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 2
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
