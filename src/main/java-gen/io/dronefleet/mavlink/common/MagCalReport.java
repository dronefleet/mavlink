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
 * Reports results of completed compass calibration. Sent until MAG_CAL_ACK received. 
 */
@MavlinkMessageInfo(
        id = 192,
        crc = 36,
        description = "Reports results of completed compass calibration. Sent until MAG_CAL_ACK received."
)
public final class MagCalReport {
    private final int compassId;

    private final int calMask;

    private final EnumValue<MagCalStatus> calStatus;

    private final int autosaved;

    private final float fitness;

    private final float ofsX;

    private final float ofsY;

    private final float ofsZ;

    private final float diagX;

    private final float diagY;

    private final float diagZ;

    private final float offdiagX;

    private final float offdiagY;

    private final float offdiagZ;

    private final float orientationConfidence;

    private final EnumValue<MavSensorOrientation> oldOrientation;

    private final EnumValue<MavSensorOrientation> newOrientation;

    private final float scaleFactor;

    private MagCalReport(int compassId, int calMask, EnumValue<MagCalStatus> calStatus,
            int autosaved, float fitness, float ofsX, float ofsY, float ofsZ, float diagX,
            float diagY, float diagZ, float offdiagX, float offdiagY, float offdiagZ,
            float orientationConfidence, EnumValue<MavSensorOrientation> oldOrientation,
            EnumValue<MavSensorOrientation> newOrientation, float scaleFactor) {
        this.compassId = compassId;
        this.calMask = calMask;
        this.calStatus = calStatus;
        this.autosaved = autosaved;
        this.fitness = fitness;
        this.ofsX = ofsX;
        this.ofsY = ofsY;
        this.ofsZ = ofsZ;
        this.diagX = diagX;
        this.diagY = diagY;
        this.diagZ = diagZ;
        this.offdiagX = offdiagX;
        this.offdiagY = offdiagY;
        this.offdiagZ = offdiagZ;
        this.orientationConfidence = orientationConfidence;
        this.oldOrientation = oldOrientation;
        this.newOrientation = newOrientation;
        this.scaleFactor = scaleFactor;
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
     * 0=requires a MAV_CMD_DO_ACCEPT_MAG_CAL, 1=saved to parameters. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "0=requires a MAV_CMD_DO_ACCEPT_MAG_CAL, 1=saved to parameters."
    )
    public final int autosaved() {
        return this.autosaved;
    }

    /**
     * RMS milligauss residuals. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "RMS milligauss residuals."
    )
    public final float fitness() {
        return this.fitness;
    }

    /**
     * X offset. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "X offset."
    )
    public final float ofsX() {
        return this.ofsX;
    }

    /**
     * Y offset. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Y offset."
    )
    public final float ofsY() {
        return this.ofsY;
    }

    /**
     * Z offset. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Z offset."
    )
    public final float ofsZ() {
        return this.ofsZ;
    }

    /**
     * X diagonal (matrix 11). 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "X diagonal (matrix 11)."
    )
    public final float diagX() {
        return this.diagX;
    }

    /**
     * Y diagonal (matrix 22). 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Y diagonal (matrix 22)."
    )
    public final float diagY() {
        return this.diagY;
    }

    /**
     * Z diagonal (matrix 33). 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "Z diagonal (matrix 33)."
    )
    public final float diagZ() {
        return this.diagZ;
    }

    /**
     * X off-diagonal (matrix 12 and 21). 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            description = "X off-diagonal (matrix 12 and 21)."
    )
    public final float offdiagX() {
        return this.offdiagX;
    }

    /**
     * Y off-diagonal (matrix 13 and 31). 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            description = "Y off-diagonal (matrix 13 and 31)."
    )
    public final float offdiagY() {
        return this.offdiagY;
    }

    /**
     * Z off-diagonal (matrix 32 and 23). 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4,
            description = "Z off-diagonal (matrix 32 and 23)."
    )
    public final float offdiagZ() {
        return this.offdiagZ;
    }

    /**
     * Confidence in orientation (higher is better). 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 4,
            extension = true,
            description = "Confidence in orientation (higher is better)."
    )
    public final float orientationConfidence() {
        return this.orientationConfidence;
    }

    /**
     * orientation before calibration. 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 1,
            enumType = MavSensorOrientation.class,
            extension = true,
            description = "orientation before calibration."
    )
    public final EnumValue<MavSensorOrientation> oldOrientation() {
        return this.oldOrientation;
    }

    /**
     * orientation after calibration. 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 1,
            enumType = MavSensorOrientation.class,
            extension = true,
            description = "orientation after calibration."
    )
    public final EnumValue<MavSensorOrientation> newOrientation() {
        return this.newOrientation;
    }

    /**
     * field radius correction factor 
     */
    @MavlinkFieldInfo(
            position = 19,
            unitSize = 4,
            extension = true,
            description = "field radius correction factor"
    )
    public final float scaleFactor() {
        return this.scaleFactor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        MagCalReport other = (MagCalReport)o;
        if (!Objects.deepEquals(compassId, other.compassId)) return false;
        if (!Objects.deepEquals(calMask, other.calMask)) return false;
        if (!Objects.deepEquals(calStatus, other.calStatus)) return false;
        if (!Objects.deepEquals(autosaved, other.autosaved)) return false;
        if (!Objects.deepEquals(fitness, other.fitness)) return false;
        if (!Objects.deepEquals(ofsX, other.ofsX)) return false;
        if (!Objects.deepEquals(ofsY, other.ofsY)) return false;
        if (!Objects.deepEquals(ofsZ, other.ofsZ)) return false;
        if (!Objects.deepEquals(diagX, other.diagX)) return false;
        if (!Objects.deepEquals(diagY, other.diagY)) return false;
        if (!Objects.deepEquals(diagZ, other.diagZ)) return false;
        if (!Objects.deepEquals(offdiagX, other.offdiagX)) return false;
        if (!Objects.deepEquals(offdiagY, other.offdiagY)) return false;
        if (!Objects.deepEquals(offdiagZ, other.offdiagZ)) return false;
        if (!Objects.deepEquals(orientationConfidence, other.orientationConfidence)) return false;
        if (!Objects.deepEquals(oldOrientation, other.oldOrientation)) return false;
        if (!Objects.deepEquals(newOrientation, other.newOrientation)) return false;
        if (!Objects.deepEquals(scaleFactor, other.scaleFactor)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(compassId);
        result = 31 * result + Objects.hashCode(calMask);
        result = 31 * result + Objects.hashCode(calStatus);
        result = 31 * result + Objects.hashCode(autosaved);
        result = 31 * result + Objects.hashCode(fitness);
        result = 31 * result + Objects.hashCode(ofsX);
        result = 31 * result + Objects.hashCode(ofsY);
        result = 31 * result + Objects.hashCode(ofsZ);
        result = 31 * result + Objects.hashCode(diagX);
        result = 31 * result + Objects.hashCode(diagY);
        result = 31 * result + Objects.hashCode(diagZ);
        result = 31 * result + Objects.hashCode(offdiagX);
        result = 31 * result + Objects.hashCode(offdiagY);
        result = 31 * result + Objects.hashCode(offdiagZ);
        result = 31 * result + Objects.hashCode(orientationConfidence);
        result = 31 * result + Objects.hashCode(oldOrientation);
        result = 31 * result + Objects.hashCode(newOrientation);
        result = 31 * result + Objects.hashCode(scaleFactor);
        return result;
    }

    @Override
    public String toString() {
        return "MagCalReport{compassId=" + compassId
                 + ", calMask=" + calMask
                 + ", calStatus=" + calStatus
                 + ", autosaved=" + autosaved
                 + ", fitness=" + fitness
                 + ", ofsX=" + ofsX
                 + ", ofsY=" + ofsY
                 + ", ofsZ=" + ofsZ
                 + ", diagX=" + diagX
                 + ", diagY=" + diagY
                 + ", diagZ=" + diagZ
                 + ", offdiagX=" + offdiagX
                 + ", offdiagY=" + offdiagY
                 + ", offdiagZ=" + offdiagZ
                 + ", orientationConfidence=" + orientationConfidence
                 + ", oldOrientation=" + oldOrientation
                 + ", newOrientation=" + newOrientation
                 + ", scaleFactor=" + scaleFactor + "}";
    }

    public static final class Builder {
        private int compassId;

        private int calMask;

        private EnumValue<MagCalStatus> calStatus;

        private int autosaved;

        private float fitness;

        private float ofsX;

        private float ofsY;

        private float ofsZ;

        private float diagX;

        private float diagY;

        private float diagZ;

        private float offdiagX;

        private float offdiagY;

        private float offdiagZ;

        private float orientationConfidence;

        private EnumValue<MavSensorOrientation> oldOrientation;

        private EnumValue<MavSensorOrientation> newOrientation;

        private float scaleFactor;

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
         * 0=requires a MAV_CMD_DO_ACCEPT_MAG_CAL, 1=saved to parameters. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "0=requires a MAV_CMD_DO_ACCEPT_MAG_CAL, 1=saved to parameters."
        )
        public final Builder autosaved(int autosaved) {
            this.autosaved = autosaved;
            return this;
        }

        /**
         * RMS milligauss residuals. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "RMS milligauss residuals."
        )
        public final Builder fitness(float fitness) {
            this.fitness = fitness;
            return this;
        }

        /**
         * X offset. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "X offset."
        )
        public final Builder ofsX(float ofsX) {
            this.ofsX = ofsX;
            return this;
        }

        /**
         * Y offset. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Y offset."
        )
        public final Builder ofsY(float ofsY) {
            this.ofsY = ofsY;
            return this;
        }

        /**
         * Z offset. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Z offset."
        )
        public final Builder ofsZ(float ofsZ) {
            this.ofsZ = ofsZ;
            return this;
        }

        /**
         * X diagonal (matrix 11). 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "X diagonal (matrix 11)."
        )
        public final Builder diagX(float diagX) {
            this.diagX = diagX;
            return this;
        }

        /**
         * Y diagonal (matrix 22). 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Y diagonal (matrix 22)."
        )
        public final Builder diagY(float diagY) {
            this.diagY = diagY;
            return this;
        }

        /**
         * Z diagonal (matrix 33). 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "Z diagonal (matrix 33)."
        )
        public final Builder diagZ(float diagZ) {
            this.diagZ = diagZ;
            return this;
        }

        /**
         * X off-diagonal (matrix 12 and 21). 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                description = "X off-diagonal (matrix 12 and 21)."
        )
        public final Builder offdiagX(float offdiagX) {
            this.offdiagX = offdiagX;
            return this;
        }

        /**
         * Y off-diagonal (matrix 13 and 31). 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                description = "Y off-diagonal (matrix 13 and 31)."
        )
        public final Builder offdiagY(float offdiagY) {
            this.offdiagY = offdiagY;
            return this;
        }

        /**
         * Z off-diagonal (matrix 32 and 23). 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 4,
                description = "Z off-diagonal (matrix 32 and 23)."
        )
        public final Builder offdiagZ(float offdiagZ) {
            this.offdiagZ = offdiagZ;
            return this;
        }

        /**
         * Confidence in orientation (higher is better). 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 4,
                extension = true,
                description = "Confidence in orientation (higher is better)."
        )
        public final Builder orientationConfidence(float orientationConfidence) {
            this.orientationConfidence = orientationConfidence;
            return this;
        }

        /**
         * orientation before calibration. 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 1,
                enumType = MavSensorOrientation.class,
                extension = true,
                description = "orientation before calibration."
        )
        public final Builder oldOrientation(EnumValue<MavSensorOrientation> oldOrientation) {
            this.oldOrientation = oldOrientation;
            return this;
        }

        /**
         * orientation before calibration. 
         */
        public final Builder oldOrientation(MavSensorOrientation entry) {
            return oldOrientation(EnumValue.of(entry));
        }

        /**
         * orientation before calibration. 
         */
        public final Builder oldOrientation(Enum... flags) {
            return oldOrientation(EnumValue.create(flags));
        }

        /**
         * orientation before calibration. 
         */
        public final Builder oldOrientation(Collection<Enum> flags) {
            return oldOrientation(EnumValue.create(flags));
        }

        /**
         * orientation after calibration. 
         */
        @MavlinkFieldInfo(
                position = 18,
                unitSize = 1,
                enumType = MavSensorOrientation.class,
                extension = true,
                description = "orientation after calibration."
        )
        public final Builder newOrientation(EnumValue<MavSensorOrientation> newOrientation) {
            this.newOrientation = newOrientation;
            return this;
        }

        /**
         * orientation after calibration. 
         */
        public final Builder newOrientation(MavSensorOrientation entry) {
            return newOrientation(EnumValue.of(entry));
        }

        /**
         * orientation after calibration. 
         */
        public final Builder newOrientation(Enum... flags) {
            return newOrientation(EnumValue.create(flags));
        }

        /**
         * orientation after calibration. 
         */
        public final Builder newOrientation(Collection<Enum> flags) {
            return newOrientation(EnumValue.create(flags));
        }

        /**
         * field radius correction factor 
         */
        @MavlinkFieldInfo(
                position = 19,
                unitSize = 4,
                extension = true,
                description = "field radius correction factor"
        )
        public final Builder scaleFactor(float scaleFactor) {
            this.scaleFactor = scaleFactor;
            return this;
        }

        public final MagCalReport build() {
            return new MagCalReport(compassId, calMask, calStatus, autosaved, fitness, ofsX, ofsY, ofsZ, diagX, diagY, diagZ, offdiagX, offdiagY, offdiagZ, orientationConfidence, oldOrientation, newOrientation, scaleFactor);
        }
    }
}
