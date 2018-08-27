package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Set a safety zone (volume), which is defined by two corners of a cube. This message can be used to 
 * tell the MAV which setpoints/waypoints to accept and which to reject. Safety areas are often 
 * enforced by national or competition regulations. 
 */
@MavlinkMessageInfo(
        id = 54,
        crc = 15
)
public final class SafetySetAllowedArea {
    private final int targetSystem;

    private final int targetComponent;

    private final EnumValue<MavFrame> frame;

    private final float p1x;

    private final float p1y;

    private final float p1z;

    private final float p2x;

    private final float p2y;

    private final float p2z;

    private SafetySetAllowedArea(int targetSystem, int targetComponent, EnumValue<MavFrame> frame,
            float p1x, float p1y, float p1z, float p2x, float p2y, float p2z) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.frame = frame;
        this.p1x = p1x;
        this.p1y = p1y;
        this.p1z = p1z;
        this.p2x = p2x;
        this.p2y = p2y;
        this.p2z = p2z;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Coordinate frame, as defined by {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} enum. Can be either global, GPS, right-handed with Z 
     * axis up or local, right handed, Z axis down. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = MavFrame.class
    )
    public final EnumValue<MavFrame> frame() {
        return this.frame;
    }

    /**
     * x position 1 / Latitude 1 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float p1x() {
        return this.p1x;
    }

    /**
     * y position 1 / Longitude 1 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float p1y() {
        return this.p1y;
    }

    /**
     * z position 1 / Altitude 1 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float p1z() {
        return this.p1z;
    }

    /**
     * x position 2 / Latitude 2 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float p2x() {
        return this.p2x;
    }

    /**
     * y position 2 / Longitude 2 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float p2y() {
        return this.p2y;
    }

    /**
     * z position 2 / Altitude 2 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float p2z() {
        return this.p2z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SafetySetAllowedArea other = (SafetySetAllowedArea)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(frame, other.frame)) return false;
        if (!Objects.deepEquals(p1x, other.p1x)) return false;
        if (!Objects.deepEquals(p1y, other.p1y)) return false;
        if (!Objects.deepEquals(p1z, other.p1z)) return false;
        if (!Objects.deepEquals(p2x, other.p2x)) return false;
        if (!Objects.deepEquals(p2y, other.p2y)) return false;
        if (!Objects.deepEquals(p2z, other.p2z)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(frame);
        result = 31 * result + Objects.hashCode(p1x);
        result = 31 * result + Objects.hashCode(p1y);
        result = 31 * result + Objects.hashCode(p1z);
        result = 31 * result + Objects.hashCode(p2x);
        result = 31 * result + Objects.hashCode(p2y);
        result = 31 * result + Objects.hashCode(p2z);
        return result;
    }

    @Override
    public String toString() {
        return "SafetySetAllowedArea{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", frame=" + frame
                 + ", p1x=" + p1x
                 + ", p1y=" + p1y
                 + ", p1z=" + p1z
                 + ", p2x=" + p2x
                 + ", p2y=" + p2y
                 + ", p2z=" + p2z + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private EnumValue<MavFrame> frame;

        private float p1x;

        private float p1y;

        private float p1z;

        private float p2x;

        private float p2y;

        private float p2z;

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

        /**
         * Coordinate frame, as defined by {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} enum. Can be either global, GPS, right-handed with Z 
         * axis up or local, right handed, Z axis down. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = MavFrame.class
        )
        public final Builder frame(EnumValue<MavFrame> frame) {
            this.frame = frame;
            return this;
        }

        /**
         * Coordinate frame, as defined by {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} enum. Can be either global, GPS, right-handed with Z 
         * axis up or local, right handed, Z axis down. 
         */
        public final Builder frame(MavFrame entry) {
            this.frame = EnumValue.of(entry);
            return this;
        }

        /**
         * Coordinate frame, as defined by {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} enum. Can be either global, GPS, right-handed with Z 
         * axis up or local, right handed, Z axis down. 
         */
        public final Builder frame(Enum... flags) {
            this.frame = EnumValue.create(flags);
            return this;
        }

        /**
         * x position 1 / Latitude 1 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder p1x(float p1x) {
            this.p1x = p1x;
            return this;
        }

        /**
         * y position 1 / Longitude 1 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder p1y(float p1y) {
            this.p1y = p1y;
            return this;
        }

        /**
         * z position 1 / Altitude 1 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder p1z(float p1z) {
            this.p1z = p1z;
            return this;
        }

        /**
         * x position 2 / Latitude 2 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder p2x(float p2x) {
            this.p2x = p2x;
            return this;
        }

        /**
         * y position 2 / Longitude 2 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder p2y(float p2y) {
            this.p2y = p2y;
            return this;
        }

        /**
         * z position 2 / Altitude 2 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4
        )
        public final Builder p2z(float p2z) {
            this.p2z = p2z;
            return this;
        }

        public final SafetySetAllowedArea build() {
            return new SafetySetAllowedArea(targetSystem, targetComponent, frame, p1x, p1y, p1z, p2x, p2y, p2z);
        }
    }
}
