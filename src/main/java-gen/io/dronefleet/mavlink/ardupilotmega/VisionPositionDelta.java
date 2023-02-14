package io.dronefleet.mavlink.ardupilotmega;

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
 * Camera vision based attitude and position deltas. 
 */
@MavlinkMessageInfo(
        id = 11011,
        crc = 106,
        description = "Camera vision based attitude and position deltas."
)
public final class VisionPositionDelta {
    private final BigInteger timeUsec;

    private final BigInteger timeDeltaUsec;

    private final List<Float> angleDelta;

    private final List<Float> positionDelta;

    private final float confidence;

    private VisionPositionDelta(BigInteger timeUsec, BigInteger timeDeltaUsec,
            List<Float> angleDelta, List<Float> positionDelta, float confidence) {
        this.timeUsec = timeUsec;
        this.timeDeltaUsec = timeDeltaUsec;
        this.angleDelta = angleDelta;
        this.positionDelta = positionDelta;
        this.confidence = confidence;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (synced to UNIX time or since system boot). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (synced to UNIX time or since system boot)."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Time since the last reported camera frame. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 8,
            description = "Time since the last reported camera frame."
    )
    public final BigInteger timeDeltaUsec() {
        return this.timeDeltaUsec;
    }

    /**
     * Defines a rotation vector [roll, pitch, yaw] to the current MAV_FRAME_BODY_FRD from the 
     * previous MAV_FRAME_BODY_FRD. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            arraySize = 3,
            description = "Defines a rotation vector [roll, pitch, yaw] to the current MAV_FRAME_BODY_FRD from the previous MAV_FRAME_BODY_FRD."
    )
    public final List<Float> angleDelta() {
        return this.angleDelta;
    }

    /**
     * Change in position to the current MAV_FRAME_BODY_FRD from the previous FRAME_BODY_FRD 
     * rotated to the current MAV_FRAME_BODY_FRD. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            arraySize = 3,
            description = "Change in position to the current MAV_FRAME_BODY_FRD from the previous FRAME_BODY_FRD rotated to the current MAV_FRAME_BODY_FRD."
    )
    public final List<Float> positionDelta() {
        return this.positionDelta;
    }

    /**
     * Normalised confidence value from 0 to 100. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Normalised confidence value from 0 to 100."
    )
    public final float confidence() {
        return this.confidence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        VisionPositionDelta other = (VisionPositionDelta)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(timeDeltaUsec, other.timeDeltaUsec)) return false;
        if (!Objects.deepEquals(angleDelta, other.angleDelta)) return false;
        if (!Objects.deepEquals(positionDelta, other.positionDelta)) return false;
        if (!Objects.deepEquals(confidence, other.confidence)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(timeDeltaUsec);
        result = 31 * result + Objects.hashCode(angleDelta);
        result = 31 * result + Objects.hashCode(positionDelta);
        result = 31 * result + Objects.hashCode(confidence);
        return result;
    }

    @Override
    public String toString() {
        return "VisionPositionDelta{timeUsec=" + timeUsec
                 + ", timeDeltaUsec=" + timeDeltaUsec
                 + ", angleDelta=" + angleDelta
                 + ", positionDelta=" + positionDelta
                 + ", confidence=" + confidence + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private BigInteger timeDeltaUsec;

        private List<Float> angleDelta;

        private List<Float> positionDelta;

        private float confidence;

        /**
         * Timestamp (synced to UNIX time or since system boot). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (synced to UNIX time or since system boot)."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Time since the last reported camera frame. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 8,
                description = "Time since the last reported camera frame."
        )
        public final Builder timeDeltaUsec(BigInteger timeDeltaUsec) {
            this.timeDeltaUsec = timeDeltaUsec;
            return this;
        }

        /**
         * Defines a rotation vector [roll, pitch, yaw] to the current MAV_FRAME_BODY_FRD from the 
         * previous MAV_FRAME_BODY_FRD. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                arraySize = 3,
                description = "Defines a rotation vector [roll, pitch, yaw] to the current MAV_FRAME_BODY_FRD from the previous MAV_FRAME_BODY_FRD."
        )
        public final Builder angleDelta(List<Float> angleDelta) {
            this.angleDelta = angleDelta;
            return this;
        }

        /**
         * Change in position to the current MAV_FRAME_BODY_FRD from the previous FRAME_BODY_FRD 
         * rotated to the current MAV_FRAME_BODY_FRD. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                arraySize = 3,
                description = "Change in position to the current MAV_FRAME_BODY_FRD from the previous FRAME_BODY_FRD rotated to the current MAV_FRAME_BODY_FRD."
        )
        public final Builder positionDelta(List<Float> positionDelta) {
            this.positionDelta = positionDelta;
            return this;
        }

        /**
         * Normalised confidence value from 0 to 100. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Normalised confidence value from 0 to 100."
        )
        public final Builder confidence(float confidence) {
            this.confidence = confidence;
            return this;
        }

        public final VisionPositionDelta build() {
            return new VisionPositionDelta(timeUsec, timeDeltaUsec, angleDelta, positionDelta, confidence);
        }
    }
}
