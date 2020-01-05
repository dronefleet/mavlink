package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Deprecated;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Message for transporting "arbitrary" variable-length data from one component to another 
 * (broadcast is not forbidden, but discouraged). The encoding of the data is usually extension 
 * specific, i.e. determined by the source, and is usually not documented as part of the MAVLink 
 * specification. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 385,
        crc = 147,
        description = "Message for transporting \"arbitrary\" variable-length data from one component to another (broadcast is not forbidden, but discouraged). The encoding of the data is usually extension specific, i.e. determined by the source, and is usually not documented as part of the MAVLink specification.",
        workInProgress = true
)
@Deprecated
public final class Tunnel {
    private final int targetSystem;

    private final int targetComponent;

    private final EnumValue<MavTunnelPayloadType> payloadType;

    private final int payloadLength;

    private final byte[] payload;

    private Tunnel(int targetSystem, int targetComponent,
            EnumValue<MavTunnelPayloadType> payloadType, int payloadLength, byte[] payload) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.payloadType = payloadType;
        this.payloadLength = payloadLength;
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
     * System ID (can be 0 for broadcast, but this is discouraged) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "System ID (can be 0 for broadcast, but this is discouraged)"
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID (can be 0 for broadcast, but this is discouraged) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Component ID (can be 0 for broadcast, but this is discouraged)"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * A code that identifies the content of the payload (0 for unknown, which is the default). If this 
     * code is less than 32768, it is a 'registered' payload type and the corresponding code should be 
     * added to the {@link io.dronefleet.mavlink.common.MavTunnelPayloadType MAV_TUNNEL_PAYLOAD_TYPE} enum. Software creators can register blocks of types as 
     * needed. Codes greater than 32767 are considered local experiments and should not be checked in 
     * to any widely distributed codebase. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            enumType = MavTunnelPayloadType.class,
            description = "A code that identifies the content of the payload (0 for unknown, which is the default). If this code is less than 32768, it is a 'registered' payload type and the corresponding code should be added to the MAV_TUNNEL_PAYLOAD_TYPE enum. Software creators can register blocks of types as needed. Codes greater than 32767 are considered local experiments and should not be checked in to any widely distributed codebase."
    )
    public final EnumValue<MavTunnelPayloadType> payloadType() {
        return this.payloadType;
    }

    /**
     * Length of the data transported in payload 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "Length of the data transported in payload"
    )
    public final int payloadLength() {
        return this.payloadLength;
    }

    /**
     * Variable length payload. The payload length is defined by payload_length. The entire content 
     * of this block is opaque unless you understand the encoding specified by payload_type. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            arraySize = 128,
            description = "Variable length payload. The payload length is defined by payload_length. The entire content of this block is opaque unless you understand the encoding specified by payload_type."
    )
    public final byte[] payload() {
        return this.payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Tunnel other = (Tunnel)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(payloadType, other.payloadType)) return false;
        if (!Objects.deepEquals(payloadLength, other.payloadLength)) return false;
        if (!Objects.deepEquals(payload, other.payload)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(payloadType);
        result = 31 * result + Objects.hashCode(payloadLength);
        result = 31 * result + Objects.hashCode(payload);
        return result;
    }

    @Override
    public String toString() {
        return "Tunnel{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", payloadType=" + payloadType
                 + ", payloadLength=" + payloadLength
                 + ", payload=" + payload + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private EnumValue<MavTunnelPayloadType> payloadType;

        private int payloadLength;

        private byte[] payload;

        /**
         * System ID (can be 0 for broadcast, but this is discouraged) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "System ID (can be 0 for broadcast, but this is discouraged)"
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID (can be 0 for broadcast, but this is discouraged) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Component ID (can be 0 for broadcast, but this is discouraged)"
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * A code that identifies the content of the payload (0 for unknown, which is the default). If this 
         * code is less than 32768, it is a 'registered' payload type and the corresponding code should be 
         * added to the {@link io.dronefleet.mavlink.common.MavTunnelPayloadType MAV_TUNNEL_PAYLOAD_TYPE} enum. Software creators can register blocks of types as 
         * needed. Codes greater than 32767 are considered local experiments and should not be checked in 
         * to any widely distributed codebase. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                enumType = MavTunnelPayloadType.class,
                description = "A code that identifies the content of the payload (0 for unknown, which is the default). If this code is less than 32768, it is a 'registered' payload type and the corresponding code should be added to the MAV_TUNNEL_PAYLOAD_TYPE enum. Software creators can register blocks of types as needed. Codes greater than 32767 are considered local experiments and should not be checked in to any widely distributed codebase."
        )
        public final Builder payloadType(EnumValue<MavTunnelPayloadType> payloadType) {
            this.payloadType = payloadType;
            return this;
        }

        /**
         * A code that identifies the content of the payload (0 for unknown, which is the default). If this 
         * code is less than 32768, it is a 'registered' payload type and the corresponding code should be 
         * added to the {@link io.dronefleet.mavlink.common.MavTunnelPayloadType MAV_TUNNEL_PAYLOAD_TYPE} enum. Software creators can register blocks of types as 
         * needed. Codes greater than 32767 are considered local experiments and should not be checked in 
         * to any widely distributed codebase. 
         */
        public final Builder payloadType(MavTunnelPayloadType entry) {
            return payloadType(EnumValue.of(entry));
        }

        /**
         * A code that identifies the content of the payload (0 for unknown, which is the default). If this 
         * code is less than 32768, it is a 'registered' payload type and the corresponding code should be 
         * added to the {@link io.dronefleet.mavlink.common.MavTunnelPayloadType MAV_TUNNEL_PAYLOAD_TYPE} enum. Software creators can register blocks of types as 
         * needed. Codes greater than 32767 are considered local experiments and should not be checked in 
         * to any widely distributed codebase. 
         */
        public final Builder payloadType(Enum... flags) {
            return payloadType(EnumValue.create(flags));
        }

        /**
         * A code that identifies the content of the payload (0 for unknown, which is the default). If this 
         * code is less than 32768, it is a 'registered' payload type and the corresponding code should be 
         * added to the {@link io.dronefleet.mavlink.common.MavTunnelPayloadType MAV_TUNNEL_PAYLOAD_TYPE} enum. Software creators can register blocks of types as 
         * needed. Codes greater than 32767 are considered local experiments and should not be checked in 
         * to any widely distributed codebase. 
         */
        public final Builder payloadType(Collection<Enum> flags) {
            return payloadType(EnumValue.create(flags));
        }

        /**
         * Length of the data transported in payload 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "Length of the data transported in payload"
        )
        public final Builder payloadLength(int payloadLength) {
            this.payloadLength = payloadLength;
            return this;
        }

        /**
         * Variable length payload. The payload length is defined by payload_length. The entire content 
         * of this block is opaque unless you understand the encoding specified by payload_type. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                arraySize = 128,
                description = "Variable length payload. The payload length is defined by payload_length. The entire content of this block is opaque unless you understand the encoding specified by payload_type."
        )
        public final Builder payload(byte[] payload) {
            this.payload = payload;
            return this;
        }

        public final Tunnel build() {
            return new Tunnel(targetSystem, targetComponent, payloadType, payloadLength, payload);
        }
    }
}
