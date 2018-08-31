package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Battery pack monitoring data for Li-Ion batteries 
 */
@MavlinkMessageInfo(
        id = 209,
        crc = 155,
        description = "Battery pack monitoring data for Li-Ion batteries"
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
            unitSize = 8,
            description = "Time since system start"
    )
    public final BigInteger batmonTimestamp() {
        return this.batmonTimestamp;
    }

    /**
     * Battery pack temperature 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Battery pack temperature"
    )
    public final float temperature() {
        return this.temperature;
    }

    /**
     * Battery pack voltage 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "Battery pack voltage"
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
            signed = true,
            description = "Battery pack current"
    )
    public final int current() {
        return this.current;
    }

    /**
     * Battery pack state-of-charge 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "Battery pack state-of-charge"
    )
    public final int soc() {
        return this.soc;
    }

    /**
     * Battery monitor status report bits in Hex 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "Battery monitor status report bits in Hex"
    )
    public final int batterystatus() {
        return this.batterystatus;
    }

    /**
     * Battery monitor serial number in Hex 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            description = "Battery monitor serial number in Hex"
    )
    public final int serialnumber() {
        return this.serialnumber;
    }

    /**
     * Battery monitor safetystatus report bits in Hex 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Battery monitor safetystatus report bits in Hex"
    )
    public final long safetystatus() {
        return this.safetystatus;
    }

    /**
     * Battery monitor operation status report bits in Hex 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Battery monitor operation status report bits in Hex"
    )
    public final long operationstatus() {
        return this.operationstatus;
    }

    /**
     * Battery pack cell 1 voltage 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2,
            description = "Battery pack cell 1 voltage"
    )
    public final int cellvoltage1() {
        return this.cellvoltage1;
    }

    /**
     * Battery pack cell 2 voltage 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 2,
            description = "Battery pack cell 2 voltage"
    )
    public final int cellvoltage2() {
        return this.cellvoltage2;
    }

    /**
     * Battery pack cell 3 voltage 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 2,
            description = "Battery pack cell 3 voltage"
    )
    public final int cellvoltage3() {
        return this.cellvoltage3;
    }

    /**
     * Battery pack cell 4 voltage 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 2,
            description = "Battery pack cell 4 voltage"
    )
    public final int cellvoltage4() {
        return this.cellvoltage4;
    }

    /**
     * Battery pack cell 5 voltage 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 2,
            description = "Battery pack cell 5 voltage"
    )
    public final int cellvoltage5() {
        return this.cellvoltage5;
    }

    /**
     * Battery pack cell 6 voltage 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 2,
            description = "Battery pack cell 6 voltage"
    )
    public final int cellvoltage6() {
        return this.cellvoltage6;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SensBatmon other = (SensBatmon)o;
        if (!Objects.deepEquals(batmonTimestamp, other.batmonTimestamp)) return false;
        if (!Objects.deepEquals(temperature, other.temperature)) return false;
        if (!Objects.deepEquals(voltage, other.voltage)) return false;
        if (!Objects.deepEquals(current, other.current)) return false;
        if (!Objects.deepEquals(soc, other.soc)) return false;
        if (!Objects.deepEquals(batterystatus, other.batterystatus)) return false;
        if (!Objects.deepEquals(serialnumber, other.serialnumber)) return false;
        if (!Objects.deepEquals(safetystatus, other.safetystatus)) return false;
        if (!Objects.deepEquals(operationstatus, other.operationstatus)) return false;
        if (!Objects.deepEquals(cellvoltage1, other.cellvoltage1)) return false;
        if (!Objects.deepEquals(cellvoltage2, other.cellvoltage2)) return false;
        if (!Objects.deepEquals(cellvoltage3, other.cellvoltage3)) return false;
        if (!Objects.deepEquals(cellvoltage4, other.cellvoltage4)) return false;
        if (!Objects.deepEquals(cellvoltage5, other.cellvoltage5)) return false;
        if (!Objects.deepEquals(cellvoltage6, other.cellvoltage6)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(batmonTimestamp);
        result = 31 * result + Objects.hashCode(temperature);
        result = 31 * result + Objects.hashCode(voltage);
        result = 31 * result + Objects.hashCode(current);
        result = 31 * result + Objects.hashCode(soc);
        result = 31 * result + Objects.hashCode(batterystatus);
        result = 31 * result + Objects.hashCode(serialnumber);
        result = 31 * result + Objects.hashCode(safetystatus);
        result = 31 * result + Objects.hashCode(operationstatus);
        result = 31 * result + Objects.hashCode(cellvoltage1);
        result = 31 * result + Objects.hashCode(cellvoltage2);
        result = 31 * result + Objects.hashCode(cellvoltage3);
        result = 31 * result + Objects.hashCode(cellvoltage4);
        result = 31 * result + Objects.hashCode(cellvoltage5);
        result = 31 * result + Objects.hashCode(cellvoltage6);
        return result;
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
                unitSize = 8,
                description = "Time since system start"
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
                unitSize = 4,
                description = "Battery pack temperature"
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
                unitSize = 2,
                description = "Battery pack voltage"
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
                signed = true,
                description = "Battery pack current"
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
                unitSize = 1,
                description = "Battery pack state-of-charge"
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
                unitSize = 2,
                description = "Battery monitor status report bits in Hex"
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
                unitSize = 2,
                description = "Battery monitor serial number in Hex"
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
                unitSize = 4,
                description = "Battery monitor safetystatus report bits in Hex"
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
                unitSize = 4,
                description = "Battery monitor operation status report bits in Hex"
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
                unitSize = 2,
                description = "Battery pack cell 1 voltage"
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
                unitSize = 2,
                description = "Battery pack cell 2 voltage"
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
                unitSize = 2,
                description = "Battery pack cell 3 voltage"
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
                unitSize = 2,
                description = "Battery pack cell 4 voltage"
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
                unitSize = 2,
                description = "Battery pack cell 5 voltage"
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
                unitSize = 2,
                description = "Battery pack cell 6 voltage"
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
