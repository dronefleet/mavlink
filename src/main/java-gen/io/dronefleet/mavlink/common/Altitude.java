package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Objects;

/**
 * The current system altitude. 
 */
@MavlinkMessageInfo(
        id = 141,
        crc = 47,
        description = "The current system altitude."
)
public final class Altitude {
    private final BigInteger timeUsec;

    private final float altitudeMonotonic;

    private final float altitudeAmsl;

    private final float altitudeLocal;

    private final float altitudeRelative;

    private final float altitudeTerrain;

    private final float bottomClearance;

    private Altitude(BigInteger timeUsec, float altitudeMonotonic, float altitudeAmsl,
            float altitudeLocal, float altitudeRelative, float altitudeTerrain,
            float bottomClearance) {
        this.timeUsec = timeUsec;
        this.altitudeMonotonic = altitudeMonotonic;
        this.altitudeAmsl = altitudeAmsl;
        this.altitudeLocal = altitudeLocal;
        this.altitudeRelative = altitudeRelative;
        this.altitudeTerrain = altitudeTerrain;
        this.bottomClearance = bottomClearance;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
     * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * This altitude measure is initialized on system boot and monotonic (it is never reset, but 
     * represents the local altitude change). The only guarantee on this field is that it will never be 
     * reset and is consistent within a flight. The recommended value for this field is the 
     * uncorrected barometric altitude at boot time. This altitude will also drift and vary between 
     * flights. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "This altitude measure is initialized on system boot and monotonic (it is never reset, but represents the local altitude change). The only guarantee on this field is that it will never be reset and is consistent within a flight. The recommended value for this field is the uncorrected barometric altitude at boot time. This altitude will also drift and vary between flights."
    )
    public final float altitudeMonotonic() {
        return this.altitudeMonotonic;
    }

    /**
     * This altitude measure is strictly above mean sea level and might be non-monotonic (it might 
     * reset on events like GPS lock or when a new QNH value is set). It should be the altitude to which 
     * global altitude waypoints are compared to. Note that it is *not* the GPS altitude, however, 
     * most GPS modules already output MSL by default and not the WGS84 altitude. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "This altitude measure is strictly above mean sea level and might be non-monotonic (it might reset on events like GPS lock or when a new QNH value is set). It should be the altitude to which global altitude waypoints are compared to. Note that it is *not* the GPS altitude, however, most GPS modules already output MSL by default and not the WGS84 altitude."
    )
    public final float altitudeAmsl() {
        return this.altitudeAmsl;
    }

    /**
     * This is the local altitude in the local coordinate frame. It is not the altitude above home, but 
     * in reference to the coordinate origin (0, 0, 0). It is up-positive. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "This is the local altitude in the local coordinate frame. It is not the altitude above home, but in reference to the coordinate origin (0, 0, 0). It is up-positive."
    )
    public final float altitudeLocal() {
        return this.altitudeLocal;
    }

    /**
     * This is the altitude above the home position. It resets on each change of the current home 
     * position. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "This is the altitude above the home position. It resets on each change of the current home position."
    )
    public final float altitudeRelative() {
        return this.altitudeRelative;
    }

    /**
     * This is the altitude above terrain. It might be fed by a terrain database or an altimeter. Values 
     * smaller than -1000 should be interpreted as unknown. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "This is the altitude above terrain. It might be fed by a terrain database or an altimeter. Values smaller than -1000 should be interpreted as unknown."
    )
    public final float altitudeTerrain() {
        return this.altitudeTerrain;
    }

    /**
     * This is not the altitude, but the clear space below the system according to the fused clearance 
     * estimate. It generally should max out at the maximum range of e.g. the laser altimeter. It is 
     * generally a moving target. A negative value indicates no measurement available. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "This is not the altitude, but the clear space below the system according to the fused clearance estimate. It generally should max out at the maximum range of e.g. the laser altimeter. It is generally a moving target. A negative value indicates no measurement available."
    )
    public final float bottomClearance() {
        return this.bottomClearance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Altitude other = (Altitude)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(altitudeMonotonic, other.altitudeMonotonic)) return false;
        if (!Objects.deepEquals(altitudeAmsl, other.altitudeAmsl)) return false;
        if (!Objects.deepEquals(altitudeLocal, other.altitudeLocal)) return false;
        if (!Objects.deepEquals(altitudeRelative, other.altitudeRelative)) return false;
        if (!Objects.deepEquals(altitudeTerrain, other.altitudeTerrain)) return false;
        if (!Objects.deepEquals(bottomClearance, other.bottomClearance)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(altitudeMonotonic);
        result = 31 * result + Objects.hashCode(altitudeAmsl);
        result = 31 * result + Objects.hashCode(altitudeLocal);
        result = 31 * result + Objects.hashCode(altitudeRelative);
        result = 31 * result + Objects.hashCode(altitudeTerrain);
        result = 31 * result + Objects.hashCode(bottomClearance);
        return result;
    }

    @Override
    public String toString() {
        return "Altitude{timeUsec=" + timeUsec
                 + ", altitudeMonotonic=" + altitudeMonotonic
                 + ", altitudeAmsl=" + altitudeAmsl
                 + ", altitudeLocal=" + altitudeLocal
                 + ", altitudeRelative=" + altitudeRelative
                 + ", altitudeTerrain=" + altitudeTerrain
                 + ", bottomClearance=" + bottomClearance + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private float altitudeMonotonic;

        private float altitudeAmsl;

        private float altitudeLocal;

        private float altitudeRelative;

        private float altitudeTerrain;

        private float bottomClearance;

        /**
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * This altitude measure is initialized on system boot and monotonic (it is never reset, but 
         * represents the local altitude change). The only guarantee on this field is that it will never be 
         * reset and is consistent within a flight. The recommended value for this field is the 
         * uncorrected barometric altitude at boot time. This altitude will also drift and vary between 
         * flights. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "This altitude measure is initialized on system boot and monotonic (it is never reset, but represents the local altitude change). The only guarantee on this field is that it will never be reset and is consistent within a flight. The recommended value for this field is the uncorrected barometric altitude at boot time. This altitude will also drift and vary between flights."
        )
        public final Builder altitudeMonotonic(float altitudeMonotonic) {
            this.altitudeMonotonic = altitudeMonotonic;
            return this;
        }

        /**
         * This altitude measure is strictly above mean sea level and might be non-monotonic (it might 
         * reset on events like GPS lock or when a new QNH value is set). It should be the altitude to which 
         * global altitude waypoints are compared to. Note that it is *not* the GPS altitude, however, 
         * most GPS modules already output MSL by default and not the WGS84 altitude. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "This altitude measure is strictly above mean sea level and might be non-monotonic (it might reset on events like GPS lock or when a new QNH value is set). It should be the altitude to which global altitude waypoints are compared to. Note that it is *not* the GPS altitude, however, most GPS modules already output MSL by default and not the WGS84 altitude."
        )
        public final Builder altitudeAmsl(float altitudeAmsl) {
            this.altitudeAmsl = altitudeAmsl;
            return this;
        }

        /**
         * This is the local altitude in the local coordinate frame. It is not the altitude above home, but 
         * in reference to the coordinate origin (0, 0, 0). It is up-positive. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "This is the local altitude in the local coordinate frame. It is not the altitude above home, but in reference to the coordinate origin (0, 0, 0). It is up-positive."
        )
        public final Builder altitudeLocal(float altitudeLocal) {
            this.altitudeLocal = altitudeLocal;
            return this;
        }

        /**
         * This is the altitude above the home position. It resets on each change of the current home 
         * position. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "This is the altitude above the home position. It resets on each change of the current home position."
        )
        public final Builder altitudeRelative(float altitudeRelative) {
            this.altitudeRelative = altitudeRelative;
            return this;
        }

        /**
         * This is the altitude above terrain. It might be fed by a terrain database or an altimeter. Values 
         * smaller than -1000 should be interpreted as unknown. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "This is the altitude above terrain. It might be fed by a terrain database or an altimeter. Values smaller than -1000 should be interpreted as unknown."
        )
        public final Builder altitudeTerrain(float altitudeTerrain) {
            this.altitudeTerrain = altitudeTerrain;
            return this;
        }

        /**
         * This is not the altitude, but the clear space below the system according to the fused clearance 
         * estimate. It generally should max out at the maximum range of e.g. the laser altimeter. It is 
         * generally a moving target. A negative value indicates no measurement available. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "This is not the altitude, but the clear space below the system according to the fused clearance estimate. It generally should max out at the maximum range of e.g. the laser altimeter. It is generally a moving target. A negative value indicates no measurement available."
        )
        public final Builder bottomClearance(float bottomClearance) {
            this.bottomClearance = bottomClearance;
            return this;
        }

        public final Altitude build() {
            return new Altitude(timeUsec, altitudeMonotonic, altitudeAmsl, altitudeLocal, altitudeRelative, altitudeTerrain, bottomClearance);
        }
    }
}
