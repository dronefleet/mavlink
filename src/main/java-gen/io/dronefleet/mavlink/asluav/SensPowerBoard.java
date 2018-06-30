package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Monitoring of power board status 
 */
@MavlinkMessageInfo(
        id = 212,
        crc = 222
)
public final class SensPowerBoard {
    private final BigInteger timestamp;

    private final int pwrBrdStatus;

    private final int pwrBrdLedStatus;

    private final float pwrBrdSystemVolt;

    private final float pwrBrdServoVolt;

    private final float pwrBrdDigitalVolt;

    private final float pwrBrdMotLAmp;

    private final float pwrBrdMotRAmp;

    private final float pwrBrdAnalogAmp;

    private final float pwrBrdDigitalAmp;

    private final float pwrBrdExtAmp;

    private final float pwrBrdAuxAmp;

    private SensPowerBoard(BigInteger timestamp, int pwrBrdStatus, int pwrBrdLedStatus,
            float pwrBrdSystemVolt, float pwrBrdServoVolt, float pwrBrdDigitalVolt,
            float pwrBrdMotLAmp, float pwrBrdMotRAmp, float pwrBrdAnalogAmp, float pwrBrdDigitalAmp,
            float pwrBrdExtAmp, float pwrBrdAuxAmp) {
        this.timestamp = timestamp;
        this.pwrBrdStatus = pwrBrdStatus;
        this.pwrBrdLedStatus = pwrBrdLedStatus;
        this.pwrBrdSystemVolt = pwrBrdSystemVolt;
        this.pwrBrdServoVolt = pwrBrdServoVolt;
        this.pwrBrdDigitalVolt = pwrBrdDigitalVolt;
        this.pwrBrdMotLAmp = pwrBrdMotLAmp;
        this.pwrBrdMotRAmp = pwrBrdMotRAmp;
        this.pwrBrdAnalogAmp = pwrBrdAnalogAmp;
        this.pwrBrdDigitalAmp = pwrBrdDigitalAmp;
        this.pwrBrdExtAmp = pwrBrdExtAmp;
        this.pwrBrdAuxAmp = pwrBrdAuxAmp;
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
     * Power board status register 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int pwrBrdStatus() {
        return this.pwrBrdStatus;
    }

    /**
     * Power board leds status 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int pwrBrdLedStatus() {
        return this.pwrBrdLedStatus;
    }

    /**
     * Power board system voltage 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float pwrBrdSystemVolt() {
        return this.pwrBrdSystemVolt;
    }

    /**
     * Power board servo voltage 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float pwrBrdServoVolt() {
        return this.pwrBrdServoVolt;
    }

    /**
     * Power board digital voltage 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float pwrBrdDigitalVolt() {
        return this.pwrBrdDigitalVolt;
    }

    /**
     * Power board left motor current sensor 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float pwrBrdMotLAmp() {
        return this.pwrBrdMotLAmp;
    }

    /**
     * Power board right motor current sensor 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float pwrBrdMotRAmp() {
        return this.pwrBrdMotRAmp;
    }

    /**
     * Power board analog current sensor 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float pwrBrdAnalogAmp() {
        return this.pwrBrdAnalogAmp;
    }

    /**
     * Power board digital current sensor 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4
    )
    public final float pwrBrdDigitalAmp() {
        return this.pwrBrdDigitalAmp;
    }

    /**
     * Power board extension current sensor 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4
    )
    public final float pwrBrdExtAmp() {
        return this.pwrBrdExtAmp;
    }

    /**
     * Power board aux current sensor 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4
    )
    public final float pwrBrdAuxAmp() {
        return this.pwrBrdAuxAmp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SensPowerBoard other = (SensPowerBoard)o;
        if (!Objects.deepEquals(timestamp, other.timestamp)) return false;
        if (!Objects.deepEquals(pwrBrdStatus, other.pwrBrdStatus)) return false;
        if (!Objects.deepEquals(pwrBrdLedStatus, other.pwrBrdLedStatus)) return false;
        if (!Objects.deepEquals(pwrBrdSystemVolt, other.pwrBrdSystemVolt)) return false;
        if (!Objects.deepEquals(pwrBrdServoVolt, other.pwrBrdServoVolt)) return false;
        if (!Objects.deepEquals(pwrBrdDigitalVolt, other.pwrBrdDigitalVolt)) return false;
        if (!Objects.deepEquals(pwrBrdMotLAmp, other.pwrBrdMotLAmp)) return false;
        if (!Objects.deepEquals(pwrBrdMotRAmp, other.pwrBrdMotRAmp)) return false;
        if (!Objects.deepEquals(pwrBrdAnalogAmp, other.pwrBrdAnalogAmp)) return false;
        if (!Objects.deepEquals(pwrBrdDigitalAmp, other.pwrBrdDigitalAmp)) return false;
        if (!Objects.deepEquals(pwrBrdExtAmp, other.pwrBrdExtAmp)) return false;
        if (!Objects.deepEquals(pwrBrdAuxAmp, other.pwrBrdAuxAmp)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timestamp);
        result = 31 * result + Objects.hashCode(pwrBrdStatus);
        result = 31 * result + Objects.hashCode(pwrBrdLedStatus);
        result = 31 * result + Objects.hashCode(pwrBrdSystemVolt);
        result = 31 * result + Objects.hashCode(pwrBrdServoVolt);
        result = 31 * result + Objects.hashCode(pwrBrdDigitalVolt);
        result = 31 * result + Objects.hashCode(pwrBrdMotLAmp);
        result = 31 * result + Objects.hashCode(pwrBrdMotRAmp);
        result = 31 * result + Objects.hashCode(pwrBrdAnalogAmp);
        result = 31 * result + Objects.hashCode(pwrBrdDigitalAmp);
        result = 31 * result + Objects.hashCode(pwrBrdExtAmp);
        result = 31 * result + Objects.hashCode(pwrBrdAuxAmp);
        return result;
    }

    public static final class Builder {
        private BigInteger timestamp;

        private int pwrBrdStatus;

        private int pwrBrdLedStatus;

        private float pwrBrdSystemVolt;

        private float pwrBrdServoVolt;

        private float pwrBrdDigitalVolt;

        private float pwrBrdMotLAmp;

        private float pwrBrdMotRAmp;

        private float pwrBrdAnalogAmp;

        private float pwrBrdDigitalAmp;

        private float pwrBrdExtAmp;

        private float pwrBrdAuxAmp;

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
         * Power board status register 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder pwrBrdStatus(int pwrBrdStatus) {
            this.pwrBrdStatus = pwrBrdStatus;
            return this;
        }

        /**
         * Power board leds status 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder pwrBrdLedStatus(int pwrBrdLedStatus) {
            this.pwrBrdLedStatus = pwrBrdLedStatus;
            return this;
        }

        /**
         * Power board system voltage 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder pwrBrdSystemVolt(float pwrBrdSystemVolt) {
            this.pwrBrdSystemVolt = pwrBrdSystemVolt;
            return this;
        }

        /**
         * Power board servo voltage 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder pwrBrdServoVolt(float pwrBrdServoVolt) {
            this.pwrBrdServoVolt = pwrBrdServoVolt;
            return this;
        }

        /**
         * Power board digital voltage 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder pwrBrdDigitalVolt(float pwrBrdDigitalVolt) {
            this.pwrBrdDigitalVolt = pwrBrdDigitalVolt;
            return this;
        }

        /**
         * Power board left motor current sensor 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder pwrBrdMotLAmp(float pwrBrdMotLAmp) {
            this.pwrBrdMotLAmp = pwrBrdMotLAmp;
            return this;
        }

        /**
         * Power board right motor current sensor 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder pwrBrdMotRAmp(float pwrBrdMotRAmp) {
            this.pwrBrdMotRAmp = pwrBrdMotRAmp;
            return this;
        }

        /**
         * Power board analog current sensor 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4
        )
        public final Builder pwrBrdAnalogAmp(float pwrBrdAnalogAmp) {
            this.pwrBrdAnalogAmp = pwrBrdAnalogAmp;
            return this;
        }

        /**
         * Power board digital current sensor 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4
        )
        public final Builder pwrBrdDigitalAmp(float pwrBrdDigitalAmp) {
            this.pwrBrdDigitalAmp = pwrBrdDigitalAmp;
            return this;
        }

        /**
         * Power board extension current sensor 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4
        )
        public final Builder pwrBrdExtAmp(float pwrBrdExtAmp) {
            this.pwrBrdExtAmp = pwrBrdExtAmp;
            return this;
        }

        /**
         * Power board aux current sensor 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4
        )
        public final Builder pwrBrdAuxAmp(float pwrBrdAuxAmp) {
            this.pwrBrdAuxAmp = pwrBrdAuxAmp;
            return this;
        }

        public final SensPowerBoard build() {
            return new SensPowerBoard(timestamp, pwrBrdStatus, pwrBrdLedStatus, pwrBrdSystemVolt, pwrBrdServoVolt, pwrBrdDigitalVolt, pwrBrdMotLAmp, pwrBrdMotRAmp, pwrBrdAnalogAmp, pwrBrdDigitalAmp, pwrBrdExtAmp, pwrBrdAuxAmp);
        }
    }
}
