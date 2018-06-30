package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * This contains the status of the GPS readings 
 */
@MavlinkMessageInfo(
        id = 194,
        crc = 51
)
public final class StatusGps {
    private final int csfails;

    private final int gpsquality;

    private final int msgstype;

    private final int posstatus;

    private final float magvar;

    private final int magdir;

    private final int modeind;

    private StatusGps(int csfails, int gpsquality, int msgstype, int posstatus, float magvar,
            int magdir, int modeind) {
        this.csfails = csfails;
        this.gpsquality = gpsquality;
        this.msgstype = msgstype;
        this.posstatus = posstatus;
        this.magvar = magvar;
        this.magdir = magdir;
        this.modeind = modeind;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Number of times checksum has failed 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2
    )
    public final int csfails() {
        return this.csfails;
    }

    /**
     * The quality indicator, 0=fix not available or invalid, 1=GPS fix, 2=C/A differential GPS, 
     * 6=Dead reckoning mode, 7=Manual input mode (fixed position), 8=Simulator mode, 9= WAAS a 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int gpsquality() {
        return this.gpsquality;
    }

    /**
     * Indicates if GN, GL or GP messages are being received 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int msgstype() {
        return this.msgstype;
    }

    /**
     * A = data valid, V = data invalid 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int posstatus() {
        return this.posstatus;
    }

    /**
     * Magnetic variation 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float magvar() {
        return this.magvar;
    }

    /**
     * Magnetic variation direction E/W. Easterly variation (E) subtracts from True course and 
     * Westerly variation (W) adds to True course 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            signed = true
    )
    public final int magdir() {
        return this.magdir;
    }

    /**
     * Positioning system mode indicator. A - Autonomous;D-Differential; E-Estimated (dead 
     * reckoning) mode;M-Manual input; N-Data not valid 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1
    )
    public final int modeind() {
        return this.modeind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        StatusGps other = (StatusGps)o;
        if (!Objects.deepEquals(csfails, other.csfails)) return false;
        if (!Objects.deepEquals(gpsquality, other.gpsquality)) return false;
        if (!Objects.deepEquals(msgstype, other.msgstype)) return false;
        if (!Objects.deepEquals(posstatus, other.posstatus)) return false;
        if (!Objects.deepEquals(magvar, other.magvar)) return false;
        if (!Objects.deepEquals(magdir, other.magdir)) return false;
        if (!Objects.deepEquals(modeind, other.modeind)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(csfails);
        result = 31 * result + Objects.hashCode(gpsquality);
        result = 31 * result + Objects.hashCode(msgstype);
        result = 31 * result + Objects.hashCode(posstatus);
        result = 31 * result + Objects.hashCode(magvar);
        result = 31 * result + Objects.hashCode(magdir);
        result = 31 * result + Objects.hashCode(modeind);
        return result;
    }

    public static final class Builder {
        private int csfails;

        private int gpsquality;

        private int msgstype;

        private int posstatus;

        private float magvar;

        private int magdir;

        private int modeind;

        /**
         * Number of times checksum has failed 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2
        )
        public final Builder csfails(int csfails) {
            this.csfails = csfails;
            return this;
        }

        /**
         * The quality indicator, 0=fix not available or invalid, 1=GPS fix, 2=C/A differential GPS, 
         * 6=Dead reckoning mode, 7=Manual input mode (fixed position), 8=Simulator mode, 9= WAAS a 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder gpsquality(int gpsquality) {
            this.gpsquality = gpsquality;
            return this;
        }

        /**
         * Indicates if GN, GL or GP messages are being received 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder msgstype(int msgstype) {
            this.msgstype = msgstype;
            return this;
        }

        /**
         * A = data valid, V = data invalid 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder posstatus(int posstatus) {
            this.posstatus = posstatus;
            return this;
        }

        /**
         * Magnetic variation 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder magvar(float magvar) {
            this.magvar = magvar;
            return this;
        }

        /**
         * Magnetic variation direction E/W. Easterly variation (E) subtracts from True course and 
         * Westerly variation (W) adds to True course 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                signed = true
        )
        public final Builder magdir(int magdir) {
            this.magdir = magdir;
            return this;
        }

        /**
         * Positioning system mode indicator. A - Autonomous;D-Differential; E-Estimated (dead 
         * reckoning) mode;M-Manual input; N-Data not valid 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1
        )
        public final Builder modeind(int modeind) {
            this.modeind = modeind;
            return this;
        }

        public final StatusGps build() {
            return new StatusGps(csfails, gpsquality, msgstype, posstatus, magvar, magdir, modeind);
        }
    }
}
