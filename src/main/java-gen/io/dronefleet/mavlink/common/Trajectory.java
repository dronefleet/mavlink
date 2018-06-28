package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.math.BigInteger;
import java.util.List;

/**
 * WORK IN PROGRESS! DO NOT DEPLOY! Message to describe a trajectory in the local frame. Supported 
 * trajectory types are enumerated in {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MAV_TRAJECTORY_REPRESENTATION} 
 */
@MavlinkMessageInfo(
        id = 332,
        crc = 131
)
public final class Trajectory {
    private final BigInteger timeUsec;

    private final MavTrajectoryRepresentation type;

    private final List<Float> point1;

    private final List<Float> point2;

    private final List<Float> point3;

    private final List<Float> point4;

    private final List<Float> point5;

    private final byte[] pointValid;

    private Trajectory(BigInteger timeUsec, MavTrajectoryRepresentation type, List<Float> point1,
            List<Float> point2, List<Float> point3, List<Float> point4, List<Float> point5,
            byte[] pointValid) {
        this.timeUsec = timeUsec;
        this.type = type;
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
        this.point5 = point5;
        this.pointValid = pointValid;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (microseconds since system boot or since UNIX epoch). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Waypoints, Bezier etc. see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MAV_TRAJECTORY_REPRESENTATION} 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final MavTrajectoryRepresentation type() {
        return this.type;
    }

    /**
     * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MAV_TRAJECTORY_REPRESENTATION}) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            arraySize = 11
    )
    public final List<Float> point1() {
        return this.point1;
    }

    /**
     * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MAV_TRAJECTORY_REPRESENTATION}) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            arraySize = 11
    )
    public final List<Float> point2() {
        return this.point2;
    }

    /**
     * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MAV_TRAJECTORY_REPRESENTATION}) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            arraySize = 11
    )
    public final List<Float> point3() {
        return this.point3;
    }

    /**
     * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MAV_TRAJECTORY_REPRESENTATION}) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            arraySize = 11
    )
    public final List<Float> point4() {
        return this.point4;
    }

    /**
     * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MAV_TRAJECTORY_REPRESENTATION}) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            arraySize = 11
    )
    public final List<Float> point5() {
        return this.point5;
    }

    /**
     * States if respective point is valid (boolean) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            arraySize = 5
    )
    public final byte[] pointValid() {
        return this.pointValid;
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private MavTrajectoryRepresentation type;

        private List<Float> point1;

        private List<Float> point2;

        private List<Float> point3;

        private List<Float> point4;

        private List<Float> point5;

        private byte[] pointValid;

        /**
         * Timestamp (microseconds since system boot or since UNIX epoch). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Waypoints, Bezier etc. see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MAV_TRAJECTORY_REPRESENTATION} 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder type(MavTrajectoryRepresentation type) {
            this.type = type;
            return this;
        }

        /**
         * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MAV_TRAJECTORY_REPRESENTATION}) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                arraySize = 11
        )
        public final Builder point1(List<Float> point1) {
            this.point1 = point1;
            return this;
        }

        /**
         * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MAV_TRAJECTORY_REPRESENTATION}) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                arraySize = 11
        )
        public final Builder point2(List<Float> point2) {
            this.point2 = point2;
            return this;
        }

        /**
         * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MAV_TRAJECTORY_REPRESENTATION}) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                arraySize = 11
        )
        public final Builder point3(List<Float> point3) {
            this.point3 = point3;
            return this;
        }

        /**
         * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MAV_TRAJECTORY_REPRESENTATION}) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                arraySize = 11
        )
        public final Builder point4(List<Float> point4) {
            this.point4 = point4;
            return this;
        }

        /**
         * Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MAV_TRAJECTORY_REPRESENTATION}) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                arraySize = 11
        )
        public final Builder point5(List<Float> point5) {
            this.point5 = point5;
            return this;
        }

        /**
         * States if respective point is valid (boolean) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                arraySize = 5
        )
        public final Builder pointValid(byte[] pointValid) {
            this.pointValid = pointValid;
            return this;
        }

        public final Trajectory build() {
            return new Trajectory(timeUsec, type, point1, point2, point3, point4, point5, pointValid);
        }
    }
}
