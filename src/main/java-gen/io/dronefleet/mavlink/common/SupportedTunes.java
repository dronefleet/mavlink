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
 * Tune formats supported by vehicle. This should be emitted as response to 
 * MAV_CMD_REQUEST_MESSAGE. 
 */
@MavlinkMessageInfo(
        id = 401,
        crc = 183,
        description = "Tune formats supported by vehicle. This should be emitted as response to MAV_CMD_REQUEST_MESSAGE."
)
public final class SupportedTunes {
    private final int targetSystem;

    private final int targetComponent;

    private final EnumValue<TuneFormat> format;

    private SupportedTunes(int targetSystem, int targetComponent, EnumValue<TuneFormat> format) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.format = format;
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
            position = 1,
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
            position = 2,
            unitSize = 1,
            description = "Component ID"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Bitfield of supported tune formats. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            enumType = TuneFormat.class,
            description = "Bitfield of supported tune formats."
    )
    public final EnumValue<TuneFormat> format() {
        return this.format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SupportedTunes other = (SupportedTunes)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(format, other.format)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(format);
        return result;
    }

    @Override
    public String toString() {
        return "SupportedTunes{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", format=" + format + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private EnumValue<TuneFormat> format;

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 1,
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
                position = 2,
                unitSize = 1,
                description = "Component ID"
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Bitfield of supported tune formats. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                enumType = TuneFormat.class,
                description = "Bitfield of supported tune formats."
        )
        public final Builder format(EnumValue<TuneFormat> format) {
            this.format = format;
            return this;
        }

        /**
         * Bitfield of supported tune formats. 
         */
        public final Builder format(TuneFormat entry) {
            return format(EnumValue.of(entry));
        }

        /**
         * Bitfield of supported tune formats. 
         */
        public final Builder format(Enum... flags) {
            return format(EnumValue.create(flags));
        }

        /**
         * Bitfield of supported tune formats. 
         */
        public final Builder format(Collection<Enum> flags) {
            return format(EnumValue.create(flags));
        }

        public final SupportedTunes build() {
            return new SupportedTunes(targetSystem, targetComponent, format);
        }
    }
}
