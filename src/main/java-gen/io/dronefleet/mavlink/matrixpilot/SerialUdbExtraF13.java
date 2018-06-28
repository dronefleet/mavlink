package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F13: format 
 */
@MavlinkMessageInfo(
        id = 177,
        crc = 249
)
public final class SerialUdbExtraF13 {
    private final int sueWeekNo;

    private final int sueLatOrigin;

    private final int sueLonOrigin;

    private final int sueAltOrigin;

    private SerialUdbExtraF13(int sueWeekNo, int sueLatOrigin, int sueLonOrigin, int sueAltOrigin) {
        this.sueWeekNo = sueWeekNo;
        this.sueLatOrigin = sueLatOrigin;
        this.sueLonOrigin = sueLonOrigin;
        this.sueAltOrigin = sueAltOrigin;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
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
        return this.sueWeekNo;
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
        return this.sueLatOrigin;
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
        return this.sueLonOrigin;
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
        return this.sueAltOrigin;
    }

    public static final class Builder {
        private int sueWeekNo;

        private int sueLatOrigin;

        private int sueLonOrigin;

        private int sueAltOrigin;

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

        public final SerialUdbExtraF13 build() {
            return new SerialUdbExtraF13(sueWeekNo, sueLatOrigin, sueLonOrigin, sueAltOrigin);
        }
    }
}
