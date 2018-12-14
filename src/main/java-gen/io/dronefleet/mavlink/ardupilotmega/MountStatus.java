package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Message with some status from APM to GCS about camera or antenna mount. 
 */
@MavlinkMessageInfo(
        id = 158,
        crc = 134,
        description = "Message with some status from APM to GCS about camera or antenna mount."
)
public final class MountStatus {
    private final int targetSystem;

    private final int targetComponent;

    private final int pointingA;

    private final int pointingB;

    private final int pointingC;

    private MountStatus(int targetSystem, int targetComponent, int pointingA, int pointingB,
            int pointingC) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.pointingA = pointingA;
        this.pointingB = pointingB;
        this.pointingC = pointingC;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "System ID."
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID."
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Pitch. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true,
            description = "Pitch."
    )
    public final int pointingA() {
        return this.pointingA;
    }

    /**
     * Roll. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true,
            description = "Roll."
    )
    public final int pointingB() {
        return this.pointingB;
    }

    /**
     * Yaw. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "Yaw."
    )
    public final int pointingC() {
        return this.pointingC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        MountStatus other = (MountStatus)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(pointingA, other.pointingA)) return false;
        if (!Objects.deepEquals(pointingB, other.pointingB)) return false;
        if (!Objects.deepEquals(pointingC, other.pointingC)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(pointingA);
        result = 31 * result + Objects.hashCode(pointingB);
        result = 31 * result + Objects.hashCode(pointingC);
        return result;
    }

    @Override
    public String toString() {
        return "MountStatus{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", pointingA=" + pointingA
                 + ", pointingB=" + pointingB
                 + ", pointingC=" + pointingC + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int pointingA;

        private int pointingB;

        private int pointingC;

        /**
         * System ID. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "System ID."
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Component ID."
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Pitch. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true,
                description = "Pitch."
        )
        public final Builder pointingA(int pointingA) {
            this.pointingA = pointingA;
            return this;
        }

        /**
         * Roll. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true,
                description = "Roll."
        )
        public final Builder pointingB(int pointingB) {
            this.pointingB = pointingB;
            return this;
        }

        /**
         * Yaw. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "Yaw."
        )
        public final Builder pointingC(int pointingC) {
            this.pointingC = pointingC;
            return this;
        }

        public final MountStatus build() {
            return new MountStatus(targetSystem, targetComponent, pointingA, pointingB, pointingC);
        }
    }
}
