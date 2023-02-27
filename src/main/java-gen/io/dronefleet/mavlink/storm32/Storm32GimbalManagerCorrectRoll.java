package io.dronefleet.mavlink.storm32;

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
 * Message to a gimbal manager to correct the gimbal roll angle. This message is typically used to 
 * manually correct for a tilted horizon in operation. A gimbal device is never to react to this 
 * message. 
 */
@MavlinkMessageInfo(
        id = 60014,
        crc = 134,
        description = "Message to a gimbal manager to correct the gimbal roll angle. This message is typically used to manually correct for a tilted horizon in operation. A gimbal device is never to react to this message."
)
public final class Storm32GimbalManagerCorrectRoll {
    private final int targetSystem;

    private final int targetComponent;

    private final int gimbalId;

    private final EnumValue<MavStorm32GimbalManagerClient> client;

    private final float roll;

    private Storm32GimbalManagerCorrectRoll(int targetSystem, int targetComponent, int gimbalId,
            EnumValue<MavStorm32GimbalManagerClient> client, float roll) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.gimbalId = gimbalId;
        this.client = client;
        this.roll = roll;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "System ID"
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Gimbal ID of the gimbal manager to address (component ID or 1-6 for non-MAVLink gimbal, 0 for all 
     * gimbals). Send command multiple times for more than one but not all gimbals. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Gimbal ID of the gimbal manager to address (component ID or 1-6 for non-MAVLink gimbal, 0 for all gimbals). Send command multiple times for more than one but not all gimbals."
    )
    public final int gimbalId() {
        return this.gimbalId;
    }

    /**
     * Client which is contacting the gimbal manager (must be set). 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = MavStorm32GimbalManagerClient.class,
            description = "Client which is contacting the gimbal manager (must be set)."
    )
    public final EnumValue<MavStorm32GimbalManagerClient> client() {
        return this.client;
    }

    /**
     * Roll angle (positive to roll to the right). 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Roll angle (positive to roll to the right)."
    )
    public final float roll() {
        return this.roll;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Storm32GimbalManagerCorrectRoll other = (Storm32GimbalManagerCorrectRoll)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(gimbalId, other.gimbalId)) return false;
        if (!Objects.deepEquals(client, other.client)) return false;
        if (!Objects.deepEquals(roll, other.roll)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(gimbalId);
        result = 31 * result + Objects.hashCode(client);
        result = 31 * result + Objects.hashCode(roll);
        return result;
    }

    @Override
    public String toString() {
        return "Storm32GimbalManagerCorrectRoll{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", gimbalId=" + gimbalId
                 + ", client=" + client
                 + ", roll=" + roll + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int gimbalId;

        private EnumValue<MavStorm32GimbalManagerClient> client;

        private float roll;

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "System ID"
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Component ID"
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Gimbal ID of the gimbal manager to address (component ID or 1-6 for non-MAVLink gimbal, 0 for all 
         * gimbals). Send command multiple times for more than one but not all gimbals. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Gimbal ID of the gimbal manager to address (component ID or 1-6 for non-MAVLink gimbal, 0 for all gimbals). Send command multiple times for more than one but not all gimbals."
        )
        public final Builder gimbalId(int gimbalId) {
            this.gimbalId = gimbalId;
            return this;
        }

        /**
         * Client which is contacting the gimbal manager (must be set). 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = MavStorm32GimbalManagerClient.class,
                description = "Client which is contacting the gimbal manager (must be set)."
        )
        public final Builder client(EnumValue<MavStorm32GimbalManagerClient> client) {
            this.client = client;
            return this;
        }

        /**
         * Client which is contacting the gimbal manager (must be set). 
         */
        public final Builder client(MavStorm32GimbalManagerClient entry) {
            return client(EnumValue.of(entry));
        }

        /**
         * Client which is contacting the gimbal manager (must be set). 
         */
        public final Builder client(Enum... flags) {
            return client(EnumValue.create(flags));
        }

        /**
         * Client which is contacting the gimbal manager (must be set). 
         */
        public final Builder client(Collection<Enum> flags) {
            return client(EnumValue.create(flags));
        }

        /**
         * Roll angle (positive to roll to the right). 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Roll angle (positive to roll to the right)."
        )
        public final Builder roll(float roll) {
            this.roll = roll;
            return this;
        }

        public final Storm32GimbalManagerCorrectRoll build() {
            return new Storm32GimbalManagerCorrectRoll(targetSystem, targetComponent, gimbalId, client, roll);
        }
    }
}
