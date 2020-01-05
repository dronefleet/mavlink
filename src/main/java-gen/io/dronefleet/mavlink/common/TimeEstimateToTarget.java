package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Time/duration estimates for various events and actions given the current vehicle state and 
 * position. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 380,
        crc = 232,
        description = "Time/duration estimates for various events and actions given the current vehicle state and position.",
        workInProgress = true
)
@Deprecated
public final class TimeEstimateToTarget {
    private final int safeReturn;

    private final int land;

    private final int missionNextItem;

    private final int missionEnd;

    private final int commandedAction;

    private TimeEstimateToTarget(int safeReturn, int land, int missionNextItem, int missionEnd,
            int commandedAction) {
        this.safeReturn = safeReturn;
        this.land = land;
        this.missionNextItem = missionNextItem;
        this.missionEnd = missionEnd;
        this.commandedAction = commandedAction;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Estimated time to complete the vehicle's configured "safe return" action from its current 
     * position (e.g. RTL, Smart RTL, etc.). -1 indicates that the vehicle is landed, or that no time 
     * estimate available. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            signed = true,
            description = "Estimated time to complete the vehicle's configured \"safe return\" action from its current position (e.g. RTL, Smart RTL, etc.). -1 indicates that the vehicle is landed, or that no time estimate available."
    )
    public final int safeReturn() {
        return this.safeReturn;
    }

    /**
     * Estimated time for vehicle to complete the LAND action from its current position. -1 indicates 
     * that the vehicle is landed, or that no time estimate available. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true,
            description = "Estimated time for vehicle to complete the LAND action from its current position. -1 indicates that the vehicle is landed, or that no time estimate available."
    )
    public final int land() {
        return this.land;
    }

    /**
     * Estimated time for reaching/completing the currently active mission item. -1 means no time 
     * estimate available. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true,
            description = "Estimated time for reaching/completing the currently active mission item. -1 means no time estimate available."
    )
    public final int missionNextItem() {
        return this.missionNextItem;
    }

    /**
     * Estimated time for completing the current mission. -1 means no mission active and/or no 
     * estimate available. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "Estimated time for completing the current mission. -1 means no mission active and/or no estimate available."
    )
    public final int missionEnd() {
        return this.missionEnd;
    }

    /**
     * Estimated time for completing the current commanded action (i.e. Go To, Takeoff, Land, etc.). 
     * -1 means no action active and/or no estimate available. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            signed = true,
            description = "Estimated time for completing the current commanded action (i.e. Go To, Takeoff, Land, etc.). -1 means no action active and/or no estimate available."
    )
    public final int commandedAction() {
        return this.commandedAction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        TimeEstimateToTarget other = (TimeEstimateToTarget)o;
        if (!Objects.deepEquals(safeReturn, other.safeReturn)) return false;
        if (!Objects.deepEquals(land, other.land)) return false;
        if (!Objects.deepEquals(missionNextItem, other.missionNextItem)) return false;
        if (!Objects.deepEquals(missionEnd, other.missionEnd)) return false;
        if (!Objects.deepEquals(commandedAction, other.commandedAction)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(safeReturn);
        result = 31 * result + Objects.hashCode(land);
        result = 31 * result + Objects.hashCode(missionNextItem);
        result = 31 * result + Objects.hashCode(missionEnd);
        result = 31 * result + Objects.hashCode(commandedAction);
        return result;
    }

    @Override
    public String toString() {
        return "TimeEstimateToTarget{safeReturn=" + safeReturn
                 + ", land=" + land
                 + ", missionNextItem=" + missionNextItem
                 + ", missionEnd=" + missionEnd
                 + ", commandedAction=" + commandedAction + "}";
    }

    public static final class Builder {
        private int safeReturn;

        private int land;

        private int missionNextItem;

        private int missionEnd;

        private int commandedAction;

        /**
         * Estimated time to complete the vehicle's configured "safe return" action from its current 
         * position (e.g. RTL, Smart RTL, etc.). -1 indicates that the vehicle is landed, or that no time 
         * estimate available. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                signed = true,
                description = "Estimated time to complete the vehicle's configured \"safe return\" action from its current position (e.g. RTL, Smart RTL, etc.). -1 indicates that the vehicle is landed, or that no time estimate available."
        )
        public final Builder safeReturn(int safeReturn) {
            this.safeReturn = safeReturn;
            return this;
        }

        /**
         * Estimated time for vehicle to complete the LAND action from its current position. -1 indicates 
         * that the vehicle is landed, or that no time estimate available. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true,
                description = "Estimated time for vehicle to complete the LAND action from its current position. -1 indicates that the vehicle is landed, or that no time estimate available."
        )
        public final Builder land(int land) {
            this.land = land;
            return this;
        }

        /**
         * Estimated time for reaching/completing the currently active mission item. -1 means no time 
         * estimate available. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true,
                description = "Estimated time for reaching/completing the currently active mission item. -1 means no time estimate available."
        )
        public final Builder missionNextItem(int missionNextItem) {
            this.missionNextItem = missionNextItem;
            return this;
        }

        /**
         * Estimated time for completing the current mission. -1 means no mission active and/or no 
         * estimate available. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "Estimated time for completing the current mission. -1 means no mission active and/or no estimate available."
        )
        public final Builder missionEnd(int missionEnd) {
            this.missionEnd = missionEnd;
            return this;
        }

        /**
         * Estimated time for completing the current commanded action (i.e. Go To, Takeoff, Land, etc.). 
         * -1 means no action active and/or no estimate available. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                signed = true,
                description = "Estimated time for completing the current commanded action (i.e. Go To, Takeoff, Land, etc.). -1 means no action active and/or no estimate available."
        )
        public final Builder commandedAction(int commandedAction) {
            this.commandedAction = commandedAction;
            return this;
        }

        public final TimeEstimateToTarget build() {
            return new TimeEstimateToTarget(safeReturn, land, missionNextItem, missionEnd, commandedAction);
        }
    }
}
