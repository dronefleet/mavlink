package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Status text message. These messages are printed in yellow in the COMM console of 
 * QGroundControl. WARNING: They consume quite some bandwidth, so use only for important status 
 * and error messages. If implemented wisely, these messages are buffered on the MCU and sent only 
 * at a limited rate (e.g. 10 Hz). 
 */
@MavlinkMessageInfo(
        id = 253,
        crc = 83
)
public final class Statustext {
    private final EnumValue<MavSeverity> severity;

    private final String text;

    private Statustext(EnumValue<MavSeverity> severity, String text) {
        this.severity = severity;
        this.text = text;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Severity of status. Relies on the definitions within RFC-5424. See enum {@link io.dronefleet.mavlink.common.MavSeverity MAV_SEVERITY}. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            enumType = MavSeverity.class
    )
    public final EnumValue<MavSeverity> severity() {
        return this.severity;
    }

    /**
     * Status text message, without null termination character 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            arraySize = 50
    )
    public final String text() {
        return this.text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Statustext other = (Statustext)o;
        if (!Objects.deepEquals(severity, other.severity)) return false;
        if (!Objects.deepEquals(text, other.text)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(severity);
        result = 31 * result + Objects.hashCode(text);
        return result;
    }

    @Override
    public String toString() {
        return "Statustext{severity=" + severity
                 + ", text=" + text + "}";
    }

    public static final class Builder {
        private EnumValue<MavSeverity> severity;

        private String text;

        /**
         * Severity of status. Relies on the definitions within RFC-5424. See enum {@link io.dronefleet.mavlink.common.MavSeverity MAV_SEVERITY}. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                enumType = MavSeverity.class
        )
        public final Builder severity(EnumValue<MavSeverity> severity) {
            this.severity = severity;
            return this;
        }

        /**
         * Severity of status. Relies on the definitions within RFC-5424. See enum {@link io.dronefleet.mavlink.common.MavSeverity MAV_SEVERITY}. 
         */
        public final Builder severity(MavSeverity entry) {
            this.severity = EnumValue.of(entry);
            return this;
        }

        /**
         * Severity of status. Relies on the definitions within RFC-5424. See enum {@link io.dronefleet.mavlink.common.MavSeverity MAV_SEVERITY}. 
         */
        public final Builder severity(Enum... flags) {
            this.severity = EnumValue.create(flags);
            return this;
        }

        /**
         * Status text message, without null termination character 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                arraySize = 50
        )
        public final Builder text(String text) {
            this.text = text;
            return this;
        }

        public final Statustext build() {
            return new Statustext(severity, text);
        }
    }
}
