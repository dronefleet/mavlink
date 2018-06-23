package io.dronefleet.mavlink.paparazzi;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Message encoding a mission script item. This message is emitted upon a request for the next 
 * script item. 
 */
@MavlinkMessageInfo(
        id = 180,
        crc = 231
)
public final class ScriptItem {
    /**
     * Sequence 
     */
    private final int seq;

    /**
     * System ID 
     */
    private final int targetSystem;

    /**
     * Component ID 
     */
    private final int targetComponent;

    /**
     * The name of the mission script, NULL terminated. 
     */
    private final String name;

    private ScriptItem(int seq, int targetSystem, int targetComponent, String name) {
        this.seq = seq;
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.name = name;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "ScriptItem{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", seq=" + seq
                 + ", name=" + name + "}";
    }

    /**
     * Sequence 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int seq() {
        return seq;
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
     * The name of the mission script, NULL terminated. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            arraySize = 50
    )
    public final String name() {
        return name;
    }

    public static class Builder {
        private int seq;

        private int targetSystem;

        private int targetComponent;

        private String name;

        private Builder() {
        }

        /**
         * Sequence 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2
        )
        public final Builder seq(int seq) {
            this.seq = seq;
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
         * The name of the mission script, NULL terminated. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                arraySize = 50
        )
        public final Builder name(String name) {
            this.name = name;
            return this;
        }

        public final ScriptItem build() {
            return new ScriptItem(seq, targetSystem, targetComponent, name);
        }
    }
}
