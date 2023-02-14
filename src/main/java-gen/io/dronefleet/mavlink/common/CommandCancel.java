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
 * Cancel a long running command. The target system should respond with a {@link io.dronefleet.mavlink.common.CommandAck COMMAND_ACK} to the 
 * original command with result=MAV_RESULT_CANCELLED if the long running process was 
 * cancelled. If it has already completed, the cancel action can be ignored. The cancel action can 
 * be retried until some sort of acknowledgement to the original command has been received. The 
 * command microservice is documented at https://mavlink.io/en/services/command.html 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 80,
        crc = 14,
        description = "Cancel a long running command. The target system should respond with a COMMAND_ACK to the original command with result=MAV_RESULT_CANCELLED if the long running process was cancelled. If it has already completed, the cancel action can be ignored. The cancel action can be retried until some sort of acknowledgement to the original command has been received. The command microservice is documented at https://mavlink.io/en/services/command.html",
        workInProgress = true
)
@Deprecated
public final class CommandCancel {
    private final int targetSystem;

    private final int targetComponent;

    private final EnumValue<MavCmd> command;

    private CommandCancel(int targetSystem, int targetComponent, EnumValue<MavCmd> command) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.command = command;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System executing long running command. Should not be broadcast (0). 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "System executing long running command. Should not be broadcast (0)."
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component executing long running command. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Component executing long running command."
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Command ID (of command to cancel). 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            enumType = MavCmd.class,
            description = "Command ID (of command to cancel)."
    )
    public final EnumValue<MavCmd> command() {
        return this.command;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CommandCancel other = (CommandCancel)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(command, other.command)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(command);
        return result;
    }

    @Override
    public String toString() {
        return "CommandCancel{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", command=" + command + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private EnumValue<MavCmd> command;

        /**
         * System executing long running command. Should not be broadcast (0). 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "System executing long running command. Should not be broadcast (0)."
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component executing long running command. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Component executing long running command."
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Command ID (of command to cancel). 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                enumType = MavCmd.class,
                description = "Command ID (of command to cancel)."
        )
        public final Builder command(EnumValue<MavCmd> command) {
            this.command = command;
            return this;
        }

        /**
         * Command ID (of command to cancel). 
         */
        public final Builder command(MavCmd entry) {
            return command(EnumValue.of(entry));
        }

        /**
         * Command ID (of command to cancel). 
         */
        public final Builder command(Enum... flags) {
            return command(EnumValue.create(flags));
        }

        /**
         * Command ID (of command to cancel). 
         */
        public final Builder command(Collection<Enum> flags) {
            return command(EnumValue.create(flags));
        }

        public final CommandCancel build() {
            return new CommandCancel(targetSystem, targetComponent, command);
        }
    }
}
