package io.dronefleet.mavlink.common;

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
 * Send a command with up to seven parameters to the MAV 
 */
@MavlinkMessageInfo(
        id = 76,
        crc = 152
)
public final class CommandLong {
    private final int targetSystem;

    private final int targetComponent;

    private final EnumValue<MavCmd> command;

    private final int confirmation;

    private final float param1;

    private final float param2;

    private final float param3;

    private final float param4;

    private final float param5;

    private final float param6;

    private final float param7;

    private CommandLong(int targetSystem, int targetComponent, EnumValue<MavCmd> command,
            int confirmation, float param1, float param2, float param3, float param4, float param5,
            float param6, float param7) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.command = command;
        this.confirmation = confirmation;
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.param4 = param4;
        this.param5 = param5;
        this.param6 = param6;
        this.param7 = param7;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System which should execute the command 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component which should execute the command, 0 for all components 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Command ID, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            enumType = MavCmd.class
    )
    public final EnumValue<MavCmd> command() {
        return this.command;
    }

    /**
     * 0: First transmission of this command. 1-255: Confirmation transmissions (e.g. for kill 
     * command) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int confirmation() {
        return this.confirmation;
    }

    /**
     * Parameter 1, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float param1() {
        return this.param1;
    }

    /**
     * Parameter 2, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float param2() {
        return this.param2;
    }

    /**
     * Parameter 3, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float param3() {
        return this.param3;
    }

    /**
     * Parameter 4, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float param4() {
        return this.param4;
    }

    /**
     * Parameter 5, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float param5() {
        return this.param5;
    }

    /**
     * Parameter 6, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4
    )
    public final float param6() {
        return this.param6;
    }

    /**
     * Parameter 7, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum. 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4
    )
    public final float param7() {
        return this.param7;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CommandLong other = (CommandLong)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(command, other.command)) return false;
        if (!Objects.deepEquals(confirmation, other.confirmation)) return false;
        if (!Objects.deepEquals(param1, other.param1)) return false;
        if (!Objects.deepEquals(param2, other.param2)) return false;
        if (!Objects.deepEquals(param3, other.param3)) return false;
        if (!Objects.deepEquals(param4, other.param4)) return false;
        if (!Objects.deepEquals(param5, other.param5)) return false;
        if (!Objects.deepEquals(param6, other.param6)) return false;
        if (!Objects.deepEquals(param7, other.param7)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(command);
        result = 31 * result + Objects.hashCode(confirmation);
        result = 31 * result + Objects.hashCode(param1);
        result = 31 * result + Objects.hashCode(param2);
        result = 31 * result + Objects.hashCode(param3);
        result = 31 * result + Objects.hashCode(param4);
        result = 31 * result + Objects.hashCode(param5);
        result = 31 * result + Objects.hashCode(param6);
        result = 31 * result + Objects.hashCode(param7);
        return result;
    }

    @Override
    public String toString() {
        return "CommandLong{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", command=" + command
                 + ", confirmation=" + confirmation
                 + ", param1=" + param1
                 + ", param2=" + param2
                 + ", param3=" + param3
                 + ", param4=" + param4
                 + ", param5=" + param5
                 + ", param6=" + param6
                 + ", param7=" + param7 + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private EnumValue<MavCmd> command;

        private int confirmation;

        private float param1;

        private float param2;

        private float param3;

        private float param4;

        private float param5;

        private float param6;

        private float param7;

        /**
         * System which should execute the command 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component which should execute the command, 0 for all components 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Command ID, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                enumType = MavCmd.class
        )
        public final Builder command(EnumValue<MavCmd> command) {
            this.command = command;
            return this;
        }

        /**
         * Command ID, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum. 
         */
        public final Builder command(MavCmd entry) {
            return command(EnumValue.of(entry));
        }

        /**
         * Command ID, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum. 
         */
        public final Builder command(Enum... flags) {
            return command(EnumValue.create(flags));
        }

        /**
         * Command ID, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum. 
         */
        public final Builder command(Collection<Enum> flags) {
            return command(EnumValue.create(flags));
        }

        /**
         * 0: First transmission of this command. 1-255: Confirmation transmissions (e.g. for kill 
         * command) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder confirmation(int confirmation) {
            this.confirmation = confirmation;
            return this;
        }

        /**
         * Parameter 1, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder param1(float param1) {
            this.param1 = param1;
            return this;
        }

        /**
         * Parameter 2, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder param2(float param2) {
            this.param2 = param2;
            return this;
        }

        /**
         * Parameter 3, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder param3(float param3) {
            this.param3 = param3;
            return this;
        }

        /**
         * Parameter 4, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder param4(float param4) {
            this.param4 = param4;
            return this;
        }

        /**
         * Parameter 5, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4
        )
        public final Builder param5(float param5) {
            this.param5 = param5;
            return this;
        }

        /**
         * Parameter 6, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4
        )
        public final Builder param6(float param6) {
            this.param6 = param6;
            return this;
        }

        /**
         * Parameter 7, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum. 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4
        )
        public final Builder param7(float param7) {
            this.param7 = param7;
            return this;
        }

        public final CommandLong build() {
            return new CommandLong(targetSystem, targetComponent, command, confirmation, param1, param2, param3, param4, param5, param6, param7);
        }
    }
}
