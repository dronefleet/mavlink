package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Transmits the diagnostics data from the Novatel OEMStar GPS 
 */
@MavlinkMessageInfo(
        id = 195,
        crc = 59
)
public final class NovatelDiag {
    private final int timestatus;

    private final long receiverstatus;

    private final int solstatus;

    private final int postype;

    private final int veltype;

    private final float possolage;

    private final int csfails;

    private NovatelDiag(int timestatus, long receiverstatus, int solstatus, int postype,
            int veltype, float possolage, int csfails) {
        this.timestatus = timestatus;
        this.receiverstatus = receiverstatus;
        this.solstatus = solstatus;
        this.postype = postype;
        this.veltype = veltype;
        this.possolage = possolage;
        this.csfails = csfails;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The Time Status. See Table 8 page 27 Novatel OEMStar Manual 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int timestatus() {
        return this.timestatus;
    }

    /**
     * Status Bitfield. See table 69 page 350 Novatel OEMstar Manual 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final long receiverstatus() {
        return this.receiverstatus;
    }

    /**
     * solution Status. See table 44 page 197 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int solstatus() {
        return this.solstatus;
    }

    /**
     * position type. See table 43 page 196 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int postype() {
        return this.postype;
    }

    /**
     * velocity type. See table 43 page 196 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int veltype() {
        return this.veltype;
    }

    /**
     * Age of the position solution 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float possolage() {
        return this.possolage;
    }

    /**
     * Times the CRC has failed since boot 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2
    )
    public final int csfails() {
        return this.csfails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        NovatelDiag other = (NovatelDiag)o;
        if (!Objects.deepEquals(timestatus, other.timestatus)) return false;
        if (!Objects.deepEquals(receiverstatus, other.receiverstatus)) return false;
        if (!Objects.deepEquals(solstatus, other.solstatus)) return false;
        if (!Objects.deepEquals(postype, other.postype)) return false;
        if (!Objects.deepEquals(veltype, other.veltype)) return false;
        if (!Objects.deepEquals(possolage, other.possolage)) return false;
        if (!Objects.deepEquals(csfails, other.csfails)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timestatus);
        result = 31 * result + Objects.hashCode(receiverstatus);
        result = 31 * result + Objects.hashCode(solstatus);
        result = 31 * result + Objects.hashCode(postype);
        result = 31 * result + Objects.hashCode(veltype);
        result = 31 * result + Objects.hashCode(possolage);
        result = 31 * result + Objects.hashCode(csfails);
        return result;
    }

    @Override
    public String toString() {
        return "NovatelDiag{timestatus=" + timestatus
                 + ", receiverstatus=" + receiverstatus
                 + ", solstatus=" + solstatus
                 + ", postype=" + postype
                 + ", veltype=" + veltype
                 + ", possolage=" + possolage
                 + ", csfails=" + csfails + "}";
    }

    public static final class Builder {
        private int timestatus;

        private long receiverstatus;

        private int solstatus;

        private int postype;

        private int veltype;

        private float possolage;

        private int csfails;

        /**
         * The Time Status. See Table 8 page 27 Novatel OEMStar Manual 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder timestatus(int timestatus) {
            this.timestatus = timestatus;
            return this;
        }

        /**
         * Status Bitfield. See table 69 page 350 Novatel OEMstar Manual 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder receiverstatus(long receiverstatus) {
            this.receiverstatus = receiverstatus;
            return this;
        }

        /**
         * solution Status. See table 44 page 197 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder solstatus(int solstatus) {
            this.solstatus = solstatus;
            return this;
        }

        /**
         * position type. See table 43 page 196 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder postype(int postype) {
            this.postype = postype;
            return this;
        }

        /**
         * velocity type. See table 43 page 196 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder veltype(int veltype) {
            this.veltype = veltype;
            return this;
        }

        /**
         * Age of the position solution 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder possolage(float possolage) {
            this.possolage = possolage;
            return this;
        }

        /**
         * Times the CRC has failed since boot 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2
        )
        public final Builder csfails(int csfails) {
            this.csfails = csfails;
            return this;
        }

        public final NovatelDiag build() {
            return new NovatelDiag(timestatus, receiverstatus, solstatus, postype, veltype, possolage, csfails);
        }
    }
}
