package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Deprecated;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Data for filling the OpenDroneID Location message. The float data types are 32-bit IEEE 754. 
 * The Location message provides the location, altitude, direction and speed of the aircraft. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 12901,
        crc = 16,
        description = "Data for filling the OpenDroneID Location message. The float data types are 32-bit IEEE 754. The Location message provides the location, altitude, direction and speed of the aircraft.",
        workInProgress = true
)
@Deprecated
public final class OpenDroneIdLocation {
    private final EnumValue<MavOdidStatus> status;

    private final int direction;

    private final int speedHorizontal;

    private final int speedVertical;

    private final int latitude;

    private final int longitude;

    private final float altitudeBarometric;

    private final float altitudeGeodetic;

    private final EnumValue<MavOdidHeightRef> heightReference;

    private final float height;

    private final EnumValue<MavOdidHorAcc> horizontalAccuracy;

    private final EnumValue<MavOdidVerAcc> verticalAccuracy;

    private final EnumValue<MavOdidVerAcc> barometerAccuracy;

    private final EnumValue<MavOdidSpeedAcc> speedAccuracy;

    private final float timestamp;

    private final EnumValue<MavOdidTimeAcc> timestampAccuracy;

    private OpenDroneIdLocation(EnumValue<MavOdidStatus> status, int direction, int speedHorizontal,
            int speedVertical, int latitude, int longitude, float altitudeBarometric,
            float altitudeGeodetic, EnumValue<MavOdidHeightRef> heightReference, float height,
            EnumValue<MavOdidHorAcc> horizontalAccuracy, EnumValue<MavOdidVerAcc> verticalAccuracy,
            EnumValue<MavOdidVerAcc> barometerAccuracy, EnumValue<MavOdidSpeedAcc> speedAccuracy,
            float timestamp, EnumValue<MavOdidTimeAcc> timestampAccuracy) {
        this.status = status;
        this.direction = direction;
        this.speedHorizontal = speedHorizontal;
        this.speedVertical = speedVertical;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitudeBarometric = altitudeBarometric;
        this.altitudeGeodetic = altitudeGeodetic;
        this.heightReference = heightReference;
        this.height = height;
        this.horizontalAccuracy = horizontalAccuracy;
        this.verticalAccuracy = verticalAccuracy;
        this.barometerAccuracy = barometerAccuracy;
        this.speedAccuracy = speedAccuracy;
        this.timestamp = timestamp;
        this.timestampAccuracy = timestampAccuracy;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Indicates whether the Unmanned Aircraft is on the ground or in the air. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = MavOdidStatus.class,
            description = "Indicates whether the Unmanned Aircraft is on the ground or in the air."
    )
    public final EnumValue<MavOdidStatus> status() {
        return this.status;
    }

    /**
     * Direction over ground (not heading, but direction of movement) in degrees * 100: 0.0 - 359.99 
     * degrees. If unknown: 361.00 degrees. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "Direction over ground (not heading, but direction of movement) in degrees * 100: 0.0 - 359.99 degrees. If unknown: 361.00 degrees."
    )
    public final int direction() {
        return this.direction;
    }

    /**
     * Ground speed. Positive only. If unknown: 255.00 m/s. If speed is larger than 254.25 m/s, use 
     * 254.25 m/s. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "Ground speed. Positive only. If unknown: 255.00 m/s. If speed is larger than 254.25 m/s, use 254.25 m/s."
    )
    public final int speedHorizontal() {
        return this.speedHorizontal;
    }

    /**
     * The vertical speed. Up is positive. If unknown: 63.00 m/s. If speed is larger than 62.00 m/s, use 
     * 62.00 m/s. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            signed = true,
            description = "The vertical speed. Up is positive. If unknown: 63.00 m/s. If speed is larger than 62.00 m/s, use 62.00 m/s."
    )
    public final int speedVertical() {
        return this.speedVertical;
    }

    /**
     * Current latitude of the UA (Unmanned Aircraft). If unknown: 0 deg (both Lat/Lon). 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            signed = true,
            description = "Current latitude of the UA (Unmanned Aircraft). If unknown: 0 deg (both Lat/Lon)."
    )
    public final int latitude() {
        return this.latitude;
    }

    /**
     * Current longitude of the UA (Unmanned Aircraft). If unknown: 0 deg (both Lat/Lon). 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            signed = true,
            description = "Current longitude of the UA (Unmanned Aircraft). If unknown: 0 deg (both Lat/Lon)."
    )
    public final int longitude() {
        return this.longitude;
    }

    /**
     * The altitude calculated from the barometric pressue. Reference is against 29.92inHg or 
     * 1013.2mb. If unknown: -1000 m. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "The altitude calculated from the barometric pressue. Reference is against 29.92inHg or 1013.2mb. If unknown: -1000 m."
    )
    public final float altitudeBarometric() {
        return this.altitudeBarometric;
    }

    /**
     * The geodetic altitude as defined by WGS84. If unknown: -1000 m. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "The geodetic altitude as defined by WGS84. If unknown: -1000 m."
    )
    public final float altitudeGeodetic() {
        return this.altitudeGeodetic;
    }

    /**
     * Indicates the reference point for the height field. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1,
            enumType = MavOdidHeightRef.class,
            description = "Indicates the reference point for the height field."
    )
    public final EnumValue<MavOdidHeightRef> heightReference() {
        return this.heightReference;
    }

    /**
     * The current height of the UA (Unmanned Aircraft) above the take-off location or the ground as 
     * indicated by height_reference. If unknown: -1000 m. 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "The current height of the UA (Unmanned Aircraft) above the take-off location or the ground as indicated by height_reference. If unknown: -1000 m."
    )
    public final float height() {
        return this.height;
    }

    /**
     * The accuracy of the horizontal position. 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 1,
            enumType = MavOdidHorAcc.class,
            description = "The accuracy of the horizontal position."
    )
    public final EnumValue<MavOdidHorAcc> horizontalAccuracy() {
        return this.horizontalAccuracy;
    }

    /**
     * The accuracy of the vertical position. 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 1,
            enumType = MavOdidVerAcc.class,
            description = "The accuracy of the vertical position."
    )
    public final EnumValue<MavOdidVerAcc> verticalAccuracy() {
        return this.verticalAccuracy;
    }

    /**
     * The accuracy of the barometric altitude. 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 1,
            enumType = MavOdidVerAcc.class,
            description = "The accuracy of the barometric altitude."
    )
    public final EnumValue<MavOdidVerAcc> barometerAccuracy() {
        return this.barometerAccuracy;
    }

    /**
     * The accuracy of the horizontal and vertical speed. 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 1,
            enumType = MavOdidSpeedAcc.class,
            description = "The accuracy of the horizontal and vertical speed."
    )
    public final EnumValue<MavOdidSpeedAcc> speedAccuracy() {
        return this.speedAccuracy;
    }

    /**
     * Seconds after the full hour. Typically the GPS outputs a time of week value in milliseconds. 
     * That value can be easily converted for this field using ((float) (time_week_ms % 
     * (60*60*1000))) / 1000. 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 4,
            description = "Seconds after the full hour. Typically the GPS outputs a time of week value in milliseconds. That value can be easily converted for this field using ((float) (time_week_ms % (60*60*1000))) / 1000."
    )
    public final float timestamp() {
        return this.timestamp;
    }

    /**
     * The accuracy of the timestamps. 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 1,
            enumType = MavOdidTimeAcc.class,
            description = "The accuracy of the timestamps."
    )
    public final EnumValue<MavOdidTimeAcc> timestampAccuracy() {
        return this.timestampAccuracy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        OpenDroneIdLocation other = (OpenDroneIdLocation)o;
        if (!Objects.deepEquals(status, other.status)) return false;
        if (!Objects.deepEquals(direction, other.direction)) return false;
        if (!Objects.deepEquals(speedHorizontal, other.speedHorizontal)) return false;
        if (!Objects.deepEquals(speedVertical, other.speedVertical)) return false;
        if (!Objects.deepEquals(latitude, other.latitude)) return false;
        if (!Objects.deepEquals(longitude, other.longitude)) return false;
        if (!Objects.deepEquals(altitudeBarometric, other.altitudeBarometric)) return false;
        if (!Objects.deepEquals(altitudeGeodetic, other.altitudeGeodetic)) return false;
        if (!Objects.deepEquals(heightReference, other.heightReference)) return false;
        if (!Objects.deepEquals(height, other.height)) return false;
        if (!Objects.deepEquals(horizontalAccuracy, other.horizontalAccuracy)) return false;
        if (!Objects.deepEquals(verticalAccuracy, other.verticalAccuracy)) return false;
        if (!Objects.deepEquals(barometerAccuracy, other.barometerAccuracy)) return false;
        if (!Objects.deepEquals(speedAccuracy, other.speedAccuracy)) return false;
        if (!Objects.deepEquals(timestamp, other.timestamp)) return false;
        if (!Objects.deepEquals(timestampAccuracy, other.timestampAccuracy)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(status);
        result = 31 * result + Objects.hashCode(direction);
        result = 31 * result + Objects.hashCode(speedHorizontal);
        result = 31 * result + Objects.hashCode(speedVertical);
        result = 31 * result + Objects.hashCode(latitude);
        result = 31 * result + Objects.hashCode(longitude);
        result = 31 * result + Objects.hashCode(altitudeBarometric);
        result = 31 * result + Objects.hashCode(altitudeGeodetic);
        result = 31 * result + Objects.hashCode(heightReference);
        result = 31 * result + Objects.hashCode(height);
        result = 31 * result + Objects.hashCode(horizontalAccuracy);
        result = 31 * result + Objects.hashCode(verticalAccuracy);
        result = 31 * result + Objects.hashCode(barometerAccuracy);
        result = 31 * result + Objects.hashCode(speedAccuracy);
        result = 31 * result + Objects.hashCode(timestamp);
        result = 31 * result + Objects.hashCode(timestampAccuracy);
        return result;
    }

    @Override
    public String toString() {
        return "OpenDroneIdLocation{status=" + status
                 + ", direction=" + direction
                 + ", speedHorizontal=" + speedHorizontal
                 + ", speedVertical=" + speedVertical
                 + ", latitude=" + latitude
                 + ", longitude=" + longitude
                 + ", altitudeBarometric=" + altitudeBarometric
                 + ", altitudeGeodetic=" + altitudeGeodetic
                 + ", heightReference=" + heightReference
                 + ", height=" + height
                 + ", horizontalAccuracy=" + horizontalAccuracy
                 + ", verticalAccuracy=" + verticalAccuracy
                 + ", barometerAccuracy=" + barometerAccuracy
                 + ", speedAccuracy=" + speedAccuracy
                 + ", timestamp=" + timestamp
                 + ", timestampAccuracy=" + timestampAccuracy + "}";
    }

    public static final class Builder {
        private EnumValue<MavOdidStatus> status;

        private int direction;

        private int speedHorizontal;

        private int speedVertical;

        private int latitude;

        private int longitude;

        private float altitudeBarometric;

        private float altitudeGeodetic;

        private EnumValue<MavOdidHeightRef> heightReference;

        private float height;

        private EnumValue<MavOdidHorAcc> horizontalAccuracy;

        private EnumValue<MavOdidVerAcc> verticalAccuracy;

        private EnumValue<MavOdidVerAcc> barometerAccuracy;

        private EnumValue<MavOdidSpeedAcc> speedAccuracy;

        private float timestamp;

        private EnumValue<MavOdidTimeAcc> timestampAccuracy;

        /**
         * Indicates whether the Unmanned Aircraft is on the ground or in the air. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = MavOdidStatus.class,
                description = "Indicates whether the Unmanned Aircraft is on the ground or in the air."
        )
        public final Builder status(EnumValue<MavOdidStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Indicates whether the Unmanned Aircraft is on the ground or in the air. 
         */
        public final Builder status(MavOdidStatus entry) {
            return status(EnumValue.of(entry));
        }

        /**
         * Indicates whether the Unmanned Aircraft is on the ground or in the air. 
         */
        public final Builder status(Enum... flags) {
            return status(EnumValue.create(flags));
        }

        /**
         * Indicates whether the Unmanned Aircraft is on the ground or in the air. 
         */
        public final Builder status(Collection<Enum> flags) {
            return status(EnumValue.create(flags));
        }

        /**
         * Direction over ground (not heading, but direction of movement) in degrees * 100: 0.0 - 359.99 
         * degrees. If unknown: 361.00 degrees. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "Direction over ground (not heading, but direction of movement) in degrees * 100: 0.0 - 359.99 degrees. If unknown: 361.00 degrees."
        )
        public final Builder direction(int direction) {
            this.direction = direction;
            return this;
        }

        /**
         * Ground speed. Positive only. If unknown: 255.00 m/s. If speed is larger than 254.25 m/s, use 
         * 254.25 m/s. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "Ground speed. Positive only. If unknown: 255.00 m/s. If speed is larger than 254.25 m/s, use 254.25 m/s."
        )
        public final Builder speedHorizontal(int speedHorizontal) {
            this.speedHorizontal = speedHorizontal;
            return this;
        }

        /**
         * The vertical speed. Up is positive. If unknown: 63.00 m/s. If speed is larger than 62.00 m/s, use 
         * 62.00 m/s. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                signed = true,
                description = "The vertical speed. Up is positive. If unknown: 63.00 m/s. If speed is larger than 62.00 m/s, use 62.00 m/s."
        )
        public final Builder speedVertical(int speedVertical) {
            this.speedVertical = speedVertical;
            return this;
        }

        /**
         * Current latitude of the UA (Unmanned Aircraft). If unknown: 0 deg (both Lat/Lon). 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                signed = true,
                description = "Current latitude of the UA (Unmanned Aircraft). If unknown: 0 deg (both Lat/Lon)."
        )
        public final Builder latitude(int latitude) {
            this.latitude = latitude;
            return this;
        }

        /**
         * Current longitude of the UA (Unmanned Aircraft). If unknown: 0 deg (both Lat/Lon). 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                signed = true,
                description = "Current longitude of the UA (Unmanned Aircraft). If unknown: 0 deg (both Lat/Lon)."
        )
        public final Builder longitude(int longitude) {
            this.longitude = longitude;
            return this;
        }

        /**
         * The altitude calculated from the barometric pressue. Reference is against 29.92inHg or 
         * 1013.2mb. If unknown: -1000 m. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "The altitude calculated from the barometric pressue. Reference is against 29.92inHg or 1013.2mb. If unknown: -1000 m."
        )
        public final Builder altitudeBarometric(float altitudeBarometric) {
            this.altitudeBarometric = altitudeBarometric;
            return this;
        }

        /**
         * The geodetic altitude as defined by WGS84. If unknown: -1000 m. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "The geodetic altitude as defined by WGS84. If unknown: -1000 m."
        )
        public final Builder altitudeGeodetic(float altitudeGeodetic) {
            this.altitudeGeodetic = altitudeGeodetic;
            return this;
        }

        /**
         * Indicates the reference point for the height field. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1,
                enumType = MavOdidHeightRef.class,
                description = "Indicates the reference point for the height field."
        )
        public final Builder heightReference(EnumValue<MavOdidHeightRef> heightReference) {
            this.heightReference = heightReference;
            return this;
        }

        /**
         * Indicates the reference point for the height field. 
         */
        public final Builder heightReference(MavOdidHeightRef entry) {
            return heightReference(EnumValue.of(entry));
        }

        /**
         * Indicates the reference point for the height field. 
         */
        public final Builder heightReference(Enum... flags) {
            return heightReference(EnumValue.create(flags));
        }

        /**
         * Indicates the reference point for the height field. 
         */
        public final Builder heightReference(Collection<Enum> flags) {
            return heightReference(EnumValue.create(flags));
        }

        /**
         * The current height of the UA (Unmanned Aircraft) above the take-off location or the ground as 
         * indicated by height_reference. If unknown: -1000 m. 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "The current height of the UA (Unmanned Aircraft) above the take-off location or the ground as indicated by height_reference. If unknown: -1000 m."
        )
        public final Builder height(float height) {
            this.height = height;
            return this;
        }

        /**
         * The accuracy of the horizontal position. 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 1,
                enumType = MavOdidHorAcc.class,
                description = "The accuracy of the horizontal position."
        )
        public final Builder horizontalAccuracy(EnumValue<MavOdidHorAcc> horizontalAccuracy) {
            this.horizontalAccuracy = horizontalAccuracy;
            return this;
        }

        /**
         * The accuracy of the horizontal position. 
         */
        public final Builder horizontalAccuracy(MavOdidHorAcc entry) {
            return horizontalAccuracy(EnumValue.of(entry));
        }

        /**
         * The accuracy of the horizontal position. 
         */
        public final Builder horizontalAccuracy(Enum... flags) {
            return horizontalAccuracy(EnumValue.create(flags));
        }

        /**
         * The accuracy of the horizontal position. 
         */
        public final Builder horizontalAccuracy(Collection<Enum> flags) {
            return horizontalAccuracy(EnumValue.create(flags));
        }

        /**
         * The accuracy of the vertical position. 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 1,
                enumType = MavOdidVerAcc.class,
                description = "The accuracy of the vertical position."
        )
        public final Builder verticalAccuracy(EnumValue<MavOdidVerAcc> verticalAccuracy) {
            this.verticalAccuracy = verticalAccuracy;
            return this;
        }

        /**
         * The accuracy of the vertical position. 
         */
        public final Builder verticalAccuracy(MavOdidVerAcc entry) {
            return verticalAccuracy(EnumValue.of(entry));
        }

        /**
         * The accuracy of the vertical position. 
         */
        public final Builder verticalAccuracy(Enum... flags) {
            return verticalAccuracy(EnumValue.create(flags));
        }

        /**
         * The accuracy of the vertical position. 
         */
        public final Builder verticalAccuracy(Collection<Enum> flags) {
            return verticalAccuracy(EnumValue.create(flags));
        }

        /**
         * The accuracy of the barometric altitude. 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 1,
                enumType = MavOdidVerAcc.class,
                description = "The accuracy of the barometric altitude."
        )
        public final Builder barometerAccuracy(EnumValue<MavOdidVerAcc> barometerAccuracy) {
            this.barometerAccuracy = barometerAccuracy;
            return this;
        }

        /**
         * The accuracy of the barometric altitude. 
         */
        public final Builder barometerAccuracy(MavOdidVerAcc entry) {
            return barometerAccuracy(EnumValue.of(entry));
        }

        /**
         * The accuracy of the barometric altitude. 
         */
        public final Builder barometerAccuracy(Enum... flags) {
            return barometerAccuracy(EnumValue.create(flags));
        }

        /**
         * The accuracy of the barometric altitude. 
         */
        public final Builder barometerAccuracy(Collection<Enum> flags) {
            return barometerAccuracy(EnumValue.create(flags));
        }

        /**
         * The accuracy of the horizontal and vertical speed. 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 1,
                enumType = MavOdidSpeedAcc.class,
                description = "The accuracy of the horizontal and vertical speed."
        )
        public final Builder speedAccuracy(EnumValue<MavOdidSpeedAcc> speedAccuracy) {
            this.speedAccuracy = speedAccuracy;
            return this;
        }

        /**
         * The accuracy of the horizontal and vertical speed. 
         */
        public final Builder speedAccuracy(MavOdidSpeedAcc entry) {
            return speedAccuracy(EnumValue.of(entry));
        }

        /**
         * The accuracy of the horizontal and vertical speed. 
         */
        public final Builder speedAccuracy(Enum... flags) {
            return speedAccuracy(EnumValue.create(flags));
        }

        /**
         * The accuracy of the horizontal and vertical speed. 
         */
        public final Builder speedAccuracy(Collection<Enum> flags) {
            return speedAccuracy(EnumValue.create(flags));
        }

        /**
         * Seconds after the full hour. Typically the GPS outputs a time of week value in milliseconds. 
         * That value can be easily converted for this field using ((float) (time_week_ms % 
         * (60*60*1000))) / 1000. 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 4,
                description = "Seconds after the full hour. Typically the GPS outputs a time of week value in milliseconds. That value can be easily converted for this field using ((float) (time_week_ms % (60*60*1000))) / 1000."
        )
        public final Builder timestamp(float timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * The accuracy of the timestamps. 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 1,
                enumType = MavOdidTimeAcc.class,
                description = "The accuracy of the timestamps."
        )
        public final Builder timestampAccuracy(EnumValue<MavOdidTimeAcc> timestampAccuracy) {
            this.timestampAccuracy = timestampAccuracy;
            return this;
        }

        /**
         * The accuracy of the timestamps. 
         */
        public final Builder timestampAccuracy(MavOdidTimeAcc entry) {
            return timestampAccuracy(EnumValue.of(entry));
        }

        /**
         * The accuracy of the timestamps. 
         */
        public final Builder timestampAccuracy(Enum... flags) {
            return timestampAccuracy(EnumValue.create(flags));
        }

        /**
         * The accuracy of the timestamps. 
         */
        public final Builder timestampAccuracy(Collection<Enum> flags) {
            return timestampAccuracy(EnumValue.create(flags));
        }

        public final OpenDroneIdLocation build() {
            return new OpenDroneIdLocation(status, direction, speedHorizontal, speedVertical, latitude, longitude, altitudeBarometric, altitudeGeodetic, heightReference, height, horizontalAccuracy, verticalAccuracy, barometerAccuracy, speedAccuracy, timestamp, timestampAccuracy);
        }
    }
}
