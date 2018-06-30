package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * Status of AP_Limits. Sent in extended status stream when AP_Limits is enabled 
 */
@MavlinkMessageInfo(
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
            long lastRecovery, long lastClear, int breachCount,
            EnumFlagSet<LimitModule> modsEnabled, EnumFlagSet<LimitModule> modsRequired,
            EnumFlagSet<LimitModule> modsTriggered) {
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

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * state of AP_Limits, (see enum LimitState, {@link io.dronefleet.mavlink.ardupilotmega.LimitsState LIMITS_STATE}) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final LimitsState limitsState() {
        return this.limitsState;
    }

    /**
     * time of last breach in milliseconds since boot 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final long lastTrigger() {
        return this.lastTrigger;
    }

    /**
     * time of last recovery action in milliseconds since boot 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final long lastAction() {
        return this.lastAction;
    }

    /**
     * time of last successful recovery in milliseconds since boot 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final long lastRecovery() {
        return this.lastRecovery;
    }

    /**
     * time of last all-clear in milliseconds since boot 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final long lastClear() {
        return this.lastClear;
    }

    /**
     * number of fence breaches 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2
    )
    public final int breachCount() {
        return this.breachCount;
    }

    /**
     * AP_Limit_Module bitfield of enabled modules, (see enum moduleid or {@link io.dronefleet.mavlink.ardupilotmega.LimitModule LIMIT_MODULE}) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1
    )
    public final EnumFlagSet<LimitModule> modsEnabled() {
        return this.modsEnabled;
    }

    /**
     * AP_Limit_Module bitfield of required modules, (see enum moduleid or {@link io.dronefleet.mavlink.ardupilotmega.LimitModule LIMIT_MODULE}) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1
    )
    public final EnumFlagSet<LimitModule> modsRequired() {
        return this.modsRequired;
    }

    /**
     * AP_Limit_Module bitfield of triggered modules, (see enum moduleid or {@link io.dronefleet.mavlink.ardupilotmega.LimitModule LIMIT_MODULE}) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1
    )
    public final EnumFlagSet<LimitModule> modsTriggered() {
        return this.modsTriggered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        LimitsStatus other = (LimitsStatus)o;
        if (!Objects.deepEquals(limitsState, other.limitsState)) return false;
        if (!Objects.deepEquals(lastTrigger, other.lastTrigger)) return false;
        if (!Objects.deepEquals(lastAction, other.lastAction)) return false;
        if (!Objects.deepEquals(lastRecovery, other.lastRecovery)) return false;
        if (!Objects.deepEquals(lastClear, other.lastClear)) return false;
        if (!Objects.deepEquals(breachCount, other.breachCount)) return false;
        if (!Objects.deepEquals(modsEnabled, other.modsEnabled)) return false;
        if (!Objects.deepEquals(modsRequired, other.modsRequired)) return false;
        if (!Objects.deepEquals(modsTriggered, other.modsTriggered)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(limitsState);
        result = 31 * result + Objects.hashCode(lastTrigger);
        result = 31 * result + Objects.hashCode(lastAction);
        result = 31 * result + Objects.hashCode(lastRecovery);
        result = 31 * result + Objects.hashCode(lastClear);
        result = 31 * result + Objects.hashCode(breachCount);
        result = 31 * result + Objects.hashCode(modsEnabled);
        result = 31 * result + Objects.hashCode(modsRequired);
        result = 31 * result + Objects.hashCode(modsTriggered);
        return result;
    }

    public static final class Builder {
        private LimitsState limitsState;

        private long lastTrigger;

        private long lastAction;

        private long lastRecovery;

        private long lastClear;

        private int breachCount;

        private EnumFlagSet<LimitModule> modsEnabled;

        private EnumFlagSet<LimitModule> modsRequired;

        private EnumFlagSet<LimitModule> modsTriggered;

        /**
         * state of AP_Limits, (see enum LimitState, {@link io.dronefleet.mavlink.ardupilotmega.LimitsState LIMITS_STATE}) 
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
         * AP_Limit_Module bitfield of enabled modules, (see enum moduleid or {@link io.dronefleet.mavlink.ardupilotmega.LimitModule LIMIT_MODULE}) 
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
         * AP_Limit_Module bitfield of required modules, (see enum moduleid or {@link io.dronefleet.mavlink.ardupilotmega.LimitModule LIMIT_MODULE}) 
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
         * AP_Limit_Module bitfield of triggered modules, (see enum moduleid or {@link io.dronefleet.mavlink.ardupilotmega.LimitModule LIMIT_MODULE}) 
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
            return new LimitsStatus(limitsState, lastTrigger, lastAction, lastRecovery, lastClear, breachCount, modsEnabled, modsRequired, modsTriggered);
        }
    }
}
