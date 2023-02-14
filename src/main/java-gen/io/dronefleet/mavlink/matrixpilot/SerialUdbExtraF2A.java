package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Backwards compatible MAVLink version of SERIAL_UDB_EXTRA - F2: Format Part A 
 */
@MavlinkMessageInfo(
        id = 170,
        crc = 103,
        description = "Backwards compatible MAVLink version of SERIAL_UDB_EXTRA - F2: Format Part A"
)
public final class SerialUdbExtraF2A {
    private final long sueTime;

    private final int sueStatus;

    private final int sueLatitude;

    private final int sueLongitude;

    private final int sueAltitude;

    private final int sueWaypointIndex;

    private final int sueRmat0;

    private final int sueRmat1;

    private final int sueRmat2;

    private final int sueRmat3;

    private final int sueRmat4;

    private final int sueRmat5;

    private final int sueRmat6;

    private final int sueRmat7;

    private final int sueRmat8;

    private final int sueCog;

    private final int sueSog;

    private final int sueCpuLoad;

    private final int sueAirSpeed3dimu;

    private final int sueEstimatedWind0;

    private final int sueEstimatedWind1;

    private final int sueEstimatedWind2;

    private final int sueMagfieldearth0;

    private final int sueMagfieldearth1;

    private final int sueMagfieldearth2;

    private final int sueSvs;

    private final int sueHdop;

    private SerialUdbExtraF2A(long sueTime, int sueStatus, int sueLatitude, int sueLongitude,
            int sueAltitude, int sueWaypointIndex, int sueRmat0, int sueRmat1, int sueRmat2,
            int sueRmat3, int sueRmat4, int sueRmat5, int sueRmat6, int sueRmat7, int sueRmat8,
            int sueCog, int sueSog, int sueCpuLoad, int sueAirSpeed3dimu, int sueEstimatedWind0,
            int sueEstimatedWind1, int sueEstimatedWind2, int sueMagfieldearth0,
            int sueMagfieldearth1, int sueMagfieldearth2, int sueSvs, int sueHdop) {
        this.sueTime = sueTime;
        this.sueStatus = sueStatus;
        this.sueLatitude = sueLatitude;
        this.sueLongitude = sueLongitude;
        this.sueAltitude = sueAltitude;
        this.sueWaypointIndex = sueWaypointIndex;
        this.sueRmat0 = sueRmat0;
        this.sueRmat1 = sueRmat1;
        this.sueRmat2 = sueRmat2;
        this.sueRmat3 = sueRmat3;
        this.sueRmat4 = sueRmat4;
        this.sueRmat5 = sueRmat5;
        this.sueRmat6 = sueRmat6;
        this.sueRmat7 = sueRmat7;
        this.sueRmat8 = sueRmat8;
        this.sueCog = sueCog;
        this.sueSog = sueSog;
        this.sueCpuLoad = sueCpuLoad;
        this.sueAirSpeed3dimu = sueAirSpeed3dimu;
        this.sueEstimatedWind0 = sueEstimatedWind0;
        this.sueEstimatedWind1 = sueEstimatedWind1;
        this.sueEstimatedWind2 = sueEstimatedWind2;
        this.sueMagfieldearth0 = sueMagfieldearth0;
        this.sueMagfieldearth1 = sueMagfieldearth1;
        this.sueMagfieldearth2 = sueMagfieldearth2;
        this.sueSvs = sueSvs;
        this.sueHdop = sueHdop;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Serial UDB Extra Time 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Serial UDB Extra Time"
    )
    public final long sueTime() {
        return this.sueTime;
    }

    /**
     * Serial UDB Extra Status 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Serial UDB Extra Status"
    )
    public final int sueStatus() {
        return this.sueStatus;
    }

    /**
     * Serial UDB Extra Latitude 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true,
            description = "Serial UDB Extra Latitude"
    )
    public final int sueLatitude() {
        return this.sueLatitude;
    }

    /**
     * Serial UDB Extra Longitude 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true,
            description = "Serial UDB Extra Longitude"
    )
    public final int sueLongitude() {
        return this.sueLongitude;
    }

    /**
     * Serial UDB Extra Altitude 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "Serial UDB Extra Altitude"
    )
    public final int sueAltitude() {
        return this.sueAltitude;
    }

    /**
     * Serial UDB Extra Waypoint Index 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "Serial UDB Extra Waypoint Index"
    )
    public final int sueWaypointIndex() {
        return this.sueWaypointIndex;
    }

    /**
     * Serial UDB Extra Rmat 0 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra Rmat 0"
    )
    public final int sueRmat0() {
        return this.sueRmat0;
    }

    /**
     * Serial UDB Extra Rmat 1 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra Rmat 1"
    )
    public final int sueRmat1() {
        return this.sueRmat1;
    }

    /**
     * Serial UDB Extra Rmat 2 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra Rmat 2"
    )
    public final int sueRmat2() {
        return this.sueRmat2;
    }

    /**
     * Serial UDB Extra Rmat 3 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra Rmat 3"
    )
    public final int sueRmat3() {
        return this.sueRmat3;
    }

    /**
     * Serial UDB Extra Rmat 4 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra Rmat 4"
    )
    public final int sueRmat4() {
        return this.sueRmat4;
    }

    /**
     * Serial UDB Extra Rmat 5 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra Rmat 5"
    )
    public final int sueRmat5() {
        return this.sueRmat5;
    }

    /**
     * Serial UDB Extra Rmat 6 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra Rmat 6"
    )
    public final int sueRmat6() {
        return this.sueRmat6;
    }

    /**
     * Serial UDB Extra Rmat 7 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra Rmat 7"
    )
    public final int sueRmat7() {
        return this.sueRmat7;
    }

    /**
     * Serial UDB Extra Rmat 8 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra Rmat 8"
    )
    public final int sueRmat8() {
        return this.sueRmat8;
    }

    /**
     * Serial UDB Extra GPS Course Over Ground 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 2,
            description = "Serial UDB Extra GPS Course Over Ground"
    )
    public final int sueCog() {
        return this.sueCog;
    }

    /**
     * Serial UDB Extra Speed Over Ground 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra Speed Over Ground"
    )
    public final int sueSog() {
        return this.sueSog;
    }

    /**
     * Serial UDB Extra CPU Load 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 2,
            description = "Serial UDB Extra CPU Load"
    )
    public final int sueCpuLoad() {
        return this.sueCpuLoad;
    }

    /**
     * Serial UDB Extra 3D IMU Air Speed 
     */
    @MavlinkFieldInfo(
            position = 19,
            unitSize = 2,
            description = "Serial UDB Extra 3D IMU Air Speed"
    )
    public final int sueAirSpeed3dimu() {
        return this.sueAirSpeed3dimu;
    }

    /**
     * Serial UDB Extra Estimated Wind 0 
     */
    @MavlinkFieldInfo(
            position = 20,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra Estimated Wind 0"
    )
    public final int sueEstimatedWind0() {
        return this.sueEstimatedWind0;
    }

    /**
     * Serial UDB Extra Estimated Wind 1 
     */
    @MavlinkFieldInfo(
            position = 21,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra Estimated Wind 1"
    )
    public final int sueEstimatedWind1() {
        return this.sueEstimatedWind1;
    }

    /**
     * Serial UDB Extra Estimated Wind 2 
     */
    @MavlinkFieldInfo(
            position = 22,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra Estimated Wind 2"
    )
    public final int sueEstimatedWind2() {
        return this.sueEstimatedWind2;
    }

    /**
     * Serial UDB Extra Magnetic Field Earth 0 
     */
    @MavlinkFieldInfo(
            position = 23,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra Magnetic Field Earth 0"
    )
    public final int sueMagfieldearth0() {
        return this.sueMagfieldearth0;
    }

    /**
     * Serial UDB Extra Magnetic Field Earth 1 
     */
    @MavlinkFieldInfo(
            position = 24,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra Magnetic Field Earth 1"
    )
    public final int sueMagfieldearth1() {
        return this.sueMagfieldearth1;
    }

    /**
     * Serial UDB Extra Magnetic Field Earth 2 
     */
    @MavlinkFieldInfo(
            position = 25,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra Magnetic Field Earth 2"
    )
    public final int sueMagfieldearth2() {
        return this.sueMagfieldearth2;
    }

    /**
     * Serial UDB Extra Number of Satellites in View 
     */
    @MavlinkFieldInfo(
            position = 26,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra Number of Satellites in View"
    )
    public final int sueSvs() {
        return this.sueSvs;
    }

    /**
     * Serial UDB Extra GPS Horizontal Dilution of Precision 
     */
    @MavlinkFieldInfo(
            position = 27,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra GPS Horizontal Dilution of Precision"
    )
    public final int sueHdop() {
        return this.sueHdop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SerialUdbExtraF2A other = (SerialUdbExtraF2A)o;
        if (!Objects.deepEquals(sueTime, other.sueTime)) return false;
        if (!Objects.deepEquals(sueStatus, other.sueStatus)) return false;
        if (!Objects.deepEquals(sueLatitude, other.sueLatitude)) return false;
        if (!Objects.deepEquals(sueLongitude, other.sueLongitude)) return false;
        if (!Objects.deepEquals(sueAltitude, other.sueAltitude)) return false;
        if (!Objects.deepEquals(sueWaypointIndex, other.sueWaypointIndex)) return false;
        if (!Objects.deepEquals(sueRmat0, other.sueRmat0)) return false;
        if (!Objects.deepEquals(sueRmat1, other.sueRmat1)) return false;
        if (!Objects.deepEquals(sueRmat2, other.sueRmat2)) return false;
        if (!Objects.deepEquals(sueRmat3, other.sueRmat3)) return false;
        if (!Objects.deepEquals(sueRmat4, other.sueRmat4)) return false;
        if (!Objects.deepEquals(sueRmat5, other.sueRmat5)) return false;
        if (!Objects.deepEquals(sueRmat6, other.sueRmat6)) return false;
        if (!Objects.deepEquals(sueRmat7, other.sueRmat7)) return false;
        if (!Objects.deepEquals(sueRmat8, other.sueRmat8)) return false;
        if (!Objects.deepEquals(sueCog, other.sueCog)) return false;
        if (!Objects.deepEquals(sueSog, other.sueSog)) return false;
        if (!Objects.deepEquals(sueCpuLoad, other.sueCpuLoad)) return false;
        if (!Objects.deepEquals(sueAirSpeed3dimu, other.sueAirSpeed3dimu)) return false;
        if (!Objects.deepEquals(sueEstimatedWind0, other.sueEstimatedWind0)) return false;
        if (!Objects.deepEquals(sueEstimatedWind1, other.sueEstimatedWind1)) return false;
        if (!Objects.deepEquals(sueEstimatedWind2, other.sueEstimatedWind2)) return false;
        if (!Objects.deepEquals(sueMagfieldearth0, other.sueMagfieldearth0)) return false;
        if (!Objects.deepEquals(sueMagfieldearth1, other.sueMagfieldearth1)) return false;
        if (!Objects.deepEquals(sueMagfieldearth2, other.sueMagfieldearth2)) return false;
        if (!Objects.deepEquals(sueSvs, other.sueSvs)) return false;
        if (!Objects.deepEquals(sueHdop, other.sueHdop)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(sueTime);
        result = 31 * result + Objects.hashCode(sueStatus);
        result = 31 * result + Objects.hashCode(sueLatitude);
        result = 31 * result + Objects.hashCode(sueLongitude);
        result = 31 * result + Objects.hashCode(sueAltitude);
        result = 31 * result + Objects.hashCode(sueWaypointIndex);
        result = 31 * result + Objects.hashCode(sueRmat0);
        result = 31 * result + Objects.hashCode(sueRmat1);
        result = 31 * result + Objects.hashCode(sueRmat2);
        result = 31 * result + Objects.hashCode(sueRmat3);
        result = 31 * result + Objects.hashCode(sueRmat4);
        result = 31 * result + Objects.hashCode(sueRmat5);
        result = 31 * result + Objects.hashCode(sueRmat6);
        result = 31 * result + Objects.hashCode(sueRmat7);
        result = 31 * result + Objects.hashCode(sueRmat8);
        result = 31 * result + Objects.hashCode(sueCog);
        result = 31 * result + Objects.hashCode(sueSog);
        result = 31 * result + Objects.hashCode(sueCpuLoad);
        result = 31 * result + Objects.hashCode(sueAirSpeed3dimu);
        result = 31 * result + Objects.hashCode(sueEstimatedWind0);
        result = 31 * result + Objects.hashCode(sueEstimatedWind1);
        result = 31 * result + Objects.hashCode(sueEstimatedWind2);
        result = 31 * result + Objects.hashCode(sueMagfieldearth0);
        result = 31 * result + Objects.hashCode(sueMagfieldearth1);
        result = 31 * result + Objects.hashCode(sueMagfieldearth2);
        result = 31 * result + Objects.hashCode(sueSvs);
        result = 31 * result + Objects.hashCode(sueHdop);
        return result;
    }

    @Override
    public String toString() {
        return "SerialUdbExtraF2A{sueTime=" + sueTime
                 + ", sueStatus=" + sueStatus
                 + ", sueLatitude=" + sueLatitude
                 + ", sueLongitude=" + sueLongitude
                 + ", sueAltitude=" + sueAltitude
                 + ", sueWaypointIndex=" + sueWaypointIndex
                 + ", sueRmat0=" + sueRmat0
                 + ", sueRmat1=" + sueRmat1
                 + ", sueRmat2=" + sueRmat2
                 + ", sueRmat3=" + sueRmat3
                 + ", sueRmat4=" + sueRmat4
                 + ", sueRmat5=" + sueRmat5
                 + ", sueRmat6=" + sueRmat6
                 + ", sueRmat7=" + sueRmat7
                 + ", sueRmat8=" + sueRmat8
                 + ", sueCog=" + sueCog
                 + ", sueSog=" + sueSog
                 + ", sueCpuLoad=" + sueCpuLoad
                 + ", sueAirSpeed3dimu=" + sueAirSpeed3dimu
                 + ", sueEstimatedWind0=" + sueEstimatedWind0
                 + ", sueEstimatedWind1=" + sueEstimatedWind1
                 + ", sueEstimatedWind2=" + sueEstimatedWind2
                 + ", sueMagfieldearth0=" + sueMagfieldearth0
                 + ", sueMagfieldearth1=" + sueMagfieldearth1
                 + ", sueMagfieldearth2=" + sueMagfieldearth2
                 + ", sueSvs=" + sueSvs
                 + ", sueHdop=" + sueHdop + "}";
    }

    public static final class Builder {
        private long sueTime;

        private int sueStatus;

        private int sueLatitude;

        private int sueLongitude;

        private int sueAltitude;

        private int sueWaypointIndex;

        private int sueRmat0;

        private int sueRmat1;

        private int sueRmat2;

        private int sueRmat3;

        private int sueRmat4;

        private int sueRmat5;

        private int sueRmat6;

        private int sueRmat7;

        private int sueRmat8;

        private int sueCog;

        private int sueSog;

        private int sueCpuLoad;

        private int sueAirSpeed3dimu;

        private int sueEstimatedWind0;

        private int sueEstimatedWind1;

        private int sueEstimatedWind2;

        private int sueMagfieldearth0;

        private int sueMagfieldearth1;

        private int sueMagfieldearth2;

        private int sueSvs;

        private int sueHdop;

        /**
         * Serial UDB Extra Time 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Serial UDB Extra Time"
        )
        public final Builder sueTime(long sueTime) {
            this.sueTime = sueTime;
            return this;
        }

        /**
         * Serial UDB Extra Status 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Serial UDB Extra Status"
        )
        public final Builder sueStatus(int sueStatus) {
            this.sueStatus = sueStatus;
            return this;
        }

        /**
         * Serial UDB Extra Latitude 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true,
                description = "Serial UDB Extra Latitude"
        )
        public final Builder sueLatitude(int sueLatitude) {
            this.sueLatitude = sueLatitude;
            return this;
        }

        /**
         * Serial UDB Extra Longitude 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true,
                description = "Serial UDB Extra Longitude"
        )
        public final Builder sueLongitude(int sueLongitude) {
            this.sueLongitude = sueLongitude;
            return this;
        }

        /**
         * Serial UDB Extra Altitude 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "Serial UDB Extra Altitude"
        )
        public final Builder sueAltitude(int sueAltitude) {
            this.sueAltitude = sueAltitude;
            return this;
        }

        /**
         * Serial UDB Extra Waypoint Index 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "Serial UDB Extra Waypoint Index"
        )
        public final Builder sueWaypointIndex(int sueWaypointIndex) {
            this.sueWaypointIndex = sueWaypointIndex;
            return this;
        }

        /**
         * Serial UDB Extra Rmat 0 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra Rmat 0"
        )
        public final Builder sueRmat0(int sueRmat0) {
            this.sueRmat0 = sueRmat0;
            return this;
        }

        /**
         * Serial UDB Extra Rmat 1 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra Rmat 1"
        )
        public final Builder sueRmat1(int sueRmat1) {
            this.sueRmat1 = sueRmat1;
            return this;
        }

        /**
         * Serial UDB Extra Rmat 2 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra Rmat 2"
        )
        public final Builder sueRmat2(int sueRmat2) {
            this.sueRmat2 = sueRmat2;
            return this;
        }

        /**
         * Serial UDB Extra Rmat 3 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra Rmat 3"
        )
        public final Builder sueRmat3(int sueRmat3) {
            this.sueRmat3 = sueRmat3;
            return this;
        }

        /**
         * Serial UDB Extra Rmat 4 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra Rmat 4"
        )
        public final Builder sueRmat4(int sueRmat4) {
            this.sueRmat4 = sueRmat4;
            return this;
        }

        /**
         * Serial UDB Extra Rmat 5 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra Rmat 5"
        )
        public final Builder sueRmat5(int sueRmat5) {
            this.sueRmat5 = sueRmat5;
            return this;
        }

        /**
         * Serial UDB Extra Rmat 6 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra Rmat 6"
        )
        public final Builder sueRmat6(int sueRmat6) {
            this.sueRmat6 = sueRmat6;
            return this;
        }

        /**
         * Serial UDB Extra Rmat 7 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra Rmat 7"
        )
        public final Builder sueRmat7(int sueRmat7) {
            this.sueRmat7 = sueRmat7;
            return this;
        }

        /**
         * Serial UDB Extra Rmat 8 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra Rmat 8"
        )
        public final Builder sueRmat8(int sueRmat8) {
            this.sueRmat8 = sueRmat8;
            return this;
        }

        /**
         * Serial UDB Extra GPS Course Over Ground 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 2,
                description = "Serial UDB Extra GPS Course Over Ground"
        )
        public final Builder sueCog(int sueCog) {
            this.sueCog = sueCog;
            return this;
        }

        /**
         * Serial UDB Extra Speed Over Ground 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra Speed Over Ground"
        )
        public final Builder sueSog(int sueSog) {
            this.sueSog = sueSog;
            return this;
        }

        /**
         * Serial UDB Extra CPU Load 
         */
        @MavlinkFieldInfo(
                position = 18,
                unitSize = 2,
                description = "Serial UDB Extra CPU Load"
        )
        public final Builder sueCpuLoad(int sueCpuLoad) {
            this.sueCpuLoad = sueCpuLoad;
            return this;
        }

        /**
         * Serial UDB Extra 3D IMU Air Speed 
         */
        @MavlinkFieldInfo(
                position = 19,
                unitSize = 2,
                description = "Serial UDB Extra 3D IMU Air Speed"
        )
        public final Builder sueAirSpeed3dimu(int sueAirSpeed3dimu) {
            this.sueAirSpeed3dimu = sueAirSpeed3dimu;
            return this;
        }

        /**
         * Serial UDB Extra Estimated Wind 0 
         */
        @MavlinkFieldInfo(
                position = 20,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra Estimated Wind 0"
        )
        public final Builder sueEstimatedWind0(int sueEstimatedWind0) {
            this.sueEstimatedWind0 = sueEstimatedWind0;
            return this;
        }

        /**
         * Serial UDB Extra Estimated Wind 1 
         */
        @MavlinkFieldInfo(
                position = 21,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra Estimated Wind 1"
        )
        public final Builder sueEstimatedWind1(int sueEstimatedWind1) {
            this.sueEstimatedWind1 = sueEstimatedWind1;
            return this;
        }

        /**
         * Serial UDB Extra Estimated Wind 2 
         */
        @MavlinkFieldInfo(
                position = 22,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra Estimated Wind 2"
        )
        public final Builder sueEstimatedWind2(int sueEstimatedWind2) {
            this.sueEstimatedWind2 = sueEstimatedWind2;
            return this;
        }

        /**
         * Serial UDB Extra Magnetic Field Earth 0 
         */
        @MavlinkFieldInfo(
                position = 23,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra Magnetic Field Earth 0"
        )
        public final Builder sueMagfieldearth0(int sueMagfieldearth0) {
            this.sueMagfieldearth0 = sueMagfieldearth0;
            return this;
        }

        /**
         * Serial UDB Extra Magnetic Field Earth 1 
         */
        @MavlinkFieldInfo(
                position = 24,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra Magnetic Field Earth 1"
        )
        public final Builder sueMagfieldearth1(int sueMagfieldearth1) {
            this.sueMagfieldearth1 = sueMagfieldearth1;
            return this;
        }

        /**
         * Serial UDB Extra Magnetic Field Earth 2 
         */
        @MavlinkFieldInfo(
                position = 25,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra Magnetic Field Earth 2"
        )
        public final Builder sueMagfieldearth2(int sueMagfieldearth2) {
            this.sueMagfieldearth2 = sueMagfieldearth2;
            return this;
        }

        /**
         * Serial UDB Extra Number of Satellites in View 
         */
        @MavlinkFieldInfo(
                position = 26,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra Number of Satellites in View"
        )
        public final Builder sueSvs(int sueSvs) {
            this.sueSvs = sueSvs;
            return this;
        }

        /**
         * Serial UDB Extra GPS Horizontal Dilution of Precision 
         */
        @MavlinkFieldInfo(
                position = 27,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra GPS Horizontal Dilution of Precision"
        )
        public final Builder sueHdop(int sueHdop) {
            this.sueHdop = sueHdop;
            return this;
        }

        public final SerialUdbExtraF2A build() {
            return new SerialUdbExtraF2A(sueTime, sueStatus, sueLatitude, sueLongitude, sueAltitude, sueWaypointIndex, sueRmat0, sueRmat1, sueRmat2, sueRmat3, sueRmat4, sueRmat5, sueRmat6, sueRmat7, sueRmat8, sueCog, sueSog, sueCpuLoad, sueAirSpeed3dimu, sueEstimatedWind0, sueEstimatedWind1, sueEstimatedWind2, sueMagfieldearth0, sueMagfieldearth1, sueMagfieldearth2, sueSvs, sueHdop);
        }
    }
}
