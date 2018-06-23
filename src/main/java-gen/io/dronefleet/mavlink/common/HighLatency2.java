package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.Override;
import java.lang.String;

/**
 * WIP: Message appropriate for high latency connections like Iridium (version 2) 
 */
@MavlinkMessageInfo(
        id = 235,
        crc = 179
)
public final class HighLatency2 {
    /**
     * Timestamp (milliseconds since boot or Unix epoch) 
     */
    private final long timestamp;

    /**
     * Latitude, expressed as degrees * 1E7 
     */
    private final int latitude;

    /**
     * Longitude, expressed as degrees * 1E7 
     */
    private final int longitude;

    /**
     * A bitfield for use for autopilot-specific flags (2 byte version). 
     */
    private final int customMode;

    /**
     * Altitude above mean sea level 
     */
    private final int altitude;

    /**
     * Altitude setpoint 
     */
    private final int targetAltitude;

    /**
     * Distance to target waypoint or position (meters / 10) 
     */
    private final int targetDistance;

    /**
     * Current waypoint number 
     */
    private final int wpNum;

    /**
     * Indicates failures as defined in {@link io.dronefleet.mavlink.common.HlFailureFlag HlFailureFlag} ENUM. 
     */
    private final EnumFlagSet<HlFailureFlag> failureFlags;

    /**
     * Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in {@link io.dronefleet.mavlink.common.MavType MavType} ENUM) 
     */
    private final MavType type;

    /**
     * Autopilot type / class. defined in {@link io.dronefleet.mavlink.common.MavAutopilot MavAutopilot} ENUM 
     */
    private final MavAutopilot autopilot;

    /**
     * Heading (degrees / 2) 
     */
    private final int heading;

    /**
     * Heading setpoint (degrees / 2) 
     */
    private final int targetHeading;

    /**
     * Throttle (percentage) 
     */
    private final int throttle;

    /**
     * Airspeed (m/s * 5) 
     */
    private final int airspeed;

    /**
     * Airspeed setpoint (m/s * 5) 
     */
    private final int airspeedSp;

    /**
     * Groundspeed (m/s * 5) 
     */
    private final int groundspeed;

    /**
     * Windspeed (m/s * 5) 
     */
    private final int windspeed;

    /**
     * Wind heading (deg / 2) 
     */
    private final int windHeading;

    /**
     * Maximum error horizontal position since last message (m * 10) 
     */
    private final int eph;

    /**
     * Maximum error vertical position since last message (m * 10) 
     */
    private final int epv;

    /**
     * Air temperature (degrees C) from airspeed sensor 
     */
    private final int temperatureAir;

    /**
     * Maximum climb rate magnitude since last message (m/s * 10) 
     */
    private final int climbRate;

    /**
     * Battery (percentage, -1 for DNU) 
     */
    private final int battery;

    /**
     * Field for custom payload. 
     */
    private final int custom0;

    /**
     * Field for custom payload. 
     */
    private final int custom1;

    /**
     * Field for custom payload. 
     */
    private final int custom2;

    private HighLatency2(long timestamp, int latitude, int longitude, int customMode, int altitude,
            int targetAltitude, int targetDistance, int wpNum,
            EnumFlagSet<HlFailureFlag> failureFlags, MavType type, MavAutopilot autopilot,
            int heading, int targetHeading, int throttle, int airspeed, int airspeedSp,
            int groundspeed, int windspeed, int windHeading, int eph, int epv, int temperatureAir,
            int climbRate, int battery, int custom0, int custom1, int custom2) {
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
        this.customMode = customMode;
        this.altitude = altitude;
        this.targetAltitude = targetAltitude;
        this.targetDistance = targetDistance;
        this.wpNum = wpNum;
        this.failureFlags = failureFlags;
        this.type = type;
        this.autopilot = autopilot;
        this.heading = heading;
        this.targetHeading = targetHeading;
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
        this.custom0 = custom0;
        this.custom1 = custom1;
        this.custom2 = custom2;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
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

    /**
     * Timestamp (milliseconds since boot or Unix epoch) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final long timestamp() {
        return timestamp;
    }

    /**
     * Latitude, expressed as degrees * 1E7 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true
    )
    public final int latitude() {
        return latitude;
    }

    /**
     * Longitude, expressed as degrees * 1E7 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            signed = true
    )
    public final int longitude() {
        return longitude;
    }

    /**
     * A bitfield for use for autopilot-specific flags (2 byte version). 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2
    )
    public final int customMode() {
        return customMode;
    }

    /**
     * Altitude above mean sea level 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            signed = true
    )
    public final int altitude() {
        return altitude;
    }

    /**
     * Altitude setpoint 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            signed = true
    )
    public final int targetAltitude() {
        return targetAltitude;
    }

    /**
     * Distance to target waypoint or position (meters / 10) 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 2
    )
    public final int targetDistance() {
        return targetDistance;
    }

    /**
     * Current waypoint number 
     */
    @MavlinkFieldInfo(
            position = 23,
            unitSize = 2
    )
    public final int wpNum() {
        return wpNum;
    }

    /**
     * Indicates failures as defined in {@link io.dronefleet.mavlink.common.HlFailureFlag HlFailureFlag} ENUM. 
     */
    @MavlinkFieldInfo(
            position = 24,
            unitSize = 2
    )
    public final EnumFlagSet<HlFailureFlag> failureFlags() {
        return failureFlags;
    }

    /**
     * Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in {@link io.dronefleet.mavlink.common.MavType MavType} ENUM) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final MavType type() {
        return type;
    }

    /**
     * Autopilot type / class. defined in {@link io.dronefleet.mavlink.common.MavAutopilot MavAutopilot} ENUM 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final MavAutopilot autopilot() {
        return autopilot;
    }

    /**
     * Heading (degrees / 2) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1
    )
    public final int heading() {
        return heading;
    }

    /**
     * Heading setpoint (degrees / 2) 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1
    )
    public final int targetHeading() {
        return targetHeading;
    }

    /**
     * Throttle (percentage) 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 1
    )
    public final int throttle() {
        return throttle;
    }

    /**
     * Airspeed (m/s * 5) 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 1
    )
    public final int airspeed() {
        return airspeed;
    }

    /**
     * Airspeed setpoint (m/s * 5) 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 1
    )
    public final int airspeedSp() {
        return airspeedSp;
    }

    /**
     * Groundspeed (m/s * 5) 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 1
    )
    public final int groundspeed() {
        return groundspeed;
    }

    /**
     * Windspeed (m/s * 5) 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 1
    )
    public final int windspeed() {
        return windspeed;
    }

    /**
     * Wind heading (deg / 2) 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 1
    )
    public final int windHeading() {
        return windHeading;
    }

    /**
     * Maximum error horizontal position since last message (m * 10) 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 1
    )
    public final int eph() {
        return eph;
    }

    /**
     * Maximum error vertical position since last message (m * 10) 
     */
    @MavlinkFieldInfo(
            position = 19,
            unitSize = 1
    )
    public final int epv() {
        return epv;
    }

    /**
     * Air temperature (degrees C) from airspeed sensor 
     */
    @MavlinkFieldInfo(
            position = 20,
            unitSize = 1,
            signed = true
    )
    public final int temperatureAir() {
        return temperatureAir;
    }

    /**
     * Maximum climb rate magnitude since last message (m/s * 10) 
     */
    @MavlinkFieldInfo(
            position = 21,
            unitSize = 1,
            signed = true
    )
    public final int climbRate() {
        return climbRate;
    }

    /**
     * Battery (percentage, -1 for DNU) 
     */
    @MavlinkFieldInfo(
            position = 22,
            unitSize = 1,
            signed = true
    )
    public final int battery() {
        return battery;
    }

    /**
     * Field for custom payload. 
     */
    @MavlinkFieldInfo(
            position = 25,
            unitSize = 1,
            signed = true
    )
    public final int custom0() {
        return custom0;
    }

    /**
     * Field for custom payload. 
     */
    @MavlinkFieldInfo(
            position = 26,
            unitSize = 1,
            signed = true
    )
    public final int custom1() {
        return custom1;
    }

    /**
     * Field for custom payload. 
     */
    @MavlinkFieldInfo(
            position = 27,
            unitSize = 1,
            signed = true
    )
    public final int custom2() {
        return custom2;
    }

    public static class Builder {
        private long timestamp;

        private int latitude;

        private int longitude;

        private int customMode;

        private int altitude;

        private int targetAltitude;

        private int targetDistance;

        private int wpNum;

        private EnumFlagSet<HlFailureFlag> failureFlags;

        private MavType type;

        private MavAutopilot autopilot;

        private int heading;

        private int targetHeading;

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

        private int custom0;

        private int custom1;

        private int custom2;

        private Builder() {
        }

        /**
         * Timestamp (milliseconds since boot or Unix epoch) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * Latitude, expressed as degrees * 1E7 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true
        )
        public final Builder latitude(int latitude) {
            this.latitude = latitude;
            return this;
        }

        /**
         * Longitude, expressed as degrees * 1E7 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                signed = true
        )
        public final Builder longitude(int longitude) {
            this.longitude = longitude;
            return this;
        }

        /**
         * A bitfield for use for autopilot-specific flags (2 byte version). 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2
        )
        public final Builder customMode(int customMode) {
            this.customMode = customMode;
            return this;
        }

        /**
         * Altitude above mean sea level 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                signed = true
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
                signed = true
        )
        public final Builder targetAltitude(int targetAltitude) {
            this.targetAltitude = targetAltitude;
            return this;
        }

        /**
         * Distance to target waypoint or position (meters / 10) 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 2
        )
        public final Builder targetDistance(int targetDistance) {
            this.targetDistance = targetDistance;
            return this;
        }

        /**
         * Current waypoint number 
         */
        @MavlinkFieldInfo(
                position = 23,
                unitSize = 2
        )
        public final Builder wpNum(int wpNum) {
            this.wpNum = wpNum;
            return this;
        }

        /**
         * Indicates failures as defined in {@link io.dronefleet.mavlink.common.HlFailureFlag HlFailureFlag} ENUM. 
         */
        @MavlinkFieldInfo(
                position = 24,
                unitSize = 2
        )
        public final Builder failureFlags(EnumFlagSet<HlFailureFlag> failureFlags) {
            this.failureFlags = failureFlags;
            return this;
        }

        /**
         * Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in {@link io.dronefleet.mavlink.common.MavType MavType} ENUM) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder type(MavType type) {
            this.type = type;
            return this;
        }

        /**
         * Autopilot type / class. defined in {@link io.dronefleet.mavlink.common.MavAutopilot MavAutopilot} ENUM 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder autopilot(MavAutopilot autopilot) {
            this.autopilot = autopilot;
            return this;
        }

        /**
         * Heading (degrees / 2) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1
        )
        public final Builder heading(int heading) {
            this.heading = heading;
            return this;
        }

        /**
         * Heading setpoint (degrees / 2) 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1
        )
        public final Builder targetHeading(int targetHeading) {
            this.targetHeading = targetHeading;
            return this;
        }

        /**
         * Throttle (percentage) 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 1
        )
        public final Builder throttle(int throttle) {
            this.throttle = throttle;
            return this;
        }

        /**
         * Airspeed (m/s * 5) 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 1
        )
        public final Builder airspeed(int airspeed) {
            this.airspeed = airspeed;
            return this;
        }

        /**
         * Airspeed setpoint (m/s * 5) 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 1
        )
        public final Builder airspeedSp(int airspeedSp) {
            this.airspeedSp = airspeedSp;
            return this;
        }

        /**
         * Groundspeed (m/s * 5) 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 1
        )
        public final Builder groundspeed(int groundspeed) {
            this.groundspeed = groundspeed;
            return this;
        }

        /**
         * Windspeed (m/s * 5) 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 1
        )
        public final Builder windspeed(int windspeed) {
            this.windspeed = windspeed;
            return this;
        }

        /**
         * Wind heading (deg / 2) 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 1
        )
        public final Builder windHeading(int windHeading) {
            this.windHeading = windHeading;
            return this;
        }

        /**
         * Maximum error horizontal position since last message (m * 10) 
         */
        @MavlinkFieldInfo(
                position = 18,
                unitSize = 1
        )
        public final Builder eph(int eph) {
            this.eph = eph;
            return this;
        }

        /**
         * Maximum error vertical position since last message (m * 10) 
         */
        @MavlinkFieldInfo(
                position = 19,
                unitSize = 1
        )
        public final Builder epv(int epv) {
            this.epv = epv;
            return this;
        }

        /**
         * Air temperature (degrees C) from airspeed sensor 
         */
        @MavlinkFieldInfo(
                position = 20,
                unitSize = 1,
                signed = true
        )
        public final Builder temperatureAir(int temperatureAir) {
            this.temperatureAir = temperatureAir;
            return this;
        }

        /**
         * Maximum climb rate magnitude since last message (m/s * 10) 
         */
        @MavlinkFieldInfo(
                position = 21,
                unitSize = 1,
                signed = true
        )
        public final Builder climbRate(int climbRate) {
            this.climbRate = climbRate;
            return this;
        }

        /**
         * Battery (percentage, -1 for DNU) 
         */
        @MavlinkFieldInfo(
                position = 22,
                unitSize = 1,
                signed = true
        )
        public final Builder battery(int battery) {
            this.battery = battery;
            return this;
        }

        /**
         * Field for custom payload. 
         */
        @MavlinkFieldInfo(
                position = 25,
                unitSize = 1,
                signed = true
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
                signed = true
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
                signed = true
        )
        public final Builder custom2(int custom2) {
            this.custom2 = custom2;
            return this;
        }

        public final HighLatency2 build() {
            return new HighLatency2(timestamp, latitude, longitude, customMode, altitude, targetAltitude, targetDistance, wpNum, failureFlags, type, autopilot, heading, targetHeading, throttle, airspeed, airspeedSp, groundspeed, windspeed, windHeading, eph, epv, temperatureAir, climbRate, battery, custom0, custom1, custom2);
        }
    }
}
