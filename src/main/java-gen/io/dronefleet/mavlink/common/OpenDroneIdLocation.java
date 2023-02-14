package io.dronefleet.mavlink.common;

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
 * Data for filling the OpenDroneID Location message. The float data types are 32-bit IEEE 754. 
 * The Location message provides the location, altitude, direction and speed of the aircraft. 
 */
@MavlinkMessageInfo(
        id = 12901,
        crc = 254,
        description = "Data for filling the OpenDroneID Location message. The float data types are 32-bit IEEE 754. The Location message provides the location, altitude, direction and speed of the aircraft."
)
public final class OpenDroneIdLocation {
    private final int targetSystem;

    private final int targetComponent;

    private final byte[] idOrMac;

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

    private OpenDroneIdLocation(int targetSystem, int targetComponent, byte[] idOrMac,
            EnumValue<MavOdidStatus> status, int direction, int speedHorizontal, int speedVertical,
            int latitude, int longitude, float altitudeBarometric, float altitudeGeodetic,
            EnumValue<MavOdidHeightRef> heightReference, float height,
            EnumValue<MavOdidHorAcc> horizontalAccuracy, EnumValue<MavOdidVerAcc> verticalAccuracy,
            EnumValue<MavOdidVerAcc> barometerAccuracy, EnumValue<MavOdidSpeedAcc> speedAccuracy,
            float timestamp, EnumValue<MavOdidTimeAcc> timestampAccuracy) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.idOrMac = idOrMac;
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
     * Only used for drone ID data received from other UAs. See detailed description at 
     * https://mavlink.io/en/services/opendroneid.html. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 20,
            description = "Only used for drone ID data received from other UAs. See detailed description at https://mavlink.io/en/services/opendroneid.html."
    )
    public final byte[] idOrMac() {
        return this.idOrMac;
    }

    /**
     * Indicates whether the unmanned aircraft is on the ground or in the air. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = MavOdidStatus.class,
            description = "Indicates whether the unmanned aircraft is on the ground or in the air."
    )
    public final EnumValue<MavOdidStatus> status() {
        return this.status;
    }

    /**
     * Direction over ground (not heading, but direction of movement) measured clockwise from true 
     * North: 0 - 35999 centi-degrees. If unknown: 36100 centi-degrees. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "Direction over ground (not heading, but direction of movement) measured clockwise from true North: 0 - 35999 centi-degrees. If unknown: 36100 centi-degrees."
    )
    public final int direction() {
        return this.direction;
    }

    /**
     * Ground speed. Positive only. If unknown: 25500 cm/s. If speed is larger than 25425 cm/s, use 
     * 25425 cm/s. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "Ground speed. Positive only. If unknown: 25500 cm/s. If speed is larger than 25425 cm/s, use 25425 cm/s."
    )
    public final int speedHorizontal() {
        return this.speedHorizontal;
    }

    /**
     * The vertical speed. Up is positive. If unknown: 6300 cm/s. If speed is larger than 6200 cm/s, use 
     * 6200 cm/s. If lower than -6200 cm/s, use -6200 cm/s. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            signed = true,
            description = "The vertical speed. Up is positive. If unknown: 6300 cm/s. If speed is larger than 6200 cm/s, use 6200 cm/s. If lower than -6200 cm/s, use -6200 cm/s."
    )
    public final int speedVertical() {
        return this.speedVertical;
    }

    /**
     * Current latitude of the unmanned aircraft. If unknown: 0 (both Lat/Lon). 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            signed = true,
            description = "Current latitude of the unmanned aircraft. If unknown: 0 (both Lat/Lon)."
    )
    public final int latitude() {
        return this.latitude;
    }

    /**
     * Current longitude of the unmanned aircraft. If unknown: 0 (both Lat/Lon). 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            signed = true,
            description = "Current longitude of the unmanned aircraft. If unknown: 0 (both Lat/Lon)."
    )
    public final int longitude() {
        return this.longitude;
    }

    /**
     * The altitude calculated from the barometric pressue. Reference is against 29.92inHg or 
     * 1013.2mb. If unknown: -1000 m. 
     */
    @MavlinkFieldInfo(
            position = 10,
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
            position = 11,
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
            position = 12,
            unitSize = 1,
            enumType = MavOdidHeightRef.class,
            description = "Indicates the reference point for the height field."
    )
    public final EnumValue<MavOdidHeightRef> heightReference() {
        return this.heightReference;
    }

    /**
     * The current height of the unmanned aircraft above the take-off location or the ground as 
     * indicated by height_reference. If unknown: -1000 m. 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            description = "The current height of the unmanned aircraft above the take-off location or the ground as indicated by height_reference. If unknown: -1000 m."
    )
    public final float height() {
        return this.height;
    }

    /**
     * The accuracy of the horizontal position. 
     */
    @MavlinkFieldInfo(
            position = 14,
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
            position = 15,
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
            position = 16,
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
            position = 17,
            unitSize = 1,
            enumType = MavOdidSpeedAcc.class,
            description = "The accuracy of the horizontal and vertical speed."
    )
    public final EnumValue<MavOdidSpeedAcc> speedAccuracy() {
        return this.speedAccuracy;
    }

    /**
     * Seconds after the full hour with reference to UTC time. Typically the GPS outputs a 
     * time-of-week value in milliseconds. First convert that to UTC and then convert for this field 
     * using ((float) (time_week_ms % (60*60*1000))) / 1000. If unknown: 0xFFFF. 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 4,
            description = "Seconds after the full hour with reference to UTC time. Typically the GPS outputs a time-of-week value in milliseconds. First convert that to UTC and then convert for this field using ((float) (time_week_ms % (60*60*1000))) / 1000. If unknown: 0xFFFF."
    )
    public final float timestamp() {
        return this.timestamp;
    }

    /**
     * The accuracy of the timestamps. 
     */
    @MavlinkFieldInfo(
            position = 19,
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
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(idOrMac, other.idOrMac)) return false;
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
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(idOrMac);
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
        return "OpenDroneIdLocation{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", idOrMac=" + idOrMac
                 + ", status=" + status
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
        private int targetSystem;

        private int targetComponent;

        private byte[] idOrMac;

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
         * Only used for drone ID data received from other UAs. See detailed description at 
         * https://mavlink.io/en/services/opendroneid.html. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 20,
                description = "Only used for drone ID data received from other UAs. See detailed description at https://mavlink.io/en/services/opendroneid.html."
        )
        public final Builder idOrMac(byte[] idOrMac) {
            this.idOrMac = idOrMac;
            return this;
        }

        /**
         * Indicates whether the unmanned aircraft is on the ground or in the air. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = MavOdidStatus.class,
                description = "Indicates whether the unmanned aircraft is on the ground or in the air."
        )
        public final Builder status(EnumValue<MavOdidStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Indicates whether the unmanned aircraft is on the ground or in the air. 
         */
        public final Builder status(MavOdidStatus entry) {
            return status(EnumValue.of(entry));
        }

        /**
         * Indicates whether the unmanned aircraft is on the ground or in the air. 
         */
        public final Builder status(Enum... flags) {
            return status(EnumValue.create(flags));
        }

        /**
         * Indicates whether the unmanned aircraft is on the ground or in the air. 
         */
        public final Builder status(Collection<Enum> flags) {
            return status(EnumValue.create(flags));
        }

        /**
         * Direction over ground (not heading, but direction of movement) measured clockwise from true 
         * North: 0 - 35999 centi-degrees. If unknown: 36100 centi-degrees. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "Direction over ground (not heading, but direction of movement) measured clockwise from true North: 0 - 35999 centi-degrees. If unknown: 36100 centi-degrees."
        )
        public final Builder direction(int direction) {
            this.direction = direction;
            return this;
        }

        /**
         * Ground speed. Positive only. If unknown: 25500 cm/s. If speed is larger than 25425 cm/s, use 
         * 25425 cm/s. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "Ground speed. Positive only. If unknown: 25500 cm/s. If speed is larger than 25425 cm/s, use 25425 cm/s."
        )
        public final Builder speedHorizontal(int speedHorizontal) {
            this.speedHorizontal = speedHorizontal;
            return this;
        }

        /**
         * The vertical speed. Up is positive. If unknown: 6300 cm/s. If speed is larger than 6200 cm/s, use 
         * 6200 cm/s. If lower than -6200 cm/s, use -6200 cm/s. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                signed = true,
                description = "The vertical speed. Up is positive. If unknown: 6300 cm/s. If speed is larger than 6200 cm/s, use 6200 cm/s. If lower than -6200 cm/s, use -6200 cm/s."
        )
        public final Builder speedVertical(int speedVertical) {
            this.speedVertical = speedVertical;
            return this;
        }

        /**
         * Current latitude of the unmanned aircraft. If unknown: 0 (both Lat/Lon). 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                signed = true,
                description = "Current latitude of the unmanned aircraft. If unknown: 0 (both Lat/Lon)."
        )
        public final Builder latitude(int latitude) {
            this.latitude = latitude;
            return this;
        }

        /**
         * Current longitude of the unmanned aircraft. If unknown: 0 (both Lat/Lon). 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                signed = true,
                description = "Current longitude of the unmanned aircraft. If unknown: 0 (both Lat/Lon)."
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
                position = 10,
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
                position = 11,
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
                position = 12,
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
         * The current height of the unmanned aircraft above the take-off location or the ground as 
         * indicated by height_reference. If unknown: -1000 m. 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                description = "The current height of the unmanned aircraft above the take-off location or the ground as indicated by height_reference. If unknown: -1000 m."
        )
        public final Builder height(float height) {
            this.height = height;
            return this;
        }

        /**
         * The accuracy of the horizontal position. 
         */
        @MavlinkFieldInfo(
                position = 14,
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
                position = 15,
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
                position = 16,
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
                position = 17,
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
         * Seconds after the full hour with reference to UTC time. Typically the GPS outputs a 
         * time-of-week value in milliseconds. First convert that to UTC and then convert for this field 
         * using ((float) (time_week_ms % (60*60*1000))) / 1000. If unknown: 0xFFFF. 
         */
        @MavlinkFieldInfo(
                position = 18,
                unitSize = 4,
                description = "Seconds after the full hour with reference to UTC time. Typically the GPS outputs a time-of-week value in milliseconds. First convert that to UTC and then convert for this field using ((float) (time_week_ms % (60*60*1000))) / 1000. If unknown: 0xFFFF."
        )
        public final Builder timestamp(float timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * The accuracy of the timestamps. 
         */
        @MavlinkFieldInfo(
                position = 19,
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
            return new OpenDroneIdLocation(targetSystem, targetComponent, idOrMac, status, direction, speedHorizontal, speedVertical, latitude, longitude, altitudeBarometric, altitudeGeodetic, heightReference, height, horizontalAccuracy, verticalAccuracy, barometerAccuracy, speedAccuracy, timestamp, timestampAccuracy);
        }
    }
}
