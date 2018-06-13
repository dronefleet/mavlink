package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.util.EnumFlagSet;

/**
 * Status of AP_Limits. Sent in extended status stream when AP_Limits is enabled 
 */
@MavlinkMessage(
    id = 167,
    crc = 144
)
public final class LimitsStatus {
  private final LimitsState limitsState;

  private final long lastTrigger;

  private final long lastAction;

  private final long lastRecovery;

  private final long lastClear;

  private final int breachCount;

  private final EnumFlagSet<LimitModule> modsEnabled;

  private final EnumFlagSet<LimitModule> modsRequired;

  private final EnumFlagSet<LimitModule> modsTriggered;

  private LimitsStatus(LimitsState limitsState, long lastTrigger, long lastAction,
      long lastRecovery, long lastClear, int breachCount, EnumFlagSet<LimitModule> modsEnabled,
      EnumFlagSet<LimitModule> modsRequired, EnumFlagSet<LimitModule> modsTriggered) {
    this.limitsState = limitsState;
    this.lastTrigger = lastTrigger;
    this.lastAction = lastAction;
    this.lastRecovery = lastRecovery;
    this.lastClear = lastClear;
    this.breachCount = breachCount;
    this.modsEnabled = modsEnabled;
    this.modsRequired = modsRequired;
    this.modsTriggered = modsTriggered;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * state of AP_Limits, (see enum LimitState, LIMITS_STATE) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final LimitsState limitsState() {
    return limitsState;
  }

  /**
   * time of last breach in milliseconds since boot 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final long lastTrigger() {
    return lastTrigger;
  }

  /**
   * time of last recovery action in milliseconds since boot 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final long lastAction() {
    return lastAction;
  }

  /**
   * time of last successful recovery in milliseconds since boot 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final long lastRecovery() {
    return lastRecovery;
  }

  /**
   * time of last all-clear in milliseconds since boot 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final long lastClear() {
    return lastClear;
  }

  /**
   * number of fence breaches 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int breachCount() {
    return breachCount;
  }

  /**
   * AP_Limit_Module bitfield of enabled modules, (see enum moduleid or LIMIT_MODULE) 
   */
  @MavlinkMessageField(
      position = 7,
      length = 1
  )
  public final EnumFlagSet<LimitModule> modsEnabled() {
    return modsEnabled;
  }

  /**
   * AP_Limit_Module bitfield of required modules, (see enum moduleid or LIMIT_MODULE) 
   */
  @MavlinkMessageField(
      position = 8,
      length = 1
  )
  public final EnumFlagSet<LimitModule> modsRequired() {
    return modsRequired;
  }

  /**
   * AP_Limit_Module bitfield of triggered modules, (see enum moduleid or LIMIT_MODULE) 
   */
  @MavlinkMessageField(
      position = 9,
      length = 1
  )
  public final EnumFlagSet<LimitModule> modsTriggered() {
    return modsTriggered;
  }

  public class Builder {
    private LimitsState limitsState;

    private long lastTrigger;

    private long lastAction;

    private long lastRecovery;

    private long lastClear;

    private int breachCount;

    private EnumFlagSet<LimitModule> modsEnabled;

    private EnumFlagSet<LimitModule> modsRequired;

    private EnumFlagSet<LimitModule> modsTriggered;

    private Builder() {
    }

    /**
     * state of AP_Limits, (see enum LimitState, LIMITS_STATE) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder limitsState(LimitsState limitsState) {
      this.limitsState = limitsState;
      return this;
    }

    /**
     * time of last breach in milliseconds since boot 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder lastTrigger(long lastTrigger) {
      this.lastTrigger = lastTrigger;
      return this;
    }

    /**
     * time of last recovery action in milliseconds since boot 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder lastAction(long lastAction) {
      this.lastAction = lastAction;
      return this;
    }

    /**
     * time of last successful recovery in milliseconds since boot 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder lastRecovery(long lastRecovery) {
      this.lastRecovery = lastRecovery;
      return this;
    }

    /**
     * time of last all-clear in milliseconds since boot 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder lastClear(long lastClear) {
      this.lastClear = lastClear;
      return this;
    }

    /**
     * number of fence breaches 
     */
    @MavlinkMessageField(
        position = 6,
        length = 2
    )
    public final Builder breachCount(int breachCount) {
      this.breachCount = breachCount;
      return this;
    }

    /**
     * AP_Limit_Module bitfield of enabled modules, (see enum moduleid or LIMIT_MODULE) 
     */
    @MavlinkMessageField(
        position = 7,
        length = 1
    )
    public final Builder modsEnabled(EnumFlagSet<LimitModule> modsEnabled) {
      this.modsEnabled = modsEnabled;
      return this;
    }

    /**
     * AP_Limit_Module bitfield of required modules, (see enum moduleid or LIMIT_MODULE) 
     */
    @MavlinkMessageField(
        position = 8,
        length = 1
    )
    public final Builder modsRequired(EnumFlagSet<LimitModule> modsRequired) {
      this.modsRequired = modsRequired;
      return this;
    }

    /**
     * AP_Limit_Module bitfield of triggered modules, (see enum moduleid or LIMIT_MODULE) 
     */
    @MavlinkMessageField(
        position = 9,
        length = 1
    )
    public final Builder modsTriggered(EnumFlagSet<LimitModule> modsTriggered) {
      this.modsTriggered = modsTriggered;
      return this;
    }

    public final LimitsStatus build() {
      return new LimitsStatus(limitsState, lastTrigger, lastAction, lastRecovery, lastClear, breachCount, modsEnabled, modsRequired, modsTriggered);
    }
  }
}
