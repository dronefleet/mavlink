package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.math.BigInteger;

/**
 * The RAW pressure readings for the typical setup of one absolute pressure and one differential 
 * pressure sensor. The sensor values should be the raw, UNSCALED ADC values. 
 */
@MavlinkMessageInfo(
        id = 28,
        crc = 67
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
     * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
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
            signed = true
    )
    public final int pressAbs() {
        return this.pressAbs;
    }

    /**
     * Differential pressure 1 (raw, 0 if nonexistant) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true
    )
    public final int pressDiff1() {
        return this.pressDiff1;
    }

    /**
     * Differential pressure 2 (raw, 0 if nonexistant) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true
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
            signed = true
    )
    public final int temperature() {
        return this.temperature;
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private int pressAbs;

        private int pressDiff1;

        private int pressDiff2;

        private int temperature;

        /**
         * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8
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
                signed = true
        )
        public final Builder pressAbs(int pressAbs) {
            this.pressAbs = pressAbs;
            return this;
        }

        /**
         * Differential pressure 1 (raw, 0 if nonexistant) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true
        )
        public final Builder pressDiff1(int pressDiff1) {
            this.pressDiff1 = pressDiff1;
            return this;
        }

        /**
         * Differential pressure 2 (raw, 0 if nonexistant) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true
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
                signed = true
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
