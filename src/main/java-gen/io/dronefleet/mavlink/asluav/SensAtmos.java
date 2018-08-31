package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Atmospheric sensors (temperature, humidity, ...) 
 */
@MavlinkMessageInfo(
        id = 208,
        crc = 175,
        description = "Atmospheric sensors (temperature, humidity, ...)"
)
public final class SensAtmos {
    private final float tempambient;

    private final float humidity;

    private SensAtmos(float tempambient, float humidity) {
        this.tempambient = tempambient;
        this.humidity = humidity;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Ambient temperature 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Ambient temperature"
    )
    public final float tempambient() {
        return this.tempambient;
    }

    /**
     * Relative humidity 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Relative humidity"
    )
    public final float humidity() {
        return this.humidity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SensAtmos other = (SensAtmos)o;
        if (!Objects.deepEquals(tempambient, other.tempambient)) return false;
        if (!Objects.deepEquals(humidity, other.humidity)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(tempambient);
        result = 31 * result + Objects.hashCode(humidity);
        return result;
    }

    @Override
    public String toString() {
        return "SensAtmos{tempambient=" + tempambient
                 + ", humidity=" + humidity + "}";
    }

    public static final class Builder {
        private float tempambient;

        private float humidity;

        /**
         * Ambient temperature 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Ambient temperature"
        )
        public final Builder tempambient(float tempambient) {
            this.tempambient = tempambient;
            return this;
        }

        /**
         * Relative humidity 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Relative humidity"
        )
        public final Builder humidity(float humidity) {
            this.humidity = humidity;
            return this;
        }

        public final SensAtmos build() {
            return new SensAtmos(tempambient, humidity);
        }
    }
}
