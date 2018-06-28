package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Message to control a camera mount, directional antenna, etc. 
 */
@MavlinkMessageInfo(
        id = 157,
        crc = 21
)
public final class MountControl {
    private final int targetSystem;

    private final int targetComponent;

    private final int inputA;

    private final int inputB;

    private final int inputC;

    private final int savePosition;

    private MountControl(int targetSystem, int targetComponent, int inputA, int inputB, int inputC,
            int savePosition) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.inputA = inputA;
        this.inputB = inputB;
        this.inputC = inputC;
        this.savePosition = savePosition;
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
     * pitch(deg*100) or lat, depending on mount mode 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true
    )
    public final int inputA() {
        return this.inputA;
    }

    /**
     * roll(deg*100) or lon depending on mount mode 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true
    )
    public final int inputB() {
        return this.inputB;
    }

    /**
     * yaw(deg*100) or alt (in cm) depending on mount mode 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true
    )
    public final int inputC() {
        return this.inputC;
    }

    /**
     * if "1" it will save current trimmed position on EEPROM (just valid for NEUTRAL and LANDING) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1
    )
    public final int savePosition() {
        return this.savePosition;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int inputA;

        private int inputB;

        private int inputC;

        private int savePosition;

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
         * pitch(deg*100) or lat, depending on mount mode 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true
        )
        public final Builder inputA(int inputA) {
            this.inputA = inputA;
            return this;
        }

        /**
         * roll(deg*100) or lon depending on mount mode 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true
        )
        public final Builder inputB(int inputB) {
            this.inputB = inputB;
            return this;
        }

        /**
         * yaw(deg*100) or alt (in cm) depending on mount mode 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true
        )
        public final Builder inputC(int inputC) {
            this.inputC = inputC;
            return this;
        }

        /**
         * if "1" it will save current trimmed position on EEPROM (just valid for NEUTRAL and LANDING) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1
        )
        public final Builder savePosition(int savePosition) {
            this.savePosition = savePosition;
            return this;
        }

        public final MountControl build() {
            return new MountControl(targetSystem, targetComponent, inputA, inputB, inputC, savePosition);
        }
    }
}
