package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Transmits the readings from the voltage and current sensors 
 */
@MavlinkMessageInfo(
        id = 191,
        crc = 17
)
public final class VoltSensor {
    private final int r2type;

    private final int voltage;

    private final int reading2;

    private VoltSensor(int r2type, int voltage, int reading2) {
        this.r2type = r2type;
        this.voltage = voltage;
        this.reading2 = reading2;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * It is the value of reading 2: 0 - Current, 1 - Foreward Sonar, 2 - Back Sonar, 3 - RPM 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int r2type() {
        return this.r2type;
    }

    /**
     * Voltage in uS of PWM. 0 uS = 0V, 20 uS = 21.5V 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2
    )
    public final int voltage() {
        return this.voltage;
    }

    /**
     * Depends on the value of r2Type (0) Current consumption in uS of PWM, 20 uS = 90Amp (1) Distance in 
     * cm (2) Distance in cm (3) Absolute value 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int reading2() {
        return this.reading2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        VoltSensor other = (VoltSensor)o;
        if (!Objects.deepEquals(r2type, other.r2type)) return false;
        if (!Objects.deepEquals(voltage, other.voltage)) return false;
        if (!Objects.deepEquals(reading2, other.reading2)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(r2type);
        result = 31 * result + Objects.hashCode(voltage);
        result = 31 * result + Objects.hashCode(reading2);
        return result;
    }

    @Override
    public String toString() {
        return "VoltSensor{r2type=" + r2type
                 + ", voltage=" + voltage
                 + ", reading2=" + reading2 + "}";
    }

    public static final class Builder {
        private int r2type;

        private int voltage;

        private int reading2;

        /**
         * It is the value of reading 2: 0 - Current, 1 - Foreward Sonar, 2 - Back Sonar, 3 - RPM 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder r2type(int r2type) {
            this.r2type = r2type;
            return this;
        }

        /**
         * Voltage in uS of PWM. 0 uS = 0V, 20 uS = 21.5V 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2
        )
        public final Builder voltage(int voltage) {
            this.voltage = voltage;
            return this;
        }

        /**
         * Depends on the value of r2Type (0) Current consumption in uS of PWM, 20 uS = 90Amp (1) Distance in 
         * cm (2) Distance in cm (3) Absolute value 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2
        )
        public final Builder reading2(int reading2) {
            this.reading2 = reading2;
            return this;
        }

        public final VoltSensor build() {
            return new VoltSensor(r2type, voltage, reading2);
        }
    }
}
