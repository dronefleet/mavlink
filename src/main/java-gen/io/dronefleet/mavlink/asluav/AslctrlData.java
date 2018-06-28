package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.math.BigInteger;

/**
 * ASL-fixed-wing controller data 
 */
@MavlinkMessageInfo(
        id = 203,
        crc = 172
)
public final class AslctrlData {
    private final BigInteger timestamp;

    private final int aslctrlMode;

    private final float h;

    private final float href;

    private final float hrefT;

    private final float pitchangle;

    private final float pitchangleref;

    private final float q;

    private final float qref;

    private final float uelev;

    private final float uthrot;

    private final float uthrot2;

    private final float nz;

    private final float airspeedref;

    private final int spoilersengaged;

    private final float yawangle;

    private final float yawangleref;

    private final float rollangle;

    private final float rollangleref;

    private final float p;

    private final float pref;

    private final float r;

    private final float rref;

    private final float uail;

    private final float urud;

    private AslctrlData(BigInteger timestamp, int aslctrlMode, float h, float href, float hrefT,
            float pitchangle, float pitchangleref, float q, float qref, float uelev, float uthrot,
            float uthrot2, float nz, float airspeedref, int spoilersengaged, float yawangle,
            float yawangleref, float rollangle, float rollangleref, float p, float pref, float r,
            float rref, float uail, float urud) {
        this.timestamp = timestamp;
        this.aslctrlMode = aslctrlMode;
        this.h = h;
        this.href = href;
        this.hrefT = hrefT;
        this.pitchangle = pitchangle;
        this.pitchangleref = pitchangleref;
        this.q = q;
        this.qref = qref;
        this.uelev = uelev;
        this.uthrot = uthrot;
        this.uthrot2 = uthrot2;
        this.nz = nz;
        this.airspeedref = airspeedref;
        this.spoilersengaged = spoilersengaged;
        this.yawangle = yawangle;
        this.yawangleref = yawangleref;
        this.rollangle = rollangle;
        this.rollangleref = rollangleref;
        this.p = p;
        this.pref = pref;
        this.r = r;
        this.rref = rref;
        this.uail = uail;
        this.urud = urud;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timestamp() {
        return this.timestamp;
    }

    /**
     * ASLCTRL control-mode (manual, stabilized, auto, etc...) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int aslctrlMode() {
        return this.aslctrlMode;
    }

    /**
     * See sourcecode for a description of these values... 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float h() {
        return this.h;
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float href() {
        return this.href;
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float hrefT() {
        return this.hrefT;
    }

    /**
     * Pitch angle 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float pitchangle() {
        return this.pitchangle;
    }

    /**
     * Pitch angle reference 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float pitchangleref() {
        return this.pitchangleref;
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float q() {
        return this.q;
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float qref() {
        return this.qref;
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4
    )
    public final float uelev() {
        return this.uelev;
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4
    )
    public final float uthrot() {
        return this.uthrot;
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4
    )
    public final float uthrot2() {
        return this.uthrot2;
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4
    )
    public final float nz() {
        return this.nz;
    }

    /**
     * Airspeed reference 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4
    )
    public final float airspeedref() {
        return this.airspeedref;
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 1
    )
    public final int spoilersengaged() {
        return this.spoilersengaged;
    }

    /**
     * Yaw angle 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 4
    )
    public final float yawangle() {
        return this.yawangle;
    }

    /**
     * Yaw angle reference 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 4
    )
    public final float yawangleref() {
        return this.yawangleref;
    }

    /**
     * Roll angle 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 4
    )
    public final float rollangle() {
        return this.rollangle;
    }

    /**
     * Roll angle reference 
     */
    @MavlinkFieldInfo(
            position = 19,
            unitSize = 4
    )
    public final float rollangleref() {
        return this.rollangleref;
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 20,
            unitSize = 4
    )
    public final float p() {
        return this.p;
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 21,
            unitSize = 4
    )
    public final float pref() {
        return this.pref;
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 22,
            unitSize = 4
    )
    public final float r() {
        return this.r;
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 23,
            unitSize = 4
    )
    public final float rref() {
        return this.rref;
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 24,
            unitSize = 4
    )
    public final float uail() {
        return this.uail;
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 25,
            unitSize = 4
    )
    public final float urud() {
        return this.urud;
    }

    public static final class Builder {
        private BigInteger timestamp;

        private int aslctrlMode;

        private float h;

        private float href;

        private float hrefT;

        private float pitchangle;

        private float pitchangleref;

        private float q;

        private float qref;

        private float uelev;

        private float uthrot;

        private float uthrot2;

        private float nz;

        private float airspeedref;

        private int spoilersengaged;

        private float yawangle;

        private float yawangleref;

        private float rollangle;

        private float rollangleref;

        private float p;

        private float pref;

        private float r;

        private float rref;

        private float uail;

        private float urud;

        /**
         * Timestamp 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8
        )
        public final Builder timestamp(BigInteger timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * ASLCTRL control-mode (manual, stabilized, auto, etc...) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder aslctrlMode(int aslctrlMode) {
            this.aslctrlMode = aslctrlMode;
            return this;
        }

        /**
         * See sourcecode for a description of these values... 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder h(float h) {
            this.h = h;
            return this;
        }

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder href(float href) {
            this.href = href;
            return this;
        }

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder hrefT(float hrefT) {
            this.hrefT = hrefT;
            return this;
        }

        /**
         * Pitch angle 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder pitchangle(float pitchangle) {
            this.pitchangle = pitchangle;
            return this;
        }

        /**
         * Pitch angle reference 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder pitchangleref(float pitchangleref) {
            this.pitchangleref = pitchangleref;
            return this;
        }

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder q(float q) {
            this.q = q;
            return this;
        }

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4
        )
        public final Builder qref(float qref) {
            this.qref = qref;
            return this;
        }

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4
        )
        public final Builder uelev(float uelev) {
            this.uelev = uelev;
            return this;
        }

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4
        )
        public final Builder uthrot(float uthrot) {
            this.uthrot = uthrot;
            return this;
        }

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4
        )
        public final Builder uthrot2(float uthrot2) {
            this.uthrot2 = uthrot2;
            return this;
        }

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4
        )
        public final Builder nz(float nz) {
            this.nz = nz;
            return this;
        }

        /**
         * Airspeed reference 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 4
        )
        public final Builder airspeedref(float airspeedref) {
            this.airspeedref = airspeedref;
            return this;
        }

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 1
        )
        public final Builder spoilersengaged(int spoilersengaged) {
            this.spoilersengaged = spoilersengaged;
            return this;
        }

        /**
         * Yaw angle 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 4
        )
        public final Builder yawangle(float yawangle) {
            this.yawangle = yawangle;
            return this;
        }

        /**
         * Yaw angle reference 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 4
        )
        public final Builder yawangleref(float yawangleref) {
            this.yawangleref = yawangleref;
            return this;
        }

        /**
         * Roll angle 
         */
        @MavlinkFieldInfo(
                position = 18,
                unitSize = 4
        )
        public final Builder rollangle(float rollangle) {
            this.rollangle = rollangle;
            return this;
        }

        /**
         * Roll angle reference 
         */
        @MavlinkFieldInfo(
                position = 19,
                unitSize = 4
        )
        public final Builder rollangleref(float rollangleref) {
            this.rollangleref = rollangleref;
            return this;
        }

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 20,
                unitSize = 4
        )
        public final Builder p(float p) {
            this.p = p;
            return this;
        }

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 21,
                unitSize = 4
        )
        public final Builder pref(float pref) {
            this.pref = pref;
            return this;
        }

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 22,
                unitSize = 4
        )
        public final Builder r(float r) {
            this.r = r;
            return this;
        }

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 23,
                unitSize = 4
        )
        public final Builder rref(float rref) {
            this.rref = rref;
            return this;
        }

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 24,
                unitSize = 4
        )
        public final Builder uail(float uail) {
            this.uail = uail;
            return this;
        }

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 25,
                unitSize = 4
        )
        public final Builder urud(float urud) {
            this.urud = urud;
            return this;
        }

        public final AslctrlData build() {
            return new AslctrlData(timestamp, aslctrlMode, h, href, hrefT, pitchangle, pitchangleref, q, qref, uelev, uthrot, uthrot2, nz, airspeedref, spoilersengaged, yawangle, yawangleref, rollangle, rollangleref, p, pref, r, rref, uail, urud);
        }
    }
}
