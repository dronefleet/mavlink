package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;

/**
 * ESC Telemetry Data for ESCs 9 to 12, matching data sent by BLHeli ESCs. 
 */
@MavlinkMessageInfo(
        id = 11032,
        crc = 85,
        description = "ESC Telemetry Data for ESCs 9 to 12, matching data sent by BLHeli ESCs."
)
public final class EscTelemetry9To12 {
    private final byte[] temperature;

    private final List<Integer> voltage;

    private final List<Integer> current;

    private final List<Integer> totalcurrent;

    private final List<Integer> rpm;

    private final List<Integer> count;

    private EscTelemetry9To12(byte[] temperature, List<Integer> voltage, List<Integer> current,
            List<Integer> totalcurrent, List<Integer> rpm, List<Integer> count) {
        this.temperature = temperature;
        this.voltage = voltage;
        this.current = current;
        this.totalcurrent = totalcurrent;
        this.rpm = rpm;
        this.count = count;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Temperature. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            arraySize = 4,
            description = "Temperature."
    )
    public final byte[] temperature() {
        return this.temperature;
    }

    /**
     * Voltage. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            arraySize = 4,
            description = "Voltage."
    )
    public final List<Integer> voltage() {
        return this.voltage;
    }

    /**
     * Current. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            arraySize = 4,
            description = "Current."
    )
    public final List<Integer> current() {
        return this.current;
    }

    /**
     * Total current. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            arraySize = 4,
            description = "Total current."
    )
    public final List<Integer> totalcurrent() {
        return this.totalcurrent;
    }

    /**
     * {@link io.dronefleet.mavlink.ardupilotmega.Rpm RPM} (e{@link io.dronefleet.mavlink.ardupilotmega.Rpm RPM}). 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            arraySize = 4,
            description = "RPM (eRPM)."
    )
    public final List<Integer> rpm() {
        return this.rpm;
    }

    /**
     * count of telemetry packets received (wraps at 65535). 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            arraySize = 4,
            description = "count of telemetry packets received (wraps at 65535)."
    )
    public final List<Integer> count() {
        return this.count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        EscTelemetry9To12 other = (EscTelemetry9To12)o;
        if (!Objects.deepEquals(temperature, other.temperature)) return false;
        if (!Objects.deepEquals(voltage, other.voltage)) return false;
        if (!Objects.deepEquals(current, other.current)) return false;
        if (!Objects.deepEquals(totalcurrent, other.totalcurrent)) return false;
        if (!Objects.deepEquals(rpm, other.rpm)) return false;
        if (!Objects.deepEquals(count, other.count)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(temperature);
        result = 31 * result + Objects.hashCode(voltage);
        result = 31 * result + Objects.hashCode(current);
        result = 31 * result + Objects.hashCode(totalcurrent);
        result = 31 * result + Objects.hashCode(rpm);
        result = 31 * result + Objects.hashCode(count);
        return result;
    }

    @Override
    public String toString() {
        return "EscTelemetry9To12{temperature=" + temperature
                 + ", voltage=" + voltage
                 + ", current=" + current
                 + ", totalcurrent=" + totalcurrent
                 + ", rpm=" + rpm
                 + ", count=" + count + "}";
    }

    public static final class Builder {
        private byte[] temperature;

        private List<Integer> voltage;

        private List<Integer> current;

        private List<Integer> totalcurrent;

        private List<Integer> rpm;

        private List<Integer> count;

        /**
         * Temperature. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                arraySize = 4,
                description = "Temperature."
        )
        public final Builder temperature(byte[] temperature) {
            this.temperature = temperature;
            return this;
        }

        /**
         * Voltage. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                arraySize = 4,
                description = "Voltage."
        )
        public final Builder voltage(List<Integer> voltage) {
            this.voltage = voltage;
            return this;
        }

        /**
         * Current. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                arraySize = 4,
                description = "Current."
        )
        public final Builder current(List<Integer> current) {
            this.current = current;
            return this;
        }

        /**
         * Total current. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                arraySize = 4,
                description = "Total current."
        )
        public final Builder totalcurrent(List<Integer> totalcurrent) {
            this.totalcurrent = totalcurrent;
            return this;
        }

        /**
         * {@link io.dronefleet.mavlink.ardupilotmega.Rpm RPM} (e{@link io.dronefleet.mavlink.ardupilotmega.Rpm RPM}). 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                arraySize = 4,
                description = "RPM (eRPM)."
        )
        public final Builder rpm(List<Integer> rpm) {
            this.rpm = rpm;
            return this;
        }

        /**
         * count of telemetry packets received (wraps at 65535). 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                arraySize = 4,
                description = "count of telemetry packets received (wraps at 65535)."
        )
        public final Builder count(List<Integer> count) {
            this.count = count;
            return this;
        }

        public final EscTelemetry9To12 build() {
            return new EscTelemetry9To12(temperature, voltage, current, totalcurrent, rpm, count);
        }
    }
}
