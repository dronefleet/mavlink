package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * Describe a trajectory using an array of up-to 5 bezier points in the local frame. 
 */
@MavlinkMessageInfo(
        id = 333,
        crc = 231,
        description = "Describe a trajectory using an array of up-to 5 bezier points in the local frame."
)
public final class TrajectoryRepresentationBezier {
    private final BigInteger timeUsec;

    private final int validPoints;

    private final List<Float> posX;

    private final List<Float> posY;

    private final List<Float> posZ;

    private final List<Float> delta;

    private final List<Float> posYaw;

    private TrajectoryRepresentationBezier(BigInteger timeUsec, int validPoints, List<Float> posX,
            List<Float> posY, List<Float> posZ, List<Float> delta, List<Float> posYaw) {
        this.timeUsec = timeUsec;
        this.validPoints = validPoints;
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        this.delta = delta;
        this.posYaw = posYaw;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
     * format (since 1.1.1970 or since system boot) by checking for the magnitude the number. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 8,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude the number."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Number of valid points (up-to 5 waypoints are possible) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Number of valid points (up-to 5 waypoints are possible)"
    )
    public final int validPoints() {
        return this.validPoints;
    }

    /**
     * X-coordinate of starting bezier point, set to NaN if not being used 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            arraySize = 5,
            description = "X-coordinate of starting bezier point, set to NaN if not being used"
    )
    public final List<Float> posX() {
        return this.posX;
    }

    /**
     * Y-coordinate of starting bezier point, set to NaN if not being used 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            arraySize = 5,
            description = "Y-coordinate of starting bezier point, set to NaN if not being used"
    )
    public final List<Float> posY() {
        return this.posY;
    }

    /**
     * Z-coordinate of starting bezier point, set to NaN if not being used 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            arraySize = 5,
            description = "Z-coordinate of starting bezier point, set to NaN if not being used"
    )
    public final List<Float> posZ() {
        return this.posZ;
    }

    /**
     * Bezier time horizon, set to NaN if velocity/acceleration should not be incorporated 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            arraySize = 5,
            description = "Bezier time horizon, set to NaN if velocity/acceleration should not be incorporated"
    )
    public final List<Float> delta() {
        return this.delta;
    }

    /**
     * Yaw, set to NaN for unchanged 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            arraySize = 5,
            description = "Yaw, set to NaN for unchanged"
    )
    public final List<Float> posYaw() {
        return this.posYaw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        TrajectoryRepresentationBezier other = (TrajectoryRepresentationBezier)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(validPoints, other.validPoints)) return false;
        if (!Objects.deepEquals(posX, other.posX)) return false;
        if (!Objects.deepEquals(posY, other.posY)) return false;
        if (!Objects.deepEquals(posZ, other.posZ)) return false;
        if (!Objects.deepEquals(delta, other.delta)) return false;
        if (!Objects.deepEquals(posYaw, other.posYaw)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(validPoints);
        result = 31 * result + Objects.hashCode(posX);
        result = 31 * result + Objects.hashCode(posY);
        result = 31 * result + Objects.hashCode(posZ);
        result = 31 * result + Objects.hashCode(delta);
        result = 31 * result + Objects.hashCode(posYaw);
        return result;
    }

    @Override
    public String toString() {
        return "TrajectoryRepresentationBezier{timeUsec=" + timeUsec
                 + ", validPoints=" + validPoints
                 + ", posX=" + posX
                 + ", posY=" + posY
                 + ", posZ=" + posZ
                 + ", delta=" + delta
                 + ", posYaw=" + posYaw + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private int validPoints;

        private List<Float> posX;

        private List<Float> posY;

        private List<Float> posZ;

        private List<Float> delta;

        private List<Float> posYaw;

        /**
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude the number. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 8,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude the number."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Number of valid points (up-to 5 waypoints are possible) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Number of valid points (up-to 5 waypoints are possible)"
        )
        public final Builder validPoints(int validPoints) {
            this.validPoints = validPoints;
            return this;
        }

        /**
         * X-coordinate of starting bezier point, set to NaN if not being used 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                arraySize = 5,
                description = "X-coordinate of starting bezier point, set to NaN if not being used"
        )
        public final Builder posX(List<Float> posX) {
            this.posX = posX;
            return this;
        }

        /**
         * Y-coordinate of starting bezier point, set to NaN if not being used 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                arraySize = 5,
                description = "Y-coordinate of starting bezier point, set to NaN if not being used"
        )
        public final Builder posY(List<Float> posY) {
            this.posY = posY;
            return this;
        }

        /**
         * Z-coordinate of starting bezier point, set to NaN if not being used 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                arraySize = 5,
                description = "Z-coordinate of starting bezier point, set to NaN if not being used"
        )
        public final Builder posZ(List<Float> posZ) {
            this.posZ = posZ;
            return this;
        }

        /**
         * Bezier time horizon, set to NaN if velocity/acceleration should not be incorporated 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                arraySize = 5,
                description = "Bezier time horizon, set to NaN if velocity/acceleration should not be incorporated"
        )
        public final Builder delta(List<Float> delta) {
            this.delta = delta;
            return this;
        }

        /**
         * Yaw, set to NaN for unchanged 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                arraySize = 5,
                description = "Yaw, set to NaN for unchanged"
        )
        public final Builder posYaw(List<Float> posYaw) {
            this.posYaw = posYaw;
            return this;
        }

        public final TrajectoryRepresentationBezier build() {
            return new TrajectoryRepresentationBezier(timeUsec, validPoints, posX, posY, posZ, delta, posYaw);
        }
    }
}
