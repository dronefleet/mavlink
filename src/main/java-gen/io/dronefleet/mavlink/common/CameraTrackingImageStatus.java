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
 * Camera tracking status, sent while in active tracking. Use MAV_CMD_SET_MESSAGE_INTERVAL to 
 * define message interval. 
 */
@MavlinkMessageInfo(
        id = 275,
        crc = 126,
        description = "Camera tracking status, sent while in active tracking. Use MAV_CMD_SET_MESSAGE_INTERVAL to define message interval."
)
public final class CameraTrackingImageStatus {
    private final EnumValue<CameraTrackingStatusFlags> trackingStatus;

    private final EnumValue<CameraTrackingMode> trackingMode;

    private final EnumValue<CameraTrackingTargetData> targetData;

    private final float pointX;

    private final float pointY;

    private final float radius;

    private final float recTopX;

    private final float recTopY;

    private final float recBottomX;

    private final float recBottomY;

    private CameraTrackingImageStatus(EnumValue<CameraTrackingStatusFlags> trackingStatus,
            EnumValue<CameraTrackingMode> trackingMode,
            EnumValue<CameraTrackingTargetData> targetData, float pointX, float pointY,
            float radius, float recTopX, float recTopY, float recBottomX, float recBottomY) {
        this.trackingStatus = trackingStatus;
        this.trackingMode = trackingMode;
        this.targetData = targetData;
        this.pointX = pointX;
        this.pointY = pointY;
        this.radius = radius;
        this.recTopX = recTopX;
        this.recTopY = recTopY;
        this.recBottomX = recBottomX;
        this.recBottomY = recBottomY;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Current tracking status 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            enumType = CameraTrackingStatusFlags.class,
            description = "Current tracking status"
    )
    public final EnumValue<CameraTrackingStatusFlags> trackingStatus() {
        return this.trackingStatus;
    }

    /**
     * Current tracking mode 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = CameraTrackingMode.class,
            description = "Current tracking mode"
    )
    public final EnumValue<CameraTrackingMode> trackingMode() {
        return this.trackingMode;
    }

    /**
     * Defines location of target data 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = CameraTrackingTargetData.class,
            description = "Defines location of target data"
    )
    public final EnumValue<CameraTrackingTargetData> targetData() {
        return this.targetData;
    }

    /**
     * Current tracked point x value if CAMERA_TRACKING_MODE_POINT (normalized 0..1, 0 is left, 1 is 
     * right), NAN if unknown 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Current tracked point x value if CAMERA_TRACKING_MODE_POINT (normalized 0..1, 0 is left, 1 is right), NAN if unknown"
    )
    public final float pointX() {
        return this.pointX;
    }

    /**
     * Current tracked point y value if CAMERA_TRACKING_MODE_POINT (normalized 0..1, 0 is top, 1 is 
     * bottom), NAN if unknown 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Current tracked point y value if CAMERA_TRACKING_MODE_POINT (normalized 0..1, 0 is top, 1 is bottom), NAN if unknown"
    )
    public final float pointY() {
        return this.pointY;
    }

    /**
     * Current tracked radius if CAMERA_TRACKING_MODE_POINT (normalized 0..1, 0 is image left, 1 is 
     * image right), NAN if unknown 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Current tracked radius if CAMERA_TRACKING_MODE_POINT (normalized 0..1, 0 is image left, 1 is image right), NAN if unknown"
    )
    public final float radius() {
        return this.radius;
    }

    /**
     * Current tracked rectangle top x value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 0..1, 
     * 0 is left, 1 is right), NAN if unknown 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Current tracked rectangle top x value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 0..1, 0 is left, 1 is right), NAN if unknown"
    )
    public final float recTopX() {
        return this.recTopX;
    }

    /**
     * Current tracked rectangle top y value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 0..1, 
     * 0 is top, 1 is bottom), NAN if unknown 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Current tracked rectangle top y value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 0..1, 0 is top, 1 is bottom), NAN if unknown"
    )
    public final float recTopY() {
        return this.recTopY;
    }

    /**
     * Current tracked rectangle bottom x value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 
     * 0..1, 0 is left, 1 is right), NAN if unknown 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Current tracked rectangle bottom x value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 0..1, 0 is left, 1 is right), NAN if unknown"
    )
    public final float recBottomX() {
        return this.recBottomX;
    }

    /**
     * Current tracked rectangle bottom y value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 
     * 0..1, 0 is top, 1 is bottom), NAN if unknown 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Current tracked rectangle bottom y value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 0..1, 0 is top, 1 is bottom), NAN if unknown"
    )
    public final float recBottomY() {
        return this.recBottomY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CameraTrackingImageStatus other = (CameraTrackingImageStatus)o;
        if (!Objects.deepEquals(trackingStatus, other.trackingStatus)) return false;
        if (!Objects.deepEquals(trackingMode, other.trackingMode)) return false;
        if (!Objects.deepEquals(targetData, other.targetData)) return false;
        if (!Objects.deepEquals(pointX, other.pointX)) return false;
        if (!Objects.deepEquals(pointY, other.pointY)) return false;
        if (!Objects.deepEquals(radius, other.radius)) return false;
        if (!Objects.deepEquals(recTopX, other.recTopX)) return false;
        if (!Objects.deepEquals(recTopY, other.recTopY)) return false;
        if (!Objects.deepEquals(recBottomX, other.recBottomX)) return false;
        if (!Objects.deepEquals(recBottomY, other.recBottomY)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(trackingStatus);
        result = 31 * result + Objects.hashCode(trackingMode);
        result = 31 * result + Objects.hashCode(targetData);
        result = 31 * result + Objects.hashCode(pointX);
        result = 31 * result + Objects.hashCode(pointY);
        result = 31 * result + Objects.hashCode(radius);
        result = 31 * result + Objects.hashCode(recTopX);
        result = 31 * result + Objects.hashCode(recTopY);
        result = 31 * result + Objects.hashCode(recBottomX);
        result = 31 * result + Objects.hashCode(recBottomY);
        return result;
    }

    @Override
    public String toString() {
        return "CameraTrackingImageStatus{trackingStatus=" + trackingStatus
                 + ", trackingMode=" + trackingMode
                 + ", targetData=" + targetData
                 + ", pointX=" + pointX
                 + ", pointY=" + pointY
                 + ", radius=" + radius
                 + ", recTopX=" + recTopX
                 + ", recTopY=" + recTopY
                 + ", recBottomX=" + recBottomX
                 + ", recBottomY=" + recBottomY + "}";
    }

    public static final class Builder {
        private EnumValue<CameraTrackingStatusFlags> trackingStatus;

        private EnumValue<CameraTrackingMode> trackingMode;

        private EnumValue<CameraTrackingTargetData> targetData;

        private float pointX;

        private float pointY;

        private float radius;

        private float recTopX;

        private float recTopY;

        private float recBottomX;

        private float recBottomY;

        /**
         * Current tracking status 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                enumType = CameraTrackingStatusFlags.class,
                description = "Current tracking status"
        )
        public final Builder trackingStatus(EnumValue<CameraTrackingStatusFlags> trackingStatus) {
            this.trackingStatus = trackingStatus;
            return this;
        }

        /**
         * Current tracking status 
         */
        public final Builder trackingStatus(CameraTrackingStatusFlags entry) {
            return trackingStatus(EnumValue.of(entry));
        }

        /**
         * Current tracking status 
         */
        public final Builder trackingStatus(Enum... flags) {
            return trackingStatus(EnumValue.create(flags));
        }

        /**
         * Current tracking status 
         */
        public final Builder trackingStatus(Collection<Enum> flags) {
            return trackingStatus(EnumValue.create(flags));
        }

        /**
         * Current tracking mode 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = CameraTrackingMode.class,
                description = "Current tracking mode"
        )
        public final Builder trackingMode(EnumValue<CameraTrackingMode> trackingMode) {
            this.trackingMode = trackingMode;
            return this;
        }

        /**
         * Current tracking mode 
         */
        public final Builder trackingMode(CameraTrackingMode entry) {
            return trackingMode(EnumValue.of(entry));
        }

        /**
         * Current tracking mode 
         */
        public final Builder trackingMode(Enum... flags) {
            return trackingMode(EnumValue.create(flags));
        }

        /**
         * Current tracking mode 
         */
        public final Builder trackingMode(Collection<Enum> flags) {
            return trackingMode(EnumValue.create(flags));
        }

        /**
         * Defines location of target data 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = CameraTrackingTargetData.class,
                description = "Defines location of target data"
        )
        public final Builder targetData(EnumValue<CameraTrackingTargetData> targetData) {
            this.targetData = targetData;
            return this;
        }

        /**
         * Defines location of target data 
         */
        public final Builder targetData(CameraTrackingTargetData entry) {
            return targetData(EnumValue.of(entry));
        }

        /**
         * Defines location of target data 
         */
        public final Builder targetData(Enum... flags) {
            return targetData(EnumValue.create(flags));
        }

        /**
         * Defines location of target data 
         */
        public final Builder targetData(Collection<Enum> flags) {
            return targetData(EnumValue.create(flags));
        }

        /**
         * Current tracked point x value if CAMERA_TRACKING_MODE_POINT (normalized 0..1, 0 is left, 1 is 
         * right), NAN if unknown 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Current tracked point x value if CAMERA_TRACKING_MODE_POINT (normalized 0..1, 0 is left, 1 is right), NAN if unknown"
        )
        public final Builder pointX(float pointX) {
            this.pointX = pointX;
            return this;
        }

        /**
         * Current tracked point y value if CAMERA_TRACKING_MODE_POINT (normalized 0..1, 0 is top, 1 is 
         * bottom), NAN if unknown 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Current tracked point y value if CAMERA_TRACKING_MODE_POINT (normalized 0..1, 0 is top, 1 is bottom), NAN if unknown"
        )
        public final Builder pointY(float pointY) {
            this.pointY = pointY;
            return this;
        }

        /**
         * Current tracked radius if CAMERA_TRACKING_MODE_POINT (normalized 0..1, 0 is image left, 1 is 
         * image right), NAN if unknown 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Current tracked radius if CAMERA_TRACKING_MODE_POINT (normalized 0..1, 0 is image left, 1 is image right), NAN if unknown"
        )
        public final Builder radius(float radius) {
            this.radius = radius;
            return this;
        }

        /**
         * Current tracked rectangle top x value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 0..1, 
         * 0 is left, 1 is right), NAN if unknown 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Current tracked rectangle top x value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 0..1, 0 is left, 1 is right), NAN if unknown"
        )
        public final Builder recTopX(float recTopX) {
            this.recTopX = recTopX;
            return this;
        }

        /**
         * Current tracked rectangle top y value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 0..1, 
         * 0 is top, 1 is bottom), NAN if unknown 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Current tracked rectangle top y value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 0..1, 0 is top, 1 is bottom), NAN if unknown"
        )
        public final Builder recTopY(float recTopY) {
            this.recTopY = recTopY;
            return this;
        }

        /**
         * Current tracked rectangle bottom x value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 
         * 0..1, 0 is left, 1 is right), NAN if unknown 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Current tracked rectangle bottom x value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 0..1, 0 is left, 1 is right), NAN if unknown"
        )
        public final Builder recBottomX(float recBottomX) {
            this.recBottomX = recBottomX;
            return this;
        }

        /**
         * Current tracked rectangle bottom y value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 
         * 0..1, 0 is top, 1 is bottom), NAN if unknown 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Current tracked rectangle bottom y value if CAMERA_TRACKING_MODE_RECTANGLE (normalized 0..1, 0 is top, 1 is bottom), NAN if unknown"
        )
        public final Builder recBottomY(float recBottomY) {
            this.recBottomY = recBottomY;
            return this;
        }

        public final CameraTrackingImageStatus build() {
            return new CameraTrackingImageStatus(trackingStatus, trackingMode, targetData, pointX, pointY, radius, recTopX, recTopY, recBottomX, recBottomY);
        }
    }
}
