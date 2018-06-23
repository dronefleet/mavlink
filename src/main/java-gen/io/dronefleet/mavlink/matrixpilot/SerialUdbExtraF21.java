package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F21 format 
 */
@MavlinkMessageInfo(
        id = 187,
        crc = 134
)
public final class SerialUdbExtraF21 {
    /**
     * SUE X accelerometer offset 
     */
    private final int sueAccelXOffset;

    /**
     * SUE Y accelerometer offset 
     */
    private final int sueAccelYOffset;

    /**
     * SUE Z accelerometer offset 
     */
    private final int sueAccelZOffset;

    /**
     * SUE X gyro offset 
     */
    private final int sueGyroXOffset;

    /**
     * SUE Y gyro offset 
     */
    private final int sueGyroYOffset;

    /**
     * SUE Z gyro offset 
     */
    private final int sueGyroZOffset;

    private SerialUdbExtraF21(int sueAccelXOffset, int sueAccelYOffset, int sueAccelZOffset,
            int sueGyroXOffset, int sueGyroYOffset, int sueGyroZOffset) {
        this.sueAccelXOffset = sueAccelXOffset;
        this.sueAccelYOffset = sueAccelYOffset;
        this.sueAccelZOffset = sueAccelZOffset;
        this.sueGyroXOffset = sueGyroXOffset;
        this.sueGyroYOffset = sueGyroYOffset;
        this.sueGyroZOffset = sueGyroZOffset;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "SerialUdbExtraF21{sueAccelXOffset=" + sueAccelXOffset
                 + ", sueAccelYOffset=" + sueAccelYOffset
                 + ", sueAccelZOffset=" + sueAccelZOffset
                 + ", sueGyroXOffset=" + sueGyroXOffset
                 + ", sueGyroYOffset=" + sueGyroYOffset
                 + ", sueGyroZOffset=" + sueGyroZOffset + "}";
    }

    /**
     * SUE X accelerometer offset 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2,
            signed = true
    )
    public final int sueAccelXOffset() {
        return sueAccelXOffset;
    }

    /**
     * SUE Y accelerometer offset 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            signed = true
    )
    public final int sueAccelYOffset() {
        return sueAccelYOffset;
    }

    /**
     * SUE Z accelerometer offset 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true
    )
    public final int sueAccelZOffset() {
        return sueAccelZOffset;
    }

    /**
     * SUE X gyro offset 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true
    )
    public final int sueGyroXOffset() {
        return sueGyroXOffset;
    }

    /**
     * SUE Y gyro offset 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            signed = true
    )
    public final int sueGyroYOffset() {
        return sueGyroYOffset;
    }

    /**
     * SUE Z gyro offset 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            signed = true
    )
    public final int sueGyroZOffset() {
        return sueGyroZOffset;
    }

    public static class Builder {
        private int sueAccelXOffset;

        private int sueAccelYOffset;

        private int sueAccelZOffset;

        private int sueGyroXOffset;

        private int sueGyroYOffset;

        private int sueGyroZOffset;

        private Builder() {
        }

        /**
         * SUE X accelerometer offset 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2,
                signed = true
        )
        public final Builder sueAccelXOffset(int sueAccelXOffset) {
            this.sueAccelXOffset = sueAccelXOffset;
            return this;
        }

        /**
         * SUE Y accelerometer offset 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                signed = true
        )
        public final Builder sueAccelYOffset(int sueAccelYOffset) {
            this.sueAccelYOffset = sueAccelYOffset;
            return this;
        }

        /**
         * SUE Z accelerometer offset 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true
        )
        public final Builder sueAccelZOffset(int sueAccelZOffset) {
            this.sueAccelZOffset = sueAccelZOffset;
            return this;
        }

        /**
         * SUE X gyro offset 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true
        )
        public final Builder sueGyroXOffset(int sueGyroXOffset) {
            this.sueGyroXOffset = sueGyroXOffset;
            return this;
        }

        /**
         * SUE Y gyro offset 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                signed = true
        )
        public final Builder sueGyroYOffset(int sueGyroYOffset) {
            this.sueGyroYOffset = sueGyroYOffset;
            return this;
        }

        /**
         * SUE Z gyro offset 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                signed = true
        )
        public final Builder sueGyroZOffset(int sueGyroZOffset) {
            this.sueGyroZOffset = sueGyroZOffset;
            return this;
        }

        public final SerialUdbExtraF21 build() {
            return new SerialUdbExtraF21(sueAccelXOffset, sueAccelYOffset, sueAccelZOffset, sueGyroXOffset, sueGyroYOffset, sueGyroZOffset);
        }
    }
}
