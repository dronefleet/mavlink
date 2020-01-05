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
 * Data for filling the OpenDroneID System message. The System Message contains general system 
 * information including the operator location and possible aircraft group information. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 12904,
        crc = 238,
        description = "Data for filling the OpenDroneID System message. The System Message contains general system information including the operator location and possible aircraft group information.",
        workInProgress = true
)
@Deprecated
public final class OpenDroneIdSystem {
    private final EnumValue<MavOdidLocationSrc> flags;

    private final int operatorLatitude;

    private final int operatorLongitude;

    private final int areaCount;

    private final int areaRadius;

    private final float areaCeiling;

    private final float areaFloor;

    private OpenDroneIdSystem(EnumValue<MavOdidLocationSrc> flags, int operatorLatitude,
            int operatorLongitude, int areaCount, int areaRadius, float areaCeiling,
            float areaFloor) {
        this.flags = flags;
        this.operatorLatitude = operatorLatitude;
        this.operatorLongitude = operatorLongitude;
        this.areaCount = areaCount;
        this.areaRadius = areaRadius;
        this.areaCeiling = areaCeiling;
        this.areaFloor = areaFloor;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Specifies the location source for the operator location. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = MavOdidLocationSrc.class,
            description = "Specifies the location source for the operator location."
    )
    public final EnumValue<MavOdidLocationSrc> flags() {
        return this.flags;
    }

    /**
     * Latitude of the operator. If unknown: 0 deg (both Lat/Lon). 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true,
            description = "Latitude of the operator. If unknown: 0 deg (both Lat/Lon)."
    )
    public final int operatorLatitude() {
        return this.operatorLatitude;
    }

    /**
     * Longitude of the operator. If unknown: 0 deg (both Lat/Lon). 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true,
            description = "Longitude of the operator. If unknown: 0 deg (both Lat/Lon)."
    )
    public final int operatorLongitude() {
        return this.operatorLongitude;
    }

    /**
     * Number of aircraft in the area, group or formation (default 1). 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "Number of aircraft in the area, group or formation (default 1)."
    )
    public final int areaCount() {
        return this.areaCount;
    }

    /**
     * Radius of the cylindrical area of the group or formation (default 0). 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "Radius of the cylindrical area of the group or formation (default 0)."
    )
    public final int areaRadius() {
        return this.areaRadius;
    }

    /**
     * Area Operations Ceiling relative to WGS84. If unknown: -1000 m. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Area Operations Ceiling relative to WGS84. If unknown: -1000 m."
    )
    public final float areaCeiling() {
        return this.areaCeiling;
    }

    /**
     * Area Operations Floor relative to WGS84. If unknown: -1000 m. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Area Operations Floor relative to WGS84. If unknown: -1000 m."
    )
    public final float areaFloor() {
        return this.areaFloor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        OpenDroneIdSystem other = (OpenDroneIdSystem)o;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        if (!Objects.deepEquals(operatorLatitude, other.operatorLatitude)) return false;
        if (!Objects.deepEquals(operatorLongitude, other.operatorLongitude)) return false;
        if (!Objects.deepEquals(areaCount, other.areaCount)) return false;
        if (!Objects.deepEquals(areaRadius, other.areaRadius)) return false;
        if (!Objects.deepEquals(areaCeiling, other.areaCeiling)) return false;
        if (!Objects.deepEquals(areaFloor, other.areaFloor)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(flags);
        result = 31 * result + Objects.hashCode(operatorLatitude);
        result = 31 * result + Objects.hashCode(operatorLongitude);
        result = 31 * result + Objects.hashCode(areaCount);
        result = 31 * result + Objects.hashCode(areaRadius);
        result = 31 * result + Objects.hashCode(areaCeiling);
        result = 31 * result + Objects.hashCode(areaFloor);
        return result;
    }

    @Override
    public String toString() {
        return "OpenDroneIdSystem{flags=" + flags
                 + ", operatorLatitude=" + operatorLatitude
                 + ", operatorLongitude=" + operatorLongitude
                 + ", areaCount=" + areaCount
                 + ", areaRadius=" + areaRadius
                 + ", areaCeiling=" + areaCeiling
                 + ", areaFloor=" + areaFloor + "}";
    }

    public static final class Builder {
        private EnumValue<MavOdidLocationSrc> flags;

        private int operatorLatitude;

        private int operatorLongitude;

        private int areaCount;

        private int areaRadius;

        private float areaCeiling;

        private float areaFloor;

        /**
         * Specifies the location source for the operator location. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = MavOdidLocationSrc.class,
                description = "Specifies the location source for the operator location."
        )
        public final Builder flags(EnumValue<MavOdidLocationSrc> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * Specifies the location source for the operator location. 
         */
        public final Builder flags(MavOdidLocationSrc entry) {
            return flags(EnumValue.of(entry));
        }

        /**
         * Specifies the location source for the operator location. 
         */
        public final Builder flags(Enum... flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Specifies the location source for the operator location. 
         */
        public final Builder flags(Collection<Enum> flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Latitude of the operator. If unknown: 0 deg (both Lat/Lon). 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true,
                description = "Latitude of the operator. If unknown: 0 deg (both Lat/Lon)."
        )
        public final Builder operatorLatitude(int operatorLatitude) {
            this.operatorLatitude = operatorLatitude;
            return this;
        }

        /**
         * Longitude of the operator. If unknown: 0 deg (both Lat/Lon). 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true,
                description = "Longitude of the operator. If unknown: 0 deg (both Lat/Lon)."
        )
        public final Builder operatorLongitude(int operatorLongitude) {
            this.operatorLongitude = operatorLongitude;
            return this;
        }

        /**
         * Number of aircraft in the area, group or formation (default 1). 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "Number of aircraft in the area, group or formation (default 1)."
        )
        public final Builder areaCount(int areaCount) {
            this.areaCount = areaCount;
            return this;
        }

        /**
         * Radius of the cylindrical area of the group or formation (default 0). 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "Radius of the cylindrical area of the group or formation (default 0)."
        )
        public final Builder areaRadius(int areaRadius) {
            this.areaRadius = areaRadius;
            return this;
        }

        /**
         * Area Operations Ceiling relative to WGS84. If unknown: -1000 m. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Area Operations Ceiling relative to WGS84. If unknown: -1000 m."
        )
        public final Builder areaCeiling(float areaCeiling) {
            this.areaCeiling = areaCeiling;
            return this;
        }

        /**
         * Area Operations Floor relative to WGS84. If unknown: -1000 m. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Area Operations Floor relative to WGS84. If unknown: -1000 m."
        )
        public final Builder areaFloor(float areaFloor) {
            this.areaFloor = areaFloor;
            return this;
        }

        public final OpenDroneIdSystem build() {
            return new OpenDroneIdSystem(flags, operatorLatitude, operatorLongitude, areaCount, areaRadius, areaCeiling, areaFloor);
        }
    }
}
