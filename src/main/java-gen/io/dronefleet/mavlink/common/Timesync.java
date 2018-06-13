package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Time synchronization message. 
 */
@MavlinkMessage(
    id = 111,
    crc = 34
)
public final class Timesync {
  /**
   * Time sync timestamp 1 
   */
  private final long tc1;

  /**
   * Time sync timestamp 2 
   */
  private final long ts1;

  private Timesync(long tc1, long ts1) {
    this.tc1 = tc1;
    this.ts1 = ts1;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Time sync timestamp 1 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final long tc1() {
    return tc1;
  }

  /**
   * Time sync timestamp 2 
   */
  @MavlinkMessageField(
      position = 2,
      length = 8
  )
  public final long ts1() {
    return ts1;
  }

  public static class Builder {
    private long tc1;

    private long ts1;

    private Builder() {
    }

    /**
     * Time sync timestamp 1 
     */
    @MavlinkMessageField(
        position = 1,
        length = 8
    )
    public final Builder tc1(long tc1) {
      this.tc1 = tc1;
      return this;
    }

    /**
     * Time sync timestamp 2 
     */
    @MavlinkMessageField(
        position = 2,
        length = 8
    )
    public final Builder ts1(long ts1) {
      this.ts1 = ts1;
      return this;
    }

    public final Timesync build() {
      return new Timesync(tc1, ts1);
    }
  }
}
