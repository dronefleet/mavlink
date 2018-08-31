package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * This message provides an API for manually controlling the vehicle using standard joystick 
 * axes nomenclature, along with a joystick-like input device. Unused axes can be disabled an 
 * buttons are also transmit as boolean values of their 
 */
@MavlinkMessageInfo(
        id = 69,
        crc = 243,
        description = "This message provides an API for manually controlling the vehicle using standard joystick axes nomenclature, along with a joystick-like input device. Unused axes can be disabled an buttons are also transmit as boolean values of their"
)
public final class ManualControl {
    private final int target;

    private final int x;

    private final int y;

    private final int z;

    private final int r;

    private final int buttons;

    private ManualControl(int target, int x, int y, int z, int r, int buttons) {
        this.target = target;
        this.x = x;
        this.y = y;
        this.z = z;
        this.r = r;
        this.buttons = buttons;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The system to be controlled. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "The system to be controlled."
    )
    public final int target() {
        return this.target;
    }

    /**
     * X-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is 
     * invalid. Generally corresponds to forward(1000)-backward(-1000) movement on a joystick 
     * and the pitch of a vehicle. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            signed = true,
            description = "X-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is invalid. Generally corresponds to forward(1000)-backward(-1000) movement on a joystick and the pitch of a vehicle."
    )
    public final int x() {
        return this.x;
    }

    /**
     * Y-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is 
     * invalid. Generally corresponds to left(-1000)-right(1000) movement on a joystick and the 
     * roll of a vehicle. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true,
            description = "Y-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is invalid. Generally corresponds to left(-1000)-right(1000) movement on a joystick and the roll of a vehicle."
    )
    public final int y() {
        return this.y;
    }

    /**
     * Z-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is 
     * invalid. Generally corresponds to a separate slider movement with maximum being 1000 and 
     * minimum being -1000 on a joystick and the thrust of a vehicle. Positive values are positive 
     * thrust, negative values are negative thrust. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true,
            description = "Z-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is invalid. Generally corresponds to a separate slider movement with maximum being 1000 and minimum being -1000 on a joystick and the thrust of a vehicle. Positive values are positive thrust, negative values are negative thrust."
    )
    public final int z() {
        return this.z;
    }

    /**
     * R-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is 
     * invalid. Generally corresponds to a twisting of the joystick, with counter-clockwise being 
     * 1000 and clockwise being -1000, and the yaw of a vehicle. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            signed = true,
            description = "R-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is invalid. Generally corresponds to a twisting of the joystick, with counter-clockwise being 1000 and clockwise being -1000, and the yaw of a vehicle."
    )
    public final int r() {
        return this.r;
    }

    /**
     * A bitfield corresponding to the joystick buttons' current state, 1 for pressed, 0 for 
     * released. The lowest bit corresponds to Button 1. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "A bitfield corresponding to the joystick buttons' current state, 1 for pressed, 0 for released. The lowest bit corresponds to Button 1."
    )
    public final int buttons() {
        return this.buttons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ManualControl other = (ManualControl)o;
        if (!Objects.deepEquals(target, other.target)) return false;
        if (!Objects.deepEquals(x, other.x)) return false;
        if (!Objects.deepEquals(y, other.y)) return false;
        if (!Objects.deepEquals(z, other.z)) return false;
        if (!Objects.deepEquals(r, other.r)) return false;
        if (!Objects.deepEquals(buttons, other.buttons)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(target);
        result = 31 * result + Objects.hashCode(x);
        result = 31 * result + Objects.hashCode(y);
        result = 31 * result + Objects.hashCode(z);
        result = 31 * result + Objects.hashCode(r);
        result = 31 * result + Objects.hashCode(buttons);
        return result;
    }

    @Override
    public String toString() {
        return "ManualControl{target=" + target
                 + ", x=" + x
                 + ", y=" + y
                 + ", z=" + z
                 + ", r=" + r
                 + ", buttons=" + buttons + "}";
    }

    public static final class Builder {
        private int target;

        private int x;

        private int y;

        private int z;

        private int r;

        private int buttons;

        /**
         * The system to be controlled. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "The system to be controlled."
        )
        public final Builder target(int target) {
            this.target = target;
            return this;
        }

        /**
         * X-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is 
         * invalid. Generally corresponds to forward(1000)-backward(-1000) movement on a joystick 
         * and the pitch of a vehicle. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                signed = true,
                description = "X-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is invalid. Generally corresponds to forward(1000)-backward(-1000) movement on a joystick and the pitch of a vehicle."
        )
        public final Builder x(int x) {
            this.x = x;
            return this;
        }

        /**
         * Y-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is 
         * invalid. Generally corresponds to left(-1000)-right(1000) movement on a joystick and the 
         * roll of a vehicle. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true,
                description = "Y-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is invalid. Generally corresponds to left(-1000)-right(1000) movement on a joystick and the roll of a vehicle."
        )
        public final Builder y(int y) {
            this.y = y;
            return this;
        }

        /**
         * Z-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is 
         * invalid. Generally corresponds to a separate slider movement with maximum being 1000 and 
         * minimum being -1000 on a joystick and the thrust of a vehicle. Positive values are positive 
         * thrust, negative values are negative thrust. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true,
                description = "Z-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is invalid. Generally corresponds to a separate slider movement with maximum being 1000 and minimum being -1000 on a joystick and the thrust of a vehicle. Positive values are positive thrust, negative values are negative thrust."
        )
        public final Builder z(int z) {
            this.z = z;
            return this;
        }

        /**
         * R-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is 
         * invalid. Generally corresponds to a twisting of the joystick, with counter-clockwise being 
         * 1000 and clockwise being -1000, and the yaw of a vehicle. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                signed = true,
                description = "R-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is invalid. Generally corresponds to a twisting of the joystick, with counter-clockwise being 1000 and clockwise being -1000, and the yaw of a vehicle."
        )
        public final Builder r(int r) {
            this.r = r;
            return this;
        }

        /**
         * A bitfield corresponding to the joystick buttons' current state, 1 for pressed, 0 for 
         * released. The lowest bit corresponds to Button 1. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "A bitfield corresponding to the joystick buttons' current state, 1 for pressed, 0 for released. The lowest bit corresponds to Button 1."
        )
        public final Builder buttons(int buttons) {
            this.buttons = buttons;
            return this;
        }

        public final ManualControl build() {
            return new ManualControl(target, x, y, z, r, buttons);
        }
    }
}
