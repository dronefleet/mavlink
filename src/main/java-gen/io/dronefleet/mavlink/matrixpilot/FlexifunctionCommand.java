package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Acknowldge sucess or failure of a flexifunction command 
 */
@MavlinkMessageInfo(
        id = 157,
        crc = 133,
        description = "Acknowldge sucess or failure of a flexifunction command"
)
public final class FlexifunctionCommand {
    private final int targetSystem;

    private final int targetComponent;

    private final int commandType;

    private FlexifunctionCommand(int targetSystem, int targetComponent, int commandType) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.commandType = commandType;
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
     * Flexifunction command type 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Flexifunction command type"
    )
    public final int commandType() {
        return this.commandType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        FlexifunctionCommand other = (FlexifunctionCommand)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(commandType, other.commandType)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(commandType);
        return result;
    }

    @Override
    public String toString() {
        return "FlexifunctionCommand{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", commandType=" + commandType + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int commandType;

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
         * Flexifunction command type 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Flexifunction command type"
        )
        public final Builder commandType(int commandType) {
            this.commandType = commandType;
            return this;
        }

        public final FlexifunctionCommand build() {
            return new FlexifunctionCommand(targetSystem, targetComponent, commandType);
        }
    }
}
