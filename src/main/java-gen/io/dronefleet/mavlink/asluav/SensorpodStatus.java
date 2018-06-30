package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Monitoring of sensorpod status 
 */
@MavlinkMessageInfo(
        id = 211,
        crc = 54
)
public final class SensorpodStatus {
    private final BigInteger timestamp;

    private final int visensorRate1;

    private final int visensorRate2;

    private final int visensorRate3;

    private final int visensorRate4;

    private final int recordingNodesCount;

    private final int cpuTemp;

    private final int freeSpace;

    private SensorpodStatus(BigInteger timestamp, int visensorRate1, int visensorRate2,
            int visensorRate3, int visensorRate4, int recordingNodesCount, int cpuTemp,
            int freeSpace) {
        this.timestamp = timestamp;
        this.visensorRate1 = visensorRate1;
        this.visensorRate2 = visensorRate2;
        this.visensorRate3 = visensorRate3;
        this.visensorRate4 = visensorRate4;
        this.recordingNodesCount = recordingNodesCount;
        this.cpuTemp = cpuTemp;
        this.freeSpace = freeSpace;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp in linuxtime (since 1.1.1970) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timestamp() {
        return this.timestamp;
    }

    /**
     * Rate of ROS topic 1 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int visensorRate1() {
        return this.visensorRate1;
    }

    /**
     * Rate of ROS topic 2 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int visensorRate2() {
        return this.visensorRate2;
    }

    /**
     * Rate of ROS topic 3 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int visensorRate3() {
        return this.visensorRate3;
    }

    /**
     * Rate of ROS topic 4 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int visensorRate4() {
        return this.visensorRate4;
    }

    /**
     * Number of recording nodes 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1
    )
    public final int recordingNodesCount() {
        return this.recordingNodesCount;
    }

    /**
     * Temperature of sensorpod CPU in 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1
    )
    public final int cpuTemp() {
        return this.cpuTemp;
    }

    /**
     * Free space available in recordings directory in [Gb] * 1e2 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2
    )
    public final int freeSpace() {
        return this.freeSpace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SensorpodStatus other = (SensorpodStatus)o;
        if (!Objects.deepEquals(timestamp, other.timestamp)) return false;
        if (!Objects.deepEquals(visensorRate1, other.visensorRate1)) return false;
        if (!Objects.deepEquals(visensorRate2, other.visensorRate2)) return false;
        if (!Objects.deepEquals(visensorRate3, other.visensorRate3)) return false;
        if (!Objects.deepEquals(visensorRate4, other.visensorRate4)) return false;
        if (!Objects.deepEquals(recordingNodesCount, other.recordingNodesCount)) return false;
        if (!Objects.deepEquals(cpuTemp, other.cpuTemp)) return false;
        if (!Objects.deepEquals(freeSpace, other.freeSpace)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timestamp);
        result = 31 * result + Objects.hashCode(visensorRate1);
        result = 31 * result + Objects.hashCode(visensorRate2);
        result = 31 * result + Objects.hashCode(visensorRate3);
        result = 31 * result + Objects.hashCode(visensorRate4);
        result = 31 * result + Objects.hashCode(recordingNodesCount);
        result = 31 * result + Objects.hashCode(cpuTemp);
        result = 31 * result + Objects.hashCode(freeSpace);
        return result;
    }

    public static final class Builder {
        private BigInteger timestamp;

        private int visensorRate1;

        private int visensorRate2;

        private int visensorRate3;

        private int visensorRate4;

        private int recordingNodesCount;

        private int cpuTemp;

        private int freeSpace;

        /**
         * Timestamp in linuxtime (since 1.1.1970) 
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
         * Rate of ROS topic 1 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder visensorRate1(int visensorRate1) {
            this.visensorRate1 = visensorRate1;
            return this;
        }

        /**
         * Rate of ROS topic 2 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder visensorRate2(int visensorRate2) {
            this.visensorRate2 = visensorRate2;
            return this;
        }

        /**
         * Rate of ROS topic 3 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder visensorRate3(int visensorRate3) {
            this.visensorRate3 = visensorRate3;
            return this;
        }

        /**
         * Rate of ROS topic 4 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder visensorRate4(int visensorRate4) {
            this.visensorRate4 = visensorRate4;
            return this;
        }

        /**
         * Number of recording nodes 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1
        )
        public final Builder recordingNodesCount(int recordingNodesCount) {
            this.recordingNodesCount = recordingNodesCount;
            return this;
        }

        /**
         * Temperature of sensorpod CPU in 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1
        )
        public final Builder cpuTemp(int cpuTemp) {
            this.cpuTemp = cpuTemp;
            return this;
        }

        /**
         * Free space available in recordings directory in [Gb] * 1e2 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2
        )
        public final Builder freeSpace(int freeSpace) {
            this.freeSpace = freeSpace;
            return this;
        }

        public final SensorpodStatus build() {
            return new SensorpodStatus(timestamp, visensorRate1, visensorRate2, visensorRate3, visensorRate4, recordingNodesCount, cpuTemp, freeSpace);
        }
    }
}
