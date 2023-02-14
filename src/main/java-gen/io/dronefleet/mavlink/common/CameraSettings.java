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
 * Settings of a camera. Can be requested with a MAV_CMD_REQUEST_MESSAGE command. 
 */
@MavlinkMessageInfo(
        id = 260,
        crc = 146,
        description = "Settings of a camera. Can be requested with a MAV_CMD_REQUEST_MESSAGE command."
)
public final class CameraSettings {
    private final long timeBootMs;

    private final EnumValue<CameraMode> modeId;

    private final float zoomlevel;

    private final float focuslevel;

    private CameraSettings(long timeBootMs, EnumValue<CameraMode> modeId, float zoomlevel,
            float focuslevel) {
        this.timeBootMs = timeBootMs;
        this.modeId = modeId;
        this.zoomlevel = zoomlevel;
        this.focuslevel = focuslevel;
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
     * Camera mode 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = CameraMode.class,
            description = "Camera mode"
    )
    public final EnumValue<CameraMode> modeId() {
        return this.modeId;
    }

    /**
     * Current zoom level as a percentage of the full range (0.0 to 100.0, NaN if not known) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            extension = true,
            description = "Current zoom level as a percentage of the full range (0.0 to 100.0, NaN if not known)"
    )
    public final float zoomlevel() {
        return this.zoomlevel;
    }

    /**
     * Current focus level as a percentage of the full range (0.0 to 100.0, NaN if not known) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            extension = true,
            description = "Current focus level as a percentage of the full range (0.0 to 100.0, NaN if not known)"
    )
    public final float focuslevel() {
        return this.focuslevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CameraSettings other = (CameraSettings)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(modeId, other.modeId)) return false;
        if (!Objects.deepEquals(zoomlevel, other.zoomlevel)) return false;
        if (!Objects.deepEquals(focuslevel, other.focuslevel)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(modeId);
        result = 31 * result + Objects.hashCode(zoomlevel);
        result = 31 * result + Objects.hashCode(focuslevel);
        return result;
    }

    @Override
    public String toString() {
        return "CameraSettings{timeBootMs=" + timeBootMs
                 + ", modeId=" + modeId
                 + ", zoomlevel=" + zoomlevel
                 + ", focuslevel=" + focuslevel + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private EnumValue<CameraMode> modeId;

        private float zoomlevel;

        private float focuslevel;

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
         * Camera mode 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = CameraMode.class,
                description = "Camera mode"
        )
        public final Builder modeId(EnumValue<CameraMode> modeId) {
            this.modeId = modeId;
            return this;
        }

        /**
         * Camera mode 
         */
        public final Builder modeId(CameraMode entry) {
            return modeId(EnumValue.of(entry));
        }

        /**
         * Camera mode 
         */
        public final Builder modeId(Enum... flags) {
            return modeId(EnumValue.create(flags));
        }

        /**
         * Camera mode 
         */
        public final Builder modeId(Collection<Enum> flags) {
            return modeId(EnumValue.create(flags));
        }

        /**
         * Current zoom level as a percentage of the full range (0.0 to 100.0, NaN if not known) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                extension = true,
                description = "Current zoom level as a percentage of the full range (0.0 to 100.0, NaN if not known)"
        )
        public final Builder zoomlevel(float zoomlevel) {
            this.zoomlevel = zoomlevel;
            return this;
        }

        /**
         * Current focus level as a percentage of the full range (0.0 to 100.0, NaN if not known) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                extension = true,
                description = "Current focus level as a percentage of the full range (0.0 to 100.0, NaN if not known)"
        )
        public final Builder focuslevel(float focuslevel) {
            this.focuslevel = focuslevel;
            return this;
        }

        public final CameraSettings build() {
            return new CameraSettings(timeBootMs, modeId, zoomlevel, focuslevel);
        }
    }
}
