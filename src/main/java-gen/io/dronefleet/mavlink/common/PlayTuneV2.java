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
 * Play vehicle tone/tune (buzzer). Supersedes message {@link io.dronefleet.mavlink.common.PlayTune PLAY_TUNE}. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 400,
        crc = 110,
        description = "Play vehicle tone/tune (buzzer). Supersedes message PLAY_TUNE.",
        workInProgress = true
)
@Deprecated
public final class PlayTuneV2 {
    private final int targetSystem;

    private final int targetComponent;

    private final EnumValue<TuneFormat> format;

    private final String tune;

    private PlayTuneV2(int targetSystem, int targetComponent, EnumValue<TuneFormat> format,
            String tune) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.format = format;
        this.tune = tune;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "System ID"
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Component ID"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Tune format 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            enumType = TuneFormat.class,
            description = "Tune format"
    )
    public final EnumValue<TuneFormat> format() {
        return this.format;
    }

    /**
     * Tune definition as a NULL-terminated string. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            arraySize = 248,
            description = "Tune definition as a NULL-terminated string."
    )
    public final String tune() {
        return this.tune;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        PlayTuneV2 other = (PlayTuneV2)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(format, other.format)) return false;
        if (!Objects.deepEquals(tune, other.tune)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(format);
        result = 31 * result + Objects.hashCode(tune);
        return result;
    }

    @Override
    public String toString() {
        return "PlayTuneV2{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", format=" + format
                 + ", tune=" + tune + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private EnumValue<TuneFormat> format;

        private String tune;

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "System ID"
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Component ID"
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Tune format 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                enumType = TuneFormat.class,
                description = "Tune format"
        )
        public final Builder format(EnumValue<TuneFormat> format) {
            this.format = format;
            return this;
        }

        /**
         * Tune format 
         */
        public final Builder format(TuneFormat entry) {
            return format(EnumValue.of(entry));
        }

        /**
         * Tune format 
         */
        public final Builder format(Enum... flags) {
            return format(EnumValue.create(flags));
        }

        /**
         * Tune format 
         */
        public final Builder format(Collection<Enum> flags) {
            return format(EnumValue.create(flags));
        }

        /**
         * Tune definition as a NULL-terminated string. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                arraySize = 248,
                description = "Tune definition as a NULL-terminated string."
        )
        public final Builder tune(String tune) {
            this.tune = tune;
            return this;
        }

        public final PlayTuneV2 build() {
            return new PlayTuneV2(targetSystem, targetComponent, format, tune);
        }
    }
}
