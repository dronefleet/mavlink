package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Status of AP_Limits. Sent in extended status stream when AP_Limits is enabled. 
 */
@MavlinkMessageInfo(
        id = 167,
        crc = 144,
        description = "Status of AP_Limits. Sent in extended status stream when AP_Limits is enabled."
)
public final class LimitsStatus {
    private final EnumValue<LimitsState> limitsState;

    private final long lastTrigger;

    private final long lastAction;

    private final long lastRecovery;

    private final long lastClear;

    private final int breachCount;

    private final EnumValue<LimitModule> modsEnabled;

    private final EnumValue<LimitModule> modsRequired;

    private final EnumValue<LimitModule> modsTriggered;

    private LimitsStatus(EnumValue<LimitsState> limitsState, long lastTrigger, long lastAction,
            long lastRecovery, long lastClear, int breachCount, EnumValue<LimitModule> modsEnabled,
            EnumValue<LimitModule> modsRequired, EnumValue<LimitModule> modsTriggered) {
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
     * State of AP_Limits. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            enumType = LimitsState.class,
            description = "State of AP_Limits."
    )
    public final EnumValue<LimitsState> limitsState() {
        return this.limitsState;
    }

    /**
     * Time (since boot) of last breach. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Time (since boot) of last breach."
    )
    public final long lastTrigger() {
        return this.lastTrigger;
    }

    /**
     * Time (since boot) of last recovery action. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Time (since boot) of last recovery action."
    )
    public final long lastAction() {
        return this.lastAction;
    }

    /**
     * Time (since boot) of last successful recovery. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Time (since boot) of last successful recovery."
    )
    public final long lastRecovery() {
        return this.lastRecovery;
    }

    /**
     * Time (since boot) of last all-clear. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Time (since boot) of last all-clear."
    )
    public final long lastClear() {
        return this.lastClear;
    }

    /**
     * Number of fence breaches. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "Number of fence breaches."
    )
    public final int breachCount() {
        return this.breachCount;
    }

    /**
     * AP_Limit_Module bitfield of enabled modules. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            enumType = LimitModule.class,
            description = "AP_Limit_Module bitfield of enabled modules."
    )
    public final EnumValue<LimitModule> modsEnabled() {
        return this.modsEnabled;
    }

    /**
     * AP_Limit_Module bitfield of required modules. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            enumType = LimitModule.class,
            description = "AP_Limit_Module bitfield of required modules."
    )
    public final EnumValue<LimitModule> modsRequired() {
        return this.modsRequired;
    }

    /**
     * AP_Limit_Module bitfield of triggered modules. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1,
            enumType = LimitModule.class,
            description = "AP_Limit_Module bitfield of triggered modules."
    )
    public final EnumValue<LimitModule> modsTriggered() {
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

    public static final class Builder {
        private EnumValue<LimitsState> limitsState;

        private long lastTrigger;

        private long lastAction;

        private long lastRecovery;

        private long lastClear;

        private int breachCount;

        private EnumValue<LimitModule> modsEnabled;

        private EnumValue<LimitModule> modsRequired;

        private EnumValue<LimitModule> modsTriggered;

        /**
         * State of AP_Limits. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                enumType = LimitsState.class,
                description = "State of AP_Limits."
        )
        public final Builder limitsState(EnumValue<LimitsState> limitsState) {
            this.limitsState = limitsState;
            return this;
        }

        /**
         * State of AP_Limits. 
         */
        public final Builder limitsState(LimitsState entry) {
            return limitsState(EnumValue.of(entry));
        }

        /**
         * State of AP_Limits. 
         */
        public final Builder limitsState(Enum... flags) {
            return limitsState(EnumValue.create(flags));
        }

        /**
         * State of AP_Limits. 
         */
        public final Builder limitsState(Collection<Enum> flags) {
            return limitsState(EnumValue.create(flags));
        }

        /**
         * Time (since boot) of last breach. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Time (since boot) of last breach."
        )
        public final Builder lastTrigger(long lastTrigger) {
            this.lastTrigger = lastTrigger;
            return this;
        }

        /**
         * Time (since boot) of last recovery action. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Time (since boot) of last recovery action."
        )
        public final Builder lastAction(long lastAction) {
            this.lastAction = lastAction;
            return this;
        }

        /**
         * Time (since boot) of last successful recovery. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Time (since boot) of last successful recovery."
        )
        public final Builder lastRecovery(long lastRecovery) {
            this.lastRecovery = lastRecovery;
            return this;
        }

        /**
         * Time (since boot) of last all-clear. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Time (since boot) of last all-clear."
        )
        public final Builder lastClear(long lastClear) {
            this.lastClear = lastClear;
            return this;
        }

        /**
         * Number of fence breaches. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "Number of fence breaches."
        )
        public final Builder breachCount(int breachCount) {
            this.breachCount = breachCount;
            return this;
        }

        /**
         * AP_Limit_Module bitfield of enabled modules. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                enumType = LimitModule.class,
                description = "AP_Limit_Module bitfield of enabled modules."
        )
        public final Builder modsEnabled(EnumValue<LimitModule> modsEnabled) {
            this.modsEnabled = modsEnabled;
            return this;
        }

        /**
         * AP_Limit_Module bitfield of enabled modules. 
         */
        public final Builder modsEnabled(LimitModule entry) {
            return modsEnabled(EnumValue.of(entry));
        }

        /**
         * AP_Limit_Module bitfield of enabled modules. 
         */
        public final Builder modsEnabled(Enum... flags) {
            return modsEnabled(EnumValue.create(flags));
        }

        /**
         * AP_Limit_Module bitfield of enabled modules. 
         */
        public final Builder modsEnabled(Collection<Enum> flags) {
            return modsEnabled(EnumValue.create(flags));
        }

        /**
         * AP_Limit_Module bitfield of required modules. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                enumType = LimitModule.class,
                description = "AP_Limit_Module bitfield of required modules."
        )
        public final Builder modsRequired(EnumValue<LimitModule> modsRequired) {
            this.modsRequired = modsRequired;
            return this;
        }

        /**
         * AP_Limit_Module bitfield of required modules. 
         */
        public final Builder modsRequired(LimitModule entry) {
            return modsRequired(EnumValue.of(entry));
        }

        /**
         * AP_Limit_Module bitfield of required modules. 
         */
        public final Builder modsRequired(Enum... flags) {
            return modsRequired(EnumValue.create(flags));
        }

        /**
         * AP_Limit_Module bitfield of required modules. 
         */
        public final Builder modsRequired(Collection<Enum> flags) {
            return modsRequired(EnumValue.create(flags));
        }

        /**
         * AP_Limit_Module bitfield of triggered modules. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1,
                enumType = LimitModule.class,
                description = "AP_Limit_Module bitfield of triggered modules."
        )
        public final Builder modsTriggered(EnumValue<LimitModule> modsTriggered) {
            this.modsTriggered = modsTriggered;
            return this;
        }

        /**
         * AP_Limit_Module bitfield of triggered modules. 
         */
        public final Builder modsTriggered(LimitModule entry) {
            return modsTriggered(EnumValue.of(entry));
        }

        /**
         * AP_Limit_Module bitfield of triggered modules. 
         */
        public final Builder modsTriggered(Enum... flags) {
            return modsTriggered(EnumValue.create(flags));
        }

        /**
         * AP_Limit_Module bitfield of triggered modules. 
         */
        public final Builder modsTriggered(Collection<Enum> flags) {
            return modsTriggered(EnumValue.create(flags));
        }

        public final LimitsStatus build() {
            return new LimitsStatus(limitsState, lastTrigger, lastAction, lastRecovery, lastClear, breachCount, modsEnabled, modsRequired, modsTriggered);
        }
    }
}
