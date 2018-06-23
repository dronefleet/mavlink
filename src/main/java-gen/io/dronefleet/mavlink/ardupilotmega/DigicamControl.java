package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Control on-board Camera Control System to take shots. 
 */
@MavlinkMessageInfo(
        id = 155,
        crc = 22
)
public final class DigicamControl {
    /**
     * Correspondent value to given extra_param 
     */
    private final float extraValue;

    /**
     * System ID 
     */
    private final int targetSystem;

    /**
     * Component ID 
     */
    private final int targetComponent;

    /**
     * 0: stop, 1: start or keep it up //Session control e.g. show/hide lens 
     */
    private final int session;

    /**
     * 1 to N //Zoom's absolute position (0 means ignore) 
     */
    private final int zoomPos;

    /**
     * -100 to 100 //Zooming step value to offset zoom from the current position 
     */
    private final int zoomStep;

    /**
     * 0: unlock focus or keep unlocked, 1: lock focus or keep locked, 3: re-lock focus 
     */
    private final int focusLock;

    /**
     * 0: ignore, 1: shot or start filming 
     */
    private final int shot;

    /**
     * Command Identity (incremental loop: 0 to 255)//A command sent multiple times will be executed 
     * or pooled just once 
     */
    private final int commandId;

    /**
     * Extra parameters enumeration (0 means ignore) 
     */
    private final int extraParam;

    private DigicamControl(float extraValue, int targetSystem, int targetComponent, int session,
            int zoomPos, int zoomStep, int focusLock, int shot, int commandId, int extraParam) {
        this.extraValue = extraValue;
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.session = session;
        this.zoomPos = zoomPos;
        this.zoomStep = zoomStep;
        this.focusLock = focusLock;
        this.shot = shot;
        this.commandId = commandId;
        this.extraParam = extraParam;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "DigicamControl{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", session=" + session
                 + ", zoomPos=" + zoomPos
                 + ", zoomStep=" + zoomStep
                 + ", focusLock=" + focusLock
                 + ", shot=" + shot
                 + ", commandId=" + commandId
                 + ", extraParam=" + extraParam
                 + ", extraValue=" + extraValue + "}";
    }

    /**
     * Correspondent value to given extra_param 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4
    )
    public final float extraValue() {
        return extraValue;
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
     * 0: stop, 1: start or keep it up //Session control e.g. show/hide lens 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int session() {
        return session;
    }

    /**
     * 1 to N //Zoom's absolute position (0 means ignore) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int zoomPos() {
        return zoomPos;
    }

    /**
     * -100 to 100 //Zooming step value to offset zoom from the current position 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            signed = true
    )
    public final int zoomStep() {
        return zoomStep;
    }

    /**
     * 0: unlock focus or keep unlocked, 1: lock focus or keep locked, 3: re-lock focus 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1
    )
    public final int focusLock() {
        return focusLock;
    }

    /**
     * 0: ignore, 1: shot or start filming 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1
    )
    public final int shot() {
        return shot;
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
        return commandId;
    }

    /**
     * Extra parameters enumeration (0 means ignore) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1
    )
    public final int extraParam() {
        return extraParam;
    }

    public static class Builder {
        private float extraValue;

        private int targetSystem;

        private int targetComponent;

        private int session;

        private int zoomPos;

        private int zoomStep;

        private int focusLock;

        private int shot;

        private int commandId;

        private int extraParam;

        private Builder() {
        }

        /**
         * Correspondent value to given extra_param 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4
        )
        public final Builder extraValue(float extraValue) {
            this.extraValue = extraValue;
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
         * 0: stop, 1: start or keep it up //Session control e.g. show/hide lens 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder session(int session) {
            this.session = session;
            return this;
        }

        /**
         * 1 to N //Zoom's absolute position (0 means ignore) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder zoomPos(int zoomPos) {
            this.zoomPos = zoomPos;
            return this;
        }

        /**
         * -100 to 100 //Zooming step value to offset zoom from the current position 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                signed = true
        )
        public final Builder zoomStep(int zoomStep) {
            this.zoomStep = zoomStep;
            return this;
        }

        /**
         * 0: unlock focus or keep unlocked, 1: lock focus or keep locked, 3: re-lock focus 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1
        )
        public final Builder focusLock(int focusLock) {
            this.focusLock = focusLock;
            return this;
        }

        /**
         * 0: ignore, 1: shot or start filming 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1
        )
        public final Builder shot(int shot) {
            this.shot = shot;
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
         * Extra parameters enumeration (0 means ignore) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1
        )
        public final Builder extraParam(int extraParam) {
            this.extraParam = extraParam;
            return this;
        }

        public final DigicamControl build() {
            return new DigicamControl(extraValue, targetSystem, targetComponent, session, zoomPos, zoomStep, focusLock, shot, commandId, extraParam);
        }
    }
}
