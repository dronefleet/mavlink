package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Update the data in the {@link io.dronefleet.mavlink.common.OpenDroneIdSystem OPEN_DRONE_ID_SYSTEM} message with new location information. This can 
 * be sent to update the location information for the operator when no other information in the 
 * SYSTEM message has changed. This message allows for efficient operation on radio links which 
 * have limited uplink bandwidth while meeting requirements for update frequency of the 
 * operator location. 
 */
@MavlinkMessageInfo(
        id = 12919,
        crc = 7,
        description = "Update the data in the OPEN_DRONE_ID_SYSTEM message with new location information. This can be sent to update the location information for the operator when no other information in the SYSTEM message has changed. This message allows for efficient operation on radio links which have limited uplink bandwidth while meeting requirements for update frequency of the operator location."
)
public final class OpenDroneIdSystemUpdate {
    private final int targetSystem;

    private final int targetComponent;

    private final int operatorLatitude;

    private final int operatorLongitude;

    private final float operatorAltitudeGeo;

    private final long timestamp;

    private OpenDroneIdSystemUpdate(int targetSystem, int targetComponent, int operatorLatitude,
            int operatorLongitude, float operatorAltitudeGeo, long timestamp) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.operatorLatitude = operatorLatitude;
        this.operatorLongitude = operatorLongitude;
        this.operatorAltitudeGeo = operatorAltitudeGeo;
        this.timestamp = timestamp;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID (0 for broadcast). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "System ID (0 for broadcast)."
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID (0 for broadcast). 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID (0 for broadcast)."
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Latitude of the operator. If unknown: 0 (both Lat/Lon). 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true,
            description = "Latitude of the operator. If unknown: 0 (both Lat/Lon)."
    )
    public final int operatorLatitude() {
        return this.operatorLatitude;
    }

    /**
     * Longitude of the operator. If unknown: 0 (both Lat/Lon). 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true,
            description = "Longitude of the operator. If unknown: 0 (both Lat/Lon)."
    )
    public final int operatorLongitude() {
        return this.operatorLongitude;
    }

    /**
     * Geodetic altitude of the operator relative to WGS84. If unknown: -1000 m. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Geodetic altitude of the operator relative to WGS84. If unknown: -1000 m."
    )
    public final float operatorAltitudeGeo() {
        return this.operatorAltitudeGeo;
    }

    /**
     * 32 bit Unix Timestamp in seconds since 00:00:00 01/01/2019. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "32 bit Unix Timestamp in seconds since 00:00:00 01/01/2019."
    )
    public final long timestamp() {
        return this.timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        OpenDroneIdSystemUpdate other = (OpenDroneIdSystemUpdate)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(operatorLatitude, other.operatorLatitude)) return false;
        if (!Objects.deepEquals(operatorLongitude, other.operatorLongitude)) return false;
        if (!Objects.deepEquals(operatorAltitudeGeo, other.operatorAltitudeGeo)) return false;
        if (!Objects.deepEquals(timestamp, other.timestamp)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(operatorLatitude);
        result = 31 * result + Objects.hashCode(operatorLongitude);
        result = 31 * result + Objects.hashCode(operatorAltitudeGeo);
        result = 31 * result + Objects.hashCode(timestamp);
        return result;
    }

    @Override
    public String toString() {
        return "OpenDroneIdSystemUpdate{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", operatorLatitude=" + operatorLatitude
                 + ", operatorLongitude=" + operatorLongitude
                 + ", operatorAltitudeGeo=" + operatorAltitudeGeo
                 + ", timestamp=" + timestamp + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int operatorLatitude;

        private int operatorLongitude;

        private float operatorAltitudeGeo;

        private long timestamp;

        /**
         * System ID (0 for broadcast). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "System ID (0 for broadcast)."
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID (0 for broadcast). 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Component ID (0 for broadcast)."
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Latitude of the operator. If unknown: 0 (both Lat/Lon). 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true,
                description = "Latitude of the operator. If unknown: 0 (both Lat/Lon)."
        )
        public final Builder operatorLatitude(int operatorLatitude) {
            this.operatorLatitude = operatorLatitude;
            return this;
        }

        /**
         * Longitude of the operator. If unknown: 0 (both Lat/Lon). 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true,
                description = "Longitude of the operator. If unknown: 0 (both Lat/Lon)."
        )
        public final Builder operatorLongitude(int operatorLongitude) {
            this.operatorLongitude = operatorLongitude;
            return this;
        }

        /**
         * Geodetic altitude of the operator relative to WGS84. If unknown: -1000 m. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Geodetic altitude of the operator relative to WGS84. If unknown: -1000 m."
        )
        public final Builder operatorAltitudeGeo(float operatorAltitudeGeo) {
            this.operatorAltitudeGeo = operatorAltitudeGeo;
            return this;
        }

        /**
         * 32 bit Unix Timestamp in seconds since 00:00:00 01/01/2019. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "32 bit Unix Timestamp in seconds since 00:00:00 01/01/2019."
        )
        public final Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public final OpenDroneIdSystemUpdate build() {
            return new OpenDroneIdSystemUpdate(targetSystem, targetComponent, operatorLatitude, operatorLongitude, operatorAltitudeGeo, timestamp);
        }
    }
}
