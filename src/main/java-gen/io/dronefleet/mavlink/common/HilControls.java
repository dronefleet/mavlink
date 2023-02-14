package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

/**
 * Sent from autopilot to simulation. Hardware in the loop control outputs 
 */
@MavlinkMessageInfo(
        id = 91,
        crc = 63,
        description = "Sent from autopilot to simulation. Hardware in the loop control outputs"
)
public final class HilControls {
    private final BigInteger timeUsec;

    private final float rollAilerons;

    private final float pitchElevator;

    private final float yawRudder;

    private final float throttle;

    private final float aux1;

    private final float aux2;

    private final float aux3;

    private final float aux4;

    private final EnumValue<MavMode> mode;

    private final int navMode;

    private HilControls(BigInteger timeUsec, float rollAilerons, float pitchElevator,
            float yawRudder, float throttle, float aux1, float aux2, float aux3, float aux4,
            EnumValue<MavMode> mode, int navMode) {
        this.timeUsec = timeUsec;
        this.rollAilerons = rollAilerons;
        this.pitchElevator = pitchElevator;
        this.yawRudder = yawRudder;
        this.throttle = throttle;
        this.aux1 = aux1;
        this.aux2 = aux2;
        this.aux3 = aux3;
        this.aux4 = aux4;
        this.mode = mode;
        this.navMode = navMode;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
     * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Control output -1 .. 1 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Control output -1 .. 1"
    )
    public final float rollAilerons() {
        return this.rollAilerons;
    }

    /**
     * Control output -1 .. 1 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Control output -1 .. 1"
    )
    public final float pitchElevator() {
        return this.pitchElevator;
    }

    /**
     * Control output -1 .. 1 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Control output -1 .. 1"
    )
    public final float yawRudder() {
        return this.yawRudder;
    }

    /**
     * Throttle 0 .. 1 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Throttle 0 .. 1"
    )
    public final float throttle() {
        return this.throttle;
    }

    /**
     * Aux 1, -1 .. 1 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Aux 1, -1 .. 1"
    )
    public final float aux1() {
        return this.aux1;
    }

    /**
     * Aux 2, -1 .. 1 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Aux 2, -1 .. 1"
    )
    public final float aux2() {
        return this.aux2;
    }

    /**
     * Aux 3, -1 .. 1 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Aux 3, -1 .. 1"
    )
    public final float aux3() {
        return this.aux3;
    }

    /**
     * Aux 4, -1 .. 1 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Aux 4, -1 .. 1"
    )
    public final float aux4() {
        return this.aux4;
    }

    /**
     * System mode. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1,
            enumType = MavMode.class,
            description = "System mode."
    )
    public final EnumValue<MavMode> mode() {
        return this.mode;
    }

    /**
     * Navigation mode (MAV_NAV_MODE) 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 1,
            description = "Navigation mode (MAV_NAV_MODE)"
    )
    public final int navMode() {
        return this.navMode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        HilControls other = (HilControls)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(rollAilerons, other.rollAilerons)) return false;
        if (!Objects.deepEquals(pitchElevator, other.pitchElevator)) return false;
        if (!Objects.deepEquals(yawRudder, other.yawRudder)) return false;
        if (!Objects.deepEquals(throttle, other.throttle)) return false;
        if (!Objects.deepEquals(aux1, other.aux1)) return false;
        if (!Objects.deepEquals(aux2, other.aux2)) return false;
        if (!Objects.deepEquals(aux3, other.aux3)) return false;
        if (!Objects.deepEquals(aux4, other.aux4)) return false;
        if (!Objects.deepEquals(mode, other.mode)) return false;
        if (!Objects.deepEquals(navMode, other.navMode)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(rollAilerons);
        result = 31 * result + Objects.hashCode(pitchElevator);
        result = 31 * result + Objects.hashCode(yawRudder);
        result = 31 * result + Objects.hashCode(throttle);
        result = 31 * result + Objects.hashCode(aux1);
        result = 31 * result + Objects.hashCode(aux2);
        result = 31 * result + Objects.hashCode(aux3);
        result = 31 * result + Objects.hashCode(aux4);
        result = 31 * result + Objects.hashCode(mode);
        result = 31 * result + Objects.hashCode(navMode);
        return result;
    }

    @Override
    public String toString() {
        return "HilControls{timeUsec=" + timeUsec
                 + ", rollAilerons=" + rollAilerons
                 + ", pitchElevator=" + pitchElevator
                 + ", yawRudder=" + yawRudder
                 + ", throttle=" + throttle
                 + ", aux1=" + aux1
                 + ", aux2=" + aux2
                 + ", aux3=" + aux3
                 + ", aux4=" + aux4
                 + ", mode=" + mode
                 + ", navMode=" + navMode + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private float rollAilerons;

        private float pitchElevator;

        private float yawRudder;

        private float throttle;

        private float aux1;

        private float aux2;

        private float aux3;

        private float aux4;

        private EnumValue<MavMode> mode;

        private int navMode;

        /**
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Control output -1 .. 1 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Control output -1 .. 1"
        )
        public final Builder rollAilerons(float rollAilerons) {
            this.rollAilerons = rollAilerons;
            return this;
        }

        /**
         * Control output -1 .. 1 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Control output -1 .. 1"
        )
        public final Builder pitchElevator(float pitchElevator) {
            this.pitchElevator = pitchElevator;
            return this;
        }

        /**
         * Control output -1 .. 1 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Control output -1 .. 1"
        )
        public final Builder yawRudder(float yawRudder) {
            this.yawRudder = yawRudder;
            return this;
        }

        /**
         * Throttle 0 .. 1 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Throttle 0 .. 1"
        )
        public final Builder throttle(float throttle) {
            this.throttle = throttle;
            return this;
        }

        /**
         * Aux 1, -1 .. 1 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Aux 1, -1 .. 1"
        )
        public final Builder aux1(float aux1) {
            this.aux1 = aux1;
            return this;
        }

        /**
         * Aux 2, -1 .. 1 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Aux 2, -1 .. 1"
        )
        public final Builder aux2(float aux2) {
            this.aux2 = aux2;
            return this;
        }

        /**
         * Aux 3, -1 .. 1 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Aux 3, -1 .. 1"
        )
        public final Builder aux3(float aux3) {
            this.aux3 = aux3;
            return this;
        }

        /**
         * Aux 4, -1 .. 1 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Aux 4, -1 .. 1"
        )
        public final Builder aux4(float aux4) {
            this.aux4 = aux4;
            return this;
        }

        /**
         * System mode. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1,
                enumType = MavMode.class,
                description = "System mode."
        )
        public final Builder mode(EnumValue<MavMode> mode) {
            this.mode = mode;
            return this;
        }

        /**
         * System mode. 
         */
        public final Builder mode(MavMode entry) {
            return mode(EnumValue.of(entry));
        }

        /**
         * System mode. 
         */
        public final Builder mode(Enum... flags) {
            return mode(EnumValue.create(flags));
        }

        /**
         * System mode. 
         */
        public final Builder mode(Collection<Enum> flags) {
            return mode(EnumValue.create(flags));
        }

        /**
         * Navigation mode (MAV_NAV_MODE) 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 1,
                description = "Navigation mode (MAV_NAV_MODE)"
        )
        public final Builder navMode(int navMode) {
            this.navMode = navMode;
            return this;
        }

        public final HilControls build() {
            return new HilControls(timeUsec, rollAilerons, pitchElevator, yawRudder, throttle, aux1, aux2, aux3, aux4, mode, navMode);
        }
    }
}
