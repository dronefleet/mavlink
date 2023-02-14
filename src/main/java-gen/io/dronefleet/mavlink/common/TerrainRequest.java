package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Request for terrain data and terrain status. See terrain protocol docs: 
 * https://mavlink.io/en/services/terrain.html 
 */
@MavlinkMessageInfo(
        id = 133,
        crc = 6,
        description = "Request for terrain data and terrain status. See terrain protocol docs: https://mavlink.io/en/services/terrain.html"
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
     * Latitude of SW corner of first grid 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            signed = true,
            description = "Latitude of SW corner of first grid"
    )
    public final int lat() {
        return this.lat;
    }

    /**
     * Longitude of SW corner of first grid 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            signed = true,
            description = "Longitude of SW corner of first grid"
    )
    public final int lon() {
        return this.lon;
    }

    /**
     * Grid spacing 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "Grid spacing"
    )
    public final int gridSpacing() {
        return this.gridSpacing;
    }

    /**
     * Bitmask of requested 4x4 grids (row major 8x7 array of grids, 56 bits) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 8,
            description = "Bitmask of requested 4x4 grids (row major 8x7 array of grids, 56 bits)"
    )
    public final BigInteger mask() {
        return this.mask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        TerrainRequest other = (TerrainRequest)o;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lon, other.lon)) return false;
        if (!Objects.deepEquals(gridSpacing, other.gridSpacing)) return false;
        if (!Objects.deepEquals(mask, other.mask)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(lat);
        result = 31 * result + Objects.hashCode(lon);
        result = 31 * result + Objects.hashCode(gridSpacing);
        result = 31 * result + Objects.hashCode(mask);
        return result;
    }

    @Override
    public String toString() {
        return "TerrainRequest{lat=" + lat
                 + ", lon=" + lon
                 + ", gridSpacing=" + gridSpacing
                 + ", mask=" + mask + "}";
    }

    public static final class Builder {
        private int lat;

        private int lon;

        private int gridSpacing;

        private BigInteger mask;

        /**
         * Latitude of SW corner of first grid 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                signed = true,
                description = "Latitude of SW corner of first grid"
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude of SW corner of first grid 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                signed = true,
                description = "Longitude of SW corner of first grid"
        )
        public final Builder lon(int lon) {
            this.lon = lon;
            return this;
        }

        /**
         * Grid spacing 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "Grid spacing"
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
                unitSize = 8,
                description = "Bitmask of requested 4x4 grids (row major 8x7 array of grids, 56 bits)"
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
