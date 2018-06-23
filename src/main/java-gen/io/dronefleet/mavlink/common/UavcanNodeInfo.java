package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * General information describing a particular UAVCAN node. Please refer to the definition of 
 * the UAVCAN service "uavcan.protocol.GetNodeInfo" for the background information. This 
 * message should be emitted by the system whenever a new node appears online, or an existing node 
 * reboots. Additionally, it can be emitted upon request from the other end of the MAVLink channel 
 * (see MAV_CMD_UAVCAN_GET_NODE_INFO). It is also not prohibited to emit this message 
 * unconditionally at a low frequency. The UAVCAN specification is available at 
 * http://uavcan.org. 
 */
@MavlinkMessageInfo(
        id = 311,
        crc = 95
)
public final class UavcanNodeInfo {
    /**
     * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     */
    private final BigInteger timeUsec;

    /**
     * The number of seconds since the start-up of the node. 
     */
    private final long uptimeSec;

    /**
     * Version control system (VCS) revision identifier (e.g. git short commit hash). Zero if 
     * unknown. 
     */
    private final long swVcsCommit;

    /**
     * Node name string. For example, "sapog.px4.io". 
     */
    private final String name;

    /**
     * Hardware major version number. 
     */
    private final int hwVersionMajor;

    /**
     * Hardware minor version number. 
     */
    private final int hwVersionMinor;

    /**
     * Hardware unique 128-bit ID. 
     */
    private final byte[] hwUniqueId;

    /**
     * Software major version number. 
     */
    private final int swVersionMajor;

    /**
     * Software minor version number. 
     */
    private final int swVersionMinor;

    private UavcanNodeInfo(BigInteger timeUsec, long uptimeSec, long swVcsCommit, String name,
            int hwVersionMajor, int hwVersionMinor, byte[] hwUniqueId, int swVersionMajor,
            int swVersionMinor) {
        this.timeUsec = timeUsec;
        this.uptimeSec = uptimeSec;
        this.swVcsCommit = swVcsCommit;
        this.name = name;
        this.hwVersionMajor = hwVersionMajor;
        this.hwVersionMinor = hwVersionMinor;
        this.hwUniqueId = hwUniqueId;
        this.swVersionMajor = swVersionMajor;
        this.swVersionMinor = swVersionMinor;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "UavcanNodeInfo{timeUsec=" + timeUsec
                 + ", uptimeSec=" + uptimeSec
                 + ", name=" + name
                 + ", hwVersionMajor=" + hwVersionMajor
                 + ", hwVersionMinor=" + hwVersionMinor
                 + ", hwUniqueId=" + hwUniqueId
                 + ", swVersionMajor=" + swVersionMajor
                 + ", swVersionMinor=" + swVersionMinor
                 + ", swVcsCommit=" + swVcsCommit + "}";
    }

    /**
     * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return timeUsec;
    }

    /**
     * The number of seconds since the start-up of the node. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final long uptimeSec() {
        return uptimeSec;
    }

    /**
     * Version control system (VCS) revision identifier (e.g. git short commit hash). Zero if 
     * unknown. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final long swVcsCommit() {
        return swVcsCommit;
    }

    /**
     * Node name string. For example, "sapog.px4.io". 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 80
    )
    public final String name() {
        return name;
    }

    /**
     * Hardware major version number. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int hwVersionMajor() {
        return hwVersionMajor;
    }

    /**
     * Hardware minor version number. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int hwVersionMinor() {
        return hwVersionMinor;
    }

    /**
     * Hardware unique 128-bit ID. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            arraySize = 16
    )
    public final byte[] hwUniqueId() {
        return hwUniqueId;
    }

    /**
     * Software major version number. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1
    )
    public final int swVersionMajor() {
        return swVersionMajor;
    }

    /**
     * Software minor version number. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1
    )
    public final int swVersionMinor() {
        return swVersionMinor;
    }

    public static class Builder {
        private BigInteger timeUsec;

        private long uptimeSec;

        private long swVcsCommit;

        private String name;

        private int hwVersionMajor;

        private int hwVersionMinor;

        private byte[] hwUniqueId;

        private int swVersionMajor;

        private int swVersionMinor;

        private Builder() {
        }

        /**
         * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * The number of seconds since the start-up of the node. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder uptimeSec(long uptimeSec) {
            this.uptimeSec = uptimeSec;
            return this;
        }

        /**
         * Version control system (VCS) revision identifier (e.g. git short commit hash). Zero if 
         * unknown. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4
        )
        public final Builder swVcsCommit(long swVcsCommit) {
            this.swVcsCommit = swVcsCommit;
            return this;
        }

        /**
         * Node name string. For example, "sapog.px4.io". 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 80
        )
        public final Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Hardware major version number. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder hwVersionMajor(int hwVersionMajor) {
            this.hwVersionMajor = hwVersionMajor;
            return this;
        }

        /**
         * Hardware minor version number. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder hwVersionMinor(int hwVersionMinor) {
            this.hwVersionMinor = hwVersionMinor;
            return this;
        }

        /**
         * Hardware unique 128-bit ID. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                arraySize = 16
        )
        public final Builder hwUniqueId(byte[] hwUniqueId) {
            this.hwUniqueId = hwUniqueId;
            return this;
        }

        /**
         * Software major version number. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1
        )
        public final Builder swVersionMajor(int swVersionMajor) {
            this.swVersionMajor = swVersionMajor;
            return this;
        }

        /**
         * Software minor version number. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1
        )
        public final Builder swVersionMinor(int swVersionMinor) {
            this.swVersionMinor = swVersionMinor;
            return this;
        }

        public final UavcanNodeInfo build() {
            return new UavcanNodeInfo(timeUsec, uptimeSec, swVcsCommit, name, hwVersionMajor, hwVersionMinor, hwUniqueId, swVersionMajor, swVersionMinor);
        }
    }
}
