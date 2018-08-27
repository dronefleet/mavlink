package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * {@link io.dronefleet.mavlink.ardupilotmega.Rpm RPM} sensor output 
 */
@MavlinkMessageInfo(
        id = 226,
        crc = 207
)
public final class Rpm {
    private final float rpm1;

    private final float rpm2;

    private Rpm(float rpm1, float rpm2) {
        this.rpm1 = rpm1;
        this.rpm2 = rpm2;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * {@link io.dronefleet.mavlink.ardupilotmega.Rpm RPM} Sensor1 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final float rpm1() {
        return this.rpm1;
    }

    /**
     * {@link io.dronefleet.mavlink.ardupilotmega.Rpm RPM} Sensor2 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float rpm2() {
        return this.rpm2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Rpm other = (Rpm)o;
        if (!Objects.deepEquals(rpm1, other.rpm1)) return false;
        if (!Objects.deepEquals(rpm2, other.rpm2)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(rpm1);
        result = 31 * result + Objects.hashCode(rpm2);
        return result;
    }

    @Override
    public String toString() {
        return "Rpm{rpm1=" + rpm1
                 + ", rpm2=" + rpm2 + "}";
    }

    public static final class Builder {
        private float rpm1;

        private float rpm2;

        /**
         * {@link io.dronefleet.mavlink.ardupilotmega.Rpm RPM} Sensor1 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder rpm1(float rpm1) {
            this.rpm1 = rpm1;
            return this;
        }

        /**
         * {@link io.dronefleet.mavlink.ardupilotmega.Rpm RPM} Sensor2 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder rpm2(float rpm2) {
            this.rpm2 = rpm2;
            return this;
        }

        public final Rpm build() {
            return new Rpm(rpm1, rpm2);
        }
    }
}
