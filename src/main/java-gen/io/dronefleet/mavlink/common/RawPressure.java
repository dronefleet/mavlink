package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Objects;

/**
 * The RAW pressure readings for the typical setup of one absolute pressure and one differential 
 * pressure sensor. The sensor values should be the raw, UNSCALED ADC values. 
 */
@MavlinkMessageInfo(
        id = 28,
        crc = 67,
        description = "The RAW pressure readings for the typical setup of one absolute pressure and one differential pressure sensor. The sensor values should be the raw, UNSCALED ADC values."
)
public final class RawPressure {
    private final BigInteger timeUsec;

    private final int pressAbs;

    private final int pressDiff1;

    private final int pressDiff2;

    private final int temperature;

    private RawPressure(BigInteger timeUsec, int pressAbs, int pressDiff1, int pressDiff2,
            int temperature) {
        this.timeUsec = timeUsec;
        this.pressAbs = pressAbs;
        this.pressDiff1 = pressDiff1;
        this.pressDiff2 = pressDiff2;
        this.temperature = temperature;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
     * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Absolute pressure (raw) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            signed = true,
            description = "Absolute pressure (raw)"
    )
    public final int pressAbs() {
        return this.pressAbs;
    }

    /**
     * Differential pressure 1 (raw, 0 if nonexistent) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true,
            description = "Differential pressure 1 (raw, 0 if nonexistent)"
    )
    public final int pressDiff1() {
        return this.pressDiff1;
    }

    /**
     * Differential pressure 2 (raw, 0 if nonexistent) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true,
            description = "Differential pressure 2 (raw, 0 if nonexistent)"
    )
    public final int pressDiff2() {
        return this.pressDiff2;
    }

    /**
     * Raw Temperature measurement (raw) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            signed = true,
            description = "Raw Temperature measurement (raw)"
    )
    public final int temperature() {
        return this.temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        RawPressure other = (RawPressure)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(pressAbs, other.pressAbs)) return false;
        if (!Objects.deepEquals(pressDiff1, other.pressDiff1)) return false;
        if (!Objects.deepEquals(pressDiff2, other.pressDiff2)) return false;
        if (!Objects.deepEquals(temperature, other.temperature)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(pressAbs);
        result = 31 * result + Objects.hashCode(pressDiff1);
        result = 31 * result + Objects.hashCode(pressDiff2);
        result = 31 * result + Objects.hashCode(temperature);
        return result;
    }

    @Override
    public String toString() {
        return "RawPressure{timeUsec=" + timeUsec
                 + ", pressAbs=" + pressAbs
                 + ", pressDiff1=" + pressDiff1
                 + ", pressDiff2=" + pressDiff2
                 + ", temperature=" + temperature + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private int pressAbs;

        private int pressDiff1;

        private int pressDiff2;

        private int temperature;

        /**
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Absolute pressure (raw) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                signed = true,
                description = "Absolute pressure (raw)"
        )
        public final Builder pressAbs(int pressAbs) {
            this.pressAbs = pressAbs;
            return this;
        }

        /**
         * Differential pressure 1 (raw, 0 if nonexistent) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true,
                description = "Differential pressure 1 (raw, 0 if nonexistent)"
        )
        public final Builder pressDiff1(int pressDiff1) {
            this.pressDiff1 = pressDiff1;
            return this;
        }

        /**
         * Differential pressure 2 (raw, 0 if nonexistent) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true,
                description = "Differential pressure 2 (raw, 0 if nonexistent)"
        )
        public final Builder pressDiff2(int pressDiff2) {
            this.pressDiff2 = pressDiff2;
            return this;
        }

        /**
         * Raw Temperature measurement (raw) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                signed = true,
                description = "Raw Temperature measurement (raw)"
        )
        public final Builder temperature(int temperature) {
            this.temperature = temperature;
            return this;
        }

        public final RawPressure build() {
            return new RawPressure(timeUsec, pressAbs, pressDiff1, pressDiff2, temperature);
        }
    }
}
