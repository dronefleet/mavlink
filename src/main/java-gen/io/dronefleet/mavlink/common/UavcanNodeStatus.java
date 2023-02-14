package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

/**
 * General status information of an UAVCAN node. Please refer to the definition of the UAVCAN 
 * message "uavcan.protocol.NodeStatus" for the background information. The UAVCAN 
 * specification is available at http://uavcan.org. 
 */
@MavlinkMessageInfo(
        id = 310,
        crc = 28,
        description = "General status information of an UAVCAN node. Please refer to the definition of the UAVCAN message \"uavcan.protocol.NodeStatus\" for the background information. The UAVCAN specification is available at http://uavcan.org."
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
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
     * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Time since the start-up of the node. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Time since the start-up of the node."
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
            enumType = UavcanNodeHealth.class,
            description = "Generalized node health status."
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
            enumType = UavcanNodeMode.class,
            description = "Generalized operating mode."
    )
    public final EnumValue<UavcanNodeMode> mode() {
        return this.mode;
    }

    /**
     * Not used currently. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "Not used currently."
    )
    public final int subMode() {
        return this.subMode;
    }

    /**
     * Vendor-specific status information. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "Vendor-specific status information."
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

    @Override
    public String toString() {
        return "UavcanNodeStatus{timeUsec=" + timeUsec
                 + ", uptimeSec=" + uptimeSec
                 + ", health=" + health
                 + ", mode=" + mode
                 + ", subMode=" + subMode
                 + ", vendorSpecificStatusCode=" + vendorSpecificStatusCode + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private long uptimeSec;

        private EnumValue<UavcanNodeHealth> health;

        private EnumValue<UavcanNodeMode> mode;

        private int subMode;

        private int vendorSpecificStatusCode;

        /**
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Time since the start-up of the node. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Time since the start-up of the node."
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
                enumType = UavcanNodeHealth.class,
                description = "Generalized node health status."
        )
        public final Builder health(EnumValue<UavcanNodeHealth> health) {
            this.health = health;
            return this;
        }

        /**
         * Generalized node health status. 
         */
        public final Builder health(UavcanNodeHealth entry) {
            return health(EnumValue.of(entry));
        }

        /**
         * Generalized node health status. 
         */
        public final Builder health(Enum... flags) {
            return health(EnumValue.create(flags));
        }

        /**
         * Generalized node health status. 
         */
        public final Builder health(Collection<Enum> flags) {
            return health(EnumValue.create(flags));
        }

        /**
         * Generalized operating mode. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = UavcanNodeMode.class,
                description = "Generalized operating mode."
        )
        public final Builder mode(EnumValue<UavcanNodeMode> mode) {
            this.mode = mode;
            return this;
        }

        /**
         * Generalized operating mode. 
         */
        public final Builder mode(UavcanNodeMode entry) {
            return mode(EnumValue.of(entry));
        }

        /**
         * Generalized operating mode. 
         */
        public final Builder mode(Enum... flags) {
            return mode(EnumValue.create(flags));
        }

        /**
         * Generalized operating mode. 
         */
        public final Builder mode(Collection<Enum> flags) {
            return mode(EnumValue.create(flags));
        }

        /**
         * Not used currently. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "Not used currently."
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
                unitSize = 2,
                description = "Vendor-specific status information."
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
