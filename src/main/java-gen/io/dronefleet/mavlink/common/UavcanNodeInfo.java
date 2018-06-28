package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
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
    private final BigInteger timeUsec;

    private final long uptimeSec;

    private final String name;

    private final int hwVersionMajor;

    private final int hwVersionMinor;

    private final byte[] hwUniqueId;

    private final int swVersionMajor;

    private final int swVersionMinor;

    private final long swVcsCommit;

    private UavcanNodeInfo(BigInteger timeUsec, long uptimeSec, String name, int hwVersionMajor,
            int hwVersionMinor, byte[] hwUniqueId, int swVersionMajor, int swVersionMinor,
            long swVcsCommit) {
        this.timeUsec = timeUsec;
        this.uptimeSec = uptimeSec;
        this.name = name;
        this.hwVersionMajor = hwVersionMajor;
        this.hwVersionMinor = hwVersionMinor;
        this.hwUniqueId = hwUniqueId;
        this.swVersionMajor = swVersionMajor;
        this.swVersionMinor = swVersionMinor;
        this.swVcsCommit = swVcsCommit;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * The number of seconds since the start-up of the node. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final long uptimeSec() {
        return this.uptimeSec;
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
        return this.name;
    }

    /**
     * Hardware major version number. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int hwVersionMajor() {
        return this.hwVersionMajor;
    }

    /**
     * Hardware minor version number. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int hwVersionMinor() {
        return this.hwVersionMinor;
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
        return this.hwUniqueId;
    }

    /**
     * Software major version number. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1
    )
    public final int swVersionMajor() {
        return this.swVersionMajor;
    }

    /**
     * Software minor version number. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1
    )
    public final int swVersionMinor() {
        return this.swVersionMinor;
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
        return this.swVcsCommit;
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private long uptimeSec;

        private String name;

        private int hwVersionMajor;

        private int hwVersionMinor;

        private byte[] hwUniqueId;

        private int swVersionMajor;

        private int swVersionMinor;

        private long swVcsCommit;

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

        public final UavcanNodeInfo build() {
            return new UavcanNodeInfo(timeUsec, uptimeSec, name, hwVersionMajor, hwVersionMinor, hwUniqueId, swVersionMajor, swVersionMinor, swVcsCommit);
        }
    }
}
