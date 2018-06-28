package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Reports progress of compass calibration. 
 */
@MavlinkMessageInfo(
        id = 191,
        crc = 92
)
public final class MagCalProgress {
    private final int compassId;

    private final int calMask;

    private final MagCalStatus calStatus;

    private final int attempt;

    private final int completionPct;

    private final byte[] completionMask;

    private final float directionX;

    private final float directionY;

    private final float directionZ;

    private MagCalProgress(int compassId, int calMask, MagCalStatus calStatus, int attempt,
            int completionPct, byte[] completionMask, float directionX, float directionY,
            float directionZ) {
        this.compassId = compassId;
        this.calMask = calMask;
        this.calStatus = calStatus;
        this.attempt = attempt;
        this.completionPct = completionPct;
        this.completionMask = completionMask;
        this.directionX = directionX;
        this.directionY = directionY;
        this.directionZ = directionZ;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Compass being calibrated 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int compassId() {
        return this.compassId;
    }

    /**
     * Bitmask of compasses being calibrated 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int calMask() {
        return this.calMask;
    }

    /**
     * Status (see {@link io.dronefleet.mavlink.ardupilotmega.MagCalStatus MAG_CAL_STATUS} enum) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final MagCalStatus calStatus() {
        return this.calStatus;
    }

    /**
     * Attempt number 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int attempt() {
        return this.attempt;
    }

    /**
     * Completion percentage 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int completionPct() {
        return this.completionPct;
    }

    /**
     * Bitmask of sphere sections (see http://en.wikipedia.org/wiki/Geodesic_grid) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            arraySize = 10
    )
    public final byte[] completionMask() {
        return this.completionMask;
    }

    /**
     * Body frame direction vector for display 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float directionX() {
        return this.directionX;
    }

    /**
     * Body frame direction vector for display 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float directionY() {
        return this.directionY;
    }

    /**
     * Body frame direction vector for display 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float directionZ() {
        return this.directionZ;
    }

    public static final class Builder {
        private int compassId;

        private int calMask;

        private MagCalStatus calStatus;

        private int attempt;

        private int completionPct;

        private byte[] completionMask;

        private float directionX;

        private float directionY;

        private float directionZ;

        /**
         * Compass being calibrated 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder compassId(int compassId) {
            this.compassId = compassId;
            return this;
        }

        /**
         * Bitmask of compasses being calibrated 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder calMask(int calMask) {
            this.calMask = calMask;
            return this;
        }

        /**
         * Status (see {@link io.dronefleet.mavlink.ardupilotmega.MagCalStatus MAG_CAL_STATUS} enum) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder calStatus(MagCalStatus calStatus) {
            this.calStatus = calStatus;
            return this;
        }

        /**
         * Attempt number 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder attempt(int attempt) {
            this.attempt = attempt;
            return this;
        }

        /**
         * Completion percentage 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder completionPct(int completionPct) {
            this.completionPct = completionPct;
            return this;
        }

        /**
         * Bitmask of sphere sections (see http://en.wikipedia.org/wiki/Geodesic_grid) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                arraySize = 10
        )
        public final Builder completionMask(byte[] completionMask) {
            this.completionMask = completionMask;
            return this;
        }

        /**
         * Body frame direction vector for display 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder directionX(float directionX) {
            this.directionX = directionX;
            return this;
        }

        /**
         * Body frame direction vector for display 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder directionY(float directionY) {
            this.directionY = directionY;
            return this;
        }

        /**
         * Body frame direction vector for display 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4
        )
        public final Builder directionZ(float directionZ) {
            this.directionZ = directionZ;
            return this;
        }

        public final MagCalProgress build() {
            return new MagCalProgress(compassId, calMask, calStatus, attempt, completionPct, completionMask, directionX, directionY, directionZ);
        }
    }
}
