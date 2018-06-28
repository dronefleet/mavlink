package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Request that the vehicle report terrain height at the given location. Used by GCS to check if 
 * vehicle has all terrain data needed for a mission. 
 */
@MavlinkMessageInfo(
        id = 135,
        crc = 203
)
public final class TerrainCheck {
    private final int lat;

    private final int lon;

    private TerrainCheck(int lat, int lon) {
        this.lat = lat;
        this.lon = lon;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Latitude (degrees *10^7) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            signed = true
    )
    public final int lat() {
        return this.lat;
    }

    /**
     * Longitude (degrees *10^7) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            signed = true
    )
    public final int lon() {
        return this.lon;
    }

    public static final class Builder {
        private int lat;

        private int lon;

        /**
         * Latitude (degrees *10^7) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                signed = true
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude (degrees *10^7) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                signed = true
        )
        public final Builder lon(int lon) {
            this.lon = lon;
            return this;
        }

        public final TerrainCheck build() {
            return new TerrainCheck(lat, lon);
        }
    }
}
