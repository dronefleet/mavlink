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
 * Status text message. These messages are printed in yellow in the COMM console of 
 * QGroundControl. WARNING: They consume quite some bandwidth, so use only for important status 
 * and error messages. If implemented wisely, these messages are buffered on the MCU and sent only 
 * at a limited rate (e.g. 10 Hz). 
 */
@MavlinkMessageInfo(
        id = 253,
        crc = 83,
        description = "Status text message. These messages are printed in yellow in the COMM console of QGroundControl. WARNING: They consume quite some bandwidth, so use only for important status and error messages. If implemented wisely, these messages are buffered on the MCU and sent only at a limited rate (e.g. 10 Hz)."
)
public final class Statustext {
    private final EnumValue<MavSeverity> severity;

    private final String text;

    private final int id;

    private final int chunkSeq;

    private Statustext(EnumValue<MavSeverity> severity, String text, int id, int chunkSeq) {
        this.severity = severity;
        this.text = text;
        this.id = id;
        this.chunkSeq = chunkSeq;
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
     * Status text message, without null termination character 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            arraySize = 50,
            description = "Status text message, without null termination character"
    )
    public final String text() {
        return this.text;
    }

    /**
     * Unique (opaque) identifier for this statustext message. May be used to reassemble a logical 
     * long-statustext message from a sequence of chunks. A value of zero indicates this is the only 
     * chunk in the sequence and the message can be emitted immediately. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            extension = true,
            description = "Unique (opaque) identifier for this statustext message.  May be used to reassemble a logical long-statustext message from a sequence of chunks.  A value of zero indicates this is the only chunk in the sequence and the message can be emitted immediately."
    )
    public final int id() {
        return this.id;
    }

    /**
     * This chunk's sequence number; indexing is from zero. Any null character in the text field is 
     * taken to mean this was the last chunk. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            extension = true,
            description = "This chunk's sequence number; indexing is from zero.  Any null character in the text field is taken to mean this was the last chunk."
    )
    public final int chunkSeq() {
        return this.chunkSeq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Statustext other = (Statustext)o;
        if (!Objects.deepEquals(severity, other.severity)) return false;
        if (!Objects.deepEquals(text, other.text)) return false;
        if (!Objects.deepEquals(id, other.id)) return false;
        if (!Objects.deepEquals(chunkSeq, other.chunkSeq)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(severity);
        result = 31 * result + Objects.hashCode(text);
        result = 31 * result + Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(chunkSeq);
        return result;
    }

    @Override
    public String toString() {
        return "Statustext{severity=" + severity
                 + ", text=" + text
                 + ", id=" + id
                 + ", chunkSeq=" + chunkSeq + "}";
    }

    public static final class Builder {
        private EnumValue<MavSeverity> severity;

        private String text;

        private int id;

        private int chunkSeq;

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
         * Status text message, without null termination character 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                arraySize = 50,
                description = "Status text message, without null termination character"
        )
        public final Builder text(String text) {
            this.text = text;
            return this;
        }

        /**
         * Unique (opaque) identifier for this statustext message. May be used to reassemble a logical 
         * long-statustext message from a sequence of chunks. A value of zero indicates this is the only 
         * chunk in the sequence and the message can be emitted immediately. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                extension = true,
                description = "Unique (opaque) identifier for this statustext message.  May be used to reassemble a logical long-statustext message from a sequence of chunks.  A value of zero indicates this is the only chunk in the sequence and the message can be emitted immediately."
        )
        public final Builder id(int id) {
            this.id = id;
            return this;
        }

        /**
         * This chunk's sequence number; indexing is from zero. Any null character in the text field is 
         * taken to mean this was the last chunk. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                extension = true,
                description = "This chunk's sequence number; indexing is from zero.  Any null character in the text field is taken to mean this was the last chunk."
        )
        public final Builder chunkSeq(int chunkSeq) {
            this.chunkSeq = chunkSeq;
            return this;
        }

        public final Statustext build() {
            return new Statustext(severity, text, id, chunkSeq);
        }
    }
}
