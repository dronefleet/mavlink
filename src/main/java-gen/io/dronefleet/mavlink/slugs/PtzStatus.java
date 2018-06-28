package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Transmits the actual Pan, Tilt and Zoom values of the camera unit 
 */
@MavlinkMessageInfo(
        id = 192,
        crc = 187
)
public final class PtzStatus {
    private final int zoom;

    private final int pan;

    private final int tilt;

    private PtzStatus(int zoom, int pan, int tilt) {
        this.zoom = zoom;
        this.pan = pan;
        this.tilt = tilt;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The actual Zoom Value 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int zoom() {
        return this.zoom;
    }

    /**
     * The Pan value in 10ths of degree 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            signed = true
    )
    public final int pan() {
        return this.pan;
    }

    /**
     * The Tilt value in 10ths of degree 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true
    )
    public final int tilt() {
        return this.tilt;
    }

    public static final class Builder {
        private int zoom;

        private int pan;

        private int tilt;

        /**
         * The actual Zoom Value 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder zoom(int zoom) {
            this.zoom = zoom;
            return this;
        }

        /**
         * The Pan value in 10ths of degree 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                signed = true
        )
        public final Builder pan(int pan) {
            this.pan = pan;
            return this;
        }

        /**
         * The Tilt value in 10ths of degree 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true
        )
        public final Builder tilt(int tilt) {
            this.tilt = tilt;
            return this;
        }

        public final PtzStatus build() {
            return new PtzStatus(zoom, pan, tilt);
        }
    }
}
