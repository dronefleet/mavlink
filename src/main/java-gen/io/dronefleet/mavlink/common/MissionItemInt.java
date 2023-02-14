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
 * Message encoding a mission item. This message is emitted to announce the presence of a mission 
 * item and to set a mission item on the system. The mission item can be either in x, y, z meters (type: 
 * LOCAL) or x:lat, y:lon, z:altitude. Local frame is Z-down, right handed (NED), global frame is 
 * Z-up, right handed (ENU). NaN or INT32_MAX may be used in float/integer params (respectively) 
 * to indicate optional/default values (e.g. to use the component's current latitude, yaw 
 * rather than a specific value). See also https://mavlink.io/en/services/mission.html. 
 */
@MavlinkMessageInfo(
        id = 73,
        crc = 38,
        description = "Message encoding a mission item. This message is emitted to announce\n"
                        + "                the presence of a mission item and to set a mission item on the system. The mission item can be either in x, y, z meters (type: LOCAL) or x:lat, y:lon, z:altitude. Local frame is Z-down, right handed (NED), global frame is Z-up, right handed (ENU). NaN or INT32_MAX may be used in float/integer params (respectively) to indicate optional/default values (e.g. to use the component's current latitude, yaw rather than a specific value). See also https://mavlink.io/en/services/mission.html."
)
public final class MissionItemInt {
    private final int targetSystem;

    private final int targetComponent;

    private final int seq;

    private final EnumValue<MavFrame> frame;

    private final EnumValue<MavCmd> command;

    private final int current;

    private final int autocontinue;

    private final float param1;

    private final float param2;

    private final float param3;

    private final float param4;

    private final int x;

    private final int y;

    private final float z;

    private final EnumValue<MavMissionType> missionType;

    private MissionItemInt(int targetSystem, int targetComponent, int seq,
            EnumValue<MavFrame> frame, EnumValue<MavCmd> command, int current, int autocontinue,
            float param1, float param2, float param3, float param4, int x, int y, float z,
            EnumValue<MavMissionType> missionType) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.seq = seq;
        this.frame = frame;
        this.command = command;
        this.current = current;
        this.autocontinue = autocontinue;
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.param4 = param4;
        this.x = x;
        this.y = y;
        this.z = z;
        this.missionType = missionType;
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
     * Waypoint ID (sequence number). Starts at zero. Increases monotonically for each waypoint, no 
     * gaps in the sequence (0,1,2,3,4). 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "Waypoint ID (sequence number). Starts at zero. Increases monotonically for each waypoint, no gaps in the sequence (0,1,2,3,4)."
    )
    public final int seq() {
        return this.seq;
    }

    /**
     * The coordinate system of the waypoint. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = MavFrame.class,
            description = "The coordinate system of the waypoint."
    )
    public final EnumValue<MavFrame> frame() {
        return this.frame;
    }

    /**
     * The scheduled action for the waypoint. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            enumType = MavCmd.class,
            description = "The scheduled action for the waypoint."
    )
    public final EnumValue<MavCmd> command() {
        return this.command;
    }

    /**
     * false:0, true:1 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            description = "false:0, true:1"
    )
    public final int current() {
        return this.current;
    }

    /**
     * Autocontinue to next waypoint. 0: false, 1: true. Set false to pause mission after the item 
     * completes. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            description = "Autocontinue to next waypoint. 0: false, 1: true. Set false to pause mission after the item completes."
    )
    public final int autocontinue() {
        return this.autocontinue;
    }

    /**
     * PARAM1, see {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "PARAM1, see MAV_CMD enum"
    )
    public final float param1() {
        return this.param1;
    }

    /**
     * PARAM2, see {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "PARAM2, see MAV_CMD enum"
    )
    public final float param2() {
        return this.param2;
    }

    /**
     * PARAM3, see {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "PARAM3, see MAV_CMD enum"
    )
    public final float param3() {
        return this.param3;
    }

    /**
     * PARAM4, see {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "PARAM4, see MAV_CMD enum"
    )
    public final float param4() {
        return this.param4;
    }

    /**
     * PARAM5 / local: x position in meters * 1e4, global: latitude in degrees * 10^7 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            signed = true,
            description = "PARAM5 / local: x position in meters * 1e4, global: latitude in degrees * 10^7"
    )
    public final int x() {
        return this.x;
    }

    /**
     * PARAM6 / y position: local: x position in meters * 1e4, global: longitude in degrees *10^7 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            signed = true,
            description = "PARAM6 / y position: local: x position in meters * 1e4, global: longitude in degrees *10^7"
    )
    public final int y() {
        return this.y;
    }

    /**
     * PARAM7 / z position: global: altitude in meters (relative or absolute, depending on frame. 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4,
            description = "PARAM7 / z position: global: altitude in meters (relative or absolute, depending on frame."
    )
    public final float z() {
        return this.z;
    }

    /**
     * Mission type. 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 1,
            enumType = MavMissionType.class,
            extension = true,
            description = "Mission type."
    )
    public final EnumValue<MavMissionType> missionType() {
        return this.missionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        MissionItemInt other = (MissionItemInt)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(seq, other.seq)) return false;
        if (!Objects.deepEquals(frame, other.frame)) return false;
        if (!Objects.deepEquals(command, other.command)) return false;
        if (!Objects.deepEquals(current, other.current)) return false;
        if (!Objects.deepEquals(autocontinue, other.autocontinue)) return false;
        if (!Objects.deepEquals(param1, other.param1)) return false;
        if (!Objects.deepEquals(param2, other.param2)) return false;
        if (!Objects.deepEquals(param3, other.param3)) return false;
        if (!Objects.deepEquals(param4, other.param4)) return false;
        if (!Objects.deepEquals(x, other.x)) return false;
        if (!Objects.deepEquals(y, other.y)) return false;
        if (!Objects.deepEquals(z, other.z)) return false;
        if (!Objects.deepEquals(missionType, other.missionType)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(seq);
        result = 31 * result + Objects.hashCode(frame);
        result = 31 * result + Objects.hashCode(command);
        result = 31 * result + Objects.hashCode(current);
        result = 31 * result + Objects.hashCode(autocontinue);
        result = 31 * result + Objects.hashCode(param1);
        result = 31 * result + Objects.hashCode(param2);
        result = 31 * result + Objects.hashCode(param3);
        result = 31 * result + Objects.hashCode(param4);
        result = 31 * result + Objects.hashCode(x);
        result = 31 * result + Objects.hashCode(y);
        result = 31 * result + Objects.hashCode(z);
        result = 31 * result + Objects.hashCode(missionType);
        return result;
    }

    @Override
    public String toString() {
        return "MissionItemInt{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", seq=" + seq
                 + ", frame=" + frame
                 + ", command=" + command
                 + ", current=" + current
                 + ", autocontinue=" + autocontinue
                 + ", param1=" + param1
                 + ", param2=" + param2
                 + ", param3=" + param3
                 + ", param4=" + param4
                 + ", x=" + x
                 + ", y=" + y
                 + ", z=" + z
                 + ", missionType=" + missionType + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int seq;

        private EnumValue<MavFrame> frame;

        private EnumValue<MavCmd> command;

        private int current;

        private int autocontinue;

        private float param1;

        private float param2;

        private float param3;

        private float param4;

        private int x;

        private int y;

        private float z;

        private EnumValue<MavMissionType> missionType;

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
         * Waypoint ID (sequence number). Starts at zero. Increases monotonically for each waypoint, no 
         * gaps in the sequence (0,1,2,3,4). 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "Waypoint ID (sequence number). Starts at zero. Increases monotonically for each waypoint, no gaps in the sequence (0,1,2,3,4)."
        )
        public final Builder seq(int seq) {
            this.seq = seq;
            return this;
        }

        /**
         * The coordinate system of the waypoint. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = MavFrame.class,
                description = "The coordinate system of the waypoint."
        )
        public final Builder frame(EnumValue<MavFrame> frame) {
            this.frame = frame;
            return this;
        }

        /**
         * The coordinate system of the waypoint. 
         */
        public final Builder frame(MavFrame entry) {
            return frame(EnumValue.of(entry));
        }

        /**
         * The coordinate system of the waypoint. 
         */
        public final Builder frame(Enum... flags) {
            return frame(EnumValue.create(flags));
        }

        /**
         * The coordinate system of the waypoint. 
         */
        public final Builder frame(Collection<Enum> flags) {
            return frame(EnumValue.create(flags));
        }

        /**
         * The scheduled action for the waypoint. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                enumType = MavCmd.class,
                description = "The scheduled action for the waypoint."
        )
        public final Builder command(EnumValue<MavCmd> command) {
            this.command = command;
            return this;
        }

        /**
         * The scheduled action for the waypoint. 
         */
        public final Builder command(MavCmd entry) {
            return command(EnumValue.of(entry));
        }

        /**
         * The scheduled action for the waypoint. 
         */
        public final Builder command(Enum... flags) {
            return command(EnumValue.create(flags));
        }

        /**
         * The scheduled action for the waypoint. 
         */
        public final Builder command(Collection<Enum> flags) {
            return command(EnumValue.create(flags));
        }

        /**
         * false:0, true:1 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                description = "false:0, true:1"
        )
        public final Builder current(int current) {
            this.current = current;
            return this;
        }

        /**
         * Autocontinue to next waypoint. 0: false, 1: true. Set false to pause mission after the item 
         * completes. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                description = "Autocontinue to next waypoint. 0: false, 1: true. Set false to pause mission after the item completes."
        )
        public final Builder autocontinue(int autocontinue) {
            this.autocontinue = autocontinue;
            return this;
        }

        /**
         * PARAM1, see {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "PARAM1, see MAV_CMD enum"
        )
        public final Builder param1(float param1) {
            this.param1 = param1;
            return this;
        }

        /**
         * PARAM2, see {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "PARAM2, see MAV_CMD enum"
        )
        public final Builder param2(float param2) {
            this.param2 = param2;
            return this;
        }

        /**
         * PARAM3, see {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "PARAM3, see MAV_CMD enum"
        )
        public final Builder param3(float param3) {
            this.param3 = param3;
            return this;
        }

        /**
         * PARAM4, see {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "PARAM4, see MAV_CMD enum"
        )
        public final Builder param4(float param4) {
            this.param4 = param4;
            return this;
        }

        /**
         * PARAM5 / local: x position in meters * 1e4, global: latitude in degrees * 10^7 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                signed = true,
                description = "PARAM5 / local: x position in meters * 1e4, global: latitude in degrees * 10^7"
        )
        public final Builder x(int x) {
            this.x = x;
            return this;
        }

        /**
         * PARAM6 / y position: local: x position in meters * 1e4, global: longitude in degrees *10^7 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                signed = true,
                description = "PARAM6 / y position: local: x position in meters * 1e4, global: longitude in degrees *10^7"
        )
        public final Builder y(int y) {
            this.y = y;
            return this;
        }

        /**
         * PARAM7 / z position: global: altitude in meters (relative or absolute, depending on frame. 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 4,
                description = "PARAM7 / z position: global: altitude in meters (relative or absolute, depending on frame."
        )
        public final Builder z(float z) {
            this.z = z;
            return this;
        }

        /**
         * Mission type. 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 1,
                enumType = MavMissionType.class,
                extension = true,
                description = "Mission type."
        )
        public final Builder missionType(EnumValue<MavMissionType> missionType) {
            this.missionType = missionType;
            return this;
        }

        /**
         * Mission type. 
         */
        public final Builder missionType(MavMissionType entry) {
            return missionType(EnumValue.of(entry));
        }

        /**
         * Mission type. 
         */
        public final Builder missionType(Enum... flags) {
            return missionType(EnumValue.create(flags));
        }

        /**
         * Mission type. 
         */
        public final Builder missionType(Collection<Enum> flags) {
            return missionType(EnumValue.create(flags));
        }

        public final MissionItemInt build() {
            return new MissionItemInt(targetSystem, targetComponent, seq, frame, command, current, autocontinue, param1, param2, param3, param4, x, y, z, missionType);
        }
    }
}
