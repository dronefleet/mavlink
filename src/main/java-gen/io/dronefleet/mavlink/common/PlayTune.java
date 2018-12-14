package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Control vehicle tone generation (buzzer) 
 */
@MavlinkMessageInfo(
        id = 258,
        crc = 187,
        description = "Control vehicle tone generation (buzzer)"
)
public final class PlayTune {
    private final int targetSystem;

    private final int targetComponent;

    private final String tune;

    private final String tune2;

    private PlayTune(int targetSystem, int targetComponent, String tune, String tune2) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.tune = tune;
        this.tune2 = tune2;
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
            unitSize = 1,
            description = "System ID"
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * tune in board specific format 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 30,
            description = "tune in board specific format"
    )
    public final String tune() {
        return this.tune;
    }

    /**
     * tune extension (appended to tune) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            arraySize = 200,
            extension = true,
            description = "tune extension (appended to tune)"
    )
    public final String tune2() {
        return this.tune2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        PlayTune other = (PlayTune)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(tune, other.tune)) return false;
        if (!Objects.deepEquals(tune2, other.tune2)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(tune);
        result = 31 * result + Objects.hashCode(tune2);
        return result;
    }

    @Override
    public String toString() {
        return "PlayTune{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", tune=" + tune
                 + ", tune2=" + tune2 + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private String tune;

        private String tune2;

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "System ID"
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
                unitSize = 1,
                description = "Component ID"
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * tune in board specific format 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 30,
                description = "tune in board specific format"
        )
        public final Builder tune(String tune) {
            this.tune = tune;
            return this;
        }

        /**
         * tune extension (appended to tune) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                arraySize = 200,
                extension = true,
                description = "tune extension (appended to tune)"
        )
        public final Builder tune2(String tune2) {
            this.tune2 = tune2;
            return this;
        }

        public final PlayTune build() {
            return new PlayTune(targetSystem, targetComponent, tune, tune2);
        }
    }
}
