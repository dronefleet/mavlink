package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * An OpenDroneID message pack is a container for multiple encoded OpenDroneID messages (i.e. 
 * not in the format given for the above message descriptions but after encoding into the 
 * compressed OpenDroneID byte format). Used e.g. when transmitting on Bluetooth 5.0 Long 
 * Range/Extended Advertising or on WiFi Neighbor Aware Networking or on WiFi Beacon. 
 */
@MavlinkMessageInfo(
        id = 12915,
        crc = 94,
        description = "An OpenDroneID message pack is a container for multiple encoded OpenDroneID messages (i.e. not in the format given for the above message descriptions but after encoding into the compressed OpenDroneID byte format). Used e.g. when transmitting on Bluetooth 5.0 Long Range/Extended Advertising or on WiFi Neighbor Aware Networking or on WiFi Beacon."
)
public final class OpenDroneIdMessagePack {
    private final int targetSystem;

    private final int targetComponent;

    private final byte[] idOrMac;

    private final int singleMessageSize;

    private final int msgPackSize;

    private final byte[] messages;

    private OpenDroneIdMessagePack(int targetSystem, int targetComponent, byte[] idOrMac,
            int singleMessageSize, int msgPackSize, byte[] messages) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.idOrMac = idOrMac;
        this.singleMessageSize = singleMessageSize;
        this.msgPackSize = msgPackSize;
        this.messages = messages;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID (0 for broadcast). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "System ID (0 for broadcast)."
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID (0 for broadcast). 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID (0 for broadcast)."
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Only used for drone ID data received from other UAs. See detailed description at 
     * https://mavlink.io/en/services/opendroneid.html. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 20,
            description = "Only used for drone ID data received from other UAs. See detailed description at https://mavlink.io/en/services/opendroneid.html."
    )
    public final byte[] idOrMac() {
        return this.idOrMac;
    }

    /**
     * This field must currently always be equal to 25 (bytes), since all encoded OpenDroneID 
     * messages are specified to have this length. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "This field must currently always be equal to 25 (bytes), since all encoded OpenDroneID messages are specified to have this length."
    )
    public final int singleMessageSize() {
        return this.singleMessageSize;
    }

    /**
     * Number of encoded messages in the pack (not the number of bytes). Allowed range is 1 - 9. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "Number of encoded messages in the pack (not the number of bytes). Allowed range is 1 - 9."
    )
    public final int msgPackSize() {
        return this.msgPackSize;
    }

    /**
     * Concatenation of encoded OpenDroneID messages. Shall be filled with nulls in the unused 
     * portion of the field. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            arraySize = 225,
            description = "Concatenation of encoded OpenDroneID messages. Shall be filled with nulls in the unused portion of the field."
    )
    public final byte[] messages() {
        return this.messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        OpenDroneIdMessagePack other = (OpenDroneIdMessagePack)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(idOrMac, other.idOrMac)) return false;
        if (!Objects.deepEquals(singleMessageSize, other.singleMessageSize)) return false;
        if (!Objects.deepEquals(msgPackSize, other.msgPackSize)) return false;
        if (!Objects.deepEquals(messages, other.messages)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(idOrMac);
        result = 31 * result + Objects.hashCode(singleMessageSize);
        result = 31 * result + Objects.hashCode(msgPackSize);
        result = 31 * result + Objects.hashCode(messages);
        return result;
    }

    @Override
    public String toString() {
        return "OpenDroneIdMessagePack{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", idOrMac=" + idOrMac
                 + ", singleMessageSize=" + singleMessageSize
                 + ", msgPackSize=" + msgPackSize
                 + ", messages=" + messages + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private byte[] idOrMac;

        private int singleMessageSize;

        private int msgPackSize;

        private byte[] messages;

        /**
         * System ID (0 for broadcast). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "System ID (0 for broadcast)."
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID (0 for broadcast). 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Component ID (0 for broadcast)."
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Only used for drone ID data received from other UAs. See detailed description at 
         * https://mavlink.io/en/services/opendroneid.html. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 20,
                description = "Only used for drone ID data received from other UAs. See detailed description at https://mavlink.io/en/services/opendroneid.html."
        )
        public final Builder idOrMac(byte[] idOrMac) {
            this.idOrMac = idOrMac;
            return this;
        }

        /**
         * This field must currently always be equal to 25 (bytes), since all encoded OpenDroneID 
         * messages are specified to have this length. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "This field must currently always be equal to 25 (bytes), since all encoded OpenDroneID messages are specified to have this length."
        )
        public final Builder singleMessageSize(int singleMessageSize) {
            this.singleMessageSize = singleMessageSize;
            return this;
        }

        /**
         * Number of encoded messages in the pack (not the number of bytes). Allowed range is 1 - 9. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "Number of encoded messages in the pack (not the number of bytes). Allowed range is 1 - 9."
        )
        public final Builder msgPackSize(int msgPackSize) {
            this.msgPackSize = msgPackSize;
            return this;
        }

        /**
         * Concatenation of encoded OpenDroneID messages. Shall be filled with nulls in the unused 
         * portion of the field. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                arraySize = 225,
                description = "Concatenation of encoded OpenDroneID messages. Shall be filled with nulls in the unused portion of the field."
        )
        public final Builder messages(byte[] messages) {
            this.messages = messages;
            return this;
        }

        public final OpenDroneIdMessagePack build() {
            return new OpenDroneIdMessagePack(targetSystem, targetComponent, idOrMac, singleMessageSize, msgPackSize, messages);
        }
    }
}
