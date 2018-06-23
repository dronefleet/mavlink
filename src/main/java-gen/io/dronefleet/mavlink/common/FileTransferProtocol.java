package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * File transfer message 
 */
@MavlinkMessageInfo(
        id = 110,
        crc = 84
)
public final class FileTransferProtocol {
    /**
     * Network ID (0 for broadcast) 
     */
    private final int targetNetwork;

    /**
     * System ID (0 for broadcast) 
     */
    private final int targetSystem;

    /**
     * Component ID (0 for broadcast) 
     */
    private final int targetComponent;

    /**
     * Variable length payload. The length is defined by the remaining message length when 
     * subtracting the header and other fields. The entire content of this block is opaque unless you 
     * understand any the encoding message_type. The particular encoding used can be extension 
     * specific and might not always be documented as part of the mavlink specification. 
     */
    private final byte[] payload;

    private FileTransferProtocol(int targetNetwork, int targetSystem, int targetComponent,
            byte[] payload) {
        this.targetNetwork = targetNetwork;
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.payload = payload;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "FileTransferProtocol{targetNetwork=" + targetNetwork
                 + ", targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", payload=" + payload + "}";
    }

    /**
     * Network ID (0 for broadcast) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int targetNetwork() {
        return targetNetwork;
    }

    /**
     * System ID (0 for broadcast) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetSystem() {
        return targetSystem;
    }

    /**
     * Component ID (0 for broadcast) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int targetComponent() {
        return targetComponent;
    }

    /**
     * Variable length payload. The length is defined by the remaining message length when 
     * subtracting the header and other fields. The entire content of this block is opaque unless you 
     * understand any the encoding message_type. The particular encoding used can be extension 
     * specific and might not always be documented as part of the mavlink specification. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            arraySize = 251
    )
    public final byte[] payload() {
        return payload;
    }

    public static class Builder {
        private int targetNetwork;

        private int targetSystem;

        private int targetComponent;

        private byte[] payload;

        private Builder() {
        }

        /**
         * Network ID (0 for broadcast) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder targetNetwork(int targetNetwork) {
            this.targetNetwork = targetNetwork;
            return this;
        }

        /**
         * System ID (0 for broadcast) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID (0 for broadcast) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Variable length payload. The length is defined by the remaining message length when 
         * subtracting the header and other fields. The entire content of this block is opaque unless you 
         * understand any the encoding message_type. The particular encoding used can be extension 
         * specific and might not always be documented as part of the mavlink specification. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                arraySize = 251
        )
        public final Builder payload(byte[] payload) {
            this.payload = payload;
            return this;
        }

        public final FileTransferProtocol build() {
            return new FileTransferProtocol(targetNetwork, targetSystem, targetComponent, payload);
        }
    }
}
