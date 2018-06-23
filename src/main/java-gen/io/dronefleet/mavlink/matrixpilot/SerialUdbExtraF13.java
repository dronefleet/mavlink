package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F13: format 
 */
@MavlinkMessageInfo(
        id = 177,
        crc = 249
)
public final class SerialUdbExtraF13 {
    /**
     * Serial UDB Extra MP Origin Latitude 
     */
    private final int sueLatOrigin;

    /**
     * Serial UDB Extra MP Origin Longitude 
     */
    private final int sueLonOrigin;

    /**
     * Serial UDB Extra MP Origin Altitude Above Sea Level 
     */
    private final int sueAltOrigin;

    /**
     * Serial UDB Extra GPS Week Number 
     */
    private final int sueWeekNo;

    private SerialUdbExtraF13(int sueLatOrigin, int sueLonOrigin, int sueAltOrigin, int sueWeekNo) {
        this.sueLatOrigin = sueLatOrigin;
        this.sueLonOrigin = sueLonOrigin;
        this.sueAltOrigin = sueAltOrigin;
        this.sueWeekNo = sueWeekNo;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "SerialUdbExtraF13{sueWeekNo=" + sueWeekNo
                 + ", sueLatOrigin=" + sueLatOrigin
                 + ", sueLonOrigin=" + sueLonOrigin
                 + ", sueAltOrigin=" + sueAltOrigin + "}";
    }

    /**
     * Serial UDB Extra MP Origin Latitude 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            signed = true
    )
    public final int sueLatOrigin() {
        return sueLatOrigin;
    }

    /**
     * Serial UDB Extra MP Origin Longitude 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true
    )
    public final int sueLonOrigin() {
        return sueLonOrigin;
    }

    /**
     * Serial UDB Extra MP Origin Altitude Above Sea Level 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true
    )
    public final int sueAltOrigin() {
        return sueAltOrigin;
    }

    /**
     * Serial UDB Extra GPS Week Number 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2,
            signed = true
    )
    public final int sueWeekNo() {
        return sueWeekNo;
    }

    public static class Builder {
        private int sueLatOrigin;

        private int sueLonOrigin;

        private int sueAltOrigin;

        private int sueWeekNo;

        private Builder() {
        }

        /**
         * Serial UDB Extra MP Origin Latitude 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                signed = true
        )
        public final Builder sueLatOrigin(int sueLatOrigin) {
            this.sueLatOrigin = sueLatOrigin;
            return this;
        }

        /**
         * Serial UDB Extra MP Origin Longitude 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true
        )
        public final Builder sueLonOrigin(int sueLonOrigin) {
            this.sueLonOrigin = sueLonOrigin;
            return this;
        }

        /**
         * Serial UDB Extra MP Origin Altitude Above Sea Level 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true
        )
        public final Builder sueAltOrigin(int sueAltOrigin) {
            this.sueAltOrigin = sueAltOrigin;
            return this;
        }

        /**
         * Serial UDB Extra GPS Week Number 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2,
                signed = true
        )
        public final Builder sueWeekNo(int sueWeekNo) {
            this.sueWeekNo = sueWeekNo;
            return this;
        }

        public final SerialUdbExtraF13 build() {
            return new SerialUdbExtraF13(sueLatOrigin, sueLonOrigin, sueAltOrigin, sueWeekNo);
        }
    }
}
