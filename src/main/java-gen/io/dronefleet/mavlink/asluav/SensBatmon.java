package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * Battery pack monitoring data for Li-Ion batteries 
 */
@MavlinkMessageInfo(
        id = 209,
        crc = 155
)
public final class SensBatmon {
    /**
     * Time since system start 
     */
    private final BigInteger batmonTimestamp;

    /**
     * Battery pack temperature 
     */
    private final float temperature;

    /**
     * Battery monitor safetystatus report bits in Hex 
     */
    private final long safetystatus;

    /**
     * Battery monitor operation status report bits in Hex 
     */
    private final long operationstatus;

    /**
     * Battery pack voltage 
     */
    private final int voltage;

    /**
     * Battery pack current 
     */
    private final int current;

    /**
     * Battery monitor status report bits in Hex 
     */
    private final int batterystatus;

    /**
     * Battery monitor serial number in Hex 
     */
    private final int serialnumber;

    /**
     * Battery pack cell 1 voltage 
     */
    private final int cellvoltage1;

    /**
     * Battery pack cell 2 voltage 
     */
    private final int cellvoltage2;

    /**
     * Battery pack cell 3 voltage 
     */
    private final int cellvoltage3;

    /**
     * Battery pack cell 4 voltage 
     */
    private final int cellvoltage4;

    /**
     * Battery pack cell 5 voltage 
     */
    private final int cellvoltage5;

    /**
     * Battery pack cell 6 voltage 
     */
    private final int cellvoltage6;

    /**
     * Battery pack state-of-charge 
     */
    private final int soc;

    private SensBatmon(BigInteger batmonTimestamp, float temperature, long safetystatus,
            long operationstatus, int voltage, int current, int batterystatus, int serialnumber,
            int cellvoltage1, int cellvoltage2, int cellvoltage3, int cellvoltage4,
            int cellvoltage5, int cellvoltage6, int soc) {
        this.batmonTimestamp = batmonTimestamp;
        this.temperature = temperature;
        this.safetystatus = safetystatus;
        this.operationstatus = operationstatus;
        this.voltage = voltage;
        this.current = current;
        this.batterystatus = batterystatus;
        this.serialnumber = serialnumber;
        this.cellvoltage1 = cellvoltage1;
        this.cellvoltage2 = cellvoltage2;
        this.cellvoltage3 = cellvoltage3;
        this.cellvoltage4 = cellvoltage4;
        this.cellvoltage5 = cellvoltage5;
        this.cellvoltage6 = cellvoltage6;
        this.soc = soc;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "SensBatmon{batmonTimestamp=" + batmonTimestamp
                 + ", temperature=" + temperature
                 + ", voltage=" + voltage
                 + ", current=" + current
                 + ", soc=" + soc
                 + ", batterystatus=" + batterystatus
                 + ", serialnumber=" + serialnumber
                 + ", safetystatus=" + safetystatus
                 + ", operationstatus=" + operationstatus
                 + ", cellvoltage1=" + cellvoltage1
                 + ", cellvoltage2=" + cellvoltage2
                 + ", cellvoltage3=" + cellvoltage3
                 + ", cellvoltage4=" + cellvoltage4
                 + ", cellvoltage5=" + cellvoltage5
                 + ", cellvoltage6=" + cellvoltage6 + "}";
    }

    /**
     * Time since system start 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger batmonTimestamp() {
        return batmonTimestamp;
    }

    /**
     * Battery pack temperature 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float temperature() {
        return temperature;
    }

    /**
     * Battery monitor safetystatus report bits in Hex 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final long safetystatus() {
        return safetystatus;
    }

    /**
     * Battery monitor operation status report bits in Hex 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final long operationstatus() {
        return operationstatus;
    }

    /**
     * Battery pack voltage 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int voltage() {
        return voltage;
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
        return current;
    }

    /**
     * Battery monitor status report bits in Hex 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2
    )
    public final int batterystatus() {
        return batterystatus;
    }

    /**
     * Battery monitor serial number in Hex 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2
    )
    public final int serialnumber() {
        return serialnumber;
    }

    /**
     * Battery pack cell 1 voltage 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2
    )
    public final int cellvoltage1() {
        return cellvoltage1;
    }

    /**
     * Battery pack cell 2 voltage 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 2
    )
    public final int cellvoltage2() {
        return cellvoltage2;
    }

    /**
     * Battery pack cell 3 voltage 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 2
    )
    public final int cellvoltage3() {
        return cellvoltage3;
    }

    /**
     * Battery pack cell 4 voltage 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 2
    )
    public final int cellvoltage4() {
        return cellvoltage4;
    }

    /**
     * Battery pack cell 5 voltage 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 2
    )
    public final int cellvoltage5() {
        return cellvoltage5;
    }

    /**
     * Battery pack cell 6 voltage 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 2
    )
    public final int cellvoltage6() {
        return cellvoltage6;
    }

    /**
     * Battery pack state-of-charge 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int soc() {
        return soc;
    }

    public static class Builder {
        private BigInteger batmonTimestamp;

        private float temperature;

        private long safetystatus;

        private long operationstatus;

        private int voltage;

        private int current;

        private int batterystatus;

        private int serialnumber;

        private int cellvoltage1;

        private int cellvoltage2;

        private int cellvoltage3;

        private int cellvoltage4;

        private int cellvoltage5;

        private int cellvoltage6;

        private int soc;

        private Builder() {
        }

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

        public final SensBatmon build() {
            return new SensBatmon(batmonTimestamp, temperature, safetystatus, operationstatus, voltage, current, batterystatus, serialnumber, cellvoltage1, cellvoltage2, cellvoltage3, cellvoltage4, cellvoltage5, cellvoltage6, soc);
        }
    }
}
