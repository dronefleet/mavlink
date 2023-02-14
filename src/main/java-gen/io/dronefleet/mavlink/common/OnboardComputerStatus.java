package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Deprecated;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * Hardware status sent by an onboard computer. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 390,
        crc = 156,
        description = "Hardware status sent by an onboard computer.",
        workInProgress = true
)
@Deprecated
public final class OnboardComputerStatus {
    private final BigInteger timeUsec;

    private final long uptime;

    private final int type;

    private final byte[] cpuCores;

    private final byte[] cpuCombined;

    private final byte[] gpuCores;

    private final byte[] gpuCombined;

    private final int temperatureBoard;

    private final List<Integer> temperatureCore;

    private final List<Integer> fanSpeed;

    private final long ramUsage;

    private final long ramTotal;

    private final List<Long> storageType;

    private final List<Long> storageUsage;

    private final List<Long> storageTotal;

    private final List<Long> linkType;

    private final List<Long> linkTxRate;

    private final List<Long> linkRxRate;

    private final List<Long> linkTxMax;

    private final List<Long> linkRxMax;

    private OnboardComputerStatus(BigInteger timeUsec, long uptime, int type, byte[] cpuCores,
            byte[] cpuCombined, byte[] gpuCores, byte[] gpuCombined, int temperatureBoard,
            List<Integer> temperatureCore, List<Integer> fanSpeed, long ramUsage, long ramTotal,
            List<Long> storageType, List<Long> storageUsage, List<Long> storageTotal,
            List<Long> linkType, List<Long> linkTxRate, List<Long> linkRxRate, List<Long> linkTxMax,
            List<Long> linkRxMax) {
        this.timeUsec = timeUsec;
        this.uptime = uptime;
        this.type = type;
        this.cpuCores = cpuCores;
        this.cpuCombined = cpuCombined;
        this.gpuCores = gpuCores;
        this.gpuCombined = gpuCombined;
        this.temperatureBoard = temperatureBoard;
        this.temperatureCore = temperatureCore;
        this.fanSpeed = fanSpeed;
        this.ramUsage = ramUsage;
        this.ramTotal = ramTotal;
        this.storageType = storageType;
        this.storageUsage = storageUsage;
        this.storageTotal = storageTotal;
        this.linkType = linkType;
        this.linkTxRate = linkTxRate;
        this.linkRxRate = linkRxRate;
        this.linkTxMax = linkTxMax;
        this.linkRxMax = linkRxMax;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
     * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 8,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Time since system boot. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Time since system boot."
    )
    public final long uptime() {
        return this.uptime;
    }

    /**
     * Type of the onboard computer: 0: Mission computer primary, 1: Mission computer backup 1, 2: 
     * Mission computer backup 2, 3: Compute node, 4-5: Compute spares, 6-9: Payload computers. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "Type of the onboard computer: 0: Mission computer primary, 1: Mission computer backup 1, 2: Mission computer backup 2, 3: Compute node, 4-5: Compute spares, 6-9: Payload computers."
    )
    public final int type() {
        return this.type;
    }

    /**
     * CPU usage on the component in percent (100 - idle). A value of UINT8_MAX implies the field is 
     * unused. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            arraySize = 8,
            description = "CPU usage on the component in percent (100 - idle). A value of UINT8_MAX implies the field is unused."
    )
    public final byte[] cpuCores() {
        return this.cpuCores;
    }

    /**
     * Combined CPU usage as the last 10 slices of 100 MS (a histogram). This allows to identify spikes 
     * in load that max out the system, but only for a short amount of time. A value of UINT8_MAX implies 
     * the field is unused. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            arraySize = 10,
            description = "Combined CPU usage as the last 10 slices of 100 MS (a histogram). This allows to identify spikes in load that max out the system, but only for a short amount of time. A value of UINT8_MAX implies the field is unused."
    )
    public final byte[] cpuCombined() {
        return this.cpuCombined;
    }

    /**
     * GPU usage on the component in percent (100 - idle). A value of UINT8_MAX implies the field is 
     * unused. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            arraySize = 4,
            description = "GPU usage on the component in percent (100 - idle). A value of UINT8_MAX implies the field is unused."
    )
    public final byte[] gpuCores() {
        return this.gpuCores;
    }

    /**
     * Combined GPU usage as the last 10 slices of 100 MS (a histogram). This allows to identify spikes 
     * in load that max out the system, but only for a short amount of time. A value of UINT8_MAX implies 
     * the field is unused. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            arraySize = 10,
            description = "Combined GPU usage as the last 10 slices of 100 MS (a histogram). This allows to identify spikes in load that max out the system, but only for a short amount of time. A value of UINT8_MAX implies the field is unused."
    )
    public final byte[] gpuCombined() {
        return this.gpuCombined;
    }

    /**
     * Temperature of the board. A value of INT8_MAX implies the field is unused. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1,
            signed = true,
            description = "Temperature of the board. A value of INT8_MAX implies the field is unused."
    )
    public final int temperatureBoard() {
        return this.temperatureBoard;
    }

    /**
     * Temperature of the CPU core. A value of INT8_MAX implies the field is unused. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1,
            arraySize = 8,
            signed = true,
            description = "Temperature of the CPU core. A value of INT8_MAX implies the field is unused."
    )
    public final List<Integer> temperatureCore() {
        return this.temperatureCore;
    }

    /**
     * Fan speeds. A value of INT16_MAX implies the field is unused. 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 2,
            arraySize = 4,
            signed = true,
            description = "Fan speeds. A value of INT16_MAX implies the field is unused."
    )
    public final List<Integer> fanSpeed() {
        return this.fanSpeed;
    }

    /**
     * Amount of used RAM on the component system. A value of UINT32_MAX implies the field is unused. 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            description = "Amount of used RAM on the component system. A value of UINT32_MAX implies the field is unused."
    )
    public final long ramUsage() {
        return this.ramUsage;
    }

    /**
     * Total amount of RAM on the component system. A value of UINT32_MAX implies the field is unused. 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            description = "Total amount of RAM on the component system. A value of UINT32_MAX implies the field is unused."
    )
    public final long ramTotal() {
        return this.ramTotal;
    }

    /**
     * Storage type: 0: HDD, 1: SSD, 2: EMMC, 3: SD card (non-removable), 4: SD card (removable). A 
     * value of UINT32_MAX implies the field is unused. 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4,
            arraySize = 4,
            description = "Storage type: 0: HDD, 1: SSD, 2: EMMC, 3: SD card (non-removable), 4: SD card (removable). A value of UINT32_MAX implies the field is unused."
    )
    public final List<Long> storageType() {
        return this.storageType;
    }

    /**
     * Amount of used storage space on the component system. A value of UINT32_MAX implies the field is 
     * unused. 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 4,
            arraySize = 4,
            description = "Amount of used storage space on the component system. A value of UINT32_MAX implies the field is unused."
    )
    public final List<Long> storageUsage() {
        return this.storageUsage;
    }

    /**
     * Total amount of storage space on the component system. A value of UINT32_MAX implies the field 
     * is unused. 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 4,
            arraySize = 4,
            description = "Total amount of storage space on the component system. A value of UINT32_MAX implies the field is unused."
    )
    public final List<Long> storageTotal() {
        return this.storageTotal;
    }

    /**
     * Link type: 0-9: UART, 10-19: Wired network, 20-29: Wifi, 30-39: Point-to-point proprietary, 
     * 40-49: Mesh proprietary 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 4,
            arraySize = 6,
            description = "Link type: 0-9: UART, 10-19: Wired network, 20-29: Wifi, 30-39: Point-to-point proprietary, 40-49: Mesh proprietary"
    )
    public final List<Long> linkType() {
        return this.linkType;
    }

    /**
     * Network traffic from the component system. A value of UINT32_MAX implies the field is unused. 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 4,
            arraySize = 6,
            description = "Network traffic from the component system. A value of UINT32_MAX implies the field is unused."
    )
    public final List<Long> linkTxRate() {
        return this.linkTxRate;
    }

    /**
     * Network traffic to the component system. A value of UINT32_MAX implies the field is unused. 
     */
    @MavlinkFieldInfo(
            position = 19,
            unitSize = 4,
            arraySize = 6,
            description = "Network traffic to the component system. A value of UINT32_MAX implies the field is unused."
    )
    public final List<Long> linkRxRate() {
        return this.linkRxRate;
    }

    /**
     * Network capacity from the component system. A value of UINT32_MAX implies the field is unused. 
     */
    @MavlinkFieldInfo(
            position = 20,
            unitSize = 4,
            arraySize = 6,
            description = "Network capacity from the component system. A value of UINT32_MAX implies the field is unused."
    )
    public final List<Long> linkTxMax() {
        return this.linkTxMax;
    }

    /**
     * Network capacity to the component system. A value of UINT32_MAX implies the field is unused. 
     */
    @MavlinkFieldInfo(
            position = 21,
            unitSize = 4,
            arraySize = 6,
            description = "Network capacity to the component system. A value of UINT32_MAX implies the field is unused."
    )
    public final List<Long> linkRxMax() {
        return this.linkRxMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        OnboardComputerStatus other = (OnboardComputerStatus)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(uptime, other.uptime)) return false;
        if (!Objects.deepEquals(type, other.type)) return false;
        if (!Objects.deepEquals(cpuCores, other.cpuCores)) return false;
        if (!Objects.deepEquals(cpuCombined, other.cpuCombined)) return false;
        if (!Objects.deepEquals(gpuCores, other.gpuCores)) return false;
        if (!Objects.deepEquals(gpuCombined, other.gpuCombined)) return false;
        if (!Objects.deepEquals(temperatureBoard, other.temperatureBoard)) return false;
        if (!Objects.deepEquals(temperatureCore, other.temperatureCore)) return false;
        if (!Objects.deepEquals(fanSpeed, other.fanSpeed)) return false;
        if (!Objects.deepEquals(ramUsage, other.ramUsage)) return false;
        if (!Objects.deepEquals(ramTotal, other.ramTotal)) return false;
        if (!Objects.deepEquals(storageType, other.storageType)) return false;
        if (!Objects.deepEquals(storageUsage, other.storageUsage)) return false;
        if (!Objects.deepEquals(storageTotal, other.storageTotal)) return false;
        if (!Objects.deepEquals(linkType, other.linkType)) return false;
        if (!Objects.deepEquals(linkTxRate, other.linkTxRate)) return false;
        if (!Objects.deepEquals(linkRxRate, other.linkRxRate)) return false;
        if (!Objects.deepEquals(linkTxMax, other.linkTxMax)) return false;
        if (!Objects.deepEquals(linkRxMax, other.linkRxMax)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(uptime);
        result = 31 * result + Objects.hashCode(type);
        result = 31 * result + Objects.hashCode(cpuCores);
        result = 31 * result + Objects.hashCode(cpuCombined);
        result = 31 * result + Objects.hashCode(gpuCores);
        result = 31 * result + Objects.hashCode(gpuCombined);
        result = 31 * result + Objects.hashCode(temperatureBoard);
        result = 31 * result + Objects.hashCode(temperatureCore);
        result = 31 * result + Objects.hashCode(fanSpeed);
        result = 31 * result + Objects.hashCode(ramUsage);
        result = 31 * result + Objects.hashCode(ramTotal);
        result = 31 * result + Objects.hashCode(storageType);
        result = 31 * result + Objects.hashCode(storageUsage);
        result = 31 * result + Objects.hashCode(storageTotal);
        result = 31 * result + Objects.hashCode(linkType);
        result = 31 * result + Objects.hashCode(linkTxRate);
        result = 31 * result + Objects.hashCode(linkRxRate);
        result = 31 * result + Objects.hashCode(linkTxMax);
        result = 31 * result + Objects.hashCode(linkRxMax);
        return result;
    }

    @Override
    public String toString() {
        return "OnboardComputerStatus{timeUsec=" + timeUsec
                 + ", uptime=" + uptime
                 + ", type=" + type
                 + ", cpuCores=" + cpuCores
                 + ", cpuCombined=" + cpuCombined
                 + ", gpuCores=" + gpuCores
                 + ", gpuCombined=" + gpuCombined
                 + ", temperatureBoard=" + temperatureBoard
                 + ", temperatureCore=" + temperatureCore
                 + ", fanSpeed=" + fanSpeed
                 + ", ramUsage=" + ramUsage
                 + ", ramTotal=" + ramTotal
                 + ", storageType=" + storageType
                 + ", storageUsage=" + storageUsage
                 + ", storageTotal=" + storageTotal
                 + ", linkType=" + linkType
                 + ", linkTxRate=" + linkTxRate
                 + ", linkRxRate=" + linkRxRate
                 + ", linkTxMax=" + linkTxMax
                 + ", linkRxMax=" + linkRxMax + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private long uptime;

        private int type;

        private byte[] cpuCores;

        private byte[] cpuCombined;

        private byte[] gpuCores;

        private byte[] gpuCombined;

        private int temperatureBoard;

        private List<Integer> temperatureCore;

        private List<Integer> fanSpeed;

        private long ramUsage;

        private long ramTotal;

        private List<Long> storageType;

        private List<Long> storageUsage;

        private List<Long> storageTotal;

        private List<Long> linkType;

        private List<Long> linkTxRate;

        private List<Long> linkRxRate;

        private List<Long> linkTxMax;

        private List<Long> linkRxMax;

        /**
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 8,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Time since system boot. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Time since system boot."
        )
        public final Builder uptime(long uptime) {
            this.uptime = uptime;
            return this;
        }

        /**
         * Type of the onboard computer: 0: Mission computer primary, 1: Mission computer backup 1, 2: 
         * Mission computer backup 2, 3: Compute node, 4-5: Compute spares, 6-9: Payload computers. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "Type of the onboard computer: 0: Mission computer primary, 1: Mission computer backup 1, 2: Mission computer backup 2, 3: Compute node, 4-5: Compute spares, 6-9: Payload computers."
        )
        public final Builder type(int type) {
            this.type = type;
            return this;
        }

        /**
         * CPU usage on the component in percent (100 - idle). A value of UINT8_MAX implies the field is 
         * unused. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                arraySize = 8,
                description = "CPU usage on the component in percent (100 - idle). A value of UINT8_MAX implies the field is unused."
        )
        public final Builder cpuCores(byte[] cpuCores) {
            this.cpuCores = cpuCores;
            return this;
        }

        /**
         * Combined CPU usage as the last 10 slices of 100 MS (a histogram). This allows to identify spikes 
         * in load that max out the system, but only for a short amount of time. A value of UINT8_MAX implies 
         * the field is unused. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                arraySize = 10,
                description = "Combined CPU usage as the last 10 slices of 100 MS (a histogram). This allows to identify spikes in load that max out the system, but only for a short amount of time. A value of UINT8_MAX implies the field is unused."
        )
        public final Builder cpuCombined(byte[] cpuCombined) {
            this.cpuCombined = cpuCombined;
            return this;
        }

        /**
         * GPU usage on the component in percent (100 - idle). A value of UINT8_MAX implies the field is 
         * unused. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                arraySize = 4,
                description = "GPU usage on the component in percent (100 - idle). A value of UINT8_MAX implies the field is unused."
        )
        public final Builder gpuCores(byte[] gpuCores) {
            this.gpuCores = gpuCores;
            return this;
        }

        /**
         * Combined GPU usage as the last 10 slices of 100 MS (a histogram). This allows to identify spikes 
         * in load that max out the system, but only for a short amount of time. A value of UINT8_MAX implies 
         * the field is unused. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                arraySize = 10,
                description = "Combined GPU usage as the last 10 slices of 100 MS (a histogram). This allows to identify spikes in load that max out the system, but only for a short amount of time. A value of UINT8_MAX implies the field is unused."
        )
        public final Builder gpuCombined(byte[] gpuCombined) {
            this.gpuCombined = gpuCombined;
            return this;
        }

        /**
         * Temperature of the board. A value of INT8_MAX implies the field is unused. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1,
                signed = true,
                description = "Temperature of the board. A value of INT8_MAX implies the field is unused."
        )
        public final Builder temperatureBoard(int temperatureBoard) {
            this.temperatureBoard = temperatureBoard;
            return this;
        }

        /**
         * Temperature of the CPU core. A value of INT8_MAX implies the field is unused. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1,
                arraySize = 8,
                signed = true,
                description = "Temperature of the CPU core. A value of INT8_MAX implies the field is unused."
        )
        public final Builder temperatureCore(List<Integer> temperatureCore) {
            this.temperatureCore = temperatureCore;
            return this;
        }

        /**
         * Fan speeds. A value of INT16_MAX implies the field is unused. 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 2,
                arraySize = 4,
                signed = true,
                description = "Fan speeds. A value of INT16_MAX implies the field is unused."
        )
        public final Builder fanSpeed(List<Integer> fanSpeed) {
            this.fanSpeed = fanSpeed;
            return this;
        }

        /**
         * Amount of used RAM on the component system. A value of UINT32_MAX implies the field is unused. 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                description = "Amount of used RAM on the component system. A value of UINT32_MAX implies the field is unused."
        )
        public final Builder ramUsage(long ramUsage) {
            this.ramUsage = ramUsage;
            return this;
        }

        /**
         * Total amount of RAM on the component system. A value of UINT32_MAX implies the field is unused. 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                description = "Total amount of RAM on the component system. A value of UINT32_MAX implies the field is unused."
        )
        public final Builder ramTotal(long ramTotal) {
            this.ramTotal = ramTotal;
            return this;
        }

        /**
         * Storage type: 0: HDD, 1: SSD, 2: EMMC, 3: SD card (non-removable), 4: SD card (removable). A 
         * value of UINT32_MAX implies the field is unused. 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 4,
                arraySize = 4,
                description = "Storage type: 0: HDD, 1: SSD, 2: EMMC, 3: SD card (non-removable), 4: SD card (removable). A value of UINT32_MAX implies the field is unused."
        )
        public final Builder storageType(List<Long> storageType) {
            this.storageType = storageType;
            return this;
        }

        /**
         * Amount of used storage space on the component system. A value of UINT32_MAX implies the field is 
         * unused. 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 4,
                arraySize = 4,
                description = "Amount of used storage space on the component system. A value of UINT32_MAX implies the field is unused."
        )
        public final Builder storageUsage(List<Long> storageUsage) {
            this.storageUsage = storageUsage;
            return this;
        }

        /**
         * Total amount of storage space on the component system. A value of UINT32_MAX implies the field 
         * is unused. 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 4,
                arraySize = 4,
                description = "Total amount of storage space on the component system. A value of UINT32_MAX implies the field is unused."
        )
        public final Builder storageTotal(List<Long> storageTotal) {
            this.storageTotal = storageTotal;
            return this;
        }

        /**
         * Link type: 0-9: UART, 10-19: Wired network, 20-29: Wifi, 30-39: Point-to-point proprietary, 
         * 40-49: Mesh proprietary 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 4,
                arraySize = 6,
                description = "Link type: 0-9: UART, 10-19: Wired network, 20-29: Wifi, 30-39: Point-to-point proprietary, 40-49: Mesh proprietary"
        )
        public final Builder linkType(List<Long> linkType) {
            this.linkType = linkType;
            return this;
        }

        /**
         * Network traffic from the component system. A value of UINT32_MAX implies the field is unused. 
         */
        @MavlinkFieldInfo(
                position = 18,
                unitSize = 4,
                arraySize = 6,
                description = "Network traffic from the component system. A value of UINT32_MAX implies the field is unused."
        )
        public final Builder linkTxRate(List<Long> linkTxRate) {
            this.linkTxRate = linkTxRate;
            return this;
        }

        /**
         * Network traffic to the component system. A value of UINT32_MAX implies the field is unused. 
         */
        @MavlinkFieldInfo(
                position = 19,
                unitSize = 4,
                arraySize = 6,
                description = "Network traffic to the component system. A value of UINT32_MAX implies the field is unused."
        )
        public final Builder linkRxRate(List<Long> linkRxRate) {
            this.linkRxRate = linkRxRate;
            return this;
        }

        /**
         * Network capacity from the component system. A value of UINT32_MAX implies the field is unused. 
         */
        @MavlinkFieldInfo(
                position = 20,
                unitSize = 4,
                arraySize = 6,
                description = "Network capacity from the component system. A value of UINT32_MAX implies the field is unused."
        )
        public final Builder linkTxMax(List<Long> linkTxMax) {
            this.linkTxMax = linkTxMax;
            return this;
        }

        /**
         * Network capacity to the component system. A value of UINT32_MAX implies the field is unused. 
         */
        @MavlinkFieldInfo(
                position = 21,
                unitSize = 4,
                arraySize = 6,
                description = "Network capacity to the component system. A value of UINT32_MAX implies the field is unused."
        )
        public final Builder linkRxMax(List<Long> linkRxMax) {
            this.linkRxMax = linkRxMax;
            return this;
        }

        public final OnboardComputerStatus build() {
            return new OnboardComputerStatus(timeUsec, uptime, type, cpuCores, cpuCombined, gpuCores, gpuCombined, temperatureBoard, temperatureCore, fanSpeed, ramUsage, ramTotal, storageType, storageUsage, storageTotal, linkType, linkTxRate, linkRxRate, linkTxMax, linkRxMax);
        }
    }
}
