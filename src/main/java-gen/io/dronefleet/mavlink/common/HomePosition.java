package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.math.BigInteger;
import java.util.List;

/**
 * This message can be requested by sending the MAV_CMD_GET_HOME_POSITION command. The 
 * position the system will return to and land on. The position is set automatically by the system 
 * during the takeoff in case it was not explicitely set by the operator before or after. The 
 * position the system will return to and land on. The global and local positions encode the 
 * position in the respective coordinate frames, while the q parameter encodes the orientation 
 * of the surface. Under normal conditions it describes the heading and terrain slope, which can 
 * be used by the aircraft to adjust the approach. The approach 3D vector describes the point to 
 * which the system should fly in normal flight mode and then perform a landing sequence along the 
 * vector. 
 */
@MavlinkMessageInfo(
        id = 242,
        crc = 205
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
     * Latitude (WGS84), in degrees * 1E7 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            signed = true
    )
    public final int latitude() {
        return this.latitude;
    }

    /**
     * Longitude (WGS84, in degrees * 1E7 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            signed = true
    )
    public final int longitude() {
        return this.longitude;
    }

    /**
     * Altitude (AMSL), in meters * 1000 (positive for up) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true
    )
    public final int altitude() {
        return this.altitude;
    }

    /**
     * Local X position of this position in the local coordinate frame 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float x() {
        return this.x;
    }

    /**
     * Local Y position of this position in the local coordinate frame 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float y() {
        return this.y;
    }

    /**
     * Local Z position of this position in the local coordinate frame 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
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
            arraySize = 4
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
            unitSize = 4
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
            unitSize = 4
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
            unitSize = 4
    )
    public final float approachZ() {
        return this.approachZ;
    }

    /**
     * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 8,
            extension = true
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
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
         * Latitude (WGS84), in degrees * 1E7 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                signed = true
        )
        public final Builder latitude(int latitude) {
            this.latitude = latitude;
            return this;
        }

        /**
         * Longitude (WGS84, in degrees * 1E7 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                signed = true
        )
        public final Builder longitude(int longitude) {
            this.longitude = longitude;
            return this;
        }

        /**
         * Altitude (AMSL), in meters * 1000 (positive for up) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true
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
                unitSize = 4
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
                unitSize = 4
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
                unitSize = 4
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
                arraySize = 4
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
                unitSize = 4
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
                unitSize = 4
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
                unitSize = 4
        )
        public final Builder approachZ(float approachZ) {
            this.approachZ = approachZ;
            return this;
        }

        /**
         * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 8,
                extension = true
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
