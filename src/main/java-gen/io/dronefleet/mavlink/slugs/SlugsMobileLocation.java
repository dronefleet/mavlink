package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Transmits the last known position of the mobile GS to the UAV. Very relevant when Track Mobile is 
 * enabled 
 */
@MavlinkMessageInfo(
        id = 186,
        crc = 101
)
public final class SlugsMobileLocation {
    /**
     * Mobile Latitude 
     */
    private final float latitude;

    /**
     * Mobile Longitude 
     */
    private final float longitude;

    /**
     * The system reporting the action 
     */
    private final int target;

    private SlugsMobileLocation(float latitude, float longitude, int target) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.target = target;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "SlugsMobileLocation{target=" + target
                 + ", latitude=" + latitude
                 + ", longitude=" + longitude + "}";
    }

    /**
     * Mobile Latitude 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float latitude() {
        return latitude;
    }

    /**
     * Mobile Longitude 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float longitude() {
        return longitude;
    }

    /**
     * The system reporting the action 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int target() {
        return target;
    }

    public static class Builder {
        private float latitude;

        private float longitude;

        private int target;

        private Builder() {
        }

        /**
         * Mobile Latitude 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder latitude(float latitude) {
            this.latitude = latitude;
            return this;
        }

        /**
         * Mobile Longitude 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder longitude(float longitude) {
            this.longitude = longitude;
            return this;
        }

        /**
         * The system reporting the action 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder target(int target) {
            this.target = target;
            return this;
        }

        public final SlugsMobileLocation build() {
            return new SlugsMobileLocation(latitude, longitude, target);
        }
    }
}
