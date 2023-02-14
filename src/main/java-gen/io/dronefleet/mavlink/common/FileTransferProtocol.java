package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * File transfer protocol message: https://mavlink.io/en/services/ftp.html. 
 */
@MavlinkMessageInfo(
        id = 110,
        crc = 84,
        description = "File transfer protocol message: https://mavlink.io/en/services/ftp.html."
)
public final class FileTransferProtocol {
    private final int targetNetwork;

    private final int targetSystem;

    private final int targetComponent;

    private final byte[] payload;

    private FileTransferProtocol(int targetNetwork, int targetSystem, int targetComponent,
            byte[] payload) {
        this.targetNetwork = targetNetwork;
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.payload = payload;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Network ID (0 for broadcast) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "Network ID (0 for broadcast)"
    )
    public final int targetNetwork() {
        return this.targetNetwork;
    }

    /**
     * System ID (0 for broadcast) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "System ID (0 for broadcast)"
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID (0 for broadcast) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Component ID (0 for broadcast)"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Variable length payload. The length is defined by the remaining message length when 
     * subtracting the header and other fields. The content/format of this block is defined in 
     * https://mavlink.io/en/services/ftp.html. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            arraySize = 251,
            description = "Variable length payload. The length is defined by the remaining message length when subtracting the header and other fields. The content/format of this block is defined in https://mavlink.io/en/services/ftp.html."
    )
    public final byte[] payload() {
        return this.payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        FileTransferProtocol other = (FileTransferProtocol)o;
        if (!Objects.deepEquals(targetNetwork, other.targetNetwork)) return false;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(payload, other.payload)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetNetwork);
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(payload);
        return result;
    }

    @Override
    public String toString() {
        return "FileTransferProtocol{targetNetwork=" + targetNetwork
                 + ", targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", payload=" + payload + "}";
    }

    public static final class Builder {
        private int targetNetwork;

        private int targetSystem;

        private int targetComponent;

        private byte[] payload;

        /**
         * Network ID (0 for broadcast) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "Network ID (0 for broadcast)"
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
                unitSize = 1,
                description = "System ID (0 for broadcast)"
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
                unitSize = 1,
                description = "Component ID (0 for broadcast)"
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Variable length payload. The length is defined by the remaining message length when 
         * subtracting the header and other fields. The content/format of this block is defined in 
         * https://mavlink.io/en/services/ftp.html. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                arraySize = 251,
                description = "Variable length payload. The length is defined by the remaining message length when subtracting the header and other fields. The content/format of this block is defined in https://mavlink.io/en/services/ftp.html."
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
