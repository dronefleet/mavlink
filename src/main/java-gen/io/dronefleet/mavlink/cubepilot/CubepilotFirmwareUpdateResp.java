package io.dronefleet.mavlink.cubepilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * offset response to encapsulated data. 
 */
@MavlinkMessageInfo(
        id = 50005,
        crc = 152,
        description = "offset response to encapsulated data."
)
public final class CubepilotFirmwareUpdateResp {
    private final int targetSystem;

    private final int targetComponent;

    private final long offset;

    private CubepilotFirmwareUpdateResp(int targetSystem, int targetComponent, long offset) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.offset = offset;
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
     * FW Offset. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "FW Offset."
    )
    public final long offset() {
        return this.offset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CubepilotFirmwareUpdateResp other = (CubepilotFirmwareUpdateResp)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(offset, other.offset)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(offset);
        return result;
    }

    @Override
    public String toString() {
        return "CubepilotFirmwareUpdateResp{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", offset=" + offset + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private long offset;

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
         * FW Offset. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "FW Offset."
        )
        public final Builder offset(long offset) {
            this.offset = offset;
            return this;
        }

        public final CubepilotFirmwareUpdateResp build() {
            return new CubepilotFirmwareUpdateResp(targetSystem, targetComponent, offset);
        }
    }
}
