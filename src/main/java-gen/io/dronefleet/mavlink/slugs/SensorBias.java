package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Accelerometer and gyro biases. 
 */
@MavlinkMessageInfo(
        id = 172,
        crc = 168
)
public final class SensorBias {
    private final float axbias;

    private final float aybias;

    private final float azbias;

    private final float gxbias;

    private final float gybias;

    private final float gzbias;

    private SensorBias(float axbias, float aybias, float azbias, float gxbias, float gybias,
            float gzbias) {
        this.axbias = axbias;
        this.aybias = aybias;
        this.azbias = azbias;
        this.gxbias = gxbias;
        this.gybias = gybias;
        this.gzbias = gzbias;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Accelerometer X bias 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final float axbias() {
        return this.axbias;
    }

    /**
     * Accelerometer Y bias 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float aybias() {
        return this.aybias;
    }

    /**
     * Accelerometer Z bias 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float azbias() {
        return this.azbias;
    }

    /**
     * Gyro X bias 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float gxbias() {
        return this.gxbias;
    }

    /**
     * Gyro Y bias 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float gybias() {
        return this.gybias;
    }

    /**
     * Gyro Z bias 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float gzbias() {
        return this.gzbias;
    }

    public static final class Builder {
        private float axbias;

        private float aybias;

        private float azbias;

        private float gxbias;

        private float gybias;

        private float gzbias;

        /**
         * Accelerometer X bias 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder axbias(float axbias) {
            this.axbias = axbias;
            return this;
        }

        /**
         * Accelerometer Y bias 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder aybias(float aybias) {
            this.aybias = aybias;
            return this;
        }

        /**
         * Accelerometer Z bias 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder azbias(float azbias) {
            this.azbias = azbias;
            return this;
        }

        /**
         * Gyro X bias 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder gxbias(float gxbias) {
            this.gxbias = gxbias;
            return this;
        }

        /**
         * Gyro Y bias 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder gybias(float gybias) {
            this.gybias = gybias;
            return this;
        }

        /**
         * Gyro Z bias 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder gzbias(float gzbias) {
            this.gzbias = gzbias;
            return this;
        }

        public final SensorBias build() {
            return new SensorBias(axbias, aybias, azbias, gxbias, gybias, gzbias);
        }
    }
}
