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
 * An OpenDroneID message pack is a container for multiple encoded OpenDroneID messages (i.e. 
 * not in the format given for the above messages descriptions but after encoding into the 
 * compressed OpenDroneID byte format). Used e.g. when transmitting on Bluetooth 5.0 Long 
 * Range/Extended Advertising or on WiFi Neighbor Aware Networking. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 12915,
        crc = 67,
        description = "An OpenDroneID message pack is a container for multiple encoded OpenDroneID messages (i.e. not in the format given for the above messages descriptions but after encoding into the compressed OpenDroneID byte format). Used e.g. when transmitting on Bluetooth 5.0 Long Range/Extended Advertising or on WiFi Neighbor Aware Networking.",
        workInProgress = true
)
@Deprecated
public final class OpenDroneIdMessagePack {
    private final int singleMessageSize;

    private final int msgPackSize;

    private final byte[] messages;

    private OpenDroneIdMessagePack(int singleMessageSize, int msgPackSize, byte[] messages) {
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
     * This field must currently always be equal to 25 bytes, since all encoded OpenDroneID messages 
     * are specificed to have this length. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "This field must currently always be equal to 25 bytes, since all encoded OpenDroneID messages are specificed to have this length."
    )
    public final int singleMessageSize() {
        return this.singleMessageSize;
    }

    /**
     * Number of encoded messages in the pack (not the number of bytes). Allowed range is 1 - 10. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Number of encoded messages in the pack (not the number of bytes). Allowed range is 1 - 10."
    )
    public final int msgPackSize() {
        return this.msgPackSize;
    }

    /**
     * Concatenation of encoded OpenDroneID messages. Shall be filled with nulls in the unused 
     * portion of the field. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            arraySize = 250,
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
        if (!Objects.deepEquals(singleMessageSize, other.singleMessageSize)) return false;
        if (!Objects.deepEquals(msgPackSize, other.msgPackSize)) return false;
        if (!Objects.deepEquals(messages, other.messages)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(singleMessageSize);
        result = 31 * result + Objects.hashCode(msgPackSize);
        result = 31 * result + Objects.hashCode(messages);
        return result;
    }

    @Override
    public String toString() {
        return "OpenDroneIdMessagePack{singleMessageSize=" + singleMessageSize
                 + ", msgPackSize=" + msgPackSize
                 + ", messages=" + messages + "}";
    }

    public static final class Builder {
        private int singleMessageSize;

        private int msgPackSize;

        private byte[] messages;

        /**
         * This field must currently always be equal to 25 bytes, since all encoded OpenDroneID messages 
         * are specificed to have this length. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "This field must currently always be equal to 25 bytes, since all encoded OpenDroneID messages are specificed to have this length."
        )
        public final Builder singleMessageSize(int singleMessageSize) {
            this.singleMessageSize = singleMessageSize;
            return this;
        }

        /**
         * Number of encoded messages in the pack (not the number of bytes). Allowed range is 1 - 10. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Number of encoded messages in the pack (not the number of bytes). Allowed range is 1 - 10."
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
                position = 4,
                unitSize = 1,
                arraySize = 250,
                description = "Concatenation of encoded OpenDroneID messages. Shall be filled with nulls in the unused portion of the field."
        )
        public final Builder messages(byte[] messages) {
            this.messages = messages;
            return this;
        }

        public final OpenDroneIdMessagePack build() {
            return new OpenDroneIdMessagePack(singleMessageSize, msgPackSize, messages);
        }
    }
}
