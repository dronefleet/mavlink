package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * The raw values of the actuator outputs (e.g. on Pixhawk, from MAIN, AUX ports). This message 
 * supersedes {@link io.dronefleet.mavlink.common.ServoOutputRaw SERVO_OUTPUT_RAW}. 
 */
@MavlinkMessageInfo(
        id = 375,
        crc = 251,
        description = "The raw values of the actuator outputs (e.g. on Pixhawk, from MAIN, AUX ports). This message supersedes SERVO_OUTPUT_RAW."
)
public final class ActuatorOutputStatus {
    private final BigInteger timeUsec;

    private final long active;

    private final List<Float> actuator;

    private ActuatorOutputStatus(BigInteger timeUsec, long active, List<Float> actuator) {
        this.timeUsec = timeUsec;
        this.active = active;
        this.actuator = actuator;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (since system boot). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (since system boot)."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Active outputs 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Active outputs"
    )
    public final long active() {
        return this.active;
    }

    /**
     * Servo / motor output array values. Zero values indicate unused channels. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            arraySize = 32,
            description = "Servo / motor output array values. Zero values indicate unused channels."
    )
    public final List<Float> actuator() {
        return this.actuator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ActuatorOutputStatus other = (ActuatorOutputStatus)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(active, other.active)) return false;
        if (!Objects.deepEquals(actuator, other.actuator)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(active);
        result = 31 * result + Objects.hashCode(actuator);
        return result;
    }

    @Override
    public String toString() {
        return "ActuatorOutputStatus{timeUsec=" + timeUsec
                 + ", active=" + active
                 + ", actuator=" + actuator + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private long active;

        private List<Float> actuator;

        /**
         * Timestamp (since system boot). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (since system boot)."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Active outputs 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Active outputs"
        )
        public final Builder active(long active) {
            this.active = active;
            return this;
        }

        /**
         * Servo / motor output array values. Zero values indicate unused channels. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                arraySize = 32,
                description = "Servo / motor output array values. Zero values indicate unused channels."
        )
        public final Builder actuator(List<Float> actuator) {
            this.actuator = actuator;
            return this;
        }

        public final ActuatorOutputStatus build() {
            return new ActuatorOutputStatus(timeUsec, active, actuator);
        }
    }
}
