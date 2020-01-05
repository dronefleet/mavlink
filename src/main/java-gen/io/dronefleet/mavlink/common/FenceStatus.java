package io.dronefleet.mavlink.common;

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
 * Status of geo-fencing. Sent in extended status stream when fencing enabled. 
 */
@MavlinkMessageInfo(
        id = 162,
        crc = 189,
        description = "Status of geo-fencing. Sent in extended status stream when fencing enabled."
)
public final class FenceStatus {
    private final int breachStatus;

    private final int breachCount;

    private final EnumValue<FenceBreach> breachType;

    private final long breachTime;

    private final EnumValue<FenceMitigate> breachMitigation;

    private FenceStatus(int breachStatus, int breachCount, EnumValue<FenceBreach> breachType,
            long breachTime, EnumValue<FenceMitigate> breachMitigation) {
        this.breachStatus = breachStatus;
        this.breachCount = breachCount;
        this.breachType = breachType;
        this.breachTime = breachTime;
        this.breachMitigation = breachMitigation;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Breach status (0 if currently inside fence, 1 if outside). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "Breach status (0 if currently inside fence, 1 if outside)."
    )
    public final int breachStatus() {
        return this.breachStatus;
    }

    /**
     * Number of fence breaches. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            description = "Number of fence breaches."
    )
    public final int breachCount() {
        return this.breachCount;
    }

    /**
     * Last breach type. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = FenceBreach.class,
            description = "Last breach type."
    )
    public final EnumValue<FenceBreach> breachType() {
        return this.breachType;
    }

    /**
     * Time (since boot) of last breach. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Time (since boot) of last breach."
    )
    public final long breachTime() {
        return this.breachTime;
    }

    /**
     * Active action to prevent fence breach 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            enumType = FenceMitigate.class,
            extension = true,
            description = "Active action to prevent fence breach"
    )
    public final EnumValue<FenceMitigate> breachMitigation() {
        return this.breachMitigation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        FenceStatus other = (FenceStatus)o;
        if (!Objects.deepEquals(breachStatus, other.breachStatus)) return false;
        if (!Objects.deepEquals(breachCount, other.breachCount)) return false;
        if (!Objects.deepEquals(breachType, other.breachType)) return false;
        if (!Objects.deepEquals(breachTime, other.breachTime)) return false;
        if (!Objects.deepEquals(breachMitigation, other.breachMitigation)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(breachStatus);
        result = 31 * result + Objects.hashCode(breachCount);
        result = 31 * result + Objects.hashCode(breachType);
        result = 31 * result + Objects.hashCode(breachTime);
        result = 31 * result + Objects.hashCode(breachMitigation);
        return result;
    }

    @Override
    public String toString() {
        return "FenceStatus{breachStatus=" + breachStatus
                 + ", breachCount=" + breachCount
                 + ", breachType=" + breachType
                 + ", breachTime=" + breachTime
                 + ", breachMitigation=" + breachMitigation + "}";
    }

    public static final class Builder {
        private int breachStatus;

        private int breachCount;

        private EnumValue<FenceBreach> breachType;

        private long breachTime;

        private EnumValue<FenceMitigate> breachMitigation;

        /**
         * Breach status (0 if currently inside fence, 1 if outside). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "Breach status (0 if currently inside fence, 1 if outside)."
        )
        public final Builder breachStatus(int breachStatus) {
            this.breachStatus = breachStatus;
            return this;
        }

        /**
         * Number of fence breaches. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                description = "Number of fence breaches."
        )
        public final Builder breachCount(int breachCount) {
            this.breachCount = breachCount;
            return this;
        }

        /**
         * Last breach type. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = FenceBreach.class,
                description = "Last breach type."
        )
        public final Builder breachType(EnumValue<FenceBreach> breachType) {
            this.breachType = breachType;
            return this;
        }

        /**
         * Last breach type. 
         */
        public final Builder breachType(FenceBreach entry) {
            return breachType(EnumValue.of(entry));
        }

        /**
         * Last breach type. 
         */
        public final Builder breachType(Enum... flags) {
            return breachType(EnumValue.create(flags));
        }

        /**
         * Last breach type. 
         */
        public final Builder breachType(Collection<Enum> flags) {
            return breachType(EnumValue.create(flags));
        }

        /**
         * Time (since boot) of last breach. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Time (since boot) of last breach."
        )
        public final Builder breachTime(long breachTime) {
            this.breachTime = breachTime;
            return this;
        }

        /**
         * Active action to prevent fence breach 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                enumType = FenceMitigate.class,
                extension = true,
                description = "Active action to prevent fence breach"
        )
        public final Builder breachMitigation(EnumValue<FenceMitigate> breachMitigation) {
            this.breachMitigation = breachMitigation;
            return this;
        }

        /**
         * Active action to prevent fence breach 
         */
        public final Builder breachMitigation(FenceMitigate entry) {
            return breachMitigation(EnumValue.of(entry));
        }

        /**
         * Active action to prevent fence breach 
         */
        public final Builder breachMitigation(Enum... flags) {
            return breachMitigation(EnumValue.create(flags));
        }

        /**
         * Active action to prevent fence breach 
         */
        public final Builder breachMitigation(Collection<Enum> flags) {
            return breachMitigation(EnumValue.create(flags));
        }

        public final FenceStatus build() {
            return new FenceStatus(breachStatus, breachCount, breachType, breachTime, breachMitigation);
        }
    }
}
