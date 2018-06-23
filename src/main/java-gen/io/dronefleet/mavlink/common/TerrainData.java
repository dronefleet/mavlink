package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Terrain data sent from GCS. The lat/lon and grid_spacing must be the same as a lat/lon from a 
 * {@link io.dronefleet.mavlink.common.TerrainRequest TerrainRequest} 
 */
@MavlinkMessageInfo(
        id = 134,
        crc = 229
)
public final class TerrainData {
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

    /**
     * Terrain data in meters AMSL 
     */
    private final List<Integer> data;

    /**
     * bit within the terrain request mask 
     */
    private final int gridbit;

    private TerrainData(int lat, int lon, int gridSpacing, List<Integer> data, int gridbit) {
        this.lat = lat;
        this.lon = lon;
        this.gridSpacing = gridSpacing;
        this.data = data;
        this.gridbit = gridbit;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "TerrainData{lat=" + lat
                 + ", lon=" + lon
                 + ", gridSpacing=" + gridSpacing
                 + ", gridbit=" + gridbit
                 + ", data=" + data + "}";
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

    /**
     * Terrain data in meters AMSL 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            signed = true,
            arraySize = 16
    )
    public final List<Integer> data() {
        return data;
    }

    /**
     * bit within the terrain request mask 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int gridbit() {
        return gridbit;
    }

    public static class Builder {
        private int lat;

        private int lon;

        private int gridSpacing;

        private List<Integer> data;

        private int gridbit;

        private Builder() {
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

        /**
         * Terrain data in meters AMSL 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                signed = true,
                arraySize = 16
        )
        public final Builder data(List<Integer> data) {
            this.data = data;
            return this;
        }

        /**
         * bit within the terrain request mask 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder gridbit(int gridbit) {
            this.gridbit = gridbit;
            return this;
        }

        public final TerrainData build() {
            return new TerrainData(lat, lon, gridSpacing, data, gridbit);
        }
    }
}
