package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Camera Event 
 */
@MavlinkMessageInfo(
        id = 179,
        crc = 189
)
public final class CameraStatus {
    private final BigInteger timeUsec;

    private final int targetSystem;

    private final int camIdx;

    private final int imgIdx;

    private final EnumValue<CameraStatusTypes> eventId;

    private final float p1;

    private final float p2;

    private final float p3;

    private final float p4;

    private CameraStatus(BigInteger timeUsec, int targetSystem, int camIdx, int imgIdx,
            EnumValue<CameraStatusTypes> eventId, float p1, float p2, float p3, float p4) {
        this.timeUsec = timeUsec;
        this.targetSystem = targetSystem;
        this.camIdx = camIdx;
        this.imgIdx = imgIdx;
        this.eventId = eventId;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Image timestamp (microseconds since UNIX epoch, according to camera clock) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
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
     * Camera ID 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int camIdx() {
        return this.camIdx;
    }

    /**
     * Image index 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2
    )
    public final int imgIdx() {
        return this.imgIdx;
    }

    /**
     * See {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CAMERA_STATUS_TYPES} enum for definition of the bitmask 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            enumType = CameraStatusTypes.class
    )
    public final EnumValue<CameraStatusTypes> eventId() {
        return this.eventId;
    }

    /**
     * Parameter 1 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CAMERA_STATUS_TYPES} enum) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float p1() {
        return this.p1;
    }

    /**
     * Parameter 2 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CAMERA_STATUS_TYPES} enum) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float p2() {
        return this.p2;
    }

    /**
     * Parameter 3 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CAMERA_STATUS_TYPES} enum) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float p3() {
        return this.p3;
    }

    /**
     * Parameter 4 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CAMERA_STATUS_TYPES} enum) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float p4() {
        return this.p4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CameraStatus other = (CameraStatus)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(camIdx, other.camIdx)) return false;
        if (!Objects.deepEquals(imgIdx, other.imgIdx)) return false;
        if (!Objects.deepEquals(eventId, other.eventId)) return false;
        if (!Objects.deepEquals(p1, other.p1)) return false;
        if (!Objects.deepEquals(p2, other.p2)) return false;
        if (!Objects.deepEquals(p3, other.p3)) return false;
        if (!Objects.deepEquals(p4, other.p4)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(camIdx);
        result = 31 * result + Objects.hashCode(imgIdx);
        result = 31 * result + Objects.hashCode(eventId);
        result = 31 * result + Objects.hashCode(p1);
        result = 31 * result + Objects.hashCode(p2);
        result = 31 * result + Objects.hashCode(p3);
        result = 31 * result + Objects.hashCode(p4);
        return result;
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private int targetSystem;

        private int camIdx;

        private int imgIdx;

        private EnumValue<CameraStatusTypes> eventId;

        private float p1;

        private float p2;

        private float p3;

        private float p4;

        /**
         * Image timestamp (microseconds since UNIX epoch, according to camera clock) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
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
         * Camera ID 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder camIdx(int camIdx) {
            this.camIdx = camIdx;
            return this;
        }

        /**
         * Image index 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2
        )
        public final Builder imgIdx(int imgIdx) {
            this.imgIdx = imgIdx;
            return this;
        }

        /**
         * See {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CAMERA_STATUS_TYPES} enum for definition of the bitmask 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                enumType = CameraStatusTypes.class
        )
        public final Builder eventId(EnumValue<CameraStatusTypes> eventId) {
            this.eventId = eventId;
            return this;
        }

        /**
         * See {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CAMERA_STATUS_TYPES} enum for definition of the bitmask 
         */
        public final Builder eventId(CameraStatusTypes entry) {
            this.eventId = EnumValue.of(entry);
            return this;
        }

        /**
         * See {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CAMERA_STATUS_TYPES} enum for definition of the bitmask 
         */
        public final Builder eventId(Enum... flags) {
            this.eventId = EnumValue.create(flags);
            return this;
        }

        /**
         * Parameter 1 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CAMERA_STATUS_TYPES} enum) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder p1(float p1) {
            this.p1 = p1;
            return this;
        }

        /**
         * Parameter 2 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CAMERA_STATUS_TYPES} enum) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder p2(float p2) {
            this.p2 = p2;
            return this;
        }

        /**
         * Parameter 3 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CAMERA_STATUS_TYPES} enum) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder p3(float p3) {
            this.p3 = p3;
            return this;
        }

        /**
         * Parameter 4 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CAMERA_STATUS_TYPES} enum) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4
        )
        public final Builder p4(float p4) {
            this.p4 = p4;
            return this;
        }

        public final CameraStatus build() {
            return new CameraStatus(timeUsec, targetSystem, camIdx, imgIdx, eventId, p1, p2, p3, p4);
        }
    }
}
