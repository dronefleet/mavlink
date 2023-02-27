package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.minimal.MavAutopilot;
import io.dronefleet.mavlink.minimal.MavType;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Message appropriate for high latency connections like Iridium (version 2) 
 */
@MavlinkMessageInfo(
        id = 235,
        crc = 179,
        description = "Message appropriate for high latency connections like Iridium (version 2)"
)
public final class HighLatency2 {
    private final long timestamp;

    private final EnumValue<MavType> type;

    private final EnumValue<MavAutopilot> autopilot;

    private final int customMode;

    private final int latitude;

    private final int longitude;

    private final int altitude;

    private final int targetAltitude;

    private final int heading;

    private final int targetHeading;

    private final int targetDistance;

    private final int throttle;

    private final int airspeed;

    private final int airspeedSp;

    private final int groundspeed;

    private final int windspeed;

    private final int windHeading;

    private final int eph;

    private final int epv;

    private final int temperatureAir;

    private final int climbRate;

    private final int battery;

    private final int wpNum;

    private final EnumValue<HlFailureFlag> failureFlags;

    private final int custom0;

    private final int custom1;

    private final int custom2;

    private HighLatency2(long timestamp, EnumValue<MavType> type, EnumValue<MavAutopilot> autopilot,
            int customMode, int latitude, int longitude, int altitude, int targetAltitude,
            int heading, int targetHeading, int targetDistance, int throttle, int airspeed,
            int airspeedSp, int groundspeed, int windspeed, int windHeading, int eph, int epv,
            int temperatureAir, int climbRate, int battery, int wpNum,
            EnumValue<HlFailureFlag> failureFlags, int custom0, int custom1, int custom2) {
        this.timestamp = timestamp;
        this.type = type;
        this.autopilot = autopilot;
        this.customMode = customMode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.targetAltitude = targetAltitude;
        this.heading = heading;
        this.targetHeading = targetHeading;
        this.targetDistance = targetDistance;
        this.throttle = throttle;
        this.airspeed = airspeed;
        this.airspeedSp = airspeedSp;
        this.groundspeed = groundspeed;
        this.windspeed = windspeed;
        this.windHeading = windHeading;
        this.eph = eph;
        this.epv = epv;
        this.temperatureAir = temperatureAir;
        this.climbRate = climbRate;
        this.battery = battery;
        this.wpNum = wpNum;
        this.failureFlags = failureFlags;
        this.custom0 = custom0;
        this.custom1 = custom1;
        this.custom2 = custom2;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (milliseconds since boot or Unix epoch) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Timestamp (milliseconds since boot or Unix epoch)"
    )
    public final long timestamp() {
        return this.timestamp;
    }

    /**
     * Type of the MAV (quadrotor, helicopter, etc.) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = MavType.class,
            description = "Type of the MAV (quadrotor, helicopter, etc.)"
    )
    public final EnumValue<MavType> type() {
        return this.type;
    }

    /**
     * Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight 
     * controllers. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = MavAutopilot.class,
            description = "Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight controllers."
    )
    public final EnumValue<MavAutopilot> autopilot() {
        return this.autopilot;
    }

    /**
     * A bitfield for use for autopilot-specific flags (2 byte version). 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "A bitfield for use for autopilot-specific flags (2 byte version)."
    )
    public final int customMode() {
        return this.customMode;
    }

    /**
     * Latitude 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "Latitude"
    )
    public final int latitude() {
        return this.latitude;
    }

    /**
     * Longitude 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            signed = true,
            description = "Longitude"
    )
    public final int longitude() {
        return this.longitude;
    }

    /**
     * Altitude above mean sea level 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            signed = true,
            description = "Altitude above mean sea level"
    )
    public final int altitude() {
        return this.altitude;
    }

    /**
     * Altitude setpoint 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            signed = true,
            description = "Altitude setpoint"
    )
    public final int targetAltitude() {
        return this.targetAltitude;
    }

    /**
     * Heading 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1,
            description = "Heading"
    )
    public final int heading() {
        return this.heading;
    }

    /**
     * Heading setpoint 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1,
            description = "Heading setpoint"
    )
    public final int targetHeading() {
        return this.targetHeading;
    }

    /**
     * Distance to target waypoint or position 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 2,
            description = "Distance to target waypoint or position"
    )
    public final int targetDistance() {
        return this.targetDistance;
    }

    /**
     * Throttle 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 1,
            description = "Throttle"
    )
    public final int throttle() {
        return this.throttle;
    }

    /**
     * Airspeed 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 1,
            description = "Airspeed"
    )
    public final int airspeed() {
        return this.airspeed;
    }

    /**
     * Airspeed setpoint 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 1,
            description = "Airspeed setpoint"
    )
    public final int airspeedSp() {
        return this.airspeedSp;
    }

    /**
     * Groundspeed 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 1,
            description = "Groundspeed"
    )
    public final int groundspeed() {
        return this.groundspeed;
    }

    /**
     * Windspeed 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 1,
            description = "Windspeed"
    )
    public final int windspeed() {
        return this.windspeed;
    }

    /**
     * Wind heading 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 1,
            description = "Wind heading"
    )
    public final int windHeading() {
        return this.windHeading;
    }

    /**
     * Maximum error horizontal position since last message 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 1,
            description = "Maximum error horizontal position since last message"
    )
    public final int eph() {
        return this.eph;
    }

    /**
     * Maximum error vertical position since last message 
     */
    @MavlinkFieldInfo(
            position = 19,
            unitSize = 1,
            description = "Maximum error vertical position since last message"
    )
    public final int epv() {
        return this.epv;
    }

    /**
     * Air temperature from airspeed sensor 
     */
    @MavlinkFieldInfo(
            position = 20,
            unitSize = 1,
            signed = true,
            description = "Air temperature from airspeed sensor"
    )
    public final int temperatureAir() {
        return this.temperatureAir;
    }

    /**
     * Maximum climb rate magnitude since last message 
     */
    @MavlinkFieldInfo(
            position = 21,
            unitSize = 1,
            signed = true,
            description = "Maximum climb rate magnitude since last message"
    )
    public final int climbRate() {
        return this.climbRate;
    }

    /**
     * Battery level (-1 if field not provided). 
     */
    @MavlinkFieldInfo(
            position = 22,
            unitSize = 1,
            signed = true,
            description = "Battery level (-1 if field not provided)."
    )
    public final int battery() {
        return this.battery;
    }

    /**
     * Current waypoint number 
     */
    @MavlinkFieldInfo(
            position = 23,
            unitSize = 2,
            description = "Current waypoint number"
    )
    public final int wpNum() {
        return this.wpNum;
    }

    /**
     * Bitmap of failure flags. 
     */
    @MavlinkFieldInfo(
            position = 24,
            unitSize = 2,
            enumType = HlFailureFlag.class,
            description = "Bitmap of failure flags."
    )
    public final EnumValue<HlFailureFlag> failureFlags() {
        return this.failureFlags;
    }

    /**
     * Field for custom payload. 
     */
    @MavlinkFieldInfo(
            position = 25,
            unitSize = 1,
            signed = true,
            description = "Field for custom payload."
    )
    public final int custom0() {
        return this.custom0;
    }

    /**
     * Field for custom payload. 
     */
    @MavlinkFieldInfo(
            position = 26,
            unitSize = 1,
            signed = true,
            description = "Field for custom payload."
    )
    public final int custom1() {
        return this.custom1;
    }

    /**
     * Field for custom payload. 
     */
    @MavlinkFieldInfo(
            position = 27,
            unitSize = 1,
            signed = true,
            description = "Field for custom payload."
    )
    public final int custom2() {
        return this.custom2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        HighLatency2 other = (HighLatency2)o;
        if (!Objects.deepEquals(timestamp, other.timestamp)) return false;
        if (!Objects.deepEquals(type, other.type)) return false;
        if (!Objects.deepEquals(autopilot, other.autopilot)) return false;
        if (!Objects.deepEquals(customMode, other.customMode)) return false;
        if (!Objects.deepEquals(latitude, other.latitude)) return false;
        if (!Objects.deepEquals(longitude, other.longitude)) return false;
        if (!Objects.deepEquals(altitude, other.altitude)) return false;
        if (!Objects.deepEquals(targetAltitude, other.targetAltitude)) return false;
        if (!Objects.deepEquals(heading, other.heading)) return false;
        if (!Objects.deepEquals(targetHeading, other.targetHeading)) return false;
        if (!Objects.deepEquals(targetDistance, other.targetDistance)) return false;
        if (!Objects.deepEquals(throttle, other.throttle)) return false;
        if (!Objects.deepEquals(airspeed, other.airspeed)) return false;
        if (!Objects.deepEquals(airspeedSp, other.airspeedSp)) return false;
        if (!Objects.deepEquals(groundspeed, other.groundspeed)) return false;
        if (!Objects.deepEquals(windspeed, other.windspeed)) return false;
        if (!Objects.deepEquals(windHeading, other.windHeading)) return false;
        if (!Objects.deepEquals(eph, other.eph)) return false;
        if (!Objects.deepEquals(epv, other.epv)) return false;
        if (!Objects.deepEquals(temperatureAir, other.temperatureAir)) return false;
        if (!Objects.deepEquals(climbRate, other.climbRate)) return false;
        if (!Objects.deepEquals(battery, other.battery)) return false;
        if (!Objects.deepEquals(wpNum, other.wpNum)) return false;
        if (!Objects.deepEquals(failureFlags, other.failureFlags)) return false;
        if (!Objects.deepEquals(custom0, other.custom0)) return false;
        if (!Objects.deepEquals(custom1, other.custom1)) return false;
        if (!Objects.deepEquals(custom2, other.custom2)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timestamp);
        result = 31 * result + Objects.hashCode(type);
        result = 31 * result + Objects.hashCode(autopilot);
        result = 31 * result + Objects.hashCode(customMode);
        result = 31 * result + Objects.hashCode(latitude);
        result = 31 * result + Objects.hashCode(longitude);
        result = 31 * result + Objects.hashCode(altitude);
        result = 31 * result + Objects.hashCode(targetAltitude);
        result = 31 * result + Objects.hashCode(heading);
        result = 31 * result + Objects.hashCode(targetHeading);
        result = 31 * result + Objects.hashCode(targetDistance);
        result = 31 * result + Objects.hashCode(throttle);
        result = 31 * result + Objects.hashCode(airspeed);
        result = 31 * result + Objects.hashCode(airspeedSp);
        result = 31 * result + Objects.hashCode(groundspeed);
        result = 31 * result + Objects.hashCode(windspeed);
        result = 31 * result + Objects.hashCode(windHeading);
        result = 31 * result + Objects.hashCode(eph);
        result = 31 * result + Objects.hashCode(epv);
        result = 31 * result + Objects.hashCode(temperatureAir);
        result = 31 * result + Objects.hashCode(climbRate);
        result = 31 * result + Objects.hashCode(battery);
        result = 31 * result + Objects.hashCode(wpNum);
        result = 31 * result + Objects.hashCode(failureFlags);
        result = 31 * result + Objects.hashCode(custom0);
        result = 31 * result + Objects.hashCode(custom1);
        result = 31 * result + Objects.hashCode(custom2);
        return result;
    }

    @Override
    public String toString() {
        return "HighLatency2{timestamp=" + timestamp
                 + ", type=" + type
                 + ", autopilot=" + autopilot
                 + ", customMode=" + customMode
                 + ", latitude=" + latitude
                 + ", longitude=" + longitude
                 + ", altitude=" + altitude
                 + ", targetAltitude=" + targetAltitude
                 + ", heading=" + heading
                 + ", targetHeading=" + targetHeading
                 + ", targetDistance=" + targetDistance
                 + ", throttle=" + throttle
                 + ", airspeed=" + airspeed
                 + ", airspeedSp=" + airspeedSp
                 + ", groundspeed=" + groundspeed
                 + ", windspeed=" + windspeed
                 + ", windHeading=" + windHeading
                 + ", eph=" + eph
                 + ", epv=" + epv
                 + ", temperatureAir=" + temperatureAir
                 + ", climbRate=" + climbRate
                 + ", battery=" + battery
                 + ", wpNum=" + wpNum
                 + ", failureFlags=" + failureFlags
                 + ", custom0=" + custom0
                 + ", custom1=" + custom1
                 + ", custom2=" + custom2 + "}";
    }

    public static final class Builder {
        private long timestamp;

        private EnumValue<MavType> type;

        private EnumValue<MavAutopilot> autopilot;

        private int customMode;

        private int latitude;

        private int longitude;

        private int altitude;

        private int targetAltitude;

        private int heading;

        private int targetHeading;

        private int targetDistance;

        private int throttle;

        private int airspeed;

        private int airspeedSp;

        private int groundspeed;

        private int windspeed;

        private int windHeading;

        private int eph;

        private int epv;

        private int temperatureAir;

        private int climbRate;

        private int battery;

        private int wpNum;

        private EnumValue<HlFailureFlag> failureFlags;

        private int custom0;

        private int custom1;

        private int custom2;

        /**
         * Timestamp (milliseconds since boot or Unix epoch) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Timestamp (milliseconds since boot or Unix epoch)"
        )
        public final Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * Type of the MAV (quadrotor, helicopter, etc.) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = MavType.class,
                description = "Type of the MAV (quadrotor, helicopter, etc.)"
        )
        public final Builder type(EnumValue<MavType> type) {
            this.type = type;
            return this;
        }

        /**
         * Type of the MAV (quadrotor, helicopter, etc.) 
         */
        public final Builder type(MavType entry) {
            return type(EnumValue.of(entry));
        }

        /**
         * Type of the MAV (quadrotor, helicopter, etc.) 
         */
        public final Builder type(Enum... flags) {
            return type(EnumValue.create(flags));
        }

        /**
         * Type of the MAV (quadrotor, helicopter, etc.) 
         */
        public final Builder type(Collection<Enum> flags) {
            return type(EnumValue.create(flags));
        }

        /**
         * Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight 
         * controllers. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = MavAutopilot.class,
                description = "Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight controllers."
        )
        public final Builder autopilot(EnumValue<MavAutopilot> autopilot) {
            this.autopilot = autopilot;
            return this;
        }

        /**
         * Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight 
         * controllers. 
         */
        public final Builder autopilot(MavAutopilot entry) {
            return autopilot(EnumValue.of(entry));
        }

        /**
         * Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight 
         * controllers. 
         */
        public final Builder autopilot(Enum... flags) {
            return autopilot(EnumValue.create(flags));
        }

        /**
         * Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight 
         * controllers. 
         */
        public final Builder autopilot(Collection<Enum> flags) {
            return autopilot(EnumValue.create(flags));
        }

        /**
         * A bitfield for use for autopilot-specific flags (2 byte version). 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "A bitfield for use for autopilot-specific flags (2 byte version)."
        )
        public final Builder customMode(int customMode) {
            this.customMode = customMode;
            return this;
        }

        /**
         * Latitude 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "Latitude"
        )
        public final Builder latitude(int latitude) {
            this.latitude = latitude;
            return this;
        }

        /**
         * Longitude 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                signed = true,
                description = "Longitude"
        )
        public final Builder longitude(int longitude) {
            this.longitude = longitude;
            return this;
        }

        /**
         * Altitude above mean sea level 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                signed = true,
                description = "Altitude above mean sea level"
        )
        public final Builder altitude(int altitude) {
            this.altitude = altitude;
            return this;
        }

        /**
         * Altitude setpoint 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                signed = true,
                description = "Altitude setpoint"
        )
        public final Builder targetAltitude(int targetAltitude) {
            this.targetAltitude = targetAltitude;
            return this;
        }

        /**
         * Heading 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1,
                description = "Heading"
        )
        public final Builder heading(int heading) {
            this.heading = heading;
            return this;
        }

        /**
         * Heading setpoint 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1,
                description = "Heading setpoint"
        )
        public final Builder targetHeading(int targetHeading) {
            this.targetHeading = targetHeading;
            return this;
        }

        /**
         * Distance to target waypoint or position 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 2,
                description = "Distance to target waypoint or position"
        )
        public final Builder targetDistance(int targetDistance) {
            this.targetDistance = targetDistance;
            return this;
        }

        /**
         * Throttle 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 1,
                description = "Throttle"
        )
        public final Builder throttle(int throttle) {
            this.throttle = throttle;
            return this;
        }

        /**
         * Airspeed 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 1,
                description = "Airspeed"
        )
        public final Builder airspeed(int airspeed) {
            this.airspeed = airspeed;
            return this;
        }

        /**
         * Airspeed setpoint 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 1,
                description = "Airspeed setpoint"
        )
        public final Builder airspeedSp(int airspeedSp) {
            this.airspeedSp = airspeedSp;
            return this;
        }

        /**
         * Groundspeed 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 1,
                description = "Groundspeed"
        )
        public final Builder groundspeed(int groundspeed) {
            this.groundspeed = groundspeed;
            return this;
        }

        /**
         * Windspeed 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 1,
                description = "Windspeed"
        )
        public final Builder windspeed(int windspeed) {
            this.windspeed = windspeed;
            return this;
        }

        /**
         * Wind heading 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 1,
                description = "Wind heading"
        )
        public final Builder windHeading(int windHeading) {
            this.windHeading = windHeading;
            return this;
        }

        /**
         * Maximum error horizontal position since last message 
         */
        @MavlinkFieldInfo(
                position = 18,
                unitSize = 1,
                description = "Maximum error horizontal position since last message"
        )
        public final Builder eph(int eph) {
            this.eph = eph;
            return this;
        }

        /**
         * Maximum error vertical position since last message 
         */
        @MavlinkFieldInfo(
                position = 19,
                unitSize = 1,
                description = "Maximum error vertical position since last message"
        )
        public final Builder epv(int epv) {
            this.epv = epv;
            return this;
        }

        /**
         * Air temperature from airspeed sensor 
         */
        @MavlinkFieldInfo(
                position = 20,
                unitSize = 1,
                signed = true,
                description = "Air temperature from airspeed sensor"
        )
        public final Builder temperatureAir(int temperatureAir) {
            this.temperatureAir = temperatureAir;
            return this;
        }

        /**
         * Maximum climb rate magnitude since last message 
         */
        @MavlinkFieldInfo(
                position = 21,
                unitSize = 1,
                signed = true,
                description = "Maximum climb rate magnitude since last message"
        )
        public final Builder climbRate(int climbRate) {
            this.climbRate = climbRate;
            return this;
        }

        /**
         * Battery level (-1 if field not provided). 
         */
        @MavlinkFieldInfo(
                position = 22,
                unitSize = 1,
                signed = true,
                description = "Battery level (-1 if field not provided)."
        )
        public final Builder battery(int battery) {
            this.battery = battery;
            return this;
        }

        /**
         * Current waypoint number 
         */
        @MavlinkFieldInfo(
                position = 23,
                unitSize = 2,
                description = "Current waypoint number"
        )
        public final Builder wpNum(int wpNum) {
            this.wpNum = wpNum;
            return this;
        }

        /**
         * Bitmap of failure flags. 
         */
        @MavlinkFieldInfo(
                position = 24,
                unitSize = 2,
                enumType = HlFailureFlag.class,
                description = "Bitmap of failure flags."
        )
        public final Builder failureFlags(EnumValue<HlFailureFlag> failureFlags) {
            this.failureFlags = failureFlags;
            return this;
        }

        /**
         * Bitmap of failure flags. 
         */
        public final Builder failureFlags(HlFailureFlag entry) {
            return failureFlags(EnumValue.of(entry));
        }

        /**
         * Bitmap of failure flags. 
         */
        public final Builder failureFlags(Enum... flags) {
            return failureFlags(EnumValue.create(flags));
        }

        /**
         * Bitmap of failure flags. 
         */
        public final Builder failureFlags(Collection<Enum> flags) {
            return failureFlags(EnumValue.create(flags));
        }

        /**
         * Field for custom payload. 
         */
        @MavlinkFieldInfo(
                position = 25,
                unitSize = 1,
                signed = true,
                description = "Field for custom payload."
        )
        public final Builder custom0(int custom0) {
            this.custom0 = custom0;
            return this;
        }

        /**
         * Field for custom payload. 
         */
        @MavlinkFieldInfo(
                position = 26,
                unitSize = 1,
                signed = true,
                description = "Field for custom payload."
        )
        public final Builder custom1(int custom1) {
            this.custom1 = custom1;
            return this;
        }

        /**
         * Field for custom payload. 
         */
        @MavlinkFieldInfo(
                position = 27,
                unitSize = 1,
                signed = true,
                description = "Field for custom payload."
        )
        public final Builder custom2(int custom2) {
            this.custom2 = custom2;
            return this;
        }

        public final HighLatency2 build() {
            return new HighLatency2(timestamp, type, autopilot, customMode, latitude, longitude, altitude, targetAltitude, heading, targetHeading, targetDistance, throttle, airspeed, airspeedSp, groundspeed, windspeed, windHeading, eph, epv, temperatureAir, climbRate, battery, wpNum, failureFlags, custom0, custom1, custom2);
        }
    }
}
