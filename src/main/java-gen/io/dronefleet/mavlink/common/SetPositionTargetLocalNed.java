package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Sets a desired vehicle position in a local north-east-down coordinate frame. Used by an 
 * external controller to command the vehicle (manual controller or other system). 
 */
@MavlinkMessageInfo(
        id = 84,
        crc = 143
)
public final class SetPositionTargetLocalNed {
    private final long timeBootMs;

    private final int targetSystem;

    private final int targetComponent;

    private final MavFrame coordinateFrame;

    private final int typeMask;

    private final float x;

    private final float y;

    private final float z;

    private final float vx;

    private final float vy;

    private final float vz;

    private final float afx;

    private final float afy;

    private final float afz;

    private final float yaw;

    private final float yawRate;

    private SetPositionTargetLocalNed(long timeBootMs, int targetSystem, int targetComponent,
            MavFrame coordinateFrame, int typeMask, float x, float y, float z, float vx, float vy,
            float vz, float afx, float afy, float afz, float yaw, float yawRate) {
        this.timeBootMs = timeBootMs;
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.coordinateFrame = coordinateFrame;
        this.typeMask = typeMask;
        this.x = x;
        this.y = y;
        this.z = z;
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
        this.afx = afx;
        this.afy = afy;
        this.afz = afz;
        this.yaw = yaw;
        this.yawRate = yawRate;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp in milliseconds since system boot 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Valid options are: MAV_FRAME_LOCAL_NED = 1, MAV_FRAME_LOCAL_OFFSET_NED = 7, 
     * MAV_FRAME_BODY_NED = 8, MAV_FRAME_BODY_OFFSET_NED = 9 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final MavFrame coordinateFrame() {
        return this.coordinateFrame;
    }

    /**
     * Bitmask to indicate which dimensions should be ignored by the vehicle: a value of 
     * 0b0000000000000000 or 0b0000001000000000 indicates that none of the setpoint dimensions 
     * should be ignored. If bit 10 is set the floats afx afy afz should be interpreted as force instead 
     * of acceleration. Mapping: bit 1: x, bit 2: y, bit 3: z, bit 4: vx, bit 5: vy, bit 6: vz, bit 7: ax, bit 
     * 8: ay, bit 9: az, bit 10: is force setpoint, bit 11: yaw, bit 12: yaw rate 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2
    )
    public final int typeMask() {
        return this.typeMask;
    }

    /**
     * X Position in NED frame in meters 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float x() {
        return this.x;
    }

    /**
     * Y Position in NED frame in meters 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float y() {
        return this.y;
    }

    /**
     * Z Position in NED frame in meters (note, altitude is negative in NED) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float z() {
        return this.z;
    }

    /**
     * X velocity in NED frame in meter / s 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float vx() {
        return this.vx;
    }

    /**
     * Y velocity in NED frame in meter / s 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4
    )
    public final float vy() {
        return this.vy;
    }

    /**
     * Z velocity in NED frame in meter / s 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4
    )
    public final float vz() {
        return this.vz;
    }

    /**
     * X acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4
    )
    public final float afx() {
        return this.afx;
    }

    /**
     * Y acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4
    )
    public final float afy() {
        return this.afy;
    }

    /**
     * Z acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4
    )
    public final float afz() {
        return this.afz;
    }

    /**
     * yaw setpoint in rad 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 4
    )
    public final float yaw() {
        return this.yaw;
    }

    /**
     * yaw rate setpoint in rad/s 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 4
    )
    public final float yawRate() {
        return this.yawRate;
    }

    public static final class Builder {
        private long timeBootMs;

        private int targetSystem;

        private int targetComponent;

        private MavFrame coordinateFrame;

        private int typeMask;

        private float x;

        private float y;

        private float z;

        private float vx;

        private float vy;

        private float vz;

        private float afx;

        private float afy;

        private float afz;

        private float yaw;

        private float yawRate;

        /**
         * Timestamp in milliseconds since system boot 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Valid options are: MAV_FRAME_LOCAL_NED = 1, MAV_FRAME_LOCAL_OFFSET_NED = 7, 
         * MAV_FRAME_BODY_NED = 8, MAV_FRAME_BODY_OFFSET_NED = 9 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder coordinateFrame(MavFrame coordinateFrame) {
            this.coordinateFrame = coordinateFrame;
            return this;
        }

        /**
         * Bitmask to indicate which dimensions should be ignored by the vehicle: a value of 
         * 0b0000000000000000 or 0b0000001000000000 indicates that none of the setpoint dimensions 
         * should be ignored. If bit 10 is set the floats afx afy afz should be interpreted as force instead 
         * of acceleration. Mapping: bit 1: x, bit 2: y, bit 3: z, bit 4: vx, bit 5: vy, bit 6: vz, bit 7: ax, bit 
         * 8: ay, bit 9: az, bit 10: is force setpoint, bit 11: yaw, bit 12: yaw rate 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2
        )
        public final Builder typeMask(int typeMask) {
            this.typeMask = typeMask;
            return this;
        }

        /**
         * X Position in NED frame in meters 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder x(float x) {
            this.x = x;
            return this;
        }

        /**
         * Y Position in NED frame in meters 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder y(float y) {
            this.y = y;
            return this;
        }

        /**
         * Z Position in NED frame in meters (note, altitude is negative in NED) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder z(float z) {
            this.z = z;
            return this;
        }

        /**
         * X velocity in NED frame in meter / s 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4
        )
        public final Builder vx(float vx) {
            this.vx = vx;
            return this;
        }

        /**
         * Y velocity in NED frame in meter / s 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4
        )
        public final Builder vy(float vy) {
            this.vy = vy;
            return this;
        }

        /**
         * Z velocity in NED frame in meter / s 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4
        )
        public final Builder vz(float vz) {
            this.vz = vz;
            return this;
        }

        /**
         * X acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4
        )
        public final Builder afx(float afx) {
            this.afx = afx;
            return this;
        }

        /**
         * Y acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4
        )
        public final Builder afy(float afy) {
            this.afy = afy;
            return this;
        }

        /**
         * Z acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 4
        )
        public final Builder afz(float afz) {
            this.afz = afz;
            return this;
        }

        /**
         * yaw setpoint in rad 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 4
        )
        public final Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * yaw rate setpoint in rad/s 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 4
        )
        public final Builder yawRate(float yawRate) {
            this.yawRate = yawRate;
            return this;
        }

        public final SetPositionTargetLocalNed build() {
            return new SetPositionTargetLocalNed(timeBootMs, targetSystem, targetComponent, coordinateFrame, typeMask, x, y, z, vx, vy, vz, afx, afy, afz, yaw, yawRate);
        }
    }
}
