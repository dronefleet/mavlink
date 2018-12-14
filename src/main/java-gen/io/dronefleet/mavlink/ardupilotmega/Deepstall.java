package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Deepstall path planning. 
 */
@MavlinkMessageInfo(
        id = 195,
        crc = 120,
        description = "Deepstall path planning."
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

    private final EnumValue<DeepstallStage> stage;

    private Deepstall(int landingLat, int landingLon, int pathLat, int pathLon, int arcEntryLat,
            int arcEntryLon, float altitude, float expectedTravelDistance, float crossTrackError,
            EnumValue<DeepstallStage> stage) {
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
     * Landing latitude. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            signed = true,
            description = "Landing latitude."
    )
    public final int landingLat() {
        return this.landingLat;
    }

    /**
     * Landing longitude. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            signed = true,
            description = "Landing longitude."
    )
    public final int landingLon() {
        return this.landingLon;
    }

    /**
     * Final heading start point, latitude. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true,
            description = "Final heading start point, latitude."
    )
    public final int pathLat() {
        return this.pathLat;
    }

    /**
     * Final heading start point, longitude. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true,
            description = "Final heading start point, longitude."
    )
    public final int pathLon() {
        return this.pathLon;
    }

    /**
     * Arc entry point, latitude. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "Arc entry point, latitude."
    )
    public final int arcEntryLat() {
        return this.arcEntryLat;
    }

    /**
     * Arc entry point, longitude. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            signed = true,
            description = "Arc entry point, longitude."
    )
    public final int arcEntryLon() {
        return this.arcEntryLon;
    }

    /**
     * Altitude. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Altitude."
    )
    public final float altitude() {
        return this.altitude;
    }

    /**
     * Distance the aircraft expects to travel during the deepstall. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Distance the aircraft expects to travel during the deepstall."
    )
    public final float expectedTravelDistance() {
        return this.expectedTravelDistance;
    }

    /**
     * Deepstall cross track error (only valid when in DEEPSTALL_STAGE_LAND). 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Deepstall cross track error (only valid when in DEEPSTALL_STAGE_LAND)."
    )
    public final float crossTrackError() {
        return this.crossTrackError;
    }

    /**
     * Deepstall stage. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1,
            enumType = DeepstallStage.class,
            description = "Deepstall stage."
    )
    public final EnumValue<DeepstallStage> stage() {
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

    @Override
    public String toString() {
        return "Deepstall{landingLat=" + landingLat
                 + ", landingLon=" + landingLon
                 + ", pathLat=" + pathLat
                 + ", pathLon=" + pathLon
                 + ", arcEntryLat=" + arcEntryLat
                 + ", arcEntryLon=" + arcEntryLon
                 + ", altitude=" + altitude
                 + ", expectedTravelDistance=" + expectedTravelDistance
                 + ", crossTrackError=" + crossTrackError
                 + ", stage=" + stage + "}";
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

        private EnumValue<DeepstallStage> stage;

        /**
         * Landing latitude. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                signed = true,
                description = "Landing latitude."
        )
        public final Builder landingLat(int landingLat) {
            this.landingLat = landingLat;
            return this;
        }

        /**
         * Landing longitude. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                signed = true,
                description = "Landing longitude."
        )
        public final Builder landingLon(int landingLon) {
            this.landingLon = landingLon;
            return this;
        }

        /**
         * Final heading start point, latitude. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true,
                description = "Final heading start point, latitude."
        )
        public final Builder pathLat(int pathLat) {
            this.pathLat = pathLat;
            return this;
        }

        /**
         * Final heading start point, longitude. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true,
                description = "Final heading start point, longitude."
        )
        public final Builder pathLon(int pathLon) {
            this.pathLon = pathLon;
            return this;
        }

        /**
         * Arc entry point, latitude. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "Arc entry point, latitude."
        )
        public final Builder arcEntryLat(int arcEntryLat) {
            this.arcEntryLat = arcEntryLat;
            return this;
        }

        /**
         * Arc entry point, longitude. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                signed = true,
                description = "Arc entry point, longitude."
        )
        public final Builder arcEntryLon(int arcEntryLon) {
            this.arcEntryLon = arcEntryLon;
            return this;
        }

        /**
         * Altitude. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Altitude."
        )
        public final Builder altitude(float altitude) {
            this.altitude = altitude;
            return this;
        }

        /**
         * Distance the aircraft expects to travel during the deepstall. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Distance the aircraft expects to travel during the deepstall."
        )
        public final Builder expectedTravelDistance(float expectedTravelDistance) {
            this.expectedTravelDistance = expectedTravelDistance;
            return this;
        }

        /**
         * Deepstall cross track error (only valid when in DEEPSTALL_STAGE_LAND). 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Deepstall cross track error (only valid when in DEEPSTALL_STAGE_LAND)."
        )
        public final Builder crossTrackError(float crossTrackError) {
            this.crossTrackError = crossTrackError;
            return this;
        }

        /**
         * Deepstall stage. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1,
                enumType = DeepstallStage.class,
                description = "Deepstall stage."
        )
        public final Builder stage(EnumValue<DeepstallStage> stage) {
            this.stage = stage;
            return this;
        }

        /**
         * Deepstall stage. 
         */
        public final Builder stage(DeepstallStage entry) {
            return stage(EnumValue.of(entry));
        }

        /**
         * Deepstall stage. 
         */
        public final Builder stage(Enum... flags) {
            return stage(EnumValue.create(flags));
        }

        /**
         * Deepstall stage. 
         */
        public final Builder stage(Collection<Enum> flags) {
            return stage(EnumValue.create(flags));
        }

        public final Deepstall build() {
            return new Deepstall(landingLat, landingLon, pathLat, pathLon, arcEntryLat, arcEntryLon, altitude, expectedTravelDistance, crossTrackError, stage);
        }
    }
}
