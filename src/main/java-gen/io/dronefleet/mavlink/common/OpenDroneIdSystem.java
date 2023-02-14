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
 * Data for filling the OpenDroneID System message. The System Message contains general system 
 * information including the operator location/altitude and possible aircraft group and/or 
 * category/class information. 
 */
@MavlinkMessageInfo(
        id = 12904,
        crc = 77,
        description = "Data for filling the OpenDroneID System message. The System Message contains general system information including the operator location/altitude and possible aircraft group and/or category/class information."
)
public final class OpenDroneIdSystem {
    private final int targetSystem;

    private final int targetComponent;

    private final byte[] idOrMac;

    private final EnumValue<MavOdidOperatorLocationType> operatorLocationType;

    private final EnumValue<MavOdidClassificationType> classificationType;

    private final int operatorLatitude;

    private final int operatorLongitude;

    private final int areaCount;

    private final int areaRadius;

    private final float areaCeiling;

    private final float areaFloor;

    private final EnumValue<MavOdidCategoryEu> categoryEu;

    private final EnumValue<MavOdidClassEu> classEu;

    private final float operatorAltitudeGeo;

    private final long timestamp;

    private OpenDroneIdSystem(int targetSystem, int targetComponent, byte[] idOrMac,
            EnumValue<MavOdidOperatorLocationType> operatorLocationType,
            EnumValue<MavOdidClassificationType> classificationType, int operatorLatitude,
            int operatorLongitude, int areaCount, int areaRadius, float areaCeiling,
            float areaFloor, EnumValue<MavOdidCategoryEu> categoryEu,
            EnumValue<MavOdidClassEu> classEu, float operatorAltitudeGeo, long timestamp) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.idOrMac = idOrMac;
        this.operatorLocationType = operatorLocationType;
        this.classificationType = classificationType;
        this.operatorLatitude = operatorLatitude;
        this.operatorLongitude = operatorLongitude;
        this.areaCount = areaCount;
        this.areaRadius = areaRadius;
        this.areaCeiling = areaCeiling;
        this.areaFloor = areaFloor;
        this.categoryEu = categoryEu;
        this.classEu = classEu;
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
     * Specifies the operator location type. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = MavOdidOperatorLocationType.class,
            description = "Specifies the operator location type."
    )
    public final EnumValue<MavOdidOperatorLocationType> operatorLocationType() {
        return this.operatorLocationType;
    }

    /**
     * Specifies the classification type of the UA. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            enumType = MavOdidClassificationType.class,
            description = "Specifies the classification type of the UA."
    )
    public final EnumValue<MavOdidClassificationType> classificationType() {
        return this.classificationType;
    }

    /**
     * Latitude of the operator. If unknown: 0 (both Lat/Lon). 
     */
    @MavlinkFieldInfo(
            position = 6,
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
            position = 7,
            unitSize = 4,
            signed = true,
            description = "Longitude of the operator. If unknown: 0 (both Lat/Lon)."
    )
    public final int operatorLongitude() {
        return this.operatorLongitude;
    }

    /**
     * Number of aircraft in the area, group or formation (default 1). Used only for swarms/multiple 
     * UA. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            description = "Number of aircraft in the area, group or formation (default 1). Used only for swarms/multiple UA."
    )
    public final int areaCount() {
        return this.areaCount;
    }

    /**
     * Radius of the cylindrical area of the group or formation (default 0). Used only for 
     * swarms/multiple UA. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            description = "Radius of the cylindrical area of the group or formation (default 0). Used only for swarms/multiple UA."
    )
    public final int areaRadius() {
        return this.areaRadius;
    }

    /**
     * Area Operations Ceiling relative to WGS84. If unknown: -1000 m. Used only for swarms/multiple 
     * UA. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Area Operations Ceiling relative to WGS84. If unknown: -1000 m. Used only for swarms/multiple UA."
    )
    public final float areaCeiling() {
        return this.areaCeiling;
    }

    /**
     * Area Operations Floor relative to WGS84. If unknown: -1000 m. Used only for swarms/multiple 
     * UA. 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "Area Operations Floor relative to WGS84. If unknown: -1000 m. Used only for swarms/multiple UA."
    )
    public final float areaFloor() {
        return this.areaFloor;
    }

    /**
     * When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the category of 
     * the UA. 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 1,
            enumType = MavOdidCategoryEu.class,
            description = "When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the category of the UA."
    )
    public final EnumValue<MavOdidCategoryEu> categoryEu() {
        return this.categoryEu;
    }

    /**
     * When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the class of the 
     * UA. 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 1,
            enumType = MavOdidClassEu.class,
            description = "When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the class of the UA."
    )
    public final EnumValue<MavOdidClassEu> classEu() {
        return this.classEu;
    }

    /**
     * Geodetic altitude of the operator relative to WGS84. If unknown: -1000 m. 
     */
    @MavlinkFieldInfo(
            position = 14,
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
            position = 15,
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
        OpenDroneIdSystem other = (OpenDroneIdSystem)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(idOrMac, other.idOrMac)) return false;
        if (!Objects.deepEquals(operatorLocationType, other.operatorLocationType)) return false;
        if (!Objects.deepEquals(classificationType, other.classificationType)) return false;
        if (!Objects.deepEquals(operatorLatitude, other.operatorLatitude)) return false;
        if (!Objects.deepEquals(operatorLongitude, other.operatorLongitude)) return false;
        if (!Objects.deepEquals(areaCount, other.areaCount)) return false;
        if (!Objects.deepEquals(areaRadius, other.areaRadius)) return false;
        if (!Objects.deepEquals(areaCeiling, other.areaCeiling)) return false;
        if (!Objects.deepEquals(areaFloor, other.areaFloor)) return false;
        if (!Objects.deepEquals(categoryEu, other.categoryEu)) return false;
        if (!Objects.deepEquals(classEu, other.classEu)) return false;
        if (!Objects.deepEquals(operatorAltitudeGeo, other.operatorAltitudeGeo)) return false;
        if (!Objects.deepEquals(timestamp, other.timestamp)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(idOrMac);
        result = 31 * result + Objects.hashCode(operatorLocationType);
        result = 31 * result + Objects.hashCode(classificationType);
        result = 31 * result + Objects.hashCode(operatorLatitude);
        result = 31 * result + Objects.hashCode(operatorLongitude);
        result = 31 * result + Objects.hashCode(areaCount);
        result = 31 * result + Objects.hashCode(areaRadius);
        result = 31 * result + Objects.hashCode(areaCeiling);
        result = 31 * result + Objects.hashCode(areaFloor);
        result = 31 * result + Objects.hashCode(categoryEu);
        result = 31 * result + Objects.hashCode(classEu);
        result = 31 * result + Objects.hashCode(operatorAltitudeGeo);
        result = 31 * result + Objects.hashCode(timestamp);
        return result;
    }

    @Override
    public String toString() {
        return "OpenDroneIdSystem{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", idOrMac=" + idOrMac
                 + ", operatorLocationType=" + operatorLocationType
                 + ", classificationType=" + classificationType
                 + ", operatorLatitude=" + operatorLatitude
                 + ", operatorLongitude=" + operatorLongitude
                 + ", areaCount=" + areaCount
                 + ", areaRadius=" + areaRadius
                 + ", areaCeiling=" + areaCeiling
                 + ", areaFloor=" + areaFloor
                 + ", categoryEu=" + categoryEu
                 + ", classEu=" + classEu
                 + ", operatorAltitudeGeo=" + operatorAltitudeGeo
                 + ", timestamp=" + timestamp + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private byte[] idOrMac;

        private EnumValue<MavOdidOperatorLocationType> operatorLocationType;

        private EnumValue<MavOdidClassificationType> classificationType;

        private int operatorLatitude;

        private int operatorLongitude;

        private int areaCount;

        private int areaRadius;

        private float areaCeiling;

        private float areaFloor;

        private EnumValue<MavOdidCategoryEu> categoryEu;

        private EnumValue<MavOdidClassEu> classEu;

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
         * Specifies the operator location type. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = MavOdidOperatorLocationType.class,
                description = "Specifies the operator location type."
        )
        public final Builder operatorLocationType(
                EnumValue<MavOdidOperatorLocationType> operatorLocationType) {
            this.operatorLocationType = operatorLocationType;
            return this;
        }

        /**
         * Specifies the operator location type. 
         */
        public final Builder operatorLocationType(MavOdidOperatorLocationType entry) {
            return operatorLocationType(EnumValue.of(entry));
        }

        /**
         * Specifies the operator location type. 
         */
        public final Builder operatorLocationType(Enum... flags) {
            return operatorLocationType(EnumValue.create(flags));
        }

        /**
         * Specifies the operator location type. 
         */
        public final Builder operatorLocationType(Collection<Enum> flags) {
            return operatorLocationType(EnumValue.create(flags));
        }

        /**
         * Specifies the classification type of the UA. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                enumType = MavOdidClassificationType.class,
                description = "Specifies the classification type of the UA."
        )
        public final Builder classificationType(
                EnumValue<MavOdidClassificationType> classificationType) {
            this.classificationType = classificationType;
            return this;
        }

        /**
         * Specifies the classification type of the UA. 
         */
        public final Builder classificationType(MavOdidClassificationType entry) {
            return classificationType(EnumValue.of(entry));
        }

        /**
         * Specifies the classification type of the UA. 
         */
        public final Builder classificationType(Enum... flags) {
            return classificationType(EnumValue.create(flags));
        }

        /**
         * Specifies the classification type of the UA. 
         */
        public final Builder classificationType(Collection<Enum> flags) {
            return classificationType(EnumValue.create(flags));
        }

        /**
         * Latitude of the operator. If unknown: 0 (both Lat/Lon). 
         */
        @MavlinkFieldInfo(
                position = 6,
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
                position = 7,
                unitSize = 4,
                signed = true,
                description = "Longitude of the operator. If unknown: 0 (both Lat/Lon)."
        )
        public final Builder operatorLongitude(int operatorLongitude) {
            this.operatorLongitude = operatorLongitude;
            return this;
        }

        /**
         * Number of aircraft in the area, group or formation (default 1). Used only for swarms/multiple 
         * UA. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                description = "Number of aircraft in the area, group or formation (default 1). Used only for swarms/multiple UA."
        )
        public final Builder areaCount(int areaCount) {
            this.areaCount = areaCount;
            return this;
        }

        /**
         * Radius of the cylindrical area of the group or formation (default 0). Used only for 
         * swarms/multiple UA. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                description = "Radius of the cylindrical area of the group or formation (default 0). Used only for swarms/multiple UA."
        )
        public final Builder areaRadius(int areaRadius) {
            this.areaRadius = areaRadius;
            return this;
        }

        /**
         * Area Operations Ceiling relative to WGS84. If unknown: -1000 m. Used only for swarms/multiple 
         * UA. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Area Operations Ceiling relative to WGS84. If unknown: -1000 m. Used only for swarms/multiple UA."
        )
        public final Builder areaCeiling(float areaCeiling) {
            this.areaCeiling = areaCeiling;
            return this;
        }

        /**
         * Area Operations Floor relative to WGS84. If unknown: -1000 m. Used only for swarms/multiple 
         * UA. 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "Area Operations Floor relative to WGS84. If unknown: -1000 m. Used only for swarms/multiple UA."
        )
        public final Builder areaFloor(float areaFloor) {
            this.areaFloor = areaFloor;
            return this;
        }

        /**
         * When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the category of 
         * the UA. 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 1,
                enumType = MavOdidCategoryEu.class,
                description = "When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the category of the UA."
        )
        public final Builder categoryEu(EnumValue<MavOdidCategoryEu> categoryEu) {
            this.categoryEu = categoryEu;
            return this;
        }

        /**
         * When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the category of 
         * the UA. 
         */
        public final Builder categoryEu(MavOdidCategoryEu entry) {
            return categoryEu(EnumValue.of(entry));
        }

        /**
         * When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the category of 
         * the UA. 
         */
        public final Builder categoryEu(Enum... flags) {
            return categoryEu(EnumValue.create(flags));
        }

        /**
         * When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the category of 
         * the UA. 
         */
        public final Builder categoryEu(Collection<Enum> flags) {
            return categoryEu(EnumValue.create(flags));
        }

        /**
         * When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the class of the 
         * UA. 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 1,
                enumType = MavOdidClassEu.class,
                description = "When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the class of the UA."
        )
        public final Builder classEu(EnumValue<MavOdidClassEu> classEu) {
            this.classEu = classEu;
            return this;
        }

        /**
         * When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the class of the 
         * UA. 
         */
        public final Builder classEu(MavOdidClassEu entry) {
            return classEu(EnumValue.of(entry));
        }

        /**
         * When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the class of the 
         * UA. 
         */
        public final Builder classEu(Enum... flags) {
            return classEu(EnumValue.create(flags));
        }

        /**
         * When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the class of the 
         * UA. 
         */
        public final Builder classEu(Collection<Enum> flags) {
            return classEu(EnumValue.create(flags));
        }

        /**
         * Geodetic altitude of the operator relative to WGS84. If unknown: -1000 m. 
         */
        @MavlinkFieldInfo(
                position = 14,
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
                position = 15,
                unitSize = 4,
                description = "32 bit Unix Timestamp in seconds since 00:00:00 01/01/2019."
        )
        public final Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public final OpenDroneIdSystem build() {
            return new OpenDroneIdSystem(targetSystem, targetComponent, idOrMac, operatorLocationType, classificationType, operatorLatitude, operatorLongitude, areaCount, areaRadius, areaCeiling, areaFloor, categoryEu, classEu, operatorAltitudeGeo, timestamp);
        }
    }
}
