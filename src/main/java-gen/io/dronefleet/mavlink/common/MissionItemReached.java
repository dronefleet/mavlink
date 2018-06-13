package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * A certain mission item has been reached. The system will either hold this position (or circle on 
 * the orbit) or (if the autocontinue on the WP was set) continue to the next waypoint. 
 */
@MavlinkMessage(
    id = 46,
    crc = 11
)
public final class MissionItemReached {
  /**
   * Sequence 
   */
  private final int seq;

  private MissionItemReached(int seq) {
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

    public final MissionItemReached build() {
      return new MissionItemReached(seq);
    }
  }
}
