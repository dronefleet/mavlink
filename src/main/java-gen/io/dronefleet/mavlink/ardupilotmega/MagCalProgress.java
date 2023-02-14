package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.common.MagCalStatus;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Reports progress of compass calibration. 
 */
@MavlinkMessageInfo(
        id = 191,
        crc = 92,
        description = "Reports progress of compass calibration."
)
public final class MagCalProgress {
    private final int compassId;

    private final int calMask;

    private final EnumValue<MagCalStatus> calStatus;

    private final int attempt;

    private final int completionPct;

    private final byte[] completionMask;

    private final float directionX;

    private final float directionY;

    private final float directionZ;

    private MagCalProgress(int compassId, int calMask, EnumValue<MagCalStatus> calStatus,
            int attempt, int completionPct, byte[] completionMask, float directionX,
            float directionY, float directionZ) {
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
     * Compass being calibrated. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "Compass being calibrated."
    )
    public final int compassId() {
        return this.compassId;
    }

    /**
     * Bitmask of compasses being calibrated. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Bitmask of compasses being calibrated."
    )
    public final int calMask() {
        return this.calMask;
    }

    /**
     * Calibration Status. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = MagCalStatus.class,
            description = "Calibration Status."
    )
    public final EnumValue<MagCalStatus> calStatus() {
        return this.calStatus;
    }

    /**
     * Attempt number. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "Attempt number."
    )
    public final int attempt() {
        return this.attempt;
    }

    /**
     * Completion percentage. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "Completion percentage."
    )
    public final int completionPct() {
        return this.completionPct;
    }

    /**
     * Bitmask of sphere sections (see http://en.wikipedia.org/wiki/Geodesic_grid). 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            arraySize = 10,
            description = "Bitmask of sphere sections (see http://en.wikipedia.org/wiki/Geodesic_grid)."
    )
    public final byte[] completionMask() {
        return this.completionMask;
    }

    /**
     * Body frame direction vector for display. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Body frame direction vector for display."
    )
    public final float directionX() {
        return this.directionX;
    }

    /**
     * Body frame direction vector for display. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Body frame direction vector for display."
    )
    public final float directionY() {
        return this.directionY;
    }

    /**
     * Body frame direction vector for display. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Body frame direction vector for display."
    )
    public final float directionZ() {
        return this.directionZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        MagCalProgress other = (MagCalProgress)o;
        if (!Objects.deepEquals(compassId, other.compassId)) return false;
        if (!Objects.deepEquals(calMask, other.calMask)) return false;
        if (!Objects.deepEquals(calStatus, other.calStatus)) return false;
        if (!Objects.deepEquals(attempt, other.attempt)) return false;
        if (!Objects.deepEquals(completionPct, other.completionPct)) return false;
        if (!Objects.deepEquals(completionMask, other.completionMask)) return false;
        if (!Objects.deepEquals(directionX, other.directionX)) return false;
        if (!Objects.deepEquals(directionY, other.directionY)) return false;
        if (!Objects.deepEquals(directionZ, other.directionZ)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(compassId);
        result = 31 * result + Objects.hashCode(calMask);
        result = 31 * result + Objects.hashCode(calStatus);
        result = 31 * result + Objects.hashCode(attempt);
        result = 31 * result + Objects.hashCode(completionPct);
        result = 31 * result + Objects.hashCode(completionMask);
        result = 31 * result + Objects.hashCode(directionX);
        result = 31 * result + Objects.hashCode(directionY);
        result = 31 * result + Objects.hashCode(directionZ);
        return result;
    }

    @Override
    public String toString() {
        return "MagCalProgress{compassId=" + compassId
                 + ", calMask=" + calMask
                 + ", calStatus=" + calStatus
                 + ", attempt=" + attempt
                 + ", completionPct=" + completionPct
                 + ", completionMask=" + completionMask
                 + ", directionX=" + directionX
                 + ", directionY=" + directionY
                 + ", directionZ=" + directionZ + "}";
    }

    public static final class Builder {
        private int compassId;

        private int calMask;

        private EnumValue<MagCalStatus> calStatus;

        private int attempt;

        private int completionPct;

        private byte[] completionMask;

        private float directionX;

        private float directionY;

        private float directionZ;

        /**
         * Compass being calibrated. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "Compass being calibrated."
        )
        public final Builder compassId(int compassId) {
            this.compassId = compassId;
            return this;
        }

        /**
         * Bitmask of compasses being calibrated. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Bitmask of compasses being calibrated."
        )
        public final Builder calMask(int calMask) {
            this.calMask = calMask;
            return this;
        }

        /**
         * Calibration Status. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = MagCalStatus.class,
                description = "Calibration Status."
        )
        public final Builder calStatus(EnumValue<MagCalStatus> calStatus) {
            this.calStatus = calStatus;
            return this;
        }

        /**
         * Calibration Status. 
         */
        public final Builder calStatus(MagCalStatus entry) {
            return calStatus(EnumValue.of(entry));
        }

        /**
         * Calibration Status. 
         */
        public final Builder calStatus(Enum... flags) {
            return calStatus(EnumValue.create(flags));
        }

        /**
         * Calibration Status. 
         */
        public final Builder calStatus(Collection<Enum> flags) {
            return calStatus(EnumValue.create(flags));
        }

        /**
         * Attempt number. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "Attempt number."
        )
        public final Builder attempt(int attempt) {
            this.attempt = attempt;
            return this;
        }

        /**
         * Completion percentage. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "Completion percentage."
        )
        public final Builder completionPct(int completionPct) {
            this.completionPct = completionPct;
            return this;
        }

        /**
         * Bitmask of sphere sections (see http://en.wikipedia.org/wiki/Geodesic_grid). 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                arraySize = 10,
                description = "Bitmask of sphere sections (see http://en.wikipedia.org/wiki/Geodesic_grid)."
        )
        public final Builder completionMask(byte[] completionMask) {
            this.completionMask = completionMask;
            return this;
        }

        /**
         * Body frame direction vector for display. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Body frame direction vector for display."
        )
        public final Builder directionX(float directionX) {
            this.directionX = directionX;
            return this;
        }

        /**
         * Body frame direction vector for display. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Body frame direction vector for display."
        )
        public final Builder directionY(float directionY) {
            this.directionY = directionY;
            return this;
        }

        /**
         * Body frame direction vector for display. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Body frame direction vector for display."
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
