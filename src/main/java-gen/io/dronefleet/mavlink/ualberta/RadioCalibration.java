package io.dronefleet.mavlink.ualberta;

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
 * Complete set of calibration parameters for the radio 
 */
@MavlinkMessageInfo(
        id = 221,
        crc = 71,
        description = "Complete set of calibration parameters for the radio"
)
public final class RadioCalibration {
    private final List<Integer> aileron;

    private final List<Integer> elevator;

    private final List<Integer> rudder;

    private final List<Integer> gyro;

    private final List<Integer> pitch;

    private final List<Integer> throttle;

    private RadioCalibration(List<Integer> aileron, List<Integer> elevator, List<Integer> rudder,
            List<Integer> gyro, List<Integer> pitch, List<Integer> throttle) {
        this.aileron = aileron;
        this.elevator = elevator;
        this.rudder = rudder;
        this.gyro = gyro;
        this.pitch = pitch;
        this.throttle = throttle;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Aileron setpoints: left, center, right 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2,
            arraySize = 3,
            description = "Aileron setpoints: left, center, right"
    )
    public final List<Integer> aileron() {
        return this.aileron;
    }

    /**
     * Elevator setpoints: nose down, center, nose up 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            arraySize = 3,
            description = "Elevator setpoints: nose down, center, nose up"
    )
    public final List<Integer> elevator() {
        return this.elevator;
    }

    /**
     * Rudder setpoints: nose left, center, nose right 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            arraySize = 3,
            description = "Rudder setpoints: nose left, center, nose right"
    )
    public final List<Integer> rudder() {
        return this.rudder;
    }

    /**
     * Tail gyro mode/gain setpoints: heading hold, rate mode 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            arraySize = 2,
            description = "Tail gyro mode/gain setpoints: heading hold, rate mode"
    )
    public final List<Integer> gyro() {
        return this.gyro;
    }

    /**
     * Pitch curve setpoints (every 25%) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            arraySize = 5,
            description = "Pitch curve setpoints (every 25%)"
    )
    public final List<Integer> pitch() {
        return this.pitch;
    }

    /**
     * Throttle curve setpoints (every 25%) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            arraySize = 5,
            description = "Throttle curve setpoints (every 25%)"
    )
    public final List<Integer> throttle() {
        return this.throttle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        RadioCalibration other = (RadioCalibration)o;
        if (!Objects.deepEquals(aileron, other.aileron)) return false;
        if (!Objects.deepEquals(elevator, other.elevator)) return false;
        if (!Objects.deepEquals(rudder, other.rudder)) return false;
        if (!Objects.deepEquals(gyro, other.gyro)) return false;
        if (!Objects.deepEquals(pitch, other.pitch)) return false;
        if (!Objects.deepEquals(throttle, other.throttle)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(aileron);
        result = 31 * result + Objects.hashCode(elevator);
        result = 31 * result + Objects.hashCode(rudder);
        result = 31 * result + Objects.hashCode(gyro);
        result = 31 * result + Objects.hashCode(pitch);
        result = 31 * result + Objects.hashCode(throttle);
        return result;
    }

    @Override
    public String toString() {
        return "RadioCalibration{aileron=" + aileron
                 + ", elevator=" + elevator
                 + ", rudder=" + rudder
                 + ", gyro=" + gyro
                 + ", pitch=" + pitch
                 + ", throttle=" + throttle + "}";
    }

    public static final class Builder {
        private List<Integer> aileron;

        private List<Integer> elevator;

        private List<Integer> rudder;

        private List<Integer> gyro;

        private List<Integer> pitch;

        private List<Integer> throttle;

        /**
         * Aileron setpoints: left, center, right 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2,
                arraySize = 3,
                description = "Aileron setpoints: left, center, right"
        )
        public final Builder aileron(List<Integer> aileron) {
            this.aileron = aileron;
            return this;
        }

        /**
         * Elevator setpoints: nose down, center, nose up 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                arraySize = 3,
                description = "Elevator setpoints: nose down, center, nose up"
        )
        public final Builder elevator(List<Integer> elevator) {
            this.elevator = elevator;
            return this;
        }

        /**
         * Rudder setpoints: nose left, center, nose right 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                arraySize = 3,
                description = "Rudder setpoints: nose left, center, nose right"
        )
        public final Builder rudder(List<Integer> rudder) {
            this.rudder = rudder;
            return this;
        }

        /**
         * Tail gyro mode/gain setpoints: heading hold, rate mode 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                arraySize = 2,
                description = "Tail gyro mode/gain setpoints: heading hold, rate mode"
        )
        public final Builder gyro(List<Integer> gyro) {
            this.gyro = gyro;
            return this;
        }

        /**
         * Pitch curve setpoints (every 25%) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                arraySize = 5,
                description = "Pitch curve setpoints (every 25%)"
        )
        public final Builder pitch(List<Integer> pitch) {
            this.pitch = pitch;
            return this;
        }

        /**
         * Throttle curve setpoints (every 25%) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                arraySize = 5,
                description = "Throttle curve setpoints (every 25%)"
        )
        public final Builder throttle(List<Integer> throttle) {
            this.throttle = throttle;
            return this;
        }

        public final RadioCalibration build() {
            return new RadioCalibration(aileron, elevator, rudder, gyro, pitch, throttle);
        }
    }
}
