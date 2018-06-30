package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * Request a {@link io.dronefleet.mavlink.ardupilotmega.GoproCommand GOPRO_COMMAND} response from the GoPro 
 */
@MavlinkMessageInfo(
        id = 216,
        crc = 50
)
public final class GoproGetRequest {
    private final int targetSystem;

    private final int targetComponent;

    private final GoproCommand cmdId;

    private GoproGetRequest(int targetSystem, int targetComponent, GoproCommand cmdId) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.cmdId = cmdId;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Command ID 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final GoproCommand cmdId() {
        return this.cmdId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GoproGetRequest other = (GoproGetRequest)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(cmdId, other.cmdId)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(cmdId);
        return result;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private GoproCommand cmdId;

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Command ID 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder cmdId(GoproCommand cmdId) {
            this.cmdId = cmdId;
            return this;
        }

        public final GoproGetRequest build() {
            return new GoproGetRequest(targetSystem, targetComponent, cmdId);
        }
    }
}
