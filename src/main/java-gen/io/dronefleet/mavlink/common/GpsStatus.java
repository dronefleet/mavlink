package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * The positioning status, as reported by GPS. This message is intended to display status 
 * information about each satellite visible to the receiver. See message {@link io.dronefleet.mavlink.common.GlobalPositionInt GLOBAL_POSITION_INT} 
 * for the global position estimate. This message can contain information for up to 20 
 * satellites. 
 */
@MavlinkMessageInfo(
        id = 25,
        crc = 23,
        description = "The positioning status, as reported by GPS. This message is intended to display status information about each satellite visible to the receiver. See message GLOBAL_POSITION_INT for the global position estimate. This message can contain information for up to 20 satellites."
)
public final class GpsStatus {
    private final int satellitesVisible;

    private final byte[] satellitePrn;

    private final byte[] satelliteUsed;

    private final byte[] satelliteElevation;

    private final byte[] satelliteAzimuth;

    private final byte[] satelliteSnr;

    private GpsStatus(int satellitesVisible, byte[] satellitePrn, byte[] satelliteUsed,
            byte[] satelliteElevation, byte[] satelliteAzimuth, byte[] satelliteSnr) {
        this.satellitesVisible = satellitesVisible;
        this.satellitePrn = satellitePrn;
        this.satelliteUsed = satelliteUsed;
        this.satelliteElevation = satelliteElevation;
        this.satelliteAzimuth = satelliteAzimuth;
        this.satelliteSnr = satelliteSnr;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Number of satellites visible 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "Number of satellites visible"
    )
    public final int satellitesVisible() {
        return this.satellitesVisible;
    }

    /**
     * Global satellite ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            arraySize = 20,
            description = "Global satellite ID"
    )
    public final byte[] satellitePrn() {
        return this.satellitePrn;
    }

    /**
     * 0: Satellite not used, 1: used for localization 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 20,
            description = "0: Satellite not used, 1: used for localization"
    )
    public final byte[] satelliteUsed() {
        return this.satelliteUsed;
    }

    /**
     * Elevation (0: right on top of receiver, 90: on the horizon) of satellite 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            arraySize = 20,
            description = "Elevation (0: right on top of receiver, 90: on the horizon) of satellite"
    )
    public final byte[] satelliteElevation() {
        return this.satelliteElevation;
    }

    /**
     * Direction of satellite, 0: 0 deg, 255: 360 deg. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            arraySize = 20,
            description = "Direction of satellite, 0: 0 deg, 255: 360 deg."
    )
    public final byte[] satelliteAzimuth() {
        return this.satelliteAzimuth;
    }

    /**
     * Signal to noise ratio of satellite 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            arraySize = 20,
            description = "Signal to noise ratio of satellite"
    )
    public final byte[] satelliteSnr() {
        return this.satelliteSnr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GpsStatus other = (GpsStatus)o;
        if (!Objects.deepEquals(satellitesVisible, other.satellitesVisible)) return false;
        if (!Objects.deepEquals(satellitePrn, other.satellitePrn)) return false;
        if (!Objects.deepEquals(satelliteUsed, other.satelliteUsed)) return false;
        if (!Objects.deepEquals(satelliteElevation, other.satelliteElevation)) return false;
        if (!Objects.deepEquals(satelliteAzimuth, other.satelliteAzimuth)) return false;
        if (!Objects.deepEquals(satelliteSnr, other.satelliteSnr)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(satellitesVisible);
        result = 31 * result + Objects.hashCode(satellitePrn);
        result = 31 * result + Objects.hashCode(satelliteUsed);
        result = 31 * result + Objects.hashCode(satelliteElevation);
        result = 31 * result + Objects.hashCode(satelliteAzimuth);
        result = 31 * result + Objects.hashCode(satelliteSnr);
        return result;
    }

    @Override
    public String toString() {
        return "GpsStatus{satellitesVisible=" + satellitesVisible
                 + ", satellitePrn=" + satellitePrn
                 + ", satelliteUsed=" + satelliteUsed
                 + ", satelliteElevation=" + satelliteElevation
                 + ", satelliteAzimuth=" + satelliteAzimuth
                 + ", satelliteSnr=" + satelliteSnr + "}";
    }

    public static final class Builder {
        private int satellitesVisible;

        private byte[] satellitePrn;

        private byte[] satelliteUsed;

        private byte[] satelliteElevation;

        private byte[] satelliteAzimuth;

        private byte[] satelliteSnr;

        /**
         * Number of satellites visible 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "Number of satellites visible"
        )
        public final Builder satellitesVisible(int satellitesVisible) {
            this.satellitesVisible = satellitesVisible;
            return this;
        }

        /**
         * Global satellite ID 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                arraySize = 20,
                description = "Global satellite ID"
        )
        public final Builder satellitePrn(byte[] satellitePrn) {
            this.satellitePrn = satellitePrn;
            return this;
        }

        /**
         * 0: Satellite not used, 1: used for localization 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 20,
                description = "0: Satellite not used, 1: used for localization"
        )
        public final Builder satelliteUsed(byte[] satelliteUsed) {
            this.satelliteUsed = satelliteUsed;
            return this;
        }

        /**
         * Elevation (0: right on top of receiver, 90: on the horizon) of satellite 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                arraySize = 20,
                description = "Elevation (0: right on top of receiver, 90: on the horizon) of satellite"
        )
        public final Builder satelliteElevation(byte[] satelliteElevation) {
            this.satelliteElevation = satelliteElevation;
            return this;
        }

        /**
         * Direction of satellite, 0: 0 deg, 255: 360 deg. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                arraySize = 20,
                description = "Direction of satellite, 0: 0 deg, 255: 360 deg."
        )
        public final Builder satelliteAzimuth(byte[] satelliteAzimuth) {
            this.satelliteAzimuth = satelliteAzimuth;
            return this;
        }

        /**
         * Signal to noise ratio of satellite 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                arraySize = 20,
                description = "Signal to noise ratio of satellite"
        )
        public final Builder satelliteSnr(byte[] satelliteSnr) {
            this.satelliteSnr = satelliteSnr;
            return this;
        }

        public final GpsStatus build() {
            return new GpsStatus(satellitesVisible, satellitePrn, satelliteUsed, satelliteElevation, satelliteAzimuth, satelliteSnr);
        }
    }
}
