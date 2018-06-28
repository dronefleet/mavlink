package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * The autopilot is requesting a resource (file, binary, other type of data) 
 */
@MavlinkMessageInfo(
        id = 142,
        crc = 72
)
public final class ResourceRequest {
    private final int requestId;

    private final int uriType;

    private final byte[] uri;

    private final int transferType;

    private final byte[] storage;

    private ResourceRequest(int requestId, int uriType, byte[] uri, int transferType,
            byte[] storage) {
        this.requestId = requestId;
        this.uriType = uriType;
        this.uri = uri;
        this.transferType = transferType;
        this.storage = storage;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Request ID. This ID should be re-used when sending back URI contents 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int requestId() {
        return this.requestId;
    }

    /**
     * The type of requested URI. 0 = a file via URL. 1 = a UAVCAN binary 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int uriType() {
        return this.uriType;
    }

    /**
     * The requested unique resource identifier (URI). It is not necessarily a straight domain name 
     * (depends on the URI type enum) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 120
    )
    public final byte[] uri() {
        return this.uri;
    }

    /**
     * The way the autopilot wants to receive the URI. 0 = MAVLink FTP. 1 = binary stream. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int transferType() {
        return this.transferType;
    }

    /**
     * The storage path the autopilot wants the URI to be stored in. Will only be valid if the 
     * transfer_type has a storage associated (e.g. MAVLink FTP). 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            arraySize = 120
    )
    public final byte[] storage() {
        return this.storage;
    }

    public static final class Builder {
        private int requestId;

        private int uriType;

        private byte[] uri;

        private int transferType;

        private byte[] storage;

        /**
         * Request ID. This ID should be re-used when sending back URI contents 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder requestId(int requestId) {
            this.requestId = requestId;
            return this;
        }

        /**
         * The type of requested URI. 0 = a file via URL. 1 = a UAVCAN binary 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder uriType(int uriType) {
            this.uriType = uriType;
            return this;
        }

        /**
         * The requested unique resource identifier (URI). It is not necessarily a straight domain name 
         * (depends on the URI type enum) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 120
        )
        public final Builder uri(byte[] uri) {
            this.uri = uri;
            return this;
        }

        /**
         * The way the autopilot wants to receive the URI. 0 = MAVLink FTP. 1 = binary stream. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder transferType(int transferType) {
            this.transferType = transferType;
            return this;
        }

        /**
         * The storage path the autopilot wants the URI to be stored in. Will only be valid if the 
         * transfer_type has a storage associated (e.g. MAVLink FTP). 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                arraySize = 120
        )
        public final Builder storage(byte[] storage) {
            this.storage = storage;
            return this;
        }

        public final ResourceRequest build() {
            return new ResourceRequest(requestId, uriType, uri, transferType, storage);
        }
    }
}
