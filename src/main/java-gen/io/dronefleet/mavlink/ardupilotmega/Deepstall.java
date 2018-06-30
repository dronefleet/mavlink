package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * Deepstall path planning 
 */
@MavlinkMessageInfo(
        id = 195,
        crc = 120
)
public final class Deepstall {
    private final int landingLat;

    private final int landingLon;

    private final int pathLat;

    private final int pathLon;

    private final int arcEntryLat;

    private final int arcEntryLon;

    private final float altitude;

    private final float expectedTravelDistance;

    private final float crossTrackError;

    private final DeepstallStage stage;

    private Deepstall(int landingLat, int landingLon, int pathLat, int pathLon, int arcEntryLat,
            int arcEntryLon, float altitude, float expectedTravelDistance, float crossTrackError,
            DeepstallStage stage) {
        this.landingLat = landingLat;
        this.landingLon = landingLon;
        this.pathLat = pathLat;
        this.pathLon = pathLon;
        this.arcEntryLat = arcEntryLat;
        this.arcEntryLon = arcEntryLon;
        this.altitude = altitude;
        this.expectedTravelDistance = expectedTravelDistance;
        this.crossTrackError = crossTrackError;
        this.stage = stage;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Landing latitude (deg * 1E7) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            signed = true
    )
    public final int landingLat() {
        return this.landingLat;
    }

    /**
     * Landing longitude (deg * 1E7) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            signed = true
    )
    public final int landingLon() {
        return this.landingLon;
    }

    /**
     * Final heading start point, latitude (deg * 1E7) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true
    )
    public final int pathLat() {
        return this.pathLat;
    }

    /**
     * Final heading start point, longitude (deg * 1E7) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true
    )
    public final int pathLon() {
        return this.pathLon;
    }

    /**
     * Arc entry point, latitude (deg * 1E7) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true
    )
    public final int arcEntryLat() {
        return this.arcEntryLat;
    }

    /**
     * Arc entry point, longitude (deg * 1E7) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            signed = true
    )
    public final int arcEntryLon() {
        return this.arcEntryLon;
    }

    /**
     * Altitude (meters) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float altitude() {
        return this.altitude;
    }

    /**
     * Distance the aircraft expects to travel during the deepstall 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float expectedTravelDistance() {
        return this.expectedTravelDistance;
    }

    /**
     * Deepstall cross track error in meters (only valid when in DEEPSTALL_STAGE_LAND) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float crossTrackError() {
        return this.crossTrackError;
    }

    /**
     * Deepstall stage, see enum MAV_DEEPSTALL_STAGE 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1
    )
    public final DeepstallStage stage() {
        return this.stage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Deepstall other = (Deepstall)o;
        if (!Objects.deepEquals(landingLat, other.landingLat)) return false;
        if (!Objects.deepEquals(landingLon, other.landingLon)) return false;
        if (!Objects.deepEquals(pathLat, other.pathLat)) return false;
        if (!Objects.deepEquals(pathLon, other.pathLon)) return false;
        if (!Objects.deepEquals(arcEntryLat, other.arcEntryLat)) return false;
        if (!Objects.deepEquals(arcEntryLon, other.arcEntryLon)) return false;
        if (!Objects.deepEquals(altitude, other.altitude)) return false;
        if (!Objects.deepEquals(expectedTravelDistance, other.expectedTravelDistance)) return false;
        if (!Objects.deepEquals(crossTrackError, other.crossTrackError)) return false;
        if (!Objects.deepEquals(stage, other.stage)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(landingLat);
        result = 31 * result + Objects.hashCode(landingLon);
        result = 31 * result + Objects.hashCode(pathLat);
        result = 31 * result + Objects.hashCode(pathLon);
        result = 31 * result + Objects.hashCode(arcEntryLat);
        result = 31 * result + Objects.hashCode(arcEntryLon);
        result = 31 * result + Objects.hashCode(altitude);
        result = 31 * result + Objects.hashCode(expectedTravelDistance);
        result = 31 * result + Objects.hashCode(crossTrackError);
        result = 31 * result + Objects.hashCode(stage);
        return result;
    }

    public static final class Builder {
        private int landingLat;

        private int landingLon;

        private int pathLat;

        private int pathLon;

        private int arcEntryLat;

        private int arcEntryLon;

        private float altitude;

        private float expectedTravelDistance;

        private float crossTrackError;

        private DeepstallStage stage;

        /**
         * Landing latitude (deg * 1E7) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                signed = true
        )
        public final Builder landingLat(int landingLat) {
            this.landingLat = landingLat;
            return this;
        }

        /**
         * Landing longitude (deg * 1E7) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                signed = true
        )
        public final Builder landingLon(int landingLon) {
            this.landingLon = landingLon;
            return this;
        }

        /**
         * Final heading start point, latitude (deg * 1E7) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true
        )
        public final Builder pathLat(int pathLat) {
            this.pathLat = pathLat;
            return this;
        }

        /**
         * Final heading start point, longitude (deg * 1E7) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true
        )
        public final Builder pathLon(int pathLon) {
            this.pathLon = pathLon;
            return this;
        }

        /**
         * Arc entry point, latitude (deg * 1E7) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true
        )
        public final Builder arcEntryLat(int arcEntryLat) {
            this.arcEntryLat = arcEntryLat;
            return this;
        }

        /**
         * Arc entry point, longitude (deg * 1E7) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                signed = true
        )
        public final Builder arcEntryLon(int arcEntryLon) {
            this.arcEntryLon = arcEntryLon;
            return this;
        }

        /**
         * Altitude (meters) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder altitude(float altitude) {
            this.altitude = altitude;
            return this;
        }

        /**
         * Distance the aircraft expects to travel during the deepstall 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder expectedTravelDistance(float expectedTravelDistance) {
            this.expectedTravelDistance = expectedTravelDistance;
            return this;
        }

        /**
         * Deepstall cross track error in meters (only valid when in DEEPSTALL_STAGE_LAND) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4
        )
        public final Builder crossTrackError(float crossTrackError) {
            this.crossTrackError = crossTrackError;
            return this;
        }

        /**
         * Deepstall stage, see enum MAV_DEEPSTALL_STAGE 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1
        )
        public final Builder stage(DeepstallStage stage) {
            this.stage = stage;
            return this;
        }

        public final Deepstall build() {
            return new Deepstall(landingLat, landingLon, pathLat, pathLon, arcEntryLat, arcEntryLon, altitude, expectedTravelDistance, crossTrackError, stage);
        }
    }
}
