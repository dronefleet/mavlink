package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Offsets and calibrations values for hardware sensors. This makes it easier to debug the 
 * calibration process. 
 */
@MavlinkMessageInfo(
        id = 150,
        crc = 134
)
public final class SensorOffsets {
    private final int magOfsX;

    private final int magOfsY;

    private final int magOfsZ;

    private final float magDeclination;

    private final int rawPress;

    private final int rawTemp;

    private final float gyroCalX;

    private final float gyroCalY;

    private final float gyroCalZ;

    private final float accelCalX;

    private final float accelCalY;

    private final float accelCalZ;

    private SensorOffsets(int magOfsX, int magOfsY, int magOfsZ, float magDeclination, int rawPress,
            int rawTemp, float gyroCalX, float gyroCalY, float gyroCalZ, float accelCalX,
            float accelCalY, float accelCalZ) {
        this.magOfsX = magOfsX;
        this.magOfsY = magOfsY;
        this.magOfsZ = magOfsZ;
        this.magDeclination = magDeclination;
        this.rawPress = rawPress;
        this.rawTemp = rawTemp;
        this.gyroCalX = gyroCalX;
        this.gyroCalY = gyroCalY;
        this.gyroCalZ = gyroCalZ;
        this.accelCalX = accelCalX;
        this.accelCalY = accelCalY;
        this.accelCalZ = accelCalZ;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * magnetometer X offset 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2,
            signed = true
    )
    public final int magOfsX() {
        return this.magOfsX;
    }

    /**
     * magnetometer Y offset 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            signed = true
    )
    public final int magOfsY() {
        return this.magOfsY;
    }

    /**
     * magnetometer Z offset 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true
    )
    public final int magOfsZ() {
        return this.magOfsZ;
    }

    /**
     * magnetic declination (radians) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float magDeclination() {
        return this.magDeclination;
    }

    /**
     * raw pressure from barometer 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true
    )
    public final int rawPress() {
        return this.rawPress;
    }

    /**
     * raw temperature from barometer 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            signed = true
    )
    public final int rawTemp() {
        return this.rawTemp;
    }

    /**
     * gyro X calibration 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float gyroCalX() {
        return this.gyroCalX;
    }

    /**
     * gyro Y calibration 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float gyroCalY() {
        return this.gyroCalY;
    }

    /**
     * gyro Z calibration 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float gyroCalZ() {
        return this.gyroCalZ;
    }

    /**
     * accel X calibration 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4
    )
    public final float accelCalX() {
        return this.accelCalX;
    }

    /**
     * accel Y calibration 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4
    )
    public final float accelCalY() {
        return this.accelCalY;
    }

    /**
     * accel Z calibration 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4
    )
    public final float accelCalZ() {
        return this.accelCalZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SensorOffsets other = (SensorOffsets)o;
        if (!Objects.deepEquals(magOfsX, other.magOfsX)) return false;
        if (!Objects.deepEquals(magOfsY, other.magOfsY)) return false;
        if (!Objects.deepEquals(magOfsZ, other.magOfsZ)) return false;
        if (!Objects.deepEquals(magDeclination, other.magDeclination)) return false;
        if (!Objects.deepEquals(rawPress, other.rawPress)) return false;
        if (!Objects.deepEquals(rawTemp, other.rawTemp)) return false;
        if (!Objects.deepEquals(gyroCalX, other.gyroCalX)) return false;
        if (!Objects.deepEquals(gyroCalY, other.gyroCalY)) return false;
        if (!Objects.deepEquals(gyroCalZ, other.gyroCalZ)) return false;
        if (!Objects.deepEquals(accelCalX, other.accelCalX)) return false;
        if (!Objects.deepEquals(accelCalY, other.accelCalY)) return false;
        if (!Objects.deepEquals(accelCalZ, other.accelCalZ)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(magOfsX);
        result = 31 * result + Objects.hashCode(magOfsY);
        result = 31 * result + Objects.hashCode(magOfsZ);
        result = 31 * result + Objects.hashCode(magDeclination);
        result = 31 * result + Objects.hashCode(rawPress);
        result = 31 * result + Objects.hashCode(rawTemp);
        result = 31 * result + Objects.hashCode(gyroCalX);
        result = 31 * result + Objects.hashCode(gyroCalY);
        result = 31 * result + Objects.hashCode(gyroCalZ);
        result = 31 * result + Objects.hashCode(accelCalX);
        result = 31 * result + Objects.hashCode(accelCalY);
        result = 31 * result + Objects.hashCode(accelCalZ);
        return result;
    }

    @Override
    public String toString() {
        return "SensorOffsets{magOfsX=" + magOfsX
                 + ", magOfsY=" + magOfsY
                 + ", magOfsZ=" + magOfsZ
                 + ", magDeclination=" + magDeclination
                 + ", rawPress=" + rawPress
                 + ", rawTemp=" + rawTemp
                 + ", gyroCalX=" + gyroCalX
                 + ", gyroCalY=" + gyroCalY
                 + ", gyroCalZ=" + gyroCalZ
                 + ", accelCalX=" + accelCalX
                 + ", accelCalY=" + accelCalY
                 + ", accelCalZ=" + accelCalZ + "}";
    }

    public static final class Builder {
        private int magOfsX;

        private int magOfsY;

        private int magOfsZ;

        private float magDeclination;

        private int rawPress;

        private int rawTemp;

        private float gyroCalX;

        private float gyroCalY;

        private float gyroCalZ;

        private float accelCalX;

        private float accelCalY;

        private float accelCalZ;

        /**
         * magnetometer X offset 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2,
                signed = true
        )
        public final Builder magOfsX(int magOfsX) {
            this.magOfsX = magOfsX;
            return this;
        }

        /**
         * magnetometer Y offset 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                signed = true
        )
        public final Builder magOfsY(int magOfsY) {
            this.magOfsY = magOfsY;
            return this;
        }

        /**
         * magnetometer Z offset 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true
        )
        public final Builder magOfsZ(int magOfsZ) {
            this.magOfsZ = magOfsZ;
            return this;
        }

        /**
         * magnetic declination (radians) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder magDeclination(float magDeclination) {
            this.magDeclination = magDeclination;
            return this;
        }

        /**
         * raw pressure from barometer 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true
        )
        public final Builder rawPress(int rawPress) {
            this.rawPress = rawPress;
            return this;
        }

        /**
         * raw temperature from barometer 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                signed = true
        )
        public final Builder rawTemp(int rawTemp) {
            this.rawTemp = rawTemp;
            return this;
        }

        /**
         * gyro X calibration 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder gyroCalX(float gyroCalX) {
            this.gyroCalX = gyroCalX;
            return this;
        }

        /**
         * gyro Y calibration 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder gyroCalY(float gyroCalY) {
            this.gyroCalY = gyroCalY;
            return this;
        }

        /**
         * gyro Z calibration 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4
        )
        public final Builder gyroCalZ(float gyroCalZ) {
            this.gyroCalZ = gyroCalZ;
            return this;
        }

        /**
         * accel X calibration 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4
        )
        public final Builder accelCalX(float accelCalX) {
            this.accelCalX = accelCalX;
            return this;
        }

        /**
         * accel Y calibration 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4
        )
        public final Builder accelCalY(float accelCalY) {
            this.accelCalY = accelCalY;
            return this;
        }

        /**
         * accel Z calibration 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4
        )
        public final Builder accelCalZ(float accelCalZ) {
            this.accelCalZ = accelCalZ;
            return this;
        }

        public final SensorOffsets build() {
            return new SensorOffsets(magOfsX, magOfsY, magOfsZ, magDeclination, rawPress, rawTemp, gyroCalX, gyroCalY, gyroCalZ, accelCalX, accelCalY, accelCalZ);
        }
    }
}
