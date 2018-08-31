package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Send a block of log data to remote location 
 */
@MavlinkMessageInfo(
        id = 184,
        crc = 159,
        description = "Send a block of log data to remote location"
)
public final class RemoteLogDataBlock {
    private final int targetSystem;

    private final int targetComponent;

    private final EnumValue<MavRemoteLogDataBlockCommands> seqno;

    private final byte[] data;

    private RemoteLogDataBlock(int targetSystem, int targetComponent,
            EnumValue<MavRemoteLogDataBlockCommands> seqno, byte[] data) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.seqno = seqno;
        this.data = data;
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
     * log data block sequence number 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            enumType = MavRemoteLogDataBlockCommands.class,
            description = "log data block sequence number"
    )
    public final EnumValue<MavRemoteLogDataBlockCommands> seqno() {
        return this.seqno;
    }

    /**
     * log data block 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            arraySize = 200,
            description = "log data block"
    )
    public final byte[] data() {
        return this.data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        RemoteLogDataBlock other = (RemoteLogDataBlock)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(seqno, other.seqno)) return false;
        if (!Objects.deepEquals(data, other.data)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(seqno);
        result = 31 * result + Objects.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "RemoteLogDataBlock{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", seqno=" + seqno
                 + ", data=" + data + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private EnumValue<MavRemoteLogDataBlockCommands> seqno;

        private byte[] data;

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
         * log data block sequence number 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                enumType = MavRemoteLogDataBlockCommands.class,
                description = "log data block sequence number"
        )
        public final Builder seqno(EnumValue<MavRemoteLogDataBlockCommands> seqno) {
            this.seqno = seqno;
            return this;
        }

        /**
         * log data block sequence number 
         */
        public final Builder seqno(MavRemoteLogDataBlockCommands entry) {
            return seqno(EnumValue.of(entry));
        }

        /**
         * log data block sequence number 
         */
        public final Builder seqno(Enum... flags) {
            return seqno(EnumValue.create(flags));
        }

        /**
         * log data block sequence number 
         */
        public final Builder seqno(Collection<Enum> flags) {
            return seqno(EnumValue.create(flags));
        }

        /**
         * log data block 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                arraySize = 200,
                description = "log data block"
        )
        public final Builder data(byte[] data) {
            this.data = data;
            return this;
        }

        public final RemoteLogDataBlock build() {
            return new RemoteLogDataBlock(targetSystem, targetComponent, seqno, data);
        }
    }
}
