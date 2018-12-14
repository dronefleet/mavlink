package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * This message can be requested by sending the MAV_CMD_GET_HOME_POSITION command. The 
 * position the system will return to and land on. The position is set automatically by the system 
 * during the takeoff in case it was not explicitly set by the operator before or after. The 
 * position the system will return to and land on. The global and local positions encode the 
 * position in the respective coordinate frames, while the q parameter encodes the orientation 
 * of the surface. Under normal conditions it describes the heading and terrain slope, which can 
 * be used by the aircraft to adjust the approach. The approach 3D vector describes the point to 
 * which the system should fly in normal flight mode and then perform a landing sequence along the 
 * vector. 
 */
@MavlinkMessageInfo(
        id = 242,
        crc = 104,
        description = "This message can be requested by sending the MAV_CMD_GET_HOME_POSITION command. The position the system will return to and land on. The position is set automatically by the system during the takeoff in case it was not explicitly set by the operator before or after. The position the system will return to and land on. The global and local positions encode the position in the respective coordinate frames, while the q parameter encodes the orientation of the surface. Under normal conditions it describes the heading and terrain slope, which can be used by the aircraft to adjust the approach. The approach 3D vector describes the point to which the system should fly in normal flight mode and then perform a landing sequence along the vector."
)
public final class HomePosition {
    private final int latitude;

    private final int longitude;

    private final int altitude;

    private final float x;

    private final float y;

    private final float z;

    private final List<Float> q;

    private final float approachX;

    private final float approachY;

    private final float approachZ;

    private final BigInteger timeUsec;

    private HomePosition(int latitude, int longitude, int altitude, float x, float y, float z,
            List<Float> q, float approachX, float approachY, float approachZ, BigInteger timeUsec) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.x = x;
        this.y = y;
        this.z = z;
        this.q = q;
        this.approachX = approachX;
        this.approachY = approachY;
        this.approachZ = approachZ;
        this.timeUsec = timeUsec;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Latitude (WGS84) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            signed = true,
            description = "Latitude (WGS84)"
    )
    public final int latitude() {
        return this.latitude;
    }

    /**
     * Longitude (WGS84) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            signed = true,
            description = "Longitude (WGS84)"
    )
    public final int longitude() {
        return this.longitude;
    }

    /**
     * Altitude (MSL). Positive for up. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true,
            description = "Altitude (MSL). Positive for up."
    )
    public final int altitude() {
        return this.altitude;
    }

    /**
     * Local X position of this position in the local coordinate frame 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Local X position of this position in the local coordinate frame"
    )
    public final float x() {
        return this.x;
    }

    /**
     * Local Y position of this position in the local coordinate frame 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Local Y position of this position in the local coordinate frame"
    )
    public final float y() {
        return this.y;
    }

    /**
     * Local Z position of this position in the local coordinate frame 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Local Z position of this position in the local coordinate frame"
    )
    public final float z() {
        return this.z;
    }

    /**
     * World to surface normal and heading transformation of the takeoff position. Used to indicate 
     * the heading and slope of the ground 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            arraySize = 4,
            description = "World to surface normal and heading transformation of the takeoff position. Used to indicate the heading and slope of the ground"
    )
    public final List<Float> q() {
        return this.q;
    }

    /**
     * Local X position of the end of the approach vector. Multicopters should set this position based 
     * on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as 
     * multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of 
     * the takeoff, assuming the takeoff happened from the threshold / touchdown zone. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Local X position of the end of the approach vector. Multicopters should set this position based on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the takeoff, assuming the takeoff happened from the threshold / touchdown zone."
    )
    public final float approachX() {
        return this.approachX;
    }

    /**
     * Local Y position of the end of the approach vector. Multicopters should set this position based 
     * on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as 
     * multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of 
     * the takeoff, assuming the takeoff happened from the threshold / touchdown zone. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Local Y position of the end of the approach vector. Multicopters should set this position based on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the takeoff, assuming the takeoff happened from the threshold / touchdown zone."
    )
    public final float approachY() {
        return this.approachY;
    }

    /**
     * Local Z position of the end of the approach vector. Multicopters should set this position based 
     * on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as 
     * multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of 
     * the takeoff, assuming the takeoff happened from the threshold / touchdown zone. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Local Z position of the end of the approach vector. Multicopters should set this position based on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the takeoff, assuming the takeoff happened from the threshold / touchdown zone."
    )
    public final float approachZ() {
        return this.approachZ;
    }

    /**
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
     * format (since 1.1.1970 or since system boot) by checking for the magnitude the number. 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 8,
            extension = true,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude the number."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        HomePosition other = (HomePosition)o;
        if (!Objects.deepEquals(latitude, other.latitude)) return false;
        if (!Objects.deepEquals(longitude, other.longitude)) return false;
        if (!Objects.deepEquals(altitude, other.altitude)) return false;
        if (!Objects.deepEquals(x, other.x)) return false;
        if (!Objects.deepEquals(y, other.y)) return false;
        if (!Objects.deepEquals(z, other.z)) return false;
        if (!Objects.deepEquals(q, other.q)) return false;
        if (!Objects.deepEquals(approachX, other.approachX)) return false;
        if (!Objects.deepEquals(approachY, other.approachY)) return false;
        if (!Objects.deepEquals(approachZ, other.approachZ)) return false;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(latitude);
        result = 31 * result + Objects.hashCode(longitude);
        result = 31 * result + Objects.hashCode(altitude);
        result = 31 * result + Objects.hashCode(x);
        result = 31 * result + Objects.hashCode(y);
        result = 31 * result + Objects.hashCode(z);
        result = 31 * result + Objects.hashCode(q);
        result = 31 * result + Objects.hashCode(approachX);
        result = 31 * result + Objects.hashCode(approachY);
        result = 31 * result + Objects.hashCode(approachZ);
        result = 31 * result + Objects.hashCode(timeUsec);
        return result;
    }

    @Override
    public String toString() {
        return "HomePosition{latitude=" + latitude
                 + ", longitude=" + longitude
                 + ", altitude=" + altitude
                 + ", x=" + x
                 + ", y=" + y
                 + ", z=" + z
                 + ", q=" + q
                 + ", approachX=" + approachX
                 + ", approachY=" + approachY
                 + ", approachZ=" + approachZ
                 + ", timeUsec=" + timeUsec + "}";
    }

    public static final class Builder {
        private int latitude;

        private int longitude;

        private int altitude;

        private float x;

        private float y;

        private float z;

        private List<Float> q;

        private float approachX;

        private float approachY;

        private float approachZ;

        private BigInteger timeUsec;

        /**
         * Latitude (WGS84) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                signed = true,
                description = "Latitude (WGS84)"
        )
        public final Builder latitude(int latitude) {
            this.latitude = latitude;
            return this;
        }

        /**
         * Longitude (WGS84) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                signed = true,
                description = "Longitude (WGS84)"
        )
        public final Builder longitude(int longitude) {
            this.longitude = longitude;
            return this;
        }

        /**
         * Altitude (MSL). Positive for up. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true,
                description = "Altitude (MSL). Positive for up."
        )
        public final Builder altitude(int altitude) {
            this.altitude = altitude;
            return this;
        }

        /**
         * Local X position of this position in the local coordinate frame 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Local X position of this position in the local coordinate frame"
        )
        public final Builder x(float x) {
            this.x = x;
            return this;
        }

        /**
         * Local Y position of this position in the local coordinate frame 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Local Y position of this position in the local coordinate frame"
        )
        public final Builder y(float y) {
            this.y = y;
            return this;
        }

        /**
         * Local Z position of this position in the local coordinate frame 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Local Z position of this position in the local coordinate frame"
        )
        public final Builder z(float z) {
            this.z = z;
            return this;
        }

        /**
         * World to surface normal and heading transformation of the takeoff position. Used to indicate 
         * the heading and slope of the ground 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                arraySize = 4,
                description = "World to surface normal and heading transformation of the takeoff position. Used to indicate the heading and slope of the ground"
        )
        public final Builder q(List<Float> q) {
            this.q = q;
            return this;
        }

        /**
         * Local X position of the end of the approach vector. Multicopters should set this position based 
         * on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as 
         * multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of 
         * the takeoff, assuming the takeoff happened from the threshold / touchdown zone. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Local X position of the end of the approach vector. Multicopters should set this position based on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the takeoff, assuming the takeoff happened from the threshold / touchdown zone."
        )
        public final Builder approachX(float approachX) {
            this.approachX = approachX;
            return this;
        }

        /**
         * Local Y position of the end of the approach vector. Multicopters should set this position based 
         * on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as 
         * multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of 
         * the takeoff, assuming the takeoff happened from the threshold / touchdown zone. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Local Y position of the end of the approach vector. Multicopters should set this position based on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the takeoff, assuming the takeoff happened from the threshold / touchdown zone."
        )
        public final Builder approachY(float approachY) {
            this.approachY = approachY;
            return this;
        }

        /**
         * Local Z position of the end of the approach vector. Multicopters should set this position based 
         * on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as 
         * multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of 
         * the takeoff, assuming the takeoff happened from the threshold / touchdown zone. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Local Z position of the end of the approach vector. Multicopters should set this position based on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the takeoff, assuming the takeoff happened from the threshold / touchdown zone."
        )
        public final Builder approachZ(float approachZ) {
            this.approachZ = approachZ;
            return this;
        }

        /**
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude the number. 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 8,
                extension = true,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude the number."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        public final HomePosition build() {
            return new HomePosition(latitude, longitude, altitude, x, y, z, q, approachX, approachY, approachZ, timeUsec);
        }
    }
}
