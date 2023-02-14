package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Temperature and humidity from hygrometer. 
 */
@MavlinkMessageInfo(
        id = 12920,
        crc = 20,
        description = "Temperature and humidity from hygrometer."
)
public final class HygrometerSensor {
    private final int id;

    private final int temperature;

    private final int humidity;

    private HygrometerSensor(int id, int temperature, int humidity) {
        this.id = id;
        this.temperature = temperature;
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
     * Hygrometer ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "Hygrometer ID"
    )
    public final int id() {
        return this.id;
    }

    /**
     * Temperature 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            signed = true,
            description = "Temperature"
    )
    public final int temperature() {
        return this.temperature;
    }

    /**
     * Humidity 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "Humidity"
    )
    public final int humidity() {
        return this.humidity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        HygrometerSensor other = (HygrometerSensor)o;
        if (!Objects.deepEquals(id, other.id)) return false;
        if (!Objects.deepEquals(temperature, other.temperature)) return false;
        if (!Objects.deepEquals(humidity, other.humidity)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(temperature);
        result = 31 * result + Objects.hashCode(humidity);
        return result;
    }

    @Override
    public String toString() {
        return "HygrometerSensor{id=" + id
                 + ", temperature=" + temperature
                 + ", humidity=" + humidity + "}";
    }

    public static final class Builder {
        private int id;

        private int temperature;

        private int humidity;

        /**
         * Hygrometer ID 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "Hygrometer ID"
        )
        public final Builder id(int id) {
            this.id = id;
            return this;
        }

        /**
         * Temperature 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                signed = true,
                description = "Temperature"
        )
        public final Builder temperature(int temperature) {
            this.temperature = temperature;
            return this;
        }

        /**
         * Humidity 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "Humidity"
        )
        public final Builder humidity(int humidity) {
            this.humidity = humidity;
            return this;
        }

        public final HygrometerSensor build() {
            return new HygrometerSensor(id, temperature, humidity);
        }
    }
}
