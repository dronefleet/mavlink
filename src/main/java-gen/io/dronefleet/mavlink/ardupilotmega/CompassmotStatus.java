package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Status of compassmot calibration. 
 */
@MavlinkMessageInfo(
        id = 177,
        crc = 240,
        description = "Status of compassmot calibration."
)
public final class CompassmotStatus {
    private final int throttle;

    private final float current;

    private final int interference;

    private final float compensationx;

    private final float compensationy;

    private final float compensationz;

    private CompassmotStatus(int throttle, float current, int interference, float compensationx,
            float compensationy, float compensationz) {
        this.throttle = throttle;
        this.current = current;
        this.interference = interference;
        this.compensationx = compensationx;
        this.compensationy = compensationy;
        this.compensationz = compensationz;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Throttle. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2,
            description = "Throttle."
    )
    public final int throttle() {
        return this.throttle;
    }

    /**
     * Current. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Current."
    )
    public final float current() {
        return this.current;
    }

    /**
     * Interference. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "Interference."
    )
    public final int interference() {
        return this.interference;
    }

    /**
     * Motor Compensation X. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Motor Compensation X."
    )
    public final float compensationx() {
        return this.compensationx;
    }

    /**
     * Motor Compensation Y. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Motor Compensation Y."
    )
    public final float compensationy() {
        return this.compensationy;
    }

    /**
     * Motor Compensation Z. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Motor Compensation Z."
    )
    public final float compensationz() {
        return this.compensationz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CompassmotStatus other = (CompassmotStatus)o;
        if (!Objects.deepEquals(throttle, other.throttle)) return false;
        if (!Objects.deepEquals(current, other.current)) return false;
        if (!Objects.deepEquals(interference, other.interference)) return false;
        if (!Objects.deepEquals(compensationx, other.compensationx)) return false;
        if (!Objects.deepEquals(compensationy, other.compensationy)) return false;
        if (!Objects.deepEquals(compensationz, other.compensationz)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(throttle);
        result = 31 * result + Objects.hashCode(current);
        result = 31 * result + Objects.hashCode(interference);
        result = 31 * result + Objects.hashCode(compensationx);
        result = 31 * result + Objects.hashCode(compensationy);
        result = 31 * result + Objects.hashCode(compensationz);
        return result;
    }

    @Override
    public String toString() {
        return "CompassmotStatus{throttle=" + throttle
                 + ", current=" + current
                 + ", interference=" + interference
                 + ", compensationx=" + compensationx
                 + ", compensationy=" + compensationy
                 + ", compensationz=" + compensationz + "}";
    }

    public static final class Builder {
        private int throttle;

        private float current;

        private int interference;

        private float compensationx;

        private float compensationy;

        private float compensationz;

        /**
         * Throttle. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2,
                description = "Throttle."
        )
        public final Builder throttle(int throttle) {
            this.throttle = throttle;
            return this;
        }

        /**
         * Current. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Current."
        )
        public final Builder current(float current) {
            this.current = current;
            return this;
        }

        /**
         * Interference. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "Interference."
        )
        public final Builder interference(int interference) {
            this.interference = interference;
            return this;
        }

        /**
         * Motor Compensation X. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Motor Compensation X."
        )
        public final Builder compensationx(float compensationx) {
            this.compensationx = compensationx;
            return this;
        }

        /**
         * Motor Compensation Y. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Motor Compensation Y."
        )
        public final Builder compensationy(float compensationy) {
            this.compensationy = compensationy;
            return this;
        }

        /**
         * Motor Compensation Z. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Motor Compensation Z."
        )
        public final Builder compensationz(float compensationz) {
            this.compensationz = compensationz;
            return this;
        }

        public final CompassmotStatus build() {
            return new CompassmotStatus(throttle, current, interference, compensationx, compensationy, compensationz);
        }
    }
}
