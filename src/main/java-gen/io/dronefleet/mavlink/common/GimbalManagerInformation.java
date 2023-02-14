package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Deprecated;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Information about a high level gimbal manager. This message should be requested by a ground 
 * station using MAV_CMD_REQUEST_MESSAGE. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 280,
        crc = 70,
        description = "Information about a high level gimbal manager. This message should be requested by a ground station using MAV_CMD_REQUEST_MESSAGE.",
        workInProgress = true
)
@Deprecated
public final class GimbalManagerInformation {
    private final long timeBootMs;

    private final EnumValue<GimbalManagerCapFlags> capFlags;

    private final int gimbalDeviceId;

    private final float rollMin;

    private final float rollMax;

    private final float pitchMin;

    private final float pitchMax;

    private final float yawMin;

    private final float yawMax;

    private GimbalManagerInformation(long timeBootMs, EnumValue<GimbalManagerCapFlags> capFlags,
            int gimbalDeviceId, float rollMin, float rollMax, float pitchMin, float pitchMax,
            float yawMin, float yawMax) {
        this.timeBootMs = timeBootMs;
        this.capFlags = capFlags;
        this.gimbalDeviceId = gimbalDeviceId;
        this.rollMin = rollMin;
        this.rollMax = rollMax;
        this.pitchMin = pitchMin;
        this.pitchMax = pitchMax;
        this.yawMin = yawMin;
        this.yawMax = yawMax;
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
            position = 2,
            unitSize = 4,
            description = "Timestamp (time since system boot)."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Bitmap of gimbal capability flags. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            enumType = GimbalManagerCapFlags.class,
            description = "Bitmap of gimbal capability flags."
    )
    public final EnumValue<GimbalManagerCapFlags> capFlags() {
        return this.capFlags;
    }

    /**
     * Gimbal device ID that this gimbal manager is responsible for. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "Gimbal device ID that this gimbal manager is responsible for."
    )
    public final int gimbalDeviceId() {
        return this.gimbalDeviceId;
    }

    /**
     * Minimum hardware roll angle (positive: rolling to the right, negative: rolling to the left) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Minimum hardware roll angle (positive: rolling to the right, negative: rolling to the left)"
    )
    public final float rollMin() {
        return this.rollMin;
    }

    /**
     * Maximum hardware roll angle (positive: rolling to the right, negative: rolling to the left) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Maximum hardware roll angle (positive: rolling to the right, negative: rolling to the left)"
    )
    public final float rollMax() {
        return this.rollMax;
    }

    /**
     * Minimum pitch angle (positive: up, negative: down) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Minimum pitch angle (positive: up, negative: down)"
    )
    public final float pitchMin() {
        return this.pitchMin;
    }

    /**
     * Maximum pitch angle (positive: up, negative: down) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Maximum pitch angle (positive: up, negative: down)"
    )
    public final float pitchMax() {
        return this.pitchMax;
    }

    /**
     * Minimum yaw angle (positive: to the right, negative: to the left) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Minimum yaw angle (positive: to the right, negative: to the left)"
    )
    public final float yawMin() {
        return this.yawMin;
    }

    /**
     * Maximum yaw angle (positive: to the right, negative: to the left) 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Maximum yaw angle (positive: to the right, negative: to the left)"
    )
    public final float yawMax() {
        return this.yawMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GimbalManagerInformation other = (GimbalManagerInformation)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(capFlags, other.capFlags)) return false;
        if (!Objects.deepEquals(gimbalDeviceId, other.gimbalDeviceId)) return false;
        if (!Objects.deepEquals(rollMin, other.rollMin)) return false;
        if (!Objects.deepEquals(rollMax, other.rollMax)) return false;
        if (!Objects.deepEquals(pitchMin, other.pitchMin)) return false;
        if (!Objects.deepEquals(pitchMax, other.pitchMax)) return false;
        if (!Objects.deepEquals(yawMin, other.yawMin)) return false;
        if (!Objects.deepEquals(yawMax, other.yawMax)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(capFlags);
        result = 31 * result + Objects.hashCode(gimbalDeviceId);
        result = 31 * result + Objects.hashCode(rollMin);
        result = 31 * result + Objects.hashCode(rollMax);
        result = 31 * result + Objects.hashCode(pitchMin);
        result = 31 * result + Objects.hashCode(pitchMax);
        result = 31 * result + Objects.hashCode(yawMin);
        result = 31 * result + Objects.hashCode(yawMax);
        return result;
    }

    @Override
    public String toString() {
        return "GimbalManagerInformation{timeBootMs=" + timeBootMs
                 + ", capFlags=" + capFlags
                 + ", gimbalDeviceId=" + gimbalDeviceId
                 + ", rollMin=" + rollMin
                 + ", rollMax=" + rollMax
                 + ", pitchMin=" + pitchMin
                 + ", pitchMax=" + pitchMax
                 + ", yawMin=" + yawMin
                 + ", yawMax=" + yawMax + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private EnumValue<GimbalManagerCapFlags> capFlags;

        private int gimbalDeviceId;

        private float rollMin;

        private float rollMax;

        private float pitchMin;

        private float pitchMax;

        private float yawMin;

        private float yawMax;

        /**
         * Timestamp (time since system boot). 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Timestamp (time since system boot)."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Bitmap of gimbal capability flags. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                enumType = GimbalManagerCapFlags.class,
                description = "Bitmap of gimbal capability flags."
        )
        public final Builder capFlags(EnumValue<GimbalManagerCapFlags> capFlags) {
            this.capFlags = capFlags;
            return this;
        }

        /**
         * Bitmap of gimbal capability flags. 
         */
        public final Builder capFlags(GimbalManagerCapFlags entry) {
            return capFlags(EnumValue.of(entry));
        }

        /**
         * Bitmap of gimbal capability flags. 
         */
        public final Builder capFlags(Enum... flags) {
            return capFlags(EnumValue.create(flags));
        }

        /**
         * Bitmap of gimbal capability flags. 
         */
        public final Builder capFlags(Collection<Enum> flags) {
            return capFlags(EnumValue.create(flags));
        }

        /**
         * Gimbal device ID that this gimbal manager is responsible for. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "Gimbal device ID that this gimbal manager is responsible for."
        )
        public final Builder gimbalDeviceId(int gimbalDeviceId) {
            this.gimbalDeviceId = gimbalDeviceId;
            return this;
        }

        /**
         * Minimum hardware roll angle (positive: rolling to the right, negative: rolling to the left) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Minimum hardware roll angle (positive: rolling to the right, negative: rolling to the left)"
        )
        public final Builder rollMin(float rollMin) {
            this.rollMin = rollMin;
            return this;
        }

        /**
         * Maximum hardware roll angle (positive: rolling to the right, negative: rolling to the left) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Maximum hardware roll angle (positive: rolling to the right, negative: rolling to the left)"
        )
        public final Builder rollMax(float rollMax) {
            this.rollMax = rollMax;
            return this;
        }

        /**
         * Minimum pitch angle (positive: up, negative: down) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Minimum pitch angle (positive: up, negative: down)"
        )
        public final Builder pitchMin(float pitchMin) {
            this.pitchMin = pitchMin;
            return this;
        }

        /**
         * Maximum pitch angle (positive: up, negative: down) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Maximum pitch angle (positive: up, negative: down)"
        )
        public final Builder pitchMax(float pitchMax) {
            this.pitchMax = pitchMax;
            return this;
        }

        /**
         * Minimum yaw angle (positive: to the right, negative: to the left) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Minimum yaw angle (positive: to the right, negative: to the left)"
        )
        public final Builder yawMin(float yawMin) {
            this.yawMin = yawMin;
            return this;
        }

        /**
         * Maximum yaw angle (positive: to the right, negative: to the left) 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Maximum yaw angle (positive: to the right, negative: to the left)"
        )
        public final Builder yawMax(float yawMax) {
            this.yawMax = yawMax;
            return this;
        }

        public final GimbalManagerInformation build() {
            return new GimbalManagerInformation(timeBootMs, capFlags, gimbalDeviceId, rollMin, rollMax, pitchMin, pitchMax, yawMin, yawMax);
        }
    }
}
