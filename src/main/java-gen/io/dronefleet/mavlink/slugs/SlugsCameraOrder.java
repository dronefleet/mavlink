package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Orders generated to the SLUGS camera mount. 
 */
@MavlinkMessageInfo(
        id = 184,
        crc = 45,
        description = "Orders generated to the SLUGS camera mount."
)
public final class SlugsCameraOrder {
    private final int target;

    private final int pan;

    private final int tilt;

    private final int zoom;

    private final int movehome;

    private SlugsCameraOrder(int target, int pan, int tilt, int zoom, int movehome) {
        this.target = target;
        this.pan = pan;
        this.tilt = tilt;
        this.zoom = zoom;
        this.movehome = movehome;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The system reporting the action 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "The system reporting the action"
    )
    public final int target() {
        return this.target;
    }

    /**
     * Order the mount to pan: -1 left, 0 No pan motion, +1 right 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            signed = true,
            description = "Order the mount to pan: -1 left, 0 No pan motion, +1 right"
    )
    public final int pan() {
        return this.pan;
    }

    /**
     * Order the mount to tilt: -1 down, 0 No tilt motion, +1 up 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            signed = true,
            description = "Order the mount to tilt: -1 down, 0 No tilt motion, +1 up"
    )
    public final int tilt() {
        return this.tilt;
    }

    /**
     * Order the zoom values 0 to 10 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            signed = true,
            description = "Order the zoom values 0 to 10"
    )
    public final int zoom() {
        return this.zoom;
    }

    /**
     * Orders the camera mount to move home. The other fields are ignored when this field is set. 1: move 
     * home, 0 ignored 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            signed = true,
            description = "Orders the camera mount to move home. The other fields are ignored when this field is set. 1: move home, 0 ignored"
    )
    public final int movehome() {
        return this.movehome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SlugsCameraOrder other = (SlugsCameraOrder)o;
        if (!Objects.deepEquals(target, other.target)) return false;
        if (!Objects.deepEquals(pan, other.pan)) return false;
        if (!Objects.deepEquals(tilt, other.tilt)) return false;
        if (!Objects.deepEquals(zoom, other.zoom)) return false;
        if (!Objects.deepEquals(movehome, other.movehome)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(target);
        result = 31 * result + Objects.hashCode(pan);
        result = 31 * result + Objects.hashCode(tilt);
        result = 31 * result + Objects.hashCode(zoom);
        result = 31 * result + Objects.hashCode(movehome);
        return result;
    }

    @Override
    public String toString() {
        return "SlugsCameraOrder{target=" + target
                 + ", pan=" + pan
                 + ", tilt=" + tilt
                 + ", zoom=" + zoom
                 + ", movehome=" + movehome + "}";
    }

    public static final class Builder {
        private int target;

        private int pan;

        private int tilt;

        private int zoom;

        private int movehome;

        /**
         * The system reporting the action 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "The system reporting the action"
        )
        public final Builder target(int target) {
            this.target = target;
            return this;
        }

        /**
         * Order the mount to pan: -1 left, 0 No pan motion, +1 right 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                signed = true,
                description = "Order the mount to pan: -1 left, 0 No pan motion, +1 right"
        )
        public final Builder pan(int pan) {
            this.pan = pan;
            return this;
        }

        /**
         * Order the mount to tilt: -1 down, 0 No tilt motion, +1 up 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                signed = true,
                description = "Order the mount to tilt: -1 down, 0 No tilt motion, +1 up"
        )
        public final Builder tilt(int tilt) {
            this.tilt = tilt;
            return this;
        }

        /**
         * Order the zoom values 0 to 10 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                signed = true,
                description = "Order the zoom values 0 to 10"
        )
        public final Builder zoom(int zoom) {
            this.zoom = zoom;
            return this;
        }

        /**
         * Orders the camera mount to move home. The other fields are ignored when this field is set. 1: move 
         * home, 0 ignored 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                signed = true,
                description = "Orders the camera mount to move home. The other fields are ignored when this field is set. 1: move home, 0 ignored"
        )
        public final Builder movehome(int movehome) {
            this.movehome = movehome;
            return this;
        }

        public final SlugsCameraOrder build() {
            return new SlugsCameraOrder(target, pan, tilt, zoom, movehome);
        }
    }
}
