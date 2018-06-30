package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * Send Status of each log block that autopilot board might have sent 
 */
@MavlinkMessageInfo(
        id = 185,
        crc = 186
)
public final class RemoteLogBlockStatus {
    private final int targetSystem;

    private final int targetComponent;

    private final long seqno;

    private final MavRemoteLogDataBlockStatuses status;

    private RemoteLogBlockStatus(int targetSystem, int targetComponent, long seqno,
            MavRemoteLogDataBlockStatuses status) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.seqno = seqno;
        this.status = status;
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
     * log data block sequence number 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final long seqno() {
        return this.seqno;
    }

    /**
     * log data block status 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final MavRemoteLogDataBlockStatuses status() {
        return this.status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        RemoteLogBlockStatus other = (RemoteLogBlockStatus)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(seqno, other.seqno)) return false;
        if (!Objects.deepEquals(status, other.status)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(seqno);
        result = 31 * result + Objects.hashCode(status);
        return result;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private long seqno;

        private MavRemoteLogDataBlockStatuses status;

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
         * log data block sequence number 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder seqno(long seqno) {
            this.seqno = seqno;
            return this;
        }

        /**
         * log data block status 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder status(MavRemoteLogDataBlockStatuses status) {
            this.status = status;
            return this;
        }

        public final RemoteLogBlockStatus build() {
            return new RemoteLogBlockStatus(targetSystem, targetComponent, seqno, status);
        }
    }
}
