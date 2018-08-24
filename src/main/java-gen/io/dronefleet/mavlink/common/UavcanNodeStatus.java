package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.math.BigInteger;
import java.util.Objects;

/**
 * General status information of an UAVCAN node. Please refer to the definition of the UAVCAN 
 * message "uavcan.protocol.NodeStatus" for the background information. The UAVCAN 
 * specification is available at http://uavcan.org. 
 */
@MavlinkMessageInfo(
        id = 310,
        crc = 28
)
public final class UavcanNodeStatus {
    private final BigInteger timeUsec;

    private final long uptimeSec;

    private final EnumValue<UavcanNodeHealth> health;

    private final EnumValue<UavcanNodeMode> mode;

    private final int subMode;

    private final int vendorSpecificStatusCode;

    private UavcanNodeStatus(BigInteger timeUsec, long uptimeSec,
            EnumValue<UavcanNodeHealth> health, EnumValue<UavcanNodeMode> mode, int subMode,
            int vendorSpecificStatusCode) {
        this.timeUsec = timeUsec;
        this.uptimeSec = uptimeSec;
        this.health = health;
        this.mode = mode;
        this.subMode = subMode;
        this.vendorSpecificStatusCode = vendorSpecificStatusCode;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * The number of seconds since the start-up of the node. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final long uptimeSec() {
        return this.uptimeSec;
    }

    /**
     * Generalized node health status. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = UavcanNodeHealth.class
    )
    public final EnumValue<UavcanNodeHealth> health() {
        return this.health;
    }

    /**
     * Generalized operating mode. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = UavcanNodeMode.class
    )
    public final EnumValue<UavcanNodeMode> mode() {
        return this.mode;
    }

    /**
     * Not used currently. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int subMode() {
        return this.subMode;
    }

    /**
     * Vendor-specific status information. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2
    )
    public final int vendorSpecificStatusCode() {
        return this.vendorSpecificStatusCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        UavcanNodeStatus other = (UavcanNodeStatus)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(uptimeSec, other.uptimeSec)) return false;
        if (!Objects.deepEquals(health, other.health)) return false;
        if (!Objects.deepEquals(mode, other.mode)) return false;
        if (!Objects.deepEquals(subMode, other.subMode)) return false;
        if (!Objects.deepEquals(vendorSpecificStatusCode, other.vendorSpecificStatusCode)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(uptimeSec);
        result = 31 * result + Objects.hashCode(health);
        result = 31 * result + Objects.hashCode(mode);
        result = 31 * result + Objects.hashCode(subMode);
        result = 31 * result + Objects.hashCode(vendorSpecificStatusCode);
        return result;
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private long uptimeSec;

        private EnumValue<UavcanNodeHealth> health;

        private EnumValue<UavcanNodeMode> mode;

        private int subMode;

        private int vendorSpecificStatusCode;

        /**
         * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * The number of seconds since the start-up of the node. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder uptimeSec(long uptimeSec) {
            this.uptimeSec = uptimeSec;
            return this;
        }

        /**
         * Generalized node health status. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = UavcanNodeHealth.class
        )
        public final Builder health(EnumValue<UavcanNodeHealth> health) {
            this.health = health;
            return this;
        }

        /**
         * Generalized node health status. 
         */
        public final Builder health(UavcanNodeHealth entry) {
            this.health = EnumValue.of(entry);
            return this;
        }

        /**
         * Generalized node health status. 
         */
        public final Builder health(Enum... flags) {
            this.health = EnumValue.create(flags);
            return this;
        }

        /**
         * Generalized operating mode. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = UavcanNodeMode.class
        )
        public final Builder mode(EnumValue<UavcanNodeMode> mode) {
            this.mode = mode;
            return this;
        }

        /**
         * Generalized operating mode. 
         */
        public final Builder mode(UavcanNodeMode entry) {
            this.mode = EnumValue.of(entry);
            return this;
        }

        /**
         * Generalized operating mode. 
         */
        public final Builder mode(Enum... flags) {
            this.mode = EnumValue.create(flags);
            return this;
        }

        /**
         * Not used currently. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder subMode(int subMode) {
            this.subMode = subMode;
            return this;
        }

        /**
         * Vendor-specific status information. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2
        )
        public final Builder vendorSpecificStatusCode(int vendorSpecificStatusCode) {
            this.vendorSpecificStatusCode = vendorSpecificStatusCode;
            return this;
        }

        public final UavcanNodeStatus build() {
            return new UavcanNodeStatus(timeUsec, uptimeSec, health, mode, subMode, vendorSpecificStatusCode);
        }
    }
}
