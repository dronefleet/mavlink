package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F22 format 
 */
@MavlinkMessageInfo(
        id = 188,
        crc = 91
)
public final class SerialUdbExtraF22 {
    private final int sueAccelXAtCalibration;

    private final int sueAccelYAtCalibration;

    private final int sueAccelZAtCalibration;

    private final int sueGyroXAtCalibration;

    private final int sueGyroYAtCalibration;

    private final int sueGyroZAtCalibration;

    private SerialUdbExtraF22(int sueAccelXAtCalibration, int sueAccelYAtCalibration,
            int sueAccelZAtCalibration, int sueGyroXAtCalibration, int sueGyroYAtCalibration,
            int sueGyroZAtCalibration) {
        this.sueAccelXAtCalibration = sueAccelXAtCalibration;
        this.sueAccelYAtCalibration = sueAccelYAtCalibration;
        this.sueAccelZAtCalibration = sueAccelZAtCalibration;
        this.sueGyroXAtCalibration = sueGyroXAtCalibration;
        this.sueGyroYAtCalibration = sueGyroYAtCalibration;
        this.sueGyroZAtCalibration = sueGyroZAtCalibration;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * SUE X accelerometer at calibration time 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2,
            signed = true
    )
    public final int sueAccelXAtCalibration() {
        return this.sueAccelXAtCalibration;
    }

    /**
     * SUE Y accelerometer at calibration time 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            signed = true
    )
    public final int sueAccelYAtCalibration() {
        return this.sueAccelYAtCalibration;
    }

    /**
     * SUE Z accelerometer at calibration time 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true
    )
    public final int sueAccelZAtCalibration() {
        return this.sueAccelZAtCalibration;
    }

    /**
     * SUE X gyro at calibration time 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true
    )
    public final int sueGyroXAtCalibration() {
        return this.sueGyroXAtCalibration;
    }

    /**
     * SUE Y gyro at calibration time 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            signed = true
    )
    public final int sueGyroYAtCalibration() {
        return this.sueGyroYAtCalibration;
    }

    /**
     * SUE Z gyro at calibration time 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            signed = true
    )
    public final int sueGyroZAtCalibration() {
        return this.sueGyroZAtCalibration;
    }

    public static final class Builder {
        private int sueAccelXAtCalibration;

        private int sueAccelYAtCalibration;

        private int sueAccelZAtCalibration;

        private int sueGyroXAtCalibration;

        private int sueGyroYAtCalibration;

        private int sueGyroZAtCalibration;

        /**
         * SUE X accelerometer at calibration time 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2,
                signed = true
        )
        public final Builder sueAccelXAtCalibration(int sueAccelXAtCalibration) {
            this.sueAccelXAtCalibration = sueAccelXAtCalibration;
            return this;
        }

        /**
         * SUE Y accelerometer at calibration time 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                signed = true
        )
        public final Builder sueAccelYAtCalibration(int sueAccelYAtCalibration) {
            this.sueAccelYAtCalibration = sueAccelYAtCalibration;
            return this;
        }

        /**
         * SUE Z accelerometer at calibration time 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true
        )
        public final Builder sueAccelZAtCalibration(int sueAccelZAtCalibration) {
            this.sueAccelZAtCalibration = sueAccelZAtCalibration;
            return this;
        }

        /**
         * SUE X gyro at calibration time 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true
        )
        public final Builder sueGyroXAtCalibration(int sueGyroXAtCalibration) {
            this.sueGyroXAtCalibration = sueGyroXAtCalibration;
            return this;
        }

        /**
         * SUE Y gyro at calibration time 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                signed = true
        )
        public final Builder sueGyroYAtCalibration(int sueGyroYAtCalibration) {
            this.sueGyroYAtCalibration = sueGyroYAtCalibration;
            return this;
        }

        /**
         * SUE Z gyro at calibration time 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                signed = true
        )
        public final Builder sueGyroZAtCalibration(int sueGyroZAtCalibration) {
            this.sueGyroZAtCalibration = sueGyroZAtCalibration;
            return this;
        }

        public final SerialUdbExtraF22 build() {
            return new SerialUdbExtraF22(sueAccelXAtCalibration, sueAccelYAtCalibration, sueAccelZAtCalibration, sueGyroXAtCalibration, sueGyroYAtCalibration, sueGyroZAtCalibration);
        }
    }
}
