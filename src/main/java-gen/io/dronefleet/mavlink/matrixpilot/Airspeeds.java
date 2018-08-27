package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * The airspeed measured by sensors and IMU 
 */
@MavlinkMessageInfo(
        id = 182,
        crc = 154
)
public final class Airspeeds {
    private final long timeBootMs;

    private final int airspeedImu;

    private final int airspeedPitot;

    private final int airspeedHotWire;

    private final int airspeedUltrasonic;

    private final int aoa;

    private final int aoy;

    private Airspeeds(long timeBootMs, int airspeedImu, int airspeedPitot, int airspeedHotWire,
            int airspeedUltrasonic, int aoa, int aoy) {
        this.timeBootMs = timeBootMs;
        this.airspeedImu = airspeedImu;
        this.airspeedPitot = airspeedPitot;
        this.airspeedHotWire = airspeedHotWire;
        this.airspeedUltrasonic = airspeedUltrasonic;
        this.aoa = aoa;
        this.aoy = aoy;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (milliseconds since system boot) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Airspeed estimate from IMU, cm/s 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            signed = true
    )
    public final int airspeedImu() {
        return this.airspeedImu;
    }

    /**
     * Pitot measured forward airpseed, cm/s 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true
    )
    public final int airspeedPitot() {
        return this.airspeedPitot;
    }

    /**
     * Hot wire anenometer measured airspeed, cm/s 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true
    )
    public final int airspeedHotWire() {
        return this.airspeedHotWire;
    }

    /**
     * Ultrasonic measured airspeed, cm/s 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            signed = true
    )
    public final int airspeedUltrasonic() {
        return this.airspeedUltrasonic;
    }

    /**
     * Angle of attack sensor, degrees * 10 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            signed = true
    )
    public final int aoa() {
        return this.aoa;
    }

    /**
     * Yaw angle sensor, degrees * 10 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            signed = true
    )
    public final int aoy() {
        return this.aoy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Airspeeds other = (Airspeeds)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(airspeedImu, other.airspeedImu)) return false;
        if (!Objects.deepEquals(airspeedPitot, other.airspeedPitot)) return false;
        if (!Objects.deepEquals(airspeedHotWire, other.airspeedHotWire)) return false;
        if (!Objects.deepEquals(airspeedUltrasonic, other.airspeedUltrasonic)) return false;
        if (!Objects.deepEquals(aoa, other.aoa)) return false;
        if (!Objects.deepEquals(aoy, other.aoy)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(airspeedImu);
        result = 31 * result + Objects.hashCode(airspeedPitot);
        result = 31 * result + Objects.hashCode(airspeedHotWire);
        result = 31 * result + Objects.hashCode(airspeedUltrasonic);
        result = 31 * result + Objects.hashCode(aoa);
        result = 31 * result + Objects.hashCode(aoy);
        return result;
    }

    @Override
    public String toString() {
        return "Airspeeds{timeBootMs=" + timeBootMs
                 + ", airspeedImu=" + airspeedImu
                 + ", airspeedPitot=" + airspeedPitot
                 + ", airspeedHotWire=" + airspeedHotWire
                 + ", airspeedUltrasonic=" + airspeedUltrasonic
                 + ", aoa=" + aoa
                 + ", aoy=" + aoy + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private int airspeedImu;

        private int airspeedPitot;

        private int airspeedHotWire;

        private int airspeedUltrasonic;

        private int aoa;

        private int aoy;

        /**
         * Timestamp (milliseconds since system boot) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Airspeed estimate from IMU, cm/s 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                signed = true
        )
        public final Builder airspeedImu(int airspeedImu) {
            this.airspeedImu = airspeedImu;
            return this;
        }

        /**
         * Pitot measured forward airpseed, cm/s 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true
        )
        public final Builder airspeedPitot(int airspeedPitot) {
            this.airspeedPitot = airspeedPitot;
            return this;
        }

        /**
         * Hot wire anenometer measured airspeed, cm/s 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true
        )
        public final Builder airspeedHotWire(int airspeedHotWire) {
            this.airspeedHotWire = airspeedHotWire;
            return this;
        }

        /**
         * Ultrasonic measured airspeed, cm/s 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                signed = true
        )
        public final Builder airspeedUltrasonic(int airspeedUltrasonic) {
            this.airspeedUltrasonic = airspeedUltrasonic;
            return this;
        }

        /**
         * Angle of attack sensor, degrees * 10 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                signed = true
        )
        public final Builder aoa(int aoa) {
            this.aoa = aoa;
            return this;
        }

        /**
         * Yaw angle sensor, degrees * 10 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                signed = true
        )
        public final Builder aoy(int aoy) {
            this.aoy = aoy;
            return this;
        }

        public final Airspeeds build() {
            return new Airspeeds(timeBootMs, airspeedImu, airspeedPitot, airspeedHotWire, airspeedUltrasonic, aoa, aoy);
        }
    }
}
