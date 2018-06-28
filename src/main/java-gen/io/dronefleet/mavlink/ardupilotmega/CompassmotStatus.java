package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Status of compassmot calibration 
 */
@MavlinkMessageInfo(
        id = 177,
        crc = 240
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
     * throttle (percent*10) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2
    )
    public final int throttle() {
        return this.throttle;
    }

    /**
     * current (Ampere) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float current() {
        return this.current;
    }

    /**
     * interference (percent) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int interference() {
        return this.interference;
    }

    /**
     * Motor Compensation X 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float compensationx() {
        return this.compensationx;
    }

    /**
     * Motor Compensation Y 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float compensationy() {
        return this.compensationy;
    }

    /**
     * Motor Compensation Z 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float compensationz() {
        return this.compensationz;
    }

    public static final class Builder {
        private int throttle;

        private float current;

        private int interference;

        private float compensationx;

        private float compensationy;

        private float compensationz;

        /**
         * throttle (percent*10) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2
        )
        public final Builder throttle(int throttle) {
            this.throttle = throttle;
            return this;
        }

        /**
         * current (Ampere) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder current(float current) {
            this.current = current;
            return this;
        }

        /**
         * interference (percent) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2
        )
        public final Builder interference(int interference) {
            this.interference = interference;
            return this;
        }

        /**
         * Motor Compensation X 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder compensationx(float compensationx) {
            this.compensationx = compensationx;
            return this;
        }

        /**
         * Motor Compensation Y 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder compensationy(float compensationy) {
            this.compensationy = compensationy;
            return this;
        }

        /**
         * Motor Compensation Z 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
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
