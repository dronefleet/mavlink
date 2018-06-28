package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * This message provides an API for manually controlling the vehicle using standard joystick 
 * axes nomenclature, along with a joystick-like input device. Unused axes can be disabled an 
 * buttons are also transmit as boolean values of their 
 */
@MavlinkMessageInfo(
        id = 69,
        crc = 243
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
            unitSize = 1
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
            signed = true
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
            signed = true
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
            signed = true
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
            signed = true
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
            unitSize = 2
    )
    public final int buttons() {
        return this.buttons;
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
                unitSize = 1
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
                signed = true
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
                signed = true
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
                signed = true
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
                signed = true
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
                unitSize = 2
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
