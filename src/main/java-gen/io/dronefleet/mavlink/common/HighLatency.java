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
 * Message appropriate for high latency connections like Iridium 
 * @deprecated Since 2020-10, replaced by {@link io.dronefleet.mavlink.common.HighLatency HIGH_LATENCY}2. 
 */
@MavlinkMessageInfo(
        id = 234,
        crc = 150,
        description = "Message appropriate for high latency connections like Iridium"
)
@Deprecated
public final class HighLatency {
    private final EnumValue<MavModeFlag> baseMode;

    private final long customMode;

    private final EnumValue<MavLandedState> landedState;

    private final int roll;

    private final int pitch;

    private final int heading;

    private final int throttle;

    private final int headingSp;

    private final int latitude;

    private final int longitude;

    private final int altitudeAmsl;

    private final int altitudeSp;

    private final int airspeed;

    private final int airspeedSp;

    private final int groundspeed;

    private final int climbRate;

    private final int gpsNsat;

    private final EnumValue<GpsFixType> gpsFixType;

    private final int batteryRemaining;

    private final int temperature;

    private final int temperatureAir;

    private final int failsafe;

    private final int wpNum;

    private final int wpDistance;

    private HighLatency(EnumValue<MavModeFlag> baseMode, long customMode,
            EnumValue<MavLandedState> landedState, int roll, int pitch, int heading, int throttle,
            int headingSp, int latitude, int longitude, int altitudeAmsl, int altitudeSp,
            int airspeed, int airspeedSp, int groundspeed, int climbRate, int gpsNsat,
            EnumValue<GpsFixType> gpsFixType, int batteryRemaining, int temperature,
            int temperatureAir, int failsafe, int wpNum, int wpDistance) {
        this.baseMode = baseMode;
        this.customMode = customMode;
        this.landedState = landedState;
        this.roll = roll;
        this.pitch = pitch;
        this.heading = heading;
        this.throttle = throttle;
        this.headingSp = headingSp;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitudeAmsl = altitudeAmsl;
        this.altitudeSp = altitudeSp;
        this.airspeed = airspeed;
        this.airspeedSp = airspeedSp;
        this.groundspeed = groundspeed;
        this.climbRate = climbRate;
        this.gpsNsat = gpsNsat;
        this.gpsFixType = gpsFixType;
        this.batteryRemaining = batteryRemaining;
        this.temperature = temperature;
        this.temperatureAir = temperatureAir;
        this.failsafe = failsafe;
        this.wpNum = wpNum;
        this.wpDistance = wpDistance;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Bitmap of enabled system modes. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = MavModeFlag.class,
            description = "Bitmap of enabled system modes."
    )
    public final EnumValue<MavModeFlag> baseMode() {
        return this.baseMode;
    }

    /**
     * A bitfield for use for autopilot-specific flags. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "A bitfield for use for autopilot-specific flags."
    )
    public final long customMode() {
        return this.customMode;
    }

    /**
     * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = MavLandedState.class,
            description = "The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown."
    )
    public final EnumValue<MavLandedState> landedState() {
        return this.landedState;
    }

    /**
     * roll 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            signed = true,
            description = "roll"
    )
    public final int roll() {
        return this.roll;
    }

    /**
     * pitch 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            signed = true,
            description = "pitch"
    )
    public final int pitch() {
        return this.pitch;
    }

    /**
     * heading 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            description = "heading"
    )
    public final int heading() {
        return this.heading;
    }

    /**
     * throttle (percentage) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            signed = true,
            description = "throttle (percentage)"
    )
    public final int throttle() {
        return this.throttle;
    }

    /**
     * heading setpoint 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            signed = true,
            description = "heading setpoint"
    )
    public final int headingSp() {
        return this.headingSp;
    }

    /**
     * Latitude 
     */
    @MavlinkFieldInfo(
            position = 10,
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
            position = 11,
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
            position = 12,
            unitSize = 2,
            signed = true,
            description = "Altitude above mean sea level"
    )
    public final int altitudeAmsl() {
        return this.altitudeAmsl;
    }

    /**
     * Altitude setpoint relative to the home position 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 2,
            signed = true,
            description = "Altitude setpoint relative to the home position"
    )
    public final int altitudeSp() {
        return this.altitudeSp;
    }

    /**
     * airspeed 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 1,
            description = "airspeed"
    )
    public final int airspeed() {
        return this.airspeed;
    }

    /**
     * airspeed setpoint 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 1,
            description = "airspeed setpoint"
    )
    public final int airspeedSp() {
        return this.airspeedSp;
    }

    /**
     * groundspeed 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 1,
            description = "groundspeed"
    )
    public final int groundspeed() {
        return this.groundspeed;
    }

    /**
     * climb rate 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 1,
            signed = true,
            description = "climb rate"
    )
    public final int climbRate() {
        return this.climbRate;
    }

    /**
     * Number of satellites visible. If unknown, set to UINT8_MAX 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 1,
            description = "Number of satellites visible. If unknown, set to UINT8_MAX"
    )
    public final int gpsNsat() {
        return this.gpsNsat;
    }

    /**
     * GPS Fix type. 
     */
    @MavlinkFieldInfo(
            position = 19,
            unitSize = 1,
            enumType = GpsFixType.class,
            description = "GPS Fix type."
    )
    public final EnumValue<GpsFixType> gpsFixType() {
        return this.gpsFixType;
    }

    /**
     * Remaining battery (percentage) 
     */
    @MavlinkFieldInfo(
            position = 20,
            unitSize = 1,
            description = "Remaining battery (percentage)"
    )
    public final int batteryRemaining() {
        return this.batteryRemaining;
    }

    /**
     * Autopilot temperature (degrees C) 
     */
    @MavlinkFieldInfo(
            position = 21,
            unitSize = 1,
            signed = true,
            description = "Autopilot temperature (degrees C)"
    )
    public final int temperature() {
        return this.temperature;
    }

    /**
     * Air temperature (degrees C) from airspeed sensor 
     */
    @MavlinkFieldInfo(
            position = 22,
            unitSize = 1,
            signed = true,
            description = "Air temperature (degrees C) from airspeed sensor"
    )
    public final int temperatureAir() {
        return this.temperatureAir;
    }

    /**
     * failsafe (each bit represents a failsafe where 0=ok, 1=failsafe active (bit0:RC, bit1:batt, 
     * bit2:GPS, bit3:GCS, bit4:fence) 
     */
    @MavlinkFieldInfo(
            position = 23,
            unitSize = 1,
            description = "failsafe (each bit represents a failsafe where 0=ok, 1=failsafe active (bit0:RC, bit1:batt, bit2:GPS, bit3:GCS, bit4:fence)"
    )
    public final int failsafe() {
        return this.failsafe;
    }

    /**
     * current waypoint number 
     */
    @MavlinkFieldInfo(
            position = 24,
            unitSize = 1,
            description = "current waypoint number"
    )
    public final int wpNum() {
        return this.wpNum;
    }

    /**
     * distance to target 
     */
    @MavlinkFieldInfo(
            position = 25,
            unitSize = 2,
            description = "distance to target"
    )
    public final int wpDistance() {
        return this.wpDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        HighLatency other = (HighLatency)o;
        if (!Objects.deepEquals(baseMode, other.baseMode)) return false;
        if (!Objects.deepEquals(customMode, other.customMode)) return false;
        if (!Objects.deepEquals(landedState, other.landedState)) return false;
        if (!Objects.deepEquals(roll, other.roll)) return false;
        if (!Objects.deepEquals(pitch, other.pitch)) return false;
        if (!Objects.deepEquals(heading, other.heading)) return false;
        if (!Objects.deepEquals(throttle, other.throttle)) return false;
        if (!Objects.deepEquals(headingSp, other.headingSp)) return false;
        if (!Objects.deepEquals(latitude, other.latitude)) return false;
        if (!Objects.deepEquals(longitude, other.longitude)) return false;
        if (!Objects.deepEquals(altitudeAmsl, other.altitudeAmsl)) return false;
        if (!Objects.deepEquals(altitudeSp, other.altitudeSp)) return false;
        if (!Objects.deepEquals(airspeed, other.airspeed)) return false;
        if (!Objects.deepEquals(airspeedSp, other.airspeedSp)) return false;
        if (!Objects.deepEquals(groundspeed, other.groundspeed)) return false;
        if (!Objects.deepEquals(climbRate, other.climbRate)) return false;
        if (!Objects.deepEquals(gpsNsat, other.gpsNsat)) return false;
        if (!Objects.deepEquals(gpsFixType, other.gpsFixType)) return false;
        if (!Objects.deepEquals(batteryRemaining, other.batteryRemaining)) return false;
        if (!Objects.deepEquals(temperature, other.temperature)) return false;
        if (!Objects.deepEquals(temperatureAir, other.temperatureAir)) return false;
        if (!Objects.deepEquals(failsafe, other.failsafe)) return false;
        if (!Objects.deepEquals(wpNum, other.wpNum)) return false;
        if (!Objects.deepEquals(wpDistance, other.wpDistance)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(baseMode);
        result = 31 * result + Objects.hashCode(customMode);
        result = 31 * result + Objects.hashCode(landedState);
        result = 31 * result + Objects.hashCode(roll);
        result = 31 * result + Objects.hashCode(pitch);
        result = 31 * result + Objects.hashCode(heading);
        result = 31 * result + Objects.hashCode(throttle);
        result = 31 * result + Objects.hashCode(headingSp);
        result = 31 * result + Objects.hashCode(latitude);
        result = 31 * result + Objects.hashCode(longitude);
        result = 31 * result + Objects.hashCode(altitudeAmsl);
        result = 31 * result + Objects.hashCode(altitudeSp);
        result = 31 * result + Objects.hashCode(airspeed);
        result = 31 * result + Objects.hashCode(airspeedSp);
        result = 31 * result + Objects.hashCode(groundspeed);
        result = 31 * result + Objects.hashCode(climbRate);
        result = 31 * result + Objects.hashCode(gpsNsat);
        result = 31 * result + Objects.hashCode(gpsFixType);
        result = 31 * result + Objects.hashCode(batteryRemaining);
        result = 31 * result + Objects.hashCode(temperature);
        result = 31 * result + Objects.hashCode(temperatureAir);
        result = 31 * result + Objects.hashCode(failsafe);
        result = 31 * result + Objects.hashCode(wpNum);
        result = 31 * result + Objects.hashCode(wpDistance);
        return result;
    }

    @Override
    public String toString() {
        return "HighLatency{baseMode=" + baseMode
                 + ", customMode=" + customMode
                 + ", landedState=" + landedState
                 + ", roll=" + roll
                 + ", pitch=" + pitch
                 + ", heading=" + heading
                 + ", throttle=" + throttle
                 + ", headingSp=" + headingSp
                 + ", latitude=" + latitude
                 + ", longitude=" + longitude
                 + ", altitudeAmsl=" + altitudeAmsl
                 + ", altitudeSp=" + altitudeSp
                 + ", airspeed=" + airspeed
                 + ", airspeedSp=" + airspeedSp
                 + ", groundspeed=" + groundspeed
                 + ", climbRate=" + climbRate
                 + ", gpsNsat=" + gpsNsat
                 + ", gpsFixType=" + gpsFixType
                 + ", batteryRemaining=" + batteryRemaining
                 + ", temperature=" + temperature
                 + ", temperatureAir=" + temperatureAir
                 + ", failsafe=" + failsafe
                 + ", wpNum=" + wpNum
                 + ", wpDistance=" + wpDistance + "}";
    }

    public static final class Builder {
        private EnumValue<MavModeFlag> baseMode;

        private long customMode;

        private EnumValue<MavLandedState> landedState;

        private int roll;

        private int pitch;

        private int heading;

        private int throttle;

        private int headingSp;

        private int latitude;

        private int longitude;

        private int altitudeAmsl;

        private int altitudeSp;

        private int airspeed;

        private int airspeedSp;

        private int groundspeed;

        private int climbRate;

        private int gpsNsat;

        private EnumValue<GpsFixType> gpsFixType;

        private int batteryRemaining;

        private int temperature;

        private int temperatureAir;

        private int failsafe;

        private int wpNum;

        private int wpDistance;

        /**
         * Bitmap of enabled system modes. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = MavModeFlag.class,
                description = "Bitmap of enabled system modes."
        )
        public final Builder baseMode(EnumValue<MavModeFlag> baseMode) {
            this.baseMode = baseMode;
            return this;
        }

        /**
         * Bitmap of enabled system modes. 
         */
        public final Builder baseMode(MavModeFlag entry) {
            return baseMode(EnumValue.of(entry));
        }

        /**
         * Bitmap of enabled system modes. 
         */
        public final Builder baseMode(Enum... flags) {
            return baseMode(EnumValue.create(flags));
        }

        /**
         * Bitmap of enabled system modes. 
         */
        public final Builder baseMode(Collection<Enum> flags) {
            return baseMode(EnumValue.create(flags));
        }

        /**
         * A bitfield for use for autopilot-specific flags. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "A bitfield for use for autopilot-specific flags."
        )
        public final Builder customMode(long customMode) {
            this.customMode = customMode;
            return this;
        }

        /**
         * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = MavLandedState.class,
                description = "The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown."
        )
        public final Builder landedState(EnumValue<MavLandedState> landedState) {
            this.landedState = landedState;
            return this;
        }

        /**
         * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown. 
         */
        public final Builder landedState(MavLandedState entry) {
            return landedState(EnumValue.of(entry));
        }

        /**
         * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown. 
         */
        public final Builder landedState(Enum... flags) {
            return landedState(EnumValue.create(flags));
        }

        /**
         * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown. 
         */
        public final Builder landedState(Collection<Enum> flags) {
            return landedState(EnumValue.create(flags));
        }

        /**
         * roll 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                signed = true,
                description = "roll"
        )
        public final Builder roll(int roll) {
            this.roll = roll;
            return this;
        }

        /**
         * pitch 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                signed = true,
                description = "pitch"
        )
        public final Builder pitch(int pitch) {
            this.pitch = pitch;
            return this;
        }

        /**
         * heading 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                description = "heading"
        )
        public final Builder heading(int heading) {
            this.heading = heading;
            return this;
        }

        /**
         * throttle (percentage) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                signed = true,
                description = "throttle (percentage)"
        )
        public final Builder throttle(int throttle) {
            this.throttle = throttle;
            return this;
        }

        /**
         * heading setpoint 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                signed = true,
                description = "heading setpoint"
        )
        public final Builder headingSp(int headingSp) {
            this.headingSp = headingSp;
            return this;
        }

        /**
         * Latitude 
         */
        @MavlinkFieldInfo(
                position = 10,
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
                position = 11,
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
                position = 12,
                unitSize = 2,
                signed = true,
                description = "Altitude above mean sea level"
        )
        public final Builder altitudeAmsl(int altitudeAmsl) {
            this.altitudeAmsl = altitudeAmsl;
            return this;
        }

        /**
         * Altitude setpoint relative to the home position 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 2,
                signed = true,
                description = "Altitude setpoint relative to the home position"
        )
        public final Builder altitudeSp(int altitudeSp) {
            this.altitudeSp = altitudeSp;
            return this;
        }

        /**
         * airspeed 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 1,
                description = "airspeed"
        )
        public final Builder airspeed(int airspeed) {
            this.airspeed = airspeed;
            return this;
        }

        /**
         * airspeed setpoint 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 1,
                description = "airspeed setpoint"
        )
        public final Builder airspeedSp(int airspeedSp) {
            this.airspeedSp = airspeedSp;
            return this;
        }

        /**
         * groundspeed 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 1,
                description = "groundspeed"
        )
        public final Builder groundspeed(int groundspeed) {
            this.groundspeed = groundspeed;
            return this;
        }

        /**
         * climb rate 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 1,
                signed = true,
                description = "climb rate"
        )
        public final Builder climbRate(int climbRate) {
            this.climbRate = climbRate;
            return this;
        }

        /**
         * Number of satellites visible. If unknown, set to UINT8_MAX 
         */
        @MavlinkFieldInfo(
                position = 18,
                unitSize = 1,
                description = "Number of satellites visible. If unknown, set to UINT8_MAX"
        )
        public final Builder gpsNsat(int gpsNsat) {
            this.gpsNsat = gpsNsat;
            return this;
        }

        /**
         * GPS Fix type. 
         */
        @MavlinkFieldInfo(
                position = 19,
                unitSize = 1,
                enumType = GpsFixType.class,
                description = "GPS Fix type."
        )
        public final Builder gpsFixType(EnumValue<GpsFixType> gpsFixType) {
            this.gpsFixType = gpsFixType;
            return this;
        }

        /**
         * GPS Fix type. 
         */
        public final Builder gpsFixType(GpsFixType entry) {
            return gpsFixType(EnumValue.of(entry));
        }

        /**
         * GPS Fix type. 
         */
        public final Builder gpsFixType(Enum... flags) {
            return gpsFixType(EnumValue.create(flags));
        }

        /**
         * GPS Fix type. 
         */
        public final Builder gpsFixType(Collection<Enum> flags) {
            return gpsFixType(EnumValue.create(flags));
        }

        /**
         * Remaining battery (percentage) 
         */
        @MavlinkFieldInfo(
                position = 20,
                unitSize = 1,
                description = "Remaining battery (percentage)"
        )
        public final Builder batteryRemaining(int batteryRemaining) {
            this.batteryRemaining = batteryRemaining;
            return this;
        }

        /**
         * Autopilot temperature (degrees C) 
         */
        @MavlinkFieldInfo(
                position = 21,
                unitSize = 1,
                signed = true,
                description = "Autopilot temperature (degrees C)"
        )
        public final Builder temperature(int temperature) {
            this.temperature = temperature;
            return this;
        }

        /**
         * Air temperature (degrees C) from airspeed sensor 
         */
        @MavlinkFieldInfo(
                position = 22,
                unitSize = 1,
                signed = true,
                description = "Air temperature (degrees C) from airspeed sensor"
        )
        public final Builder temperatureAir(int temperatureAir) {
            this.temperatureAir = temperatureAir;
            return this;
        }

        /**
         * failsafe (each bit represents a failsafe where 0=ok, 1=failsafe active (bit0:RC, bit1:batt, 
         * bit2:GPS, bit3:GCS, bit4:fence) 
         */
        @MavlinkFieldInfo(
                position = 23,
                unitSize = 1,
                description = "failsafe (each bit represents a failsafe where 0=ok, 1=failsafe active (bit0:RC, bit1:batt, bit2:GPS, bit3:GCS, bit4:fence)"
        )
        public final Builder failsafe(int failsafe) {
            this.failsafe = failsafe;
            return this;
        }

        /**
         * current waypoint number 
         */
        @MavlinkFieldInfo(
                position = 24,
                unitSize = 1,
                description = "current waypoint number"
        )
        public final Builder wpNum(int wpNum) {
            this.wpNum = wpNum;
            return this;
        }

        /**
         * distance to target 
         */
        @MavlinkFieldInfo(
                position = 25,
                unitSize = 2,
                description = "distance to target"
        )
        public final Builder wpDistance(int wpDistance) {
            this.wpDistance = wpDistance;
            return this;
        }

        public final HighLatency build() {
            return new HighLatency(baseMode, customMode, landedState, roll, pitch, heading, throttle, headingSp, latitude, longitude, altitudeAmsl, altitudeSp, airspeed, airspeedSp, groundspeed, climbRate, gpsNsat, gpsFixType, batteryRemaining, temperature, temperatureAir, failsafe, wpNum, wpDistance);
        }
    }
}
