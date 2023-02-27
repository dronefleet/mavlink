package io.dronefleet.mavlink.storm32;

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
 * Information about the shot operation. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 60020,
        crc = 202,
        description = "Information about the shot operation.",
        workInProgress = true
)
@Deprecated
public final class QshotStatus {
    private final EnumValue<MavQshotMode> mode;

    private final int shotState;

    private QshotStatus(EnumValue<MavQshotMode> mode, int shotState) {
        this.mode = mode;
        this.shotState = shotState;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Current shot mode. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            enumType = MavQshotMode.class,
            description = "Current shot mode."
    )
    public final EnumValue<MavQshotMode> mode() {
        return this.mode;
    }

    /**
     * Current state in the shot. States are specific to the selected shot mode. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "Current state in the shot. States are specific to the selected shot mode."
    )
    public final int shotState() {
        return this.shotState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        QshotStatus other = (QshotStatus)o;
        if (!Objects.deepEquals(mode, other.mode)) return false;
        if (!Objects.deepEquals(shotState, other.shotState)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(mode);
        result = 31 * result + Objects.hashCode(shotState);
        return result;
    }

    @Override
    public String toString() {
        return "QshotStatus{mode=" + mode
                 + ", shotState=" + shotState + "}";
    }

    public static final class Builder {
        private EnumValue<MavQshotMode> mode;

        private int shotState;

        /**
         * Current shot mode. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                enumType = MavQshotMode.class,
                description = "Current shot mode."
        )
        public final Builder mode(EnumValue<MavQshotMode> mode) {
            this.mode = mode;
            return this;
        }

        /**
         * Current shot mode. 
         */
        public final Builder mode(MavQshotMode entry) {
            return mode(EnumValue.of(entry));
        }

        /**
         * Current shot mode. 
         */
        public final Builder mode(Enum... flags) {
            return mode(EnumValue.create(flags));
        }

        /**
         * Current shot mode. 
         */
        public final Builder mode(Collection<Enum> flags) {
            return mode(EnumValue.create(flags));
        }

        /**
         * Current state in the shot. States are specific to the selected shot mode. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "Current state in the shot. States are specific to the selected shot mode."
        )
        public final Builder shotState(int shotState) {
            this.shotState = shotState;
            return this;
        }

        public final QshotStatus build() {
            return new QshotStatus(mode, shotState);
        }
    }
}
