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
 * axes nomenclature, along with a joystick-like input device. Unused axes can be disabled and 
 * buttons states are transmitted as individual on/off bits of a bitmask 
 */
@MavlinkMessageInfo(
        id = 69,
        crc = 243,
        description = "This message provides an API for manually controlling the vehicle using standard joystick axes nomenclature, along with a joystick-like input device. Unused axes can be disabled and buttons states are transmitted as individual on/off bits of a bitmask"
)
public final class ManualControl {
    private final int target;

    private final int x;

    private final int y;

    private final int z;

    private final int r;

    private final int buttons;

    private final int buttons2;

    private final int enabledExtensions;

    private final int s;

    private final int t;

    private ManualControl(int target, int x, int y, int z, int r, int buttons, int buttons2,
            int enabledExtensions, int s, int t) {
        this.target = target;
        this.x = x;
        this.y = y;
        this.z = z;
        this.r = r;
        this.buttons = buttons;
        this.buttons2 = buttons2;
        this.enabledExtensions = enabledExtensions;
        this.s = s;
        this.t = t;
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
     * A bitfield corresponding to the joystick buttons' 0-15 current state, 1 for pressed, 0 for 
     * released. The lowest bit corresponds to Button 1. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "A bitfield corresponding to the joystick buttons' 0-15 current state, 1 for pressed, 0 for released. The lowest bit corresponds to Button 1."
    )
    public final int buttons() {
        return this.buttons;
    }

    /**
     * A bitfield corresponding to the joystick buttons' 16-31 current state, 1 for pressed, 0 for 
     * released. The lowest bit corresponds to Button 16. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            extension = true,
            description = "A bitfield corresponding to the joystick buttons' 16-31 current state, 1 for pressed, 0 for released. The lowest bit corresponds to Button 16."
    )
    public final int buttons2() {
        return this.buttons2;
    }

    /**
     * Set bits to 1 to indicate which of the following extension fields contain valid data: bit 0: 
     * pitch, bit 1: roll. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1,
            extension = true,
            description = "Set bits to 1 to indicate which of the following extension fields contain valid data: bit 0: pitch, bit 1: roll."
    )
    public final int enabledExtensions() {
        return this.enabledExtensions;
    }

    /**
     * Pitch-only-axis, normalized to the range [-1000,1000]. Generally corresponds to pitch on 
     * vehicles with additional degrees of freedom. Valid if bit 0 of enabled_extensions field is 
     * set. Set to 0 if invalid. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2,
            signed = true,
            extension = true,
            description = "Pitch-only-axis, normalized to the range [-1000,1000]. Generally corresponds to pitch on vehicles with additional degrees of freedom. Valid if bit 0 of enabled_extensions field is set. Set to 0 if invalid."
    )
    public final int s() {
        return this.s;
    }

    /**
     * Roll-only-axis, normalized to the range [-1000,1000]. Generally corresponds to roll on 
     * vehicles with additional degrees of freedom. Valid if bit 1 of enabled_extensions field is 
     * set. Set to 0 if invalid. 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 2,
            signed = true,
            extension = true,
            description = "Roll-only-axis, normalized to the range [-1000,1000]. Generally corresponds to roll on vehicles with additional degrees of freedom. Valid if bit 1 of enabled_extensions field is set. Set to 0 if invalid."
    )
    public final int t() {
        return this.t;
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
        if (!Objects.deepEquals(buttons2, other.buttons2)) return false;
        if (!Objects.deepEquals(enabledExtensions, other.enabledExtensions)) return false;
        if (!Objects.deepEquals(s, other.s)) return false;
        if (!Objects.deepEquals(t, other.t)) return false;
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
        result = 31 * result + Objects.hashCode(buttons2);
        result = 31 * result + Objects.hashCode(enabledExtensions);
        result = 31 * result + Objects.hashCode(s);
        result = 31 * result + Objects.hashCode(t);
        return result;
    }

    @Override
    public String toString() {
        return "ManualControl{target=" + target
                 + ", x=" + x
                 + ", y=" + y
                 + ", z=" + z
                 + ", r=" + r
                 + ", buttons=" + buttons
                 + ", buttons2=" + buttons2
                 + ", enabledExtensions=" + enabledExtensions
                 + ", s=" + s
                 + ", t=" + t + "}";
    }

    public static final class Builder {
        private int target;

        private int x;

        private int y;

        private int z;

        private int r;

        private int buttons;

        private int buttons2;

        private int enabledExtensions;

        private int s;

        private int t;

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
         * A bitfield corresponding to the joystick buttons' 0-15 current state, 1 for pressed, 0 for 
         * released. The lowest bit corresponds to Button 1. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "A bitfield corresponding to the joystick buttons' 0-15 current state, 1 for pressed, 0 for released. The lowest bit corresponds to Button 1."
        )
        public final Builder buttons(int buttons) {
            this.buttons = buttons;
            return this;
        }

        /**
         * A bitfield corresponding to the joystick buttons' 16-31 current state, 1 for pressed, 0 for 
         * released. The lowest bit corresponds to Button 16. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                extension = true,
                description = "A bitfield corresponding to the joystick buttons' 16-31 current state, 1 for pressed, 0 for released. The lowest bit corresponds to Button 16."
        )
        public final Builder buttons2(int buttons2) {
            this.buttons2 = buttons2;
            return this;
        }

        /**
         * Set bits to 1 to indicate which of the following extension fields contain valid data: bit 0: 
         * pitch, bit 1: roll. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1,
                extension = true,
                description = "Set bits to 1 to indicate which of the following extension fields contain valid data: bit 0: pitch, bit 1: roll."
        )
        public final Builder enabledExtensions(int enabledExtensions) {
            this.enabledExtensions = enabledExtensions;
            return this;
        }

        /**
         * Pitch-only-axis, normalized to the range [-1000,1000]. Generally corresponds to pitch on 
         * vehicles with additional degrees of freedom. Valid if bit 0 of enabled_extensions field is 
         * set. Set to 0 if invalid. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 2,
                signed = true,
                extension = true,
                description = "Pitch-only-axis, normalized to the range [-1000,1000]. Generally corresponds to pitch on vehicles with additional degrees of freedom. Valid if bit 0 of enabled_extensions field is set. Set to 0 if invalid."
        )
        public final Builder s(int s) {
            this.s = s;
            return this;
        }

        /**
         * Roll-only-axis, normalized to the range [-1000,1000]. Generally corresponds to roll on 
         * vehicles with additional degrees of freedom. Valid if bit 1 of enabled_extensions field is 
         * set. Set to 0 if invalid. 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 2,
                signed = true,
                extension = true,
                description = "Roll-only-axis, normalized to the range [-1000,1000]. Generally corresponds to roll on vehicles with additional degrees of freedom. Valid if bit 1 of enabled_extensions field is set. Set to 0 if invalid."
        )
        public final Builder t(int t) {
            this.t = t;
            return this;
        }

        public final ManualControl build() {
            return new ManualControl(target, x, y, z, r, buttons, buttons2, enabledExtensions, s, t);
        }
    }
}
