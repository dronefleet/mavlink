package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Deprecated;
import java.lang.Float;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * ESC information for higher rate streaming. Recommended streaming rate is ~10 Hz. Information 
 * that changes more slowly is sent in {@link io.dronefleet.mavlink.common.EscInfo ESC_INFO}. It should typically only be streamed on 
 * high-bandwidth links (i.e. to a companion computer). 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 291,
        crc = 10,
        description = "ESC information for higher rate streaming. Recommended streaming rate is ~10 Hz. Information that changes more slowly is sent in ESC_INFO. It should typically only be streamed on high-bandwidth links (i.e. to a companion computer).",
        workInProgress = true
)
@Deprecated
public final class EscStatus {
    private final int index;

    private final BigInteger timeUsec;

    private final List<Integer> rpm;

    private final List<Float> voltage;

    private final List<Float> current;

    private EscStatus(int index, BigInteger timeUsec, List<Integer> rpm, List<Float> voltage,
            List<Float> current) {
        this.index = index;
        this.timeUsec = timeUsec;
        this.rpm = rpm;
        this.voltage = voltage;
        this.current = current;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Index of the first ESC in this message. minValue = 0, maxValue = 60, increment = 4. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Index of the first ESC in this message. minValue = 0, maxValue = 60, increment = 4."
    )
    public final int index() {
        return this.index;
    }

    /**
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
     * format (since 1.1.1970 or since system boot) by checking for the magnitude the number. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 8,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude the number."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Reported motor RPM from each ESC (negative for reverse rotation). 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            arraySize = 4,
            signed = true,
            description = "Reported motor RPM from each ESC (negative for reverse rotation)."
    )
    public final List<Integer> rpm() {
        return this.rpm;
    }

    /**
     * Voltage measured from each ESC. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            arraySize = 4,
            description = "Voltage measured from each ESC."
    )
    public final List<Float> voltage() {
        return this.voltage;
    }

    /**
     * Current measured from each ESC. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            arraySize = 4,
            description = "Current measured from each ESC."
    )
    public final List<Float> current() {
        return this.current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        EscStatus other = (EscStatus)o;
        if (!Objects.deepEquals(index, other.index)) return false;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(rpm, other.rpm)) return false;
        if (!Objects.deepEquals(voltage, other.voltage)) return false;
        if (!Objects.deepEquals(current, other.current)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(index);
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(rpm);
        result = 31 * result + Objects.hashCode(voltage);
        result = 31 * result + Objects.hashCode(current);
        return result;
    }

    @Override
    public String toString() {
        return "EscStatus{index=" + index
                 + ", timeUsec=" + timeUsec
                 + ", rpm=" + rpm
                 + ", voltage=" + voltage
                 + ", current=" + current + "}";
    }

    public static final class Builder {
        private int index;

        private BigInteger timeUsec;

        private List<Integer> rpm;

        private List<Float> voltage;

        private List<Float> current;

        /**
         * Index of the first ESC in this message. minValue = 0, maxValue = 60, increment = 4. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Index of the first ESC in this message. minValue = 0, maxValue = 60, increment = 4."
        )
        public final Builder index(int index) {
            this.index = index;
            return this;
        }

        /**
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude the number. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 8,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude the number."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Reported motor RPM from each ESC (negative for reverse rotation). 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                arraySize = 4,
                signed = true,
                description = "Reported motor RPM from each ESC (negative for reverse rotation)."
        )
        public final Builder rpm(List<Integer> rpm) {
            this.rpm = rpm;
            return this;
        }

        /**
         * Voltage measured from each ESC. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                arraySize = 4,
                description = "Voltage measured from each ESC."
        )
        public final Builder voltage(List<Float> voltage) {
            this.voltage = voltage;
            return this;
        }

        /**
         * Current measured from each ESC. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                arraySize = 4,
                description = "Current measured from each ESC."
        )
        public final Builder current(List<Float> current) {
            this.current = current;
            return this;
        }

        public final EscStatus build() {
            return new EscStatus(index, timeUsec, rpm, voltage, current);
        }
    }
}
