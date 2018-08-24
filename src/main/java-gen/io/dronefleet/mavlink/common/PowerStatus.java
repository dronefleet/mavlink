package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * Power supply status 
 */
@MavlinkMessageInfo(
        id = 125,
        crc = 203
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
     * 5V rail voltage in millivolts 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2
    )
    public final int vcc() {
        return this.vcc;
    }

    /**
     * servo rail voltage in millivolts 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2
    )
    public final int vservo() {
        return this.vservo;
    }

    /**
     * power supply status flags (see {@link io.dronefleet.mavlink.common.MavPowerStatus MAV_POWER_STATUS} enum) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            enumType = MavPowerStatus.class
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

    public static final class Builder {
        private int vcc;

        private int vservo;

        private EnumValue<MavPowerStatus> flags;

        /**
         * 5V rail voltage in millivolts 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2
        )
        public final Builder vcc(int vcc) {
            this.vcc = vcc;
            return this;
        }

        /**
         * servo rail voltage in millivolts 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2
        )
        public final Builder vservo(int vservo) {
            this.vservo = vservo;
            return this;
        }

        /**
         * power supply status flags (see {@link io.dronefleet.mavlink.common.MavPowerStatus MAV_POWER_STATUS} enum) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                enumType = MavPowerStatus.class
        )
        public final Builder flags(EnumValue<MavPowerStatus> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * power supply status flags (see {@link io.dronefleet.mavlink.common.MavPowerStatus MAV_POWER_STATUS} enum) 
         */
        public final Builder flags(MavPowerStatus entry) {
            this.flags = EnumValue.of(entry);
            return this;
        }

        /**
         * power supply status flags (see {@link io.dronefleet.mavlink.common.MavPowerStatus MAV_POWER_STATUS} enum) 
         */
        public final Builder flags(Enum... flags) {
            this.flags = EnumValue.create(flags);
            return this;
        }

        public final PowerStatus build() {
            return new PowerStatus(vcc, vservo, flags);
        }
    }
}
