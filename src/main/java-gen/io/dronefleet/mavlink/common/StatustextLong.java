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
 * Status text message (use only for important status and error messages). The full message 
 * payload can be used for status text, but we recommend that updates be kept concise. Note: The 
 * message is intended as a less restrictive replacement for {@link io.dronefleet.mavlink.common.Statustext STATUSTEXT}. 
 */
@MavlinkMessageInfo(
        id = 365,
        crc = 36,
        description = "Status text message (use only for important status and error messages). The full message payload can be used for status text, but we recommend that updates be kept concise. Note: The message is intended as a less restrictive replacement for STATUSTEXT."
)
public final class StatustextLong {
    private final EnumValue<MavSeverity> severity;

    private final String text;

    private StatustextLong(EnumValue<MavSeverity> severity, String text) {
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
     * Severity of status. Relies on the definitions within RFC-5424. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            enumType = MavSeverity.class,
            description = "Severity of status. Relies on the definitions within RFC-5424."
    )
    public final EnumValue<MavSeverity> severity() {
        return this.severity;
    }

    /**
     * Status text message, without null termination character. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            arraySize = 254,
            description = "Status text message, without null termination character."
    )
    public final String text() {
        return this.text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        StatustextLong other = (StatustextLong)o;
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
        return "StatustextLong{severity=" + severity
                 + ", text=" + text + "}";
    }

    public static final class Builder {
        private EnumValue<MavSeverity> severity;

        private String text;

        /**
         * Severity of status. Relies on the definitions within RFC-5424. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                enumType = MavSeverity.class,
                description = "Severity of status. Relies on the definitions within RFC-5424."
        )
        public final Builder severity(EnumValue<MavSeverity> severity) {
            this.severity = severity;
            return this;
        }

        /**
         * Severity of status. Relies on the definitions within RFC-5424. 
         */
        public final Builder severity(MavSeverity entry) {
            return severity(EnumValue.of(entry));
        }

        /**
         * Severity of status. Relies on the definitions within RFC-5424. 
         */
        public final Builder severity(Enum... flags) {
            return severity(EnumValue.create(flags));
        }

        /**
         * Severity of status. Relies on the definitions within RFC-5424. 
         */
        public final Builder severity(Collection<Enum> flags) {
            return severity(EnumValue.create(flags));
        }

        /**
         * Status text message, without null termination character. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                arraySize = 254,
                description = "Status text message, without null termination character."
        )
        public final Builder text(String text) {
            this.text = text;
            return this;
        }

        public final StatustextLong build() {
            return new StatustextLong(severity, text);
        }
    }
}
