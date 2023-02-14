package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * Set the vehicle attitude and body angular rates. 
 */
@MavlinkMessageInfo(
        id = 140,
        crc = 181,
        description = "Set the vehicle attitude and body angular rates."
)
public final class ActuatorControlTarget {
    private final BigInteger timeUsec;

    private final int groupMlx;

    private final List<Float> controls;

    private ActuatorControlTarget(BigInteger timeUsec, int groupMlx, List<Float> controls) {
        this.timeUsec = timeUsec;
        this.groupMlx = groupMlx;
        this.controls = controls;
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
     * Actuator group. The "_mlx" indicates this is a multi-instance message and a MAVLink parser 
     * should use this field to difference between instances. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Actuator group. The \"_mlx\" indicates this is a multi-instance message and a MAVLink parser should use this field to difference between instances."
    )
    public final int groupMlx() {
        return this.groupMlx;
    }

    /**
     * Actuator controls. Normed to -1..+1 where 0 is neutral position. Throttle for single rotation 
     * direction motors is 0..1, negative range for reverse direction. Standard mapping for 
     * attitude controls (group 0): (index 0-7): roll, pitch, yaw, throttle, flaps, spoilers, 
     * airbrakes, landing gear. Load a pass-through mixer to repurpose them as generic outputs. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            arraySize = 8,
            description = "Actuator controls. Normed to -1..+1 where 0 is neutral position. Throttle for single rotation direction motors is 0..1, negative range for reverse direction. Standard mapping for attitude controls (group 0): (index 0-7): roll, pitch, yaw, throttle, flaps, spoilers, airbrakes, landing gear. Load a pass-through mixer to repurpose them as generic outputs."
    )
    public final List<Float> controls() {
        return this.controls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ActuatorControlTarget other = (ActuatorControlTarget)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(groupMlx, other.groupMlx)) return false;
        if (!Objects.deepEquals(controls, other.controls)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(groupMlx);
        result = 31 * result + Objects.hashCode(controls);
        return result;
    }

    @Override
    public String toString() {
        return "ActuatorControlTarget{timeUsec=" + timeUsec
                 + ", groupMlx=" + groupMlx
                 + ", controls=" + controls + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private int groupMlx;

        private List<Float> controls;

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
         * Actuator group. The "_mlx" indicates this is a multi-instance message and a MAVLink parser 
         * should use this field to difference between instances. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Actuator group. The \"_mlx\" indicates this is a multi-instance message and a MAVLink parser should use this field to difference between instances."
        )
        public final Builder groupMlx(int groupMlx) {
            this.groupMlx = groupMlx;
            return this;
        }

        /**
         * Actuator controls. Normed to -1..+1 where 0 is neutral position. Throttle for single rotation 
         * direction motors is 0..1, negative range for reverse direction. Standard mapping for 
         * attitude controls (group 0): (index 0-7): roll, pitch, yaw, throttle, flaps, spoilers, 
         * airbrakes, landing gear. Load a pass-through mixer to repurpose them as generic outputs. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                arraySize = 8,
                description = "Actuator controls. Normed to -1..+1 where 0 is neutral position. Throttle for single rotation direction motors is 0..1, negative range for reverse direction. Standard mapping for attitude controls (group 0): (index 0-7): roll, pitch, yaw, throttle, flaps, spoilers, airbrakes, landing gear. Load a pass-through mixer to repurpose them as generic outputs."
        )
        public final Builder controls(List<Float> controls) {
            this.controls = controls;
            return this;
        }

        public final ActuatorControlTarget build() {
            return new ActuatorControlTarget(timeUsec, groupMlx, controls);
        }
    }
}
