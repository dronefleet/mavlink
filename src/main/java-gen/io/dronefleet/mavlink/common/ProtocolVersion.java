package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Version and capability of protocol version. This message is the response to 
 * REQUEST_PROTOCOL_VERSION and is used as part of the handshaking to establish which MAVLink 
 * version should be used on the network. Every node should respond to REQUEST_PROTOCOL_VERSION 
 * to enable the handshaking. Library implementers should consider adding this into the default 
 * decoding state machine to allow the protocol core to respond directly. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 300,
        crc = 217,
        description = "Version and capability of protocol version. This message is the response to REQUEST_PROTOCOL_VERSION and is used as part of the handshaking to establish which MAVLink version should be used on the network. Every node should respond to REQUEST_PROTOCOL_VERSION to enable the handshaking. Library implementers should consider adding this into the default decoding state machine to allow the protocol core to respond directly.",
        workInProgress = true
)
@Deprecated
public final class ProtocolVersion {
    private final int version;

    private final int minVersion;

    private final int maxVersion;

    private final byte[] specVersionHash;

    private final byte[] libraryVersionHash;

    private ProtocolVersion(int version, int minVersion, int maxVersion, byte[] specVersionHash,
            byte[] libraryVersionHash) {
        this.version = version;
        this.minVersion = minVersion;
        this.maxVersion = maxVersion;
        this.specVersionHash = specVersionHash;
        this.libraryVersionHash = libraryVersionHash;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Currently active MAVLink version number * 100: v1.0 is 100, v2.0 is 200, etc. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            description = "Currently active MAVLink version number * 100: v1.0 is 100, v2.0 is 200, etc."
    )
    public final int version() {
        return this.version;
    }

    /**
     * Minimum MAVLink version supported 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "Minimum MAVLink version supported"
    )
    public final int minVersion() {
        return this.minVersion;
    }

    /**
     * Maximum MAVLink version supported (set to the same value as version by default) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "Maximum MAVLink version supported (set to the same value as version by default)"
    )
    public final int maxVersion() {
        return this.maxVersion;
    }

    /**
     * The first 8 bytes (not characters printed in hex!) of the git hash. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            arraySize = 8,
            description = "The first 8 bytes (not characters printed in hex!) of the git hash."
    )
    public final byte[] specVersionHash() {
        return this.specVersionHash;
    }

    /**
     * The first 8 bytes (not characters printed in hex!) of the git hash. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            arraySize = 8,
            description = "The first 8 bytes (not characters printed in hex!) of the git hash."
    )
    public final byte[] libraryVersionHash() {
        return this.libraryVersionHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ProtocolVersion other = (ProtocolVersion)o;
        if (!Objects.deepEquals(version, other.version)) return false;
        if (!Objects.deepEquals(minVersion, other.minVersion)) return false;
        if (!Objects.deepEquals(maxVersion, other.maxVersion)) return false;
        if (!Objects.deepEquals(specVersionHash, other.specVersionHash)) return false;
        if (!Objects.deepEquals(libraryVersionHash, other.libraryVersionHash)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(version);
        result = 31 * result + Objects.hashCode(minVersion);
        result = 31 * result + Objects.hashCode(maxVersion);
        result = 31 * result + Objects.hashCode(specVersionHash);
        result = 31 * result + Objects.hashCode(libraryVersionHash);
        return result;
    }

    @Override
    public String toString() {
        return "ProtocolVersion{version=" + version
                 + ", minVersion=" + minVersion
                 + ", maxVersion=" + maxVersion
                 + ", specVersionHash=" + specVersionHash
                 + ", libraryVersionHash=" + libraryVersionHash + "}";
    }

    public static final class Builder {
        private int version;

        private int minVersion;

        private int maxVersion;

        private byte[] specVersionHash;

        private byte[] libraryVersionHash;

        /**
         * Currently active MAVLink version number * 100: v1.0 is 100, v2.0 is 200, etc. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                description = "Currently active MAVLink version number * 100: v1.0 is 100, v2.0 is 200, etc."
        )
        public final Builder version(int version) {
            this.version = version;
            return this;
        }

        /**
         * Minimum MAVLink version supported 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "Minimum MAVLink version supported"
        )
        public final Builder minVersion(int minVersion) {
            this.minVersion = minVersion;
            return this;
        }

        /**
         * Maximum MAVLink version supported (set to the same value as version by default) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "Maximum MAVLink version supported (set to the same value as version by default)"
        )
        public final Builder maxVersion(int maxVersion) {
            this.maxVersion = maxVersion;
            return this;
        }

        /**
         * The first 8 bytes (not characters printed in hex!) of the git hash. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                arraySize = 8,
                description = "The first 8 bytes (not characters printed in hex!) of the git hash."
        )
        public final Builder specVersionHash(byte[] specVersionHash) {
            this.specVersionHash = specVersionHash;
            return this;
        }

        /**
         * The first 8 bytes (not characters printed in hex!) of the git hash. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                arraySize = 8,
                description = "The first 8 bytes (not characters printed in hex!) of the git hash."
        )
        public final Builder libraryVersionHash(byte[] libraryVersionHash) {
            this.libraryVersionHash = libraryVersionHash;
            return this;
        }

        public final ProtocolVersion build() {
            return new ProtocolVersion(version, minVersion, maxVersion, specVersionHash, libraryVersionHash);
        }
    }
}
