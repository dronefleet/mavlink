package io.dronefleet.mavlink.autoquad;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;

/**
 * Sends ESC32 telemetry data for up to 4 motors. Multiple messages may be sent in sequence when 
 * system has &gt; 4 motors. Data is described as follows: // unsigned int state : 3; // unsigned int vin 
 * : 12; // x 100 // unsigned int amps : 14; // x 100 // unsigned int rpm : 15; // unsigned int duty : 8; // x 
 * (255/100) // - Data Version 2 - // unsigned int errors : 9; // Bad detects error count // - Data 
 * Version 3 - // unsigned int temp : 9; // (Deg C + 32) * 4 // unsigned int errCode : 3; 
 */
@MavlinkMessageInfo(
        id = 152,
        crc = 115,
        description = "Sends ESC32 telemetry data for up to 4 motors. Multiple messages may be sent in sequence when system has > 4 motors. Data is described as follows: \n"
                        + "\t\t\t\t// unsigned int state :   3;\n"
                        + "\t\t\t    // unsigned int vin :\t  12;  // x 100\n"
                        + "\t\t\t    // unsigned int amps :\t  14;  // x 100\n"
                        + "\t\t\t    // unsigned int rpm :\t  15;\n"
                        + "\t\t\t    // unsigned int duty :\t  8;   // x (255/100)\n"
                        + "\t\t\t    // - Data Version 2 -\n"
                        + "\t\t\t    //     unsigned int errors :    9;   // Bad detects error count\n"
                        + "\t\t\t    // - Data Version 3 -\n"
                        + "\t\t\t    //     unsigned int temp   :    9;   // (Deg C + 32) * 4\n"
                        + "\t\t\t    // unsigned int errCode : 3;"
)
public final class AqEscTelemetry {
    private final long timeBootMs;

    private final int seq;

    private final int numMotors;

    private final int numInSeq;

    private final byte[] escid;

    private final List<Integer> statusAge;

    private final byte[] dataVersion;

    private final List<Long> data0;

    private final List<Long> data1;

    private AqEscTelemetry(long timeBootMs, int seq, int numMotors, int numInSeq, byte[] escid,
            List<Integer> statusAge, byte[] dataVersion, List<Long> data0, List<Long> data1) {
        this.timeBootMs = timeBootMs;
        this.seq = seq;
        this.numMotors = numMotors;
        this.numInSeq = numInSeq;
        this.escid = escid;
        this.statusAge = statusAge;
        this.dataVersion = dataVersion;
        this.data0 = data0;
        this.data1 = data1;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp of the component clock since boot time in ms. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Timestamp of the component clock since boot time in ms."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Sequence number of message (first set of 4 motors is #1, next 4 is #2, etc). 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Sequence number of message (first set of 4 motors is #1, next 4 is #2, etc)."
    )
    public final int seq() {
        return this.seq;
    }

    /**
     * Total number of active ESCs/motors on the system. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Total number of active ESCs/motors on the system."
    )
    public final int numMotors() {
        return this.numMotors;
    }

    /**
     * Number of active ESCs in this sequence (1 through this many array members will be populated with 
     * data) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "Number of active ESCs in this sequence (1 through this many array members will be populated with data)"
    )
    public final int numInSeq() {
        return this.numInSeq;
    }

    /**
     * ESC/Motor ID 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            arraySize = 4,
            description = "ESC/Motor ID"
    )
    public final byte[] escid() {
        return this.escid;
    }

    /**
     * Age of each ESC telemetry reading in ms compared to boot time. A value of 0xFFFF means timeout/no 
     * data. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            arraySize = 4,
            description = "Age of each ESC telemetry reading in ms compared to boot time. A value of 0xFFFF means timeout/no data."
    )
    public final List<Integer> statusAge() {
        return this.statusAge;
    }

    /**
     * Version of data structure (determines contents). 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            arraySize = 4,
            description = "Version of data structure (determines contents)."
    )
    public final byte[] dataVersion() {
        return this.dataVersion;
    }

    /**
     * Data bits 1-32 for each ESC. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            arraySize = 4,
            description = "Data bits 1-32 for each ESC."
    )
    public final List<Long> data0() {
        return this.data0;
    }

    /**
     * Data bits 33-64 for each ESC. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            arraySize = 4,
            description = "Data bits 33-64 for each ESC."
    )
    public final List<Long> data1() {
        return this.data1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        AqEscTelemetry other = (AqEscTelemetry)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(seq, other.seq)) return false;
        if (!Objects.deepEquals(numMotors, other.numMotors)) return false;
        if (!Objects.deepEquals(numInSeq, other.numInSeq)) return false;
        if (!Objects.deepEquals(escid, other.escid)) return false;
        if (!Objects.deepEquals(statusAge, other.statusAge)) return false;
        if (!Objects.deepEquals(dataVersion, other.dataVersion)) return false;
        if (!Objects.deepEquals(data0, other.data0)) return false;
        if (!Objects.deepEquals(data1, other.data1)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(seq);
        result = 31 * result + Objects.hashCode(numMotors);
        result = 31 * result + Objects.hashCode(numInSeq);
        result = 31 * result + Objects.hashCode(escid);
        result = 31 * result + Objects.hashCode(statusAge);
        result = 31 * result + Objects.hashCode(dataVersion);
        result = 31 * result + Objects.hashCode(data0);
        result = 31 * result + Objects.hashCode(data1);
        return result;
    }

    @Override
    public String toString() {
        return "AqEscTelemetry{timeBootMs=" + timeBootMs
                 + ", seq=" + seq
                 + ", numMotors=" + numMotors
                 + ", numInSeq=" + numInSeq
                 + ", escid=" + escid
                 + ", statusAge=" + statusAge
                 + ", dataVersion=" + dataVersion
                 + ", data0=" + data0
                 + ", data1=" + data1 + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private int seq;

        private int numMotors;

        private int numInSeq;

        private byte[] escid;

        private List<Integer> statusAge;

        private byte[] dataVersion;

        private List<Long> data0;

        private List<Long> data1;

        /**
         * Timestamp of the component clock since boot time in ms. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Timestamp of the component clock since boot time in ms."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Sequence number of message (first set of 4 motors is #1, next 4 is #2, etc). 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Sequence number of message (first set of 4 motors is #1, next 4 is #2, etc)."
        )
        public final Builder seq(int seq) {
            this.seq = seq;
            return this;
        }

        /**
         * Total number of active ESCs/motors on the system. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Total number of active ESCs/motors on the system."
        )
        public final Builder numMotors(int numMotors) {
            this.numMotors = numMotors;
            return this;
        }

        /**
         * Number of active ESCs in this sequence (1 through this many array members will be populated with 
         * data) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "Number of active ESCs in this sequence (1 through this many array members will be populated with data)"
        )
        public final Builder numInSeq(int numInSeq) {
            this.numInSeq = numInSeq;
            return this;
        }

        /**
         * ESC/Motor ID 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                arraySize = 4,
                description = "ESC/Motor ID"
        )
        public final Builder escid(byte[] escid) {
            this.escid = escid;
            return this;
        }

        /**
         * Age of each ESC telemetry reading in ms compared to boot time. A value of 0xFFFF means timeout/no 
         * data. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                arraySize = 4,
                description = "Age of each ESC telemetry reading in ms compared to boot time. A value of 0xFFFF means timeout/no data."
        )
        public final Builder statusAge(List<Integer> statusAge) {
            this.statusAge = statusAge;
            return this;
        }

        /**
         * Version of data structure (determines contents). 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                arraySize = 4,
                description = "Version of data structure (determines contents)."
        )
        public final Builder dataVersion(byte[] dataVersion) {
            this.dataVersion = dataVersion;
            return this;
        }

        /**
         * Data bits 1-32 for each ESC. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                arraySize = 4,
                description = "Data bits 1-32 for each ESC."
        )
        public final Builder data0(List<Long> data0) {
            this.data0 = data0;
            return this;
        }

        /**
         * Data bits 33-64 for each ESC. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                arraySize = 4,
                description = "Data bits 33-64 for each ESC."
        )
        public final Builder data1(List<Long> data1) {
            this.data1 = data1;
            return this;
        }

        public final AqEscTelemetry build() {
            return new AqEscTelemetry(timeBootMs, seq, numMotors, numInSeq, escid, statusAge, dataVersion, data0, data1);
        }
    }
}
