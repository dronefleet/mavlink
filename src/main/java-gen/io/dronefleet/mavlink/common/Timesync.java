package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Time synchronization message. The message is used for both timesync requests and responses. 
 * The request is sent with `ts1=syncing component timestamp` and `tc1=0`, and may be broadcast 
 * or targeted to a specific system/component. The response is sent with `ts1=syncing component 
 * timestamp` (mirror back unchanged), and `tc1=responding component timestamp`, with the 
 * `target_system` and `target_component` set to ids of the original request. Systems can 
 * determine if they are receiving a request or response based on the value of `tc`. If the response 
 * has `target_system==target_component==0` the remote system has not been updated to use the 
 * component IDs and cannot reliably timesync; the requestor may report an error. Timestamps are 
 * UNIX Epoch time or time since system boot in nanoseconds (the timestamp format can be inferred 
 * by checking for the magnitude of the number; generally it doesn't matter as only the offset is 
 * used). The message sequence is repeated numerous times with results being filtered/averaged 
 * to estimate the offset. 
 */
@MavlinkMessageInfo(
        id = 111,
        crc = 34,
        description = "Time synchronization message.\n"
                        + "        The message is used for both timesync requests and responses.\n"
                        + "        The request is sent with `ts1=syncing component timestamp` and `tc1=0`, and may be broadcast or targeted to a specific system/component.\n"
                        + "        The response is sent with `ts1=syncing component timestamp` (mirror back unchanged), and `tc1=responding component timestamp`, with the `target_system` and `target_component` set to ids of the original request.\n"
                        + "        Systems can determine if they are receiving a request or response based on the value of `tc`.\n"
                        + "        If the response has `target_system==target_component==0` the remote system has not been updated to use the component IDs and cannot reliably timesync; the requestor may report an error.\n"
                        + "        Timestamps are UNIX Epoch time or time since system boot in nanoseconds (the timestamp format can be inferred by checking for the magnitude of the number; generally it doesn't matter as only the offset is used).\n"
                        + "        The message sequence is repeated numerous times with results being filtered/averaged to estimate the offset."
)
public final class Timesync {
    private final long tc1;

    private final long ts1;

    private final int targetSystem;

    private final int targetComponent;

    private Timesync(long tc1, long ts1, int targetSystem, int targetComponent) {
        this.tc1 = tc1;
        this.ts1 = ts1;
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Time sync timestamp 1. Syncing: 0. Responding: Timestamp of responding component. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            signed = true,
            description = "Time sync timestamp 1. Syncing: 0. Responding: Timestamp of responding component."
    )
    public final long tc1() {
        return this.tc1;
    }

    /**
     * Time sync timestamp 2. Timestamp of syncing component (mirrored in response). 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 8,
            signed = true,
            description = "Time sync timestamp 2. Timestamp of syncing component (mirrored in response)."
    )
    public final long ts1() {
        return this.ts1;
    }

    /**
     * Target system id. Request: 0 (broadcast) or id of specific system. Response must contain 
     * system id of the requesting component. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            extension = true,
            description = "Target system id. Request: 0 (broadcast) or id of specific system. Response must contain system id of the requesting component."
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Target component id. Request: 0 (broadcast) or id of specific component. Response must 
     * contain component id of the requesting component. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            extension = true,
            description = "Target component id. Request: 0 (broadcast) or id of specific component. Response must contain component id of the requesting component."
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Timesync other = (Timesync)o;
        if (!Objects.deepEquals(tc1, other.tc1)) return false;
        if (!Objects.deepEquals(ts1, other.ts1)) return false;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(tc1);
        result = 31 * result + Objects.hashCode(ts1);
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        return result;
    }

    @Override
    public String toString() {
        return "Timesync{tc1=" + tc1
                 + ", ts1=" + ts1
                 + ", targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent + "}";
    }

    public static final class Builder {
        private long tc1;

        private long ts1;

        private int targetSystem;

        private int targetComponent;

        /**
         * Time sync timestamp 1. Syncing: 0. Responding: Timestamp of responding component. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                signed = true,
                description = "Time sync timestamp 1. Syncing: 0. Responding: Timestamp of responding component."
        )
        public final Builder tc1(long tc1) {
            this.tc1 = tc1;
            return this;
        }

        /**
         * Time sync timestamp 2. Timestamp of syncing component (mirrored in response). 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 8,
                signed = true,
                description = "Time sync timestamp 2. Timestamp of syncing component (mirrored in response)."
        )
        public final Builder ts1(long ts1) {
            this.ts1 = ts1;
            return this;
        }

        /**
         * Target system id. Request: 0 (broadcast) or id of specific system. Response must contain 
         * system id of the requesting component. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                extension = true,
                description = "Target system id. Request: 0 (broadcast) or id of specific system. Response must contain system id of the requesting component."
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Target component id. Request: 0 (broadcast) or id of specific component. Response must 
         * contain component id of the requesting component. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                extension = true,
                description = "Target component id. Request: 0 (broadcast) or id of specific component. Response must contain component id of the requesting component."
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        public final Timesync build() {
            return new Timesync(tc1, ts1, targetSystem, targetComponent);
        }
    }
}
