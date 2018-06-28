package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Report status of a command. Includes feedback whether the command was executed. 
 */
@MavlinkMessageInfo(
        id = 77,
        crc = 4
)
public final class CommandAck {
    private final MavCmd command;

    private final MavResult result;

    private final int progress;

    private final int resultParam2;

    private final int targetSystem;

    private final int targetComponent;

    private CommandAck(MavCmd command, MavResult result, int progress, int resultParam2,
            int targetSystem, int targetComponent) {
        this.command = command;
        this.result = result;
        this.progress = progress;
        this.resultParam2 = resultParam2;
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Command ID, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2
    )
    public final MavCmd command() {
        return this.command;
    }

    /**
     * See {@link io.dronefleet.mavlink.common.MavResult MAV_RESULT} enum 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final MavResult result() {
        return this.result;
    }

    /**
     * WIP: Also used as result_param1, it can be set with a enum containing the errors reasons of why 
     * the command was denied or the progress percentage or 255 if unknown the progress when result is 
     * MAV_RESULT_IN_PROGRESS. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            extension = true
    )
    public final int progress() {
        return this.progress;
    }

    /**
     * WIP: Additional parameter of the result, example: which parameter of MAV_CMD_NAV_WAYPOINT 
     * caused it to be denied. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            extension = true
    )
    public final int resultParam2() {
        return this.resultParam2;
    }

    /**
     * WIP: System which requested the command to be executed 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            extension = true
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * WIP: Component which requested the command to be executed 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            extension = true
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    public static final class Builder {
        private MavCmd command;

        private MavResult result;

        private int progress;

        private int resultParam2;

        private int targetSystem;

        private int targetComponent;

        /**
         * Command ID, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2
        )
        public final Builder command(MavCmd command) {
            this.command = command;
            return this;
        }

        /**
         * See {@link io.dronefleet.mavlink.common.MavResult MAV_RESULT} enum 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder result(MavResult result) {
            this.result = result;
            return this;
        }

        /**
         * WIP: Also used as result_param1, it can be set with a enum containing the errors reasons of why 
         * the command was denied or the progress percentage or 255 if unknown the progress when result is 
         * MAV_RESULT_IN_PROGRESS. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                extension = true
        )
        public final Builder progress(int progress) {
            this.progress = progress;
            return this;
        }

        /**
         * WIP: Additional parameter of the result, example: which parameter of MAV_CMD_NAV_WAYPOINT 
         * caused it to be denied. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                extension = true
        )
        public final Builder resultParam2(int resultParam2) {
            this.resultParam2 = resultParam2;
            return this;
        }

        /**
         * WIP: System which requested the command to be executed 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                extension = true
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * WIP: Component which requested the command to be executed 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                extension = true
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        public final CommandAck build() {
            return new CommandAck(command, result, progress, resultParam2, targetSystem, targetComponent);
        }
    }
}
