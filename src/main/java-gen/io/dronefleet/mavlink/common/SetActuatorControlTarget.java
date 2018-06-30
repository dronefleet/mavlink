package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.lang.Object;
import java.lang.Override;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * Set the vehicle attitude and body angular rates. 
 */
@MavlinkMessageInfo(
        id = 139,
        crc = 168
)
public final class SetActuatorControlTarget {
    private final BigInteger timeUsec;

    private final int groupMlx;

    private final int targetSystem;

    private final int targetComponent;

    private final List<Float> controls;

    private SetActuatorControlTarget(BigInteger timeUsec, int groupMlx, int targetSystem,
            int targetComponent, List<Float> controls) {
        this.timeUsec = timeUsec;
        this.groupMlx = groupMlx;
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
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
     * Timestamp (micros since boot or Unix epoch) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
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
            unitSize = 1
    )
    public final int groupMlx() {
        return this.groupMlx;
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Actuator controls. Normed to -1..+1 where 0 is neutral position. Throttle for single rotation 
     * direction motors is 0..1, negative range for reverse direction. Standard mapping for 
     * attitude controls (group 0): (index 0-7): roll, pitch, yaw, throttle, flaps, spoilers, 
     * airbrakes, landing gear. Load a pass-through mixer to repurpose them as generic outputs. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            arraySize = 8
    )
    public final List<Float> controls() {
        return this.controls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SetActuatorControlTarget other = (SetActuatorControlTarget)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(groupMlx, other.groupMlx)) return false;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(controls, other.controls)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(groupMlx);
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(controls);
        return result;
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private int groupMlx;

        private int targetSystem;

        private int targetComponent;

        private List<Float> controls;

        /**
         * Timestamp (micros since boot or Unix epoch) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8
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
                unitSize = 1
        )
        public final Builder groupMlx(int groupMlx) {
            this.groupMlx = groupMlx;
            return this;
        }

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 3,
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
                position = 4,
                unitSize = 1
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Actuator controls. Normed to -1..+1 where 0 is neutral position. Throttle for single rotation 
         * direction motors is 0..1, negative range for reverse direction. Standard mapping for 
         * attitude controls (group 0): (index 0-7): roll, pitch, yaw, throttle, flaps, spoilers, 
         * airbrakes, landing gear. Load a pass-through mixer to repurpose them as generic outputs. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                arraySize = 8
        )
        public final Builder controls(List<Float> controls) {
            this.controls = controls;
            return this;
        }

        public final SetActuatorControlTarget build() {
            return new SetActuatorControlTarget(timeUsec, groupMlx, targetSystem, targetComponent, controls);
        }
    }
}
