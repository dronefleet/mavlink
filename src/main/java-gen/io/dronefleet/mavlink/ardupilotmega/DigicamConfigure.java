package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Configure on-board Camera Control System. 
 */
@MavlinkMessageInfo(
        id = 154,
        crc = 84
)
public final class DigicamConfigure {
    private final int targetSystem;

    private final int targetComponent;

    private final int mode;

    private final int shutterSpeed;

    private final int aperture;

    private final int iso;

    private final int exposureType;

    private final int commandId;

    private final int engineCutOff;

    private final int extraParam;

    private final float extraValue;

    private DigicamConfigure(int targetSystem, int targetComponent, int mode, int shutterSpeed,
            int aperture, int iso, int exposureType, int commandId, int engineCutOff,
            int extraParam, float extraValue) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.mode = mode;
        this.shutterSpeed = shutterSpeed;
        this.aperture = aperture;
        this.iso = iso;
        this.exposureType = exposureType;
        this.commandId = commandId;
        this.engineCutOff = engineCutOff;
        this.extraParam = extraParam;
        this.extraValue = extraValue;
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
     * Mode enumeration from 1 to N //P, TV, AV, M, Etc (0 means ignore) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int mode() {
        return this.mode;
    }

    /**
     * Divisor number //e.g. 1000 means 1/1000 (0 means ignore) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2
    )
    public final int shutterSpeed() {
        return this.shutterSpeed;
    }

    /**
     * F stop number x 10 //e.g. 28 means 2.8 (0 means ignore) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int aperture() {
        return this.aperture;
    }

    /**
     * ISO enumeration from 1 to N //e.g. 80, 100, 200, Etc (0 means ignore) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1
    )
    public final int iso() {
        return this.iso;
    }

    /**
     * Exposure type enumeration from 1 to N (0 means ignore) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1
    )
    public final int exposureType() {
        return this.exposureType;
    }

    /**
     * Command Identity (incremental loop: 0 to 255)//A command sent multiple times will be executed 
     * or pooled just once 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1
    )
    public final int commandId() {
        return this.commandId;
    }

    /**
     * Main engine cut-off time before camera trigger in seconds/10 (0 means no cut-off) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1
    )
    public final int engineCutOff() {
        return this.engineCutOff;
    }

    /**
     * Extra parameters enumeration (0 means ignore) 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1
    )
    public final int extraParam() {
        return this.extraParam;
    }

    /**
     * Correspondent value to given extra_param 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4
    )
    public final float extraValue() {
        return this.extraValue;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int mode;

        private int shutterSpeed;

        private int aperture;

        private int iso;

        private int exposureType;

        private int commandId;

        private int engineCutOff;

        private int extraParam;

        private float extraValue;

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
         * Mode enumeration from 1 to N //P, TV, AV, M, Etc (0 means ignore) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder mode(int mode) {
            this.mode = mode;
            return this;
        }

        /**
         * Divisor number //e.g. 1000 means 1/1000 (0 means ignore) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2
        )
        public final Builder shutterSpeed(int shutterSpeed) {
            this.shutterSpeed = shutterSpeed;
            return this;
        }

        /**
         * F stop number x 10 //e.g. 28 means 2.8 (0 means ignore) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder aperture(int aperture) {
            this.aperture = aperture;
            return this;
        }

        /**
         * ISO enumeration from 1 to N //e.g. 80, 100, 200, Etc (0 means ignore) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1
        )
        public final Builder iso(int iso) {
            this.iso = iso;
            return this;
        }

        /**
         * Exposure type enumeration from 1 to N (0 means ignore) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1
        )
        public final Builder exposureType(int exposureType) {
            this.exposureType = exposureType;
            return this;
        }

        /**
         * Command Identity (incremental loop: 0 to 255)//A command sent multiple times will be executed 
         * or pooled just once 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1
        )
        public final Builder commandId(int commandId) {
            this.commandId = commandId;
            return this;
        }

        /**
         * Main engine cut-off time before camera trigger in seconds/10 (0 means no cut-off) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1
        )
        public final Builder engineCutOff(int engineCutOff) {
            this.engineCutOff = engineCutOff;
            return this;
        }

        /**
         * Extra parameters enumeration (0 means ignore) 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1
        )
        public final Builder extraParam(int extraParam) {
            this.extraParam = extraParam;
            return this;
        }

        /**
         * Correspondent value to given extra_param 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4
        )
        public final Builder extraValue(float extraValue) {
            this.extraValue = extraValue;
            return this;
        }

        public final DigicamConfigure build() {
            return new DigicamConfigure(targetSystem, targetComponent, mode, shutterSpeed, aperture, iso, exposureType, commandId, engineCutOff, extraParam, extraValue);
        }
    }
}
