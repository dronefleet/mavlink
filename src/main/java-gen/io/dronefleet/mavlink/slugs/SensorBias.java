package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Accelerometer and gyro biases. 
 */
@MavlinkMessageInfo(
        id = 172,
        crc = 168,
        description = "Accelerometer and gyro biases."
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
            unitSize = 4,
            description = "Accelerometer X bias"
    )
    public final float axbias() {
        return this.axbias;
    }

    /**
     * Accelerometer Y bias 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Accelerometer Y bias"
    )
    public final float aybias() {
        return this.aybias;
    }

    /**
     * Accelerometer Z bias 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Accelerometer Z bias"
    )
    public final float azbias() {
        return this.azbias;
    }

    /**
     * Gyro X bias 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Gyro X bias"
    )
    public final float gxbias() {
        return this.gxbias;
    }

    /**
     * Gyro Y bias 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Gyro Y bias"
    )
    public final float gybias() {
        return this.gybias;
    }

    /**
     * Gyro Z bias 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Gyro Z bias"
    )
    public final float gzbias() {
        return this.gzbias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SensorBias other = (SensorBias)o;
        if (!Objects.deepEquals(axbias, other.axbias)) return false;
        if (!Objects.deepEquals(aybias, other.aybias)) return false;
        if (!Objects.deepEquals(azbias, other.azbias)) return false;
        if (!Objects.deepEquals(gxbias, other.gxbias)) return false;
        if (!Objects.deepEquals(gybias, other.gybias)) return false;
        if (!Objects.deepEquals(gzbias, other.gzbias)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(axbias);
        result = 31 * result + Objects.hashCode(aybias);
        result = 31 * result + Objects.hashCode(azbias);
        result = 31 * result + Objects.hashCode(gxbias);
        result = 31 * result + Objects.hashCode(gybias);
        result = 31 * result + Objects.hashCode(gzbias);
        return result;
    }

    @Override
    public String toString() {
        return "SensorBias{axbias=" + axbias
                 + ", aybias=" + aybias
                 + ", azbias=" + azbias
                 + ", gxbias=" + gxbias
                 + ", gybias=" + gybias
                 + ", gzbias=" + gzbias + "}";
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
                unitSize = 4,
                description = "Accelerometer X bias"
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
                unitSize = 4,
                description = "Accelerometer Y bias"
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
                unitSize = 4,
                description = "Accelerometer Z bias"
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
                unitSize = 4,
                description = "Gyro X bias"
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
                unitSize = 4,
                description = "Gyro Y bias"
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
                unitSize = 4,
                description = "Gyro Z bias"
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
