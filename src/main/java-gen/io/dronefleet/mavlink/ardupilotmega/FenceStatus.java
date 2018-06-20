package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.common.FenceBreach;
import java.lang.Override;
import java.lang.String;

/**
 * Status of geo-fencing. Sent in extended status stream when fencing enabled 
 */
@MavlinkMessageInfo(
    id = 162,
    crc = 189
)
public final class FenceStatus {
  /**
   * time of last breach in milliseconds since boot 
   */
  private final long breachTime;

  /**
   * number of fence breaches 
   */
  private final int breachCount;

  /**
   * 0 if currently inside fence, 1 if outside 
   */
  private final int breachStatus;

  /**
   * last breach type (see FENCE_BREACH_* enum) 
   */
  private final FenceBreach breachType;

  private FenceStatus(long breachTime, int breachCount, int breachStatus, FenceBreach breachType) {
    this.breachTime = breachTime;
    this.breachCount = breachCount;
    this.breachStatus = breachStatus;
    this.breachType = breachType;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "FenceStatus{breachStatus=" + breachStatus
         + ", breachCount=" + breachCount
         + ", breachType=" + breachType
         + ", breachTime=" + breachTime + "}";
  }

  /**
   * time of last breach in milliseconds since boot 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 4
  )
  public final long breachTime() {
    return breachTime;
  }

  /**
   * number of fence breaches 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 2
  )
  public final int breachCount() {
    return breachCount;
  }

  /**
   * 0 if currently inside fence, 1 if outside 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 1
  )
  public final int breachStatus() {
    return breachStatus;
  }

  /**
   * last breach type (see FENCE_BREACH_* enum) 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1
  )
  public final FenceBreach breachType() {
    return breachType;
  }

  public static class Builder {
    private long breachTime;

    private int breachCount;

    private int breachStatus;

    private FenceBreach breachType;

    private Builder() {
    }

    /**
     * time of last breach in milliseconds since boot 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 4
    )
    public final Builder breachTime(long breachTime) {
      this.breachTime = breachTime;
      return this;
    }

    /**
     * number of fence breaches 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 2
    )
    public final Builder breachCount(int breachCount) {
      this.breachCount = breachCount;
      return this;
    }

    /**
     * 0 if currently inside fence, 1 if outside 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 1
    )
    public final Builder breachStatus(int breachStatus) {
      this.breachStatus = breachStatus;
      return this;
    }

    /**
     * last breach type (see FENCE_BREACH_* enum) 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 1
    )
    public final Builder breachType(FenceBreach breachType) {
      this.breachType = breachType;
      return this;
    }

    public final FenceStatus build() {
      return new FenceStatus(breachTime, breachCount, breachStatus, breachType);
    }
  }
}
