package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Streamed from drone to report progress of terrain map download (initiated by 
 * {@link io.dronefleet.mavlink.common.TerrainRequest TERRAIN_REQUEST}), or sent as a response to a {@link io.dronefleet.mavlink.common.TerrainCheck TERRAIN_CHECK} request. See terrain protocol 
 * docs: https://mavlink.io/en/services/terrain.html 
 */
@MavlinkMessageInfo(
        id = 136,
        crc = 1,
        description = "Streamed from drone to report progress of terrain map download (initiated by TERRAIN_REQUEST), or sent as a response to a TERRAIN_CHECK request. See terrain protocol docs: https://mavlink.io/en/services/terrain.html"
)
public final class TerrainReport {
    private final int lat;

    private final int lon;

    private final int spacing;

    private final float terrainHeight;

    private final float currentHeight;

    private final int pending;

    private final int loaded;

    private TerrainReport(int lat, int lon, int spacing, float terrainHeight, float currentHeight,
            int pending, int loaded) {
        this.lat = lat;
        this.lon = lon;
        this.spacing = spacing;
        this.terrainHeight = terrainHeight;
        this.currentHeight = currentHeight;
        this.pending = pending;
        this.loaded = loaded;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Latitude 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            signed = true,
            description = "Latitude"
    )
    public final int lat() {
        return this.lat;
    }

    /**
     * Longitude 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            signed = true,
            description = "Longitude"
    )
    public final int lon() {
        return this.lon;
    }

    /**
     * grid spacing (zero if terrain at this location unavailable) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "grid spacing (zero if terrain at this location unavailable)"
    )
    public final int spacing() {
        return this.spacing;
    }

    /**
     * Terrain height MSL 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Terrain height MSL"
    )
    public final float terrainHeight() {
        return this.terrainHeight;
    }

    /**
     * Current vehicle height above lat/lon terrain height 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Current vehicle height above lat/lon terrain height"
    )
    public final float currentHeight() {
        return this.currentHeight;
    }

    /**
     * Number of 4x4 terrain blocks waiting to be received or read from disk 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "Number of 4x4 terrain blocks waiting to be received or read from disk"
    )
    public final int pending() {
        return this.pending;
    }

    /**
     * Number of 4x4 terrain blocks in memory 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            description = "Number of 4x4 terrain blocks in memory"
    )
    public final int loaded() {
        return this.loaded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        TerrainReport other = (TerrainReport)o;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lon, other.lon)) return false;
        if (!Objects.deepEquals(spacing, other.spacing)) return false;
        if (!Objects.deepEquals(terrainHeight, other.terrainHeight)) return false;
        if (!Objects.deepEquals(currentHeight, other.currentHeight)) return false;
        if (!Objects.deepEquals(pending, other.pending)) return false;
        if (!Objects.deepEquals(loaded, other.loaded)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(lat);
        result = 31 * result + Objects.hashCode(lon);
        result = 31 * result + Objects.hashCode(spacing);
        result = 31 * result + Objects.hashCode(terrainHeight);
        result = 31 * result + Objects.hashCode(currentHeight);
        result = 31 * result + Objects.hashCode(pending);
        result = 31 * result + Objects.hashCode(loaded);
        return result;
    }

    @Override
    public String toString() {
        return "TerrainReport{lat=" + lat
                 + ", lon=" + lon
                 + ", spacing=" + spacing
                 + ", terrainHeight=" + terrainHeight
                 + ", currentHeight=" + currentHeight
                 + ", pending=" + pending
                 + ", loaded=" + loaded + "}";
    }

    public static final class Builder {
        private int lat;

        private int lon;

        private int spacing;

        private float terrainHeight;

        private float currentHeight;

        private int pending;

        private int loaded;

        /**
         * Latitude 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                signed = true,
                description = "Latitude"
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                signed = true,
                description = "Longitude"
        )
        public final Builder lon(int lon) {
            this.lon = lon;
            return this;
        }

        /**
         * grid spacing (zero if terrain at this location unavailable) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "grid spacing (zero if terrain at this location unavailable)"
        )
        public final Builder spacing(int spacing) {
            this.spacing = spacing;
            return this;
        }

        /**
         * Terrain height MSL 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Terrain height MSL"
        )
        public final Builder terrainHeight(float terrainHeight) {
            this.terrainHeight = terrainHeight;
            return this;
        }

        /**
         * Current vehicle height above lat/lon terrain height 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Current vehicle height above lat/lon terrain height"
        )
        public final Builder currentHeight(float currentHeight) {
            this.currentHeight = currentHeight;
            return this;
        }

        /**
         * Number of 4x4 terrain blocks waiting to be received or read from disk 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "Number of 4x4 terrain blocks waiting to be received or read from disk"
        )
        public final Builder pending(int pending) {
            this.pending = pending;
            return this;
        }

        /**
         * Number of 4x4 terrain blocks in memory 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                description = "Number of 4x4 terrain blocks in memory"
        )
        public final Builder loaded(int loaded) {
            this.loaded = loaded;
            return this;
        }

        public final TerrainReport build() {
            return new TerrainReport(lat, lon, spacing, terrainHeight, currentHeight, pending, loaded);
        }
    }
}
