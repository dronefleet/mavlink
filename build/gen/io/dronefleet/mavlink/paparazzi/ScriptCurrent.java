package io.dronefleet.mavlink.paparazzi;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * This message informs about the currently active SCRIPT. 
 */
@MavlinkMessage(
    id = 184,
    crc = 40
)
public final class ScriptCurrent {
  private final int seq;

  private ScriptCurrent(int seq) {
    this.seq = seq;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Active Sequence 
   */
  @MavlinkMessageField(
      position = 1,
      length = 2
  )
  public final int seq() {
    return seq;
  }

  public class Builder {
    private int seq;

    private Builder() {
    }

    /**
     * Active Sequence 
     */
    @MavlinkMessageField(
        position = 1,
        length = 2
    )
    public final Builder seq(int seq) {
      this.seq = seq;
      return this;
    }

    public final ScriptCurrent build() {
      return new ScriptCurrent(seq);
    }
  }
}
