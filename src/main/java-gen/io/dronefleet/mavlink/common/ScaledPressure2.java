package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Barometer readings for 2nd barometer 
 */
@MavlinkMessageInfo(
        id = 137,
        crc = 195,
        description = "Barometer readings for 2nd barometer"
)
public final class ScaledPressure2 {
    private final long timeBootMs;

    private final float pressAbs;

    private final float pressDiff;

    private final int temperature;

    private final int temperaturePressDiff;

    private ScaledPressure2(long timeBootMs, float pressAbs, float pressDiff, int temperature,
            int temperaturePressDiff) {
        this.timeBootMs = timeBootMs;
        this.pressAbs = pressAbs;
        this.pressDiff = pressDiff;
        this.temperature = temperature;
        this.temperaturePressDiff = temperaturePressDiff;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (time since system boot). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Timestamp (time since system boot)."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Absolute pressure 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Absolute pressure"
    )
    public final float pressAbs() {
        return this.pressAbs;
    }

    /**
     * Differential pressure 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Differential pressure"
    )
    public final float pressDiff() {
        return this.pressDiff;
    }

    /**
     * Absolute pressure temperature 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true,
            description = "Absolute pressure temperature"
    )
    public final int temperature() {
        return this.temperature;
    }

    /**
     * Differential pressure temperature (0, if not available). Report values of 0 (or 1) as 1 cdegC. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            signed = true,
            extension = true,
            description = "Differential pressure temperature (0, if not available). Report values of 0 (or 1) as 1 cdegC."
    )
    public final int temperaturePressDiff() {
        return this.temperaturePressDiff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ScaledPressure2 other = (ScaledPressure2)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(pressAbs, other.pressAbs)) return false;
        if (!Objects.deepEquals(pressDiff, other.pressDiff)) return false;
        if (!Objects.deepEquals(temperature, other.temperature)) return false;
        if (!Objects.deepEquals(temperaturePressDiff, other.temperaturePressDiff)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(pressAbs);
        result = 31 * result + Objects.hashCode(pressDiff);
        result = 31 * result + Objects.hashCode(temperature);
        result = 31 * result + Objects.hashCode(temperaturePressDiff);
        return result;
    }

    @Override
    public String toString() {
        return "ScaledPressure2{timeBootMs=" + timeBootMs
                 + ", pressAbs=" + pressAbs
                 + ", pressDiff=" + pressDiff
                 + ", temperature=" + temperature
                 + ", temperaturePressDiff=" + temperaturePressDiff + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private float pressAbs;

        private float pressDiff;

        private int temperature;

        private int temperaturePressDiff;

        /**
         * Timestamp (time since system boot). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Timestamp (time since system boot)."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Absolute pressure 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Absolute pressure"
        )
        public final Builder pressAbs(float pressAbs) {
            this.pressAbs = pressAbs;
            return this;
        }

        /**
         * Differential pressure 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Differential pressure"
        )
        public final Builder pressDiff(float pressDiff) {
            this.pressDiff = pressDiff;
            return this;
        }

        /**
         * Absolute pressure temperature 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true,
                description = "Absolute pressure temperature"
        )
        public final Builder temperature(int temperature) {
            this.temperature = temperature;
            return this;
        }

        /**
         * Differential pressure temperature (0, if not available). Report values of 0 (or 1) as 1 cdegC. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                signed = true,
                extension = true,
                description = "Differential pressure temperature (0, if not available). Report values of 0 (or 1) as 1 cdegC."
        )
        public final Builder temperaturePressDiff(int temperaturePressDiff) {
            this.temperaturePressDiff = temperaturePressDiff;
            return this;
        }

        public final ScaledPressure2 build() {
            return new ScaledPressure2(timeBootMs, pressAbs, pressDiff, temperature, temperaturePressDiff);
        }
    }
}
