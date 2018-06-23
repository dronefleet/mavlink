package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Send a block of log data to remote location 
 */
@MavlinkMessageInfo(
        id = 184,
        crc = 159
)
public final class RemoteLogDataBlock {
    /**
     * log data block sequence number 
     */
    private final MavRemoteLogDataBlockCommands seqno;

    /**
     * System ID 
     */
    private final int targetSystem;

    /**
     * Component ID 
     */
    private final int targetComponent;

    /**
     * log data block 
     */
    private final byte[] data;

    private RemoteLogDataBlock(MavRemoteLogDataBlockCommands seqno, int targetSystem,
            int targetComponent, byte[] data) {
        this.seqno = seqno;
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.data = data;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "RemoteLogDataBlock{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", seqno=" + seqno
                 + ", data=" + data + "}";
    }

    /**
     * log data block sequence number 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final MavRemoteLogDataBlockCommands seqno() {
        return seqno;
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int targetSystem() {
        return targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetComponent() {
        return targetComponent;
    }

    /**
     * log data block 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            arraySize = 200
    )
    public final byte[] data() {
        return data;
    }

    public static class Builder {
        private MavRemoteLogDataBlockCommands seqno;

        private int targetSystem;

        private int targetComponent;

        private byte[] data;

        private Builder() {
        }

        /**
         * log data block sequence number 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder seqno(MavRemoteLogDataBlockCommands seqno) {
            this.seqno = seqno;
            return this;
        }

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
         * log data block 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                arraySize = 200
        )
        public final Builder data(byte[] data) {
            this.data = data;
            return this;
        }

        public final RemoteLogDataBlock build() {
            return new RemoteLogDataBlock(seqno, targetSystem, targetComponent, data);
        }
    }
}
