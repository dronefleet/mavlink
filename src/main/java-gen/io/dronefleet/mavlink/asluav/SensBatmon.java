package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.math.BigInteger;

/**
 * Battery pack monitoring data for Li-Ion batteries 
 */
@MavlinkMessageInfo(
        id = 209,
        crc = 155
)
public final class SensBatmon {
    private final BigInteger batmonTimestamp;

    private final float temperature;

    private final int voltage;

    private final int current;

    private final int soc;

    private final int batterystatus;

    private final int serialnumber;

    private final long safetystatus;

    private final long operationstatus;

    private final int cellvoltage1;

    private final int cellvoltage2;

    private final int cellvoltage3;

    private final int cellvoltage4;

    private final int cellvoltage5;

    private final int cellvoltage6;

    private SensBatmon(BigInteger batmonTimestamp, float temperature, int voltage, int current,
            int soc, int batterystatus, int serialnumber, long safetystatus, long operationstatus,
            int cellvoltage1, int cellvoltage2, int cellvoltage3, int cellvoltage4,
            int cellvoltage5, int cellvoltage6) {
        this.batmonTimestamp = batmonTimestamp;
        this.temperature = temperature;
        this.voltage = voltage;
        this.current = current;
        this.soc = soc;
        this.batterystatus = batterystatus;
        this.serialnumber = serialnumber;
        this.safetystatus = safetystatus;
        this.operationstatus = operationstatus;
        this.cellvoltage1 = cellvoltage1;
        this.cellvoltage2 = cellvoltage2;
        this.cellvoltage3 = cellvoltage3;
        this.cellvoltage4 = cellvoltage4;
        this.cellvoltage5 = cellvoltage5;
        this.cellvoltage6 = cellvoltage6;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Time since system start 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger batmonTimestamp() {
        return this.batmonTimestamp;
    }

    /**
     * Battery pack temperature 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float temperature() {
        return this.temperature;
    }

    /**
     * Battery pack voltage 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int voltage() {
        return this.voltage;
    }

    /**
     * Battery pack current 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true
    )
    public final int current() {
        return this.current;
    }

    /**
     * Battery pack state-of-charge 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int soc() {
        return this.soc;
    }

    /**
     * Battery monitor status report bits in Hex 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2
    )
    public final int batterystatus() {
        return this.batterystatus;
    }

    /**
     * Battery monitor serial number in Hex 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2
    )
    public final int serialnumber() {
        return this.serialnumber;
    }

    /**
     * Battery monitor safetystatus report bits in Hex 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final long safetystatus() {
        return this.safetystatus;
    }

    /**
     * Battery monitor operation status report bits in Hex 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final long operationstatus() {
        return this.operationstatus;
    }

    /**
     * Battery pack cell 1 voltage 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2
    )
    public final int cellvoltage1() {
        return this.cellvoltage1;
    }

    /**
     * Battery pack cell 2 voltage 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 2
    )
    public final int cellvoltage2() {
        return this.cellvoltage2;
    }

    /**
     * Battery pack cell 3 voltage 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 2
    )
    public final int cellvoltage3() {
        return this.cellvoltage3;
    }

    /**
     * Battery pack cell 4 voltage 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 2
    )
    public final int cellvoltage4() {
        return this.cellvoltage4;
    }

    /**
     * Battery pack cell 5 voltage 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 2
    )
    public final int cellvoltage5() {
        return this.cellvoltage5;
    }

    /**
     * Battery pack cell 6 voltage 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 2
    )
    public final int cellvoltage6() {
        return this.cellvoltage6;
    }

    public static final class Builder {
        private BigInteger batmonTimestamp;

        private float temperature;

        private int voltage;

        private int current;

        private int soc;

        private int batterystatus;

        private int serialnumber;

        private long safetystatus;

        private long operationstatus;

        private int cellvoltage1;

        private int cellvoltage2;

        private int cellvoltage3;

        private int cellvoltage4;

        private int cellvoltage5;

        private int cellvoltage6;

        /**
         * Time since system start 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8
        )
        public final Builder batmonTimestamp(BigInteger batmonTimestamp) {
            this.batmonTimestamp = batmonTimestamp;
            return this;
        }

        /**
         * Battery pack temperature 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder temperature(float temperature) {
            this.temperature = temperature;
            return this;
        }

        /**
         * Battery pack voltage 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2
        )
        public final Builder voltage(int voltage) {
            this.voltage = voltage;
            return this;
        }

        /**
         * Battery pack current 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true
        )
        public final Builder current(int current) {
            this.current = current;
            return this;
        }

        /**
         * Battery pack state-of-charge 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder soc(int soc) {
            this.soc = soc;
            return this;
        }

        /**
         * Battery monitor status report bits in Hex 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2
        )
        public final Builder batterystatus(int batterystatus) {
            this.batterystatus = batterystatus;
            return this;
        }

        /**
         * Battery monitor serial number in Hex 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2
        )
        public final Builder serialnumber(int serialnumber) {
            this.serialnumber = serialnumber;
            return this;
        }

        /**
         * Battery monitor safetystatus report bits in Hex 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder safetystatus(long safetystatus) {
            this.safetystatus = safetystatus;
            return this;
        }

        /**
         * Battery monitor operation status report bits in Hex 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4
        )
        public final Builder operationstatus(long operationstatus) {
            this.operationstatus = operationstatus;
            return this;
        }

        /**
         * Battery pack cell 1 voltage 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 2
        )
        public final Builder cellvoltage1(int cellvoltage1) {
            this.cellvoltage1 = cellvoltage1;
            return this;
        }

        /**
         * Battery pack cell 2 voltage 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 2
        )
        public final Builder cellvoltage2(int cellvoltage2) {
            this.cellvoltage2 = cellvoltage2;
            return this;
        }

        /**
         * Battery pack cell 3 voltage 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 2
        )
        public final Builder cellvoltage3(int cellvoltage3) {
            this.cellvoltage3 = cellvoltage3;
            return this;
        }

        /**
         * Battery pack cell 4 voltage 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 2
        )
        public final Builder cellvoltage4(int cellvoltage4) {
            this.cellvoltage4 = cellvoltage4;
            return this;
        }

        /**
         * Battery pack cell 5 voltage 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 2
        )
        public final Builder cellvoltage5(int cellvoltage5) {
            this.cellvoltage5 = cellvoltage5;
            return this;
        }

        /**
         * Battery pack cell 6 voltage 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 2
        )
        public final Builder cellvoltage6(int cellvoltage6) {
            this.cellvoltage6 = cellvoltage6;
            return this;
        }

        public final SensBatmon build() {
            return new SensBatmon(batmonTimestamp, temperature, voltage, current, soc, batterystatus, serialnumber, safetystatus, operationstatus, cellvoltage1, cellvoltage2, cellvoltage3, cellvoltage4, cellvoltage5, cellvoltage6);
        }
    }
}
