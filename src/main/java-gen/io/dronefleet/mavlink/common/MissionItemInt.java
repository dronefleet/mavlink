package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Message encoding a mission item. This message is emitted to announce the presence of a mission 
 * item and to set a mission item on the system. The mission item can be either in x, y, z meters (type: 
 * LOCAL) or x:lat, y:lon, z:altitude. Local frame is Z-down, right handed (NED), global frame is 
 * Z-up, right handed (ENU). See also https://mavlink.io/en/protocol/mission.html. 
 */
@MavlinkMessageInfo(
        id = 73,
        crc = 209
)
public final class MissionItemInt {
    private final int targetSystem;

    private final int targetComponent;

    private final int seq;

    private final MavFrame frame;

    private final MavCmd command;

    private final int current;

    private final int autocontinue;

    private final float param1;

    private final float param2;

    private final float param3;

    private final float param4;

    private final int x;

    private final int y;

    private final float z;

    private final MavMissionType missionType;

    private MissionItemInt(int targetSystem, int targetComponent, int seq, MavFrame frame,
            MavCmd command, int current, int autocontinue, float param1, float param2, float param3,
            float param4, int x, int y, float z, MavMissionType missionType) {
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
            unitSize = 1
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
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
            unitSize = 2
    )
    public final int seq() {
        return this.seq;
    }

    /**
     * The coordinate system of the waypoint, as defined by {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} enum 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final MavFrame frame() {
        return this.frame;
    }

    /**
     * The scheduled action for the waypoint, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2
    )
    public final MavCmd command() {
        return this.command;
    }

    /**
     * false:0, true:1 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1
    )
    public final int current() {
        return this.current;
    }

    /**
     * autocontinue to next wp 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1
    )
    public final int autocontinue() {
        return this.autocontinue;
    }

    /**
     * PARAM1, see {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float param1() {
        return this.param1;
    }

    /**
     * PARAM2, see {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float param2() {
        return this.param2;
    }

    /**
     * PARAM3, see {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4
    )
    public final float param3() {
        return this.param3;
    }

    /**
     * PARAM4, see {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4
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
            signed = true
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
            signed = true
    )
    public final int y() {
        return this.y;
    }

    /**
     * PARAM7 / z position: global: altitude in meters (relative or absolute, depending on frame. 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4
    )
    public final float z() {
        return this.z;
    }

    /**
     * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MAV_MISSION_TYPE} 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 1,
            extension = true
    )
    public final MavMissionType missionType() {
        return this.missionType;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int seq;

        private MavFrame frame;

        private MavCmd command;

        private int current;

        private int autocontinue;

        private float param1;

        private float param2;

        private float param3;

        private float param4;

        private int x;

        private int y;

        private float z;

        private MavMissionType missionType;

        /**
         * System ID 
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
         * Component ID 
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
         * Waypoint ID (sequence number). Starts at zero. Increases monotonically for each waypoint, no 
         * gaps in the sequence (0,1,2,3,4). 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2
        )
        public final Builder seq(int seq) {
            this.seq = seq;
            return this;
        }

        /**
         * The coordinate system of the waypoint, as defined by {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} enum 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder frame(MavFrame frame) {
            this.frame = frame;
            return this;
        }

        /**
         * The scheduled action for the waypoint, as defined by {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} enum 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2
        )
        public final Builder command(MavCmd command) {
            this.command = command;
            return this;
        }

        /**
         * false:0, true:1 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1
        )
        public final Builder current(int current) {
            this.current = current;
            return this;
        }

        /**
         * autocontinue to next wp 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1
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
                unitSize = 4
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
                unitSize = 4
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
                unitSize = 4
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
                unitSize = 4
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
                signed = true
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
                signed = true
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
                unitSize = 4
        )
        public final Builder z(float z) {
            this.z = z;
            return this;
        }

        /**
         * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MAV_MISSION_TYPE} 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 1,
                extension = true
        )
        public final Builder missionType(MavMissionType missionType) {
            this.missionType = missionType;
            return this;
        }

        public final MissionItemInt build() {
            return new MissionItemInt(targetSystem, targetComponent, seq, frame, command, current, autocontinue, param1, param2, param3, param4, x, y, z, missionType);
        }
    }
}
