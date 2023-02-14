package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;

/**
 * Terrain data sent from GCS. The lat/lon and grid_spacing must be the same as a lat/lon from a 
 * {@link io.dronefleet.mavlink.common.TerrainRequest TERRAIN_REQUEST}. See terrain protocol docs: 
 * https://mavlink.io/en/services/terrain.html 
 */
@MavlinkMessageInfo(
        id = 134,
        crc = 229,
        description = "Terrain data sent from GCS. The lat/lon and grid_spacing must be the same as a lat/lon from a TERRAIN_REQUEST. See terrain protocol docs: https://mavlink.io/en/services/terrain.html"
)
public final class TerrainData {
    private final int lat;

    private final int lon;

    private final int gridSpacing;

    private final int gridbit;

    private final List<Integer> data;

    private TerrainData(int lat, int lon, int gridSpacing, int gridbit, List<Integer> data) {
        this.lat = lat;
        this.lon = lon;
        this.gridSpacing = gridSpacing;
        this.gridbit = gridbit;
        this.data = data;
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
     * bit within the terrain request mask 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "bit within the terrain request mask"
    )
    public final int gridbit() {
        return this.gridbit;
    }

    /**
     * Terrain data MSL 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            arraySize = 16,
            signed = true,
            description = "Terrain data MSL"
    )
    public final List<Integer> data() {
        return this.data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        TerrainData other = (TerrainData)o;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lon, other.lon)) return false;
        if (!Objects.deepEquals(gridSpacing, other.gridSpacing)) return false;
        if (!Objects.deepEquals(gridbit, other.gridbit)) return false;
        if (!Objects.deepEquals(data, other.data)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(lat);
        result = 31 * result + Objects.hashCode(lon);
        result = 31 * result + Objects.hashCode(gridSpacing);
        result = 31 * result + Objects.hashCode(gridbit);
        result = 31 * result + Objects.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "TerrainData{lat=" + lat
                 + ", lon=" + lon
                 + ", gridSpacing=" + gridSpacing
                 + ", gridbit=" + gridbit
                 + ", data=" + data + "}";
    }

    public static final class Builder {
        private int lat;

        private int lon;

        private int gridSpacing;

        private int gridbit;

        private List<Integer> data;

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
         * bit within the terrain request mask 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "bit within the terrain request mask"
        )
        public final Builder gridbit(int gridbit) {
            this.gridbit = gridbit;
            return this;
        }

        /**
         * Terrain data MSL 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                arraySize = 16,
                signed = true,
                description = "Terrain data MSL"
        )
        public final Builder data(List<Integer> data) {
            this.data = data;
            return this;
        }

        public final TerrainData build() {
            return new TerrainData(lat, lon, gridSpacing, gridbit, data);
        }
    }
}
