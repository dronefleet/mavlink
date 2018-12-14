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
 * Power supply status 
 */
@MavlinkMessageInfo(
        id = 125,
        crc = 203,
        description = "Power supply status"
)
public final class PowerStatus {
    private final int vcc;

    private final int vservo;

    private final EnumValue<MavPowerStatus> flags;

    private PowerStatus(int vcc, int vservo, EnumValue<MavPowerStatus> flags) {
        this.vcc = vcc;
        this.vservo = vservo;
        this.flags = flags;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * 5V rail voltage. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2,
            description = "5V rail voltage."
    )
    public final int vcc() {
        return this.vcc;
    }

    /**
     * Servo rail voltage. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            description = "Servo rail voltage."
    )
    public final int vservo() {
        return this.vservo;
    }

    /**
     * Bitmap of power supply status flags. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            enumType = MavPowerStatus.class,
            description = "Bitmap of power supply status flags."
    )
    public final EnumValue<MavPowerStatus> flags() {
        return this.flags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        PowerStatus other = (PowerStatus)o;
        if (!Objects.deepEquals(vcc, other.vcc)) return false;
        if (!Objects.deepEquals(vservo, other.vservo)) return false;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(vcc);
        result = 31 * result + Objects.hashCode(vservo);
        result = 31 * result + Objects.hashCode(flags);
        return result;
    }

    @Override
    public String toString() {
        return "PowerStatus{vcc=" + vcc
                 + ", vservo=" + vservo
                 + ", flags=" + flags + "}";
    }

    public static final class Builder {
        private int vcc;

        private int vservo;

        private EnumValue<MavPowerStatus> flags;

        /**
         * 5V rail voltage. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2,
                description = "5V rail voltage."
        )
        public final Builder vcc(int vcc) {
            this.vcc = vcc;
            return this;
        }

        /**
         * Servo rail voltage. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                description = "Servo rail voltage."
        )
        public final Builder vservo(int vservo) {
            this.vservo = vservo;
            return this;
        }

        /**
         * Bitmap of power supply status flags. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                enumType = MavPowerStatus.class,
                description = "Bitmap of power supply status flags."
        )
        public final Builder flags(EnumValue<MavPowerStatus> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * Bitmap of power supply status flags. 
         */
        public final Builder flags(MavPowerStatus entry) {
            return flags(EnumValue.of(entry));
        }

        /**
         * Bitmap of power supply status flags. 
         */
        public final Builder flags(Enum... flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Bitmap of power supply status flags. 
         */
        public final Builder flags(Collection<Enum> flags) {
            return flags(EnumValue.create(flags));
        }

        public final PowerStatus build() {
            return new PowerStatus(vcc, vservo, flags);
        }
    }
}
