package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Request to set a {@link io.dronefleet.mavlink.ardupilotmega.GoproCommand GOPRO_COMMAND} with a desired. 
 */
@MavlinkMessageInfo(
        id = 218,
        crc = 17,
        description = "Request to set a GOPRO_COMMAND with a desired."
)
public final class GoproSetRequest {
    private final int targetSystem;

    private final int targetComponent;

    private final EnumValue<GoproCommand> cmdId;

    private final byte[] value;

    private GoproSetRequest(int targetSystem, int targetComponent, EnumValue<GoproCommand> cmdId,
            byte[] value) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.cmdId = cmdId;
        this.value = value;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "System ID."
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID."
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Command ID. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = GoproCommand.class,
            description = "Command ID."
    )
    public final EnumValue<GoproCommand> cmdId() {
        return this.cmdId;
    }

    /**
     * Value. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            arraySize = 4,
            description = "Value."
    )
    public final byte[] value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GoproSetRequest other = (GoproSetRequest)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(cmdId, other.cmdId)) return false;
        if (!Objects.deepEquals(value, other.value)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(cmdId);
        result = 31 * result + Objects.hashCode(value);
        return result;
    }

    @Override
    public String toString() {
        return "GoproSetRequest{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", cmdId=" + cmdId
                 + ", value=" + value + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private EnumValue<GoproCommand> cmdId;

        private byte[] value;

        /**
         * System ID. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "System ID."
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Component ID."
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Command ID. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = GoproCommand.class,
                description = "Command ID."
        )
        public final Builder cmdId(EnumValue<GoproCommand> cmdId) {
            this.cmdId = cmdId;
            return this;
        }

        /**
         * Command ID. 
         */
        public final Builder cmdId(GoproCommand entry) {
            return cmdId(EnumValue.of(entry));
        }

        /**
         * Command ID. 
         */
        public final Builder cmdId(Enum... flags) {
            return cmdId(EnumValue.create(flags));
        }

        /**
         * Command ID. 
         */
        public final Builder cmdId(Collection<Enum> flags) {
            return cmdId(EnumValue.create(flags));
        }

        /**
         * Value. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                arraySize = 4,
                description = "Value."
        )
        public final Builder value(byte[] value) {
            this.value = value;
            return this;
        }

        public final GoproSetRequest build() {
            return new GoproSetRequest(targetSystem, targetComponent, cmdId, value);
        }
    }
}
