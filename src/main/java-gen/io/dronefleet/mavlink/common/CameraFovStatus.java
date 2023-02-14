package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;

/**
 * Information about the field of view of a camera. Can be requested with a 
 * MAV_CMD_REQUEST_MESSAGE command. 
 */
@MavlinkMessageInfo(
        id = 271,
        crc = 22,
        description = "Information about the field of view of a camera. Can be requested with a MAV_CMD_REQUEST_MESSAGE command."
)
public final class CameraFovStatus {
    private final long timeBootMs;

    private final int latCamera;

    private final int lonCamera;

    private final int altCamera;

    private final int latImage;

    private final int lonImage;

    private final int altImage;

    private final List<Float> q;

    private final float hfov;

    private final float vfov;

    private CameraFovStatus(long timeBootMs, int latCamera, int lonCamera, int altCamera,
            int latImage, int lonImage, int altImage, List<Float> q, float hfov, float vfov) {
        this.timeBootMs = timeBootMs;
        this.latCamera = latCamera;
        this.lonCamera = lonCamera;
        this.altCamera = altCamera;
        this.latImage = latImage;
        this.lonImage = lonImage;
        this.altImage = altImage;
        this.q = q;
        this.hfov = hfov;
        this.vfov = vfov;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (time since system boot). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Timestamp (time since system boot)."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Latitude of camera (INT32_MAX if unknown). 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            signed = true,
            description = "Latitude of camera (INT32_MAX if unknown)."
    )
    public final int latCamera() {
        return this.latCamera;
    }

    /**
     * Longitude of camera (INT32_MAX if unknown). 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true,
            description = "Longitude of camera (INT32_MAX if unknown)."
    )
    public final int lonCamera() {
        return this.lonCamera;
    }

    /**
     * Altitude (MSL) of camera (INT32_MAX if unknown). 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true,
            description = "Altitude (MSL) of camera (INT32_MAX if unknown)."
    )
    public final int altCamera() {
        return this.altCamera;
    }

    /**
     * Latitude of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not intersecting 
     * with horizon). 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "Latitude of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not intersecting with horizon)."
    )
    public final int latImage() {
        return this.latImage;
    }

    /**
     * Longitude of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not 
     * intersecting with horizon). 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            signed = true,
            description = "Longitude of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not intersecting with horizon)."
    )
    public final int lonImage() {
        return this.lonImage;
    }

    /**
     * Altitude (MSL) of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not 
     * intersecting with horizon). 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            signed = true,
            description = "Altitude (MSL) of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not intersecting with horizon)."
    )
    public final int altImage() {
        return this.altImage;
    }

    /**
     * Quaternion of camera orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            arraySize = 4,
            description = "Quaternion of camera orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0)"
    )
    public final List<Float> q() {
        return this.q;
    }

    /**
     * Horizontal field of view (NaN if unknown). 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Horizontal field of view (NaN if unknown)."
    )
    public final float hfov() {
        return this.hfov;
    }

    /**
     * Vertical field of view (NaN if unknown). 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Vertical field of view (NaN if unknown)."
    )
    public final float vfov() {
        return this.vfov;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CameraFovStatus other = (CameraFovStatus)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(latCamera, other.latCamera)) return false;
        if (!Objects.deepEquals(lonCamera, other.lonCamera)) return false;
        if (!Objects.deepEquals(altCamera, other.altCamera)) return false;
        if (!Objects.deepEquals(latImage, other.latImage)) return false;
        if (!Objects.deepEquals(lonImage, other.lonImage)) return false;
        if (!Objects.deepEquals(altImage, other.altImage)) return false;
        if (!Objects.deepEquals(q, other.q)) return false;
        if (!Objects.deepEquals(hfov, other.hfov)) return false;
        if (!Objects.deepEquals(vfov, other.vfov)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(latCamera);
        result = 31 * result + Objects.hashCode(lonCamera);
        result = 31 * result + Objects.hashCode(altCamera);
        result = 31 * result + Objects.hashCode(latImage);
        result = 31 * result + Objects.hashCode(lonImage);
        result = 31 * result + Objects.hashCode(altImage);
        result = 31 * result + Objects.hashCode(q);
        result = 31 * result + Objects.hashCode(hfov);
        result = 31 * result + Objects.hashCode(vfov);
        return result;
    }

    @Override
    public String toString() {
        return "CameraFovStatus{timeBootMs=" + timeBootMs
                 + ", latCamera=" + latCamera
                 + ", lonCamera=" + lonCamera
                 + ", altCamera=" + altCamera
                 + ", latImage=" + latImage
                 + ", lonImage=" + lonImage
                 + ", altImage=" + altImage
                 + ", q=" + q
                 + ", hfov=" + hfov
                 + ", vfov=" + vfov + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private int latCamera;

        private int lonCamera;

        private int altCamera;

        private int latImage;

        private int lonImage;

        private int altImage;

        private List<Float> q;

        private float hfov;

        private float vfov;

        /**
         * Timestamp (time since system boot). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Timestamp (time since system boot)."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Latitude of camera (INT32_MAX if unknown). 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                signed = true,
                description = "Latitude of camera (INT32_MAX if unknown)."
        )
        public final Builder latCamera(int latCamera) {
            this.latCamera = latCamera;
            return this;
        }

        /**
         * Longitude of camera (INT32_MAX if unknown). 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true,
                description = "Longitude of camera (INT32_MAX if unknown)."
        )
        public final Builder lonCamera(int lonCamera) {
            this.lonCamera = lonCamera;
            return this;
        }

        /**
         * Altitude (MSL) of camera (INT32_MAX if unknown). 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true,
                description = "Altitude (MSL) of camera (INT32_MAX if unknown)."
        )
        public final Builder altCamera(int altCamera) {
            this.altCamera = altCamera;
            return this;
        }

        /**
         * Latitude of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not intersecting 
         * with horizon). 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "Latitude of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not intersecting with horizon)."
        )
        public final Builder latImage(int latImage) {
            this.latImage = latImage;
            return this;
        }

        /**
         * Longitude of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not 
         * intersecting with horizon). 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                signed = true,
                description = "Longitude of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not intersecting with horizon)."
        )
        public final Builder lonImage(int lonImage) {
            this.lonImage = lonImage;
            return this;
        }

        /**
         * Altitude (MSL) of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not 
         * intersecting with horizon). 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                signed = true,
                description = "Altitude (MSL) of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not intersecting with horizon)."
        )
        public final Builder altImage(int altImage) {
            this.altImage = altImage;
            return this;
        }

        /**
         * Quaternion of camera orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                arraySize = 4,
                description = "Quaternion of camera orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0)"
        )
        public final Builder q(List<Float> q) {
            this.q = q;
            return this;
        }

        /**
         * Horizontal field of view (NaN if unknown). 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Horizontal field of view (NaN if unknown)."
        )
        public final Builder hfov(float hfov) {
            this.hfov = hfov;
            return this;
        }

        /**
         * Vertical field of view (NaN if unknown). 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Vertical field of view (NaN if unknown)."
        )
        public final Builder vfov(float vfov) {
            this.vfov = vfov;
            return this;
        }

        public final CameraFovStatus build() {
            return new CameraFovStatus(timeBootMs, latCamera, lonCamera, altCamera, latImage, lonImage, altImage, q, hfov, vfov);
        }
    }
}
