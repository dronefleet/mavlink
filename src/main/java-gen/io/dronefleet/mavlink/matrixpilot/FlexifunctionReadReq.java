package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Reqest reading of flexifunction data 
 */
@MavlinkMessageInfo(
        id = 151,
        crc = 26,
        description = "Reqest reading of flexifunction data"
)
public final class FlexifunctionReadReq {
    private final int targetSystem;

    private final int targetComponent;

    private final int readReqType;

    private final int dataIndex;

    private FlexifunctionReadReq(int targetSystem, int targetComponent, int readReqType,
            int dataIndex) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.readReqType = readReqType;
        this.dataIndex = dataIndex;
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
            unitSize = 1,
            description = "System ID"
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Type of flexifunction data requested 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true,
            description = "Type of flexifunction data requested"
    )
    public final int readReqType() {
        return this.readReqType;
    }

    /**
     * index into data where needed 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true,
            description = "index into data where needed"
    )
    public final int dataIndex() {
        return this.dataIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        FlexifunctionReadReq other = (FlexifunctionReadReq)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(readReqType, other.readReqType)) return false;
        if (!Objects.deepEquals(dataIndex, other.dataIndex)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(readReqType);
        result = 31 * result + Objects.hashCode(dataIndex);
        return result;
    }

    @Override
    public String toString() {
        return "FlexifunctionReadReq{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", readReqType=" + readReqType
                 + ", dataIndex=" + dataIndex + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int readReqType;

        private int dataIndex;

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "System ID"
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
                unitSize = 1,
                description = "Component ID"
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Type of flexifunction data requested 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true,
                description = "Type of flexifunction data requested"
        )
        public final Builder readReqType(int readReqType) {
            this.readReqType = readReqType;
            return this;
        }

        /**
         * index into data where needed 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true,
                description = "index into data where needed"
        )
        public final Builder dataIndex(int dataIndex) {
            this.dataIndex = dataIndex;
            return this;
        }

        public final FlexifunctionReadReq build() {
            return new FlexifunctionReadReq(targetSystem, targetComponent, readReqType, dataIndex);
        }
    }
}
