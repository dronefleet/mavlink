package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.Override;
import java.lang.String;

/**
 * Status of AP_Limits. Sent in extended status stream when AP_Limits is enabled 
 */
@MavlinkMessageInfo(
        id = 167,
        crc = 144
)
public final class LimitsStatus {
    /**
     * time of last breach in milliseconds since boot 
     */
    private final long lastTrigger;

    /**
     * time of last recovery action in milliseconds since boot 
     */
    private final long lastAction;

    /**
     * time of last successful recovery in milliseconds since boot 
     */
    private final long lastRecovery;

    /**
     * time of last all-clear in milliseconds since boot 
     */
    private final long lastClear;

    /**
     * number of fence breaches 
     */
    private final int breachCount;

    /**
     * state of AP_Limits, (see enum LimitState, {@link io.dronefleet.mavlink.ardupilotmega.LimitsState LimitsState}) 
     */
    private final LimitsState limitsState;

    /**
     * AP_Limit_Module bitfield of enabled modules, (see enum moduleid or {@link io.dronefleet.mavlink.ardupilotmega.LimitModule LimitModule}) 
     */
    private final EnumFlagSet<LimitModule> modsEnabled;

    /**
     * AP_Limit_Module bitfield of required modules, (see enum moduleid or {@link io.dronefleet.mavlink.ardupilotmega.LimitModule LimitModule}) 
     */
    private final EnumFlagSet<LimitModule> modsRequired;

    /**
     * AP_Limit_Module bitfield of triggered modules, (see enum moduleid or {@link io.dronefleet.mavlink.ardupilotmega.LimitModule LimitModule}) 
     */
    private final EnumFlagSet<LimitModule> modsTriggered;

    private LimitsStatus(long lastTrigger, long lastAction, long lastRecovery, long lastClear,
            int breachCount, LimitsState limitsState, EnumFlagSet<LimitModule> modsEnabled,
            EnumFlagSet<LimitModule> modsRequired, EnumFlagSet<LimitModule> modsTriggered) {
        this.lastTrigger = lastTrigger;
        this.lastAction = lastAction;
        this.lastRecovery = lastRecovery;
        this.lastClear = lastClear;
        this.breachCount = breachCount;
        this.limitsState = limitsState;
        this.modsEnabled = modsEnabled;
        this.modsRequired = modsRequired;
        this.modsTriggered = modsTriggered;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "LimitsStatus{limitsState=" + limitsState
                 + ", lastTrigger=" + lastTrigger
                 + ", lastAction=" + lastAction
                 + ", lastRecovery=" + lastRecovery
                 + ", lastClear=" + lastClear
                 + ", breachCount=" + breachCount
                 + ", modsEnabled=" + modsEnabled
                 + ", modsRequired=" + modsRequired
                 + ", modsTriggered=" + modsTriggered + "}";
    }

    /**
     * time of last breach in milliseconds since boot 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final long lastTrigger() {
        return lastTrigger;
    }

    /**
     * time of last recovery action in milliseconds since boot 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final long lastAction() {
        return lastAction;
    }

    /**
     * time of last successful recovery in milliseconds since boot 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final long lastRecovery() {
        return lastRecovery;
    }

    /**
     * time of last all-clear in milliseconds since boot 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final long lastClear() {
        return lastClear;
    }

    /**
     * number of fence breaches 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2
    )
    public final int breachCount() {
        return breachCount;
    }

    /**
     * state of AP_Limits, (see enum LimitState, {@link io.dronefleet.mavlink.ardupilotmega.LimitsState LimitsState}) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final LimitsState limitsState() {
        return limitsState;
    }

    /**
     * AP_Limit_Module bitfield of enabled modules, (see enum moduleid or {@link io.dronefleet.mavlink.ardupilotmega.LimitModule LimitModule}) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1
    )
    public final EnumFlagSet<LimitModule> modsEnabled() {
        return modsEnabled;
    }

    /**
     * AP_Limit_Module bitfield of required modules, (see enum moduleid or {@link io.dronefleet.mavlink.ardupilotmega.LimitModule LimitModule}) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1
    )
    public final EnumFlagSet<LimitModule> modsRequired() {
        return modsRequired;
    }

    /**
     * AP_Limit_Module bitfield of triggered modules, (see enum moduleid or {@link io.dronefleet.mavlink.ardupilotmega.LimitModule LimitModule}) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1
    )
    public final EnumFlagSet<LimitModule> modsTriggered() {
        return modsTriggered;
    }

    public static class Builder {
        private long lastTrigger;

        private long lastAction;

        private long lastRecovery;

        private long lastClear;

        private int breachCount;

        private LimitsState limitsState;

        private EnumFlagSet<LimitModule> modsEnabled;

        private EnumFlagSet<LimitModule> modsRequired;

        private EnumFlagSet<LimitModule> modsTriggered;

        private Builder() {
        }

        /**
         * time of last breach in milliseconds since boot 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder lastTrigger(long lastTrigger) {
            this.lastTrigger = lastTrigger;
            return this;
        }

        /**
         * time of last recovery action in milliseconds since boot 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder lastAction(long lastAction) {
            this.lastAction = lastAction;
            return this;
        }

        /**
         * time of last successful recovery in milliseconds since boot 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder lastRecovery(long lastRecovery) {
            this.lastRecovery = lastRecovery;
            return this;
        }

        /**
         * time of last all-clear in milliseconds since boot 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder lastClear(long lastClear) {
            this.lastClear = lastClear;
            return this;
        }

        /**
         * number of fence breaches 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2
        )
        public final Builder breachCount(int breachCount) {
            this.breachCount = breachCount;
            return this;
        }

        /**
         * state of AP_Limits, (see enum LimitState, {@link io.dronefleet.mavlink.ardupilotmega.LimitsState LimitsState}) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder limitsState(LimitsState limitsState) {
            this.limitsState = limitsState;
            return this;
        }

        /**
         * AP_Limit_Module bitfield of enabled modules, (see enum moduleid or {@link io.dronefleet.mavlink.ardupilotmega.LimitModule LimitModule}) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1
        )
        public final Builder modsEnabled(EnumFlagSet<LimitModule> modsEnabled) {
            this.modsEnabled = modsEnabled;
            return this;
        }

        /**
         * AP_Limit_Module bitfield of required modules, (see enum moduleid or {@link io.dronefleet.mavlink.ardupilotmega.LimitModule LimitModule}) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1
        )
        public final Builder modsRequired(EnumFlagSet<LimitModule> modsRequired) {
            this.modsRequired = modsRequired;
            return this;
        }

        /**
         * AP_Limit_Module bitfield of triggered modules, (see enum moduleid or {@link io.dronefleet.mavlink.ardupilotmega.LimitModule LimitModule}) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1
        )
        public final Builder modsTriggered(EnumFlagSet<LimitModule> modsTriggered) {
            this.modsTriggered = modsTriggered;
            return this;
        }

        public final LimitsStatus build() {
            return new LimitsStatus(lastTrigger, lastAction, lastRecovery, lastClear, breachCount, limitsState, modsEnabled, modsRequired, modsTriggered);
        }
    }
}
