package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Status of key hardware 
 */
@MavlinkMessageInfo(
        id = 165,
        crc = 21
)
public final class Hwstatus {
    private final int vcc;

    private final int i2cerr;

    private Hwstatus(int vcc, int i2cerr) {
        this.vcc = vcc;
        this.i2cerr = i2cerr;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * board voltage (mV) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2
    )
    public final int vcc() {
        return this.vcc;
    }

    /**
     * I2C error count 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int i2cerr() {
        return this.i2cerr;
    }

    public static final class Builder {
        private int vcc;

        private int i2cerr;

        /**
         * board voltage (mV) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2
        )
        public final Builder vcc(int vcc) {
            this.vcc = vcc;
            return this;
        }

        /**
         * I2C error count 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder i2cerr(int i2cerr) {
            this.i2cerr = i2cerr;
            return this;
        }

        public final Hwstatus build() {
            return new Hwstatus(vcc, i2cerr);
        }
    }
}
