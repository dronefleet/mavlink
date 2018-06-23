package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Message to control a camera mount, directional antenna, etc. 
 */
@MavlinkMessageInfo(
        id = 157,
        crc = 21
)
public final class MountControl {
    /**
     * pitch(deg*100) or lat, depending on mount mode 
     */
    private final int inputA;

    /**
     * roll(deg*100) or lon depending on mount mode 
     */
    private final int inputB;

    /**
     * yaw(deg*100) or alt (in cm) depending on mount mode 
     */
    private final int inputC;

    /**
     * System ID 
     */
    private final int targetSystem;

    /**
     * Component ID 
     */
    private final int targetComponent;

    /**
     * if "1" it will save current trimmed position on EEPROM (just valid for NEUTRAL and LANDING) 
     */
    private final int savePosition;

    private MountControl(int inputA, int inputB, int inputC, int targetSystem, int targetComponent,
            int savePosition) {
        this.inputA = inputA;
        this.inputB = inputB;
        this.inputC = inputC;
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.savePosition = savePosition;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "MountControl{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", inputA=" + inputA
                 + ", inputB=" + inputB
                 + ", inputC=" + inputC
                 + ", savePosition=" + savePosition + "}";
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
        return inputA;
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
        return inputB;
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
        return inputC;
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

    /**
     * if "1" it will save current trimmed position on EEPROM (just valid for NEUTRAL and LANDING) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1
    )
    public final int savePosition() {
        return savePosition;
    }

    public static class Builder {
        private int inputA;

        private int inputB;

        private int inputC;

        private int targetSystem;

        private int targetComponent;

        private int savePosition;

        private Builder() {
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
            return new MountControl(inputA, inputB, inputC, targetSystem, targetComponent, savePosition);
        }
    }
}
