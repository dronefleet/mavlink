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
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

/**
 * Information about a low level gimbal. This message should be requested by the gimbal manager or 
 * a ground station using MAV_CMD_REQUEST_MESSAGE. The maximum angles and rates are the limits 
 * by hardware. However, the limits by software used are likely different/smaller and dependent 
 * on mode/settings/etc.. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 283,
        crc = 74,
        description = "Information about a low level gimbal. This message should be requested by the gimbal manager or a ground station using MAV_CMD_REQUEST_MESSAGE. The maximum angles and rates are the limits by hardware. However, the limits by software used are likely different/smaller and dependent on mode/settings/etc..",
        workInProgress = true
)
@Deprecated
public final class GimbalDeviceInformation {
    private final long timeBootMs;

    private final String vendorName;

    private final String modelName;

    private final String customName;

    private final long firmwareVersion;

    private final long hardwareVersion;

    private final BigInteger uid;

    private final EnumValue<GimbalDeviceCapFlags> capFlags;

    private final int customCapFlags;

    private final float rollMin;

    private final float rollMax;

    private final float pitchMin;

    private final float pitchMax;

    private final float yawMin;

    private final float yawMax;

    private GimbalDeviceInformation(long timeBootMs, String vendorName, String modelName,
            String customName, long firmwareVersion, long hardwareVersion, BigInteger uid,
            EnumValue<GimbalDeviceCapFlags> capFlags, int customCapFlags, float rollMin,
            float rollMax, float pitchMin, float pitchMax, float yawMin, float yawMax) {
        this.timeBootMs = timeBootMs;
        this.vendorName = vendorName;
        this.modelName = modelName;
        this.customName = customName;
        this.firmwareVersion = firmwareVersion;
        this.hardwareVersion = hardwareVersion;
        this.uid = uid;
        this.capFlags = capFlags;
        this.customCapFlags = customCapFlags;
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
     * Name of the gimbal vendor. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 32,
            description = "Name of the gimbal vendor."
    )
    public final String vendorName() {
        return this.vendorName;
    }

    /**
     * Name of the gimbal model. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            arraySize = 32,
            description = "Name of the gimbal model."
    )
    public final String modelName() {
        return this.modelName;
    }

    /**
     * Custom name of the gimbal given to it by the user. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            arraySize = 32,
            description = "Custom name of the gimbal given to it by the user."
    )
    public final String customName() {
        return this.customName;
    }

    /**
     * Version of the gimbal firmware, encoded as: (Dev &amp; 0xff) &lt;&lt; 24 | (Patch &amp; 0xff) &lt;&lt; 16 | (Minor &amp; 
     * 0xff) &lt;&lt; 8 | (Major &amp; 0xff). 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Version of the gimbal firmware, encoded as: (Dev & 0xff) << 24 | (Patch & 0xff) << 16 | (Minor & 0xff) << 8 | (Major & 0xff)."
    )
    public final long firmwareVersion() {
        return this.firmwareVersion;
    }

    /**
     * Version of the gimbal hardware, encoded as: (Dev &amp; 0xff) &lt;&lt; 24 | (Patch &amp; 0xff) &lt;&lt; 16 | (Minor &amp; 
     * 0xff) &lt;&lt; 8 | (Major &amp; 0xff). 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Version of the gimbal hardware, encoded as: (Dev & 0xff) << 24 | (Patch & 0xff) << 16 | (Minor & 0xff) << 8 | (Major & 0xff)."
    )
    public final long hardwareVersion() {
        return this.hardwareVersion;
    }

    /**
     * UID of gimbal hardware (0 if unknown). 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 8,
            description = "UID of gimbal hardware (0 if unknown)."
    )
    public final BigInteger uid() {
        return this.uid;
    }

    /**
     * Bitmap of gimbal capability flags. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            enumType = GimbalDeviceCapFlags.class,
            description = "Bitmap of gimbal capability flags."
    )
    public final EnumValue<GimbalDeviceCapFlags> capFlags() {
        return this.capFlags;
    }

    /**
     * Bitmap for use for gimbal-specific capability flags. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2,
            description = "Bitmap for use for gimbal-specific capability flags."
    )
    public final int customCapFlags() {
        return this.customCapFlags;
    }

    /**
     * Minimum hardware roll angle (positive: rolling to the right, negative: rolling to the left). 
     * NAN if unknown. 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "Minimum hardware roll angle (positive: rolling to the right, negative: rolling to the left). NAN if unknown."
    )
    public final float rollMin() {
        return this.rollMin;
    }

    /**
     * Maximum hardware roll angle (positive: rolling to the right, negative: rolling to the left). 
     * NAN if unknown. 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            description = "Maximum hardware roll angle (positive: rolling to the right, negative: rolling to the left). NAN if unknown."
    )
    public final float rollMax() {
        return this.rollMax;
    }

    /**
     * Minimum hardware pitch angle (positive: up, negative: down). NAN if unknown. 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            description = "Minimum hardware pitch angle (positive: up, negative: down). NAN if unknown."
    )
    public final float pitchMin() {
        return this.pitchMin;
    }

    /**
     * Maximum hardware pitch angle (positive: up, negative: down). NAN if unknown. 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4,
            description = "Maximum hardware pitch angle (positive: up, negative: down). NAN if unknown."
    )
    public final float pitchMax() {
        return this.pitchMax;
    }

    /**
     * Minimum hardware yaw angle (positive: to the right, negative: to the left). NAN if unknown. 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 4,
            description = "Minimum hardware yaw angle (positive: to the right, negative: to the left). NAN if unknown."
    )
    public final float yawMin() {
        return this.yawMin;
    }

    /**
     * Maximum hardware yaw angle (positive: to the right, negative: to the left). NAN if unknown. 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 4,
            description = "Maximum hardware yaw angle (positive: to the right, negative: to the left). NAN if unknown."
    )
    public final float yawMax() {
        return this.yawMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GimbalDeviceInformation other = (GimbalDeviceInformation)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(vendorName, other.vendorName)) return false;
        if (!Objects.deepEquals(modelName, other.modelName)) return false;
        if (!Objects.deepEquals(customName, other.customName)) return false;
        if (!Objects.deepEquals(firmwareVersion, other.firmwareVersion)) return false;
        if (!Objects.deepEquals(hardwareVersion, other.hardwareVersion)) return false;
        if (!Objects.deepEquals(uid, other.uid)) return false;
        if (!Objects.deepEquals(capFlags, other.capFlags)) return false;
        if (!Objects.deepEquals(customCapFlags, other.customCapFlags)) return false;
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
        result = 31 * result + Objects.hashCode(vendorName);
        result = 31 * result + Objects.hashCode(modelName);
        result = 31 * result + Objects.hashCode(customName);
        result = 31 * result + Objects.hashCode(firmwareVersion);
        result = 31 * result + Objects.hashCode(hardwareVersion);
        result = 31 * result + Objects.hashCode(uid);
        result = 31 * result + Objects.hashCode(capFlags);
        result = 31 * result + Objects.hashCode(customCapFlags);
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
        return "GimbalDeviceInformation{timeBootMs=" + timeBootMs
                 + ", vendorName=" + vendorName
                 + ", modelName=" + modelName
                 + ", customName=" + customName
                 + ", firmwareVersion=" + firmwareVersion
                 + ", hardwareVersion=" + hardwareVersion
                 + ", uid=" + uid
                 + ", capFlags=" + capFlags
                 + ", customCapFlags=" + customCapFlags
                 + ", rollMin=" + rollMin
                 + ", rollMax=" + rollMax
                 + ", pitchMin=" + pitchMin
                 + ", pitchMax=" + pitchMax
                 + ", yawMin=" + yawMin
                 + ", yawMax=" + yawMax + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private String vendorName;

        private String modelName;

        private String customName;

        private long firmwareVersion;

        private long hardwareVersion;

        private BigInteger uid;

        private EnumValue<GimbalDeviceCapFlags> capFlags;

        private int customCapFlags;

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
         * Name of the gimbal vendor. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 32,
                description = "Name of the gimbal vendor."
        )
        public final Builder vendorName(String vendorName) {
            this.vendorName = vendorName;
            return this;
        }

        /**
         * Name of the gimbal model. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                arraySize = 32,
                description = "Name of the gimbal model."
        )
        public final Builder modelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        /**
         * Custom name of the gimbal given to it by the user. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                arraySize = 32,
                description = "Custom name of the gimbal given to it by the user."
        )
        public final Builder customName(String customName) {
            this.customName = customName;
            return this;
        }

        /**
         * Version of the gimbal firmware, encoded as: (Dev &amp; 0xff) &lt;&lt; 24 | (Patch &amp; 0xff) &lt;&lt; 16 | (Minor &amp; 
         * 0xff) &lt;&lt; 8 | (Major &amp; 0xff). 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Version of the gimbal firmware, encoded as: (Dev & 0xff) << 24 | (Patch & 0xff) << 16 | (Minor & 0xff) << 8 | (Major & 0xff)."
        )
        public final Builder firmwareVersion(long firmwareVersion) {
            this.firmwareVersion = firmwareVersion;
            return this;
        }

        /**
         * Version of the gimbal hardware, encoded as: (Dev &amp; 0xff) &lt;&lt; 24 | (Patch &amp; 0xff) &lt;&lt; 16 | (Minor &amp; 
         * 0xff) &lt;&lt; 8 | (Major &amp; 0xff). 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Version of the gimbal hardware, encoded as: (Dev & 0xff) << 24 | (Patch & 0xff) << 16 | (Minor & 0xff) << 8 | (Major & 0xff)."
        )
        public final Builder hardwareVersion(long hardwareVersion) {
            this.hardwareVersion = hardwareVersion;
            return this;
        }

        /**
         * UID of gimbal hardware (0 if unknown). 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 8,
                description = "UID of gimbal hardware (0 if unknown)."
        )
        public final Builder uid(BigInteger uid) {
            this.uid = uid;
            return this;
        }

        /**
         * Bitmap of gimbal capability flags. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                enumType = GimbalDeviceCapFlags.class,
                description = "Bitmap of gimbal capability flags."
        )
        public final Builder capFlags(EnumValue<GimbalDeviceCapFlags> capFlags) {
            this.capFlags = capFlags;
            return this;
        }

        /**
         * Bitmap of gimbal capability flags. 
         */
        public final Builder capFlags(GimbalDeviceCapFlags entry) {
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
         * Bitmap for use for gimbal-specific capability flags. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 2,
                description = "Bitmap for use for gimbal-specific capability flags."
        )
        public final Builder customCapFlags(int customCapFlags) {
            this.customCapFlags = customCapFlags;
            return this;
        }

        /**
         * Minimum hardware roll angle (positive: rolling to the right, negative: rolling to the left). 
         * NAN if unknown. 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "Minimum hardware roll angle (positive: rolling to the right, negative: rolling to the left). NAN if unknown."
        )
        public final Builder rollMin(float rollMin) {
            this.rollMin = rollMin;
            return this;
        }

        /**
         * Maximum hardware roll angle (positive: rolling to the right, negative: rolling to the left). 
         * NAN if unknown. 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                description = "Maximum hardware roll angle (positive: rolling to the right, negative: rolling to the left). NAN if unknown."
        )
        public final Builder rollMax(float rollMax) {
            this.rollMax = rollMax;
            return this;
        }

        /**
         * Minimum hardware pitch angle (positive: up, negative: down). NAN if unknown. 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                description = "Minimum hardware pitch angle (positive: up, negative: down). NAN if unknown."
        )
        public final Builder pitchMin(float pitchMin) {
            this.pitchMin = pitchMin;
            return this;
        }

        /**
         * Maximum hardware pitch angle (positive: up, negative: down). NAN if unknown. 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 4,
                description = "Maximum hardware pitch angle (positive: up, negative: down). NAN if unknown."
        )
        public final Builder pitchMax(float pitchMax) {
            this.pitchMax = pitchMax;
            return this;
        }

        /**
         * Minimum hardware yaw angle (positive: to the right, negative: to the left). NAN if unknown. 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 4,
                description = "Minimum hardware yaw angle (positive: to the right, negative: to the left). NAN if unknown."
        )
        public final Builder yawMin(float yawMin) {
            this.yawMin = yawMin;
            return this;
        }

        /**
         * Maximum hardware yaw angle (positive: to the right, negative: to the left). NAN if unknown. 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 4,
                description = "Maximum hardware yaw angle (positive: to the right, negative: to the left). NAN if unknown."
        )
        public final Builder yawMax(float yawMax) {
            this.yawMax = yawMax;
            return this;
        }

        public final GimbalDeviceInformation build() {
            return new GimbalDeviceInformation(timeBootMs, vendorName, modelName, customName, firmwareVersion, hardwareVersion, uid, capFlags, customCapFlags, rollMin, rollMax, pitchMin, pitchMax, yawMin, yawMax);
        }
    }
}
