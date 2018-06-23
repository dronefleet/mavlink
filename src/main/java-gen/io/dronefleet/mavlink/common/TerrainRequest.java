package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * Request for terrain data and terrain status 
 */
@MavlinkMessageInfo(
        id = 133,
        crc = 6
)
public final class TerrainRequest {
    /**
     * Bitmask of requested 4x4 grids (row major 8x7 array of grids, 56 bits) 
     */
    private final BigInteger mask;

    /**
     * Latitude of SW corner of first grid (degrees *10^7) 
     */
    private final int lat;

    /**
     * Longitude of SW corner of first grid (in degrees *10^7) 
     */
    private final int lon;

    /**
     * Grid spacing in meters 
     */
    private final int gridSpacing;

    private TerrainRequest(BigInteger mask, int lat, int lon, int gridSpacing) {
        this.mask = mask;
        this.lat = lat;
        this.lon = lon;
        this.gridSpacing = gridSpacing;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "TerrainRequest{lat=" + lat
                 + ", lon=" + lon
                 + ", gridSpacing=" + gridSpacing
                 + ", mask=" + mask + "}";
    }

    /**
     * Bitmask of requested 4x4 grids (row major 8x7 array of grids, 56 bits) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 8
    )
    public final BigInteger mask() {
        return mask;
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
        return lat;
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
        return lon;
    }

    /**
     * Grid spacing in meters 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int gridSpacing() {
        return gridSpacing;
    }

    public static class Builder {
        private BigInteger mask;

        private int lat;

        private int lon;

        private int gridSpacing;

        private Builder() {
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

        public final TerrainRequest build() {
            return new TerrainRequest(mask, lat, lon, gridSpacing);
        }
    }
}
