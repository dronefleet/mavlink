package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * The RAW values of the RC channels sent to the MAV to override info received from the RC radio. The 
 * standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. 
 * Individual receivers/transmitters might violate this specification. Note carefully the 
 * semantic differences between the first 8 channels and the subsequent channels 
 */
@MavlinkMessageInfo(
        id = 70,
        crc = 124,
        description = "The RAW values of the RC channels sent to the MAV to override info received from the RC radio. The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. Individual receivers/transmitters might violate this specification.  Note carefully the semantic differences between the first 8 channels and the subsequent channels"
)
public final class RcChannelsOverride {
    private final int targetSystem;

    private final int targetComponent;

    private final int chan1Raw;

    private final int chan2Raw;

    private final int chan3Raw;

    private final int chan4Raw;

    private final int chan5Raw;

    private final int chan6Raw;

    private final int chan7Raw;

    private final int chan8Raw;

    private final int chan9Raw;

    private final int chan10Raw;

    private final int chan11Raw;

    private final int chan12Raw;

    private final int chan13Raw;

    private final int chan14Raw;

    private final int chan15Raw;

    private final int chan16Raw;

    private final int chan17Raw;

    private final int chan18Raw;

    private RcChannelsOverride(int targetSystem, int targetComponent, int chan1Raw, int chan2Raw,
            int chan3Raw, int chan4Raw, int chan5Raw, int chan6Raw, int chan7Raw, int chan8Raw,
            int chan9Raw, int chan10Raw, int chan11Raw, int chan12Raw, int chan13Raw, int chan14Raw,
            int chan15Raw, int chan16Raw, int chan17Raw, int chan18Raw) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.chan1Raw = chan1Raw;
        this.chan2Raw = chan2Raw;
        this.chan3Raw = chan3Raw;
        this.chan4Raw = chan4Raw;
        this.chan5Raw = chan5Raw;
        this.chan6Raw = chan6Raw;
        this.chan7Raw = chan7Raw;
        this.chan8Raw = chan8Raw;
        this.chan9Raw = chan9Raw;
        this.chan10Raw = chan10Raw;
        this.chan11Raw = chan11Raw;
        this.chan12Raw = chan12Raw;
        this.chan13Raw = chan13Raw;
        this.chan14Raw = chan14Raw;
        this.chan15Raw = chan15Raw;
        this.chan16Raw = chan16Raw;
        this.chan17Raw = chan17Raw;
        this.chan18Raw = chan18Raw;
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
     * RC channel 1 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release 
     * this channel back to the RC radio. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "RC channel 1 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release this channel back to the RC radio."
    )
    public final int chan1Raw() {
        return this.chan1Raw;
    }

    /**
     * RC channel 2 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release 
     * this channel back to the RC radio. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "RC channel 2 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release this channel back to the RC radio."
    )
    public final int chan2Raw() {
        return this.chan2Raw;
    }

    /**
     * RC channel 3 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release 
     * this channel back to the RC radio. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "RC channel 3 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release this channel back to the RC radio."
    )
    public final int chan3Raw() {
        return this.chan3Raw;
    }

    /**
     * RC channel 4 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release 
     * this channel back to the RC radio. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "RC channel 4 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release this channel back to the RC radio."
    )
    public final int chan4Raw() {
        return this.chan4Raw;
    }

    /**
     * RC channel 5 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release 
     * this channel back to the RC radio. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            description = "RC channel 5 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release this channel back to the RC radio."
    )
    public final int chan5Raw() {
        return this.chan5Raw;
    }

    /**
     * RC channel 6 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release 
     * this channel back to the RC radio. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            description = "RC channel 6 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release this channel back to the RC radio."
    )
    public final int chan6Raw() {
        return this.chan6Raw;
    }

    /**
     * RC channel 7 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release 
     * this channel back to the RC radio. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            description = "RC channel 7 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release this channel back to the RC radio."
    )
    public final int chan7Raw() {
        return this.chan7Raw;
    }

    /**
     * RC channel 8 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release 
     * this channel back to the RC radio. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2,
            description = "RC channel 8 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release this channel back to the RC radio."
    )
    public final int chan8Raw() {
        return this.chan8Raw;
    }

    /**
     * RC channel 9 value. A value of 0 or UINT16_MAX means to ignore this field. A value of UINT16_MAX-1 
     * means to release this channel back to the RC radio. 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 2,
            extension = true,
            description = "RC channel 9 value. A value of 0 or UINT16_MAX means to ignore this field. A value of UINT16_MAX-1 means to release this channel back to the RC radio."
    )
    public final int chan9Raw() {
        return this.chan9Raw;
    }

    /**
     * RC channel 10 value. A value of 0 or UINT16_MAX means to ignore this field. A value of 
     * UINT16_MAX-1 means to release this channel back to the RC radio. 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 2,
            extension = true,
            description = "RC channel 10 value. A value of 0 or UINT16_MAX means to ignore this field. A value of UINT16_MAX-1 means to release this channel back to the RC radio."
    )
    public final int chan10Raw() {
        return this.chan10Raw;
    }

    /**
     * RC channel 11 value. A value of 0 or UINT16_MAX means to ignore this field. A value of 
     * UINT16_MAX-1 means to release this channel back to the RC radio. 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 2,
            extension = true,
            description = "RC channel 11 value. A value of 0 or UINT16_MAX means to ignore this field. A value of UINT16_MAX-1 means to release this channel back to the RC radio."
    )
    public final int chan11Raw() {
        return this.chan11Raw;
    }

    /**
     * RC channel 12 value. A value of 0 or UINT16_MAX means to ignore this field. A value of 
     * UINT16_MAX-1 means to release this channel back to the RC radio. 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 2,
            extension = true,
            description = "RC channel 12 value. A value of 0 or UINT16_MAX means to ignore this field. A value of UINT16_MAX-1 means to release this channel back to the RC radio."
    )
    public final int chan12Raw() {
        return this.chan12Raw;
    }

    /**
     * RC channel 13 value. A value of 0 or UINT16_MAX means to ignore this field. A value of 
     * UINT16_MAX-1 means to release this channel back to the RC radio. 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 2,
            extension = true,
            description = "RC channel 13 value. A value of 0 or UINT16_MAX means to ignore this field. A value of UINT16_MAX-1 means to release this channel back to the RC radio."
    )
    public final int chan13Raw() {
        return this.chan13Raw;
    }

    /**
     * RC channel 14 value. A value of 0 or UINT16_MAX means to ignore this field. A value of 
     * UINT16_MAX-1 means to release this channel back to the RC radio. 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 2,
            extension = true,
            description = "RC channel 14 value. A value of 0 or UINT16_MAX means to ignore this field. A value of UINT16_MAX-1 means to release this channel back to the RC radio."
    )
    public final int chan14Raw() {
        return this.chan14Raw;
    }

    /**
     * RC channel 15 value. A value of 0 or UINT16_MAX means to ignore this field. A value of 
     * UINT16_MAX-1 means to release this channel back to the RC radio. 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 2,
            extension = true,
            description = "RC channel 15 value. A value of 0 or UINT16_MAX means to ignore this field. A value of UINT16_MAX-1 means to release this channel back to the RC radio."
    )
    public final int chan15Raw() {
        return this.chan15Raw;
    }

    /**
     * RC channel 16 value. A value of 0 or UINT16_MAX means to ignore this field. A value of 
     * UINT16_MAX-1 means to release this channel back to the RC radio. 
     */
    @MavlinkFieldInfo(
            position = 19,
            unitSize = 2,
            extension = true,
            description = "RC channel 16 value. A value of 0 or UINT16_MAX means to ignore this field. A value of UINT16_MAX-1 means to release this channel back to the RC radio."
    )
    public final int chan16Raw() {
        return this.chan16Raw;
    }

    /**
     * RC channel 17 value. A value of 0 or UINT16_MAX means to ignore this field. A value of 
     * UINT16_MAX-1 means to release this channel back to the RC radio. 
     */
    @MavlinkFieldInfo(
            position = 20,
            unitSize = 2,
            extension = true,
            description = "RC channel 17 value. A value of 0 or UINT16_MAX means to ignore this field. A value of UINT16_MAX-1 means to release this channel back to the RC radio."
    )
    public final int chan17Raw() {
        return this.chan17Raw;
    }

    /**
     * RC channel 18 value. A value of 0 or UINT16_MAX means to ignore this field. A value of 
     * UINT16_MAX-1 means to release this channel back to the RC radio. 
     */
    @MavlinkFieldInfo(
            position = 21,
            unitSize = 2,
            extension = true,
            description = "RC channel 18 value. A value of 0 or UINT16_MAX means to ignore this field. A value of UINT16_MAX-1 means to release this channel back to the RC radio."
    )
    public final int chan18Raw() {
        return this.chan18Raw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        RcChannelsOverride other = (RcChannelsOverride)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(chan1Raw, other.chan1Raw)) return false;
        if (!Objects.deepEquals(chan2Raw, other.chan2Raw)) return false;
        if (!Objects.deepEquals(chan3Raw, other.chan3Raw)) return false;
        if (!Objects.deepEquals(chan4Raw, other.chan4Raw)) return false;
        if (!Objects.deepEquals(chan5Raw, other.chan5Raw)) return false;
        if (!Objects.deepEquals(chan6Raw, other.chan6Raw)) return false;
        if (!Objects.deepEquals(chan7Raw, other.chan7Raw)) return false;
        if (!Objects.deepEquals(chan8Raw, other.chan8Raw)) return false;
        if (!Objects.deepEquals(chan9Raw, other.chan9Raw)) return false;
        if (!Objects.deepEquals(chan10Raw, other.chan10Raw)) return false;
        if (!Objects.deepEquals(chan11Raw, other.chan11Raw)) return false;
        if (!Objects.deepEquals(chan12Raw, other.chan12Raw)) return false;
        if (!Objects.deepEquals(chan13Raw, other.chan13Raw)) return false;
        if (!Objects.deepEquals(chan14Raw, other.chan14Raw)) return false;
        if (!Objects.deepEquals(chan15Raw, other.chan15Raw)) return false;
        if (!Objects.deepEquals(chan16Raw, other.chan16Raw)) return false;
        if (!Objects.deepEquals(chan17Raw, other.chan17Raw)) return false;
        if (!Objects.deepEquals(chan18Raw, other.chan18Raw)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(chan1Raw);
        result = 31 * result + Objects.hashCode(chan2Raw);
        result = 31 * result + Objects.hashCode(chan3Raw);
        result = 31 * result + Objects.hashCode(chan4Raw);
        result = 31 * result + Objects.hashCode(chan5Raw);
        result = 31 * result + Objects.hashCode(chan6Raw);
        result = 31 * result + Objects.hashCode(chan7Raw);
        result = 31 * result + Objects.hashCode(chan8Raw);
        result = 31 * result + Objects.hashCode(chan9Raw);
        result = 31 * result + Objects.hashCode(chan10Raw);
        result = 31 * result + Objects.hashCode(chan11Raw);
        result = 31 * result + Objects.hashCode(chan12Raw);
        result = 31 * result + Objects.hashCode(chan13Raw);
        result = 31 * result + Objects.hashCode(chan14Raw);
        result = 31 * result + Objects.hashCode(chan15Raw);
        result = 31 * result + Objects.hashCode(chan16Raw);
        result = 31 * result + Objects.hashCode(chan17Raw);
        result = 31 * result + Objects.hashCode(chan18Raw);
        return result;
    }

    @Override
    public String toString() {
        return "RcChannelsOverride{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", chan1Raw=" + chan1Raw
                 + ", chan2Raw=" + chan2Raw
                 + ", chan3Raw=" + chan3Raw
                 + ", chan4Raw=" + chan4Raw
                 + ", chan5Raw=" + chan5Raw
                 + ", chan6Raw=" + chan6Raw
                 + ", chan7Raw=" + chan7Raw
                 + ", chan8Raw=" + chan8Raw
                 + ", chan9Raw=" + chan9Raw
                 + ", chan10Raw=" + chan10Raw
                 + ", chan11Raw=" + chan11Raw
                 + ", chan12Raw=" + chan12Raw
                 + ", chan13Raw=" + chan13Raw
                 + ", chan14Raw=" + chan14Raw
                 + ", chan15Raw=" + chan15Raw
                 + ", chan16Raw=" + chan16Raw
                 + ", chan17Raw=" + chan17Raw
                 + ", chan18Raw=" + chan18Raw + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int chan1Raw;

        private int chan2Raw;

        private int chan3Raw;

        private int chan4Raw;

        private int chan5Raw;

        private int chan6Raw;

        private int chan7Raw;

        private int chan8Raw;

        private int chan9Raw;

        private int chan10Raw;

        private int chan11Raw;

        private int chan12Raw;

        private int chan13Raw;

        private int chan14Raw;

        private int chan15Raw;

        private int chan16Raw;

        private int chan17Raw;

        private int chan18Raw;

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
         * RC channel 1 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release 
         * this channel back to the RC radio. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "RC channel 1 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release this channel back to the RC radio."
        )
        public final Builder chan1Raw(int chan1Raw) {
            this.chan1Raw = chan1Raw;
            return this;
        }

        /**
         * RC channel 2 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release 
         * this channel back to the RC radio. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "RC channel 2 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release this channel back to the RC radio."
        )
        public final Builder chan2Raw(int chan2Raw) {
            this.chan2Raw = chan2Raw;
            return this;
        }

        /**
         * RC channel 3 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release 
         * this channel back to the RC radio. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "RC channel 3 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release this channel back to the RC radio."
        )
        public final Builder chan3Raw(int chan3Raw) {
            this.chan3Raw = chan3Raw;
            return this;
        }

        /**
         * RC channel 4 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release 
         * this channel back to the RC radio. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "RC channel 4 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release this channel back to the RC radio."
        )
        public final Builder chan4Raw(int chan4Raw) {
            this.chan4Raw = chan4Raw;
            return this;
        }

        /**
         * RC channel 5 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release 
         * this channel back to the RC radio. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                description = "RC channel 5 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release this channel back to the RC radio."
        )
        public final Builder chan5Raw(int chan5Raw) {
            this.chan5Raw = chan5Raw;
            return this;
        }

        /**
         * RC channel 6 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release 
         * this channel back to the RC radio. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                description = "RC channel 6 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release this channel back to the RC radio."
        )
        public final Builder chan6Raw(int chan6Raw) {
            this.chan6Raw = chan6Raw;
            return this;
        }

        /**
         * RC channel 7 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release 
         * this channel back to the RC radio. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                description = "RC channel 7 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release this channel back to the RC radio."
        )
        public final Builder chan7Raw(int chan7Raw) {
            this.chan7Raw = chan7Raw;
            return this;
        }

        /**
         * RC channel 8 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release 
         * this channel back to the RC radio. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 2,
                description = "RC channel 8 value. A value of UINT16_MAX means to ignore this field. A value of 0 means to release this channel back to the RC radio."
        )
        public final Builder chan8Raw(int chan8Raw) {
            this.chan8Raw = chan8Raw;
            return this;
        }

        /**
         * RC channel 9 value. A value of 0 or UINT16_MAX means to ignore this field. A value of UINT16_MAX-1 
         * means to release this channel back to the RC radio. 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 2,
                extension = true,
                description = "RC channel 9 value. A value of 0 or UINT16_MAX means to ignore this field. A value of UINT16_MAX-1 means to release this channel back to the RC radio."
        )
        public final Builder chan9Raw(int chan9Raw) {
            this.chan9Raw = chan9Raw;
            return this;
        }

        /**
         * RC channel 10 value. A value of 0 or UINT16_MAX means to ignore this field. A value of 
         * UINT16_MAX-1 means to release this channel back to the RC radio. 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 2,
                extension = true,
                description = "RC channel 10 value. A value of 0 or UINT16_MAX means to ignore this field. A value of UINT16_MAX-1 means to release this channel back to the RC radio."
        )
        public final Builder chan10Raw(int chan10Raw) {
            this.chan10Raw = chan10Raw;
            return this;
        }

        /**
         * RC channel 11 value. A value of 0 or UINT16_MAX means to ignore this field. A value of 
         * UINT16_MAX-1 means to release this channel back to the RC radio. 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 2,
                extension = true,
                description = "RC channel 11 value. A value of 0 or UINT16_MAX means to ignore this field. A value of UINT16_MAX-1 means to release this channel back to the RC radio."
        )
        public final Builder chan11Raw(int chan11Raw) {
            this.chan11Raw = chan11Raw;
            return this;
        }

        /**
         * RC channel 12 value. A value of 0 or UINT16_MAX means to ignore this field. A value of 
         * UINT16_MAX-1 means to release this channel back to the RC radio. 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 2,
                extension = true,
                description = "RC channel 12 value. A value of 0 or UINT16_MAX means to ignore this field. A value of UINT16_MAX-1 means to release this channel back to the RC radio."
        )
        public final Builder chan12Raw(int chan12Raw) {
            this.chan12Raw = chan12Raw;
            return this;
        }

        /**
         * RC channel 13 value. A value of 0 or UINT16_MAX means to ignore this field. A value of 
         * UINT16_MAX-1 means to release this channel back to the RC radio. 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 2,
                extension = true,
                description = "RC channel 13 value. A value of 0 or UINT16_MAX means to ignore this field. A value of UINT16_MAX-1 means to release this channel back to the RC radio."
        )
        public final Builder chan13Raw(int chan13Raw) {
            this.chan13Raw = chan13Raw;
            return this;
        }

        /**
         * RC channel 14 value. A value of 0 or UINT16_MAX means to ignore this field. A value of 
         * UINT16_MAX-1 means to release this channel back to the RC radio. 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 2,
                extension = true,
                description = "RC channel 14 value. A value of 0 or UINT16_MAX means to ignore this field. A value of UINT16_MAX-1 means to release this channel back to the RC radio."
        )
        public final Builder chan14Raw(int chan14Raw) {
            this.chan14Raw = chan14Raw;
            return this;
        }

        /**
         * RC channel 15 value. A value of 0 or UINT16_MAX means to ignore this field. A value of 
         * UINT16_MAX-1 means to release this channel back to the RC radio. 
         */
        @MavlinkFieldInfo(
                position = 18,
                unitSize = 2,
                extension = true,
                description = "RC channel 15 value. A value of 0 or UINT16_MAX means to ignore this field. A value of UINT16_MAX-1 means to release this channel back to the RC radio."
        )
        public final Builder chan15Raw(int chan15Raw) {
            this.chan15Raw = chan15Raw;
            return this;
        }

        /**
         * RC channel 16 value. A value of 0 or UINT16_MAX means to ignore this field. A value of 
         * UINT16_MAX-1 means to release this channel back to the RC radio. 
         */
        @MavlinkFieldInfo(
                position = 19,
                unitSize = 2,
                extension = true,
                description = "RC channel 16 value. A value of 0 or UINT16_MAX means to ignore this field. A value of UINT16_MAX-1 means to release this channel back to the RC radio."
        )
        public final Builder chan16Raw(int chan16Raw) {
            this.chan16Raw = chan16Raw;
            return this;
        }

        /**
         * RC channel 17 value. A value of 0 or UINT16_MAX means to ignore this field. A value of 
         * UINT16_MAX-1 means to release this channel back to the RC radio. 
         */
        @MavlinkFieldInfo(
                position = 20,
                unitSize = 2,
                extension = true,
                description = "RC channel 17 value. A value of 0 or UINT16_MAX means to ignore this field. A value of UINT16_MAX-1 means to release this channel back to the RC radio."
        )
        public final Builder chan17Raw(int chan17Raw) {
            this.chan17Raw = chan17Raw;
            return this;
        }

        /**
         * RC channel 18 value. A value of 0 or UINT16_MAX means to ignore this field. A value of 
         * UINT16_MAX-1 means to release this channel back to the RC radio. 
         */
        @MavlinkFieldInfo(
                position = 21,
                unitSize = 2,
                extension = true,
                description = "RC channel 18 value. A value of 0 or UINT16_MAX means to ignore this field. A value of UINT16_MAX-1 means to release this channel back to the RC radio."
        )
        public final Builder chan18Raw(int chan18Raw) {
            this.chan18Raw = chan18Raw;
            return this;
        }

        public final RcChannelsOverride build() {
            return new RcChannelsOverride(targetSystem, targetComponent, chan1Raw, chan2Raw, chan3Raw, chan4Raw, chan5Raw, chan6Raw, chan7Raw, chan8Raw, chan9Raw, chan10Raw, chan11Raw, chan12Raw, chan13Raw, chan14Raw, chan15Raw, chan16Raw, chan17Raw, chan18Raw);
        }
    }
}
