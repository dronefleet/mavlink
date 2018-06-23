package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Message implementing parts of the V2 payload specs in V1 frames for transitional support. 
 */
@MavlinkMessageInfo(
        id = 248,
        crc = 8
)
public final class V2Extension {
    /**
     * A code that identifies the software component that understands this message (analogous to usb 
     * device classes or mime type strings). If this code is less than 32768, it is considered a 
     * 'registered' protocol extension and the corresponding entry should be added to 
     * https://github.com/mavlink/mavlink/extension-message-ids.xml. Software creators can 
     * register blocks of message IDs as needed (useful for GCS specific metadata, etc...). 
     * Message_types greater than 32767 are considered local experiments and should not be checked 
     * in to any widely distributed codebase. 
     */
    private final int messageType;

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

    private V2Extension(int messageType, int targetNetwork, int targetSystem, int targetComponent,
            byte[] payload) {
        this.messageType = messageType;
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
        return "V2Extension{targetNetwork=" + targetNetwork
                 + ", targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", messageType=" + messageType
                 + ", payload=" + payload + "}";
    }

    /**
     * A code that identifies the software component that understands this message (analogous to usb 
     * device classes or mime type strings). If this code is less than 32768, it is considered a 
     * 'registered' protocol extension and the corresponding entry should be added to 
     * https://github.com/mavlink/mavlink/extension-message-ids.xml. Software creators can 
     * register blocks of message IDs as needed (useful for GCS specific metadata, etc...). 
     * Message_types greater than 32767 are considered local experiments and should not be checked 
     * in to any widely distributed codebase. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2
    )
    public final int messageType() {
        return messageType;
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
            position = 5,
            unitSize = 1,
            arraySize = 249
    )
    public final byte[] payload() {
        return payload;
    }

    public static class Builder {
        private int messageType;

        private int targetNetwork;

        private int targetSystem;

        private int targetComponent;

        private byte[] payload;

        private Builder() {
        }

        /**
         * A code that identifies the software component that understands this message (analogous to usb 
         * device classes or mime type strings). If this code is less than 32768, it is considered a 
         * 'registered' protocol extension and the corresponding entry should be added to 
         * https://github.com/mavlink/mavlink/extension-message-ids.xml. Software creators can 
         * register blocks of message IDs as needed (useful for GCS specific metadata, etc...). 
         * Message_types greater than 32767 are considered local experiments and should not be checked 
         * in to any widely distributed codebase. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2
        )
        public final Builder messageType(int messageType) {
            this.messageType = messageType;
            return this;
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
                position = 5,
                unitSize = 1,
                arraySize = 249
        )
        public final Builder payload(byte[] payload) {
            this.payload = payload;
            return this;
        }

        public final V2Extension build() {
            return new V2Extension(messageType, targetNetwork, targetSystem, targetComponent, payload);
        }
    }
}
