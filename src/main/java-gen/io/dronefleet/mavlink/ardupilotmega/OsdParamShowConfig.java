package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Read a configured an OSD parameter slot. 
 */
@MavlinkMessageInfo(
        id = 11035,
        crc = 128,
        description = "Read a configured an OSD parameter slot."
)
public final class OsdParamShowConfig {
    private final int targetSystem;

    private final int targetComponent;

    private final long requestId;

    private final int osdScreen;

    private final int osdIndex;

    private OsdParamShowConfig(int targetSystem, int targetComponent, long requestId, int osdScreen,
            int osdIndex) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.requestId = requestId;
        this.osdScreen = osdScreen;
        this.osdIndex = osdIndex;
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
     * Request ID - copied to reply. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Request ID - copied to reply."
    )
    public final long requestId() {
        return this.requestId;
    }

    /**
     * OSD parameter screen index. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "OSD parameter screen index."
    )
    public final int osdScreen() {
        return this.osdScreen;
    }

    /**
     * OSD parameter display index. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "OSD parameter display index."
    )
    public final int osdIndex() {
        return this.osdIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        OsdParamShowConfig other = (OsdParamShowConfig)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(requestId, other.requestId)) return false;
        if (!Objects.deepEquals(osdScreen, other.osdScreen)) return false;
        if (!Objects.deepEquals(osdIndex, other.osdIndex)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(requestId);
        result = 31 * result + Objects.hashCode(osdScreen);
        result = 31 * result + Objects.hashCode(osdIndex);
        return result;
    }

    @Override
    public String toString() {
        return "OsdParamShowConfig{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", requestId=" + requestId
                 + ", osdScreen=" + osdScreen
                 + ", osdIndex=" + osdIndex + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private long requestId;

        private int osdScreen;

        private int osdIndex;

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
         * Request ID - copied to reply. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Request ID - copied to reply."
        )
        public final Builder requestId(long requestId) {
            this.requestId = requestId;
            return this;
        }

        /**
         * OSD parameter screen index. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "OSD parameter screen index."
        )
        public final Builder osdScreen(int osdScreen) {
            this.osdScreen = osdScreen;
            return this;
        }

        /**
         * OSD parameter display index. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "OSD parameter display index."
        )
        public final Builder osdIndex(int osdIndex) {
            this.osdIndex = osdIndex;
            return this;
        }

        public final OsdParamShowConfig build() {
            return new OsdParamShowConfig(targetSystem, targetComponent, requestId, osdScreen, osdIndex);
        }
    }
}
