package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.math.BigInteger;

/**
 * Request for terrain data and terrain status 
 */
@MavlinkMessageInfo(
        id = 133,
        crc = 6
)
public final class TerrainRequest {
    private final int lat;

    private final int lon;

    private final int gridSpacing;

    private final BigInteger mask;

    private TerrainRequest(int lat, int lon, int gridSpacing, BigInteger mask) {
        this.lat = lat;
        this.lon = lon;
        this.gridSpacing = gridSpacing;
        this.mask = mask;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Latitude of SW corner of first grid (degrees *10^7) 
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
     * Longitude of SW corner of first grid (in degrees *10^7) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            signed = true
    )
    public final int lon() {
        return this.lon;
    }

    /**
     * Grid spacing in meters 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int gridSpacing() {
        return this.gridSpacing;
    }

    /**
     * Bitmask of requested 4x4 grids (row major 8x7 array of grids, 56 bits) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 8
    )
    public final BigInteger mask() {
        return this.mask;
    }

    public static final class Builder {
        private int lat;

        private int lon;

        private int gridSpacing;

        private BigInteger mask;

        /**
         * Latitude of SW corner of first grid (degrees *10^7) 
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
         * Longitude of SW corner of first grid (in degrees *10^7) 
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

        /**
         * Grid spacing in meters 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2
        )
        public final Builder gridSpacing(int gridSpacing) {
            this.gridSpacing = gridSpacing;
            return this;
        }

        /**
         * Bitmask of requested 4x4 grids (row major 8x7 array of grids, 56 bits) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 8
        )
        public final Builder mask(BigInteger mask) {
            this.mask = mask;
            return this;
        }

        public final TerrainRequest build() {
            return new TerrainRequest(lat, lon, gridSpacing, mask);
        }
    }
}
