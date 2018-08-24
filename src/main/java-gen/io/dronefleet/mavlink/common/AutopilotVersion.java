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
 * Version and capability of autopilot software 
 */
@MavlinkMessageInfo(
        id = 148,
        crc = 178
)
public final class AutopilotVersion {
    private final EnumValue<MavProtocolCapability> capabilities;

    private final long flightSwVersion;

    private final long middlewareSwVersion;

    private final long osSwVersion;

    private final long boardVersion;

    private final byte[] flightCustomVersion;

    private final byte[] middlewareCustomVersion;

    private final byte[] osCustomVersion;

    private final int vendorId;

    private final int productId;

    private final BigInteger uid;

    private final byte[] uid2;

    private AutopilotVersion(EnumValue<MavProtocolCapability> capabilities, long flightSwVersion,
            long middlewareSwVersion, long osSwVersion, long boardVersion,
            byte[] flightCustomVersion, byte[] middlewareCustomVersion, byte[] osCustomVersion,
            int vendorId, int productId, BigInteger uid, byte[] uid2) {
        this.capabilities = capabilities;
        this.flightSwVersion = flightSwVersion;
        this.middlewareSwVersion = middlewareSwVersion;
        this.osSwVersion = osSwVersion;
        this.boardVersion = boardVersion;
        this.flightCustomVersion = flightCustomVersion;
        this.middlewareCustomVersion = middlewareCustomVersion;
        this.osCustomVersion = osCustomVersion;
        this.vendorId = vendorId;
        this.productId = productId;
        this.uid = uid;
        this.uid2 = uid2;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * bitmask of capabilities (see {@link io.dronefleet.mavlink.common.MavProtocolCapability MAV_PROTOCOL_CAPABILITY} enum) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            enumType = MavProtocolCapability.class
    )
    public final EnumValue<MavProtocolCapability> capabilities() {
        return this.capabilities;
    }

    /**
     * Firmware version number 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final long flightSwVersion() {
        return this.flightSwVersion;
    }

    /**
     * Middleware version number 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final long middlewareSwVersion() {
        return this.middlewareSwVersion;
    }

    /**
     * Operating system version number 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final long osSwVersion() {
        return this.osSwVersion;
    }

    /**
     * HW / board version (last 8 bytes should be silicon ID, if any) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final long boardVersion() {
        return this.boardVersion;
    }

    /**
     * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique 
     * identifier, but should allow to identify the commit using the main version number even for very 
     * large code bases. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            arraySize = 8
    )
    public final byte[] flightCustomVersion() {
        return this.flightCustomVersion;
    }

    /**
     * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique 
     * identifier, but should allow to identify the commit using the main version number even for very 
     * large code bases. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            arraySize = 8
    )
    public final byte[] middlewareCustomVersion() {
        return this.middlewareCustomVersion;
    }

    /**
     * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique 
     * identifier, but should allow to identify the commit using the main version number even for very 
     * large code bases. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            arraySize = 8
    )
    public final byte[] osCustomVersion() {
        return this.osCustomVersion;
    }

    /**
     * ID of the board vendor 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2
    )
    public final int vendorId() {
        return this.vendorId;
    }

    /**
     * ID of the product 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2
    )
    public final int productId() {
        return this.productId;
    }

    /**
     * UID if provided by hardware (see uid2) 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 8
    )
    public final BigInteger uid() {
        return this.uid;
    }

    /**
     * UID if provided by hardware (supersedes the uid field. If this is non-zero, use this field, 
     * otherwise use uid) 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 1,
            arraySize = 18,
            extension = true
    )
    public final byte[] uid2() {
        return this.uid2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        AutopilotVersion other = (AutopilotVersion)o;
        if (!Objects.deepEquals(capabilities, other.capabilities)) return false;
        if (!Objects.deepEquals(flightSwVersion, other.flightSwVersion)) return false;
        if (!Objects.deepEquals(middlewareSwVersion, other.middlewareSwVersion)) return false;
        if (!Objects.deepEquals(osSwVersion, other.osSwVersion)) return false;
        if (!Objects.deepEquals(boardVersion, other.boardVersion)) return false;
        if (!Objects.deepEquals(flightCustomVersion, other.flightCustomVersion)) return false;
        if (!Objects.deepEquals(middlewareCustomVersion, other.middlewareCustomVersion)) return false;
        if (!Objects.deepEquals(osCustomVersion, other.osCustomVersion)) return false;
        if (!Objects.deepEquals(vendorId, other.vendorId)) return false;
        if (!Objects.deepEquals(productId, other.productId)) return false;
        if (!Objects.deepEquals(uid, other.uid)) return false;
        if (!Objects.deepEquals(uid2, other.uid2)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(capabilities);
        result = 31 * result + Objects.hashCode(flightSwVersion);
        result = 31 * result + Objects.hashCode(middlewareSwVersion);
        result = 31 * result + Objects.hashCode(osSwVersion);
        result = 31 * result + Objects.hashCode(boardVersion);
        result = 31 * result + Objects.hashCode(flightCustomVersion);
        result = 31 * result + Objects.hashCode(middlewareCustomVersion);
        result = 31 * result + Objects.hashCode(osCustomVersion);
        result = 31 * result + Objects.hashCode(vendorId);
        result = 31 * result + Objects.hashCode(productId);
        result = 31 * result + Objects.hashCode(uid);
        result = 31 * result + Objects.hashCode(uid2);
        return result;
    }

    public static final class Builder {
        private EnumValue<MavProtocolCapability> capabilities;

        private long flightSwVersion;

        private long middlewareSwVersion;

        private long osSwVersion;

        private long boardVersion;

        private byte[] flightCustomVersion;

        private byte[] middlewareCustomVersion;

        private byte[] osCustomVersion;

        private int vendorId;

        private int productId;

        private BigInteger uid;

        private byte[] uid2;

        /**
         * bitmask of capabilities (see {@link io.dronefleet.mavlink.common.MavProtocolCapability MAV_PROTOCOL_CAPABILITY} enum) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                enumType = MavProtocolCapability.class
        )
        public final Builder capabilities(EnumValue<MavProtocolCapability> capabilities) {
            this.capabilities = capabilities;
            return this;
        }

        /**
         * bitmask of capabilities (see {@link io.dronefleet.mavlink.common.MavProtocolCapability MAV_PROTOCOL_CAPABILITY} enum) 
         */
        public final Builder capabilities(MavProtocolCapability entry) {
            this.capabilities = EnumValue.of(entry);
            return this;
        }

        /**
         * bitmask of capabilities (see {@link io.dronefleet.mavlink.common.MavProtocolCapability MAV_PROTOCOL_CAPABILITY} enum) 
         */
        public final Builder capabilities(Enum... flags) {
            this.capabilities = EnumValue.create(flags);
            return this;
        }

        /**
         * Firmware version number 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder flightSwVersion(long flightSwVersion) {
            this.flightSwVersion = flightSwVersion;
            return this;
        }

        /**
         * Middleware version number 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder middlewareSwVersion(long middlewareSwVersion) {
            this.middlewareSwVersion = middlewareSwVersion;
            return this;
        }

        /**
         * Operating system version number 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder osSwVersion(long osSwVersion) {
            this.osSwVersion = osSwVersion;
            return this;
        }

        /**
         * HW / board version (last 8 bytes should be silicon ID, if any) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder boardVersion(long boardVersion) {
            this.boardVersion = boardVersion;
            return this;
        }

        /**
         * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique 
         * identifier, but should allow to identify the commit using the main version number even for very 
         * large code bases. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                arraySize = 8
        )
        public final Builder flightCustomVersion(byte[] flightCustomVersion) {
            this.flightCustomVersion = flightCustomVersion;
            return this;
        }

        /**
         * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique 
         * identifier, but should allow to identify the commit using the main version number even for very 
         * large code bases. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                arraySize = 8
        )
        public final Builder middlewareCustomVersion(byte[] middlewareCustomVersion) {
            this.middlewareCustomVersion = middlewareCustomVersion;
            return this;
        }

        /**
         * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique 
         * identifier, but should allow to identify the commit using the main version number even for very 
         * large code bases. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                arraySize = 8
        )
        public final Builder osCustomVersion(byte[] osCustomVersion) {
            this.osCustomVersion = osCustomVersion;
            return this;
        }

        /**
         * ID of the board vendor 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2
        )
        public final Builder vendorId(int vendorId) {
            this.vendorId = vendorId;
            return this;
        }

        /**
         * ID of the product 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 2
        )
        public final Builder productId(int productId) {
            this.productId = productId;
            return this;
        }

        /**
         * UID if provided by hardware (see uid2) 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 8
        )
        public final Builder uid(BigInteger uid) {
            this.uid = uid;
            return this;
        }

        /**
         * UID if provided by hardware (supersedes the uid field. If this is non-zero, use this field, 
         * otherwise use uid) 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 1,
                arraySize = 18,
                extension = true
        )
        public final Builder uid2(byte[] uid2) {
            this.uid2 = uid2;
            return this;
        }

        public final AutopilotVersion build() {
            return new AutopilotVersion(capabilities, flightSwVersion, middlewareSwVersion, osSwVersion, boardVersion, flightCustomVersion, middlewareCustomVersion, osCustomVersion, vendorId, productId, uid, uid2);
        }
    }
}
