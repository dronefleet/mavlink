package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.common.FenceBreach;

/**
 * Status of geo-fencing. Sent in extended status stream when fencing enabled 
 */
@MavlinkMessage(
    id = 162,
    crc = 189
)
public final class FenceStatus {
  /**
   * 0 if currently inside fence, 1 if outside 
   */
  private final int breachStatus;

  /**
   * number of fence breaches 
   */
  private final int breachCount;

  /**
   * last breach type (see FENCE_BREACH_* enum) 
   */
  private final FenceBreach breachType;

  /**
   * time of last breach in milliseconds since boot 
   */
  private final long breachTime;

  private FenceStatus(int breachStatus, int breachCount, FenceBreach breachType, long breachTime) {
    this.breachStatus = breachStatus;
    this.breachCount = breachCount;
    this.breachType = breachType;
    this.breachTime = breachTime;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * 0 if currently inside fence, 1 if outside 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int breachStatus() {
    return breachStatus;
  }

  /**
   * number of fence breaches 
   */
  @MavlinkMessageField(
      position = 2,
      length = 2
  )
  public final int breachCount() {
    return breachCount;
  }

  /**
   * last breach type (see FENCE_BREACH_* enum) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final FenceBreach breachType() {
    return breachType;
  }

  /**
   * time of last breach in milliseconds since boot 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final long breachTime() {
    return breachTime;
  }

  public static class Builder {
    private int breachStatus;

    private int breachCount;

    private FenceBreach breachType;

    private long breachTime;

    private Builder() {
    }

    /**
     * 0 if currently inside fence, 1 if outside 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder breachStatus(int breachStatus) {
      this.breachStatus = breachStatus;
      return this;
    }

    /**
     * number of fence breaches 
     */
    @MavlinkMessageField(
        position = 2,
        length = 2
    )
    public final Builder breachCount(int breachCount) {
      this.breachCount = breachCount;
      return this;
    }

    /**
     * last breach type (see FENCE_BREACH_* enum) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder breachType(FenceBreach breachType) {
      this.breachType = breachType;
      return this;
    }

    /**
     * time of last breach in milliseconds since boot 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder breachTime(long breachTime) {
      this.breachTime = breachTime;
      return this;
    }

    public final FenceStatus build() {
      return new FenceStatus(breachStatus, breachCount, breachType, breachTime);
    }
  }
}
