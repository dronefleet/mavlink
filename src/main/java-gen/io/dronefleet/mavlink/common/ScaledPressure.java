package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * The pressure readings for the typical setup of one absolute and differential pressure sensor. 
 * The units are as specified in each field. 
 */
@MavlinkMessageInfo(
        id = 29,
        crc = 115,
        description = "The pressure readings for the typical setup of one absolute and differential pressure sensor. The units are as specified in each field."
)
public final class ScaledPressure {
    private final long timeBootMs;

    private final float pressAbs;

    private final float pressDiff;

    private final int temperature;

    private ScaledPressure(long timeBootMs, float pressAbs, float pressDiff, int temperature) {
        this.timeBootMs = timeBootMs;
        this.pressAbs = pressAbs;
        this.pressDiff = pressDiff;
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
     * Differential pressure 1 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Differential pressure 1"
    )
    public final float pressDiff() {
        return this.pressDiff;
    }

    /**
     * Temperature 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true,
            description = "Temperature"
    )
    public final int temperature() {
        return this.temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ScaledPressure other = (ScaledPressure)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(pressAbs, other.pressAbs)) return false;
        if (!Objects.deepEquals(pressDiff, other.pressDiff)) return false;
        if (!Objects.deepEquals(temperature, other.temperature)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(pressAbs);
        result = 31 * result + Objects.hashCode(pressDiff);
        result = 31 * result + Objects.hashCode(temperature);
        return result;
    }

    @Override
    public String toString() {
        return "ScaledPressure{timeBootMs=" + timeBootMs
                 + ", pressAbs=" + pressAbs
                 + ", pressDiff=" + pressDiff
                 + ", temperature=" + temperature + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private float pressAbs;

        private float pressDiff;

        private int temperature;

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
         * Differential pressure 1 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Differential pressure 1"
        )
        public final Builder pressDiff(float pressDiff) {
            this.pressDiff = pressDiff;
            return this;
        }

        /**
         * Temperature 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true,
                description = "Temperature"
        )
        public final Builder temperature(int temperature) {
            this.temperature = temperature;
            return this;
        }

        public final ScaledPressure build() {
            return new ScaledPressure(timeBootMs, pressAbs, pressDiff, temperature);
        }
    }
}
