package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Message with some status from APM to GCS about camera or antenna mount 
 */
@MavlinkMessageInfo(
        id = 158,
        crc = 134
)
public final class MountStatus {
    /**
     * pitch(deg*100) 
     */
    private final int pointingA;

    /**
     * roll(deg*100) 
     */
    private final int pointingB;

    /**
     * yaw(deg*100) 
     */
    private final int pointingC;

    /**
     * System ID 
     */
    private final int targetSystem;

    /**
     * Component ID 
     */
    private final int targetComponent;

    private MountStatus(int pointingA, int pointingB, int pointingC, int targetSystem,
            int targetComponent) {
        this.pointingA = pointingA;
        this.pointingB = pointingB;
        this.pointingC = pointingC;
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "MountStatus{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", pointingA=" + pointingA
                 + ", pointingB=" + pointingB
                 + ", pointingC=" + pointingC + "}";
    }

    /**
     * pitch(deg*100) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true
    )
    public final int pointingA() {
        return pointingA;
    }

    /**
     * roll(deg*100) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true
    )
    public final int pointingB() {
        return pointingB;
    }

    /**
     * yaw(deg*100) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true
    )
    public final int pointingC() {
        return pointingC;
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int targetSystem() {
        return targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetComponent() {
        return targetComponent;
    }

    public static class Builder {
        private int pointingA;

        private int pointingB;

        private int pointingC;

        private int targetSystem;

        private int targetComponent;

        private Builder() {
        }

        /**
         * pitch(deg*100) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true
        )
        public final Builder pointingA(int pointingA) {
            this.pointingA = pointingA;
            return this;
        }

        /**
         * roll(deg*100) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true
        )
        public final Builder pointingB(int pointingB) {
            this.pointingB = pointingB;
            return this;
        }

        /**
         * yaw(deg*100) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true
        )
        public final Builder pointingC(int pointingC) {
            this.pointingC = pointingC;
            return this;
        }

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 1,
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
                position = 2,
                unitSize = 1
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        public final MountStatus build() {
            return new MountStatus(pointingA, pointingB, pointingC, targetSystem, targetComponent);
        }
    }
}
