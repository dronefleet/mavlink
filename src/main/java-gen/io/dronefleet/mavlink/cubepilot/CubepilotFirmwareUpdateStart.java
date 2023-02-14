package io.dronefleet.mavlink.cubepilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Start firmware update with encapsulated data. 
 */
@MavlinkMessageInfo(
        id = 50004,
        crc = 240,
        description = "Start firmware update with encapsulated data."
)
public final class CubepilotFirmwareUpdateStart {
    private final int targetSystem;

    private final int targetComponent;

    private final long size;

    private final long crc;

    private CubepilotFirmwareUpdateStart(int targetSystem, int targetComponent, long size,
            long crc) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.size = size;
        this.crc = crc;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "System ID."
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID."
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * FW Size. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "FW Size."
    )
    public final long size() {
        return this.size;
    }

    /**
     * FW CRC. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "FW CRC."
    )
    public final long crc() {
        return this.crc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CubepilotFirmwareUpdateStart other = (CubepilotFirmwareUpdateStart)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(size, other.size)) return false;
        if (!Objects.deepEquals(crc, other.crc)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(size);
        result = 31 * result + Objects.hashCode(crc);
        return result;
    }

    @Override
    public String toString() {
        return "CubepilotFirmwareUpdateStart{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", size=" + size
                 + ", crc=" + crc + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private long size;

        private long crc;

        /**
         * System ID. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "System ID."
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Component ID."
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * FW Size. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "FW Size."
        )
        public final Builder size(long size) {
            this.size = size;
            return this;
        }

        /**
         * FW CRC. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "FW CRC."
        )
        public final Builder crc(long crc) {
            this.crc = crc;
            return this;
        }

        public final CubepilotFirmwareUpdateStart build() {
            return new CubepilotFirmwareUpdateStart(targetSystem, targetComponent, size, crc);
        }
    }
}
