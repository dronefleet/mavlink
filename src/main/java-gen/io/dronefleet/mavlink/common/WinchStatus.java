package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

/**
 * Winch status. 
 */
@MavlinkMessageInfo(
        id = 9005,
        crc = 117,
        description = "Winch status."
)
public final class WinchStatus {
    private final BigInteger timeUsec;

    private final float lineLength;

    private final float speed;

    private final float tension;

    private final float voltage;

    private final float current;

    private final int temperature;

    private final EnumValue<MavWinchStatusFlag> status;

    private WinchStatus(BigInteger timeUsec, float lineLength, float speed, float tension,
            float voltage, float current, int temperature, EnumValue<MavWinchStatusFlag> status) {
        this.timeUsec = timeUsec;
        this.lineLength = lineLength;
        this.speed = speed;
        this.tension = tension;
        this.voltage = voltage;
        this.current = current;
        this.temperature = temperature;
        this.status = status;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (synced to UNIX time or since system boot). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (synced to UNIX time or since system boot)."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Length of line released. NaN if unknown 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Length of line released. NaN if unknown"
    )
    public final float lineLength() {
        return this.lineLength;
    }

    /**
     * Speed line is being released or retracted. Positive values if being released, negative values 
     * if being retracted, NaN if unknown 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Speed line is being released or retracted. Positive values if being released, negative values if being retracted, NaN if unknown"
    )
    public final float speed() {
        return this.speed;
    }

    /**
     * Tension on the line. NaN if unknown 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Tension on the line. NaN if unknown"
    )
    public final float tension() {
        return this.tension;
    }

    /**
     * Voltage of the battery supplying the winch. NaN if unknown 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Voltage of the battery supplying the winch. NaN if unknown"
    )
    public final float voltage() {
        return this.voltage;
    }

    /**
     * Current draw from the winch. NaN if unknown 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Current draw from the winch. NaN if unknown"
    )
    public final float current() {
        return this.current;
    }

    /**
     * Temperature of the motor. INT16_MAX if unknown 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            signed = true,
            description = "Temperature of the motor. INT16_MAX if unknown"
    )
    public final int temperature() {
        return this.temperature;
    }

    /**
     * Status flags 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            enumType = MavWinchStatusFlag.class,
            description = "Status flags"
    )
    public final EnumValue<MavWinchStatusFlag> status() {
        return this.status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        WinchStatus other = (WinchStatus)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(lineLength, other.lineLength)) return false;
        if (!Objects.deepEquals(speed, other.speed)) return false;
        if (!Objects.deepEquals(tension, other.tension)) return false;
        if (!Objects.deepEquals(voltage, other.voltage)) return false;
        if (!Objects.deepEquals(current, other.current)) return false;
        if (!Objects.deepEquals(temperature, other.temperature)) return false;
        if (!Objects.deepEquals(status, other.status)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(lineLength);
        result = 31 * result + Objects.hashCode(speed);
        result = 31 * result + Objects.hashCode(tension);
        result = 31 * result + Objects.hashCode(voltage);
        result = 31 * result + Objects.hashCode(current);
        result = 31 * result + Objects.hashCode(temperature);
        result = 31 * result + Objects.hashCode(status);
        return result;
    }

    @Override
    public String toString() {
        return "WinchStatus{timeUsec=" + timeUsec
                 + ", lineLength=" + lineLength
                 + ", speed=" + speed
                 + ", tension=" + tension
                 + ", voltage=" + voltage
                 + ", current=" + current
                 + ", temperature=" + temperature
                 + ", status=" + status + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private float lineLength;

        private float speed;

        private float tension;

        private float voltage;

        private float current;

        private int temperature;

        private EnumValue<MavWinchStatusFlag> status;

        /**
         * Timestamp (synced to UNIX time or since system boot). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (synced to UNIX time or since system boot)."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Length of line released. NaN if unknown 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Length of line released. NaN if unknown"
        )
        public final Builder lineLength(float lineLength) {
            this.lineLength = lineLength;
            return this;
        }

        /**
         * Speed line is being released or retracted. Positive values if being released, negative values 
         * if being retracted, NaN if unknown 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Speed line is being released or retracted. Positive values if being released, negative values if being retracted, NaN if unknown"
        )
        public final Builder speed(float speed) {
            this.speed = speed;
            return this;
        }

        /**
         * Tension on the line. NaN if unknown 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Tension on the line. NaN if unknown"
        )
        public final Builder tension(float tension) {
            this.tension = tension;
            return this;
        }

        /**
         * Voltage of the battery supplying the winch. NaN if unknown 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Voltage of the battery supplying the winch. NaN if unknown"
        )
        public final Builder voltage(float voltage) {
            this.voltage = voltage;
            return this;
        }

        /**
         * Current draw from the winch. NaN if unknown 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Current draw from the winch. NaN if unknown"
        )
        public final Builder current(float current) {
            this.current = current;
            return this;
        }

        /**
         * Temperature of the motor. INT16_MAX if unknown 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                signed = true,
                description = "Temperature of the motor. INT16_MAX if unknown"
        )
        public final Builder temperature(int temperature) {
            this.temperature = temperature;
            return this;
        }

        /**
         * Status flags 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                enumType = MavWinchStatusFlag.class,
                description = "Status flags"
        )
        public final Builder status(EnumValue<MavWinchStatusFlag> status) {
            this.status = status;
            return this;
        }

        /**
         * Status flags 
         */
        public final Builder status(MavWinchStatusFlag entry) {
            return status(EnumValue.of(entry));
        }

        /**
         * Status flags 
         */
        public final Builder status(Enum... flags) {
            return status(EnumValue.create(flags));
        }

        /**
         * Status flags 
         */
        public final Builder status(Collection<Enum> flags) {
            return status(EnumValue.create(flags));
        }

        public final WinchStatus build() {
            return new WinchStatus(timeUsec, lineLength, speed, tension, voltage, current, temperature, status);
        }
    }
}
