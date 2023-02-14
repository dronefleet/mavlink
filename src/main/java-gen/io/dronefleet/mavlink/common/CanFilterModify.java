package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Modify the filter of what CAN messages to forward over the mavlink. This can be used to make CAN 
 * forwarding work well on low bandwidth links. The filtering is applied on bits 8 to 24 of the CAN id 
 * (2nd and 3rd bytes) which corresponds to the DroneCAN message ID for DroneCAN. Filters with 
 * more than 16 IDs can be constructed by sending multiple {@link io.dronefleet.mavlink.common.CanFilterModify CAN_FILTER_MODIFY} messages. 
 */
@MavlinkMessageInfo(
        id = 388,
        crc = 8,
        description = "Modify the filter of what CAN messages to forward over the mavlink. This can be used to make CAN forwarding work well on low bandwidth links. The filtering is applied on bits 8 to 24 of the CAN id (2nd and 3rd bytes) which corresponds to the DroneCAN message ID for DroneCAN. Filters with more than 16 IDs can be constructed by sending multiple CAN_FILTER_MODIFY messages."
)
public final class CanFilterModify {
    private final int targetSystem;

    private final int targetComponent;

    private final int bus;

    private final EnumValue<CanFilterOp> operation;

    private final int numIds;

    private final List<Integer> ids;

    private CanFilterModify(int targetSystem, int targetComponent, int bus,
            EnumValue<CanFilterOp> operation, int numIds, List<Integer> ids) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.bus = bus;
        this.operation = operation;
        this.numIds = numIds;
        this.ids = ids;
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
     * bus number 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "bus number"
    )
    public final int bus() {
        return this.bus;
    }

    /**
     * what operation to perform on the filter list. See {@link io.dronefleet.mavlink.common.CanFilterOp CAN_FILTER_OP} enum. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = CanFilterOp.class,
            description = "what operation to perform on the filter list. See CAN_FILTER_OP enum."
    )
    public final EnumValue<CanFilterOp> operation() {
        return this.operation;
    }

    /**
     * number of IDs in filter list 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "number of IDs in filter list"
    )
    public final int numIds() {
        return this.numIds;
    }

    /**
     * filter IDs, length num_ids 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            arraySize = 16,
            description = "filter IDs, length num_ids"
    )
    public final List<Integer> ids() {
        return this.ids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CanFilterModify other = (CanFilterModify)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(bus, other.bus)) return false;
        if (!Objects.deepEquals(operation, other.operation)) return false;
        if (!Objects.deepEquals(numIds, other.numIds)) return false;
        if (!Objects.deepEquals(ids, other.ids)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(bus);
        result = 31 * result + Objects.hashCode(operation);
        result = 31 * result + Objects.hashCode(numIds);
        result = 31 * result + Objects.hashCode(ids);
        return result;
    }

    @Override
    public String toString() {
        return "CanFilterModify{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", bus=" + bus
                 + ", operation=" + operation
                 + ", numIds=" + numIds
                 + ", ids=" + ids + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int bus;

        private EnumValue<CanFilterOp> operation;

        private int numIds;

        private List<Integer> ids;

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
         * bus number 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "bus number"
        )
        public final Builder bus(int bus) {
            this.bus = bus;
            return this;
        }

        /**
         * what operation to perform on the filter list. See {@link io.dronefleet.mavlink.common.CanFilterOp CAN_FILTER_OP} enum. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = CanFilterOp.class,
                description = "what operation to perform on the filter list. See CAN_FILTER_OP enum."
        )
        public final Builder operation(EnumValue<CanFilterOp> operation) {
            this.operation = operation;
            return this;
        }

        /**
         * what operation to perform on the filter list. See {@link io.dronefleet.mavlink.common.CanFilterOp CAN_FILTER_OP} enum. 
         */
        public final Builder operation(CanFilterOp entry) {
            return operation(EnumValue.of(entry));
        }

        /**
         * what operation to perform on the filter list. See {@link io.dronefleet.mavlink.common.CanFilterOp CAN_FILTER_OP} enum. 
         */
        public final Builder operation(Enum... flags) {
            return operation(EnumValue.create(flags));
        }

        /**
         * what operation to perform on the filter list. See {@link io.dronefleet.mavlink.common.CanFilterOp CAN_FILTER_OP} enum. 
         */
        public final Builder operation(Collection<Enum> flags) {
            return operation(EnumValue.create(flags));
        }

        /**
         * number of IDs in filter list 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "number of IDs in filter list"
        )
        public final Builder numIds(int numIds) {
            this.numIds = numIds;
            return this;
        }

        /**
         * filter IDs, length num_ids 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                arraySize = 16,
                description = "filter IDs, length num_ids"
        )
        public final Builder ids(List<Integer> ids) {
            this.ids = ids;
            return this;
        }

        public final CanFilterModify build() {
            return new CanFilterModify(targetSystem, targetComponent, bus, operation, numIds, ids);
        }
    }
}
